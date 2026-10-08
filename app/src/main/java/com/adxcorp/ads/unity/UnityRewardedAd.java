package com.adxcorp.ads.unity;

import com.adxcorp.ads.RewardedAd;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class UnityRewardedAd {
    private RewardedAd mRewardedAd;

    public UnityRewardedAd(final String str, final RewardedAd.RewardedAdListener rewardedAdListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.1
            @Override // java.lang.Runnable
            public void run() {
                UnityRewardedAd.this.mRewardedAd = new RewardedAd(UnityPlayer.currentActivity, str);
                UnityRewardedAd.this.mRewardedAd.setRewardedAdListener(rewardedAdListener);
            }
        });
    }

    public void destroy() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.2
            @Override // java.lang.Runnable
            public void run() {
                if (UnityRewardedAd.this.mRewardedAd != null) {
                    UnityRewardedAd.this.mRewardedAd.destroy();
                    UnityRewardedAd.this.mRewardedAd = null;
                }
            }
        });
    }

    public void loadAd() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.3
            @Override // java.lang.Runnable
            public void run() {
                if (UnityRewardedAd.this.mRewardedAd != null) {
                    UnityRewardedAd.this.mRewardedAd.loadAd();
                }
            }
        });
    }

    public void show() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.4
            @Override // java.lang.Runnable
            public void run() {
                if (UnityRewardedAd.this.mRewardedAd == null || !UnityRewardedAd.this.mRewardedAd.isLoaded()) {
                    return;
                }
                UnityRewardedAd.this.mRewardedAd.show();
            }
        });
    }

    public boolean isLoaded() {
        RewardedAd rewardedAd = this.mRewardedAd;
        if (rewardedAd != null) {
            return rewardedAd.isLoaded();
        }
        return false;
    }

    public void setUserIdForSSV(final String str) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.5
            @Override // java.lang.Runnable
            public void run() {
                if (UnityRewardedAd.this.mRewardedAd != null) {
                    UnityRewardedAd.this.mRewardedAd.setUserIdForSSV(str);
                }
            }
        });
    }

    public void setCustomDataForSSV(final String str) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.6
            @Override // java.lang.Runnable
            public void run() {
                if (UnityRewardedAd.this.mRewardedAd != null) {
                    UnityRewardedAd.this.mRewardedAd.setCustomDataForSSV(str);
                }
            }
        });
    }

    public void setOnPaidEventListener(final OnPaidEventListener onPaidEventListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityRewardedAd.7
            @Override // java.lang.Runnable
            public void run() {
                if (UnityRewardedAd.this.mRewardedAd != null) {
                    UnityRewardedAd.this.mRewardedAd.setOnPaidEventListener(onPaidEventListener);
                }
            }
        });
    }
}
