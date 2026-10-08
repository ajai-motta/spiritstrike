package com.adxcorp.ads.nativeads.event;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface NativeAdImpressionListener {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(View view);

    void setImpressionRecorded();
}
