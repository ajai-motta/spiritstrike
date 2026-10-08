package com.adxcorp.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.adxcorp.ads.common.CustomEvent;
import com.adxcorp.ads.common.FullScreenState;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.AdEventListener;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class RewardedAd {
    private static final String TAG = "RewardedAd";
    private AdController mAdController;
    private final String mAdxUnitId;
    private String mCustomData;
    private RewardedCustomEvent mCustomEvent;
    private FullScreenState mFullScreenState;
    private boolean mIsDestroyed;
    private OnPaidEventListener mOnPaidEventListener;
    private RewardedAdListener mRewardedAdListener;
    private String mUserId;
    private String mInventoryType = "rv";
    private AdEventListener mAdEventListener = new AdEventListener() { // from class: com.adxcorp.ads.RewardedAd.2
        @Override // com.adxcorp.ads.mediation.event.AdEventListener
        public void onMediationLoaded(CustomEvent customEvent) {
            ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdLoaded:::");
            if (RewardedAd.this.mIsDestroyed) {
                return;
            }
            RewardedAd.this.mFullScreenState = FullScreenState.READY;
            RewardedAd.this.mCustomEvent = (RewardedCustomEvent) customEvent;
            if (RewardedAd.this.mRewardedAdListener != null) {
                RewardedAd.this.mRewardedAdListener.onAdLoaded();
            }
        }

        @Override // com.adxcorp.ads.mediation.event.AdEventListener
        public void onAdFailedToLoad(int i) {
            ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdError:::" + i);
            RewardedAd.this.mFullScreenState = FullScreenState.NOT_READY;
            if (RewardedAd.this.mRewardedAdListener != null) {
                RewardedAd.this.mRewardedAdListener.onAdError(i);
            }
        }
    };

    public interface RewardedAdListener {
        void onAdClicked();

        void onAdClosed();

        void onAdError(int i);

        void onAdFailedToShow();

        void onAdImpression();

        void onAdLoaded();

        void onAdRewarded();
    }

    public RewardedAd(Activity activity, String str) {
        this.mAdxUnitId = str;
        ADXLogUtil.d(TAG, str + ":::init");
        this.mFullScreenState = FullScreenState.NOT_READY;
        AdController adController = new AdController(activity, this.mInventoryType, this.mAdEventListener);
        this.mAdController = adController;
        adController.setSlotID(str);
    }

    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        this.mRewardedAdListener = rewardedAdListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    public void setUserIdForSSV(String str) {
        this.mUserId = str;
    }

    public void setCustomDataForSSV(String str) {
        this.mCustomData = str;
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
        this.mRewardedAdListener = null;
        this.mOnPaidEventListener = null;
    }

    public void loadAd() {
        ADXLogUtil.d(TAG, this.mAdxUnitId + ":::loadAd:::");
        if (this.mIsDestroyed) {
            return;
        }
        this.mFullScreenState = FullScreenState.NOT_READY;
        this.mAdController.loadAd(new RCustomEventListener() { // from class: com.adxcorp.ads.RewardedAd.1
            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdLoaded() {
                ADXLogUtil.d(RewardedAd.TAG, "Something wrong. onAdLoaded callback should to not firing");
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdError() {
                ADXLogUtil.d(RewardedAd.TAG, "Something wrong. onAdError callback should to not firing");
            }

            @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
            public void onAdImpression() {
                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdImpression:::");
                RewardedAd.this.mFullScreenState = FullScreenState.SHOW;
                if (RewardedAd.this.mCustomEvent != null) {
                    if (RewardedAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(RewardedAd.this.mCustomEvent.getCustomEvent().getMediationData(), RewardedAd.this.mInventoryType, "impression");
                    } else {
                        ReportUtil.sendMetric(RewardedAd.this.mCustomEvent.getMediationData(), RewardedAd.this.mInventoryType, "impression");
                    }
                }
                if (RewardedAd.this.mRewardedAdListener != null) {
                    RewardedAd.this.mRewardedAdListener.onAdImpression();
                }
            }

            @Override // com.adxcorp.ads.common.CustomEventListener
            public void onAdClicked() {
                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdClicked:::");
                if (RewardedAd.this.mCustomEvent != null) {
                    if (RewardedAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(RewardedAd.this.mCustomEvent.getCustomEvent().getMediationData(), RewardedAd.this.mInventoryType, "click");
                    } else {
                        ReportUtil.sendMetric(RewardedAd.this.mCustomEvent.getMediationData(), RewardedAd.this.mInventoryType, "click");
                    }
                }
                if (RewardedAd.this.mRewardedAdListener != null) {
                    RewardedAd.this.mRewardedAdListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.common.RCustomEventListener
            public void onAdRewarded() {
                String str;
                String strEncode;
                String strEncode2 = "";
                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdRewarded:::");
                if (RewardedAd.this.mCustomEvent != null) {
                    try {
                        if (!TextUtils.isEmpty(RewardedAd.this.mUserId)) {
                            strEncode = URLEncoder.encode(RewardedAd.this.mUserId, "UTF-8");
                        } else {
                            strEncode = "";
                        }
                        try {
                            if (!TextUtils.isEmpty(RewardedAd.this.mCustomData)) {
                                strEncode2 = URLEncoder.encode(RewardedAd.this.mCustomData, "UTF-8");
                            }
                        } catch (Exception e) {
                            str = strEncode;
                            e = e;
                            ADXLogUtil.e(RewardedAd.TAG, e);
                            strEncode = str;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = "";
                    }
                    if (RewardedAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendRewardMetric(RewardedAd.this.mCustomEvent.getCustomEvent().getMediationData(), RewardedAd.this.mInventoryType, strEncode, strEncode2);
                    } else {
                        ReportUtil.sendRewardMetric(RewardedAd.this.mCustomEvent.getMediationData(), RewardedAd.this.mInventoryType, strEncode, strEncode2);
                    }
                }
                if (RewardedAd.this.mRewardedAdListener != null) {
                    RewardedAd.this.mRewardedAdListener.onAdRewarded();
                }
            }

            @Override // com.adxcorp.ads.common.RCustomEventListener
            public void onAdClosed() {
                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdClosed:::");
                if (RewardedAd.this.mCustomEvent != null) {
                    if (RewardedAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendMetric(RewardedAd.this.mCustomEvent.getCustomEvent().getMediationData(), RewardedAd.this.mInventoryType, "close");
                    } else {
                        ReportUtil.sendMetric(RewardedAd.this.mCustomEvent.getMediationData(), RewardedAd.this.mInventoryType, "close");
                    }
                }
                if (RewardedAd.this.mRewardedAdListener != null) {
                    RewardedAd.this.mRewardedAdListener.onAdClosed();
                }
            }

            @Override // com.adxcorp.ads.common.RCustomEventListener
            public void onAdFailedToShow() {
                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onAdFailedToShow:::");
                if (RewardedAd.this.mRewardedAdListener != null) {
                    RewardedAd.this.mRewardedAdListener.onAdFailedToShow();
                }
            }

            @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
            public void onPaidEvent(double d) {
                ADXLogUtil.d(RewardedAd.TAG, RewardedAd.this.mAdxUnitId + ":::onPaidEvent:::" + d);
                if (RewardedAd.this.mCustomEvent != null) {
                    if (RewardedAd.this.mCustomEvent.getCustomEvent() != null) {
                        ReportUtil.sendPaidMetric(RewardedAd.this.mCustomEvent.getCustomEvent().getMediationData(), RewardedAd.this.mInventoryType, d);
                    } else {
                        ReportUtil.sendPaidMetric(RewardedAd.this.mCustomEvent.getMediationData(), RewardedAd.this.mInventoryType, d);
                    }
                }
                if (RewardedAd.this.mOnPaidEventListener != null) {
                    RewardedAd.this.mOnPaidEventListener.onPaidEvent(d);
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
            RewardedAdListener rewardedAdListener = this.mRewardedAdListener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdFailedToShow();
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
            RewardedCustomEvent rewardedCustomEvent = this.mCustomEvent;
            if (rewardedCustomEvent != null) {
                rewardedCustomEvent.destroy();
                this.mCustomEvent = null;
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }
}
