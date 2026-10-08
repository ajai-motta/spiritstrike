package com.bytedance.sdk.component.mzz.mzz;

/* JADX INFO: loaded from: classes3.dex */
public class rq extends qdl {
    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public void qdl(final com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        final com.bytedance.sdk.component.mzz.lnr.mo moVarJl = lnrVar.jl();
        com.bytedance.sdk.component.mzz.mml mmlVarMml = moVarJl.mml();
        lnrVar.qdl(false);
        try {
            com.bytedance.sdk.component.mzz.mo moVarQdl = mmlVarMml.qdl(new com.bytedance.sdk.component.mzz.ud.ud(lnrVar.qdl(), lnrVar.exu(), lnrVar.rdp(), lnrVar.jyq()));
            int iUd = moVarQdl.ud();
            lnrVar.qdl(moVarQdl.qdl());
            if (moVarQdl.ud() == 200) {
                final byte[] bArr = (byte[]) moVarQdl.lnr();
                lnrVar.qdl(new ud(bArr, moVarQdl));
                final String strTvp = lnrVar.tvp();
                final com.bytedance.sdk.component.mzz.ud udVarExc = lnrVar.exc();
                if (udVarExc.mzz()) {
                    moVarJl.ud(lnrVar.exc()).qdl(strTvp, bArr);
                }
                moVarJl.wd().submit(new Runnable() { // from class: com.bytedance.sdk.component.mzz.mzz.rq.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (udVarExc.wd()) {
                            moVarJl.lnr(lnrVar.exc()).qdl(strTvp, bArr);
                        }
                    }
                });
                return;
            }
            String.valueOf(moVarQdl);
            Object objLnr = moVarQdl.lnr();
            qdl(iUd, moVarQdl.mml(), objLnr instanceof Throwable ? (Throwable) objLnr : null, lnrVar);
        } catch (Throwable th) {
            qdl(1004, "net request failed!", th, lnrVar);
        }
    }

    private void qdl(int i, String str, Throwable th, com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        lnrVar.qdl(new jpc(i, str, th));
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public String qdl() {
        return "net_request";
    }
}
