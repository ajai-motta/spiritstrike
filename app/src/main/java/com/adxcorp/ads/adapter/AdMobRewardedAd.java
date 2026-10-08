package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdMobRewardedAd extends RewardedCustomEvent {
    private static final String TAG = "AdMobRewardedAd";
    private Activity mActivity;
    private String mAdUnitId;
    private RCustomEventListener mCustomEventListener;
    private RewardedAd mRewardedAd;

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void loadAd(Context context, Map<String, String> map, RCustomEventListener rCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = rCustomEventListener;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
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
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.d(str, "The AdUnitId cannot be null.");
            RCustomEventListener rCustomEventListener4 = this.mCustomEventListener;
            if (rCustomEventListener4 != null) {
                rCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        Bundle bundle = new Bundle();
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(this.mActivity)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            bundle.putString("npa", "1");
        }
        RewardedAd.load(this.mActivity, this.mAdUnitId, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), new RewardedAdLoadCallback() { // from class: com.adxcorp.ads.adapter.AdMobRewardedAd.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(RewardedAd rewardedAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                AdMobRewardedAd.this.mRewardedAd = rewardedAd;
                AdMobRewardedAd.this.mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.adxcorp.ads.adapter.AdMobRewardedAd.1.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        ADXLogUtil.d(AdMobRewardedAd.TAG, "onRewardedAdFailedToShow : " + adError.getCode());
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                        if (AdMobRewardedAd.this.mCustomEventListener != null) {
                            AdMobRewardedAd.this.mCustomEventListener.onAdFailedToShow();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        AdMobRewardedAd.this.mRewardedAd = null;
                        ADXLogUtil.d(AdMobRewardedAd.TAG, "onAdShowedFullScreenContent");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                        if (AdMobRewardedAd.this.mCustomEventListener != null) {
                            AdMobRewardedAd.this.mCustomEventListener.onAdClosed();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, "Impression");
                        if (AdMobRewardedAd.this.mCustomEventListener != null) {
                            AdMobRewardedAd.this.mCustomEventListener.onAdImpression();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                        if (AdMobRewardedAd.this.mCustomEventListener != null) {
                            AdMobRewardedAd.this.mCustomEventListener.onAdClicked();
                        }
                    }
                });
                AdMobRewardedAd.this.mRewardedAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdMobRewardedAd.1.2
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(AdValue adValue) {
                        double valueMicros = adValue.getValueMicros() / 1000000.0d;
                        double d = 1000.0d * valueMicros;
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(AdMobRewardedAd.TAG, "AdMob onPaidEvent - CurrencyCode : " + adValue.getCurrencyCode() + ", Revenue : " + valueMicros + ", PrecisionType : " + adValue.getPrecisionType() + ", ecpm : " + d);
                        }
                        if (AdMobRewardedAd.this.mCustomEventListener != null) {
                            AdMobRewardedAd.this.mCustomEventListener.onPaidEvent(d);
                        }
                    }
                });
                if (AdMobRewardedAd.this.mCustomEventListener != null) {
                    AdMobRewardedAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, "Failure, " + loadAdError.getCode());
                if (AdMobRewardedAd.this.mCustomEventListener != null) {
                    AdMobRewardedAd.this.mCustomEventListener.onAdError();
                }
            }
        });
    }

    @Override // com.adxcorp.ads.common.RewardedCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null) {
            rewardedAd.show(this.mActivity, new OnUserEarnedRewardListener() { // from class: com.adxcorp.ads.adapter.AdMobRewardedAd.2
                @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                public void onUserEarnedReward(RewardItem rewardItem) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    if (AdMobRewardedAd.this.mCustomEventListener != null) {
                        AdMobRewardedAd.this.mCustomEventListener.onAdRewarded();
                    }
                }
            });
            return;
        }
        ADXLogUtil.d(str, "The rewarded ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        RCustomEventListener rCustomEventListener = this.mCustomEventListener;
        if (rCustomEventListener != null) {
            rCustomEventListener.onAdFailedToShow();
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        this.mRewardedAd = null;
    }
}
