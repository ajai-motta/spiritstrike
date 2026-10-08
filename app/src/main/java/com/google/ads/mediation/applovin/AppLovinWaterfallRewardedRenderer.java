package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class AppLovinWaterfallRewardedRenderer extends AppLovinRewardedRenderer implements MediationRewardedAd {
    private static final String DEFAULT_ZONE = "";
    protected static final HashMap<String, WeakReference<AppLovinWaterfallRewardedRenderer>> incentivizedAdsMap = new HashMap<>();
    private boolean enableMultipleAdLoading;
    private String zoneId;

    protected AppLovinWaterfallRewardedRenderer(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory, AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper) {
        super(mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory, appLovinSdkUtilsWrapper);
        this.enableMultipleAdLoading = false;
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer
    public void loadAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        final Context context = mediationRewardedAdConfiguration.getContext();
        final Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        String string = serverParameters.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN);
            Log.e(TAG, adError.toString());
            this.adLoadCallback.onFailure(adError);
        } else {
            if (AppLovinUtils.isMultiAdsEnabled()) {
                this.enableMultipleAdLoading = true;
            }
            this.networkExtras = mediationRewardedAdConfiguration.getMediationExtras();
            this.appLovinInitializer.initialize(context, string, new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinWaterfallRewardedRenderer.1
                @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
                public void onInitializeSuccess() {
                    AppLovinWaterfallRewardedRenderer.this.zoneId = AppLovinUtils.retrieveZoneId(serverParameters);
                    AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer = AppLovinWaterfallRewardedRenderer.this;
                    appLovinWaterfallRewardedRenderer.appLovinSdk = appLovinWaterfallRewardedRenderer.appLovinInitializer.retrieveSdk(context);
                    Log.d(AppLovinRewardedRenderer.TAG, String.format("Requesting rewarded video for zone '%s'", AppLovinWaterfallRewardedRenderer.this.zoneId));
                    if (!AppLovinWaterfallRewardedRenderer.incentivizedAdsMap.containsKey(AppLovinWaterfallRewardedRenderer.this.zoneId)) {
                        AppLovinWaterfallRewardedRenderer.incentivizedAdsMap.put(AppLovinWaterfallRewardedRenderer.this.zoneId, new WeakReference<>(AppLovinWaterfallRewardedRenderer.this));
                        if (Objects.equals(AppLovinWaterfallRewardedRenderer.this.zoneId, "")) {
                            AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer2 = AppLovinWaterfallRewardedRenderer.this;
                            appLovinWaterfallRewardedRenderer2.incentivizedInterstitial = appLovinWaterfallRewardedRenderer2.appLovinAdFactory.createIncentivizedInterstitial(AppLovinWaterfallRewardedRenderer.this.appLovinSdk);
                        } else {
                            AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer3 = AppLovinWaterfallRewardedRenderer.this;
                            appLovinWaterfallRewardedRenderer3.incentivizedInterstitial = appLovinWaterfallRewardedRenderer3.appLovinAdFactory.createIncentivizedInterstitial(AppLovinWaterfallRewardedRenderer.this.zoneId, AppLovinWaterfallRewardedRenderer.this.appLovinSdk);
                        }
                        AppLovinWaterfallRewardedRenderer.this.incentivizedInterstitial.preload(AppLovinWaterfallRewardedRenderer.this);
                        return;
                    }
                    AdError adError2 = new AdError(105, "Cannot load multiple rewarded ads with the same Zone ID. Let the first ad finish loading before attempting to load another.", AppLovinMediationAdapter.ERROR_DOMAIN);
                    Log.e(AppLovinRewardedRenderer.TAG, adError2.toString());
                    AppLovinWaterfallRewardedRenderer.this.adLoadCallback.onFailure(adError2);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.appLovinSdk.getSettings().setMuted(true);
        String str = this.zoneId;
        if (str != null) {
            Log.d(TAG, String.format("Showing rewarded video for zone '%s'", str));
        }
        if (!this.incentivizedInterstitial.isAdReadyToDisplay()) {
            AdError adError = new AdError(106, "Ad not ready to show.", AppLovinMediationAdapter.ERROR_DOMAIN);
            Log.e(TAG, adError.toString());
            this.rewardedAdCallback.onAdFailedToShow(adError);
            return;
        }
        this.incentivizedInterstitial.show(context, this, this, this, this);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (this.enableMultipleAdLoading) {
            incentivizedAdsMap.remove(this.zoneId);
        }
        super.adReceived(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        incentivizedAdsMap.remove(this.zoneId);
        super.failedToReceiveAd(i);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        incentivizedAdsMap.remove(this.zoneId);
        super.adHidden(appLovinAd);
    }
}
