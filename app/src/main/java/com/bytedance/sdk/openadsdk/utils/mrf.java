package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public class mrf {
    public long qdl;
    private long ud;

    public long qdl() {
        return this.ud;
    }

    private mrf(boolean z) {
        if (z) {
            mzz();
        }
    }

    public static mrf ud() {
        return new mrf(true);
    }

    public static mrf lnr() {
        return new mrf(false);
    }

    public long mml() {
        return SystemClock.elapsedRealtime() - this.ud;
    }

    public long qdl(mrf mrfVar) {
        return Math.abs(mrfVar.ud - this.ud);
    }

    public void mzz() {
        this.qdl = System.currentTimeMillis();
        this.ud = SystemClock.elapsedRealtime();
    }

    public boolean mo() {
        return this.ud > 0;
    }

    public String toString() {
        return String.valueOf(this.qdl);
    }
}
