package com.google.ads.mediation.fyber;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DTExchangeBannerAd.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u001d\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\"\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/google/ads/mediation/fyber/DTExchangeBannerAd;", "Lcom/google/android/gms/ads/mediation/MediationBannerAd;", "Lcom/fyber/inneractive/sdk/external/InneractiveAdSpot$RequestListener;", "Lcom/fyber/inneractive/sdk/external/InneractiveAdViewEventsListener;", "mediationAdLoadCallback", "Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;", "Lcom/google/android/gms/ads/mediation/MediationBannerAdCallback;", "<init>", "(Lcom/google/android/gms/ads/mediation/MediationAdLoadCallback;)V", "adSpot", "Lcom/fyber/inneractive/sdk/external/InneractiveAdSpot;", "wrapperView", "Landroid/widget/RelativeLayout;", "bannerAdCallback", "loadAd", "", "mediationBannerAdConfiguration", "Lcom/google/android/gms/ads/mediation/MediationBannerAdConfiguration;", "onInneractiveSuccessfulAdRequest", "iAdSpot", "onInneractiveFailedAdRequest", "errorCode", "Lcom/fyber/inneractive/sdk/external/InneractiveErrorCode;", "getView", "Landroid/view/View;", "onAdImpression", "onAdClicked", "onAdWillCloseInternalBrowser", "onAdWillOpenExternalApp", "onAdEnteredErrorState", "displayError", "Lcom/fyber/inneractive/sdk/external/InneractiveUnitController$AdDisplayError;", "onAdExpanded", "onAdResized", "onAdCollapsed", k.M, "adx-library-fyber_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DTExchangeBannerAd implements MediationBannerAd, InneractiveAdSpot.RequestListener, InneractiveAdViewEventsListener {
    private static final String TAG = Reflection.getOrCreateKotlinClass(DTExchangeBannerAd.class).getSimpleName();
    private InneractiveAdSpot adSpot;
    private MediationBannerAdCallback bannerAdCallback;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback;
    private RelativeLayout wrapperView;

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdCollapsed(InneractiveAdSpot adSpot) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot adSpot, InneractiveUnitController.AdDisplayError displayError) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdExpanded(InneractiveAdSpot adSpot) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdResized(InneractiveAdSpot adSpot) {
    }

    public DTExchangeBannerAd(MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        Intrinsics.checkNotNullParameter(mediationAdLoadCallback, "mediationAdLoadCallback");
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public final void loadAd(MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        Intrinsics.checkNotNullParameter(mediationBannerAdConfiguration, "mediationBannerAdConfiguration");
        InneractiveAdManager.setMediationName(FyberMediationAdapter.MEDIATOR_NAME);
        InneractiveAdManager.setMediationVersion(MobileAds.getVersion().toString());
        String bidResponse = mediationBannerAdConfiguration.getBidResponse();
        Intrinsics.checkNotNullExpressionValue(bidResponse, "getBidResponse(...)");
        this.adSpot = InneractiveAdSpotManager.get().createSpot();
        InneractiveAdViewUnitController inneractiveAdViewUnitController = new InneractiveAdViewUnitController();
        InneractiveAdSpot inneractiveAdSpot = this.adSpot;
        InneractiveAdSpot inneractiveAdSpot2 = null;
        if (inneractiveAdSpot == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot = null;
        }
        inneractiveAdSpot.addUnitController(inneractiveAdViewUnitController);
        this.wrapperView = new RelativeLayout(mediationBannerAdConfiguration.getContext());
        InneractiveAdSpot inneractiveAdSpot3 = this.adSpot;
        if (inneractiveAdSpot3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot3 = null;
        }
        inneractiveAdSpot3.setRequestListener(this);
        inneractiveAdViewUnitController.setEventsListener(this);
        FyberAdapterUtils.updateFyberExtraParams(mediationBannerAdConfiguration.getMediationExtras());
        InneractiveAdSpot inneractiveAdSpot4 = this.adSpot;
        if (inneractiveAdSpot4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
        } else {
            inneractiveAdSpot2 = inneractiveAdSpot4;
        }
        inneractiveAdSpot2.loadAd(bidResponse);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot iAdSpot) {
        InneractiveAdSpot inneractiveAdSpot = this.adSpot;
        RelativeLayout relativeLayout = null;
        InneractiveAdSpot inneractiveAdSpot2 = null;
        InneractiveAdSpot inneractiveAdSpot3 = null;
        if (inneractiveAdSpot == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot = null;
        }
        if (!inneractiveAdSpot.isReady()) {
            AdError adError = new AdError(106, "DT Exchange's banner ad spot is not ready.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(TAG, adError.getMessage());
            this.mediationAdLoadCallback.onFailure(adError);
            InneractiveAdSpot inneractiveAdSpot4 = this.adSpot;
            if (inneractiveAdSpot4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            } else {
                inneractiveAdSpot2 = inneractiveAdSpot4;
            }
            inneractiveAdSpot2.destroy();
            return;
        }
        InneractiveAdSpot inneractiveAdSpot5 = this.adSpot;
        if (inneractiveAdSpot5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            inneractiveAdSpot5 = null;
        }
        InneractiveUnitController selectedUnitController = inneractiveAdSpot5.getSelectedUnitController();
        InneractiveAdViewUnitController inneractiveAdViewUnitController = selectedUnitController instanceof InneractiveAdViewUnitController ? (InneractiveAdViewUnitController) selectedUnitController : null;
        if (inneractiveAdViewUnitController == null) {
            AdError adError2 = new AdError(105, "Unexpected controller type.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(TAG, adError2.getMessage());
            this.mediationAdLoadCallback.onFailure(adError2);
            InneractiveAdSpot inneractiveAdSpot6 = this.adSpot;
            if (inneractiveAdSpot6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adSpot");
            } else {
                inneractiveAdSpot3 = inneractiveAdSpot6;
            }
            inneractiveAdSpot3.destroy();
            return;
        }
        RelativeLayout relativeLayout2 = this.wrapperView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrapperView");
        } else {
            relativeLayout = relativeLayout2;
        }
        inneractiveAdViewUnitController.bindView(relativeLayout);
        this.bannerAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveFailedAdRequest(InneractiveAdSpot adSpot, InneractiveErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.mediationAdLoadCallback.onFailure(DTExchangeErrorCodes.getAdError(errorCode));
        if (adSpot != null) {
            adSpot.destroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View getView() {
        RelativeLayout relativeLayout = this.wrapperView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wrapperView");
            relativeLayout = null;
        }
        return relativeLayout;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot adSpot) {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot adSpot) {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot adSpot) {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdClosed();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot adSpot) {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
            mediationBannerAdCallback.onAdLeftApplication();
        }
    }
}
