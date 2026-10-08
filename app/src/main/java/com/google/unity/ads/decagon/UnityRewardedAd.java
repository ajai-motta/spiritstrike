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
import com.google.android.libraries.ads.mobile.sdk.rewarded.RewardedAd;
import com.google.android.libraries.ads.mobile.sdk.rewarded.RewardedAdEventCallback;
import com.google.unity.ads.PluginUtils;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class UnityRewardedAd extends UnityAdBase<RewardedAd, UnityRewardedAdCallback> {
    private final AdWrapper<RewardedAd> adWrapper;

    public UnityRewardedAd(Activity activity, UnityRewardedAdCallback callback) {
        this(activity, callback, AdWrapper.forRewarded(), Executors.newSingleThreadExecutor());
    }

    UnityRewardedAd(Activity activity, UnityRewardedAdCallback callback, AdWrapper<RewardedAd> adWrapper, Executor executor) {
        super(activity, callback, executor);
        this.adWrapper = adWrapper;
    }

    public void load(final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5322lambda$load$0$comgoogleunityadsdecagonUnityRewardedAd(request);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$0$com-google-unity-ads-decagon-UnityRewardedAd, reason: not valid java name */
    /* synthetic */ void m5322lambda$load$0$comgoogleunityadsdecagonUnityRewardedAd(AdRequest adRequest) {
        this.adWrapper.load(adRequest, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityRewardedAd$1, reason: invalid class name */
    class AnonymousClass1 implements AdLoadCallback<RewardedAd> {
        final /* synthetic */ UnityRewardedAd this$0;

        AnonymousClass1(final UnityRewardedAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onAdLoaded(RewardedAd rewardedAd) {
            this.this$0.ad = rewardedAd;
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5325x85e970e4();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-decagon-UnityRewardedAd$1, reason: not valid java name */
        /* synthetic */ void m5325x85e970e4() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onRewardedAdLoaded();
            }
        }

        public void onAdFailedToLoad(final LoadAdError adError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5324x33288cab(adError);
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-decagon-UnityRewardedAd$1, reason: not valid java name */
        /* synthetic */ void m5324x33288cab(LoadAdError loadAdError) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onRewardedAdFailedToLoad(loadAdError);
            }
        }
    }

    public void show() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to show rewarded ad before it was ready. Please call load first and wait for a successful onAdLoaded callback.");
        } else {
            ((RewardedAd) this.ad).setAdEventCallback(new AnonymousClass2(this));
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5323lambda$show$0$comgoogleunityadsdecagonUnityRewardedAd();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityRewardedAd$2, reason: invalid class name */
    class AnonymousClass2 implements RewardedAdEventCallback {
        final /* synthetic */ UnityRewardedAd this$0;

        AnonymousClass2(final UnityRewardedAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        public void onAdShowedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5331x5cdc51c6();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdShowedFullScreenContent$0$com-google-unity-ads-decagon-UnityRewardedAd$2, reason: not valid java name */
        /* synthetic */ void m5331x5cdc51c6() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onAdShowedFullScreenContent();
            }
        }

        public void onAdDismissedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5327x31cc29f5();
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdDismissedFullScreenContent$0$com-google-unity-ads-decagon-UnityRewardedAd$2, reason: not valid java name */
        /* synthetic */ void m5327x31cc29f5() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onAdDismissedFullScreenContent();
            }
        }

        public void onAdFailedToShowFullScreenContent(final FullScreenContentError fullScreenContentError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$2$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5328x98d9169f(fullScreenContentError);
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-decagon-UnityRewardedAd$2, reason: not valid java name */
        /* synthetic */ void m5328x98d9169f(FullScreenContentError fullScreenContentError) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onAdFailedToShowFullScreenContent(fullScreenContentError);
            }
        }

        public void onAdImpression() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5329xf7840ee1();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-decagon-UnityRewardedAd$2, reason: not valid java name */
        /* synthetic */ void m5329xf7840ee1() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onAdImpression();
            }
        }

        public void onAdClicked() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5326x6fe74d61();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-decagon-UnityRewardedAd$2, reason: not valid java name */
        /* synthetic */ void m5326x6fe74d61() {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onAdClicked();
            }
        }

        public void onAdPaid(final AdValue adValue) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5330lambda$onAdPaid$0$comgoogleunityadsdecagonUnityRewardedAd$2(adValue);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPaid$0$com-google-unity-ads-decagon-UnityRewardedAd$2, reason: not valid java name */
        /* synthetic */ void m5330lambda$onAdPaid$0$comgoogleunityadsdecagonUnityRewardedAd$2(AdValue adValue) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onPaidEvent(adValue.getPrecisionType().ordinal(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-google-unity-ads-decagon-UnityRewardedAd, reason: not valid java name */
    /* synthetic */ void m5323lambda$show$0$comgoogleunityadsdecagonUnityRewardedAd() {
        ((RewardedAd) this.ad).setImmersiveMode(true);
        ((RewardedAd) this.ad).show(this.activity, new AnonymousClass3(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityRewardedAd$3, reason: invalid class name */
    class AnonymousClass3 implements OnUserEarnedRewardListener {
        final /* synthetic */ UnityRewardedAd this$0;

        AnonymousClass3(final UnityRewardedAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        public void onUserEarnedReward(final RewardItem rewardItem) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityRewardedAd$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5332x14c1ba1d(rewardItem);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onUserEarnedReward$0$com-google-unity-ads-decagon-UnityRewardedAd$3, reason: not valid java name */
        /* synthetic */ void m5332x14c1ba1d(RewardItem rewardItem) {
            if (this.this$0.callback != 0) {
                ((UnityRewardedAdCallback) this.this$0.callback).onUserEarnedReward(rewardItem.getType(), rewardItem.getAmount());
            }
        }
    }

    public long getPlacementId() {
        if (this.ad == 0) {
            return 0L;
        }
        return ((RewardedAd) this.ad).getPlacementId();
    }

    public void setPlacementId(long placementId) {
        if (this.ad == 0) {
            return;
        }
        ((RewardedAd) this.ad).setPlacementId(placementId);
    }

    public ResponseInfo getResponseInfo() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return ((RewardedAd) this.ad).getResponseInfo();
    }
}
