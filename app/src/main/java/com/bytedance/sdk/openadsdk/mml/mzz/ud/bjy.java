package com.bytedance.sdk.openadsdk.mml.mzz.ud;

import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public class bjy {
    private int lnr;
    private com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr mml;
    private ljh mzz;
    private long qdl;
    private String ud;

    public bjy(long j, String str, int i, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, ljh ljhVar) {
        this.qdl = j;
        this.ud = str;
        this.lnr = i;
        this.mml = lnrVar;
        this.mzz = ljhVar;
    }

    public long qdl() {
        return this.qdl;
    }

    public String ud() {
        return this.ud;
    }

    public int lnr() {
        return this.lnr;
    }

    public com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr mml() {
        return this.mml;
    }

    public ljh mzz() {
        return this.mzz;
    }

    public static class qdl {
        private com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl fs;
        private int jpc;
        private int mo;
        private int to;
        private int tvp;
        private int wd;
        private long qdl = 0;
        private long ud = 0;
        private long lnr = 0;
        private long mml = 0;
        private boolean mzz = false;
        private boolean rq = false;

        public long qdl() {
            return this.mml;
        }

        public void qdl(long j) {
            this.mml = j;
        }

        public long ud() {
            return this.qdl;
        }

        public void ud(long j) {
            this.qdl = j;
            rdp();
        }

        private void rdp() {
            long j = this.lnr;
            if (j > 0) {
                long j2 = this.qdl;
                if (j2 > j) {
                    long j3 = j2 % j;
                    this.qdl = j3;
                    if (j3 == 0) {
                        this.qdl = j;
                    }
                }
            }
        }

        public long lnr() {
            return this.ud;
        }

        public void lnr(long j) {
            this.ud = j;
        }

        public long mml() {
            return this.lnr;
        }

        public void mml(long j) {
            this.lnr = j;
            rdp();
        }

        public int mzz() {
            return this.mo;
        }

        public void qdl(int i) {
            this.mo = i;
        }

        public int mo() {
            return this.wd;
        }

        public void ud(int i) {
            this.wd = i;
        }

        public int wd() {
            long j = this.lnr;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.qdl * 100) / j), 100);
        }

        public int jpc() {
            return this.jpc;
        }

        public void lnr(int i) {
            this.jpc = i;
        }

        public int tvp() {
            return this.tvp;
        }

        public int to() {
            return this.to;
        }

        public void mml(int i) {
            this.to = i;
        }

        public boolean rq() {
            return this.rq;
        }

        public boolean fs() {
            return this.mzz;
        }

        public void qdl(boolean z) {
            this.mzz = z;
        }

        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar) {
            this.fs = qdlVar;
        }

        public com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl exu() {
            return this.fs;
        }
    }
}
