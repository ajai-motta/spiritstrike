package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.mediation.MInterstitialAd;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AdPieInterstitialAd";
    private Activity mActivity;
    private ICustomEventListener mCustomEventListener;
    private MInterstitialAd mInterstitialAd;

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
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        if (this.mInterstitialAd == null) {
            this.mInterstitialAd = new MInterstitialAd(this.mActivity, null);
        }
        this.mInterstitialAd.setAdListener(new MInterstitialAd.InterstitialAdListener() { // from class: com.adxcorp.ads.adapter.AdPieInterstitialAd.1
            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings) {
            }

            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onAdLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdPieInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + i);
                if (AdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdPieInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onAdShown() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                if (AdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdPieInterstitialAd.this.mCustomEventListener.onAdImpression();
                    AdPieInterstitialAd.this.mCustomEventListener.onPaidEvent(AdPieInterstitialAd.this.mMediationData.getEcpm());
                }
            }

            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (AdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdPieInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onAdDismissed() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                if (AdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdPieInterstitialAd.this.mCustomEventListener.onAdClosed();
                }
            }

            @Override // com.adxcorp.ads.mediation.MInterstitialAd.InterstitialAdListener
            public void onAdFailedToShow() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                if (AdPieInterstitialAd.this.mCustomEventListener != null) {
                    AdPieInterstitialAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }
        });
        this.mInterstitialAd.parsingBidResponse(this.mMediationData);
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        MInterstitialAd mInterstitialAd = this.mInterstitialAd;
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            return;
        }
        Log.d(TAG, "Interstitial ad not ready.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        MInterstitialAd mInterstitialAd = this.mInterstitialAd;
        if (mInterstitialAd != null) {
            mInterstitialAd.destroy();
            this.mInterstitialAd = null;
        }
    }
}
