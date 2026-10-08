package com.bytedance.sdk.component.mzz.mzz;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements tvp {
    private byte[] qdl;
    private com.bytedance.sdk.component.mzz.mo ud;

    public ud(byte[] bArr, com.bytedance.sdk.component.mzz.mo moVar) {
        this.qdl = bArr;
        this.ud = moVar;
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public void qdl(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        tvp jpcVar;
        int iFs = lnrVar.fs();
        lnrVar.qdl(this.qdl.length);
        if (iFs != 2) {
            if (iFs == 3) {
                byte[] bArr = this.qdl;
                jpcVar = new exu(bArr, this.ud, com.bytedance.sdk.component.utils.mo.ud(bArr));
            } else {
                boolean zUd = com.bytedance.sdk.component.utils.mo.ud(this.qdl);
                if (!zUd && com.bytedance.sdk.component.utils.mo.qdl(this.qdl)) {
                    jpcVar = new mzz(this.qdl, this.ud);
                } else {
                    jpcVar = new exu(this.qdl, this.ud, zUd);
                }
            }
        } else if (com.bytedance.sdk.component.utils.mo.qdl(this.qdl)) {
            jpcVar = new mzz(this.qdl, this.ud);
        } else if (this.ud == null) {
            jpcVar = new rq();
        } else {
            jpcVar = new jpc(1001, "not image format", null);
        }
        lnrVar.qdl(jpcVar);
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public String qdl() {
        return "image_type";
    }
}
