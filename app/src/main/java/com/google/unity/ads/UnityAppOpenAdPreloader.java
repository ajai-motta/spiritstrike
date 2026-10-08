package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.appopen.AppOpenAdPreloader;
import com.google.android.gms.ads.preload.PreloadCallbackV2;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class UnityAppOpenAdPreloader {
    private final Activity activity;
    private final UnityPreloadCallback preloadCallback;
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    public UnityAppOpenAdPreloader(Activity activity, UnityPreloadCallback preloadCallback) {
        this.activity = activity;
        this.preloadCallback = preloadCallback;
    }

    public boolean start(String preloadId, PreloadConfiguration preloadConfiguration) {
        return AppOpenAdPreloader.start(preloadId, preloadConfiguration, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityAppOpenAdPreloader$1, reason: invalid class name */
    class AnonymousClass1 extends PreloadCallbackV2 {
        final /* synthetic */ UnityAppOpenAdPreloader this$0;

        AnonymousClass1(final UnityAppOpenAdPreloader this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdPreloaded(final String preloadId, final ResponseInfo responseInfo) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAdPreloader$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5219x829fe33c(preloadId, responseInfo);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPreloaded$0$com-google-unity-ads-UnityAppOpenAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5219x829fe33c(String str, ResponseInfo responseInfo) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdPreloaded(str, responseInfo);
            }
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdsExhausted(final String preloadId) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAdPreloader$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5220x1a884050(preloadId);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdsExhausted$0$com-google-unity-ads-UnityAppOpenAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5220x1a884050(String str) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdsExhausted(str);
            }
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdFailedToPreload(final String preloadId, final AdError adError) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.UnityAppOpenAdPreloader$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5218x518e1033(preloadId, adError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToPreload$0$com-google-unity-ads-UnityAppOpenAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5218x518e1033(String str, AdError adError) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdFailedToPreload(str, adError);
            }
        }
    }

    public boolean isAdAvailable(String preloadId) {
        return AppOpenAdPreloader.isAdAvailable(preloadId);
    }

    public int getNumAdsAvailable(String preloadId) {
        return AppOpenAdPreloader.getNumAdsAvailable(preloadId);
    }

    public UnityAppOpenAd pollAd(String preloadId, UnityAppOpenAdCallback callback) {
        AppOpenAd appOpenAdPollAd = AppOpenAdPreloader.pollAd(preloadId);
        if (appOpenAdPollAd == null) {
            return null;
        }
        UnityAppOpenAd unityAppOpenAd = new UnityAppOpenAd(this.activity, callback);
        unityAppOpenAd.setAppOpenAd(appOpenAdPollAd);
        return unityAppOpenAd;
    }

    public PreloadConfiguration getConfiguration(String preloadId) {
        return AppOpenAdPreloader.getConfiguration(preloadId);
    }

    public Map<String, PreloadConfiguration> getConfigurations() {
        return AppOpenAdPreloader.getConfigurations();
    }

    public void destroy(String preloadId) {
        AppOpenAdPreloader.destroy(preloadId);
    }

    public void destroyAll() {
        AppOpenAdPreloader.destroyAll();
    }
}
