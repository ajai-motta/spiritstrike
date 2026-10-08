package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.AdPieUtil;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.InterstitialAd;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxAdPieInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AdxAdPieInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private String mAppId;
    private ICustomEventListener mCustomEventListener;
    private String mFloorPrice;
    private InterstitialAd mInterstitialAd;

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
        this.mAppId = map.get("mid");
        this.mAdUnitId = map.get("sid");
        try {
            this.mFloorPrice = map.get("ecpm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mAppId)) {
            Log.d(TAG, "The AppId cannot be null.");
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            ICustomEventListener iCustomEventListener5 = this.mCustomEventListener;
            if (iCustomEventListener5 != null) {
                iCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        AdPieUtil.initialize(context, this.mAppId);
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        if (this.mInterstitialAd == null) {
            this.mInterstitialAd = new InterstitialAd(this.mActivity, this.mAdUnitId);
        }
        this.mInterstitialAd.setAdListener(new InterstitialAd.InterstitialAdListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieInterstitialAd.1
            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
            public void onAdLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + i);
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
            public void onAdShown() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onAdImpression();
                }
            }

            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
            public void onAdDismissed() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
            public void onAdFailedToShow() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }
        });
        this.mInterstitialAd.setOnPaidEventListener(new InterstitialAd.OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdxAdPieInterstitialAd.2
            @Override // com.gomfactory.adpie.sdk.InterstitialAd.OnPaidEventListener
            public void onPaidEvent(double d) {
                if (AdxAdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdxAdPieInterstitialAd.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mInterstitialAd.setExtraParameter("floorPrice", this.mFloorPrice);
        this.mInterstitialAd.load();
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            return;
        }
        Log.d(TAG, "Interstitial ad not ready.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.mInterstitialAd = null;
        }
    }
}
