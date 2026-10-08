package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.tnkfactory.ad.AdConfiguration;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.InterstitialAdItem;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TnkInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "TnkInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private double mEcpm;
    private InterstitialAdItem mInterstitialAd;
    private boolean mTestMode;

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
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        InterstitialAdItem interstitialAdItem = new InterstitialAdItem(this.mActivity, this.mAdUnitId, new AdListener() { // from class: com.adxcorp.ads.adapter.TnkInterstitialAd.1
            @Override // com.tnkfactory.ad.AdListener
            public void onClose(AdItem adItem, int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                if (TnkInterstitialAd.this.mCustomEventListener != null) {
                    TnkInterstitialAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onClick(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (TnkInterstitialAd.this.mCustomEventListener != null) {
                    TnkInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onShow(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                if (TnkInterstitialAd.this.mCustomEventListener != null) {
                    TnkInterstitialAd.this.mCustomEventListener.onAdImpression();
                    TnkInterstitialAd.this.mCustomEventListener.onPaidEvent(TnkInterstitialAd.this.mEcpm);
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onError(AdItem adItem, AdError adError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + adError.getMessage());
                if (TnkInterstitialAd.this.mCustomEventListener != null) {
                    TnkInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.tnkfactory.ad.AdListener
            public void onLoad(AdItem adItem) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (TnkInterstitialAd.this.mCustomEventListener != null) {
                    TnkInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }
        });
        this.mInterstitialAd = interstitialAdItem;
        interstitialAdItem.load();
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        InterstitialAdItem interstitialAdItem = this.mInterstitialAd;
        if (interstitialAdItem != null && interstitialAdItem.isLoaded()) {
            this.mInterstitialAd.show();
            return;
        }
        ADXLogUtil.d(str, "Interstitial ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_TNK, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        ICustomEventListener iCustomEventListener = this.mCustomEventListener;
        if (iCustomEventListener != null) {
            iCustomEventListener.onAdFailedToShow();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        InterstitialAdItem interstitialAdItem = this.mInterstitialAd;
        if (interstitialAdItem != null) {
            interstitialAdItem.setListener(null);
            this.mInterstitialAd = null;
        }
    }
}
