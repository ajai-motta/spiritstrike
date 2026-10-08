package com.google.unity.ads;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class Interstitial {
    private final Activity activity;
    private final UnityInterstitialAdCallback callback;
    private InterstitialAd interstitialAd;
    private final FullScreenContentCallback fullScreenContentCallback = new AnonymousClass1(this);
    private final OnPaidEventListener onPaidEventListener = new AnonymousClass2(this);

    public void destroy() {
    }

    /* JADX INFO: renamed from: com.google.unity.ads.Interstitial$1, reason: invalid class name */
    class AnonymousClass1 extends FullScreenContentCallback {
        final /* synthetic */ Interstitial this$0;

        AnonymousClass1(final Interstitial this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(final AdError error) {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5193xee32b728(error);
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-Interstitial$1, reason: not valid java name */
        /* synthetic */ void m5193xee32b728(AdError adError) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdFailedToShowFullScreenContent(adError);
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5195x9404ee61();
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdShowedFullScreenContent$0$com-google-unity-ads-Interstitial$1, reason: not valid java name */
        /* synthetic */ void m5195x9404ee61() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdShowedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5192x35aa5d92();
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdDismissedFullScreenContent$0$com-google-unity-ads-Interstitial$1, reason: not valid java name */
        /* synthetic */ void m5192x35aa5d92() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdDismissedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5194lambda$onAdImpression$0$comgoogleunityadsInterstitial$1();
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-Interstitial$1, reason: not valid java name */
        /* synthetic */ void m5194lambda$onAdImpression$0$comgoogleunityadsInterstitial$1() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdImpression();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5191lambda$onAdClicked$0$comgoogleunityadsInterstitial$1();
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-Interstitial$1, reason: not valid java name */
        /* synthetic */ void m5191lambda$onAdClicked$0$comgoogleunityadsInterstitial$1() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdClicked();
            }
        }
    }

    public Interstitial(Activity activity, UnityInterstitialAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void setInterstitialAd(InterstitialAd interstitialAd) {
        this.interstitialAd = interstitialAd;
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5189lambda$setInterstitialAd$0$comgoogleunityadsInterstitial();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setInterstitialAd$0$com-google-unity-ads-Interstitial, reason: not valid java name */
    /* synthetic */ void m5189lambda$setInterstitialAd$0$comgoogleunityadsInterstitial() {
        this.interstitialAd.setOnPaidEventListener(this.onPaidEventListener);
        this.interstitialAd.setFullScreenContentCallback(this.fullScreenContentCallback);
    }

    /* JADX INFO: renamed from: com.google.unity.ads.Interstitial$2, reason: invalid class name */
    class AnonymousClass2 implements OnPaidEventListener {
        final /* synthetic */ Interstitial this$0;

        AnonymousClass2(final Interstitial this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5196lambda$onPaidEvent$0$comgoogleunityadsInterstitial$2(adValue);
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onPaidEvent$0$com-google-unity-ads-Interstitial$2, reason: not valid java name */
        /* synthetic */ void m5196lambda$onPaidEvent$0$comgoogleunityadsInterstitial$2(AdValue adValue) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    public void loadAd(final String adUnitId, final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5186lambda$loadAd$0$comgoogleunityadsInterstitial(adUnitId, request);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$loadAd$0$com-google-unity-ads-Interstitial, reason: not valid java name */
    /* synthetic */ void m5186lambda$loadAd$0$comgoogleunityadsInterstitial(String str, AdRequest adRequest) {
        InterstitialAd.load(this.activity, str, adRequest, new AnonymousClass3(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.Interstitial$3, reason: invalid class name */
    class AnonymousClass3 extends InterstitialAdLoadCallback {
        final /* synthetic */ Interstitial this$0;

        AnonymousClass3(final Interstitial this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(InterstitialAd ad) {
            this.this$0.interstitialAd = ad;
            this.this$0.interstitialAd.setOnPaidEventListener(this.this$0.onPaidEventListener);
            this.this$0.interstitialAd.setFullScreenContentCallback(this.this$0.fullScreenContentCallback);
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5198lambda$onAdLoaded$0$comgoogleunityadsInterstitial$3();
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-Interstitial$3, reason: not valid java name */
        /* synthetic */ void m5198lambda$onAdLoaded$0$comgoogleunityadsInterstitial$3() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onInterstitialAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(final LoadAdError error) {
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5197lambda$onAdFailedToLoad$0$comgoogleunityadsInterstitial$3(error);
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-Interstitial$3, reason: not valid java name */
        /* synthetic */ void m5197lambda$onAdFailedToLoad$0$comgoogleunityadsInterstitial$3(LoadAdError loadAdError) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onInterstitialAdFailedToLoad(loadAdError);
            }
        }
    }

    public boolean isAdAvailable(String adUnitId) {
        return InterstitialAd.isAdAvailable(this.activity, adUnitId);
    }

    public void pollAd(String adUnitId) {
        InterstitialAd interstitialAdPollAd = InterstitialAd.pollAd(this.activity, adUnitId);
        this.interstitialAd = interstitialAdPollAd;
        if (interstitialAdPollAd == null) {
            Log.e(PluginUtils.LOGTAG, "Failed to obtain an Interstitial Ad from the preloader.");
            final LoadAdError loadAdError = new LoadAdError(0, "Failed to obtain an Interstitial Ad from the preloader.", MobileAds.ERROR_DOMAIN, null, null);
            new Thread(new Runnable() { // from class: com.google.unity.ads.Interstitial$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5187lambda$pollAd$0$comgoogleunityadsInterstitial(loadAdError);
                }
            }).start();
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5188lambda$pollAd$1$comgoogleunityadsInterstitial();
                }
            });
            this.interstitialAd.setFullScreenContentCallback(this.fullScreenContentCallback);
            UnityInterstitialAdCallback unityInterstitialAdCallback = this.callback;
            if (unityInterstitialAdCallback != null) {
                unityInterstitialAdCallback.onInterstitialAdLoaded();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$pollAd$0$com-google-unity-ads-Interstitial, reason: not valid java name */
    /* synthetic */ void m5187lambda$pollAd$0$comgoogleunityadsInterstitial(LoadAdError loadAdError) {
        UnityInterstitialAdCallback unityInterstitialAdCallback = this.callback;
        if (unityInterstitialAdCallback != null) {
            unityInterstitialAdCallback.onInterstitialAdFailedToLoad(loadAdError);
        }
    }

    /* JADX INFO: renamed from: lambda$pollAd$1$com-google-unity-ads-Interstitial, reason: not valid java name */
    /* synthetic */ void m5188lambda$pollAd$1$comgoogleunityadsInterstitial() {
        this.interstitialAd.setOnPaidEventListener(this.onPaidEventListener);
    }

    public long getPlacementId() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null) {
            return 0L;
        }
        return interstitialAd.getPlacementId();
    }

    public void setPlacementId(long placementId) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null) {
            return;
        }
        interstitialAd.setPlacementId(placementId);
    }

    public String getAdUnitId() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null) {
            return null;
        }
        return interstitialAd.getAdUnitId();
    }

    public ResponseInfo getResponseInfo() {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return interstitialAd.getResponseInfo();
    }

    public void show() {
        if (this.interstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show interstitial ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.Interstitial$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5190lambda$show$0$comgoogleunityadsInterstitial();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-google-unity-ads-Interstitial, reason: not valid java name */
    /* synthetic */ void m5190lambda$show$0$comgoogleunityadsInterstitial() {
        this.interstitialAd.setImmersiveMode(true);
        this.interstitialAd.show(this.activity);
    }
}
