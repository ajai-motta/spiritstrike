package com.google.unity.ads.decagon;

import com.google.android.libraries.ads.mobile.sdk.common.FullScreenContentError;

/* JADX INFO: loaded from: classes5.dex */
public interface UnityFullScreenContentCallback {
    void onAdClicked();

    void onAdDismissedFullScreenContent();

    void onAdFailedToShowFullScreenContent(FullScreenContentError error);

    void onAdImpression();

    void onAdShowedFullScreenContent();
}
