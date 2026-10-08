package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.AdPieUtil;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.RewardedAd;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxAdPieRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "AdxAdPieRewardedAd";
    private Activity mActivity;
    private String mAdUnitId;
    private String mAppId;
    private RCustomEventListener mCustomEventListener;
    private String mFloorPrice;
    private RewardedAd mRewardedAd;

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
        this.mAppId = map.get("mid");
        this.mAdUnitId = map.get("sid");
        try {
            this.mFloorPrice = map.get("ecpm");
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
        AdPieUtil.initialize(context, this.mAppId);
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        if (this.mRewardedAd == null) {
            this.mRewardedAd = new RewardedAd(this.mActivity, this.mAdUnitId);
        }
        this.mRewardedAd.setAdListener(new RewardedAd.RewardedAdListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieRewardedAd.1
            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdShown() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Impression");
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdImpression();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdDismissed() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdRewarded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdRewarded();
                }
            }

            @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
            public void onAdFailedToShow() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }
        });
        this.mRewardedAd.setOnPaidEventListener(new RewardedAd.OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieRewardedAd.2
            @Override // com.gomfactory.adpie.sdk.RewardedAd.OnPaidEventListener
            public void onPaidEvent(double d) {
                if (AdxAdPieRewardedAd.this.mCustomEventListener != null) {
                    AdxAdPieRewardedAd.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mRewardedAd.setExtraParameter("floorPrice", this.mFloorPrice);
        this.mRewardedAd.load();
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && rewardedAd.isLoaded()) {
            this.mRewardedAd.show();
            return;
        }
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        Log.d(TAG, "Rewarded ad not ready.");
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
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null) {
            rewardedAd.destroy();
            this.mRewardedAd = null;
        }
    }
}
