package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.tnkfactory.ad.AdConfiguration;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.InterstitialAdItem;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TnkRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "TnkRewardedAd";
    private Activity mActivity;
    private String mAdUnitId;
    private RCustomEventListener mCustomEventListener;
    private double mEcpm;
    private InterstitialAdItem mRewardedAd;
    private boolean mTestMode;

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
        String str2 = map.get("pub_id");
        if (!TextUtils.isEmpty(str2)) {
            AdConfiguration.setPublisherId(context, str2);
        }
        this.mAdUnitId = map.get(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER);
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mTestMode = false;
        if (map.containsKey("test_mode")) {
            this.mTestMode = Boolean.parseBoolean(map.get("test_mode"));
        }
        if (this.mTestMode) {
            AdConfiguration.enableLogging(true);
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        InterstitialAdItem interstitialAdItem = new InterstitialAdItem(this.mActivity, this.mAdUnitId, new AdListener() { // from class: com.adxcorp.ads.adapter.TnkRewardedAd.1
            @Override // com.tnkfactory.ad.AdListener
            public void onClose(AdItem adItem, int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (TnkRewardedAd.this.mCustomEventListener != null) {
                    TnkRewardedAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onClick(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (TnkRewardedAd.this.mCustomEventListener != null) {
                    TnkRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onShow(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, "Impression");
                if (TnkRewardedAd.this.mCustomEventListener != null) {
                    TnkRewardedAd.this.mCustomEventListener.onAdImpression();
                    TnkRewardedAd.this.mCustomEventListener.onPaidEvent(TnkRewardedAd.this.mEcpm);
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onError(AdItem adItem, AdError adError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, "Failure, " + adError.getMessage());
                if (TnkRewardedAd.this.mCustomEventListener != null) {
                    TnkRewardedAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onLoad(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (TnkRewardedAd.this.mCustomEventListener != null) {
                    TnkRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onVideoCompletion(AdItem adItem, int i) {
                Log.d(TnkRewardedAd.TAG, "onVideoCompletion : " + i);
                if (i >= VIDEO_VERIFY_SUCCESS_SELF) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    if (TnkRewardedAd.this.mCustomEventListener != null) {
                        TnkRewardedAd.this.mCustomEventListener.onAdRewarded();
                    }
                }
            }
        });
        this.mRewardedAd = interstitialAdItem;
        interstitialAdItem.load();
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        InterstitialAdItem interstitialAdItem = this.mRewardedAd;
        if (interstitialAdItem != null && interstitialAdItem.isLoaded()) {
            this.mRewardedAd.show();
            return;
        }
        ADXLogUtil.d(str, "The rewarded ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        RCustomEventListener rCustomEventListener = this.mCustomEventListener;
        if (rCustomEventListener != null) {
            rCustomEventListener.onAdFailedToShow();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        ADXLogUtil.d(TAG, ":::destroy:::");
        InterstitialAdItem interstitialAdItem = this.mRewardedAd;
        if (interstitialAdItem != null) {
            interstitialAdItem.setListener(null);
            this.mRewardedAd = null;
        }
    }
}
