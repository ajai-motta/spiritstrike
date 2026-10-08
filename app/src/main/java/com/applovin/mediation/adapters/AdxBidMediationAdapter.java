package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.common.CustomEvent;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.common.RCustomEventListener;
import com.adxcorp.ads.common.RewardedCustomEvent;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxBidMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxNativeAdAdapter {
    private static final String TAG = "AdxBidMediationAdapter";
    private CustomEvent mCustomEvent;

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void onDestroy() {
    }

    public AdxBidMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, null);
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getSdkVersion() {
        return ADXGDPR.ADX_SDK_VERSION;
    }

    @Override // com.applovin.mediation.adapter.MaxAdapter
    public String getAdapterVersion() {
        return ADXGDPR.ADX_SDK_VERSION + ".0";
    }

    @Override // com.applovin.mediation.adapter.MaxAdViewAdapter
    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity, MaxAdViewAdapterListener maxAdViewAdapterListener) {
        String str = TAG;
        ADXLogUtil.d(str, "loadAdViewAd - ServerParameters : " + maxAdapterResponseParameters.getServerParameters() + ", LocalExtraParameters : " + maxAdapterResponseParameters.getLocalExtraParameters());
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        if (localExtraParameters.containsKey("enable_bidding") && ((Boolean) localExtraParameters.get("enable_bidding")).booleanValue() && localExtraParameters.containsKey("custom_event")) {
            CustomEvent customEvent = (CustomEvent) localExtraParameters.get("custom_event");
            this.mCustomEvent = customEvent;
            if (customEvent != null) {
                if (isMatch(localExtraParameters, serverParameters)) {
                    ADXLogUtil.d(str, "onAdViewAdLoaded");
                    if (maxAdViewAdapterListener != null) {
                        maxAdViewAdapterListener.onAdViewAdLoaded(((BannerCustomEvent) this.mCustomEvent).getAdView());
                        return;
                    }
                    return;
                }
                if (maxAdViewAdapterListener != null) {
                    ADXLogUtil.d(str, "onAdViewAdLoadFailed - NO_FILL");
                    maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.NO_FILL);
                    return;
                }
                return;
            }
        }
        if (maxAdViewAdapterListener != null) {
            ADXLogUtil.d(str, "onAdViewAdLoadFailed - BAD_REQUEST");
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapters.MediationAdapterBase, com.applovin.mediation.adapter.MaxNativeAdAdapter
    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        String str = TAG;
        ADXLogUtil.d(str, "loadNativeAd - ServerParameters : " + maxAdapterResponseParameters.getServerParameters() + ", LocalExtraParameters : " + maxAdapterResponseParameters.getLocalExtraParameters());
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        if (localExtraParameters.containsKey("enable_bidding") && ((Boolean) localExtraParameters.get("enable_bidding")).booleanValue() && localExtraParameters.containsKey("custom_event")) {
            CustomEvent customEvent = (CustomEvent) localExtraParameters.get("custom_event");
            this.mCustomEvent = customEvent;
            if (customEvent != null) {
                if (!isMatch(localExtraParameters, serverParameters)) {
                    if (maxNativeAdAdapterListener != null) {
                        ADXLogUtil.d(str, "onNativeAdLoadFailed - NO_FILL");
                        maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.NO_FILL);
                        return;
                    }
                    return;
                }
                ADXLogUtil.d(str, "onNativeAdLoaded");
                MaxNativeAd maxNativeAdBuild = new MaxNativeAd.Builder().build();
                if (maxNativeAdAdapterListener != null) {
                    maxNativeAdAdapterListener.onNativeAdLoaded(maxNativeAdBuild, serverParameters);
                    return;
                }
                return;
            }
        }
        if (maxNativeAdAdapterListener != null) {
            ADXLogUtil.d(str, "onNativeAdLoadFailed - BAD_REQUEST");
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        String str = TAG;
        ADXLogUtil.d(str, "loadInterstitialAd - ServerParameters : " + maxAdapterResponseParameters.getServerParameters() + ", LocalExtraParameters : " + maxAdapterResponseParameters.getLocalExtraParameters());
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        if (localExtraParameters.containsKey("enable_bidding") && ((Boolean) localExtraParameters.get("enable_bidding")).booleanValue() && localExtraParameters.containsKey("custom_event")) {
            CustomEvent customEvent = (CustomEvent) localExtraParameters.get("custom_event");
            this.mCustomEvent = customEvent;
            if (customEvent != null) {
                if (isMatch(localExtraParameters, serverParameters)) {
                    ADXLogUtil.d(str, "onInterstitialAdLoaded");
                    if (maxInterstitialAdapterListener != null) {
                        maxInterstitialAdapterListener.onInterstitialAdLoaded();
                        return;
                    }
                    return;
                }
                ADXLogUtil.d(str, "onInterstitialAdLoadFailed - NO_FILL");
                if (maxInterstitialAdapterListener != null) {
                    maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.NO_FILL);
                    return;
                }
                return;
            }
        }
        ADXLogUtil.d(str, "onInterstitialAdLoadFailed - BAD_REQUEST");
        if (maxInterstitialAdapterListener != null) {
            maxInterstitialAdapterListener.onInterstitialAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxInterstitialAdapter
    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        ADXLogUtil.d(TAG, "showInterstitialAd - " + this.mCustomEvent);
        CustomEvent customEvent = this.mCustomEvent;
        if (customEvent != null && (customEvent instanceof IntersCustomEvent)) {
            customEvent.setCustomEventListener(new ICustomEventListener() { // from class: com.applovin.mediation.adapters.AdxBidMediationAdapter.1
                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdError() {
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdLoaded() {
                }

                @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
                public void onPaidEvent(double d) {
                }

                @Override // com.adxcorp.ads.common.ICustomEventListener, com.adxcorp.ads.common.CustomEventListener
                public void onAdImpression() {
                    MaxInterstitialAdapterListener maxInterstitialAdapterListener2 = maxInterstitialAdapterListener;
                    if (maxInterstitialAdapterListener2 != null) {
                        maxInterstitialAdapterListener2.onInterstitialAdDisplayed();
                    }
                }

                @Override // com.adxcorp.ads.common.ICustomEventListener
                public void onAdClosed() {
                    MaxInterstitialAdapterListener maxInterstitialAdapterListener2 = maxInterstitialAdapterListener;
                    if (maxInterstitialAdapterListener2 != null) {
                        maxInterstitialAdapterListener2.onInterstitialAdHidden();
                    }
                }

                @Override // com.adxcorp.ads.common.ICustomEventListener
                public void onAdFailedToShow() {
                    MaxInterstitialAdapterListener maxInterstitialAdapterListener2 = maxInterstitialAdapterListener;
                    if (maxInterstitialAdapterListener2 != null) {
                        maxInterstitialAdapterListener2.onInterstitialAdDisplayFailed(MaxAdapterError.INTERNAL_ERROR);
                    }
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdClicked() {
                    MaxInterstitialAdapterListener maxInterstitialAdapterListener2 = maxInterstitialAdapterListener;
                    if (maxInterstitialAdapterListener2 != null) {
                        maxInterstitialAdapterListener2.onInterstitialAdClicked();
                    }
                }
            });
            ((IntersCustomEvent) this.mCustomEvent).show();
        } else if (maxInterstitialAdapterListener != null) {
            maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.INTERNAL_ERROR);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        String str = TAG;
        ADXLogUtil.d(str, "loadRewardedAd - ServerParameters : " + maxAdapterResponseParameters.getServerParameters() + ", LocalExtraParameters : " + maxAdapterResponseParameters.getLocalExtraParameters());
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        if (localExtraParameters.containsKey("enable_bidding") && ((Boolean) localExtraParameters.get("enable_bidding")).booleanValue() && localExtraParameters.containsKey("custom_event")) {
            CustomEvent customEvent = (CustomEvent) localExtraParameters.get("custom_event");
            this.mCustomEvent = customEvent;
            if (customEvent != null) {
                if (isMatch(localExtraParameters, serverParameters)) {
                    ADXLogUtil.d(str, "onRewardedAdLoaded");
                    if (maxRewardedAdapterListener != null) {
                        maxRewardedAdapterListener.onRewardedAdLoaded();
                        return;
                    }
                    return;
                }
                ADXLogUtil.d(str, "onRewardedAdLoadFailed - NO_FILL");
                if (maxRewardedAdapterListener != null) {
                    maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.NO_FILL);
                    return;
                }
                return;
            }
        }
        ADXLogUtil.d(str, "onRewardedAdLoadFailed - BAD_REQUEST");
        if (maxRewardedAdapterListener != null) {
            maxRewardedAdapterListener.onRewardedAdLoadFailed(MaxAdapterError.BAD_REQUEST);
        }
    }

    @Override // com.applovin.mediation.adapter.MaxRewardedAdapter
    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxRewardedAdapterListener maxRewardedAdapterListener) {
        ADXLogUtil.d(TAG, "showRewardedAd - " + this.mCustomEvent);
        CustomEvent customEvent = this.mCustomEvent;
        if (customEvent != null && (customEvent instanceof RewardedCustomEvent)) {
            customEvent.setCustomEventListener(new RCustomEventListener() { // from class: com.applovin.mediation.adapters.AdxBidMediationAdapter.2
                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdError() {
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdLoaded() {
                }

                @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
                public void onPaidEvent(double d) {
                }

                @Override // com.adxcorp.ads.common.RCustomEventListener, com.adxcorp.ads.common.CustomEventListener
                public void onAdImpression() {
                    MaxRewardedAdapterListener maxRewardedAdapterListener2 = maxRewardedAdapterListener;
                    if (maxRewardedAdapterListener2 != null) {
                        maxRewardedAdapterListener2.onRewardedAdDisplayed();
                    }
                }

                @Override // com.adxcorp.ads.common.RCustomEventListener
                public void onAdClosed() {
                    MaxRewardedAdapterListener maxRewardedAdapterListener2 = maxRewardedAdapterListener;
                    if (maxRewardedAdapterListener2 != null) {
                        maxRewardedAdapterListener2.onRewardedAdHidden();
                    }
                }

                @Override // com.adxcorp.ads.common.RCustomEventListener
                public void onAdRewarded() {
                    MaxReward reward = AdxBidMediationAdapter.this.getReward();
                    MaxRewardedAdapterListener maxRewardedAdapterListener2 = maxRewardedAdapterListener;
                    if (maxRewardedAdapterListener2 != null) {
                        maxRewardedAdapterListener2.onUserRewarded(reward);
                    }
                }

                @Override // com.adxcorp.ads.common.RCustomEventListener
                public void onAdFailedToShow() {
                    MaxRewardedAdapterListener maxRewardedAdapterListener2 = maxRewardedAdapterListener;
                    if (maxRewardedAdapterListener2 != null) {
                        maxRewardedAdapterListener2.onRewardedAdDisplayFailed(MaxAdapterError.INTERNAL_ERROR);
                    }
                }

                @Override // com.adxcorp.ads.common.CustomEventListener
                public void onAdClicked() {
                    MaxRewardedAdapterListener maxRewardedAdapterListener2 = maxRewardedAdapterListener;
                    if (maxRewardedAdapterListener2 != null) {
                        maxRewardedAdapterListener2.onRewardedAdClicked();
                    }
                }
            });
            ((RewardedCustomEvent) this.mCustomEvent).show();
        } else if (maxRewardedAdapterListener != null) {
            maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.INTERNAL_ERROR);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[PHI: r3
  0x0042: PHI (r3v3 double) = (r3v1 double), (r3v6 double), (r3v6 double) binds: [B:17:0x002f, B:8:0x0016, B:10:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isMatch(java.util.Map r8, android.os.Bundle r9) {
        /*
            r7 = this;
            java.lang.String r0 = "adx_ecpm"
            r1 = 0
            boolean r3 = r8.containsKey(r0)     // Catch: java.lang.Exception -> L2d
            if (r3 == 0) goto L15
            java.lang.Object r8 = r8.get(r0)     // Catch: java.lang.Exception -> L2d
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L2d
            double r3 = java.lang.Double.parseDouble(r8)     // Catch: java.lang.Exception -> L2d
            goto L16
        L15:
            r3 = r1
        L16:
            if (r9 == 0) goto L42
            java.lang.String r8 = "custom_parameters"
            android.os.Bundle r8 = r9.getBundle(r8)     // Catch: java.lang.Exception -> L2b
            if (r8 == 0) goto L42
            java.lang.String r9 = "floor_price"
            java.lang.String r8 = r8.getString(r9)     // Catch: java.lang.Exception -> L2b
            double r8 = java.lang.Double.parseDouble(r8)     // Catch: java.lang.Exception -> L2b
            goto L43
        L2b:
            r8 = move-exception
            goto L2f
        L2d:
            r8 = move-exception
            r3 = r1
        L2f:
            java.lang.String r9 = com.applovin.mediation.adapters.AdxBidMediationAdapter.TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "Parameter Parsing error : "
            r0.<init>(r5)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.adxcorp.util.ADXLogUtil.d(r9, r8)
        L42:
            r8 = r1
        L43:
            java.lang.String r0 = com.applovin.mediation.adapters.AdxBidMediationAdapter.TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "floorPrice : "
            r5.<init>(r6)
            r5.append(r8)
            java.lang.String r6 = ", ecpm : "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.adxcorp.util.ADXLogUtil.d(r0, r5)
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            r5 = 0
            if (r0 == 0) goto L6e
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L68
            goto L6e
        L68:
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 < 0) goto L6e
            r8 = 1
            return r8
        L6e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.mediation.adapters.AdxBidMediationAdapter.isMatch(java.util.Map, android.os.Bundle):boolean");
    }
}
