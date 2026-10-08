package com.applovin.mediation.rtb;

import android.content.Context;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.sdk.AppLovinAd;
import com.google.ads.mediation.applovin.AppLovinAdFactory;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.ads.mediation.applovin.AppLovinRewardedRenderer;
import com.google.ads.mediation.applovin.AppLovinSdkUtilsWrapper;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLovinRtbRewardedRenderer extends AppLovinRewardedRenderer {
    private AppLovinAd appLovinAd;

    public AppLovinRtbRewardedRenderer(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory, AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper) {
        super(mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory, appLovinSdkUtilsWrapper);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer
    public void loadAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        this.appLovinSdk = this.appLovinInitializer.retrieveSdk(mediationRewardedAdConfiguration.getContext());
        this.incentivizedInterstitial = this.appLovinAdFactory.createIncentivizedInterstitial(this.appLovinSdk);
        this.incentivizedInterstitial.setExtraInfo(AppLovinExtras.Keys.KEY_WATERMARK, mediationRewardedAdConfiguration.getWatermark());
        this.networkExtras = mediationRewardedAdConfiguration.getMediationExtras();
        this.appLovinSdk.getAdService().loadNextAdForAdToken(mediationRewardedAdConfiguration.getBidResponse(), this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.appLovinSdk.getSettings().setMuted(true);
        this.incentivizedInterstitial.show(this.appLovinAd, context, this, this, this, this);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        this.appLovinAd = appLovinAd;
        super.adReceived(appLovinAd);
    }
}
