package com.adxcorp.ads.common;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IntersCustomEvent extends CustomEvent {
    private ICustomEventListener proxyCustomEventListener = new ICustomEventListener() { // from class: com.adxcorp.ads.common.IntersCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (IntersCustomEvent.this.mIsFinished) {
                return;
            }
            IntersCustomEvent.this.mIsFinished = true;
            IntersCustomEvent.this.stopTimer();
            if (IntersCustomEvent.this.mAdCustomEventListener != null) {
                IntersCustomEvent.this.mAdCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (IntersCustomEvent.this.mIsFinished) {
                return;
            }
            IntersCustomEvent.this.mIsFinished = true;
            IntersCustomEvent.this.stopTimer();
            if (IntersCustomEvent.this.mAdCustomEventListener != null) {
                IntersCustomEvent.this.mAdCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (IntersCustomEvent.this.mAdCustomEventListener != null) {
                IntersCustomEvent.this.mAdCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (IntersCustomEvent.this.mAdCustomEventListener != null) {
                IntersCustomEvent.this.mAdCustomEventListener.onAdImpression();
            }
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener
        public void onAdClosed() {
            if (IntersCustomEvent.this.mAdCustomEventListener == null || !(IntersCustomEvent.this.mAdCustomEventListener instanceof ICustomEventListener)) {
                return;
            }
            ((ICustomEventListener) IntersCustomEvent.this.mAdCustomEventListener).onAdClosed();
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener
        public void onAdFailedToShow() {
            if (IntersCustomEvent.this.mAdCustomEventListener == null || !(IntersCustomEvent.this.mAdCustomEventListener instanceof ICustomEventListener)) {
                return;
            }
            ((ICustomEventListener) IntersCustomEvent.this.mAdCustomEventListener).onAdFailedToShow();
        }

        @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
        public void onPaidEvent(double d) {
            if (IntersCustomEvent.this.mAdCustomEventListener == null || !(IntersCustomEvent.this.mAdCustomEventListener instanceof ICustomEventListener)) {
                return;
            }
            ((ICustomEventListener) IntersCustomEvent.this.mAdCustomEventListener).onPaidEvent(d);
        }
    };

    public abstract void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener);

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
