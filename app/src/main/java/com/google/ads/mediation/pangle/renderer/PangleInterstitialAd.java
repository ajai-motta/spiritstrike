package com.google.ads.mediation.pangle.renderer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class PangleInterstitialAd implements MediationInterstitialAd {
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> adLoadCallback;
    private MediationInterstitialAdCallback interstitialAdCallback;
    private PAGInterstitialAd pagInterstitialAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;

    public PangleInterstitialAd(MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void render(final MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        Bundle serverParameters = mediationInterstitialAdConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load interstitial ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = mediationInterstitialAdConfiguration.getBidResponse();
            this.pangleInitializer.initialize(mediationInterstitialAdConfiguration.getContext(), serverParameters.getString(PangleConstants.APP_ID), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleInterstitialAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGInterstitialRequest pAGInterstitialRequestCreatePagInterstitialRequest = PangleInterstitialAd.this.pangleFactory.createPagInterstitialRequest();
                    pAGInterstitialRequestCreatePagInterstitialRequest.setAdString(bidResponse);
                    PangleRequestHelper.setWatermarkString(pAGInterstitialRequestCreatePagInterstitialRequest, bidResponse, mediationInterstitialAdConfiguration);
                    PangleInterstitialAd.this.pangleSdkWrapper.loadInterstitialAd(string, pAGInterstitialRequestCreatePagInterstitialRequest, new PAGInterstitialAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleInterstitialAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
                        public void onError(int i, String str) {
                            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + i + "(" + str + ")");
                            AdError adErrorCreateSdkError = PangleConstants.createSdkError(i, str);
                            Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                            PangleInterstitialAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                            PangleInterstitialAd.this.interstitialAdCallback = (MediationInterstitialAdCallback) PangleInterstitialAd.this.adLoadCallback.onSuccess(PangleInterstitialAd.this);
                            PangleInterstitialAd.this.pagInterstitialAd = pAGInterstitialAd;
                        }
                    });
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleInterstitialAd.this.adLoadCallback.onFailure(adError);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.pagInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
                if (PangleInterstitialAd.this.interstitialAdCallback != null) {
                    PangleInterstitialAd.this.interstitialAdCallback.onAdOpened();
                    PangleInterstitialAd.this.interstitialAdCallback.reportAdImpression();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (PangleInterstitialAd.this.interstitialAdCallback != null) {
                    PangleInterstitialAd.this.interstitialAdCallback.reportAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                if (PangleInterstitialAd.this.interstitialAdCallback != null) {
                    PangleInterstitialAd.this.interstitialAdCallback.onAdClosed();
                }
            }
        });
        if (context instanceof Activity) {
            this.pagInterstitialAd.show((Activity) context);
        } else {
            this.pagInterstitialAd.show(null);
        }
    }
}
