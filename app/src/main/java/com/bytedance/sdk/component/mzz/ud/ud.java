package com.bytedance.sdk.component.mzz.ud;

import com.bytedance.sdk.component.mzz.mzz;
import com.bytedance.sdk.component.mzz.rdp;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements mzz {
    private boolean lnr;
    private rdp mml;
    private String qdl;
    private boolean ud;

    public ud(String str, boolean z, boolean z2, rdp rdpVar) {
        this.qdl = str;
        this.ud = z;
        this.lnr = z2;
        this.mml = rdpVar;
    }

    @Override // com.bytedance.sdk.component.mzz.mzz
    public String qdl() {
        return this.qdl;
    }

    @Override // com.bytedance.sdk.component.mzz.mzz
    public boolean ud() {
        return this.ud;
    }

    @Override // com.bytedance.sdk.component.mzz.mzz
    public boolean lnr() {
        return this.lnr;
    }
}
