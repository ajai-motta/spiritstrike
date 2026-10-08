package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class UnityRewardedInterstitialAd {
    private Activity activity;
    private UnityRewardedInterstitialAdCallback callback;
    private RewardedInterstitialAd rewardedInterstitialAd;

    public void destroy() {
    }

    public UnityRewardedInterstitialAd(Activity activity, UnityRewardedInterstitialAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedInterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ UnityRewardedInterstitialAd this$0;
        final /* synthetic */ String val$adUnitId;
        final /* synthetic */ AdRequest val$request;

        AnonymousClass1(final UnityRewardedInterstitialAd this$0, final String val$adUnitId, final AdRequest val$request) {
            this.val$adUnitId = val$adUnitId;
            this.val$request = val$request;
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardedInterstitialAd.load(this.this$0.activity, this.val$adUnitId, this.val$request, new C03401(this));
        }

        /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedInterstitialAd$1$1, reason: invalid class name and collision with other inner class name */
        class C03401 extends RewardedInterstitialAdLoadCallback {
            final /* synthetic */ AnonymousClass1 this$1;

            C03401(final AnonymousClass1 this$1) {
                Objects.requireNonNull(this$1);
                this.this$1 = this$1;
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedInterstitialAd ad) {
                this.this$1.this$0.rewardedInterstitialAd = ad;
                this.this$1.this$0.rewardedInterstitialAd.setOnPaidEventListener(new OnPaidEventListener(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.1
                    final /* synthetic */ C03401 this$2;

                    {
                        Objects.requireNonNull(this);
                        this.this$2 = this;
                    }

                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(final AdValue adValue) {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.1.1
                            final /* synthetic */ C03411 this$3;

                            {
                                Objects.requireNonNull(this);
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.this$3.this$2.this$1.this$0.callback != null) {
                                    this.this$3.this$2.this$1.this$0.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
                                }
                            }
                        }).start();
                    }
                });
                this.this$1.this$0.rewardedInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2
                    final /* synthetic */ C03401 this$2;

                    {
                        Objects.requireNonNull(this);
                        this.this$2 = this;
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(final AdError error) {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.1
                            final /* synthetic */ AnonymousClass2 this$3;

                            {
                                Objects.requireNonNull(this);
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.this$3.this$2.this$1.this$0.callback != null) {
                                    this.this$3.this$2.this$1.this$0.callback.onAdFailedToShowFullScreenContent(error);
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.2
                            final /* synthetic */ AnonymousClass2 this$3;

                            {
                                Objects.requireNonNull(this);
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.this$3.this$2.this$1.this$0.callback != null) {
                                    this.this$3.this$2.this$1.this$0.callback.onAdShowedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.3
                            final /* synthetic */ AnonymousClass2 this$3;

                            {
                                Objects.requireNonNull(this);
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.this$3.this$2.this$1.this$0.callback != null) {
                                    this.this$3.this$2.this$1.this$0.callback.onAdDismissedFullScreenContent();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.4
                            final /* synthetic */ AnonymousClass2 this$3;

                            {
                                Objects.requireNonNull(this);
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.this$3.this$2.this$1.this$0.callback != null) {
                                    this.this$3.this$2.this$1.this$0.callback.onAdImpression();
                                }
                            }
                        }).start();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.2.5
                            final /* synthetic */ AnonymousClass2 this$3;

                            {
                                Objects.requireNonNull(this);
                                this.this$3 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (this.this$3.this$2.this$1.this$0.callback != null) {
                                    this.this$3.this$2.this$1.this$0.callback.onAdClicked();
                                }
                            }
                        }).start();
                    }
                });
                new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.3
                    final /* synthetic */ C03401 this$2;

                    {
                        Objects.requireNonNull(this);
                        this.this$2 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.this$2.this$1.this$0.callback != null) {
                            this.this$2.this$1.this$0.callback.onRewardedInterstitialAdLoaded();
                        }
                    }
                }).start();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(final LoadAdError error) {
                new Thread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.1.1.4
                    final /* synthetic */ C03401 this$2;

                    {
                        Objects.requireNonNull(this);
                        this.this$2 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.this$2.this$1.this$0.callback != null) {
                            this.this$2.this$1.this$0.callback.onRewardedInterstitialAdFailedToLoad(error);
                        }
                    }
                }).start();
            }
        }
    }

    public void loadAd(final String adUnitId, final AdRequest request) {
        this.activity.runOnUiThread(new AnonymousClass1(this, adUnitId, request));
    }

    public void show() {
        if (this.rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show rewarded interstitial ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.2
                final /* synthetic */ UnityRewardedInterstitialAd this$0;

                {
                    Objects.requireNonNull(this);
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.this$0.rewardedInterstitialAd.setImmersiveMode(true);
                    this.this$0.rewardedInterstitialAd.show(this.this$0.activity, new AnonymousClass1(this));
                }

                /* JADX INFO: renamed from: com.google.unity.ads.UnityRewardedInterstitialAd$2$1, reason: invalid class name */
                class AnonymousClass1 implements OnUserEarnedRewardListener {
                    final /* synthetic */ AnonymousClass2 this$1;

                    AnonymousClass1(final AnonymousClass2 this$1) {
                        Objects.requireNonNull(this$1);
                        this.this$1 = this$1;
                    }

                    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                    public void onUserEarnedReward(final RewardItem rewardItem) {
                        new Thread(new Runnable() { // from class: com.google.unity.ads.UnityRewardedInterstitialAd$2$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m5255x233e95bb(rewardItem);
                            }
                        }).start();
                    }

                    /* JADX INFO: renamed from: lambda$onUserEarnedReward$0$com-google-unity-ads-UnityRewardedInterstitialAd$2$1, reason: not valid java name */
                    /* synthetic */ void m5255x233e95bb(RewardItem rewardItem) {
                        if (this.this$1.this$0.callback != null) {
                            this.this$1.this$0.callback.onUserEarnedReward(rewardItem.getType(), rewardItem.getAmount());
                        }
                    }
                }
            });
        }
    }

    public long getPlacementId() {
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd == null) {
            return 0L;
        }
        return rewardedInterstitialAd.getPlacementId();
    }

    public void setPlacementId(long placementId) {
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd == null) {
            return;
        }
        rewardedInterstitialAd.setPlacementId(placementId);
    }

    public void setServerSideVerificationOptions(final ServerSideVerificationOptions serverSideVerificationOptions) {
        if (this.rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to set server side verification before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.3
                final /* synthetic */ UnityRewardedInterstitialAd this$0;

                {
                    Objects.requireNonNull(this);
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.this$0.rewardedInterstitialAd.setServerSideVerificationOptions(serverSideVerificationOptions);
                }
            });
        }
    }

    public String getAdUnitId() {
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd == null) {
            return null;
        }
        return rewardedInterstitialAd.getAdUnitId();
    }

    public ResponseInfo getResponseInfo() {
        RewardedInterstitialAd rewardedInterstitialAd = this.rewardedInterstitialAd;
        if (rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return rewardedInterstitialAd.getResponseInfo();
    }

    public RewardItem getRewardItem() {
        if (this.rewardedInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to get reward item before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
            return null;
        }
        FutureTask futureTask = new FutureTask(new Callable<RewardItem>(this) { // from class: com.google.unity.ads.UnityRewardedInterstitialAd.4
            final /* synthetic */ UnityRewardedInterstitialAd this$0;

            {
                Objects.requireNonNull(this);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RewardItem call() {
                return this.this$0.rewardedInterstitialAd.getRewardItem();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (RewardItem) futureTask.get();
        } catch (InterruptedException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to get reward item: %s", e.getLocalizedMessage()));
            return null;
        } catch (ExecutionException e2) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to get reward item: %s", e2.getLocalizedMessage()));
            return null;
        }
    }
}
