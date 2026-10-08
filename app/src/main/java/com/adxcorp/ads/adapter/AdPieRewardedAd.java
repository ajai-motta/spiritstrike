package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.ads.mediation.MRewardedAd;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "AdPieRewardedAd";
    private Activity mActivity;
    private RCustomEventListener mCustomEventListener;
    private MRewardedAd mRewardedAd;

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = rCustomEventListener;
        if (context == null) {
            Log.d(str, "Activity cannot be null.");
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
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        if (this.mRewardedAd == null) {
            this.mRewardedAd = new MRewardedAd(this.mActivity, null);
        }
        this.mRewardedAd.setAdListener(new MRewardedAd.RewardedAdListener() { // from class: com.adxcorp.ads.adapter.AdPieRewardedAd.1
            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings) {
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, "Failure, " + i);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdShown() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, "Impression");
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdImpression();
                    AdPieRewardedAd.this.mCustomEventListener.onPaidEvent(AdPieRewardedAd.this.mMediationData.getEcpm());
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdDismissed() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdRewarded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdRewarded();
                }
            }

            @Override // com.adxcorp.ads.mediation.MRewardedAd.RewardedAdListener
            public void onAdFailedToShow() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                if (AdPieRewardedAd.this.mCustomEventListener != null) {
                    AdPieRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }
        });
        this.mRewardedAd.parsingBidResponse(this.mMediationData);
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        MRewardedAd mRewardedAd = this.mRewardedAd;
        if (mRewardedAd != null && mRewardedAd.isLoaded()) {
            this.mRewardedAd.show();
            return;
        }
        Log.d(TAG, "Rewarded ad not ready.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        MRewardedAd mRewardedAd = this.mRewardedAd;
        if (mRewardedAd != null) {
            mRewardedAd.destroy();
            this.mRewardedAd = null;
        }
    }
}
