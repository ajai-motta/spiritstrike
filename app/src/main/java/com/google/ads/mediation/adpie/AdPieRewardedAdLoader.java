package com.google.ads.mediation.adpie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdPieError;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.RewardedAd;
import com.google.ads.mediation.AdErrorUtil;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class AdPieRewardedAdLoader implements MediationRewardedAd, RewardedAd.RewardedAdListener {
    private static final String APP_ID = "app_id";
    private static final String DOMAIN = "com.google.ads.mediation.adpie";
    private static final String SLOT_ID = "slot_id";
    private String TAG = "AdPieRewardedAdLoader";
    private String mAppId;
    private RewardedAd mRewardedAd;
    private String mSlotId;
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private final MediationRewardedAdConfiguration mediationRewardedAdConfiguration;
    private MediationRewardedAdCallback rewardedAdCallback;

    public AdPieRewardedAdLoader(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mediationRewardedAdConfiguration = mediationRewardedAdConfiguration;
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void loadAd() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        try {
            Log.d(this.TAG, "severParameters : " + this.mediationRewardedAdConfiguration.getServerParameters());
            JSONObject jSONObject = new JSONObject(this.mediationRewardedAdConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD));
            this.mAppId = jSONObject.getString("app_id");
            this.mSlotId = jSONObject.getString(SLOT_ID);
            Log.d(this.TAG, "AppId : " + this.mAppId + ", SlotId : " + this.mSlotId);
            if (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSlotId)) {
                this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
                return;
            }
            final Context context = this.mediationRewardedAdConfiguration.getContext();
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(context, this.mAppId, new AdPieSDK.OnInitializedListener() { // from class: com.google.ads.mediation.adpie.AdPieRewardedAdLoader.1
                    @Override // com.gomfactory.adpie.sdk.AdPieSDK.OnInitializedListener
                    public void onCompleted(boolean z) {
                        if (!z) {
                            AdPieRewardedAdLoader.this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(104, "Failed to initialize SDK.", AdPieRewardedAdLoader.DOMAIN));
                        } else {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.ads.mediation.adpie.AdPieRewardedAdLoader.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdPieRewardedAdLoader.this.mRewardedAd = new RewardedAd(context, AdPieRewardedAdLoader.this.mSlotId);
                                    AdPieRewardedAdLoader.this.mRewardedAd.setAdListener(AdPieRewardedAdLoader.this);
                                    AdPieRewardedAdLoader.this.mRewardedAd.load();
                                }
                            });
                        }
                    }
                });
                return;
            }
            RewardedAd rewardedAd = new RewardedAd(context, this.mSlotId);
            this.mRewardedAd = rewardedAd;
            rewardedAd.setAdListener(this);
            this.mRewardedAd.load();
        } catch (Exception e) {
            e.printStackTrace();
            this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && rewardedAd.isLoaded()) {
            this.mRewardedAd.show();
        } else {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
            this.rewardedAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(0, "No ad to show.", DOMAIN));
        }
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdLoaded() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
        this.rewardedAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdFailedToLoad(int i) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i + AdPieError.getMessage(i));
        this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(i, AdPieError.getMessage(i), DOMAIN));
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdShown() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Impression");
        this.rewardedAdCallback.onAdOpened();
        this.rewardedAdCallback.onVideoStart();
        this.rewardedAdCallback.reportAdImpression();
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdClicked() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
        this.rewardedAdCallback.reportAdClicked();
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdDismissed() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
        this.rewardedAdCallback.onAdClosed();
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdRewarded() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
        this.rewardedAdCallback.onVideoComplete();
        this.rewardedAdCallback.onUserEarnedReward();
    }

    @Override // com.gomfactory.adpie.sdk.RewardedAd.RewardedAdListener
    public void onAdFailedToShow() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        this.rewardedAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(103, "Failed To show", DOMAIN));
    }
}
