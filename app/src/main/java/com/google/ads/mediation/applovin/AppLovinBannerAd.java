package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class AppLovinBannerAd implements MediationBannerAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
    private static final String TAG = "AppLovinBannerAd";
    private final AppLovinAdFactory appLovinAdFactory;
    private AppLovinAdViewWrapper appLovinAdViewWrapper;
    private final AppLovinInitializer appLovinInitializer;
    private MediationBannerAdCallback bannerAdCallback;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback;
    private AppLovinSdk sdk;
    private String zoneId;

    private AppLovinBannerAd(MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        this.appLovinInitializer = appLovinInitializer;
        this.appLovinAdFactory = appLovinAdFactory;
    }

    public static AppLovinBannerAd newInstance(MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        return new AppLovinBannerAd(mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory);
    }

    public void loadAd(MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        final Context context = mediationBannerAdConfiguration.getContext();
        final Bundle serverParameters = mediationBannerAdConfiguration.getServerParameters();
        final AdSize adSize = mediationBannerAdConfiguration.getAdSize();
        String string = serverParameters.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            Log.e(TAG, adError.getMessage());
            this.mediationAdLoadCallback.onFailure(adError);
            return;
        }
        final AppLovinAdSize appLovinAdSizeAppLovinAdSizeFromAdMobAdSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(context, adSize);
        if (appLovinAdSizeAppLovinAdSizeFromAdMobAdSize == null) {
            AdError adError2 = new AdError(101, "Failed to request banner with unsupported size.", AppLovinMediationAdapter.ERROR_DOMAIN);
            Log.e(TAG, adError2.getMessage());
            this.mediationAdLoadCallback.onFailure(adError2);
            return;
        }
        this.appLovinInitializer.initialize(context, string, new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinBannerAd.1
            @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
            public void onInitializeSuccess() {
                AppLovinBannerAd appLovinBannerAd = AppLovinBannerAd.this;
                appLovinBannerAd.sdk = appLovinBannerAd.appLovinInitializer.retrieveSdk(context);
                AppLovinBannerAd.this.zoneId = AppLovinUtils.retrieveZoneId(serverParameters);
                Log.d(AppLovinBannerAd.TAG, "Requesting banner of size " + appLovinAdSizeAppLovinAdSizeFromAdMobAdSize + " for zone: " + AppLovinBannerAd.this.zoneId);
                AppLovinBannerAd appLovinBannerAd2 = AppLovinBannerAd.this;
                appLovinBannerAd2.appLovinAdViewWrapper = appLovinBannerAd2.appLovinAdFactory.createAdView(AppLovinBannerAd.this.sdk, appLovinAdSizeAppLovinAdSizeFromAdMobAdSize, adSize, context);
                AppLovinBannerAd.this.appLovinAdViewWrapper.setAdDisplayListener(AppLovinBannerAd.this);
                AppLovinBannerAd.this.appLovinAdViewWrapper.setAdClickListener(AppLovinBannerAd.this);
                AppLovinBannerAd.this.appLovinAdViewWrapper.setAdViewEventListener(AppLovinBannerAd.this);
                if (!TextUtils.isEmpty(AppLovinBannerAd.this.zoneId)) {
                    AppLovinBannerAd.this.sdk.getAdService().loadNextAdForZoneId(AppLovinBannerAd.this.zoneId, AppLovinBannerAd.this);
                } else {
                    AppLovinBannerAd.this.sdk.getAdService().loadNextAd(appLovinAdSizeAppLovinAdSizeFromAdMobAdSize, AppLovinBannerAd.this);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View getView() {
        return this.appLovinAdViewWrapper.getAppLovinAdView();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
        Log.d(TAG, "Banner did load ad for zone: " + this.zoneId);
        this.appLovinAdViewWrapper.renderAd(appLovinAd);
        this.bannerAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        AdError adError = AppLovinUtils.getAdError(i);
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i + " (" + adError.getMessage() + ")");
        String str = TAG;
        StringBuilder sb = new StringBuilder("Failed to load banner ad with error: ");
        sb.append(i);
        Log.w(str, sb.toString());
        this.mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, "Impression");
        Log.d(TAG, "Banner displayed.");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        Log.d(TAG, "Banner dismissed.");
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
        Log.d(TAG, "Banner clicked.");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(TAG, "Banner opened fullscreen.");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(TAG, "Banner closed fullscreen.");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdClosed();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(TAG, "Banner left application.");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        Log.w(TAG, "Banner failed to display: " + appLovinAdViewDisplayErrorCode);
    }
}
