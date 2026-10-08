package com.adxcorp.ads.common;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RewardedCustomEvent extends CustomEvent {
    private RCustomEventListener proxyCustomEventListener = new RCustomEventListener() { // from class: com.adxcorp.ads.common.RewardedCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (RewardedCustomEvent.this.mIsFinished) {
                return;
            }
            RewardedCustomEvent.this.mIsFinished = true;
            RewardedCustomEvent.this.stopTimer();
            if (RewardedCustomEvent.this.mAdCustomEventListener != null) {
                RewardedCustomEvent.this.mAdCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (RewardedCustomEvent.this.mIsFinished) {
                return;
            }
            RewardedCustomEvent.this.mIsFinished = true;
            RewardedCustomEvent.this.stopTimer();
            if (RewardedCustomEvent.this.mAdCustomEventListener != null) {
                RewardedCustomEvent.this.mAdCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (RewardedCustomEvent.this.mAdCustomEventListener != null) {
                RewardedCustomEvent.this.mAdCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (RewardedCustomEvent.this.mAdCustomEventListener != null) {
                RewardedCustomEvent.this.mAdCustomEventListener.onAdImpression();
            }
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onAdClosed() {
            if (RewardedCustomEvent.this.mAdCustomEventListener == null || !(RewardedCustomEvent.this.mAdCustomEventListener instanceof RCustomEventListener)) {
                return;
            }
            ((RCustomEventListener) RewardedCustomEvent.this.mAdCustomEventListener).onAdClosed();
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onAdRewarded() {
            if (RewardedCustomEvent.this.mAdCustomEventListener == null || !(RewardedCustomEvent.this.mAdCustomEventListener instanceof RCustomEventListener)) {
                return;
            }
            ((RCustomEventListener) RewardedCustomEvent.this.mAdCustomEventListener).onAdRewarded();
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener
        public void onAdFailedToShow() {
            if (RewardedCustomEvent.this.mAdCustomEventListener == null || !(RewardedCustomEvent.this.mAdCustomEventListener instanceof RCustomEventListener)) {
                return;
            }
            ((RCustomEventListener) RewardedCustomEvent.this.mAdCustomEventListener).onAdFailedToShow();
        }

        @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
        public void onPaidEvent(double d) {
            if (RewardedCustomEvent.this.mAdCustomEventListener == null || !(RewardedCustomEvent.this.mAdCustomEventListener instanceof RCustomEventListener)) {
                return;
            }
            ((RCustomEventListener) RewardedCustomEvent.this.mAdCustomEventListener).onPaidEvent(d);
        }
    };

    public abstract void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener);

    public abstract void show();

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
}
