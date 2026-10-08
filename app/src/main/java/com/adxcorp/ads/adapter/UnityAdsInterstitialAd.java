package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MetaData;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UnityAdsInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "UnityAdsInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private double mEcpm;
    private String mGameId;

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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
        this.mGameId = map.get("game_id");
        if (map.containsKey(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER)) {
            this.mAdUnitId = map.get(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER);
        } else if (map.containsKey(AppLovinUtils.ServerParameterKeys.ZONE_ID)) {
            this.mAdUnitId = map.get(AppLovinUtils.ServerParameterKeys.ZONE_ID);
        }
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mGameId)) {
            Log.d(TAG, "The game id cannot be null.");
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
        if (!UnityAds.isInitialized()) {
            initGdpr(context);
            UnityAds.initialize(this.mActivity.getApplicationContext(), this.mGameId, false, new IUnityAdsInitializationListener() { // from class: com.adxcorp.ads.adapter.UnityAdsInterstitialAd.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() {
                    Log.d(UnityAdsInterstitialAd.TAG, "onInitializationComplete");
                    UnityAdsInterstitialAd.this.requestAd();
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str2) {
                    Log.d(UnityAdsInterstitialAd.TAG, "onInitializationFailed : " + str2);
                    if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                        UnityAdsInterstitialAd.this.mCustomEventListener.onAdError();
                    }
                }
            });
        } else {
            requestAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        UnityAds.load(this.mAdUnitId, new IUnityAdsLoadListener() { // from class: com.adxcorp.ads.adapter.UnityAdsInterstitialAd.2
            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsAdLoaded(String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                    UnityAdsInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure(" + str2 + ")");
                if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                    UnityAdsInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }
        });
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        UnityAds.show(this.mActivity, this.mAdUnitId, new IUnityAdsShowListener() { // from class: com.adxcorp.ads.adapter.UnityAdsInterstitialAd.3
            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
                if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                    UnityAdsInterstitialAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowStart(String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                    UnityAdsInterstitialAd.this.mCustomEventListener.onAdImpression();
                    UnityAdsInterstitialAd.this.mCustomEventListener.onPaidEvent(UnityAdsInterstitialAd.this.mEcpm);
                }
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowClick(String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                    UnityAdsInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                if (UnityAdsInterstitialAd.this.mCustomEventListener != null) {
                    UnityAdsInterstitialAd.this.mCustomEventListener.onAdClosed();
                }
            }
        });
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
    }

    private void initGdpr(Context context) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MetaData metaData = new MetaData(context);
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(context)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            metaData.set("gdpr.consent", (Object) false);
        } else {
            metaData.set("gdpr.consent", (Object) true);
        }
        metaData.commit();
    }
}
