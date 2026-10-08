package com.adxcorp.ads.common;

/* JADX INFO: loaded from: classes2.dex */
public interface RCustomEventListener extends CustomEventListener {
    void onAdClosed();

    void onAdFailedToShow();

    @Override // com.adxcorp.ads.common.CustomEventListener
    void onAdImpression();

    void onAdRewarded();

    @Override // com.adxcorp.ads.common.CustomEventListener
    void onPaidEvent(double d);
}
