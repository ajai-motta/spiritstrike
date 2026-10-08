package com.adxcorp.ads.nativeads.adapter;

import android.content.Context;
import com.adxcorp.ads.common.CustomEvent;
import com.adxcorp.ads.common.CustomEventListener;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.nativeads.BaseNativeAd;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeCustomEvent extends CustomEvent {
    protected BaseNativeAd mBaseNativeAd;
    private CustomEventListener proxyCustomEventListener = new CustomEventListener() { // from class: com.adxcorp.ads.nativeads.adapter.NativeCustomEvent.1
        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdLoaded() {
            if (NativeCustomEvent.this.mIsFinished) {
                return;
            }
            NativeCustomEvent.this.mIsFinished = true;
            NativeCustomEvent.this.stopTimer();
            if (NativeCustomEvent.this.mAdCustomEventListener != null) {
                NativeCustomEvent.this.mAdCustomEventListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdError() {
            if (NativeCustomEvent.this.mIsFinished) {
                return;
            }
            NativeCustomEvent.this.mIsFinished = true;
            NativeCustomEvent.this.stopTimer();
            if (NativeCustomEvent.this.mAdCustomEventListener != null) {
                NativeCustomEvent.this.mAdCustomEventListener.onAdError();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdClicked() {
            if (NativeCustomEvent.this.mAdCustomEventListener != null) {
                NativeCustomEvent.this.mAdCustomEventListener.onAdClicked();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onAdImpression() {
            if (NativeCustomEvent.this.mAdCustomEventListener != null) {
                NativeCustomEvent.this.mAdCustomEventListener.onAdImpression();
            }
        }

        @Override // com.adxcorp.ads.common.CustomEventListener
        public void onPaidEvent(double d) {
            if (NativeCustomEvent.this.mAdCustomEventListener != null) {
                NativeCustomEvent.this.mAdCustomEventListener.onPaidEvent(d);
            }
        }
    };

    public interface CustomEventNativeListener {
        void onNativeAdFailed();

        void onNativeAdLoaded(BaseNativeAd baseNativeAd);
    }

    public abstract void loadAd(Context context, Map<String, String> map, CustomEventListener customEventListener);

    @Deprecated
    protected abstract void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> map, Map<String, String> map2);

    protected void onInvalidate() {
    }

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

    public BaseNativeAd getBaseNativeAd() {
        return this.mBaseNativeAd;
    }
}
