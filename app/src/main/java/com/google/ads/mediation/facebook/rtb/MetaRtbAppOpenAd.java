package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetaRtbAppOpenAd.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u0011H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/google/ads/mediation/facebook/rtb/MetaRtbAppOpenAd;", "Lcom/google/android/gms/ads/mediation/MediationAppOpenAd;", "Lcom/facebook/ads/InterstitialAdExtendedListener;", "loadCallback", "Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;", "Lcom/google/android/gms/ads/mediation/MediationAppOpenAdCallback;", "metaFactory", "Lcom/google/ads/mediation/facebook/MetaFactory;", "<init>", "(Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;Lcom/google/ads/mediation/facebook/MetaFactory;)V", "appOpenAd", "Lcom/facebook/ads/InterstitialAd;", "appOpenAdCallback", "showAdCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "didAppOpenAdClose", "loadAd", "", "adConfiguration", "Lcom/google/android/gms/ads/mediation/MediationAppOpenAdConfiguration;", "showAd", "context", "Landroid/content/Context;", "onInterstitialDisplayed", "ad", "Lcom/facebook/ads/Ad;", "onInterstitialDismissed", "onError", "adError", "Lcom/facebook/ads/AdError;", "onAdLoaded", "onAdClicked", "onLoggingImpression", "onInterstitialActivityDestroyed", "onRewardedAdCompleted", "onRewardedAdServerSucceeded", "onRewardedAdServerFailed", "adx-library-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MetaRtbAppOpenAd implements MediationAppOpenAd, InterstitialAdExtendedListener {
    private InterstitialAd appOpenAd;
    private MediationAppOpenAdCallback appOpenAdCallback;
    private final AtomicBoolean didAppOpenAdClose;
    private final MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> loadCallback;
    private final MetaFactory metaFactory;
    private final AtomicBoolean showAdCalled;

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdCompleted() {
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerFailed() {
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerSucceeded() {
    }

    public MetaRtbAppOpenAd(MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> loadCallback, MetaFactory metaFactory) {
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        Intrinsics.checkNotNullParameter(metaFactory, "metaFactory");
        this.loadCallback = loadCallback;
        this.metaFactory = metaFactory;
        this.showAdCalled = new AtomicBoolean();
        this.didAppOpenAdClose = new AtomicBoolean();
    }

    public final void loadAd(MediationAppOpenAdConfiguration adConfiguration) {
        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderBuildLoadAdConfig;
        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderWithBid;
        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderWithAdListener;
        InterstitialAd interstitialAd;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Bundle serverParameters = adConfiguration.getServerParameters();
        Intrinsics.checkNotNullExpressionValue(serverParameters, "getServerParameters(...)");
        String placementID = FacebookMediationAdapter.getPlacementID(serverParameters);
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty. ", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.loadCallback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(adConfiguration);
        this.appOpenAd = this.metaFactory.createAppOpenAd(adConfiguration.getContext(), placementID);
        if (!TextUtils.isEmpty(adConfiguration.getWatermark()) && (interstitialAd = this.appOpenAd) != null) {
            interstitialAd.setExtraHints(new ExtraHints.Builder().mediationData(adConfiguration.getWatermark()).build());
        }
        InterstitialAd interstitialAd2 = this.appOpenAd;
        if (interstitialAd2 != null) {
            InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfigBuild = (interstitialAd2 == null || (interstitialAdLoadConfigBuilderBuildLoadAdConfig = interstitialAd2.buildLoadAdConfig()) == null || (interstitialAdLoadConfigBuilderWithBid = interstitialAdLoadConfigBuilderBuildLoadAdConfig.withBid(adConfiguration.getBidResponse())) == null || (interstitialAdLoadConfigBuilderWithAdListener = interstitialAdLoadConfigBuilderWithBid.withAdListener(this)) == null) ? null : interstitialAdLoadConfigBuilderWithAdListener.build();
            Intrinsics.checkNotNull(interstitialLoadAdConfigBuild);
            interstitialAd2.loadAd(interstitialLoadAdConfigBuild);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAppOpenAd
    public void showAd(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.showAdCalled.set(true);
        InterstitialAd interstitialAd = this.appOpenAd;
        if (interstitialAd == null || interstitialAd.show()) {
            return;
        }
        AdError adError = new AdError(110, "Failed to present app open ad.", FacebookMediationAdapter.ERROR_DOMAIN);
        Log.w(FacebookMediationAdapter.TAG, adError.toString());
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDisplayed(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdOpened();
        }
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDismissed(Ad ad) {
        MediationAppOpenAdCallback mediationAppOpenAdCallback;
        Intrinsics.checkNotNullParameter(ad, "ad");
        if (this.didAppOpenAdClose.getAndSet(true) || (mediationAppOpenAdCallback = this.appOpenAdCallback) == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdClosed();
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adError, "adError");
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Intrinsics.checkNotNullExpressionValue(adError2, "getAdError(...)");
        Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
        if (this.showAdCalled.get()) {
            MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
            if (mediationAppOpenAdCallback != null) {
                mediationAppOpenAdCallback.onAdFailedToShow(adError2);
                return;
            }
            return;
        }
        this.loadCallback.onFailure(adError2);
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.appOpenAdCallback = this.loadCallback.onSuccess(this);
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.reportAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.appOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.reportAdImpression();
        }
    }

    @Override // com.facebook.ads.InterstitialAdExtendedListener
    public void onInterstitialActivityDestroyed() {
        MediationAppOpenAdCallback mediationAppOpenAdCallback;
        if (this.didAppOpenAdClose.getAndSet(true) || (mediationAppOpenAdCallback = this.appOpenAdCallback) == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdClosed();
    }
}
