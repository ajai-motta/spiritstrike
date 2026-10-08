package com.bytedance.adsdk.ugeno.mml.mml;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class wd extends lnr {
    public wd(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.mml.mml.lnr
    public boolean qdl(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            int iQdl = com.bytedance.adsdk.ugeno.wd.lnr.qdl(String.valueOf(objArr[0]), 0);
            if (this.mzz == null || this.mzz.isEmpty() || iQdl == com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("type"), 0)) {
                this.qdl.qdl(this.ud, this.mo, this.lnr.ud());
            }
        }
        return false;
    }
}
