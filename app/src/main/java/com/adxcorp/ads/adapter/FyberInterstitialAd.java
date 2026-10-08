package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FyberInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "FyberInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private String mAppId;
    private ICustomEventListener mCustomEventListener;
    private double mEcpm;
    private InneractiveAdSpot mInterstitialSpot;

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = iCustomEventListener;
        if (context == null) {
            Log.d(str, "Activity cannot be null.");
            ICustomEventListener iCustomEventListener2 = this.mCustomEventListener;
            if (iCustomEventListener2 != null) {
                iCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            ICustomEventListener iCustomEventListener3 = this.mCustomEventListener;
            if (iCustomEventListener3 != null) {
                iCustomEventListener3.onAdError();
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
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            ICustomEventListener iCustomEventListener5 = this.mCustomEventListener;
            if (iCustomEventListener5 != null) {
                iCustomEventListener5.onAdError();
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
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        InneractiveAdSpot inneractiveAdSpot = this.mInterstitialSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
        }
        InneractiveAdManager.setMuteVideo(true);
        InneractiveAdSpot inneractiveAdSpotCreateSpot = InneractiveAdSpotManager.get().createSpot();
        this.mInterstitialSpot = inneractiveAdSpotCreateSpot;
        inneractiveAdSpotCreateSpot.setMediationName(InneractiveMediationName.OTHER);
        this.mInterstitialSpot.setMediationVersion(ADXGDPR.ADX_SDK_VERSION);
        this.mInterstitialSpot.addUnitController(new InneractiveFullscreenUnitController());
        InneractiveAdRequest inneractiveAdRequest = new InneractiveAdRequest(this.mAdUnitId);
        this.mInterstitialSpot.setRequestListener(new InneractiveAdSpot.RequestListener() { // from class: com.adxcorp.ads.adapter.FyberInterstitialAd.1
            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot2) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (FyberInterstitialAd.this.mCustomEventListener != null) {
                    FyberInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot2, InneractiveErrorCode inneractiveErrorCode) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + inneractiveErrorCode);
                if (FyberInterstitialAd.this.mCustomEventListener != null) {
                    FyberInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }
        });
        this.mInterstitialSpot.requestAd(inneractiveAdRequest);
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        InneractiveAdSpot inneractiveAdSpot = this.mInterstitialSpot;
        if (inneractiveAdSpot != null && inneractiveAdSpot.isReady()) {
            InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) this.mInterstitialSpot.getSelectedUnitController();
            inneractiveFullscreenUnitController.setEventsListener(new InneractiveFullscreenAdEventsListener() { // from class: com.adxcorp.ads.adapter.FyberInterstitialAd.2
                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot2) {
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot2) {
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
                public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                    if (FyberInterstitialAd.this.mCustomEventListener != null) {
                        FyberInterstitialAd.this.mCustomEventListener.onAdClosed();
                    }
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdImpression(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                    if (FyberInterstitialAd.this.mCustomEventListener != null) {
                        FyberInterstitialAd.this.mCustomEventListener.onAdImpression();
                        FyberInterstitialAd.this.mCustomEventListener.onPaidEvent(FyberInterstitialAd.this.mEcpm);
                    }
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdClicked(InneractiveAdSpot inneractiveAdSpot2) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                    if (FyberInterstitialAd.this.mCustomEventListener != null) {
                        FyberInterstitialAd.this.mCustomEventListener.onAdClicked();
                    }
                }

                @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot2, InneractiveUnitController.AdDisplayError adDisplayError) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                    if (FyberInterstitialAd.this.mCustomEventListener != null) {
                        FyberInterstitialAd.this.mCustomEventListener.onAdFailedToShow();
                    }
                }
            });
            InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = new InneractiveFullscreenVideoContentController();
            inneractiveFullscreenVideoContentController.setEventsListener(new VideoContentListener() { // from class: com.adxcorp.ads.adapter.FyberInterstitialAd.3
                @Override // com.fyber.inneractive.sdk.external.VideoContentListener
                public void onCompleted() {
                }

                @Override // com.fyber.inneractive.sdk.external.VideoContentListener
                public void onPlayerError() {
                }

                @Override // com.fyber.inneractive.sdk.external.VideoContentListener
                public void onProgress(int i, int i2) {
                }
            });
            inneractiveFullscreenUnitController.addContentController(inneractiveFullscreenVideoContentController);
            inneractiveFullscreenUnitController.show(this.mActivity);
            return;
        }
        ADXLogUtil.d(str, "Interstitial ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        ICustomEventListener iCustomEventListener = this.mCustomEventListener;
        if (iCustomEventListener != null) {
            iCustomEventListener.onAdFailedToShow();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        InneractiveAdSpot inneractiveAdSpot = this.mInterstitialSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
            this.mInterstitialSpot = null;
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
