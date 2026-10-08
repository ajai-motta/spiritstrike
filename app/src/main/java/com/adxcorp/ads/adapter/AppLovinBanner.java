package com.adxcorp.ads.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.animation.core.AnimationConstants;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinBanner extends BannerCustomEvent {
    private static final String TAG = "AppLovinBanner";
    private String biddingPlatform;
    private double ecpm;
    private boolean enableBiddingKit;
    private String mAdUnitId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;
    private boolean mIsLoaded;
    private MaxAdView mMaxAdView;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        return this.mMaxAdView;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        this.mContext = context;
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            this.mAdUnitId = map.get(AppLovinUtils.ServerParameterKeys.ZONE_ID);
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(str, "The AdUnitId cannot be null.");
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
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
        if (this.mContext == null) {
            Log.d(TAG, "Context cannot be null.");
            BCustomEventListener bCustomEventListener3 = this.mCustomEventListener;
            if (bCustomEventListener3 != null) {
                bCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        if (AppLovinUtils.isChildUser()) {
            Log.d(TAG, AppLovinUtils.ERROR_MSG_CHILD_USER);
            BCustomEventListener bCustomEventListener4 = this.mCustomEventListener;
            if (bCustomEventListener4 != null) {
                bCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        if (this.mMaxAdView == null) {
            MaxAdView maxAdView = new MaxAdView(this.mAdUnitId, MaxAdFormat.BANNER, this.mContext);
            this.mMaxAdView = maxAdView;
            maxAdView.setLocalExtraParameter("enable_bidding", Boolean.valueOf(this.enableBiddingKit));
            this.mMaxAdView.setGravity(17);
        }
        applyBannerAdSize();
        if (this.enableBiddingKit) {
            this.mMaxAdView.setLocalExtraParameter("adx_ecpm", String.valueOf(this.ecpm));
            this.mMaxAdView.setLocalExtraParameter("custom_event", this.mCustomEvent);
            if (TextUtils.isEmpty(this.biddingPlatform)) {
                this.mMaxAdView.setExtraParameter("jC7Fp", String.valueOf(this.ecpm));
            }
            this.mMaxAdView.setExtraParameter("disable_precache", "true");
        }
        this.mMaxAdView.setExtraParameter("allow_pause_auto_refresh_immediately", "true");
        this.mMaxAdView.setExtraParameter("disable_auto_retries", "true");
        this.mMaxAdView.stopAutoRefresh();
        this.mMaxAdView.setListener(new MaxAdViewAdListener() { // from class: com.adxcorp.ads.adapter.AppLovinBanner.1
            @Override // com.applovin.mediation.MaxAdViewAdListener
            public void onAdExpanded(MaxAd maxAd) {
                ADXLogUtil.d(AppLovinBanner.TAG, "onAdExpanded");
            }

            @Override // com.applovin.mediation.MaxAdViewAdListener
            public void onAdCollapsed(MaxAd maxAd) {
                ADXLogUtil.d(AppLovinBanner.TAG, "onAdCollapsed");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                if (AppLovinBanner.this.mIsLoaded) {
                    return;
                }
                AppLovinBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinBanner.TAG, "onAdLoaded : " + networkName);
                if (AppLovinBanner.this.enableBiddingKit && (TextUtils.isEmpty(networkName) || !networkName.equals(ADXLogUtil.PLATFORM_ADX))) {
                    AppLovinBanner.this.setCustomEvent(null);
                }
                if (AppLovinBanner.this.mCustomEventListener != null) {
                    AppLovinBanner.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayed(MaxAd maxAd) {
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinBanner.TAG, "onAdDisplayed : " + networkName + ", CreativeId : " + maxAd.getCreativeId());
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdHidden(MaxAd maxAd) {
                ADXLogUtil.d(AppLovinBanner.TAG, "onAdHidden");
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdClicked(MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                if (AppLovinBanner.this.mCustomEventListener != null) {
                    AppLovinBanner.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                if (AppLovinBanner.this.mIsLoaded) {
                    return;
                }
                AppLovinBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, "Failure, " + maxError.getCode() + "(" + maxError.getMessage() + ")");
                if (AppLovinBanner.this.mCustomEventListener != null) {
                    AppLovinBanner.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                String networkName = maxAd.getNetworkName();
                ADXLogUtil.d(AppLovinBanner.TAG, "onAdDisplayFailed : " + networkName + ", " + maxError.getCode() + ", " + maxError.getMessage());
            }
        });
        this.mMaxAdView.setRevenueListener(new MaxAdRevenueListener() { // from class: com.adxcorp.ads.adapter.AppLovinBanner.2
            @Override // com.applovin.mediation.MaxAdRevenueListener
            public void onAdRevenuePaid(MaxAd maxAd) {
                double revenue = maxAd.getRevenue();
                double d = 1000.0d * revenue;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AppLovinBanner.TAG, "AppLovin onAdRevenuePaid - " + maxAd);
                    ADXLogUtil.d(AppLovinBanner.TAG, "AppLovin onAdRevenuePaid - Revenue : " + revenue + ", RevenuePrecision : " + maxAd.getRevenuePrecision() + ", ecpm : " + d);
                }
                if (AppLovinBanner.this.mCustomEventListener != null) {
                    AppLovinBanner.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mIsLoaded = false;
        this.mMaxAdView.loadAd();
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        MaxAdView maxAdView = this.mMaxAdView;
        if (maxAdView != null) {
            maxAdView.removeAllViews();
            this.mMaxAdView.destroy();
            this.mMaxAdView = null;
        }
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_BANNER, "Impression");
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
        }
    }

    private void applyBannerAdSize() {
        int iDpToPx;
        int iDpToPx2;
        if (this.mMaxAdView != null) {
            int i = AnonymousClass3.$SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[this.mBannerAdSize.ordinal()];
            if (i == 1) {
                if (this.mMaxAdView.getAdFormat() != MaxAdFormat.BANNER) {
                    this.mMaxAdView.destroy();
                    this.mMaxAdView = null;
                    this.mMaxAdView = new MaxAdView(this.mAdUnitId, MaxAdFormat.BANNER, this.mContext);
                }
                iDpToPx = AppLovinSdkUtils.dpToPx(this.mContext, 320);
                iDpToPx2 = AppLovinSdkUtils.dpToPx(this.mContext, 50);
            } else if (i == 2) {
                Log.d(TAG, this.mBannerAdSize + " not supported.");
                if (this.mMaxAdView.getAdFormat() != MaxAdFormat.BANNER) {
                    this.mMaxAdView.destroy();
                    this.mMaxAdView = null;
                    this.mMaxAdView = new MaxAdView(this.mAdUnitId, MaxAdFormat.BANNER, this.mContext);
                }
                iDpToPx = AppLovinSdkUtils.dpToPx(this.mContext, 320);
                iDpToPx2 = AppLovinSdkUtils.dpToPx(this.mContext, 100);
            } else if (i == 3) {
                if (this.mMaxAdView.getAdFormat() != MaxAdFormat.MREC) {
                    this.mMaxAdView.destroy();
                    this.mMaxAdView = null;
                    this.mMaxAdView = new MaxAdView(this.mAdUnitId, MaxAdFormat.MREC, this.mContext);
                }
                iDpToPx = AppLovinSdkUtils.dpToPx(this.mContext, AnimationConstants.DefaultDurationMillis);
                iDpToPx2 = AppLovinSdkUtils.dpToPx(this.mContext, 250);
            } else if (i != 4) {
                iDpToPx = 0;
                iDpToPx2 = 0;
            } else {
                if (this.mMaxAdView.getAdFormat() != MaxAdFormat.LEADER) {
                    this.mMaxAdView.destroy();
                    this.mMaxAdView = null;
                    this.mMaxAdView = new MaxAdView(this.mAdUnitId, MaxAdFormat.LEADER, this.mContext);
                }
                iDpToPx = AppLovinSdkUtils.dpToPx(this.mContext, 728);
                iDpToPx2 = AppLovinSdkUtils.dpToPx(this.mContext, 90);
            }
            if (iDpToPx <= 0 || iDpToPx2 <= 0) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx2);
            layoutParams.gravity = 17;
            this.mMaxAdView.setLayoutParams(layoutParams);
            this.mMaxAdView.setGravity(17);
        }
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.adapter.AppLovinBanner$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE;

        static {
            int[] iArr = new int[AdConstants.BANNER_AD_SIZE.values().length];
            $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE = iArr;
            try {
                iArr[AdConstants.BANNER_AD_SIZE.AD_SIZE_320x50.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_320x100.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_300x250.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_728x90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
