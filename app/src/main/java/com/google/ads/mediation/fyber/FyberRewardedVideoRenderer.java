package com.google.ads.mediation.fyber;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class FyberRewardedVideoRenderer implements MediationRewardedAd, InneractiveAdSpot.RequestListener, InneractiveFullscreenAdEventsListener, InneractiveFullScreenAdRewardedListener {
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> adLoadCallback;
    private MediationRewardedAdCallback rewardedAdCallback;
    private InneractiveAdSpot rewardedSpot;
    private InneractiveFullscreenUnitController unitController;

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
    }

    FyberRewardedVideoRenderer(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adLoadCallback = mediationAdLoadCallback;
    }

    void loadWaterfallAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        String string = mediationRewardedAdConfiguration.getServerParameters().getString("spotId");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Spot ID is null or empty.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(FyberMediationAdapter.TAG, adError.getMessage());
            this.adLoadCallback.onFailure(adError);
        } else {
            initializeFyberClasses(mediationRewardedAdConfiguration);
            this.rewardedSpot.requestAd(new InneractiveAdRequest(string));
        }
    }

    void loadRtbAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        String bidResponse = mediationRewardedAdConfiguration.getBidResponse();
        initializeFyberClasses(mediationRewardedAdConfiguration);
        this.rewardedSpot.loadAd(bidResponse);
    }

    private void initializeFyberClasses(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        this.rewardedSpot = FyberFactory.createRewardedAdSpot();
        InneractiveFullscreenUnitController inneractiveFullscreenUnitControllerCreateInneractiveFullscreenUnitController = FyberFactory.createInneractiveFullscreenUnitController();
        this.unitController = inneractiveFullscreenUnitControllerCreateInneractiveFullscreenUnitController;
        this.rewardedSpot.addUnitController(inneractiveFullscreenUnitControllerCreateInneractiveFullscreenUnitController);
        this.rewardedSpot.setRequestListener(this);
        FyberAdapterUtils.updateFyberExtraParams(mediationRewardedAdConfiguration.getMediationExtras());
    }

    private void registerFyberAdListeners() {
        this.unitController.setEventsListener(this);
        this.unitController.setRewardedListener(this);
        this.unitController.addContentController(new InneractiveFullscreenVideoContentController());
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        if (!(context instanceof Activity)) {
            AdError adError = new AdError(107, "Cannot show a rewarded ad without an activity context.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(FyberMediationAdapter.TAG, adError.getMessage());
            MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(adError);
                return;
            }
            return;
        }
        InneractiveAdSpot inneractiveAdSpot = this.rewardedSpot;
        if (inneractiveAdSpot != null && this.unitController != null && inneractiveAdSpot.isReady()) {
            this.unitController.show((Activity) context);
        } else if (this.rewardedAdCallback != null) {
            AdError adError2 = new AdError(106, "DT Exchange's rewarded spot is not ready.", DTExchangeErrorCodes.ERROR_DOMAIN);
            Log.w(FyberMediationAdapter.TAG, adError2.getMessage());
            this.rewardedAdCallback.onAdFailedToShow(adError2);
        }
    }

    private boolean isVideoAdAvailable(InneractiveFullscreenUnitController inneractiveFullscreenUnitController) {
        return (inneractiveFullscreenUnitController == null || inneractiveFullscreenUnitController.getSelectedContentController() == null || !(inneractiveFullscreenUnitController.getSelectedContentController() instanceof InneractiveFullscreenVideoContentController)) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
        this.rewardedAdCallback = this.adLoadCallback.onSuccess(this);
        registerFyberAdListeners();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        AdError adError = DTExchangeErrorCodes.getAdError(inneractiveErrorCode);
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, "Failure, " + adError.getCode() + " (" + adError.getMessage() + ")");
        Log.w(FyberMediationAdapter.TAG, adError.getMessage());
        this.adLoadCallback.onFailure(adError);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, "Impression");
        this.rewardedAdCallback.onAdOpened();
        if (isVideoAdAvailable(this.unitController)) {
            this.rewardedAdCallback.onVideoStart();
        }
        this.rewardedAdCallback.reportAdImpression();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
        this.rewardedAdCallback.reportAdClicked();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
    public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
        this.rewardedAdCallback.onAdClosed();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener
    public void onAdRewarded(InneractiveAdSpot inneractiveAdSpot) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
        this.rewardedAdCallback.onUserEarnedReward();
        this.rewardedAdCallback.onVideoComplete();
    }
}
