package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdManagerInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AdManagerInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private com.google.android.gms.ads.admanager.AdManagerInterstitialAd mInterstitialAd;

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = iCustomEventListener;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
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
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.d(str, "The AdUnitId cannot be null.");
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
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        Bundle bundle = new Bundle();
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(this.mActivity)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            bundle.putString("npa", "1");
        }
        com.google.android.gms.ads.admanager.AdManagerInterstitialAd.load(this.mActivity, this.mAdUnitId, new AdManagerAdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), new AdManagerInterstitialAdLoadCallback() { // from class: com.adxcorp.ads.adapter.AdManagerInterstitialAd.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(com.google.android.gms.ads.admanager.AdManagerInterstitialAd adManagerInterstitialAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                AdManagerInterstitialAd.this.mInterstitialAd = adManagerInterstitialAd;
                AdManagerInterstitialAd.this.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.adxcorp.ads.adapter.AdManagerInterstitialAd.1.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        ADXLogUtil.d(AdManagerInterstitialAd.TAG, "onAdFailedToShowFullScreenContent");
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
                        if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                            AdManagerInterstitialAd.this.mCustomEventListener.onAdFailedToShow();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        AdManagerInterstitialAd.this.mInterstitialAd = null;
                        ADXLogUtil.d(AdManagerInterstitialAd.TAG, "onAdShowedFullScreenContent");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                        if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                            AdManagerInterstitialAd.this.mCustomEventListener.onAdClosed();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                        if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                            AdManagerInterstitialAd.this.mCustomEventListener.onAdImpression();
                        }
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                        if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                            AdManagerInterstitialAd.this.mCustomEventListener.onAdClicked();
                        }
                    }
                });
                AdManagerInterstitialAd.this.mInterstitialAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdManagerInterstitialAd.1.2
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(AdValue adValue) {
                        double valueMicros = adValue.getValueMicros() / 1000000.0d;
                        double d = 1000.0d * valueMicros;
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(AdManagerInterstitialAd.TAG, "AdManager onPaidEvent - CurrencyCode : " + adValue.getCurrencyCode() + ", Revenue : " + valueMicros + ", PrecisionType : " + adValue.getPrecisionType() + ", ecpm : " + d);
                        }
                        if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                            AdManagerInterstitialAd.this.mCustomEventListener.onPaidEvent(d);
                        }
                    }
                });
                if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                    AdManagerInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
                if (AdManagerInterstitialAd.this.mCustomEventListener != null) {
                    AdManagerInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }
        });
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        String str = TAG;
        ADXLogUtil.d(str, ":::show:::");
        com.google.android.gms.ads.admanager.AdManagerInterstitialAd adManagerInterstitialAd = this.mInterstitialAd;
        if (adManagerInterstitialAd != null) {
            adManagerInterstitialAd.show(this.mActivity);
            return;
        }
        ADXLogUtil.d(str, "Interstitial ad wasn't loaded yet.");
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMANAGER, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        this.mInterstitialAd = null;
    }
}
