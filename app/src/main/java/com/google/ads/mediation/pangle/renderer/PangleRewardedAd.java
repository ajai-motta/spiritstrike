package com.google.ads.mediation.pangle.renderer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class PangleRewardedAd implements MediationRewardedAd {
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> adLoadCallback;
    private PAGRewardedAd pagRewardedAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;
    private MediationRewardedAdCallback rewardedAdCallback;

    public PangleRewardedAd(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void render(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load rewarded ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = mediationRewardedAdConfiguration.getBidResponse();
            this.pangleInitializer.initialize(mediationRewardedAdConfiguration.getContext(), serverParameters.getString(PangleConstants.APP_ID), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleRewardedAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGRewardedRequest pAGRewardedRequestCreatePagRewardedRequest = PangleRewardedAd.this.pangleFactory.createPagRewardedRequest();
                    pAGRewardedRequestCreatePagRewardedRequest.setAdString(bidResponse);
                    PangleRequestHelper.setWatermarkString(pAGRewardedRequestCreatePagRewardedRequest, bidResponse, mediationRewardedAdConfiguration);
                    PangleRewardedAd.this.pangleSdkWrapper.loadRewardedAd(string, pAGRewardedRequestCreatePagRewardedRequest, new PAGRewardedAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleRewardedAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
                        public void onError(int i, String str) {
                            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, "Failure, " + i + "(" + str + ")");
                            AdError adErrorCreateSdkError = PangleConstants.createSdkError(i, str);
                            Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                            PangleRewardedAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                            PangleRewardedAd.this.rewardedAdCallback = (MediationRewardedAdCallback) PangleRewardedAd.this.adLoadCallback.onSuccess(PangleRewardedAd.this);
                            PangleRewardedAd.this.pagRewardedAd = pAGRewardedAd;
                        }
                    });
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleRewardedAd.this.adLoadCallback.onFailure(adError);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.pagRewardedAd.setAdInteractionListener(new PAGRewardedAdInteractionListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleRewardedAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, "Impression");
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.onAdOpened();
                    PangleRewardedAd.this.rewardedAdCallback.reportAdImpression();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.reportAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.onAdClosed();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
            public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.onUserEarnedReward();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
            public void onUserEarnedRewardFail(int i, String str) {
                Log.d(PangleMediationAdapter.TAG, PangleConstants.createSdkError(i, String.format("Failed to reward user: %s", str)).toString());
            }
        });
        if (context instanceof Activity) {
            this.pagRewardedAd.show((Activity) context);
        } else {
            this.pagRewardedAd.show(null);
        }
    }
}
