package com.google.unity.ads.decagon;

import android.app.Activity;
import android.util.Log;
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback;
import com.google.android.libraries.ads.mobile.sdk.common.AdRequest;
import com.google.android.libraries.ads.mobile.sdk.common.AdValue;
import com.google.android.libraries.ads.mobile.sdk.common.FullScreenContentError;
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError;
import com.google.android.libraries.ads.mobile.sdk.common.ResponseInfo;
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAd;
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAdEventCallback;
import com.google.unity.ads.PluginUtils;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class UnityInterstitialAd extends UnityAdBase<InterstitialAd, UnityInterstitialAdCallback> {
    private final AdWrapper<InterstitialAd> adWrapper;

    public UnityInterstitialAd(Activity activity, UnityInterstitialAdCallback callback) {
        this(activity, callback, AdWrapper.forInterstitial(), Executors.newSingleThreadExecutor());
    }

    UnityInterstitialAd(Activity activity, UnityInterstitialAdCallback callback, AdWrapper<InterstitialAd> adWrapper, Executor executor) {
        super(activity, callback, executor);
        this.adWrapper = adWrapper;
    }

    public void load(final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5312lambda$load$0$comgoogleunityadsdecagonUnityInterstitialAd(request);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$0$com-google-unity-ads-decagon-UnityInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5312lambda$load$0$comgoogleunityadsdecagonUnityInterstitialAd(AdRequest adRequest) {
        this.adWrapper.load(adRequest, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityInterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 implements AdLoadCallback<InterstitialAd> {
        final /* synthetic */ UnityInterstitialAd this$0;

        AnonymousClass1(final UnityInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onAdLoaded(InterstitialAd ad) {
            this.this$0.ad = ad;
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5315x4227a02();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-decagon-UnityInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5315x4227a02() {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onInterstitialAdLoaded();
            }
        }

        public void onAdFailedToLoad(final LoadAdError adError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5314x81505a49(adError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-decagon-UnityInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5314x81505a49(LoadAdError loadAdError) {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onInterstitialAdFailedToLoad(loadAdError);
            }
        }
    }

    public void show() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to show intertitial ad before it was ready. Please call loadAd first and wait for a successful onAdLoaded callback.");
        } else {
            ((InterstitialAd) this.ad).setAdEventCallback(new AnonymousClass2(this));
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5313lambda$show$0$comgoogleunityadsdecagonUnityInterstitialAd();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityInterstitialAd$2, reason: invalid class name */
    class AnonymousClass2 implements InterstitialAdEventCallback {
        final /* synthetic */ UnityInterstitialAd this$0;

        AnonymousClass2(final UnityInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        public void onAdShowedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5321x73080264();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdShowedFullScreenContent$0$com-google-unity-ads-decagon-UnityInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5321x73080264() {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onAdShowedFullScreenContent();
            }
        }

        public void onAdDismissedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5317x1ee22b13();
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdDismissedFullScreenContent$0$com-google-unity-ads-decagon-UnityInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5317x1ee22b13() {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onAdDismissedFullScreenContent();
            }
        }

        public void onAdFailedToShowFullScreenContent(final FullScreenContentError fullScreenContentError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5318x26f4b2bd(fullScreenContentError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-decagon-UnityInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5318x26f4b2bd(FullScreenContentError fullScreenContentError) {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onAdFailedToShowFullScreenContent(fullScreenContentError);
            }
        }

        public void onAdImpression() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$2$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5319xcb05b9ff();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-decagon-UnityInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5319xcb05b9ff() {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onAdImpression();
            }
        }

        public void onAdClicked() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5316xcaa5b87f();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-decagon-UnityInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5316xcaa5b87f() {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onAdClicked();
            }
        }

        public void onAdPaid(final AdValue adValue) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityInterstitialAd$2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5320xad4c59dc(adValue);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPaid$0$com-google-unity-ads-decagon-UnityInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5320xad4c59dc(AdValue adValue) {
            if (this.this$0.callback != 0) {
                ((UnityInterstitialAdCallback) this.this$0.callback).onPaidEvent(adValue.getPrecisionType().ordinal(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-google-unity-ads-decagon-UnityInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5313lambda$show$0$comgoogleunityadsdecagonUnityInterstitialAd() {
        ((InterstitialAd) this.ad).setImmersiveMode(true);
        ((InterstitialAd) this.ad).show(this.activity);
    }

    public long getPlacementId() {
        if (this.ad == 0) {
            return 0L;
        }
        return ((InterstitialAd) this.ad).getPlacementId();
    }

    public void setPlacementId(long placementId) {
        if (this.ad == 0) {
            return;
        }
        ((InterstitialAd) this.ad).setPlacementId(placementId);
    }

    public ResponseInfo getResponseInfo() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return ((InterstitialAd) this.ad).getResponseInfo();
    }
}
