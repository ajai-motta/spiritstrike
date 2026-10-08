package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
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
public class UnityAdsRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "UnityAdsRewardedAd";
    private Activity mActivity;
    private String mAdUnitId;
    private RCustomEventListener mCustomEventListener;
    private double mEcpm;
    private String mGameId;

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = rCustomEventListener;
        if (context == null) {
            Log.d(str, "Activity cannot be null.");
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
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            RCustomEventListener rCustomEventListener5 = this.mCustomEventListener;
            if (rCustomEventListener5 != null) {
                rCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        if (!UnityAds.isInitialized()) {
            initGdpr(context);
            UnityAds.initialize(this.mActivity.getApplicationContext(), this.mGameId, false, new IUnityAdsInitializationListener() { // from class: com.adxcorp.ads.adapter.UnityAdsRewardedAd.1
                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationComplete() {
                    Log.d(UnityAdsRewardedAd.TAG, "onInitializationComplete");
                    UnityAdsRewardedAd.this.requestAd();
                }

                @Override // com.unity3d.ads.IUnityAdsInitializationListener
                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str2) {
                    Log.d(UnityAdsRewardedAd.TAG, "onInitializationFailed : " + str2);
                    if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                        UnityAdsRewardedAd.this.mCustomEventListener.onAdError();
                    }
                }
            });
        } else {
            requestAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        UnityAds.load(this.mAdUnitId, new IUnityAdsLoadListener() { // from class: com.adxcorp.ads.adapter.UnityAdsRewardedAd.2
            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsAdLoaded(String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                    UnityAdsRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.unity3d.ads.IUnityAdsLoadListener
            public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, "Failure(" + str2 + ")");
                if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                    UnityAdsRewardedAd.this.mCustomEventListener.onAdError();
                }
            }
        });
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        UnityAds.show(this.mActivity, this.mAdUnitId, new IUnityAdsShowListener() { // from class: com.adxcorp.ads.adapter.UnityAdsRewardedAd.3
            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
                if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                    UnityAdsRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                }
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowStart(String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, "Impression");
                if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                    UnityAdsRewardedAd.this.mCustomEventListener.onAdImpression();
                    UnityAdsRewardedAd.this.mCustomEventListener.onPaidEvent(UnityAdsRewardedAd.this.mEcpm);
                }
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowClick(String str) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                    UnityAdsRewardedAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.unity3d.ads.IUnityAdsShowListener
            public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
                if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                        UnityAdsRewardedAd.this.mCustomEventListener.onAdRewarded();
                    }
                } else if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.SKIPPED) {
                    ADXLogUtil.d(UnityAdsRewardedAd.TAG, "Unity ad was skipped, no reward will be given.");
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_UNITYADS, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (UnityAdsRewardedAd.this.mCustomEventListener != null) {
                    UnityAdsRewardedAd.this.mCustomEventListener.onAdClosed();
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
