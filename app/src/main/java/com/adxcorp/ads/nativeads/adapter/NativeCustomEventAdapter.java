package com.adxcorp.ads.nativeads.adapter;

import android.content.Context;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.nativeads.BaseNativeAd;
import com.adxcorp.ads.nativeads.adapter.NativeCustomEvent;
import com.adxcorp.ads.nativeads.util.ReflectionUtil;
import com.adxcorp.util.ADXLogUtil;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCustomEventAdapter {
    private final String TAG = "NativeCustomEventAdapter";
    private NativeCustomEvent.CustomEventNativeListener mExternalListener;
    private boolean mIsFinished;
    private Timer mTimer;
    private NativeCustomEvent nativeCustomEvent;

    public NativeCustomEventAdapter(NativeCustomEvent.CustomEventNativeListener customEventNativeListener) {
        this.mExternalListener = customEventNativeListener;
    }

    public void loadNative(Context context, String str, Map<String, Object> map, Map<String, String> map2, long j, MediationData mediationData) {
        try {
            this.nativeCustomEvent = ReflectionUtil.create(str);
            this.mIsFinished = false;
            stopTimer();
            startTimer(j);
            this.nativeCustomEvent.loadNativeAd(context, createListener(), map, map2);
        } catch (Exception e) {
            e.printStackTrace();
            ADXLogUtil.d(this.TAG, "Not found Adapter : " + str);
            this.mExternalListener.onNativeAdFailed();
        }
    }

    private NativeCustomEvent.CustomEventNativeListener createListener() {
        return new NativeCustomEvent.CustomEventNativeListener() { // from class: com.adxcorp.ads.nativeads.adapter.NativeCustomEventAdapter.1
            @Override // com.adxcorp.ads.nativeads.adapter.NativeCustomEvent.CustomEventNativeListener
            public void onNativeAdLoaded(BaseNativeAd baseNativeAd) {
                if (NativeCustomEventAdapter.this.mIsFinished) {
                    return;
                }
                ADXLogUtil.d(NativeCustomEventAdapter.this.TAG, "onNativeAdLoaded");
                NativeCustomEventAdapter.this.stopTimer();
                NativeCustomEventAdapter.this.invalidate();
                NativeCustomEventAdapter.this.mExternalListener.onNativeAdLoaded(baseNativeAd);
            }

            @Override // com.adxcorp.ads.nativeads.adapter.NativeCustomEvent.CustomEventNativeListener
            public void onNativeAdFailed() {
                if (NativeCustomEventAdapter.this.mIsFinished) {
                    return;
                }
                ADXLogUtil.d(NativeCustomEventAdapter.this.TAG, "onNativeAdFailed");
                NativeCustomEventAdapter.this.stopTimer();
                NativeCustomEventAdapter.this.invalidate();
                NativeCustomEventAdapter.this.mExternalListener.onNativeAdFailed();
            }
        };
    }

    public void stopLoading() {
        stopTimer();
        try {
            NativeCustomEvent nativeCustomEvent = this.nativeCustomEvent;
            if (nativeCustomEvent != null && this.mIsFinished) {
                nativeCustomEvent.onInvalidate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void invalidate() {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            NativeCustomEvent nativeCustomEvent = this.nativeCustomEvent;
            if (nativeCustomEvent != null) {
                try {
                    nativeCustomEvent.onInvalidate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.nativeCustomEvent = null;
            }
        }
    }

    private void startTimer(long j) {
        this.mTimer = new Timer();
        this.mTimer.schedule(new AdCheckTimerTask(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    class AdCheckTimerTask extends TimerTask {
        AdCheckTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (NativeCustomEventAdapter.this.mIsFinished) {
                return;
            }
            NativeCustomEventAdapter.this.mIsFinished = true;
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(NativeCustomEventAdapter.this.TAG, "CustomEvent loading time is delayed.");
            }
            NativeCustomEventAdapter.this.stopLoading();
            NativeCustomEventAdapter.this.mExternalListener.onNativeAdFailed();
        }
    }
}
