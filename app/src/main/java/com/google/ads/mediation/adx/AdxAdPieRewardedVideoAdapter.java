package com.google.ads.mediation.adx;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.adxcorp.ads.RewardedAd;
import com.adxcorp.ads.mediation.AdError;
import com.adxcorp.util.ADXLogUtil;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.rewarded.RewardItem;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class AdxAdPieRewardedVideoAdapter extends Adapter implements MediationRewardedAd {
    private static final String ADUNIT_ID = "adunit_id";
    private static final int ERROR_AD_NOT_READY = 103;
    private static final int ERROR_CONTEXT_NOT_ACTIVITY = 102;
    private static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    private static final String TAG = "AdxAdPieRewardedVideoAdapter";
    private Activity mActivity;
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mAdLoadCallback;
    private String mAdUnitId;
    private RewardedAd mRewardedAd;
    private MediationRewardedAdCallback mRewardedAdCallback;

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (!(context instanceof Activity)) {
            initializationCompleteCallback.onInitializationFailed("SDK requires an Activity context to initialize");
            return;
        }
        this.mActivity = (Activity) context;
        String string = "";
        for (MediationConfiguration mediationConfiguration : list) {
            if (mediationConfiguration.getFormat() == AdFormat.REWARDED) {
                string = mediationConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
            }
        }
        try {
            this.mAdUnitId = new JSONObject(string).getString("adunit_id");
            initializationCompleteCallback.onInitializationSucceeded();
        } catch (Exception unused) {
            Log.w(TAG, "Parameters are invalid.");
            initializationCompleteCallback.onInitializationFailed("Parameters are invalid.");
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String str = BuildConfig.SDK_VERSION_NAME;
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length >= 3) {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            int i3 = Integer.parseInt(strArrSplit[2]);
            if (strArrSplit.length >= 4) {
                i3 = (i3 * 100) + Integer.parseInt(strArrSplit[3]);
            }
            return new VersionInfo(i, i2, i3);
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", str));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        String str = BuildConfig.VERSION_NAME;
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length >= 4) {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            int i3 = (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]);
            if (strArrSplit.length >= 5) {
                i3 = (i3 * 100) + Integer.parseInt(strArrSplit[4]);
            }
            return new VersionInfo(i, i2, i3);
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", str));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        this.mAdLoadCallback = mediationAdLoadCallback;
        try {
            this.mAdUnitId = new JSONObject(mediationRewardedAdConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD)).getString("adunit_id");
            try {
                if (this.mActivity == null && (mediationRewardedAdConfiguration.getContext() instanceof Activity)) {
                    this.mActivity = (Activity) mediationRewardedAdConfiguration.getContext();
                }
            } catch (Exception unused) {
            }
            RewardedAd rewardedAd = new RewardedAd(this.mActivity, this.mAdUnitId);
            this.mRewardedAd = rewardedAd;
            rewardedAd.setRewardedAdListener(new RewardedAd.RewardedAdListener() { // from class: com.google.ads.mediation.adx.AdxAdPieRewardedVideoAdapter.1
                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdLoaded() {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
                    if (AdxAdPieRewardedVideoAdapter.this.mAdLoadCallback != null) {
                        AdxAdPieRewardedVideoAdapter adxAdPieRewardedVideoAdapter = AdxAdPieRewardedVideoAdapter.this;
                        adxAdPieRewardedVideoAdapter.mRewardedAdCallback = (MediationRewardedAdCallback) adxAdPieRewardedVideoAdapter.mAdLoadCallback.onSuccess(AdxAdPieRewardedVideoAdapter.this);
                    }
                }

                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdError(int i) {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Failure, " + i);
                    if (AdxAdPieRewardedVideoAdapter.this.mAdLoadCallback != null) {
                        AdxAdPieRewardedVideoAdapter.this.mAdLoadCallback.onFailure(AdxAdPieRewardedVideoAdapter.this.createSDKError(i, AdError.getMessage(i)));
                    }
                }

                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdClicked() {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
                }

                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdImpression() {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, "Impression");
                    if (AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback != null) {
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.onAdOpened();
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.onVideoStart();
                    }
                    if (AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback != null) {
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.reportAdImpression();
                    }
                }

                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdClosed() {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
                    if (AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback != null) {
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.onAdClosed();
                    }
                }

                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdRewarded() {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
                    RewardItem rewardItem = new RewardItem() { // from class: com.google.ads.mediation.adx.AdxAdPieRewardedVideoAdapter.1.1
                        @Override // com.google.android.gms.ads.rewarded.RewardItem
                        public int getAmount() {
                            return 1;
                        }

                        @Override // com.google.android.gms.ads.rewarded.RewardItem
                        public String getType() {
                            return "";
                        }
                    };
                    if (AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback != null) {
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.onVideoComplete();
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.onUserEarnedReward(rewardItem);
                    }
                }

                @Override // com.adxcorp.ads.RewardedAd.RewardedAdListener
                public void onAdFailedToShow() {
                    if (AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback != null) {
                        AdxAdPieRewardedVideoAdapter.this.mRewardedAdCallback.onAdFailedToShow(AdxAdPieRewardedVideoAdapter.this.createSDKError(103, "No ad to show."));
                    }
                }
            });
            this.mRewardedAd.loadAd();
        } catch (Exception unused2) {
            Log.w(TAG, "Parameters are invalid.");
            this.mAdLoadCallback.onFailure(createSDKError(101, "Parameters are invalid."));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        if (!(context instanceof Activity)) {
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(createSDKError(102, "AdMob requires an Activity context to show ads."));
                return;
            }
            return;
        }
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null && rewardedAd.isLoaded()) {
            this.mRewardedAd.show();
            return;
        }
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onAdFailedToShow(createSDKError(103, "No ad to show."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.gms.ads.AdError createSDKError(int i, String str) {
        return new com.google.android.gms.ads.AdError(i, str, "adx");
    }
}
