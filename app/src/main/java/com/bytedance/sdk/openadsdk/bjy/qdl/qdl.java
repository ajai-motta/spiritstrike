package com.bytedance.sdk.openadsdk.bjy.qdl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    String bjy;
    float exu;
    float fs;
    float jpc;
    float jtx;
    float lnr;
    float mml;
    int mo;
    float mzz;
    String qdl;
    int rdp;
    float rq;
    int to;
    float tvp;
    int ud;
    float wd;
    int yt;
    int jl = -1;
    String exc = "";

    public int qdl() {
        return this.jl;
    }

    public void qdl(int i) {
        this.jl = i;
    }

    public String ud() {
        return this.exc;
    }

    public void qdl(String str) {
        this.exc = str;
    }

    public String lnr() {
        return this.qdl;
    }

    public void ud(String str) {
        this.qdl = str;
    }

    public int mml() {
        return this.ud;
    }

    public void ud(int i) {
        this.ud = i;
    }

    public float mzz() {
        return this.lnr;
    }

    public void qdl(float f) {
        this.lnr = f;
    }

    public float mo() {
        return this.mml;
    }

    public void ud(float f) {
        this.mml = f;
    }

    public float wd() {
        return this.mzz;
    }

    public void lnr(float f) {
        this.mzz = f;
    }

    public int jpc() {
        return this.mo;
    }

    public void lnr(int i) {
        this.mo = i;
    }

    public float tvp() {
        return this.wd;
    }

    public void mml(float f) {
        this.wd = f;
    }

    public float to() {
        return this.jpc;
    }

    public void mzz(float f) {
        this.jpc = f;
    }

    public float rq() {
        return this.tvp;
    }

    public void mo(float f) {
        this.tvp = f;
    }

    public int fs() {
        return this.to;
    }

    public void mml(int i) {
        this.to = i;
    }

    public float exu() {
        return this.rq;
    }

    public void wd(float f) {
        this.rq = f;
    }

    public float rdp() {
        return this.fs;
    }

    public void jpc(float f) {
        this.fs = f;
    }

    public BigDecimal bjy() {
        return new BigDecimal(this.exu).setScale(3, RoundingMode.HALF_UP);
    }

    public void tvp(float f) {
        this.exu = f;
    }

    public int jtx() {
        return this.rdp;
    }

    public void mzz(int i) {
        this.rdp = i;
    }

    public String yt() {
        return this.bjy;
    }

    public void lnr(String str) {
        this.bjy = str;
    }

    public float jl() {
        return this.jtx;
    }

    public void to(float f) {
        this.jtx = f;
    }

    public int exc() {
        return this.yt;
    }

    public void mo(int i) {
        this.yt = i;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.bjy.qdl.qdl$qdl, reason: collision with other inner class name */
    public static class C0224qdl {
        qdl qdl = new qdl();

        public C0224qdl qdl(String str) {
            this.qdl.ud(str);
            return this;
        }

        public C0224qdl qdl(int i) {
            this.qdl.ud(i);
            return this;
        }

        public C0224qdl qdl(float f) {
            this.qdl.qdl(f);
            return this;
        }

        public C0224qdl ud(float f) {
            this.qdl.ud(f);
            return this;
        }

        public C0224qdl lnr(float f) {
            this.qdl.lnr(f);
            return this;
        }

        public C0224qdl mml(float f) {
            this.qdl.mml(f);
            return this;
        }

        public C0224qdl mzz(float f) {
            this.qdl.mzz(f);
            return this;
        }

        public C0224qdl mo(float f) {
            this.qdl.mo(f);
            return this;
        }

        public C0224qdl wd(float f) {
            this.qdl.wd(f);
            return this;
        }

        public C0224qdl jpc(float f) {
            this.qdl.jpc(f);
            return this;
        }

        public C0224qdl tvp(float f) {
            this.qdl.tvp(f);
            return this;
        }

        public C0224qdl ud(int i) {
            this.qdl.mzz(i);
            return this;
        }

        public C0224qdl ud(String str) {
            this.qdl.lnr(str);
            return this;
        }

        public C0224qdl to(float f) {
            this.qdl.to(f);
            return this;
        }

        public C0224qdl lnr(int i) {
            this.qdl.mo(i);
            return this;
        }

        public qdl qdl() {
            return this.qdl;
        }
    }
}
