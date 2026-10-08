package com.google.ads.mediation.pangle.renderer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class PangleBannerAd implements MediationBannerAd, PAGBannerAdInteractionListener {
    public static final String ERROR_MESSAGE_BANNER_SIZE_MISMATCH = "Failed to request banner ad from Pangle. Invalid banner size.";
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> adLoadCallback;
    private MediationBannerAdCallback bannerAdCallback;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;
    FrameLayout wrappedAdView;

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
    }

    public PangleBannerAd(MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void render(final MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        Bundle serverParameters = mediationBannerAdConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load banner ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = mediationBannerAdConfiguration.getBidResponse();
            final Context context = mediationBannerAdConfiguration.getContext();
            this.pangleInitializer.initialize(context, serverParameters.getString(PangleConstants.APP_ID), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleBannerAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGBannerSize bannerSizeFromGoogleAdSize = PangleBannerAd.getBannerSizeFromGoogleAdSize(context, mediationBannerAdConfiguration.getAdSize());
                    if (bannerSizeFromGoogleAdSize == null) {
                        AdError adErrorCreateAdapterError2 = PangleConstants.createAdapterError(102, PangleBannerAd.ERROR_MESSAGE_BANNER_SIZE_MISMATCH);
                        Log.w(PangleMediationAdapter.TAG, adErrorCreateAdapterError2.toString());
                        PangleBannerAd.this.adLoadCallback.onFailure(adErrorCreateAdapterError2);
                    } else {
                        PangleBannerAd.this.wrappedAdView = new FrameLayout(context);
                        PAGBannerRequest pAGBannerRequestCreatePagBannerRequest = PangleBannerAd.this.pangleFactory.createPagBannerRequest(bannerSizeFromGoogleAdSize);
                        pAGBannerRequestCreatePagBannerRequest.setAdString(bidResponse);
                        PangleRequestHelper.setWatermarkString(pAGBannerRequestCreatePagBannerRequest, bidResponse, mediationBannerAdConfiguration);
                        PangleBannerAd.this.pangleSdkWrapper.loadBannerAd(string, pAGBannerRequestCreatePagBannerRequest, new PAGBannerAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleBannerAd.1.1
                            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
                            public void onError(int i, String str) {
                                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i + "(" + str + ")");
                                AdError adErrorCreateSdkError = PangleConstants.createSdkError(i, str);
                                Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                                PangleBannerAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                            public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                                ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                                pAGBannerAd.setAdInteractionListener(PangleBannerAd.this);
                                PangleBannerAd.this.wrappedAdView.addView(pAGBannerAd.getBannerView());
                                PangleBannerAd.this.bannerAdCallback = (MediationBannerAdCallback) PangleBannerAd.this.adLoadCallback.onSuccess(PangleBannerAd.this);
                            }
                        });
                    }
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleBannerAd.this.adLoadCallback.onFailure(adError);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View getView() {
        return this.wrappedAdView;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_BANNER, "Impression");
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_PANGLE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }

    static PAGBannerSize getBannerSizeFromGoogleAdSize(Context context, AdSize adSize) {
        if (adSize == null) {
            return null;
        }
        if (adSize.getWidth() == PAGBannerSize.BANNER_W_320_H_50.getWidth() && adSize.getHeight() == PAGBannerSize.BANNER_W_320_H_50.getHeight()) {
            return PAGBannerSize.BANNER_W_320_H_50;
        }
        if (adSize.getWidth() == PAGBannerSize.BANNER_W_300_H_250.getWidth() && adSize.getHeight() == PAGBannerSize.BANNER_W_300_H_250.getHeight()) {
            return PAGBannerSize.BANNER_W_300_H_250;
        }
        if (adSize.getWidth() == PAGBannerSize.BANNER_W_728_H_90.getWidth() && adSize.getHeight() == PAGBannerSize.BANNER_W_728_H_90.getHeight()) {
            return PAGBannerSize.BANNER_W_728_H_90;
        }
        PAGBannerSize currentOrientationAnchoredAdaptiveBannerAdSize = PAGBannerSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adSize.getWidth());
        return (adSize.getWidth() == currentOrientationAnchoredAdaptiveBannerAdSize.getWidth() && adSize.getHeight() == currentOrientationAnchoredAdaptiveBannerAdSize.getHeight()) ? currentOrientationAnchoredAdaptiveBannerAdSize : PAGBannerSize.getInlineAdaptiveBannerAdSize(adSize.getWidth(), adSize.getHeight());
    }
}
