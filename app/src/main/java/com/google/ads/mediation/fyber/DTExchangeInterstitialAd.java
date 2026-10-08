package com.google.ads.mediation.fyber;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DTExchangeInterstitialAd.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u001c\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/google/ads/mediation/fyber/DTExchangeInterstitialAd;", "Lcom/google/android/gms/ads/mediation/MediationInterstitialAd;", "Lcom/fyber/inneractive/sdk/external/InneractiveAdSpot$RequestListener;", "Lcom/fyber/inneractive/sdk/external/InneractiveFullscreenAdEventsListener;", "mediationAdLoadCallback", "Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;", "Lcom/google/android/gms/ads/mediation/MediationInterstitialAdCallback;", "<init>", "(Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;)V", "adSpot", "Lcom/fyber/inneractive/sdk/external/InneractiveAdSpot;", "interstitialAdCallback", "loadAd", "", "mediationInterstitialAdConfiguration", "Lcom/google/android/gms/ads/mediation/MediationInterstitialAdConfiguration;", "showAd", "context", "Landroid/content/Context;", "onInneractiveSuccessfulAdRequest", "iAdSpot", "onInneractiveFailedAdRequest", "errorCode", "Lcom/fyber/inneractive/sdk/external/InneractiveErrorCode;", "onAdImpression", "onAdClicked", "onAdWillCloseInternalBrowser", "onAdWillOpenExternalApp", "onAdEnteredErrorState", "displayError", "Lcom/fyber/inneractive/sdk/external/InneractiveUnitController$AdDisplayError;", "onAdDismissed", k.M, "adx-library-fyber_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DTExchangeInterstitialAd implements MediationInterstitialAd, InneractiveAdSpot.RequestListener, InneractiveFullscreenAdEventsListener {
    private static final String TAG = Reflection.getOrCreateKotlinClass(DTExchangeInterstitialAd.class).getSimpleName();
    private InneractiveAdSpot adSpot;
    private MediationInterstitialAdCallback interstitialAdCallback;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback;

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot iAdSpot, InneractiveUnitController.AdDisplayError displayError) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot iAdSpot) {
    }

    public DTExchangeInterstitialAd(MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        Intrinsics.checkNotNullParameter(mediationAdLoadCallback, "mediationAdLoadCallback");
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public final void loadAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        Intrinsics.checkNotNullParameter(mediationInterstitialAdConfiguration, "mediationInterstitialAdConfiguration");
        InneractiveAdManager.setMediationName(FyberMediationAdapter.MEDIATOR_NAME);
        InneractiveAdManager.setMediationVersion(MobileAds.getVersion().toString());
        String bidResponse = mediationInterstitialAdConfiguration.getBidResponse();
        Intrinsics.checkNotNullExpressionValue(bidResponse, "getBidResponse(...)");
        this.adSpot = InneractiveAdSpotManager.get().createSpot();
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = new InneractiveFullscreenUnitController();
        InneractiveAdSpot inneractiveAdSpot = this.adSpot;
        InneractiveAdSpot inneractiveAdSpot2 = null;
        if (inneractiveAdSpot == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot = null;
        }
        inneractiveAdSpot.addUnitController(inneractiveFullscreenUnitController);
        InneractiveAdSpot inneractiveAdSpot3 = this.adSpot;
        if (inneractiveAdSpot3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot3 = null;
        }
        inneractiveAdSpot3.setRequestListener(this);
        inneractiveFullscreenUnitController.setEventsListener(this);
        FyberAdapterUtils.updateFyberExtraParams(mediationInterstitialAdConfiguration.getMediationExtras());
        InneractiveAdSpot inneractiveAdSpot4 = this.adSpot;
        if (inneractiveAdSpot4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
        } else {
            inneractiveAdSpot2 = inneractiveAdSpot4;
        }
        inneractiveAdSpot2.loadAd(bidResponse);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        InneractiveAdSpot inneractiveAdSpot = this.adSpot;
        InneractiveAdSpot inneractiveAdSpot2 = null;
        if (inneractiveAdSpot == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot = null;
        }
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        InneractiveFullscreenUnitController inneractiveFullscreenUnitController = selectedUnitController instanceof InneractiveFullscreenUnitController ? (InneractiveFullscreenUnitController) selectedUnitController : null;
        if (inneractiveFullscreenUnitController == null) {
            Log.w(TAG, "showInterstitial called, but wrong spot has been used (should not happen).");
            MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
            if (mediationInterstitialAdCallback != null) {
                mediationInterstitialAdCallback.onAdOpened();
            }
            MediationInterstitialAdCallback mediationInterstitialAdCallback2 = this.interstitialAdCallback;
            if (mediationInterstitialAdCallback2 != null) {
                mediationInterstitialAdCallback2.onAdClosed();
            }
            InneractiveAdSpot inneractiveAdSpot3 = this.adSpot;
            if (inneractiveAdSpot3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            } else {
                inneractiveAdSpot2 = inneractiveAdSpot3;
            }
            inneractiveAdSpot2.destroy();
            return;
        }
        inneractiveFullscreenUnitController.show((Activity) context);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot iAdSpot) {
        InneractiveAdSpot inneractiveAdSpot = this.adSpot;
        InneractiveAdSpot inneractiveAdSpot2 = null;
        if (inneractiveAdSpot == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot = null;
        }
        if (!inneractiveAdSpot.isReady()) {
            AdError adError = new AdError(106, "DT Exchange's interstitial ad spot is not ready.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(TAG, adError.getMessage());
            this.mediationAdLoadCallback.onFailure(adError);
            InneractiveAdSpot inneractiveAdSpot3 = this.adSpot;
            if (inneractiveAdSpot3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            } else {
                inneractiveAdSpot2 = inneractiveAdSpot3;
            }
            inneractiveAdSpot2.destroy();
            return;
        }
        this.interstitialAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveFailedAdRequest(InneractiveAdSpot iAdSpot, InneractiveErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.mediationAdLoadCallback.onFailure(DTExchangeErrorCodes.getAdError(errorCode));
        if (iAdSpot != null) {
            iAdSpot.destroy();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot iAdSpot) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
        MediationInterstitialAdCallback mediationInterstitialAdCallback2 = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback2 != null) {
            mediationInterstitialAdCallback2.reportAdImpression();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot iAdSpot) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdClicked();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot iAdSpot) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
    public void onAdDismissed(InneractiveAdSpot iAdSpot) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }
}
