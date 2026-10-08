package com.adxcorp.ads.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.tnkfactory.ad.AdConfiguration;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.BannerAdView;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TnkBanner extends BannerCustomEvent {
    private static final String TAG = "TnkBanner";
    private String mAdUnitId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private BannerAdView mBannerAdView;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;
    private double mEcpm;
    private boolean mIsLoaded;
    private boolean mTestMode;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        return this.mBannerAdView;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        ADXLogUtil.d(TAG, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        this.mContext = context;
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
        String str = map.get("pub_id");
        if (!TextUtils.isEmpty(str)) {
            AdConfiguration.setPublisherId(this.mContext, str);
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The adunit id cannot be null.");
            BCustomEventListener bCustomEventListener3 = this.mCustomEventListener;
            if (bCustomEventListener3 != null) {
                bCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        if (this.mContext == null) {
            Log.d(TAG, "Context cannot be null.");
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
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        BannerAdView bannerAdView = new BannerAdView(this.mContext, this.mAdUnitId);
        this.mBannerAdView = bannerAdView;
        bannerAdView.setListener(new AdListener() { // from class: com.adxcorp.ads.adapter.TnkBanner.1
            @Override // com.tnkfactory.ad.AdListener
            public void onClick(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                if (TnkBanner.this.mCustomEventListener != null) {
                    TnkBanner.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onError(AdItem adItem, AdError adError) {
                if (TnkBanner.this.mIsLoaded) {
                    return;
                }
                TnkBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_BANNER, "Failure, " + adError.getMessage());
                if (TnkBanner.this.mCustomEventListener != null) {
                    TnkBanner.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onLoad(AdItem adItem) {
                if (TnkBanner.this.mIsLoaded) {
                    return;
                }
                TnkBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (TnkBanner.this.mCustomEventListener != null) {
                    TnkBanner.this.mCustomEventListener.onAdLoaded();
                }
            }
        });
        this.mIsLoaded = false;
        this.mBannerAdView.load();
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        BannerAdView bannerAdView = this.mBannerAdView;
        if (bannerAdView != null) {
            bannerAdView.removeAllViews();
            this.mBannerAdView = null;
        }
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_BANNER, "Impression");
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
            this.mCustomEventListener.onPaidEvent(this.mEcpm);
        }
    }
}
