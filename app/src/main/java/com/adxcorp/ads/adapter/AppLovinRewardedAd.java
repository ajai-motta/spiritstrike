package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.DataKeys;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "AppLovinRewardedAd";
    private String biddingPlatform;
    private double ecpm;
    private boolean enableBiddingKit;
    private Activity mActivity;
    private String mAdUnitId;
    private RCustomEventListener mCustomEventListener;
    private MaxRewardedAd mMaxRewardedAd;

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
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            this.mAdUnitId = map.get(AppLovinUtils.ServerParameterKeys.ZONE_ID);
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(str, "The AdUnitId cannot be null.");
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        try {
            if (map.containsKey("enableBiddingKit")) {
                this.enableBiddingKit = Boolean.parseBoolean(map.get("enableBiddingKit"));
            }
            if (map.containsKey("ecpm")) {
                this.ecpm = Double.parseDouble(map.get("ecpm"));
            }
            if (map.containsKey("biddingPlatform")) {
                this.biddingPlatform = map.get("biddingPlatform");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (AppLovinUtils.isChildUser()) {
            Log.d(TAG, AppLovinUtils.ERROR_MSG_CHILD_USER);
            RCustomEventListener rCustomEventListener5 = this.mCustomEventListener;
            if (rCustomEventListener5 != null) {
                rCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        if (this.enableBiddingKit) {
            try {
                MaxRewardedAd.getInstance(this.mAdUnitId, this.mActivity).destroy();
            } catch (Exception e) {
                Log.d(TAG, "MaxRewardedAd destroy error : " + e);
            }
        }
        MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(this.mAdUnitId, this.mActivity);
        this.mMaxRewardedAd = maxRewardedAd;
        maxRewardedAd.setLocalExtraParameter("enable_bidding", Boolean.valueOf(this.enableBiddingKit));
        if (this.enableBiddingKit) {
            this.mMaxRewardedAd.setLocalExtraParameter("adx_ecpm", String.valueOf(this.ecpm));
            this.mMaxRewardedAd.setLocalExtraParameter("custom_event", this.mCustomEvent);
            if (TextUtils.isEmpty(this.biddingPlatform)) {
                this.mMaxRewardedAd.setExtraParameter("jC7Fp", String.valueOf(this.ecpm));
            }
            try {
                String stringValue = Preference.getStringValue(this.mActivity, DataKeys.APPLOVIN_DISABLE_PRECACHE, "");
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, "disablePrecache : " + stringValue);
                }
                if (!TextUtils.isEmpty(stringValue)) {
                    String[] strArrSplit = stringValue.split("\\s*,\\s*");
                    int length = strArrSplit.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            String str = stringValue + ", " + this.mAdUnitId;
                            Preference.putString(this.mActivity, DataKeys.APPLOVIN_DISABLE_PRECACHE, str);
                            AppLovinSdk.getInstance(this.mActivity).getSettings().setExtraParameter("disable_b2b_ad_unit_ids", str);
                            break;
                        }
                        String str2 = strArrSplit[i];
                        if (!TextUtils.isEmpty(str2) && this.mAdUnitId.equals(str2)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    Preference.putString(this.mActivity, DataKeys.APPLOVIN_DISABLE_PRECACHE, this.mAdUnitId);
                    AppLovinSdk.getInstance(this.mActivity).getSettings().setExtraParameter("disable_b2b_ad_unit_ids", this.mAdUnitId);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.mMaxRewardedAd.setExtraParameter("disable_auto_retries", "true");
        this.mMaxRewardedAd.setListener(new MaxRewardedAdListener() { // from class: com.adxcorp.ads.adapter.AppLovinRewardedAd.1
            @Override // com.applovin.mediation.MaxRewardedAdListener
            public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdRewarded();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinRewardedAd.TAG, "onAdLoaded : " + networkName);
                if (AppLovinRewardedAd.this.enableBiddingKit && (TextUtils.isEmpty(networkName) || !networkName.equals(ADXLogUtil.PLATFORM_ADX))) {
                    AppLovinRewardedAd.this.setCustomEvent(null);
                }
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, "Impression");
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinRewardedAd.TAG, "onAdDisplayed : " + networkName + ", CreativeId : " + maxAd.getCreativeId());
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdImpression();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str3, MaxError maxError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, "Failure, " + maxError.getCode() + "(" + maxError.getMessage() + ")");
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinRewardedAd.TAG, "onAdDisplayFailed : " + networkName + ", " + maxError.getCode() + ", " + maxError.getMessage());
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }
        });
        this.mMaxRewardedAd.setRevenueListener(new MaxAdRevenueListener() { // from class: com.adxcorp.ads.adapter.AppLovinRewardedAd.2
            @Override // com.applovin.mediation.MaxAdRevenueListener
            public void onAdRevenuePaid(MaxAd maxAd) {
                double revenue = maxAd.getRevenue();
                double d = 1000.0d * revenue;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AppLovinRewardedAd.TAG, "AppLovin onAdRevenuePaid - " + maxAd);
                    ADXLogUtil.d(AppLovinRewardedAd.TAG, "AppLovin onAdRevenuePaid - Revenue : " + revenue + ", RevenuePrecision : " + maxAd.getRevenuePrecision() + ", ecpm : " + d);
                }
                if (AppLovinRewardedAd.this.mCustomEventListener != null) {
                    AppLovinRewardedAd.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mMaxRewardedAd.loadAd();
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        MaxRewardedAd maxRewardedAd = this.mMaxRewardedAd;
        if (maxRewardedAd != null && maxRewardedAd.isReady()) {
            this.mMaxRewardedAd.showAd();
            return;
        }
        ADXLogUtil.d(str, "The rewarded ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        this.mMaxRewardedAd = null;
    }
}
