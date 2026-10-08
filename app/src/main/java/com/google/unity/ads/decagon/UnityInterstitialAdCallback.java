package com.google.unity.ads.decagon;

import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError;

/* JADX INFO: loaded from: classes5.dex */
public interface UnityInterstitialAdCallback extends UnityFullScreenContentCallback, UnityPaidEventListener {
    void onInterstitialAdFailedToLoad(LoadAdError error);

    void onInterstitialAdLoaded();
}
