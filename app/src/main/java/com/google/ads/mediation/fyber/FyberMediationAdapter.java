package com.google.ads.mediation.fyber;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.BidTokenProvider;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerAdapter;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerAdapter;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class FyberMediationAdapter extends RtbAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    static final String KEY_APP_ID = "applicationId";
    public static final String KEY_MUTE_VIDEO = "muteVideo";
    static final String KEY_SPOT_ID = "spotId";
    protected static final InneractiveMediationName MEDIATOR_NAME = InneractiveMediationName.ADMOB;
    static final String TAG = "FyberMediationAdapter";
    private DTExchangeBannerAd bannerRtbAd;
    private InneractiveAdSpot bannerSpot;
    private ViewGroup bannerWrapperView;
    private WeakReference<Activity> interstitialActivityRef;
    private DTExchangeInterstitialAd interstitialRtbAd;
    private InneractiveAdSpot interstitialSpot;
    private MediationBannerListener mediationBannerListener;
    private MediationInterstitialListener mediationInterstitialListener;
    private AdSize requestedAdSize;
    private FyberRewardedVideoRenderer rewardedRenderer;

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        String string = mediationRewardedAdConfiguration.getServerParameters().getString(KEY_APP_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "App ID is null or empty.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(TAG, adError.getMessage());
            mediationAdLoadCallback.onFailure(adError);
        } else {
            InneractiveAdManager.setMediationName(MEDIATOR_NAME);
            InneractiveAdManager.setMediationVersion(MobileAds.getVersion().toString());
            InneractiveAdManager.initialize(mediationRewardedAdConfiguration.getContext(), string, new OnFyberMarketplaceInitializedListener() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.1
                @Override // com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener
                public void onFyberMarketplaceInitialized(OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus) {
                    if (fyberInitStatus != OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
                        AdError adError2 = DTExchangeErrorCodes.getAdError(fyberInitStatus);
                        Log.w(FyberMediationAdapter.TAG, adError2.getMessage());
                        mediationAdLoadCallback.onFailure(adError2);
                    } else {
                        FyberMediationAdapter.this.rewardedRenderer = new FyberRewardedVideoRenderer(mediationAdLoadCallback);
                        FyberMediationAdapter.this.rewardedRenderer.loadWaterfallAd(mediationRewardedAdConfiguration);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (FyberSdkWrapper.getDelegate().isInitialized()) {
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString(KEY_APP_ID);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        if (hashSet.isEmpty()) {
            AdError adError = new AdError(101, "DT Exchange SDK requires an appId to be configured on the AdMob UI.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(TAG, adError.getMessage());
            initializationCompleteCallback.onInitializationFailed(adError.getMessage());
        } else {
            String str = (String) hashSet.iterator().next();
            if (hashSet.size() > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the DT Exchange SDK.", KEY_APP_ID, hashSet, str));
            }
            InneractiveAdManager.initialize(context, str, new OnFyberMarketplaceInitializedListener() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.2
                @Override // com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener
                public void onFyberMarketplaceInitialized(OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus) {
                    if (fyberInitStatus != OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
                        AdError adError2 = DTExchangeErrorCodes.getAdError(fyberInitStatus);
                        Log.w(FyberMediationAdapter.TAG, adError2.getMessage());
                        initializationCompleteCallback.onInitializationFailed(adError2.getMessage());
                        return;
                    }
                    initializationCompleteCallback.onInitializationSucceeded();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        String bidderToken = BidTokenProvider.getBidderToken();
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        signalCallbacks.onSuccess(bidderToken);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        String adapterVersion = FyberAdapterUtils.getAdapterVersion();
        String[] strArrSplit = adapterVersion.split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", adapterVersion));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String sdkVersion = FyberAdapterUtils.getSdkVersion();
        String[] strArrSplit = sdkVersion.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", sdkVersion));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(final Context context, MediationBannerListener mediationBannerListener, final Bundle bundle, final AdSize adSize, MediationAdRequest mediationAdRequest, final Bundle bundle2) {
        this.mediationBannerListener = mediationBannerListener;
        String string = bundle.getString(KEY_APP_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "App ID is null or empty.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(TAG, adError.getMessage());
            this.mediationBannerListener.onAdFailedToLoad(this, adError);
        } else {
            InneractiveAdManager.setMediationName(MEDIATOR_NAME);
            InneractiveAdManager.setMediationVersion(MobileAds.getVersion().toString());
            InneractiveAdManager.initialize(context, string, new OnFyberMarketplaceInitializedListener() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.3
                @Override // com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener
                public void onFyberMarketplaceInitialized(OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus) {
                    if (fyberInitStatus != OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
                        AdError adError2 = DTExchangeErrorCodes.getAdError(fyberInitStatus);
                        Log.w(FyberMediationAdapter.TAG, adError2.getMessage());
                        FyberMediationAdapter.this.mediationBannerListener.onAdFailedToLoad(FyberMediationAdapter.this, adError2);
                        return;
                    }
                    String string2 = bundle.getString("spotId");
                    if (TextUtils.isEmpty(string2)) {
                        AdError adError3 = new AdError(101, "Cannot render banner ad. Please define a valid spot id on the AdMob UI.", DTExchangeErrorCodes.ERROR_DOMAIN);
                        Log.w(FyberMediationAdapter.TAG, adError3.getMessage());
                        FyberMediationAdapter.this.mediationBannerListener.onAdFailedToLoad(FyberMediationAdapter.this, adError3);
                        return;
                    }
                    FyberMediationAdapter.this.bannerSpot = InneractiveAdSpotManager.get().createSpot();
                    FyberMediationAdapter.this.bannerSpot.addUnitController(new InneractiveAdViewUnitController());
                    FyberMediationAdapter.this.bannerWrapperView = new RelativeLayout(context);
                    FyberMediationAdapter.this.bannerSpot.setRequestListener(FyberMediationAdapter.this.createFyberBannerAdListener());
                    FyberMediationAdapter.this.requestedAdSize = adSize;
                    FyberAdapterUtils.updateFyberExtraParams(bundle2);
                    FyberMediationAdapter.this.bannerSpot.requestAd(new InneractiveAdRequest(string2));
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.bannerWrapperView;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        InneractiveAdSpot inneractiveAdSpot = this.bannerSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
            this.bannerSpot = null;
        }
        InneractiveAdSpot inneractiveAdSpot2 = this.interstitialSpot;
        if (inneractiveAdSpot2 != null) {
            inneractiveAdSpot2.destroy();
            this.interstitialSpot = null;
        }
        WeakReference<Activity> weakReference = this.interstitialActivityRef;
        if (weakReference != null) {
            weakReference.clear();
            this.interstitialActivityRef = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InneractiveAdSpot.RequestListener createFyberBannerAdListener() {
        return new InneractiveAdSpot.RequestListener() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.4
            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot) {
                if (!(FyberMediationAdapter.this.bannerSpot.getSelectedUnitController() instanceof InneractiveAdViewUnitController)) {
                    AdError adError = new AdError(105, String.format("Unexpected controller type. Expected: %s. Actual: %s", InneractiveUnitController.class.getName(), FyberMediationAdapter.this.bannerSpot.getSelectedUnitController().getClass().getName()), DTExchangeErrorCodes.ERROR_DOMAIN);
                    Log.w(FyberMediationAdapter.TAG, adError.getMessage());
                    FyberMediationAdapter.this.mediationBannerListener.onAdFailedToLoad(FyberMediationAdapter.this, adError);
                    FyberMediationAdapter.this.bannerSpot.destroy();
                }
                InneractiveAdViewUnitController inneractiveAdViewUnitController = (InneractiveAdViewUnitController) FyberMediationAdapter.this.bannerSpot.getSelectedUnitController();
                inneractiveAdViewUnitController.setEventsListener(FyberMediationAdapter.this.createFyberAdViewListener());
                inneractiveAdViewUnitController.bindView(FyberMediationAdapter.this.bannerWrapperView);
                Context context = FyberMediationAdapter.this.bannerWrapperView.getContext();
                float f = context.getResources().getDisplayMetrics().density;
                int iRound = Math.round(inneractiveAdViewUnitController.getAdContentWidth() / f);
                int iRound2 = Math.round(inneractiveAdViewUnitController.getAdContentHeight() / f);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new AdSize(iRound, iRound2));
                if (MediationUtils.findClosestSize(context, FyberMediationAdapter.this.requestedAdSize, arrayList) == null) {
                    AdError adError2 = new AdError(103, String.format("The loaded ad size did not match the requested ad size. Requested ad size: %dx%d. Loaded ad size: %dx%d.", Integer.valueOf(Math.round(FyberMediationAdapter.this.requestedAdSize.getWidthInPixels(context) / f)), Integer.valueOf(Math.round(FyberMediationAdapter.this.requestedAdSize.getHeightInPixels(context) / f)), Integer.valueOf(iRound), Integer.valueOf(iRound2)), DTExchangeErrorCodes.ERROR_DOMAIN);
                    Log.w(FyberMediationAdapter.TAG, adError2.getMessage());
                    FyberMediationAdapter.this.mediationBannerListener.onAdFailedToLoad(FyberMediationAdapter.this, adError2);
                    return;
                }
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                FyberMediationAdapter.this.mediationBannerListener.onAdLoaded(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
                AdError adError = DTExchangeErrorCodes.getAdError(inneractiveErrorCode);
                Log.w(FyberMediationAdapter.TAG, adError.getMessage());
                FyberMediationAdapter.this.mediationBannerListener.onAdFailedToLoad(FyberMediationAdapter.this, adError);
                if (inneractiveAdSpot != null) {
                    inneractiveAdSpot.destroy();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InneractiveAdViewEventsListener createFyberAdViewListener() {
        return new InneractiveAdViewEventsListenerAdapter() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.5
            @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, "Impression");
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                FyberMediationAdapter.this.mediationBannerListener.onAdClicked(FyberMediationAdapter.this);
                FyberMediationAdapter.this.mediationBannerListener.onAdOpened(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
                FyberMediationAdapter.this.mediationBannerListener.onAdClosed(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
                FyberMediationAdapter.this.mediationBannerListener.onAdLeftApplication(FyberMediationAdapter.this);
            }
        };
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(final Context context, MediationInterstitialListener mediationInterstitialListener, final Bundle bundle, MediationAdRequest mediationAdRequest, final Bundle bundle2) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        this.mediationInterstitialListener = mediationInterstitialListener;
        String string = bundle.getString(KEY_APP_ID);
        AdError adError = new AdError(101, "App ID is null or empty.", DTExchangeErrorCodes.ERROR_DOMAIN);
        if (TextUtils.isEmpty(string)) {
            Log.w(TAG, adError.getMessage());
            this.mediationInterstitialListener.onAdFailedToLoad(this, adError);
        } else {
            InneractiveAdManager.setMediationName(MEDIATOR_NAME);
            InneractiveAdManager.setMediationVersion(MobileAds.getVersion().toString());
            InneractiveAdManager.initialize(context, string, new OnFyberMarketplaceInitializedListener() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.6
                @Override // com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener
                public void onFyberMarketplaceInitialized(OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus) {
                    if (fyberInitStatus != OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
                        AdError adError2 = DTExchangeErrorCodes.getAdError(fyberInitStatus);
                        Log.w(FyberMediationAdapter.TAG, adError2.getMessage());
                        FyberMediationAdapter.this.mediationInterstitialListener.onAdFailedToLoad(FyberMediationAdapter.this, adError2);
                        return;
                    }
                    String string2 = bundle.getString("spotId");
                    if (TextUtils.isEmpty(string2)) {
                        AdError adError3 = new AdError(101, "Cannot render interstitial ad. Please define a valid spot id on the AdMob UI.", DTExchangeErrorCodes.ERROR_DOMAIN);
                        Log.w(FyberMediationAdapter.TAG, adError3.getMessage());
                        FyberMediationAdapter.this.mediationInterstitialListener.onAdFailedToLoad(FyberMediationAdapter.this, adError3);
                        return;
                    }
                    if (!(context instanceof Activity)) {
                        AdError adError4 = new AdError(107, "Cannot request an interstitial ad without an activity context.", DTExchangeErrorCodes.ERROR_DOMAIN);
                        Log.w(FyberMediationAdapter.TAG, adError4.getMessage());
                        if (FyberMediationAdapter.this.mediationInterstitialListener != null) {
                            FyberMediationAdapter.this.mediationInterstitialListener.onAdFailedToLoad(FyberMediationAdapter.this, adError4);
                            return;
                        }
                        return;
                    }
                    FyberMediationAdapter.this.interstitialActivityRef = new WeakReference((Activity) context);
                    FyberMediationAdapter.this.interstitialSpot = InneractiveAdSpotManager.get().createSpot();
                    FyberMediationAdapter.this.interstitialSpot.addUnitController(new InneractiveFullscreenUnitController());
                    FyberMediationAdapter.this.interstitialSpot.setRequestListener(FyberMediationAdapter.this.createFyberInterstitialAdListener());
                    FyberAdapterUtils.updateFyberExtraParams(bundle2);
                    FyberMediationAdapter.this.interstitialSpot.requestAd(new InneractiveAdRequest(string2));
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        WeakReference<Activity> weakReference = this.interstitialActivityRef;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity == null) {
            Log.w(TAG, "showInterstitial called, but activity reference was lost.");
            this.mediationInterstitialListener.onAdOpened(this);
            this.mediationInterstitialListener.onAdClosed(this);
        } else {
            if (!(this.interstitialSpot.getSelectedUnitController() instanceof InneractiveFullscreenUnitController)) {
                Log.w(TAG, "showInterstitial called, but wrong spot has been used (should not happen).");
                this.mediationInterstitialListener.onAdOpened(this);
                this.mediationInterstitialListener.onAdClosed(this);
                return;
            }
            InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) this.interstitialSpot.getSelectedUnitController();
            if (!this.interstitialSpot.isReady()) {
                Log.w(TAG, "showInterstitial called, but Ad has expired.");
                this.mediationInterstitialListener.onAdOpened(this);
                this.mediationInterstitialListener.onAdClosed(this);
                return;
            }
            inneractiveFullscreenUnitController.show(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InneractiveAdSpot.RequestListener createFyberInterstitialAdListener() {
        return new InneractiveAdSpot.RequestListener() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.7
            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot) {
                if (!(FyberMediationAdapter.this.interstitialSpot.getSelectedUnitController() instanceof InneractiveFullscreenUnitController)) {
                    AdError adError = new AdError(105, String.format("Unexpected controller type. Expected: %s. Actual: %s", InneractiveUnitController.class.getName(), FyberMediationAdapter.this.bannerSpot.getSelectedUnitController().getClass().getName()), DTExchangeErrorCodes.ERROR_DOMAIN);
                    Log.w(FyberMediationAdapter.TAG, adError.getMessage());
                    FyberMediationAdapter.this.mediationInterstitialListener.onAdFailedToLoad(FyberMediationAdapter.this, adError);
                    FyberMediationAdapter.this.interstitialSpot.destroy();
                }
                ((InneractiveFullscreenUnitController) FyberMediationAdapter.this.interstitialSpot.getSelectedUnitController()).setEventsListener(FyberMediationAdapter.this.createFyberInterstitialListener());
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                FyberMediationAdapter.this.mediationInterstitialListener.onAdLoaded(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
                AdError adError = DTExchangeErrorCodes.getAdError(inneractiveErrorCode);
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + adError.getCode() + " (" + adError.getMessage() + ")");
                Log.w(FyberMediationAdapter.TAG, adError.getMessage());
                FyberMediationAdapter.this.mediationInterstitialListener.onAdFailedToLoad(FyberMediationAdapter.this, adError);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InneractiveFullscreenAdEventsListener createFyberInterstitialListener() {
        return new InneractiveFullscreenAdEventsListenerAdapter() { // from class: com.google.ads.mediation.fyber.FyberMediationAdapter.8
            @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                FyberMediationAdapter.this.mediationInterstitialListener.onAdOpened(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                FyberMediationAdapter.this.mediationInterstitialListener.onAdClicked(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
            public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot) {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                FyberMediationAdapter.this.mediationInterstitialListener.onAdClosed(FyberMediationAdapter.this);
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerAdapter, com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
            public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
                FyberMediationAdapter.this.mediationInterstitialListener.onAdLeftApplication(FyberMediationAdapter.this);
            }
        };
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        DTExchangeBannerAd dTExchangeBannerAd = new DTExchangeBannerAd(mediationAdLoadCallback);
        this.bannerRtbAd = dTExchangeBannerAd;
        dTExchangeBannerAd.loadAd(mediationBannerAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        DTExchangeInterstitialAd dTExchangeInterstitialAd = new DTExchangeInterstitialAd(mediationAdLoadCallback);
        this.interstitialRtbAd = dTExchangeInterstitialAd;
        dTExchangeInterstitialAd.loadAd(mediationInterstitialAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.rewardedRenderer = new FyberRewardedVideoRenderer(mediationAdLoadCallback);
        InneractiveAdManager.setMediationName(MEDIATOR_NAME);
        InneractiveAdManager.setMediationVersion(MobileAds.getVersion().toString());
        this.rewardedRenderer.loadRtbAd(mediationRewardedAdConfiguration);
    }
}
