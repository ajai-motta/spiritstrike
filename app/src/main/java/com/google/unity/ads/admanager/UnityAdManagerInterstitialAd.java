package com.google.unity.ads.admanager;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.unity.ads.PluginUtils;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class UnityAdManagerInterstitialAd {
    private final Activity activity;
    private AdManagerInterstitialAd adManagerInterstitialAd;
    private final UnityAdManagerInterstitialAdCallback callback;
    private final ExecutorService service = Executors.newSingleThreadExecutor();
    private final FullScreenContentCallback fullScreenContentCallback = new AnonymousClass1(this);
    private final OnPaidEventListener onPaidEventListener = new AnonymousClass2(this);
    private final AppEventListener appEventListener = new AnonymousClass3(this);

    public void destroy() {
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$1, reason: invalid class name */
    class AnonymousClass1 extends FullScreenContentCallback {
        final /* synthetic */ UnityAdManagerInterstitialAd this$0;

        AnonymousClass1(final UnityAdManagerInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(final AdError error) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5281x45742723(error);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5281x45742723(AdError adError) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdFailedToShowFullScreenContent(adError);
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5283x966c591c();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdShowedFullScreenContent$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5283x966c591c() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdShowedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5280xe2993d0d();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdDismissedFullScreenContent$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5280xe2993d0d() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdDismissedFullScreenContent();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdImpression() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5282xf41562a1();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5282xf41562a1() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdImpression();
            }
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdClicked() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5279x65fd5421();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$1, reason: not valid java name */
        /* synthetic */ void m5279x65fd5421() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAdClicked();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$2, reason: invalid class name */
    class AnonymousClass2 implements OnPaidEventListener {
        final /* synthetic */ UnityAdManagerInterstitialAd this$0;

        AnonymousClass2(final UnityAdManagerInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5284x981544cc(adValue);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onPaidEvent$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$2, reason: not valid java name */
        /* synthetic */ void m5284x981544cc(AdValue adValue) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$3, reason: invalid class name */
    class AnonymousClass3 implements AppEventListener {
        final /* synthetic */ UnityAdManagerInterstitialAd this$0;

        AnonymousClass3(final UnityAdManagerInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.admanager.AppEventListener
        public void onAppEvent(final String name, final String data) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5285xe2ea2310(name, data);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAppEvent$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$3, reason: not valid java name */
        /* synthetic */ void m5285xe2ea2310(String str, String str2) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onAppEvent(str, str2);
            }
        }
    }

    public UnityAdManagerInterstitialAd(Activity activity, UnityAdManagerInterstitialAdCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void loadAd(final String adUnitId, final AdManagerAdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5276x872d7532(adUnitId, request);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$loadAd$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5276x872d7532(String str, AdManagerAdRequest adManagerAdRequest) {
        AdManagerInterstitialAd.load(this.activity, str, adManagerAdRequest, new AnonymousClass4(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$4, reason: invalid class name */
    class AnonymousClass4 extends AdManagerInterstitialAdLoadCallback {
        final /* synthetic */ UnityAdManagerInterstitialAd this$0;

        AnonymousClass4(final UnityAdManagerInterstitialAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(AdManagerInterstitialAd ad) {
            this.this$0.adManagerInterstitialAd = ad;
            this.this$0.adManagerInterstitialAd.setOnPaidEventListener(this.this$0.onPaidEventListener);
            this.this$0.adManagerInterstitialAd.setAppEventListener(this.this$0.appEventListener);
            this.this$0.adManagerInterstitialAd.setFullScreenContentCallback(this.this$0.fullScreenContentCallback);
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5287x8c473820();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$4, reason: not valid java name */
        /* synthetic */ void m5287x8c473820() {
            if (this.this$0.callback != null) {
                this.this$0.callback.onInterstitialAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(final LoadAdError error) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5286x93f23579(error);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd$4, reason: not valid java name */
        /* synthetic */ void m5286x93f23579(LoadAdError loadAdError) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onInterstitialAdFailedToLoad(loadAdError);
            }
        }
    }

    public boolean isAdAvailable(String adUnitId) {
        return AdManagerInterstitialAd.isAdAvailable(this.activity, adUnitId);
    }

    public void pollAd(String adUnitId) {
        AdManagerInterstitialAd adManagerInterstitialAd = (AdManagerInterstitialAd) AdManagerInterstitialAd.pollAd(this.activity, adUnitId);
        this.adManagerInterstitialAd = adManagerInterstitialAd;
        if (adManagerInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Failed to obtain an Ad Manager Interstitial Ad from the preloader.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5277xf6ec000b();
                }
            });
            this.adManagerInterstitialAd.setFullScreenContentCallback(this.fullScreenContentCallback);
        }
    }

    /* JADX INFO: renamed from: lambda$pollAd$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5277xf6ec000b() {
        this.adManagerInterstitialAd.setOnPaidEventListener(this.onPaidEventListener);
        this.adManagerInterstitialAd.setAppEventListener(this.appEventListener);
    }

    public String getAdUnitId() {
        AdManagerInterstitialAd adManagerInterstitialAd = this.adManagerInterstitialAd;
        if (adManagerInterstitialAd == null) {
            return null;
        }
        return adManagerInterstitialAd.getAdUnitId();
    }

    public ResponseInfo getResponseInfo() {
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m5275x5c69eb4();
            }
        });
        this.activity.runOnUiThread(futureTask);
        try {
            return (ResponseInfo) futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Unable to check Ad Manager interstitial response info: %s", e.getLocalizedMessage()));
            return null;
        }
    }

    /* JADX INFO: renamed from: lambda$getResponseInfo$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd, reason: not valid java name */
    /* synthetic */ ResponseInfo m5275x5c69eb4() throws Exception {
        return this.adManagerInterstitialAd.getResponseInfo();
    }

    public void show() {
        if (this.adManagerInterstitialAd == null) {
            Log.e(PluginUtils.LOGTAG, "Tried to show Ad Manager interstitial ad before it was ready. This should in theory never happen. If it does, please contact the plugin owners.");
        } else {
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerInterstitialAd$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5278x525dd4c6();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-google-unity-ads-admanager-UnityAdManagerInterstitialAd, reason: not valid java name */
    /* synthetic */ void m5278x525dd4c6() {
        this.adManagerInterstitialAd.show(this.activity);
    }
}
