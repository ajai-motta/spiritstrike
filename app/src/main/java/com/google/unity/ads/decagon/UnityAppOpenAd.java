package com.google.unity.ads.decagon;

import android.app.Activity;
import android.util.Log;
import com.google.android.libraries.ads.mobile.sdk.appopen.AppOpenAd;
import com.google.android.libraries.ads.mobile.sdk.appopen.AppOpenAdEventCallback;
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback;
import com.google.android.libraries.ads.mobile.sdk.common.AdRequest;
import com.google.android.libraries.ads.mobile.sdk.common.AdValue;
import com.google.android.libraries.ads.mobile.sdk.common.FullScreenContentError;
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError;
import com.google.android.libraries.ads.mobile.sdk.common.ResponseInfo;
import com.google.unity.ads.PluginUtils;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public class UnityAppOpenAd extends UnityAdBase<AppOpenAd, UnityAppOpenAdCallback> {
    private final AdWrapper<AppOpenAd> adWrapper;

    public UnityAppOpenAd(Activity activity, UnityAppOpenAdCallback callback) {
        this(activity, callback, AdWrapper.forAppOpen(), Executors.newSingleThreadExecutor());
    }

    UnityAppOpenAd(Activity activity, UnityAppOpenAdCallback callback, AdWrapper<AppOpenAd> adWrapper, Executor executor) {
        super(activity, callback, executor);
        this.adWrapper = adWrapper;
    }

    public void load(final AdRequest request) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5288lambda$load$0$comgoogleunityadsdecagonUnityAppOpenAd(request);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$load$0$com-google-unity-ads-decagon-UnityAppOpenAd, reason: not valid java name */
    /* synthetic */ void m5288lambda$load$0$comgoogleunityadsdecagonUnityAppOpenAd(AdRequest adRequest) {
        this.adWrapper.load(adRequest, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityAppOpenAd$1, reason: invalid class name */
    class AnonymousClass1 implements AdLoadCallback<AppOpenAd> {
        final /* synthetic */ UnityAppOpenAd this$0;

        AnonymousClass1(final UnityAppOpenAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onAdLoaded(AppOpenAd ad) {
            this.this$0.ad = ad;
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5291x637c215();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-decagon-UnityAppOpenAd$1, reason: not valid java name */
        /* synthetic */ void m5291x637c215() {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAppOpenAdLoaded();
            }
        }

        public void onAdFailedToLoad(final LoadAdError adError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5290x1c52916e(adError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-decagon-UnityAppOpenAd$1, reason: not valid java name */
        /* synthetic */ void m5290x1c52916e(LoadAdError loadAdError) {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAppOpenAdFailedToLoad(loadAdError);
            }
        }
    }

    public void show() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to show app open ad before it was ready. Please call loadAd first and wait for a successful onAdLoaded callback.");
        } else {
            ((AppOpenAd) this.ad).setAdEventCallback(new AnonymousClass2(this));
            this.activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5289lambda$show$0$comgoogleunityadsdecagonUnityAppOpenAd();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.decagon.UnityAppOpenAd$2, reason: invalid class name */
    class AnonymousClass2 implements AppOpenAdEventCallback {
        final /* synthetic */ UnityAppOpenAd this$0;

        AnonymousClass2(final UnityAppOpenAd this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        public void onAdShowedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$2$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5297x4e4c115();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdShowedFullScreenContent$0$com-google-unity-ads-decagon-UnityAppOpenAd$2, reason: not valid java name */
        /* synthetic */ void m5297x4e4c115() {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAdShowedFullScreenContent();
            }
        }

        public void onAdDismissedFullScreenContent() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$2$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5293x4591a706();
                }
            });
            this.this$0.ad = null;
        }

        /* JADX INFO: renamed from: lambda$onAdDismissedFullScreenContent$0$com-google-unity-ads-decagon-UnityAppOpenAd$2, reason: not valid java name */
        /* synthetic */ void m5293x4591a706() {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAdDismissedFullScreenContent();
            }
        }

        public void onAdFailedToShowFullScreenContent(final FullScreenContentError fullScreenContentError) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$2$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5294xb43f7d1c(fullScreenContentError);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToShowFullScreenContent$0$com-google-unity-ads-decagon-UnityAppOpenAd$2, reason: not valid java name */
        /* synthetic */ void m5294xb43f7d1c(FullScreenContentError fullScreenContentError) {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAdFailedToShowFullScreenContent(fullScreenContentError);
            }
        }

        public void onAdImpression() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$2$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5295xd013749a();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-decagon-UnityAppOpenAd$2, reason: not valid java name */
        /* synthetic */ void m5295xd013749a() {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAdImpression();
            }
        }

        public void onAdClicked() {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5292x370e661a();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-decagon-UnityAppOpenAd$2, reason: not valid java name */
        /* synthetic */ void m5292x370e661a() {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onAdClicked();
            }
        }

        public void onAdPaid(final AdValue adValue) {
            this.this$0.executor.execute(new Runnable() { // from class: com.google.unity.ads.decagon.UnityAppOpenAd$2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5296lambda$onAdPaid$0$comgoogleunityadsdecagonUnityAppOpenAd$2(adValue);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPaid$0$com-google-unity-ads-decagon-UnityAppOpenAd$2, reason: not valid java name */
        /* synthetic */ void m5296lambda$onAdPaid$0$comgoogleunityadsdecagonUnityAppOpenAd$2(AdValue adValue) {
            if (this.this$0.callback != 0) {
                ((UnityAppOpenAdCallback) this.this$0.callback).onPaidEvent(adValue.getPrecisionType().ordinal(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: lambda$show$0$com-google-unity-ads-decagon-UnityAppOpenAd, reason: not valid java name */
    /* synthetic */ void m5289lambda$show$0$comgoogleunityadsdecagonUnityAppOpenAd() {
        ((AppOpenAd) this.ad).setImmersiveMode(true);
        ((AppOpenAd) this.ad).show(this.activity);
    }

    public long getPlacementId() {
        if (this.ad == 0) {
            return 0L;
        }
        return ((AppOpenAd) this.ad).getPlacementId();
    }

    public void setPlacementId(long placementId) {
        if (this.ad == 0) {
            return;
        }
        ((AppOpenAd) this.ad).setPlacementId(placementId);
    }

    public ResponseInfo getResponseInfo() {
        if (this.ad == 0) {
            Log.e(PluginUtils.LOGTAG, "Tried to get response info before it was ready. Returning null.");
            return null;
        }
        return ((AppOpenAd) this.ad).getResponseInfo();
    }
}
