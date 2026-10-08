package com.bytedance.adsdk.ud.lnr.ud;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class yt implements lnr {
    private final com.bytedance.adsdk.ud.lnr.qdl.jpc lnr;
    private final boolean mml;
    private final String qdl;
    private final int ud;

    public yt(String str, int i, com.bytedance.adsdk.ud.lnr.qdl.jpc jpcVar, boolean z) {
        this.qdl = str;
        this.ud = i;
        this.lnr = jpcVar;
        this.mml = z;
    }

    public String qdl() {
        return this.qdl;
    }

    public com.bytedance.adsdk.ud.lnr.qdl.jpc ud() {
        return this.lnr;
    }

    @Override // com.bytedance.adsdk.ud.lnr.ud.lnr
    public com.bytedance.adsdk.ud.qdl.qdl.lnr qdl(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.wd wdVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar) {
        return new com.bytedance.adsdk.ud.qdl.qdl.jl(tvpVar, qdlVar, this);
    }

    public boolean lnr() {
        return this.mml;
    }

    public String toString() {
        return "ShapePath{name=" + this.qdl + ", index=" + this.ud + AbstractJsonLexerKt.END_OBJ;
    }
}
