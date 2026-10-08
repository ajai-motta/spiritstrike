package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class FacebookRtbBannerAd implements MediationBannerAd, AdListener {
    private AdView adView;
    private MediationBannerAdCallback bannerAdCallback;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> callback;
    private final MetaFactory metaFactory;
    private FrameLayout wrappedAdView;

    public FacebookRtbBannerAd(MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        this.callback = mediationAdLoadCallback;
        this.metaFactory = metaFactory;
    }

    public void render(MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        String placementID = FacebookMediationAdapter.getPlacementID(mediationBannerAdConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.callback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(mediationBannerAdConfiguration);
        try {
            this.adView = this.metaFactory.createMetaAdView(mediationBannerAdConfiguration.getContext(), placementID, mediationBannerAdConfiguration.getBidResponse());
            if (!TextUtils.isEmpty(mediationBannerAdConfiguration.getWatermark())) {
                this.adView.setExtraHints(new ExtraHints.Builder().mediationData(mediationBannerAdConfiguration.getWatermark()).build());
            }
            Context context = mediationBannerAdConfiguration.getContext();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mediationBannerAdConfiguration.getAdSize().getWidthInPixels(context), -2);
            this.wrappedAdView = new FrameLayout(context);
            this.adView.setLayoutParams(layoutParams);
            this.wrappedAdView.addView(this.adView);
            AdView adView = this.adView;
            adView.loadAd(adView.buildLoadAdConfig().withAdListener(this).withBid(mediationBannerAdConfiguration.getBidResponse()).build());
        } catch (Exception e) {
            AdError adError2 = new AdError(111, "Failed to create banner ad: " + e.getMessage(), FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError2.getMessage());
            this.callback.onFailure(adError2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View getView() {
        return this.wrappedAdView;
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_BANNER, "Failure, " + adError.getErrorCode() + "(" + adError.getErrorMessage() + ")");
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
        this.callback.onFailure(adError2);
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
        this.bannerAdCallback = this.callback.onSuccess(this);
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
            this.bannerAdCallback.onAdOpened();
            this.bannerAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_BANNER, "Impression");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }
}
