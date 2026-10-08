package com.bytedance.sdk.component.lnr.qdl;

import android.os.SystemClock;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    long jpc;
    long lnr;
    long mml;
    long mo;
    long mzz;
    long qdl = SystemClock.elapsedRealtime();
    long ud;
    long wd;

    public void qdl() {
        this.lnr = SystemClock.elapsedRealtime();
    }

    public void ud() {
        this.mml = SystemClock.elapsedRealtime();
    }

    public void lnr() {
        this.mzz = SystemClock.elapsedRealtime();
    }

    public long mml() {
        return this.qdl;
    }

    public void mzz() {
        this.mo = SystemClock.elapsedRealtime();
    }

    public long mo() {
        return this.mo;
    }

    public long wd() {
        return this.lnr;
    }

    public long jpc() {
        return this.mml;
    }

    public long tvp() {
        return this.mzz;
    }

    public long to() {
        return this.wd;
    }

    public void rq() {
        this.wd = SystemClock.elapsedRealtime();
    }

    public long fs() {
        return this.jpc;
    }

    public void exu() {
        this.jpc = SystemClock.elapsedRealtime();
    }

    public long rdp() {
        return this.ud;
    }

    public void bjy() {
        this.ud = SystemClock.elapsedRealtime();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.qdl + ", asyncCallExecTs=" + this.ud + ", requestStartExecTs=" + this.lnr + ", requestConnectStartTs=" + this.mml + ", requestConnectFinishTs=" + this.mzz + ", reqCallServerStartTs=" + this.wd + ", reqCallServerFinishTs=" + this.jpc + AbstractJsonLexerKt.END_OBJ;
    }
}
