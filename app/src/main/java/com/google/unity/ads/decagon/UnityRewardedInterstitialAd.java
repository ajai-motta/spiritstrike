package com.google.unity.ads.decagon;

import android.app.Activity;
import android.util.Log;
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback;
import com.google.android.libraries.ads.mobile.sdk.common.AdRequest;
import com.google.android.libraries.ads.mobile.sdk.common.AdValue;
import com.google.android.libraries.ads.mobile.sdk.common.FullScreenContentError;
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError;
import com.google.android.libraries.ads.mobile.sdk.common.ResponseInfo;
import com.google.android.libraries.ads.mobile.sdk.rewarded.OnUserEarnedRewardListener;
import com.google.android.libraries.ads.mobile.sdk.rewarded.RewardItem;
import com.google.android.libraries.ads.mobile.sdk.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.libraries.ads.mobile.sdk.rewardedinterstitial.RewardedInterstitialAdEventCallback;
import com.google.unity.ads.PluginUtils;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class UnityRewardedInterstitialAd extends UnityAdBase<RewardedInterstitialAd, UnityRewardedInterstitialAdCallback> {
    private final AdWrapper<RewardedInterstitialAd> adWrapper;

    public UnityRewardedInterstitialAd(Activity activity, UnityRewardedInterstitialAdCallback callback) {
        this(activity, callback, AdWrapper.forRewardedInterstitial(), Executors.newSingleThreadExecutor());
    }

    UnityRewardedInterstitialAd(Activity activity, UnityRewardedInterstitialAdCallback callback, AdWrapper<RewardedInterstitialAd> adWrapper, Executor executor) {
        super(activity, callback, executor);
        this.adWrapper = adWrapper;
    }

    public void load(final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5333x80aa1f64(request);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5333x80aa1f64(AdRequest adRequest) {
        this.adWrapper.load(adRequest, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 implements AdLoadCallback<RewardedInterstitialAd> {
        final /* synthetic */ UnityRewardedInterstitialAd this$0;

        AnonymousClass1(final UnityRewardedInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onAdLoaded(RewardedInterstitialAd rewardedInterstitialAd) {
            this.this$0.ad = rewardedInterstitialAd;
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5336x883f0830();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5336x883f0830() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onRewardedInterstitialAdLoaded();
            }
        }

        public void onAdFailedToLoad(final LoadAdError adError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5335x8887b177(adError);
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5335x8887b177(LoadAdError loadAdError) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onRewardedInterstitialAdFailedToLoad(loadAdError);
            }
        }
    }

    public void show() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to show rewarded interstitial ad before it was ready. Please call load first and wait for a successful onAdLoaded callback.");
        } else {
            ((RewardedInterstitialAd) this.ad).setAdEventCallback(new AnonymousClass2(this));
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5334xc0988eed();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2, reason: invalid class name */
    class AnonymousClass2 implements RewardedInterstitialAdEventCallback {
        final /* synthetic */ UnityRewardedInterstitialAd this$0;

        AnonymousClass2(final UnityRewardedInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        public void onAdShowedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5342xcb0a9f92();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdShowedFullScreenContent$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5342xcb0a9f92() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onAdShowedFullScreenContent();
            }
        }

        public void onAdDismissedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5338x904a941();
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdDismissedFullScreenContent$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5338x904a941() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onAdDismissedFullScreenContent();
            }
        }

        public void onAdFailedToShowFullScreenContent(final FullScreenContentError fullScreenContentError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5339x6b11e6eb(fullScreenContentError);
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5339x6b11e6eb(FullScreenContentError fullScreenContentError) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onAdFailedToShowFullScreenContent(fullScreenContentError);
            }
        }

        public void onAdImpression() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5340x86d08c2d();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5340x86d08c2d() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onAdImpression();
            }
        }

        public void onAdClicked() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5337x7fca0aad();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5337x7fca0aad() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onAdClicked();
            }
        }

        public void onAdPaid(final AdValue adValue) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5341x431bff0a(adValue);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPaid$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5341x431bff0a(AdValue adValue) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onPaidEvent(adValue.getPrecisionType().ordinal(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5334xc0988eed() {
        ((RewardedInterstitialAd) this.ad).setImmersiveMode(true);
        ((RewardedInterstitialAd) this.ad).show(this.activity, new AnonymousClass3(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$3, reason: invalid class name */
    class AnonymousClass3 implements OnUserEarnedRewardListener {
        final /* synthetic */ UnityRewardedInterstitialAd this$0;

        AnonymousClass3(final UnityRewardedInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        public void onUserEarnedReward(final RewardItem rewardItem) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedInterstitialAd$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5343x2e1836e9(rewardItem);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onUserEarnedReward$0$com-google-unity-ads-decagon-UnityRewardedInterstitialAd$3, reason: not valid java name */
        /* synthetic */ void m5343x2e1836e9(RewardItem rewardItem) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedInterstitialAdCallback) this.this$0.callback).onUserEarnedReward(rewardItem.getType(), rewardItem.getAmount());
            }
        }
    }

    public long getPlacementId() {
        if (this.ad == 0) {
            return 0L;
        }
        return ((RewardedInterstitialAd) this.ad).getPlacementId();
    }

    public void setPlacementId(long placementId) {
        if (this.ad == 0) {
            return;
        }
        ((RewardedInterstitialAd) this.ad).setPlacementId(placementId);
    }

    public ResponseInfo getResponseInfo() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return ((RewardedInterstitialAd) this.ad).getResponseInfo();
    }
}
