package com.bytedance.adsdk.ud.lnr.ud;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class tvp implements lnr {
    private final boolean lnr;
    private final String qdl;
    private final qdl ud;

    public enum qdl {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static qdl qdl(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public tvp(String str, qdl qdlVar, boolean z) {
        this.qdl = str;
        this.ud = qdlVar;
        this.lnr = z;
    }

    public String qdl() {
        return this.qdl;
    }

    public qdl ud() {
        return this.ud;
    }

    public boolean lnr() {
        return this.lnr;
    }

    @Override // com.bytedance.adsdk.ud.lnr.ud.lnr
    public com.bytedance.adsdk.ud.qdl.qdl.lnr qdl(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.wd wdVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar) {
        return new com.bytedance.adsdk.ud.qdl.qdl.fs(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.ud + AbstractJsonLexerKt.END_OBJ;
    }
}
