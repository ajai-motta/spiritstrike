package com.bytedance.sdk.openadsdk.component.jpc;

/* JADX INFO: loaded from: classes3.dex */
public final class qdl {
    private boolean lnr;
    private long mml;
    private float qdl;
    private long ud;

    public void qdl(boolean z) {
        this.lnr = z;
    }

    public long qdl() {
        return this.mml;
    }

    public void qdl(long j) {
        this.mml = j;
    }

    public float ud() {
        return this.qdl;
    }

    public void qdl(float f) {
        StringBuilder sb = new StringBuilder("setTotalTime() called with: time = [");
        sb.append(f);
        sb.append("]");
        this.qdl = f;
    }

    public long lnr() {
        return this.ud;
    }

    public void ud(long j) {
        this.ud = j;
    }
}
