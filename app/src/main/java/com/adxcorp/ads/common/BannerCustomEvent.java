package com.adxcorp.ads.common;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.adxcorp.ads.common.AdConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BannerCustomEvent extends CustomEvent {
    private BCustomEventListener proxyCustomEventListener = new BCustomEventListener() { // from class: com.adxcorp.ads.common.BannerCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (BannerCustomEvent.this.mIsFinished) {
                return;
            }
            BannerCustomEvent.this.mIsFinished = true;
            BannerCustomEvent.this.stopTimer();
            if (BannerCustomEvent.this.mAdCustomEventListener != null) {
                BannerCustomEvent.this.mAdCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (BannerCustomEvent.this.mIsFinished) {
                return;
            }
            BannerCustomEvent.this.mIsFinished = true;
            BannerCustomEvent.this.stopTimer();
            if (BannerCustomEvent.this.mAdCustomEventListener != null) {
                BannerCustomEvent.this.mAdCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (BannerCustomEvent.this.mAdCustomEventListener != null) {
                BannerCustomEvent.this.mAdCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (BannerCustomEvent.this.mAdCustomEventListener != null) {
                BannerCustomEvent.this.mAdCustomEventListener.onAdImpression();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onPaidEvent(double d) {
            if (BannerCustomEvent.this.mAdCustomEventListener != null) {
                BannerCustomEvent.this.mAdCustomEventListener.onPaidEvent(d);
            }
        }
    };

    public abstract View getAdView();

    public abstract void impression();

    public abstract void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener);

    public abstract void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size);

    /* JADX WARN: Finally extract failed */
    @Override // com.adxcorp.ads.common.CustomEvent
    public void internalLoadAd(Context context, MediationData mediationData, long j, CustomEventListener customEventListener) {
        this.mAdCustomEventListener = customEventListener;
        this.mMediationData = mediationData;
        this.mIsFinished = false;
        stopTimer();
        startTimer(j);
        try {
            loadAd(context, convertJsonToMap(mediationData), this.proxyCustomEventListener);
        } catch (Throwable th) {
            stopTimer();
            throw th;
        }
    }

    public void clearAnimation() {
        View adView = getAdView();
        if (adView != null) {
            adView.clearAnimation();
        }
    }

    public void startAnimation(Animation animation) {
        View adView = getAdView();
        if (adView != null) {
            adView.startAnimation(animation);
        }
    }

    public void setVisibility(int i) {
        View adView = getAdView();
        if (adView != null) {
            adView.setVisibility(i);
        }
    }
}
