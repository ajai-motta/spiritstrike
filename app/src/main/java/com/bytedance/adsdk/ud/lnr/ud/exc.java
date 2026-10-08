package com.bytedance.adsdk.ud.lnr.ud;

import com.bytedance.adsdk.ud.qdl.qdl.jyq;

/* JADX INFO: loaded from: classes.dex */
public class exc implements lnr {
    private final com.bytedance.adsdk.ud.lnr.qdl.ud lnr;
    private final com.bytedance.adsdk.ud.lnr.qdl.ud mml;
    private final boolean mo;
    private final com.bytedance.adsdk.ud.lnr.qdl.ud mzz;
    private final String qdl;
    private final qdl ud;

    public enum qdl {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static qdl qdl(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public exc(String str, qdl qdlVar, com.bytedance.adsdk.ud.lnr.qdl.ud udVar, com.bytedance.adsdk.ud.lnr.qdl.ud udVar2, com.bytedance.adsdk.ud.lnr.qdl.ud udVar3, boolean z) {
        this.qdl = str;
        this.ud = qdlVar;
        this.lnr = udVar;
        this.mml = udVar2;
        this.mzz = udVar3;
        this.mo = z;
    }

    public String qdl() {
        return this.qdl;
    }

    public qdl ud() {
        return this.ud;
    }

    public com.bytedance.adsdk.ud.lnr.qdl.ud lnr() {
        return this.mml;
    }

    public com.bytedance.adsdk.ud.lnr.qdl.ud mml() {
        return this.lnr;
    }

    public com.bytedance.adsdk.ud.lnr.qdl.ud mzz() {
        return this.mzz;
    }

    public boolean mo() {
        return this.mo;
    }

    @Override // com.bytedance.adsdk.ud.lnr.ud.lnr
    public com.bytedance.adsdk.ud.qdl.qdl.lnr qdl(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.wd wdVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar) {
        return new jyq(qdlVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.lnr + ", end: " + this.mml + ", offset: " + this.mzz + "}";
    }
}
