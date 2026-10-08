package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdPreloader;
import com.google.android.gms.ads.preload.PreloadCallbackV2;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class UnityInterstitialAdPreloader {
    private final Activity activity;
    private final UnityPreloadCallback preloadCallback;

    public UnityInterstitialAdPreloader(Activity activity, UnityPreloadCallback preloadCallback) {
        this.activity = activity;
        this.preloadCallback = preloadCallback;
    }

    public boolean start(String preloadId, PreloadConfiguration preloadConfiguration) {
        return InterstitialAdPreloader.start(preloadId, preloadConfiguration, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityInterstitialAdPreloader$1, reason: invalid class name */
    class AnonymousClass1 extends PreloadCallbackV2 {
        final /* synthetic */ UnityInterstitialAdPreloader this$0;

        AnonymousClass1(final UnityInterstitialAdPreloader this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdPreloaded(final String preloadId, final ResponseInfo responseInfo) {
            this.this$0.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityInterstitialAdPreloader$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5224xfd2291cd(preloadId, responseInfo);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPreloaded$0$com-google-unity-ads-UnityInterstitialAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5224xfd2291cd(String str, ResponseInfo responseInfo) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdPreloaded(str, responseInfo);
            }
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdsExhausted(final String preloadId) {
            this.this$0.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityInterstitialAdPreloader$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5225xeb0d4139(preloadId);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdsExhausted$0$com-google-unity-ads-UnityInterstitialAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5225xeb0d4139(String str) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdsExhausted(str);
            }
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdFailedToPreload(final String preloadId, final AdError adError) {
            this.this$0.runOnNewThread(new Runnable() { // from class: com.google.unity.ads.UnityInterstitialAdPreloader$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5223xdace736(preloadId, adError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToPreload$0$com-google-unity-ads-UnityInterstitialAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5223xdace736(String str, AdError adError) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdFailedToPreload(str, adError);
            }
        }
    }

    public boolean isAdAvailable(String preloadId) {
        return InterstitialAdPreloader.isAdAvailable(preloadId);
    }

    public int getNumAdsAvailable(String preloadId) {
        return InterstitialAdPreloader.getNumAdsAvailable(preloadId);
    }

    public void destroy(String preloadId) {
        InterstitialAdPreloader.destroy(preloadId);
    }

    public Interstitial pollAd(String preloadId, UnityInterstitialAdCallback callback) {
        InterstitialAd interstitialAdPollAd = InterstitialAdPreloader.pollAd(preloadId);
        if (interstitialAdPollAd == null) {
            return null;
        }
        Interstitial interstitial = new Interstitial(this.activity, callback);
        interstitial.setInterstitialAd(interstitialAdPollAd);
        return interstitial;
    }

    public PreloadConfiguration getConfiguration(String preloadId) {
        return InterstitialAdPreloader.getConfiguration(preloadId);
    }

    public Map<String, PreloadConfiguration> getConfigurations() {
        return InterstitialAdPreloader.getConfigurations();
    }

    public void destroyAll() {
        InterstitialAdPreloader.destroyAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnNewThread(final Runnable action) {
        new Thread(action).start();
    }
}
