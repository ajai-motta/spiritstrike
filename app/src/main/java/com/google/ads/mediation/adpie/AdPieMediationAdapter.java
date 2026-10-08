package com.google.ads.mediation.adpie;

import android.content.Context;
import android.util.Log;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
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
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class AdPieMediationAdapter extends Adapter {
    private String TAG = "AdPieMediationAdapter";
    private AdPieBannerLoader mAdPieBannerLoader;
    private AdPieInterstitialLoader mAdPieInterstitialLoader;
    private AdPieRewardedAdLoader mAdPieRewardedAdLoader;

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        String[] strArrSplit = (AdPieSDK.getInstance().getVersion() + ".0").split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String[] strArrSplit = AdPieSDK.getInstance().getVersion().split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        Log.d(this.TAG, "loadBannerAd : " + mediationBannerAdConfiguration);
        AdPieBannerLoader adPieBannerLoader = new AdPieBannerLoader(mediationBannerAdConfiguration, mediationAdLoadCallback);
        this.mAdPieBannerLoader = adPieBannerLoader;
        adPieBannerLoader.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        Log.d(this.TAG, "loadInterstitialAd : " + mediationInterstitialAdConfiguration);
        AdPieInterstitialLoader adPieInterstitialLoader = new AdPieInterstitialLoader(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
        this.mAdPieInterstitialLoader = adPieInterstitialLoader;
        adPieInterstitialLoader.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(this.TAG, "loadRewardedAd : " + mediationRewardedAdConfiguration);
        AdPieRewardedAdLoader adPieRewardedAdLoader = new AdPieRewardedAdLoader(mediationRewardedAdConfiguration, mediationAdLoadCallback);
        this.mAdPieRewardedAdLoader = adPieRewardedAdLoader;
        adPieRewardedAdLoader.loadAd();
    }
}
