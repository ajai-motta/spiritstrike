package com.google.unity.ads.decagon;

import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError;

/* JADX INFO: loaded from: classes5.dex */
public interface UnityRewardedInterstitialAdCallback extends UnityFullScreenContentCallback, UnityPaidEventListener {
    void onRewardedInterstitialAdFailedToLoad(LoadAdError error);

    void onRewardedInterstitialAdLoaded();

    void onUserEarnedReward(String type, float amount);
}
