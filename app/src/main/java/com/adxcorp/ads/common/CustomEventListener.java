package com.adxcorp.ads.common;

/* JADX INFO: loaded from: classes2.dex */
public interface CustomEventListener {
    void onAdClicked();

    void onAdError();

    void onAdImpression();

    void onAdLoaded();

    void onPaidEvent(double d);
}
