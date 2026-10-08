package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.DataKeys;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AppLovinInterstitialAd";
    private String biddingPlatform;
    private double ecpm;
    private boolean enableBiddingKit;
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private MaxInterstitialAd mMaxInterstitialAd;

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
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            this.mAdUnitId = map.get(AppLovinUtils.ServerParameterKeys.ZONE_ID);
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(str, "The AdUnitId cannot be null.");
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
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
            ICustomEventListener iCustomEventListener5 = this.mCustomEventListener;
            if (iCustomEventListener5 != null) {
                iCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(this.mAdUnitId, this.mActivity);
        this.mMaxInterstitialAd = maxInterstitialAd;
        maxInterstitialAd.setLocalExtraParameter("enable_bidding", Boolean.valueOf(this.enableBiddingKit));
        if (this.enableBiddingKit) {
            this.mMaxInterstitialAd.setLocalExtraParameter("adx_ecpm", String.valueOf(this.ecpm));
            this.mMaxInterstitialAd.setLocalExtraParameter("custom_event", this.mCustomEvent);
            if (TextUtils.isEmpty(this.biddingPlatform)) {
                this.mMaxInterstitialAd.setExtraParameter("jC7Fp", String.valueOf(this.ecpm));
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mMaxInterstitialAd.setExtraParameter("disable_auto_retries", "true");
        this.mMaxInterstitialAd.setListener(new MaxAdListener() { // from class: com.adxcorp.ads.adapter.AppLovinInterstitialAd.1
            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinInterstitialAd.TAG, "onAdLoaded : " + networkName);
                if (AppLovinInterstitialAd.this.enableBiddingKit && (TextUtils.isEmpty(networkName) || !networkName.equals(ADXLogUtil.PLATFORM_ADX))) {
                    AppLovinInterstitialAd.this.setCustomEvent(null);
                }
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinInterstitialAd.TAG, "onAdDisplayed : " + networkName + ", CreativeId : " + maxAd.getCreativeId());
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onAdImpression();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                ADXLogUtil.d(AppLovinInterstitialAd.TAG, "onAdHidden CreativeId: " + maxAd.getCreativeId());
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str3, MaxError maxError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + maxError.getCode() + "(" + maxError.getMessage() + ")");
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinInterstitialAd.TAG, "onAdDisplayFailed : " + networkName + ", " + maxError.getCode() + ", " + maxError.getMessage());
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }
        });
        this.mMaxInterstitialAd.setRevenueListener(new MaxAdRevenueListener() { // from class: com.adxcorp.ads.adapter.AppLovinInterstitialAd.2
            @Override // com.applovin.mediation.MaxAdRevenueListener
            public void onAdRevenuePaid(MaxAd maxAd) {
                double revenue = maxAd.getRevenue();
                double d = 1000.0d * revenue;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AppLovinInterstitialAd.TAG, "AppLovin onAdRevenuePaid - " + maxAd);
                    ADXLogUtil.d(AppLovinInterstitialAd.TAG, "AppLovin onAdRevenuePaid - Revenue : " + revenue + ", RevenuePrecision : " + maxAd.getRevenuePrecision() + ", ecpm : " + d);
                }
                if (AppLovinInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinInterstitialAd.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mMaxInterstitialAd.loadAd();
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        MaxInterstitialAd maxInterstitialAd = this.mMaxInterstitialAd;
        if (maxInterstitialAd != null && maxInterstitialAd.isReady()) {
            this.mMaxInterstitialAd.showAd();
            return;
        }
        ADXLogUtil.d(str, "Interstitial ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        MaxInterstitialAd maxInterstitialAd = this.mMaxInterstitialAd;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
            this.mMaxInterstitialAd = null;
        }
    }
}
