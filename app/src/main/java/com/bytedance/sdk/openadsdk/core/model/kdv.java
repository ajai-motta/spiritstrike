package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.utils.mrf;

/* JADX INFO: loaded from: classes3.dex */
public class kdv {
    private int exu;
    private long fs;
    private long jpc;
    private mrf lnr = mrf.lnr();
    private mrf mml = mrf.lnr();
    private long mo;
    private long mzz;
    public boolean qdl;
    private int rq;
    private long to;
    private long tvp;
    public long ud;
    private long wd;

    public void qdl(mrf mrfVar, mrf mrfVar2, int i, mrf mrfVar3) {
        this.mzz = mrfVar.qdl(this.lnr);
        this.mo = mrfVar2.qdl(mrfVar);
        this.wd = i;
        this.jpc = mrfVar3.qdl(mrfVar2);
    }

    public void qdl(mrf mrfVar) {
        this.lnr = mrfVar;
    }

    public void ud(mrf mrfVar) {
        this.mml = mrfVar;
        this.tvp = mrfVar.qdl(this.lnr);
    }

    public mrf qdl() {
        return this.lnr;
    }

    public long ud() {
        return this.mzz;
    }

    public long lnr() {
        return this.mo;
    }

    public long mml() {
        return this.wd;
    }

    public long mzz() {
        return this.jpc;
    }

    public long mo() {
        return this.tvp;
    }

    public long wd() {
        return this.to;
    }

    public void qdl(long j) {
        this.to = j;
    }

    public int jpc() {
        return this.rq;
    }

    public void qdl(int i) {
        this.rq = i;
    }

    public void ud(long j) {
        this.fs = j;
    }

    public long tvp() {
        return this.fs;
    }

    public synchronized void ud(int i) {
        this.exu = i;
    }

    public synchronized long to() {
        return this.exu;
    }
}
