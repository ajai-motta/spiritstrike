package com.bytedance.sdk.component.mzz.mzz;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends qdl {
    private byte[] qdl;
    private com.bytedance.sdk.component.mzz.mo ud;

    public mzz(byte[] bArr, com.bytedance.sdk.component.mzz.mo moVar) {
        this.qdl = bArr;
        this.ud = moVar;
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public void qdl(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        com.bytedance.sdk.component.mzz.lnr.mo moVarJl = lnrVar.jl();
        com.bytedance.sdk.component.mzz.lnr.ud.qdl qdlVarQdl = moVarJl.qdl(lnrVar);
        try {
            lnrVar.jyq();
            Bitmap bitmapQdl = qdlVarQdl.qdl(this.qdl);
            if (bitmapQdl != null) {
                lnrVar.qdl(new exu(bitmapQdl, this.ud, false));
                moVarJl.qdl(lnrVar.exc()).qdl(lnrVar.to(), bitmapQdl);
                return;
            }
            qdl(1002, "decode failed bitmap null", null, lnrVar);
        } catch (Throwable th) {
            qdl(1002, "decode failed:" + th.getMessage(), th, lnrVar);
        }
    }

    private void qdl(int i, String str, Throwable th, com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        if (this.ud == null) {
            lnrVar.qdl(new rq());
        } else {
            lnrVar.qdl(new jpc(i, str, th));
        }
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public String qdl() {
        return "decode";
    }
}
