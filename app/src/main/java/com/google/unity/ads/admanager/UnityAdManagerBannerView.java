package com.google.unity.ads.admanager;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.unity.ads.Banner;
import com.google.unity.ads.PluginUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class UnityAdManagerBannerView extends Banner {
    private final ExecutorService service;

    public UnityAdManagerBannerView(Activity activity, UnityAdManagerAdListener listener) {
        this.unityPlayerActivity = activity;
        this.unityListener = listener;
        this.service = Executors.newSingleThreadExecutor();
    }

    @Override // com.google.unity.ads.Banner
    protected void createAdView(final String publisherId, final AdSize adSize) {
        this.adView = new AdManagerAdView(this.unityPlayerActivity);
        this.adView.setBackgroundColor(0);
        this.adView.setAdUnitId(publisherId);
        this.adView.setAdSize(adSize);
        this.adView.setVisibility(8);
        this.adView.setDescendantFocusability(393216);
        this.unityPlayerActivity.addContentView(this.adView, getLayoutParams());
        this.adView.setAdListener(new AnonymousClass1(this));
        this.adView.setOnPaidEventListener(new AnonymousClass2(this));
        ((AdManagerAdView) this.adView).setAppEventListener(new AnonymousClass3(this));
        setLayoutChangeListener();
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerBannerView$1, reason: invalid class name */
    class AnonymousClass1 extends AdListener {
        final /* synthetic */ UnityAdManagerBannerView this$0;

        AnonymousClass1(final UnityAdManagerBannerView this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            if (!this.this$0.hidden) {
                this.this$0.show();
            }
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5264x9d5d5b9f();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$1, reason: not valid java name */
        /* synthetic */ void m5264x9d5d5b9f() {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onAdLoaded();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(final LoadAdError error) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5262x3a46ed78(error);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdFailedToLoad$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$1, reason: not valid java name */
        /* synthetic */ void m5262x3a46ed78(LoadAdError loadAdError) {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onAdFailedToLoad(loadAdError);
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5265xa6caa603();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdOpened$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$1, reason: not valid java name */
        /* synthetic */ void m5265xa6caa603() {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onAdOpened();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5261x272a2086();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClosed$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$1, reason: not valid java name */
        /* synthetic */ void m5261x272a2086() {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onAdClosed();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5263x8ccd6823();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdImpression$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$1, reason: not valid java name */
        /* synthetic */ void m5263x8ccd6823() {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onAdImpression();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5260xe76a19a3();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdClicked$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$1, reason: not valid java name */
        /* synthetic */ void m5260xe76a19a3() {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onAdClicked();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerBannerView$2, reason: invalid class name */
    class AnonymousClass2 implements OnPaidEventListener {
        final /* synthetic */ UnityAdManagerBannerView this$0;

        AnonymousClass2(final UnityAdManagerBannerView this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5266x1d98ef4e(adValue);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onPaidEvent$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$2, reason: not valid java name */
        /* synthetic */ void m5266x1d98ef4e(AdValue adValue) {
            if (this.this$0.unityListener != null) {
                this.this$0.unityListener.onPaidEvent(adValue.getPrecisionType(), adValue.getValueMicros(), adValue.getCurrencyCode());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.unity.ads.admanager.UnityAdManagerBannerView$3, reason: invalid class name */
    class AnonymousClass3 implements AppEventListener {
        final /* synthetic */ UnityAdManagerBannerView this$0;

        AnonymousClass3(final UnityAdManagerBannerView this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.gms.ads.admanager.AppEventListener
        public void onAppEvent(final String name, final String data) {
            this.this$0.service.execute(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5267x46c56712(name, data);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAppEvent$0$com-google-unity-ads-admanager-UnityAdManagerBannerView$3, reason: not valid java name */
        /* synthetic */ void m5267x46c56712(String str, String str2) {
            if (this.this$0.unityListener != null) {
                ((UnityAdManagerAdListener) this.this$0.unityListener).onAppEvent(str, str2);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$loadAd$0$com-google-unity-ads-admanager-UnityAdManagerBannerView, reason: not valid java name */
    /* synthetic */ void m5258x49beb234(AdManagerAdRequest adManagerAdRequest) {
        ((AdManagerAdView) this.adView).loadAd(adManagerAdRequest);
    }

    public void loadAd(final AdManagerAdRequest request) {
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5258x49beb234(request);
            }
        });
    }

    public List<AdSize> getAdSizes() {
        FutureTask futureTask = new FutureTask(new Callable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m5257x51b59a04();
            }
        });
        this.unityPlayerActivity.runOnUiThread(futureTask);
        AdSize[] adSizeArr = new AdSize[0];
        try {
            adSizeArr = (AdSize[]) futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.e(PluginUtils.LOGTAG, String.format("Failed to get ad sizes: %s", e.getLocalizedMessage()));
        }
        return Arrays.asList(adSizeArr);
    }

    /* JADX INFO: renamed from: lambda$getAdSizes$0$com-google-unity-ads-admanager-UnityAdManagerBannerView, reason: not valid java name */
    /* synthetic */ AdSize[] m5257x51b59a04() throws Exception {
        return ((AdManagerAdView) this.adView).getAdSizes();
    }

    public void setAdSizes(final List<AdSize> adSizes) {
        if (adSizes == null || adSizes.size() < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.unityPlayerActivity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.admanager.UnityAdManagerBannerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5259xa6dd6e78(adSizes);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setAdSizes$0$com-google-unity-ads-admanager-UnityAdManagerBannerView, reason: not valid java name */
    /* synthetic */ void m5259xa6dd6e78(List list) {
        ((AdManagerAdView) this.adView).setAdSizes((AdSize[]) list.toArray(new AdSize[list.size()]));
    }
}
