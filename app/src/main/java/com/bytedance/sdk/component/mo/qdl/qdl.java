package com.bytedance.sdk.component.mo.qdl;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private long exu;
    private int fs;
    private boolean jpc;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl lnr;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mml;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mo;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mzz;
    private com.bytedance.sdk.component.mo.qdl.qdl.mzz qdl;
    private int rq;
    private boolean to;
    private mzz tvp;
    private com.bytedance.sdk.component.mo.qdl.ud.lnr ud;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl wd;

    private qdl() {
        this.rq = 200;
        this.fs = 10;
    }

    public com.bytedance.sdk.component.mo.qdl.qdl.mzz qdl() {
        return this.qdl;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl ud() {
        return this.mo;
    }

    public boolean lnr() {
        return this.to;
    }

    public mzz mml() {
        return this.tvp;
    }

    public long mzz() {
        return this.exu;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mo() {
        return this.wd;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl wd() {
        return this.lnr;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl jpc() {
        return this.mml;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl tvp() {
        return this.mzz;
    }

    public com.bytedance.sdk.component.mo.qdl.ud.lnr to() {
        return this.ud;
    }

    public boolean rq() {
        return this.jpc;
    }

    public int fs() {
        return this.rq;
    }

    public int exu() {
        return this.fs;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.mo.qdl.qdl$qdl, reason: collision with other inner class name */
    public static class C0205qdl {
        private long fs;
        private com.bytedance.sdk.component.mo.qdl.qdl.mzz jpc;
        private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl lnr;
        private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mml;
        private boolean mo;
        private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mzz;
        private com.bytedance.sdk.component.mo.qdl.ud.lnr qdl;
        private boolean tvp;
        private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl ud;
        private mzz wd;
        private int to = 5000;
        private int rq = 10;

        public C0205qdl qdl(long j) {
            this.fs = j;
            return this;
        }

        public C0205qdl qdl(com.bytedance.sdk.component.mo.qdl.qdl.mzz mzzVar) {
            this.jpc = mzzVar;
            return this;
        }

        public C0205qdl qdl(mzz mzzVar) {
            this.wd = mzzVar;
            return this;
        }

        public C0205qdl qdl(boolean z) {
            this.mo = z;
            return this;
        }

        public C0205qdl qdl(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
            this.ud = qdlVar;
            return this;
        }

        public C0205qdl ud(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
            this.lnr = qdlVar;
            return this;
        }

        public C0205qdl lnr(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
            this.mml = qdlVar;
            return this;
        }

        public C0205qdl qdl(com.bytedance.sdk.component.mo.qdl.ud.lnr lnrVar) {
            this.qdl = lnrVar;
            return this;
        }

        public C0205qdl qdl(int i) {
            this.to = i;
            return this;
        }

        public C0205qdl ud(int i) {
            this.rq = i;
            return this;
        }

        public qdl qdl() {
            qdl qdlVar = new qdl();
            qdlVar.ud = this.qdl;
            qdlVar.lnr = this.ud;
            qdlVar.mml = this.lnr;
            qdlVar.mzz = this.mml;
            qdlVar.mo = this.mzz;
            qdlVar.jpc = this.mo;
            qdlVar.tvp = this.wd;
            qdlVar.qdl = this.jpc;
            qdlVar.to = this.tvp;
            qdlVar.fs = this.rq;
            qdlVar.rq = this.to;
            qdlVar.exu = this.fs;
            return qdlVar;
        }
    }
}
