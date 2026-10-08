package com.adxcorp.ads;

import android.app.Activity;
import com.adxcorp.ads.common.CustomEvent;
import com.adxcorp.ads.common.FullScreenState;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.AdEventListener;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialAd {
    private static final String TAG = "InterstitialAd";
    private AdController mAdController;
    private final String mAdxUnitId;
    private IntersCustomEvent mCustomEvent;
    private FullScreenState mFullScreenState;
    private InterstitialListener mInterstitialListener;
    private boolean mIsDestroyed;
    private OnPaidEventListener mOnPaidEventListener;
    private String mInventoryType = ReportUtil.INVENTORY_TYPE_INTERSTITIAL;
    private AdEventListener mAdEventListener = new AdEventListener() { // from class: com.adxcorp.ads.InterstitialAd.2
        @Override // com.adxcorp.ads.mediation.event.AdEventListener
        public void onMediationLoaded(CustomEvent customEvent) {
            ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdLoaded:::");
            if (InterstitialAd.this.mIsDestroyed) {
                return;
            }
            InterstitialAd.this.mFullScreenState = FullScreenState.READY;
            InterstitialAd.this.mCustomEvent = (IntersCustomEvent) customEvent;
            if (InterstitialAd.this.mInterstitialListener != null) {
                InterstitialAd.this.mInterstitialListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.mediation.event.AdEventListener
        public void onAdFailedToLoad(int i) {
            ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdError:::" + i);
            InterstitialAd.this.mFullScreenState = FullScreenState.NOT_READY;
            if (InterstitialAd.this.mInterstitialListener != null) {
                InterstitialAd.this.mInterstitialListener.onAdError(i);
            }
        }
    };

    public interface InterstitialListener {
        void onAdClicked();

        void onAdClosed();

        void onAdError(int i);

        void onAdFailedToShow();

        void onAdImpression();

        void onAdLoaded();
    }

    public InterstitialAd(Activity activity, String str) {
        this.mAdxUnitId = str;
        ADXLogUtil.d(TAG, str + ":::init");
        this.mFullScreenState = FullScreenState.NOT_READY;
        AdController adController = new AdController(activity, this.mInventoryType, this.mAdEventListener);
        this.mAdController = adController;
        adController.setSlotID(str);
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        this.mInterstitialListener = interstitialListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
        this.mInterstitialListener = null;
        this.mOnPaidEventListener = null;
    }

    public void loadAd() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::loadAd:::");
        if (this.mIsDestroyed) {
            return;
        }
        this.mFullScreenState = FullScreenState.NOT_READY;
        this.mAdController.loadAd(new ICustomEventListener() { // from class: com.adxcorp.ads.InterstitialAd.1
            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdLoaded() {
                ADXLogUtil.d(InterstitialAd.TAG, "Something wrong. onAdLoaded callback should to not firing");
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdError() {
                ADXLogUtil.d(InterstitialAd.TAG, "Something wrong. onAdError callback should to not firing");
            }

            @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
            public void onAdImpression() {
                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdImpression:::");
                InterstitialAd.this.mFullScreenState = FullScreenState.SHOW;
                if (InterstitialAd.this.mCustomEvent != null) {
                    if (InterstitialAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(InterstitialAd.this.mCustomEvent.getCustomEvent().getMediationData(), InterstitialAd.this.mInventoryType, "impression");
                    } else {
                        ReportUtil.sendMetric(InterstitialAd.this.mCustomEvent.getMediationData(), InterstitialAd.this.mInventoryType, "impression");
                    }
                }
                if (InterstitialAd.this.mInterstitialListener != null) {
                    InterstitialAd.this.mInterstitialListener.onAdImpression();
                }
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdClicked() {
                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdClicked:::");
                if (InterstitialAd.this.mCustomEvent != null) {
                    if (InterstitialAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(InterstitialAd.this.mCustomEvent.getCustomEvent().getMediationData(), InterstitialAd.this.mInventoryType, "click");
                    } else {
                        ReportUtil.sendMetric(InterstitialAd.this.mCustomEvent.getMediationData(), InterstitialAd.this.mInventoryType, "click");
                    }
                }
                if (InterstitialAd.this.mInterstitialListener != null) {
                    InterstitialAd.this.mInterstitialListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.common.ICustomEventListener
            public void onAdClosed() {
                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdClosed:::");
                if (InterstitialAd.this.mCustomEvent != null) {
                    if (InterstitialAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(InterstitialAd.this.mCustomEvent.getCustomEvent().getMediationData(), InterstitialAd.this.mInventoryType, "close");
                    } else {
                        ReportUtil.sendMetric(InterstitialAd.this.mCustomEvent.getMediationData(), InterstitialAd.this.mInventoryType, "close");
                    }
                }
                if (InterstitialAd.this.mInterstitialListener != null) {
                    InterstitialAd.this.mInterstitialListener.onAdClosed();
                }
            }

            @Override // com.adxcorp.ads.common.ICustomEventListener
            public void onAdFailedToShow() {
                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onAdFailedToShow:::");
                if (InterstitialAd.this.mInterstitialListener != null) {
                    InterstitialAd.this.mInterstitialListener.onAdFailedToShow();
                }
            }

            @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
            public void onPaidEvent(double d) {
                ADXLogUtil.d(InterstitialAd.TAG, InterstitialAd.this.mAdxUnitId + ":::onPaidEvent:::" + d);
                if (InterstitialAd.this.mCustomEvent != null) {
                    if (InterstitialAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendPaidMetric(InterstitialAd.this.mCustomEvent.getCustomEvent().getMediationData(), InterstitialAd.this.mInventoryType, d);
                    } else {
                        ReportUtil.sendPaidMetric(InterstitialAd.this.mCustomEvent.getMediationData(), InterstitialAd.this.mInventoryType, d);
                    }
                }
                if (InterstitialAd.this.mOnPaidEventListener != null) {
                    InterstitialAd.this.mOnPaidEventListener.onPaidEvent(d);
                }
            }
        });
    }

    public boolean isLoaded() {
        return this.mCustomEvent != null && this.mFullScreenState.isReady();
    }

    public void show() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::show:::");
        if (this.mCustomEvent != null && this.mFullScreenState.isReady()) {
            this.mFullScreenState = FullScreenState.NOT_READY;
            this.mCustomEvent.show();
        } else {
            InterstitialListener interstitialListener = this.mInterstitialListener;
            if (interstitialListener != null) {
                interstitialListener.onAdFailedToShow();
            }
        }
    }

    public void destroy() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::destroy:::");
        try {
            this.mIsDestroyed = true;
            removeEventListener();
            AdController adController = this.mAdController;
            if (adController != null) {
                adController.destroy();
                this.mAdController = null;
            }
            IntersCustomEvent intersCustomEvent = this.mCustomEvent;
            if (intersCustomEvent != null) {
                intersCustomEvent.destroy();
                this.mCustomEvent = null;
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }
}
