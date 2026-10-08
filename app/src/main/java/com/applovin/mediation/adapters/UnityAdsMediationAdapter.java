package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import androidx.compose.animation.core.AnimationConstants;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.unityads.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.ads.AdFormat;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class UnityAdsMediationAdapter extends MediationAdapterBase implements MaxSignalProvider, MaxInterstitialAdapter, MaxRewardedAdapter, MaxAdViewAdapter {
    private static MaxAdapter.InitializationStatus initializationStatus;
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private BannerView bannerView;
    private String biddingAdId;

    public UnityAdsMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Context context = getContext(activity);
        updatePrivacyConsent(maxAdapterInitializationParameters, context);
        if (initialized.compareAndSet(false, true)) {
            String string = maxAdapterInitializationParameters.getServerParameters().getString("game_id", null);
            log("Initializing UnityAds SDK with game id: " + string + "...");
            initializationStatus = MaxAdapter.InitializationStatus.INITIALIZING;
            MediationMetaData mediationMetaData = new MediationMetaData(context);
            mediationMetaData.setName("MAX");
            mediationMetaData.setVersion(AppLovinSdk.VERSION);
            mediationMetaData.set("adapter_version", getAdapterVersion());
            mediationMetaData.commit();
            UnityAds.setDebugMode(maxAdapterInitializationParameters.isTesting());
            UnityAds.initialize(context, string, maxAdapterInitializationParameters.isTesting(), new IUnityAdsInitializationListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() {
                    UnityAdsMediationAdapter.this.log("UnityAds SDK initialized");
                    MaxAdapter.InitializationStatus unused = UnityAdsMediationAdapter.initializationStatus = MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS;
                    onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS, null);
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    UnityAdsMediationAdapter.this.log("UnityAds SDK failed to initialize with error: " + str);
                    MaxAdapter.InitializationStatus unused = UnityAdsMediationAdapter.initializationStatus = MaxAdapter.InitializationStatus.INITIALIZED_FAILURE;
                    onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE, str);
                }
            });
            return;
        }
        onCompletionListener.onCompletion(initializationStatus, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return UnityAds.getVersion();
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        BannerView bannerView = this.bannerView;
        if (bannerView != null) {
            bannerView.destroy();
            this.bannerView = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxSignalProvider
    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, final MaxSignalCollectionListener maxSignalCollectionListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        log("Collecting signal...");
        updatePrivacyConsent(maxAdapterSignalCollectionParameters, getContext(activity));
        UnityAds.getToken(new TokenConfiguration(toUnityAdFormat(maxAdapterSignalCollectionParameters)), new IUnityAdsTokenListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter$$ExternalSyntheticLambda0
            @Override // com.unity3d.ads.IUnityAdsTokenListener
            public final void onUnityAdsTokenReady(String str) {
                this.f$0.m4489x69a55f(maxSignalCollectionListener, str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$collectSignal$0$com-applovin-mediation-adapters-UnityAdsMediationAdapter, reason: not valid java name */
    /* synthetic */ void m4489x69a55f(MaxSignalCollectionListener maxSignalCollectionListener, String str) {
        log("Collected signal");
        maxSignalCollectionListener.onSignalCollected(str);
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        StringBuilder sb = new StringBuilder("Loading ");
        sb.append(AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "");
        sb.append("interstitial ad for placement \"");
        sb.append(thirdPartyAdPlacementId);
        sb.append("\"...");
        log(sb.toString());
        updatePrivacyConsent(maxAdapterResponseParameters, getContext(activity));
        this.biddingAdId = UUID.randomUUID().toString();
        UnityAds.load(thirdPartyAdPlacementId, createAdLoadOptions(maxAdapterResponseParameters), new IUnityAdsLoadListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter.2
            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsAdLoaded(String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                UnityAdsMediationAdapter.this.log("Interstitial placement \"" + str + "\" loaded");
                maxInterstitialAdapterListener.onInterstitialAdLoaded();
            }

            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure(" + str2 + ")");
                UnityAdsMediationAdapter.this.log("Interstitial placement \"" + str + "\" failed to load with error: " + unityAdsLoadError + ": " + str2);
                maxInterstitialAdapterListener.onInterstitialAdLoadFailed(UnityAdsMediationAdapter.toMaxError(unityAdsLoadError, str2));
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing interstitial ad for placement \"" + thirdPartyAdPlacementId + "\"...");
        UnityAds.show(activity, thirdPartyAdPlacementId, createAdShowOptions(), new IUnityAdsShowListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter.3
            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
                UnityAdsMediationAdapter.this.log("Interstitial placement \"" + str + "\" failed to display with error: " + unityAdsShowError + ": " + str2);
                maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(new MaxAdapterError(MaxAdapterError.AD_DISPLAY_FAILED, unityAdsShowError.ordinal(), str2));
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowStart(String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                UnityAdsMediationAdapter.this.log("Interstitial placement \"" + str + "\" displayed");
                maxInterstitialAdapterListener.onInterstitialAdDisplayed();
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowClick(String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                UnityAdsMediationAdapter.this.log("Interstitial placement \"" + str + "\" clicked");
                maxInterstitialAdapterListener.onInterstitialAdClicked();
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                UnityAdsMediationAdapter.this.log("Interstitial placement \"" + str + "\" hidden with completion state: " + unityAdsShowCompletionState);
                maxInterstitialAdapterListener.onInterstitialAdHidden();
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        StringBuilder sb = new StringBuilder("Loading ");
        sb.append(AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "");
        sb.append("rewarded ad for placement \"");
        sb.append(thirdPartyAdPlacementId);
        sb.append("\"...");
        log(sb.toString());
        updatePrivacyConsent(maxAdapterResponseParameters, getContext(activity));
        this.biddingAdId = UUID.randomUUID().toString();
        UnityAds.load(thirdPartyAdPlacementId, createAdLoadOptions(maxAdapterResponseParameters), new IUnityAdsLoadListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter.4
            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsAdLoaded(String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                UnityAdsMediationAdapter.this.log("Rewarded ad placement \"" + str + "\" loaded");
                maxRewardedAdapterListener.onRewardedAdLoaded();
            }

            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, "Failure(" + str2 + ")");
                UnityAdsMediationAdapter.this.log("Rewarded ad placement \"" + str + "\" failed to load with error: " + unityAdsLoadError + ": " + str2);
                maxRewardedAdapterListener.onRewardedAdLoadFailed(UnityAdsMediationAdapter.toMaxError(unityAdsLoadError, str2));
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        log("Showing rewarded ad for placement \"" + thirdPartyAdPlacementId + "\"...");
        configureReward(maxAdapterResponseParameters);
        UnityAds.show(activity, thirdPartyAdPlacementId, createAdShowOptions(), new IUnityAdsShowListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter.5
            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
                UnityAdsMediationAdapter.this.log("Rewarded ad placement \"" + str + "\" failed to display with error: " + unityAdsShowError + ": " + str2);
                maxRewardedAdapterListener.onRewardedAdDisplayFailed(new MaxAdapterError(MaxAdapterError.AD_DISPLAY_FAILED, unityAdsShowError.ordinal(), str2));
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowStart(String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, "Impression");
                UnityAdsMediationAdapter.this.log("Rewarded ad placement \"" + str + "\" displayed");
                maxRewardedAdapterListener.onRewardedAdDisplayed();
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowClick(String str) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                UnityAdsMediationAdapter.this.log("Rewarded ad placement \"" + str + "\" clicked");
                maxRewardedAdapterListener.onRewardedAdClicked();
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
                UnityAdsMediationAdapter.this.log("Rewarded ad placement \"" + str + "\" hidden with completion state: " + unityAdsShowCompletionState);
                if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED || UnityAdsMediationAdapter.this.shouldAlwaysRewardUser()) {
                    ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    maxRewardedAdapterListener.onUserRewarded(UnityAdsMediationAdapter.this.getReward());
                }
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                maxRewardedAdapterListener.onRewardedAdHidden();
            }
        });
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        StringBuilder sb = new StringBuilder("Loading ");
        sb.append(AppLovinSdkUtils.isValidString(maxAdapterResponseParameters.getBidResponse()) ? "bidding " : "");
        sb.append(maxAdFormat.getLabel());
        sb.append(" ad for placement \"");
        sb.append(thirdPartyAdPlacementId);
        sb.append("\"...");
        log(sb.toString());
        if (activity == null) {
            log(maxAdFormat.getLabel() + " ad placement \"" + thirdPartyAdPlacementId + "\" load failed: Activity is null");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.MISSING_ACTIVITY);
            return;
        }
        updatePrivacyConsent(maxAdapterResponseParameters, getContext(activity));
        this.biddingAdId = UUID.randomUUID().toString();
        BannerView bannerView = new BannerView(activity, thirdPartyAdPlacementId, toUnityBannerSize(maxAdFormat));
        this.bannerView = bannerView;
        bannerView.setListener(new BannerView.IListener() { // from class: com.applovin.mediation.adapters.UnityAdsMediationAdapter.6
            @Override // com.unity3d.services.banners.BannerView.IListener
            public void onBannerLoaded(BannerView bannerView2) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                UnityAdsMediationAdapter.this.log(maxAdFormat.getLabel() + " ad placement \"" + thirdPartyAdPlacementId + "\" loaded");
                maxAdViewAdapterListener.onAdViewAdLoaded(bannerView2);
            }

            @Override // com.unity3d.services.banners.BannerView.IListener
            public void onBannerFailedToLoad(BannerView bannerView2, BannerErrorInfo bannerErrorInfo) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_BANNER, "Failure(" + bannerErrorInfo.errorMessage + ")");
                UnityAdsMediationAdapter.this.log(maxAdFormat.getLabel() + " ad placement \"" + thirdPartyAdPlacementId + "\" failed to load");
                maxAdViewAdapterListener.onAdViewAdLoadFailed(UnityAdsMediationAdapter.toMaxError(bannerErrorInfo));
            }

            @Override // com.unity3d.services.banners.BannerView.IListener
            public void onBannerShown(BannerView bannerView2) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_BANNER, "Impression");
                UnityAdsMediationAdapter.this.log(maxAdFormat.getLabel() + " ad placement \"" + thirdPartyAdPlacementId + "\" shown");
                maxAdViewAdapterListener.onAdViewAdDisplayed();
            }

            @Override // com.unity3d.services.banners.BannerView.IListener
            public void onBannerClick(BannerView bannerView2) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                UnityAdsMediationAdapter.this.log(maxAdFormat.getLabel() + " ad placement \"" + thirdPartyAdPlacementId + "\" clicked");
                maxAdViewAdapterListener.onAdViewAdClicked();
            }

            @Override // com.unity3d.services.banners.BannerView.IListener
            public void onBannerLeftApplication(BannerView bannerView2) {
                UnityAdsMediationAdapter.this.log(maxAdFormat.getLabel() + " ad placement \"" + thirdPartyAdPlacementId + "\" left application");
            }
        });
        this.bannerView.load(createAdLoadOptions(maxAdapterResponseParameters));
    }

    private UnityAdsLoadOptions createAdLoadOptions(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String bidResponse = maxAdapterResponseParameters.getBidResponse();
        if (AppLovinSdkUtils.isValidString(bidResponse)) {
            unityAdsLoadOptions.setAdMarkup(bidResponse);
        }
        if (AppLovinSdkUtils.isValidString(this.biddingAdId)) {
            unityAdsLoadOptions.setObjectId(this.biddingAdId);
        }
        return unityAdsLoadOptions;
    }

    private UnityAdsShowOptions createAdShowOptions() {
        UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
        if (AppLovinSdkUtils.isValidString(this.biddingAdId)) {
            unityAdsShowOptions.setObjectId(this.biddingAdId);
        }
        return unityAdsShowOptions;
    }

    private AdFormat toUnityAdFormat(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters) {
        MaxAdFormat adFormat = maxAdapterSignalCollectionParameters.getAdFormat();
        if (adFormat.isAdViewAd()) {
            return AdFormat.BANNER;
        }
        if (adFormat == MaxAdFormat.INTERSTITIAL) {
            return AdFormat.INTERSTITIAL;
        }
        if (adFormat == MaxAdFormat.REWARDED) {
            return AdFormat.REWARDED;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + adFormat);
    }

    private UnityBannerSize toUnityBannerSize(MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.BANNER) {
            return new UnityBannerSize(320, 50);
        }
        if (maxAdFormat == MaxAdFormat.LEADER) {
            return new UnityBannerSize(728, 90);
        }
        if (maxAdFormat == MaxAdFormat.MREC) {
            return new UnityBannerSize(AnimationConstants.DefaultDurationMillis, 250);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(BannerErrorInfo bannerErrorInfo) {
        MaxAdapterError maxAdapterError;
        if (bannerErrorInfo.errorCode == BannerErrorCode.NO_FILL) {
            maxAdapterError = MaxAdapterError.NO_FILL;
        } else if (bannerErrorInfo.errorCode == BannerErrorCode.NATIVE_ERROR) {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        } else if (bannerErrorInfo.errorCode == BannerErrorCode.WEBVIEW_ERROR) {
            maxAdapterError = MaxAdapterError.WEBVIEW_ERROR;
        } else {
            maxAdapterError = MaxAdapterError.UNSPECIFIED;
        }
        return new MaxAdapterError(maxAdapterError, bannerErrorInfo.errorCode.ordinal(), bannerErrorInfo.errorMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MaxAdapterError toMaxError(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        int i = AnonymousClass7.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[unityAdsLoadError.ordinal()];
        if (i == 1) {
            maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
        } else if (i == 2) {
            maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
        } else if (i == 3) {
            maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
        } else if (i == 4) {
            maxAdapterError = MaxAdapterError.NO_FILL;
        } else if (i == 5) {
            maxAdapterError = MaxAdapterError.TIMEOUT;
        }
        return new MaxAdapterError(maxAdapterError, unityAdsLoadError.ordinal(), str);
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.UnityAdsMediationAdapter$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError = iArr;
            try {
                iArr[UnityAds.UnityAdsShowError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.NOT_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.VIDEO_PLAYER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.NO_CONNECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.ALREADY_SHOWING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.INTERNAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[UnityAds.UnityAdsLoadError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = iArr2;
            try {
                iArr2[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static MaxAdapterError toMaxError(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        MaxAdapterError maxAdapterError = MaxAdapterError.UNSPECIFIED;
        switch (AnonymousClass7.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[unityAdsShowError.ordinal()]) {
            case 1:
                maxAdapterError = MaxAdapterError.NOT_INITIALIZED;
                break;
            case 2:
                maxAdapterError = MaxAdapterError.AD_NOT_READY;
                break;
            case 3:
                maxAdapterError = MaxAdapterError.WEBVIEW_ERROR;
                break;
            case 4:
                maxAdapterError = MaxAdapterError.INVALID_CONFIGURATION;
                break;
            case 5:
                maxAdapterError = MaxAdapterError.NO_CONNECTION;
                break;
            case 6:
                maxAdapterError = MaxAdapterError.INVALID_LOAD_STATE;
                break;
            case 7:
                maxAdapterError = MaxAdapterError.INTERNAL_ERROR;
                break;
        }
        return new MaxAdapterError(maxAdapterError, unityAdsShowError.ordinal(), str);
    }

    private void updatePrivacyConsent(MaxAdapterParameters maxAdapterParameters, Context context) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MetaData metaData = new MetaData(context);
        Boolean boolHasUserConsent = maxAdapterParameters.hasUserConsent();
        if (boolHasUserConsent != null) {
            metaData.set("gdpr.consent", boolHasUserConsent);
            metaData.commit();
        }
        if (maxAdapterParameters.isDoNotSell() != null) {
            metaData.set("privacy.consent", Boolean.valueOf(!r3.booleanValue()));
            metaData.commit();
        }
        metaData.set("privacy.mode", "mixed");
        metaData.commit();
    }

    private Context getContext(Activity activity) {
        return activity != null ? activity.getApplicationContext() : getApplicationContext();
    }
}
