package com.adxcorp.ads.mediation.event;

import com.adxcorp.ads.common.CustomEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface AdEventListener {
    void onAdFailedToLoad(int i);

    void onMediationLoaded(CustomEvent customEvent);
}
