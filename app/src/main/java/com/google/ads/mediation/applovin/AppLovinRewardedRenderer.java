package com.google.ads.mediation.applovin;

import android.os.Bundle;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AppLovinRewardedRenderer implements MediationRewardedAd, AppLovinAdLoadListener, AppLovinAdRewardListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    protected static final String ERROR_MSG_AD_NOT_READY = "Ad not ready to show.";
    protected static final String ERROR_MSG_MULTIPLE_REWARDED_AD = "Cannot load multiple rewarded ads with the same Zone ID. Let the first ad finish loading before attempting to load another.";
    protected static final String TAG = "AppLovinRewardedRenderer";
    protected final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> adLoadCallback;
    protected final AppLovinAdFactory appLovinAdFactory;
    protected final AppLovinInitializer appLovinInitializer;
    protected AppLovinSdk appLovinSdk;
    protected final AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper;
    protected AppLovinIncentivizedInterstitial incentivizedInterstitial;
    protected Bundle networkExtras;
    protected MediationRewardedAdCallback rewardedAdCallback;

    public abstract void loadAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration);

    protected AppLovinRewardedRenderer(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory, AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper) {
        this.adLoadCallback = mediationAdLoadCallback;
        this.appLovinInitializer = appLovinInitializer;
        this.appLovinAdFactory = appLovinAdFactory;
        this.appLovinSdkUtilsWrapper = appLovinSdkUtilsWrapper;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
        Log.i(TAG, "Rewarded video did load ad.");
        this.appLovinSdkUtilsWrapper.runOnUiThread(new Runnable() { // from class: com.google.ads.mediation.applovin.AppLovinRewardedRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                AppLovinRewardedRenderer appLovinRewardedRenderer = AppLovinRewardedRenderer.this;
                appLovinRewardedRenderer.rewardedAdCallback = appLovinRewardedRenderer.adLoadCallback.onSuccess(AppLovinRewardedRenderer.this);
            }
        });
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        final AdError adError = AppLovinUtils.getAdError(i);
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, "Failure, " + i + " (" + adError.getMessage() + ")");
        Log.w(TAG, adError.toString());
        this.appLovinSdkUtilsWrapper.runOnUiThread(new Runnable() { // from class: com.google.ads.mediation.applovin.AppLovinRewardedRenderer.2
            @Override // java.lang.Runnable
            public void run() {
                AppLovinRewardedRenderer.this.adLoadCallback.onFailure(adError);
            }
        });
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, "Impression");
        Log.d(TAG, "Rewarded video displayed.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onAdOpened();
        this.rewardedAdCallback.reportAdImpression();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
        Log.d(TAG, "Rewarded video dismissed.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
        Log.d(TAG, "Rewarded video clicked.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        Log.d(TAG, "Rewarded video playback began.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoStart();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        Log.d(TAG, "Rewarded video playback ended at playback percent: " + d + "%.");
        if (this.rewardedAdCallback == null || !z) {
            return;
        }
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
        this.rewardedAdCallback.onUserEarnedReward();
        this.rewardedAdCallback.onVideoComplete();
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        Log.e(TAG, "Rewarded video validation request for ad did exceed quota with response: " + map);
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        Log.e(TAG, "Rewarded video validation request for ad failed with error code: " + i);
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        Log.e(TAG, "Rewarded video validation request was rejected with response: " + map);
    }

    @Override // com.applovin.sdk.AppLovinAdRewardListener
    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        String str = map.get("currency");
        int i = (int) Double.parseDouble(map.get(AppLovinEventParameters.REVENUE_AMOUNT));
        Log.d(TAG, "Rewarded " + i + ServerSentEventKt.SPACE + str);
    }
}
