package com.applovin.mediation.adapters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapters.adpie.DrawableDownloadListener;
import com.applovin.mediation.adapters.adpie.DrawableDownloadUtil;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.AdView;
import com.gomfactory.adpie.sdk.InterstitialAd;
import com.gomfactory.adpie.sdk.NativeAd;
import com.gomfactory.adpie.sdk.RewardedAd;
import com.gomfactory.adpie.sdk.nativeads.NativeAdData;
import com.gomfactory.adpie.sdk.nativeads.NativeAdView;
import com.gomfactory.adpie.sdk.util.ClickThroughUtil;
import com.gomfactory.adpie.sdk.util.DisplayUtil;
import com.gomfactory.adpie.sdk.util.ReportUtil;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxNativeAdAdapter {
    private static final String TAG = "AdPieMediationAdapter";
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private NativeAd mNativeAd;
    private RewardedAd mRewardedAd;

    public AdPieMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return ADXGDPR.ADX_SDK_VERSION;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return ADXGDPR.ADX_SDK_VERSION + ".0";
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
        log("Destroy called for adapter " + this);
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
            this.mAdView = null;
        }
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.mInterstitialAd = null;
        }
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null) {
            rewardedAd.destroy();
            this.mRewardedAd = null;
        }
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
        }
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, final Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        d("Loading " + maxAdFormat.getLabel() + " AdView ad for placement: " + thirdPartyAdPlacementId + "...");
        String string = maxAdapterResponseParameters.getServerParameters().getString("app_id", null);
        String str = TAG;
        Log.d(str, "mid : " + string + ", sid : " + thirdPartyAdPlacementId);
        if (!TextUtils.isEmpty(string)) {
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(activity, string);
            }
            ADXLogUtil.d(str, "loadAdViewAd - " + maxAdapterResponseParameters.getServerParameters());
            try {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieMediationAdapter.this.mAdView = new AdView(activity);
                        AdPieMediationAdapter.this.mAdView.setSlotId(thirdPartyAdPlacementId);
                        AdPieMediationAdapter.this.mAdView.setAdListener(new AdView.AdListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.1.1
                            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
                            public void onAdLoaded() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                                if (maxAdViewAdapterListener != null) {
                                    ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, "Impression");
                                    maxAdViewAdapterListener.onAdViewAdLoaded(AdPieMediationAdapter.this.mAdView);
                                    maxAdViewAdapterListener.onAdViewAdDisplayed();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
                            public void onAdFailedToLoad(int i) {
                                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i);
                                if (maxAdViewAdapterListener != null) {
                                    maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
                            public void onAdClicked() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                                if (maxAdViewAdapterListener != null) {
                                    maxAdViewAdapterListener.onAdViewAdClicked();
                                }
                            }
                        });
                        AdPieMediationAdapter.this.mAdView.load();
                    }
                });
                return;
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
                if (maxAdViewAdapterListener != null) {
                    maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
                    return;
                }
                return;
            }
        }
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_FAILURE);
        if (maxAdViewAdapterListener != null) {
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, final Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        d("Loading interstitial ad for ad id: " + thirdPartyAdPlacementId + "...");
        String string = maxAdapterResponseParameters.getServerParameters().getString("app_id", null);
        String str = TAG;
        Log.d(str, "mid : " + string + ", sid : " + thirdPartyAdPlacementId);
        if (!TextUtils.isEmpty(string)) {
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(activity, string);
            }
            ADXLogUtil.d(str, "loadInterstitialAd - " + maxAdapterResponseParameters.getServerParameters());
            try {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieMediationAdapter.this.mInterstitialAd = new InterstitialAd(activity, thirdPartyAdPlacementId);
                        AdPieMediationAdapter.this.mInterstitialAd.setAdListener(new InterstitialAd.InterstitialAdListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.2.1
                            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
                            public void onAdLoaded() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                                if (maxInterstitialAdapterListener != null) {
                                    maxInterstitialAdapterListener.onInterstitialAdLoaded();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
                            public void onAdFailedToLoad(int i) {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + i);
                                if (maxInterstitialAdapterListener != null) {
                                    maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.NO_FILL);
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
                            public void onAdShown() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                                if (maxInterstitialAdapterListener != null) {
                                    maxInterstitialAdapterListener.onInterstitialAdDisplayed();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
                            public void onAdClicked() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                                if (maxInterstitialAdapterListener != null) {
                                    maxInterstitialAdapterListener.onInterstitialAdClicked();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
                            public void onAdDismissed() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                                if (maxInterstitialAdapterListener != null) {
                                    maxInterstitialAdapterListener.onInterstitialAdHidden();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
                            public void onAdFailedToShow() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                                if (maxInterstitialAdapterListener != null) {
                                    maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
                                }
                            }
                        });
                        AdPieMediationAdapter.this.mInterstitialAd.load();
                    }
                });
                return;
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
                if (maxInterstitialAdapterListener != null) {
                    maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
                    return;
                }
                return;
            }
        }
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_FAILURE);
        if (maxInterstitialAdapterListener != null) {
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        ADXLogUtil.d(TAG, "showInterstitialAd - " + serverParameters);
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AdPieMediationAdapter.this.mInterstitialAd != null && AdPieMediationAdapter.this.mInterstitialAd.isLoaded()) {
                        AdPieMediationAdapter.this.mInterstitialAd.show();
                        return;
                    }
                    AdPieMediationAdapter.this.log("Interstitial ad not ready");
                    ADXLogUtil.d(AdPieMediationAdapter.TAG, "Interstitial ad not ready");
                    MaxInterstitialAdapterListener maxInterstitialAdapterListener2 = maxInterstitialAdapterListener;
                    if (maxInterstitialAdapterListener2 != null) {
                        maxInterstitialAdapterListener2.onInterstitialAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
                    }
                }
            });
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, final Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        final String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        d("Loading rewarded ad for ad id: " + thirdPartyAdPlacementId + "...");
        String string = maxAdapterResponseParameters.getServerParameters().getString("app_id", null);
        String str = TAG;
        Log.d(str, "mid : " + string + ", sid : " + thirdPartyAdPlacementId);
        if (!TextUtils.isEmpty(string)) {
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(activity, string);
            }
            ADXLogUtil.d(str, "loadRewardedAd - " + maxAdapterResponseParameters.getServerParameters());
            try {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieMediationAdapter.this.mRewardedAd = new RewardedAd(activity, thirdPartyAdPlacementId);
                        AdPieMediationAdapter.this.mRewardedAd.setAdListener(new RewardedAd.RewardedAdListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.4.1
                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdLoaded() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onRewardedAdLoaded();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdFailedToLoad(int i) {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i);
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.NO_FILL);
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdShown() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Impression");
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onRewardedAdDisplayed();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdClicked() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onRewardedAdClicked();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdDismissed() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onRewardedAdHidden();
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdRewarded() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onUserRewarded(AdPieMediationAdapter.this.getReward());
                                }
                            }

                            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
                            public void onAdFailedToShow() {
                                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                                if (maxRewardedAdapterListener != null) {
                                    maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_DISPLAY_FAILED);
                                }
                            }
                        });
                        AdPieMediationAdapter.this.mRewardedAd.load();
                    }
                });
                return;
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
                if (maxRewardedAdapterListener != null) {
                    maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
                    return;
                }
                return;
            }
        }
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_FAILURE);
        if (maxRewardedAdapterListener != null) {
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        ADXLogUtil.d(TAG, "showRewardedAd - " + serverParameters);
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AdPieMediationAdapter.this.mRewardedAd != null && AdPieMediationAdapter.this.mRewardedAd.isLoaded()) {
                        AdPieMediationAdapter.this.mRewardedAd.show();
                        return;
                    }
                    AdPieMediationAdapter.this.log("Rewarded ad not ready");
                    ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                    maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.AD_NOT_READY);
                }
            });
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD);
        String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
        d("Loading native ad for ad id: " + thirdPartyAdPlacementId + "...");
        String string = maxAdapterResponseParameters.getServerParameters().getString("app_id", null);
        String str = TAG;
        Log.d(str, "mid : " + string + ", sid : " + thirdPartyAdPlacementId);
        if (!TextUtils.isEmpty(string)) {
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(activity, string);
            }
            ADXLogUtil.d(str, "loadNativeAd - " + maxAdapterResponseParameters.getServerParameters());
            try {
                AppLovinSdkUtils.runOnUiThread(new AnonymousClass6(activity, thirdPartyAdPlacementId, maxNativeAdAdapterListener));
                return;
            } catch (Exception e) {
                ADXLogUtil.e(TAG, e);
                return;
            }
        }
        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_FAILURE);
        if (maxNativeAdAdapterListener != null) {
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    /* JADX INFO: renamed from: com.applovin.mediation.adapters.AdPieMediationAdapter$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String val$adId;
        final /* synthetic */ Activity val$finalActivity;
        final /* synthetic */ MaxNativeAdAdapterListener val$listener;

        AnonymousClass6(Activity activity, String str, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
            this.val$finalActivity = activity;
            this.val$adId = str;
            this.val$listener = maxNativeAdAdapterListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdPieMediationAdapter.this.mNativeAd = new NativeAd(this.val$finalActivity, null);
            AdPieMediationAdapter.this.mNativeAd.setSlotId(this.val$adId);
            AdPieMediationAdapter.this.mNativeAd.setAdListener(new AnonymousClass1());
            AdPieMediationAdapter.this.mNativeAd.loadAd();
        }

        /* JADX INFO: renamed from: com.applovin.mediation.adapters.AdPieMediationAdapter$6$1, reason: invalid class name */
        class AnonymousClass1 implements NativeAd.AdListener {
            @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
            public void onAdClicked() {
            }

            @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
            public void onAdShown() {
            }

            AnonymousClass1() {
            }

            @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
            public void onAdLoaded(NativeAdView nativeAdView) {
                try {
                    final NativeAdData nativeAdData = nativeAdView.getNativeAdData();
                    HashMap<String, URL> map = new HashMap<>();
                    if (!TextUtils.isEmpty(nativeAdData.getIconImageUrl())) {
                        map.put(DrawableDownloadUtil.KEY_ICON, new URL(nativeAdData.getIconImageUrl()));
                    }
                    if (!TextUtils.isEmpty(nativeAdData.getMainImageUrl())) {
                        map.put(DrawableDownloadUtil.KEY_MAIN_IMAGE, new URL(nativeAdData.getMainImageUrl()));
                    }
                    if (!TextUtils.isEmpty(nativeAdData.getOptoutImageUrl())) {
                        map.put(DrawableDownloadUtil.KEY_PRIVACY_ICON, new URL(nativeAdData.getOptoutImageUrl()));
                    }
                    new DrawableDownloadUtil(new DrawableDownloadListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.6.1.1
                        @Override // com.applovin.mediation.adapters.adpie.DrawableDownloadListener
                        public void onDownloadSuccess(HashMap<String, Drawable> map2) {
                            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_SUCCESS);
                            Drawable drawable = map2.get(DrawableDownloadUtil.KEY_ICON);
                            Drawable drawable2 = map2.get(DrawableDownloadUtil.KEY_MAIN_IMAGE);
                            Drawable drawable3 = map2.get(DrawableDownloadUtil.KEY_PRIVACY_ICON);
                            ImageView imageView = new ImageView(AnonymousClass6.this.val$finalActivity);
                            imageView.setImageDrawable(drawable2);
                            ImageView imageView2 = new ImageView(AnonymousClass6.this.val$finalActivity);
                            if (drawable3 != null) {
                                imageView2.setVisibility(0);
                                imageView2.setLayoutParams(new ViewGroup.LayoutParams(DisplayUtil.dpToPx(AnonymousClass6.this.val$finalActivity, 20), DisplayUtil.dpToPx(AnonymousClass6.this.val$finalActivity, 20)));
                                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.6.1.1.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view) {
                                        try {
                                            ClickThroughUtil.goToBrowser(AnonymousClass6.this.val$finalActivity, nativeAdData.getOptoutLink());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                                imageView2.setImageDrawable(drawable3);
                            }
                            MaxAdPieNativeAd maxAdPieNativeAd = AdPieMediationAdapter.this.new MaxAdPieNativeAd(new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(nativeAdData.getTitle()).setBody(nativeAdData.getDescription()).setCallToAction(nativeAdData.getCallToAction()).setIcon(new MaxNativeAd.MaxNativeAdImage(drawable)).setMediaView(imageView).setOptionsView(imageView2), AnonymousClass6.this.val$listener, nativeAdData);
                            if (AnonymousClass6.this.val$listener != null) {
                                AnonymousClass6.this.val$listener.onNativeAdLoaded(maxAdPieNativeAd, null);
                            }
                        }

                        @Override // com.applovin.mediation.adapters.adpie.DrawableDownloadListener
                        public void onDownloadFailure() {
                            ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, "Failure, (Native ad images failed to download.)");
                            if (AnonymousClass6.this.val$listener != null) {
                                AnonymousClass6.this.val$listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
                            }
                        }
                    }).execute(map);
                } catch (Exception e) {
                    ADXLogUtil.e(AdPieMediationAdapter.TAG, e);
                    ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, "Failure, (" + e.toString() + ")");
                    if (AnonymousClass6.this.val$listener != null) {
                        AnonymousClass6.this.val$listener.onNativeAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.NativeAd.AdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_FAILURE);
                if (AnonymousClass6.this.val$listener != null) {
                    AnonymousClass6.this.val$listener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
                }
            }
        }
    }

    private class MaxAdPieNativeAd extends MaxNativeAd {
        private MaxNativeAdAdapterListener listener;
        private boolean mIsClicked;
        private NativeAdData nativeAdData;
        private View observerView;

        public MaxAdPieNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        public MaxAdPieNativeAd(MaxNativeAd.Builder builder, MaxNativeAdAdapterListener maxNativeAdAdapterListener, NativeAdData nativeAdData) {
            super(builder);
            this.listener = maxNativeAdAdapterListener;
            this.nativeAdData = nativeAdData;
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
            ADXLogUtil.d(AdPieMediationAdapter.TAG, "prepareViewForInteraction!");
            ADXLogUtil.printViewHierarchy(viewGroup);
            return super.prepareForInteraction(list, viewGroup);
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public boolean shouldPrepareViewForInteractionOnMainThread() {
            ADXLogUtil.d(AdPieMediationAdapter.TAG, "shouldPrepareViewForInteractionOnMainThread");
            return super.shouldPrepareViewForInteractionOnMainThread();
        }

        @Override // com.applovin.mediation.nativeAds.MaxNativeAd
        public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
            ADXLogUtil.d(AdPieMediationAdapter.TAG, "prepareViewForInteraction");
            try {
                ViewGroup optionsContentViewGroup = maxNativeAdView.getOptionsContentViewGroup();
                if (optionsContentViewGroup != null && (optionsContentViewGroup.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) optionsContentViewGroup.getLayoutParams();
                    layoutParams.width = DisplayUtil.dpToPx(maxNativeAdView.getContext(), 20);
                    layoutParams.height = DisplayUtil.dpToPx(maxNativeAdView.getContext(), 20);
                    optionsContentViewGroup.setLayoutParams(layoutParams);
                }
                if (maxNativeAdView.getTitleTextView() != null) {
                    maxNativeAdView.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.MaxAdPieNativeAd.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MaxAdPieNativeAd.this.handleClick(view);
                        }
                    });
                }
                if (maxNativeAdView.getBodyTextView() != null) {
                    maxNativeAdView.getBodyTextView().setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.MaxAdPieNativeAd.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MaxAdPieNativeAd.this.handleClick(view);
                        }
                    });
                }
                if (maxNativeAdView.getIconImageView() != null) {
                    maxNativeAdView.getIconImageView().setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.MaxAdPieNativeAd.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MaxAdPieNativeAd.this.handleClick(view);
                        }
                    });
                }
                if (maxNativeAdView.getMainView() != null) {
                    maxNativeAdView.getMainView().setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.MaxAdPieNativeAd.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MaxAdPieNativeAd.this.handleClick(view);
                        }
                    });
                }
                if (maxNativeAdView.getCallToActionButton() != null) {
                    maxNativeAdView.getCallToActionButton().setOnClickListener(new View.OnClickListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.MaxAdPieNativeAd.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            MaxAdPieNativeAd.this.handleClick(view);
                        }
                    });
                }
                View view = new View(maxNativeAdView.getContext());
                this.observerView = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
                maxNativeAdView.addView(this.observerView, 0);
                this.observerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.applovin.mediation.adapters.AdPieMediationAdapter.MaxAdPieNativeAd.6
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view2) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view2) {
                        if (MaxAdPieNativeAd.this.observerView != null) {
                            MaxAdPieNativeAd.this.observerView.removeOnAttachStateChangeListener(this);
                        }
                        ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, "Impression");
                        ReportUtil.sendReport("NATIVE_IMPRESSION_TAG", MaxAdPieNativeAd.this.nativeAdData.getTrackingImpUrls());
                        if (MaxAdPieNativeAd.this.listener != null) {
                            MaxAdPieNativeAd.this.listener.onNativeAdDisplayed(null);
                        }
                    }
                });
            } catch (Exception e) {
                ADXLogUtil.e(AdPieMediationAdapter.TAG, e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleClick(View view) {
            try {
                ADXLogUtil.logAppLovinEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_CLICK);
                ClickThroughUtil.goToBrowser(view.getContext(), this.nativeAdData.getLink());
                if (!this.mIsClicked) {
                    this.mIsClicked = true;
                    ReportUtil.sendReport("NATIVE_CLICK_TAG", this.nativeAdData.getTrackingClkUrls());
                }
                MaxNativeAdAdapterListener maxNativeAdAdapterListener = this.listener;
                if (maxNativeAdAdapterListener != null) {
                    maxNativeAdAdapterListener.onNativeAdClicked();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
