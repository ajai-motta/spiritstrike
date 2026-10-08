package com.google.ads.mediation.facebook;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.ads.Ad;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class FacebookRewardedAd implements MediationRewardedAd, RewardedVideoAdExtendedListener {
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private final MetaFactory metaFactory;
    private RewardedVideoAd rewardedAd;
    private MediationRewardedAdCallback rewardedAdCallback;
    private final AtomicBoolean showAdCalled = new AtomicBoolean();
    private final AtomicBoolean didRewardedAdClose = new AtomicBoolean();

    public FacebookRewardedAd(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        this.metaFactory = metaFactory;
    }

    public void render(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD);
        Context context = mediationRewardedAdConfiguration.getContext();
        String placementID = FacebookMediationAdapter.getPlacementID(mediationRewardedAdConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.mediationAdLoadCallback.onFailure(adError);
        } else {
            FacebookMediationAdapter.setMixedAudience(mediationRewardedAdConfiguration);
            this.rewardedAd = this.metaFactory.createRewardedAd(context, placementID);
            if (!TextUtils.isEmpty(mediationRewardedAdConfiguration.getWatermark())) {
                this.rewardedAd.setExtraHints(new ExtraHints.Builder().mediationData(mediationRewardedAdConfiguration.getWatermark()).build());
            }
            RewardedVideoAd rewardedVideoAd = this.rewardedAd;
            rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).withBid(mediationRewardedAdConfiguration.getBidResponse()).withAdExperience(getAdExperienceType()).build());
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.showAdCalled.set(true);
        if (!this.rewardedAd.show()) {
            AdError adError = new AdError(110, "Failed to present rewarded ad.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
            MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(adError);
            }
            this.rewardedAd.destroy();
            return;
        }
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.rewardedAdCallback;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onVideoStart();
            this.rewardedAdCallback.onAdOpened();
        }
    }

    AdExperienceType getAdExperienceType() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_REWARD);
        this.rewardedAdCallback.onVideoComplete();
        this.rewardedAdCallback.onUserEarnedReward();
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        if (this.showAdCalled.get()) {
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(adError2);
            }
        } else {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, "Failure, " + adError.getErrorCode() + "(" + adError.getErrorMessage() + ")");
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
            if (mediationAdLoadCallback != null) {
                mediationAdLoadCallback.onFailure(adError2);
            }
        }
        this.rewardedAd.destroy();
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_LOAD_SUCCESS);
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.rewardedAdCallback = mediationAdLoadCallback.onSuccess(this);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLICK);
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, "Impression");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.rewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdImpression();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoClosed() {
        if (!this.didRewardedAdClose.getAndSet(true) && this.rewardedAdCallback != null) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
            this.rewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdExtendedListener
    public void onRewardedVideoActivityDestroyed() {
        if (!this.didRewardedAdClose.getAndSet(true) && this.rewardedAdCallback != null) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_RV, ADXLogUtil.EVENT_CLOSED);
            this.rewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.rewardedAd;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }
}
