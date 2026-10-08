package com.adxcorp.ads.common;

/* JADX INFO: loaded from: classes2.dex */
public enum FullScreenState {
    NOT_READY,
    READY,
    SHOW;

    public boolean isReady() {
        return this == READY;
    }
}
