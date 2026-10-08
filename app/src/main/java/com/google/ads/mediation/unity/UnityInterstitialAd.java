package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* JADX INFO: loaded from: classes8.dex */
public class UnityInterstitialAd implements MediationInterstitialAd, IUnityAdsLoadListener, IUnityAdsShowListener {
    static final String ERROR_MSG_INTERSTITIAL_INITIALIZATION_FAILED = "Unity Ads initialization failed for game ID '%s' with error message: %s";
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> adLoadCallback;
    private MediationInterstitialAdCallback interstitialAdCallback;
    private String objectId;
    private String placementId;
    private final UnityAdsLoader unityAdsLoader;
    private final UnityInitializer unityInitializer;

    public UnityInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, UnityInitializer unityInitializer, UnityAdsLoader unityAdsLoader) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.unityInitializer = unityInitializer;
        this.unityAdsLoader = unityAdsLoader;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad successfully loaded for placement ID: %s", str));
        this.placementId = str;
        this.interstitialAdCallback = this.adLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure(" + str2 + ")");
        this.placementId = str;
        AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsLoadError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
        this.adLoadCallback.onFailure(adErrorCreateSDKError);
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String str) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad started for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad was clicked for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.reportAdClicked();
        this.interstitialAdCallback.onAdLeftApplication();
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad finished playing for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsShowError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adErrorCreateSDKError);
        }
    }

    public void loadAd() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        final Context context = this.adConfiguration.getContext();
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(AndroidGetAdPlayerContext.KEY_GAME_ID);
        String string2 = serverParameters.getString("zoneId");
        this.placementId = string2;
        if (!UnityAdsAdapterUtils.areValidIds(string, string2)) {
            this.adLoadCallback.onFailure(new AdError(101, "Missing or invalid server parameters.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
        } else {
            final String bidResponse = this.adConfiguration.getBidResponse();
            this.unityInitializer.initializeUnityAds(context, string, new IUnityAdsInitializationListener() { // from class: com.google.ads.mediation.unity.UnityInterstitialAd.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
                    Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load interstitial ad with placement ID: %s", string, UnityInterstitialAd.this.placementId));
                    UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
                    UnityInterstitialAd.this.objectId = UUID.randomUUID().toString();
                    UnityAdsLoadOptions unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId = UnityInterstitialAd.this.unityAdsLoader.createUnityAdsLoadOptionsWithId(UnityInterstitialAd.this.objectId);
                    String str = bidResponse;
                    if (str != null) {
                        unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId.setAdMarkup(str);
                    }
                    UnityInterstitialAd.this.unityAdsLoader.load(UnityInterstitialAd.this.placementId, unityAdsLoadOptionsCreateUnityAdsLoadOptionsWithId, UnityInterstitialAd.this);
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, String.format(UnityInterstitialAd.ERROR_MSG_INTERSTITIAL_INITIALIZATION_FAILED, string, str));
                    Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
                    UnityInterstitialAd.this.adLoadCallback.onFailure(adErrorCreateSDKError);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        if (this.placementId == null) {
            Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
        }
        UnityAdsShowOptions unityAdsShowOptionsCreateUnityAdsShowOptionsWithId = this.unityAdsLoader.createUnityAdsShowOptionsWithId(this.objectId);
        unityAdsShowOptionsCreateUnityAdsShowOptionsWithId.set("watermark", this.adConfiguration.getWatermark());
        this.unityAdsLoader.show((Activity) context, this.placementId, unityAdsShowOptionsCreateUnityAdsShowOptionsWithId, this);
    }
}
