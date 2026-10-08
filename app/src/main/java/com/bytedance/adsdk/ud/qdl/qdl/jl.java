package com.bytedance.adsdk.ud.qdl.qdl;

import android.graphics.Path;
import com.bytedance.adsdk.ud.qdl.ud.qdl;

/* JADX INFO: loaded from: classes.dex */
public class jl implements exu, qdl.InterfaceC0180qdl {
    private final boolean lnr;
    private final com.bytedance.adsdk.ud.tvp mml;
    private boolean mo;
    private final com.bytedance.adsdk.ud.qdl.ud.exu mzz;
    private final String ud;
    private final Path qdl = new Path();
    private final ud wd = new ud();

    public jl(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, com.bytedance.adsdk.ud.lnr.ud.yt ytVar) {
        this.ud = ytVar.qdl();
        this.lnr = ytVar.lnr();
        this.mml = tvpVar;
        com.bytedance.adsdk.ud.qdl.ud.exu exuVarQdl = ytVar.ud().qdl();
        this.mzz = exuVarQdl;
        qdlVar.qdl(exuVarQdl);
        exuVarQdl.qdl(this);
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        ud();
    }

    private void ud() {
        this.mo = false;
        this.mml.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(java.util.List<com.bytedance.adsdk.ud.qdl.qdl.lnr> r6, java.util.List<com.bytedance.adsdk.ud.qdl.qdl.lnr> r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L39
            java.lang.Object r1 = r6.get(r0)
            com.bytedance.adsdk.ud.qdl.qdl.lnr r1 = (com.bytedance.adsdk.ud.qdl.qdl.lnr) r1
            boolean r2 = r1 instanceof com.bytedance.adsdk.ud.qdl.qdl.jyq
            if (r2 == 0) goto L26
            r2 = r1
            com.bytedance.adsdk.ud.qdl.qdl.jyq r2 = (com.bytedance.adsdk.ud.qdl.qdl.jyq) r2
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r3 = r2.ud()
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r4 = com.bytedance.adsdk.ud.lnr.ud.exc.qdl.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            com.bytedance.adsdk.ud.qdl.qdl.ud r1 = r5.wd
            r1.qdl(r2)
            r2.qdl(r5)
            goto L36
        L26:
            boolean r2 = r1 instanceof com.bytedance.adsdk.ud.qdl.qdl.exc
            if (r2 == 0) goto L36
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            com.bytedance.adsdk.ud.qdl.qdl.exc r1 = (com.bytedance.adsdk.ud.qdl.qdl.exc) r1
            r7.add(r1)
        L36:
            int r0 = r0 + 1
            goto L2
        L39:
            com.bytedance.adsdk.ud.qdl.ud.exu r6 = r5.mzz
            r6.qdl(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.qdl.qdl.jl.qdl(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.exu
    public Path mml() {
        if (this.mo) {
            return this.qdl;
        }
        this.qdl.reset();
        if (this.lnr) {
            this.mo = true;
            return this.qdl;
        }
        Path pathWd = this.mzz.wd();
        if (pathWd == null) {
            return this.qdl;
        }
        this.qdl.set(pathWd);
        this.qdl.setFillType(Path.FillType.EVEN_ODD);
        this.wd.qdl(this.qdl);
        this.mo = true;
        return this.qdl;
    }
}
