package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.preload.PreloadCallbackV2;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdPreloader;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class UnityRewardedAdPreloader {
    private final Activity activity;
    private final UnityPreloadCallback preloadCallback;
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    public UnityRewardedAdPreloader(Activity activity, UnityPreloadCallback preloadCallback) {
        this.activity = activity;
        this.preloadCallback = preloadCallback;
    }

    public boolean start(String preloadId, PreloadConfiguration preloadConfiguration) {
        return RewardedAdPreloader.start(preloadId, preloadConfiguration, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedAdPreloader$1, reason: invalid class name */
    class AnonymousClass1 extends PreloadCallbackV2 {
        final /* synthetic */ UnityRewardedAdPreloader this$0;

        AnonymousClass1(final UnityRewardedAdPreloader this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdPreloaded(final String preloadId, final ResponseInfo responseInfo) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAdPreloader$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5249xd70e30ab(preloadId, responseInfo);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPreloaded$0$com-google-unity-ads-UnityRewardedAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5249xd70e30ab(String str, ResponseInfo responseInfo) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdPreloaded(str, responseInfo);
            }
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdsExhausted(final String preloadId) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAdPreloader$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5250x3c317617(preloadId);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdsExhausted$0$com-google-unity-ads-UnityRewardedAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5250x3c317617(String str) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdsExhausted(str);
            }
        }

        @Override // com.google.android.gms.ads.preload.PreloadCallbackV2
        public void onAdFailedToPreload(final String preloadId, final AdError adError) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.UnityRewardedAdPreloader$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5248xe5e5a294(preloadId, adError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToPreload$0$com-google-unity-ads-UnityRewardedAdPreloader$1, reason: not valid java name */
        /* synthetic */ void m5248xe5e5a294(String str, AdError adError) {
            if (this.this$0.preloadCallback != null) {
                this.this$0.preloadCallback.onAdFailedToPreload(str, adError);
            }
        }
    }

    public boolean isAdAvailable(String preloadId) {
        return RewardedAdPreloader.isAdAvailable(preloadId);
    }

    public int getNumAdsAvailable(String preloadId) {
        return RewardedAdPreloader.getNumAdsAvailable(preloadId);
    }

    public void destroy(String preloadId) {
        RewardedAdPreloader.destroy(preloadId);
    }

    public UnityRewardedAd pollAd(String preloadId, UnityRewardedAdCallback callback) {
        RewardedAd rewardedAdPollAd = RewardedAdPreloader.pollAd(preloadId);
        if (rewardedAdPollAd == null) {
            return null;
        }
        UnityRewardedAd unityRewardedAd = new UnityRewardedAd(this.activity, callback);
        unityRewardedAd.setRewardedAd(rewardedAdPollAd);
        return unityRewardedAd;
    }

    public PreloadConfiguration getConfiguration(String preloadId) {
        return RewardedAdPreloader.getConfiguration(preloadId);
    }

    public Map<String, PreloadConfiguration> getConfigurations() {
        return RewardedAdPreloader.getConfigurations();
    }

    public void destroyAll() {
        RewardedAdPreloader.destroyAll();
    }
}
