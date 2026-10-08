package com.adxcorp.ads.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.AdPieUtil;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdView;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxAdPieBanner extends BannerCustomEvent {
    private static final String TAG = "AdxAdPieBanner";
    private String mAdUnitId;
    private AdView mAdView;
    private String mAppId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;
    private String mFloorPrice;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        return this.mAdView;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        this.mContext = context;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        this.mAppId = map.get("mid");
        this.mAdUnitId = map.get("sid");
        try {
            this.mFloorPrice = map.get("ecpm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mAppId)) {
            Log.d(TAG, "The AppId cannot be null.");
            BCustomEventListener bCustomEventListener3 = this.mCustomEventListener;
            if (bCustomEventListener3 != null) {
                bCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            BCustomEventListener bCustomEventListener4 = this.mCustomEventListener;
            if (bCustomEventListener4 != null) {
                bCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        AdPieUtil.initialize(context, this.mAppId);
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        if (this.mAdView == null) {
            this.mAdView = new AdView(this.mContext);
        }
        this.mAdView.setAdListener(new AdView.AdListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieBanner.1
            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
            public void onAdLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdxAdPieBanner.this.mCustomEventListener != null) {
                    AdxAdPieBanner.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i);
                if (AdxAdPieBanner.this.mCustomEventListener != null) {
                    AdxAdPieBanner.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.gomfactory.adpie.sdk.AdView.AdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                if (AdxAdPieBanner.this.mCustomEventListener != null) {
                    AdxAdPieBanner.this.mCustomEventListener.onAdClicked();
                }
            }
        });
        this.mAdView.setOnPaidEventListener(new AdView.OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieBanner.2
            @Override // com.gomfactory.adpie.sdk.AdView.OnPaidEventListener
            public void onPaidEvent(double d) {
                if (AdxAdPieBanner.this.mCustomEventListener != null) {
                    AdxAdPieBanner.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mAdView.setSlotId(this.mAdUnitId);
        this.mAdView.setExtraParameter("floorPrice", this.mFloorPrice);
        this.mAdView.load();
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, "Impression");
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
            this.mAdView = null;
        }
    }
}
