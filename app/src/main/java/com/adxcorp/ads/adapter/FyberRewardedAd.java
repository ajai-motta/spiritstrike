package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FyberRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "FyberRewardedAd";
    private Activity mActivity;
    private String mAdUnitId;
    private String mAppId;
    private RCustomEventListener mCustomEventListener;
    private double mEcpm;
    private InneractiveAdSpot mRewardedSpot;

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = rCustomEventListener;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            RCustomEventListener rCustomEventListener2 = this.mCustomEventListener;
            if (rCustomEventListener2 != null) {
                rCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            RCustomEventListener rCustomEventListener3 = this.mCustomEventListener;
            if (rCustomEventListener3 != null) {
                rCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        this.mActivity = (Activity) context;
        this.mAppId = map.get("app_id");
        this.mAdUnitId = map.get("spot_id");
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mAppId)) {
            Log.d(TAG, "The AppId cannot be null.");
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            RCustomEventListener rCustomEventListener5 = this.mCustomEventListener;
            if (rCustomEventListener5 != null) {
                rCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            initGdpr(context);
            InneractiveAdManager.initialize(context, this.mAppId, null);
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        InneractiveAdSpot inneractiveAdSpot = this.mRewardedSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
        }
        InneractiveAdManager.setMuteVideo(true);
        InneractiveAdSpot inneractiveAdSpotCreateSpot = InneractiveAdSpotManager.get().createSpot();
        this.mRewardedSpot = inneractiveAdSpotCreateSpot;
        inneractiveAdSpotCreateSpot.setMediationName(InneractiveMediationName.OTHER);
        this.mRewardedSpot.setMediationVersion(ADXGDPR.ADX_SDK_VERSION);
        this.mRewardedSpot.addUnitController(new InneractiveFullscreenUnitController());
        InneractiveAdRequest inneractiveAdRequest = new InneractiveAdRequest(this.mAdUnitId);
        this.mRewardedSpot.setRequestListener(new InneractiveAdSpot.RequestListener() { // from class: com.adxcorp.ads.adapter.FyberRewardedAd.1
            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot2) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (FyberRewardedAd.this.mCustomEventListener != null) {
                    FyberRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot2, InneractiveErrorCode inneractiveErrorCode) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, "Failure, " + inneractiveErrorCode);
                if (FyberRewardedAd.this.mCustomEventListener != null) {
                    FyberRewardedAd.this.mCustomEventListener.onAdError();
                }
            }
        });
        this.mRewardedSpot.requestAd(inneractiveAdRequest);
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        InneractiveAdSpot inneractiveAdSpot = this.mRewardedSpot;
        if (inneractiveAdSpot != null && inneractiveAdSpot.isReady()) {
            InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) this.mRewardedSpot.getSelectedUnitController();
            inneractiveFullscreenUnitController.setEventsListener(new InneractiveFullscreenAdEventsListener() { // from class: com.adxcorp.ads.adapter.FyberRewardedAd.2
                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot2) {
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot2) {
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
                public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                    if (FyberRewardedAd.this.mCustomEventListener != null) {
                        FyberRewardedAd.this.mCustomEventListener.onAdClosed();
                    }
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdImpression(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, "Impression");
                    if (FyberRewardedAd.this.mCustomEventListener != null) {
                        FyberRewardedAd.this.mCustomEventListener.onAdImpression();
                        FyberRewardedAd.this.mCustomEventListener.onPaidEvent(FyberRewardedAd.this.mEcpm);
                    }
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdClicked(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                    if (FyberRewardedAd.this.mCustomEventListener != null) {
                        FyberRewardedAd.this.mCustomEventListener.onAdClicked();
                    }
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot2, InneractiveUnitController.AdDisplayError adDisplayError) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                    if (FyberRewardedAd.this.mCustomEventListener != null) {
                        FyberRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                    }
                }
            });
            InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = new InneractiveFullscreenVideoContentController();
            inneractiveFullscreenVideoContentController.setEventsListener(new VideoContentListener() { // from class: com.adxcorp.ads.adapter.FyberRewardedAd.3
                @Override // com.fyber.inneractive.sdk.external.VideoContentListener
                public void onCompleted() {
                }

                @Override // com.fyber.inneractive.sdk.external.VideoContentListener
                public void onProgress(int i, int i2) {
                }

                @Override // com.fyber.inneractive.sdk.external.VideoContentListener
                public void onPlayerError() {
                    if (FyberRewardedAd.this.mCustomEventListener != null) {
                        FyberRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                    }
                }
            });
            inneractiveFullscreenUnitController.setRewardedListener(new InneractiveFullScreenAdRewardedListener() { // from class: com.adxcorp.ads.adapter.FyberRewardedAd.4
                @Override // com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener
                public void onAdRewarded(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    if (FyberRewardedAd.this.mCustomEventListener != null) {
                        FyberRewardedAd.this.mCustomEventListener.onAdRewarded();
                    }
                }
            });
            inneractiveFullscreenUnitController.addContentController(inneractiveFullscreenVideoContentController);
            inneractiveFullscreenUnitController.show(this.mActivity);
            return;
        }
        ADXLogUtil.d(str, "The rewarded ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        RCustomEventListener rCustomEventListener = this.mCustomEventListener;
        if (rCustomEventListener != null) {
            rCustomEventListener.onAdFailedToShow();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        InneractiveAdSpot inneractiveAdSpot = this.mRewardedSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
            this.mRewardedSpot = null;
        }
    }

    private void initGdpr(Context context) {
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(context)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            InneractiveAdManager.setGdprConsent(false);
        } else {
            InneractiveAdManager.setGdprConsent(true);
        }
    }
}
