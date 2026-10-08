package com.bytedance.sdk.component.ud.qdl.qdl.qdl;

import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.jpc;
import com.bytedance.sdk.component.ud.qdl.rdp;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class lnr implements jpc.qdl {
    int lnr = 0;
    List<com.bytedance.sdk.component.ud.qdl.jpc> qdl;
    fs ud;

    lnr(List<com.bytedance.sdk.component.ud.qdl.jpc> list, fs fsVar) {
        this.qdl = list;
        this.ud = fsVar;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.jpc.qdl
    public fs qdl() {
        return this.ud;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.jpc.qdl
    public rdp qdl(fs fsVar) throws IOException {
        this.ud = fsVar;
        int i = this.lnr + 1;
        this.lnr = i;
        if (i >= this.qdl.size()) {
            return null;
        }
        return this.qdl.get(this.lnr).qdl(this);
    }
}
