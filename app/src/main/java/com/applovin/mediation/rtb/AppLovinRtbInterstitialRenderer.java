package com.applovin.mediation.rtb;

import android.content.Context;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinAdFactory;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.ads.mediation.applovin.AppLovinInterstitialRenderer;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinRtbInterstitialRenderer extends AppLovinInterstitialRenderer implements MediationInterstitialAd {
    private AppLovinInterstitialAdDialog interstitialAd;
    private AppLovinSdk sdk;

    public AppLovinRtbInterstitialRenderer(MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        super(mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinInterstitialRenderer
    public void loadAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        this.sdk = this.appLovinInitializer.retrieveSdk(mediationInterstitialAdConfiguration.getContext());
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreateInterstitialAdDialog = this.appLovinAdFactory.createInterstitialAdDialog(this.sdk, mediationInterstitialAdConfiguration.getContext());
        this.interstitialAd = appLovinInterstitialAdDialogCreateInterstitialAdDialog;
        appLovinInterstitialAdDialogCreateInterstitialAdDialog.setAdDisplayListener(this);
        this.interstitialAd.setAdClickListener(this);
        this.interstitialAd.setAdVideoPlaybackListener(this);
        this.interstitialAd.setExtraInfo(AppLovinExtras.Keys.KEY_WATERMARK, mediationInterstitialAdConfiguration.getWatermark());
        this.networkExtras = mediationInterstitialAdConfiguration.getMediationExtras();
        this.sdk.getAdService().loadNextAdForAdToken(mediationInterstitialAdConfiguration.getBidResponse(), this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.sdk.getSettings().setMuted(true);
        this.interstitialAd.showAndRender(this.appLovinInterstitialAd);
    }
}
