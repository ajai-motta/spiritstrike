package com.bytedance.sdk.openadsdk.component.mzz;

import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private ljh lnr;
    private com.bytedance.sdk.openadsdk.core.model.qdl mml;
    private String mo;
    private int mzz;
    private int qdl;
    private int ud;
    private boolean wd;

    public ud(int i, int i2, ljh ljhVar, com.bytedance.sdk.openadsdk.core.model.qdl qdlVar) {
        this.qdl = i;
        this.ud = i2;
        this.lnr = ljhVar;
        this.mml = qdlVar;
    }

    public ud(int i, int i2, int i3, String str) {
        this.qdl = i;
        this.ud = i2;
        this.mzz = i3;
        this.mo = str;
    }

    public com.bytedance.sdk.openadsdk.core.model.qdl qdl() {
        return this.mml;
    }

    public void qdl(boolean z) {
        this.wd = z;
    }

    public int ud() {
        return this.qdl;
    }

    public int lnr() {
        return this.ud;
    }

    public ljh mml() {
        return this.lnr;
    }

    public int mzz() {
        return this.mzz;
    }

    public String mo() {
        return this.mo;
    }
}
