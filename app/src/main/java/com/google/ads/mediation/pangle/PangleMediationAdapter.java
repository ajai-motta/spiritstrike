package com.google.ads.mediation.pangle;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.api.init.BiddingTokenCallback;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.renderer.PangleAppOpenAd;
import com.google.ads.mediation.pangle.renderer.PangleBannerAd;
import com.google.ads.mediation.pangle.renderer.PangleInterstitialAd;
import com.google.ads.mediation.pangle.renderer.PangleNativeAd;
import com.google.ads.mediation.pangle.renderer.PangleRewardedAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class PangleMediationAdapter extends RtbAdapter {
    static final String ERROR_MESSAGE_MISSING_OR_INVALID_APP_ID = "Missing or invalid App ID.";
    public static final String TAG = "PangleMediationAdapter";
    private static int gdpr = -1;
    private PangleAppOpenAd appOpenAd;
    private PangleBannerAd bannerAd;
    private PangleInterstitialAd interstitialAd;
    private PangleNativeAd nativeAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;
    private PangleRewardedAd rewardedAd;

    public PangleMediationAdapter() {
        this.pangleInitializer = PangleInitializer.getInstance();
        this.pangleSdkWrapper = new PangleSdkWrapper();
        this.pangleFactory = new PangleFactory();
    }

    PangleMediationAdapter(PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(RtbSignalData rtbSignalData, final SignalCallbacks signalCallbacks) {
        if (PangleConstants.isChildUser()) {
            signalCallbacks.onFailure(PangleConstants.createChildUserError());
            return;
        }
        Bundle networkExtras = rtbSignalData.getNetworkExtras();
        if (networkExtras != null && networkExtras.containsKey("user_data")) {
            this.pangleSdkWrapper.setUserData(networkExtras.getString("user_data", ""));
        }
        PAGBiddingRequest pAGBiddingRequest = new PAGBiddingRequest();
        pAGBiddingRequest.setAdxId(PangleConstants.ADX_ID);
        this.pangleSdkWrapper.getBiddingToken(rtbSignalData.getContext(), pAGBiddingRequest, new BiddingTokenCallback() { // from class: com.google.ads.mediation.pangle.PangleMediationAdapter.1
            @Override // com.bytedance.sdk.openadsdk.api.init.BiddingTokenCallback
            public void onBiddingTokenCollected(String str) {
                signalCallbacks.onSuccess(str);
            }
        });
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (PangleConstants.isChildUser()) {
            initializationCompleteCallback.onInitializationFailed(PangleConstants.ERROR_MSG_CHILD_USER);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString(PangleConstants.APP_ID);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size <= 0) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, ERROR_MESSAGE_MISSING_OR_INVALID_APP_ID);
            Log.w(TAG, adErrorCreateAdapterError.toString());
            initializationCompleteCallback.onInitializationFailed(adErrorCreateAdapterError.toString());
        } else {
            String str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Found multiple app IDs in %s. Using %s to initialize Pangle SDK.", hashSet, str));
            }
            this.pangleInitializer.initialize(context, str, new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.PangleMediationAdapter.2
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    initializationCompleteCallback.onInitializationSucceeded();
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    initializationCompleteCallback.onInitializationFailed(adError.getMessage());
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        return getVersionInfo(BuildConfig.ADAPTER_VERSION);
    }

    VersionInfo getVersionInfo(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length >= 4) {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            int i3 = (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]);
            if (strArrSplit.length >= 5) {
                i3 = (i3 * 100) + Integer.parseInt(strArrSplit[4]);
            }
            return new VersionInfo(i, i2, i3);
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", str));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String sdkVersion = this.pangleSdkWrapper.getSdkVersion();
        String[] strArrSplit = sdkVersion.split("\\.");
        if (strArrSplit.length >= 3) {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            int i3 = Integer.parseInt(strArrSplit[2]);
            if (strArrSplit.length >= 4) {
                i3 = (i3 * 100) + Integer.parseInt(strArrSplit[3]);
            }
            return new VersionInfo(i, i2, i3);
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", sdkVersion));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadAppOpenAd(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback) {
        if (PangleConstants.isChildUser()) {
            mediationAdLoadCallback.onFailure(PangleConstants.createChildUserError());
            return;
        }
        PangleAppOpenAd pangleAppOpenAdCreatePangleAppOpenAd = this.pangleFactory.createPangleAppOpenAd(mediationAdLoadCallback, this.pangleInitializer, this.pangleSdkWrapper);
        this.appOpenAd = pangleAppOpenAdCreatePangleAppOpenAd;
        pangleAppOpenAdCreatePangleAppOpenAd.render(mediationAppOpenAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        if (PangleConstants.isChildUser()) {
            mediationAdLoadCallback.onFailure(PangleConstants.createChildUserError());
            return;
        }
        PangleBannerAd pangleBannerAdCreatePangleBannerAd = this.pangleFactory.createPangleBannerAd(mediationAdLoadCallback, this.pangleInitializer, this.pangleSdkWrapper);
        this.bannerAd = pangleBannerAdCreatePangleBannerAd;
        pangleBannerAdCreatePangleBannerAd.render(mediationBannerAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (PangleConstants.isChildUser()) {
            mediationAdLoadCallback.onFailure(PangleConstants.createChildUserError());
            return;
        }
        PangleInterstitialAd pangleInterstitialAdCreatePangleInterstitialAd = this.pangleFactory.createPangleInterstitialAd(mediationAdLoadCallback, this.pangleInitializer, this.pangleSdkWrapper);
        this.interstitialAd = pangleInterstitialAdCreatePangleInterstitialAd;
        pangleInterstitialAdCreatePangleInterstitialAd.render(mediationInterstitialAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        if (PangleConstants.isChildUser()) {
            mediationAdLoadCallback.onFailure(PangleConstants.createChildUserError());
            return;
        }
        PangleNativeAd pangleNativeAdCreatePangleNativeAd = this.pangleFactory.createPangleNativeAd(mediationAdLoadCallback, this.pangleInitializer, this.pangleSdkWrapper);
        this.nativeAd = pangleNativeAdCreatePangleNativeAd;
        pangleNativeAdCreatePangleNativeAd.render(mediationNativeAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (PangleConstants.isChildUser()) {
            mediationAdLoadCallback.onFailure(PangleConstants.createChildUserError());
            return;
        }
        PangleRewardedAd pangleRewardedAdCreatePangleRewardedAd = this.pangleFactory.createPangleRewardedAd(mediationAdLoadCallback, this.pangleInitializer, this.pangleSdkWrapper);
        this.rewardedAd = pangleRewardedAdCreatePangleRewardedAd;
        pangleRewardedAdCreatePangleRewardedAd.render(mediationRewardedAdConfiguration);
    }

    public static void setGDPRConsent(int i) {
        setGDPRConsent(i, new PangleSdkWrapper());
    }

    static void setGDPRConsent(int i, PangleSdkWrapper pangleSdkWrapper) {
        if (i != 1 && i != 0 && i != -1) {
            Log.w(TAG, "Invalid GDPR value. Pangle SDK only accepts -1, 0 or 1.");
            return;
        }
        if (pangleSdkWrapper.isInitSuccess() && !PangleConstants.isChildUser()) {
            pangleSdkWrapper.setGdprConsent(i);
        }
        gdpr = i;
    }

    public static int getGDPRConsent() {
        return gdpr;
    }

    public static void setPAConsent(int i) {
        setPAConsent(i, new PangleSdkWrapper());
    }

    static void setPAConsent(int i, PangleSdkWrapper pangleSdkWrapper) {
        if (i != 1 && i != 0) {
            Log.w(TAG, "Invalid PA value. Pangle SDK only accepts 0 or 1.");
        } else {
            pangleSdkWrapper.setPAConsent(i);
        }
    }

    public static int getPAConsent() {
        return PAGConfig.getPAConsent();
    }
}
