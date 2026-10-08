package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.ads.Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class FacebookRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdExtendedListener {
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback;
    private MediationInterstitialAdCallback interstitalAdCallback;
    private InterstitialAd interstitialAd;
    private final MetaFactory metaFactory;
    private final AtomicBoolean showAdCalled = new AtomicBoolean();
    private final AtomicBoolean didInterstitialAdClose = new AtomicBoolean();

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdCompleted() {
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerFailed() {
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerSucceeded() {
    }

    public FacebookRtbInterstitialAd(MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        this.callback = mediationAdLoadCallback;
        this.metaFactory = metaFactory;
    }

    public void render(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        String placementID = FacebookMediationAdapter.getPlacementID(mediationInterstitialAdConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty. ", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.callback.onFailure(adError);
        } else {
            FacebookMediationAdapter.setMixedAudience(mediationInterstitialAdConfiguration);
            this.interstitialAd = this.metaFactory.createInterstitialAd(mediationInterstitialAdConfiguration.getContext(), placementID);
            if (!TextUtils.isEmpty(mediationInterstitialAdConfiguration.getWatermark())) {
                this.interstitialAd.setExtraHints(new ExtraHints.Builder().mediationData(mediationInterstitialAdConfiguration.getWatermark()).build());
            }
            InterstitialAd interstitialAd = this.interstitialAd;
            interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withBid(mediationInterstitialAdConfiguration.getBidResponse()).withAdListener(this).build());
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.showAdCalled.set(true);
        if (this.interstitialAd.show()) {
            return;
        }
        AdError adError = new AdError(110, "Failed to present interstitial ad.", FacebookMediationAdapter.ERROR_DOMAIN);
        Log.w(FacebookMediationAdapter.TAG, adError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDisplayed(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDismissed(Ad ad) {
        if (this.didInterstitialAdClose.getAndSet(true) || this.interstitalAdCallback == null) {
            return;
        }
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
        this.interstitalAdCallback.onAdClosed();
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + adError.getErrorCode() + "(" + adError.getErrorMessage() + ")");
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
        if (this.showAdCalled.get()) {
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdFailedToShow(adError2);
                return;
            }
            return;
        }
        this.callback.onFailure(adError2);
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
        this.interstitalAdCallback = this.callback.onSuccess(this);
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdClicked();
            this.interstitalAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitalAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdImpression();
        }
    }

    @Override // com.facebook.ads.InterstitialAdExtendedListener
    public void onInterstitialActivityDestroyed() {
        if (this.didInterstitialAdClose.getAndSet(true) || this.interstitalAdCallback == null) {
            return;
        }
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
        this.interstitalAdCallback.onAdClosed();
    }
}
