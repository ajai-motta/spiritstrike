package com.google.unity.ads;

import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: loaded from: classes5.dex */
public interface UnityInterstitialAdCallback extends UnityPaidEventListener, UnityFullScreenContentCallback {
    void onInterstitialAdFailedToLoad(LoadAdError error);

    void onInterstitialAdLoaded();
}
