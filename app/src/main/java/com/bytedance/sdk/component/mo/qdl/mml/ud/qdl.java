package com.bytedance.sdk.component.mo.qdl.mml.ud;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private int qdl;
    private int ud;

    public int qdl() {
        return this.qdl;
    }

    public int ud() {
        return this.ud;
    }

    qdl(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.qdl = i;
        this.ud = i2;
    }

    public static qdl lnr() {
        return new qdl(1, 100, 172800000L);
    }

    public static qdl mml() {
        return new qdl(1, 100, -1L);
    }

    public static qdl mzz() {
        return new qdl(3, 100, 172800000L);
    }
}
