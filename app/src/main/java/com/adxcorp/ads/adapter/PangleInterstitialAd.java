package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "PangleInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private String mAppId;
    private ICustomEventListener mCustomEventListener;
    private double mEcpm;
    private PAGInterstitialAd mInterstitialAd;

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
        this.mAppId = map.get("app_id");
        this.mAdUnitId = map.get(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER);
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
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
        if (!PAGSdk.isInitSuccess()) {
            PAGSdk.init(context, buildConfig(), new PAGSdk.PAGInitCallback() { // from class: com.adxcorp.ads.adapter.PangleInterstitialAd.1
                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void success() {
                    Log.i(PangleInterstitialAd.TAG, "Pangle SDK initialization is completed.");
                    PangleInterstitialAd.this.requestAd();
                }

                @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
                public void fail(int i, String str2) {
                    Log.i(PangleInterstitialAd.TAG, "Pangle SDK failed to initialize. (" + i + ", " + str2 + ")");
                    if (PangleInterstitialAd.this.mCustomEventListener != null) {
                        PangleInterstitialAd.this.mCustomEventListener.onAdError();
                    }
                }
            });
        } else {
            requestAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        PAGInterstitialAd.loadAd(this.mAdUnitId, new PAGInterstitialRequest(), new PAGInterstitialAdLoadListener() { // from class: com.adxcorp.ads.adapter.PangleInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
            public void onError(int i, String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + i + "(" + str + ")");
                if (PangleInterstitialAd.this.mCustomEventListener != null) {
                    PangleInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (PangleInterstitialAd.this.mCustomEventListener != null) {
                    PangleInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
                PangleInterstitialAd.this.mInterstitialAd = pAGInterstitialAd;
            }
        });
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        PAGInterstitialAd pAGInterstitialAd = this.mInterstitialAd;
        if (pAGInterstitialAd != null) {
            pAGInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() { // from class: com.adxcorp.ads.adapter.PangleInterstitialAd.3
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdShowed() {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                    if (PangleInterstitialAd.this.mCustomEventListener != null) {
                        PangleInterstitialAd.this.mCustomEventListener.onAdImpression();
                        PangleInterstitialAd.this.mCustomEventListener.onPaidEvent(PangleInterstitialAd.this.mEcpm);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdClicked() {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                    if (PangleInterstitialAd.this.mCustomEventListener != null) {
                        PangleInterstitialAd.this.mCustomEventListener.onAdClicked();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
                public void onAdDismissed() {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                    if (PangleInterstitialAd.this.mCustomEventListener != null) {
                        PangleInterstitialAd.this.mCustomEventListener.onAdClosed();
                    }
                }
            });
            this.mInterstitialAd.show(this.mActivity);
            return;
        }
        Log.d(TAG, "Interstitial ad not ready.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
    }

    private PAGConfig buildConfig() {
        return new PAGConfig.Builder().appId(this.mAppId).setGDPRConsent(ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(this.mActivity)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied ? 0 : 1).useTextureView(false).debugLog(MediationSDK.getInstance().getConfiguration().isSdkLog()).supportMultiProcess(true).build();
    }
}
