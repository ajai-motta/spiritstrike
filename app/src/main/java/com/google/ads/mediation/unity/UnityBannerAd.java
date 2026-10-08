package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.ads.mediation.unity.UnityAdsAdapterUtils;
import com.google.ads.mediation.unity.eventadapters.UnityBannerEventAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class UnityBannerAd extends UnityMediationAdapter implements MediationBannerAdapter {
    private String bannerPlacementId;
    private BannerView bannerView;
    private UnityBannerEventAdapter eventAdapter;
    private String gameId;
    private MediationBannerListener mediationBannerListener;
    private BannerView.IListener unityBannerListener = new BannerView.Listener() { // from class: com.google.ads.mediation.unity.UnityBannerAd.1
        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerLoaded(BannerView bannerView) {
            logBannerMessage("Unity Ads finished loading banner ad for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.LOADED);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerClick(BannerView bannerView) {
            logBannerMessage("Unity Ads banner ad was clicked for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.CLICKED);
            UnityBannerAd.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.OPENED);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
            UnityBannerAd.this.sendBannerFailedToLoad(UnityAdsAdapterUtils.getMediationErrorCode(bannerErrorInfo), bannerErrorInfo.errorMessage);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerLeftApplication(BannerView bannerView) {
            logBannerMessage("Unity Ads banner ad left application for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.LEFT_APPLICATION);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerShown(BannerView bannerView) {
            logBannerMessage("Unity Ads banner ad was shown for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.sendAdEvent(UnityAdsAdapterUtils.AdEvent.IMPRESSION);
        }

        private void logBannerMessage(String str, BannerView bannerView) {
            if (bannerView != null) {
                Log.d(UnityMediationAdapter.TAG, String.format(str, bannerView.getPlacementId()));
            }
        }
    };

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        BannerView bannerView = this.bannerView;
        if (bannerView != null) {
            bannerView.destroy();
        }
        this.bannerView = null;
        this.mediationBannerListener = null;
        this.unityBannerListener = null;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(final Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mediationBannerListener = mediationBannerListener;
        this.eventAdapter = new UnityBannerEventAdapter(mediationBannerListener, this);
        this.gameId = bundle.getString(AndroidGetAdPlayerContext.KEY_GAME_ID);
        String string = bundle.getString("zoneId");
        this.bannerPlacementId = string;
        if (!UnityAdsAdapterUtils.areValidIds(this.gameId, string)) {
            sendBannerFailedToLoad(101, "Missing or invalid server parameters.");
            return;
        }
        if (!(context instanceof Activity)) {
            sendBannerFailedToLoad(105, "Unity Ads requires an Activity context to load ads.");
            return;
        }
        final Activity activity = (Activity) context;
        final UnityBannerSize unityBannerSize = UnityAdsAdapterUtils.getUnityBannerSize(context, adSize);
        if (unityBannerSize == null) {
            sendBannerFailedToLoad(110, String.format("There is no matching Unity Ads ad size for Google ad size: %s", adSize));
        } else {
            UnityInitializer.getInstance().initializeUnityAds(context, this.gameId, new IUnityAdsInitializationListener() { // from class: com.google.ads.mediation.unity.UnityBannerAd.2
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
                    Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load banner ad with placement ID: %s", UnityBannerAd.this.gameId, UnityBannerAd.this.bannerPlacementId));
                    if (UnityBannerAd.this.bannerView == null) {
                        UnityBannerAd.this.bannerView = new BannerView(activity, UnityBannerAd.this.bannerPlacementId, unityBannerSize);
                    }
                    UnityAdsAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
                    UnityBannerAd.this.bannerView.setListener(UnityBannerAd.this.unityBannerListener);
                    UnityBannerAd.this.bannerView.load();
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    AdError adErrorCreateSDKError = UnityAdsAdapterUtils.createSDKError(unityAdsInitializationError, String.format("Unity Ads initialization failed for game ID '%s' with error message: %s", UnityBannerAd.this.gameId, str));
                    Log.w(UnityMediationAdapter.TAG, adErrorCreateSDKError.toString());
                    if (UnityBannerAd.this.mediationBannerListener != null) {
                        UnityBannerAd.this.mediationBannerListener.onAdFailedToLoad(UnityBannerAd.this, adErrorCreateSDKError);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.bannerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBannerFailedToLoad(int i, String str) {
        AdError adErrorCreateAdError = UnityAdsAdapterUtils.createAdError(i, str);
        Log.w(TAG, adErrorCreateAdError.toString());
        MediationBannerListener mediationBannerListener = this.mediationBannerListener;
        if (mediationBannerListener != null) {
            mediationBannerListener.onAdFailedToLoad(this, adErrorCreateAdError);
        }
    }
}
