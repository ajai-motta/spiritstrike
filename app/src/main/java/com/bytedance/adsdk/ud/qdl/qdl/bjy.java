package com.bytedance.adsdk.ud.qdl.qdl;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.ud.qdl.ud.qdl;

/* JADX INFO: loaded from: classes.dex */
public class bjy implements exu, rq, qdl.InterfaceC0180qdl {
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> jpc;
    private final String lnr;
    private final boolean mml;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, PointF> mo;
    private final com.bytedance.adsdk.ud.tvp mzz;
    private boolean rq;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, PointF> wd;
    private final Path qdl = new Path();
    private final RectF ud = new RectF();
    private final ud tvp = new ud();
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> to = null;

    public bjy(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, com.bytedance.adsdk.ud.lnr.ud.rq rqVar) {
        this.lnr = rqVar.qdl();
        this.mml = rqVar.mzz();
        this.mzz = tvpVar;
        com.bytedance.adsdk.ud.qdl.ud.qdl<PointF, PointF> qdlVarQdl = rqVar.mml().qdl();
        this.mo = qdlVarQdl;
        com.bytedance.adsdk.ud.qdl.ud.qdl<PointF, PointF> qdlVarQdl2 = rqVar.lnr().qdl();
        this.wd = qdlVarQdl2;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl3 = rqVar.ud().qdl();
        this.jpc = qdlVarQdl3;
        qdlVar.qdl(qdlVarQdl);
        qdlVar.qdl(qdlVarQdl2);
        qdlVar.qdl(qdlVarQdl3);
        qdlVarQdl.qdl(this);
        qdlVarQdl2.qdl(this);
        qdlVarQdl3.qdl(this);
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        ud();
    }

    private void ud() {
        this.rq = false;
        this.mzz.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(java.util.List<com.bytedance.adsdk.ud.qdl.qdl.lnr> r5, java.util.List<com.bytedance.adsdk.ud.qdl.qdl.lnr> r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L34
            java.lang.Object r0 = r5.get(r6)
            com.bytedance.adsdk.ud.qdl.qdl.lnr r0 = (com.bytedance.adsdk.ud.qdl.qdl.lnr) r0
            boolean r1 = r0 instanceof com.bytedance.adsdk.ud.qdl.qdl.jyq
            if (r1 == 0) goto L25
            r1 = r0
            com.bytedance.adsdk.ud.qdl.qdl.jyq r1 = (com.bytedance.adsdk.ud.qdl.qdl.jyq) r1
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r2 = r1.ud()
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r3 = com.bytedance.adsdk.ud.lnr.ud.exc.qdl.SIMULTANEOUSLY
            if (r2 != r3) goto L25
            com.bytedance.adsdk.ud.qdl.qdl.ud r0 = r4.tvp
            r0.qdl(r1)
            r1.qdl(r4)
            goto L31
        L25:
            boolean r1 = r0 instanceof com.bytedance.adsdk.ud.qdl.qdl.yt
            if (r1 == 0) goto L31
            com.bytedance.adsdk.ud.qdl.qdl.yt r0 = (com.bytedance.adsdk.ud.qdl.qdl.yt) r0
            com.bytedance.adsdk.ud.qdl.ud.qdl r0 = r0.ud()
            r4.to = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.qdl.qdl.bjy.qdl(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.exu
    public Path mml() {
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVar;
        if (this.rq) {
            return this.qdl;
        }
        this.qdl.reset();
        if (this.mml) {
            this.rq = true;
            return this.qdl;
        }
        PointF pointFWd = this.wd.wd();
        float f = pointFWd.x / 2.0f;
        float f2 = pointFWd.y / 2.0f;
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> qdlVar2 = this.jpc;
        float fTvp = qdlVar2 == null ? 0.0f : ((com.bytedance.adsdk.ud.qdl.ud.mml) qdlVar2).tvp();
        if (fTvp == 0.0f && (qdlVar = this.to) != null) {
            fTvp = Math.min(qdlVar.wd().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fTvp > fMin) {
            fTvp = fMin;
        }
        PointF pointFWd2 = this.mo.wd();
        this.qdl.moveTo(pointFWd2.x + f, (pointFWd2.y - f2) + fTvp);
        this.qdl.lineTo(pointFWd2.x + f, (pointFWd2.y + f2) - fTvp);
        if (fTvp > 0.0f) {
            float f3 = fTvp * 2.0f;
            this.ud.set((pointFWd2.x + f) - f3, (pointFWd2.y + f2) - f3, pointFWd2.x + f, pointFWd2.y + f2);
            this.qdl.arcTo(this.ud, 0.0f, 90.0f, false);
        }
        this.qdl.lineTo((pointFWd2.x - f) + fTvp, pointFWd2.y + f2);
        if (fTvp > 0.0f) {
            float f4 = fTvp * 2.0f;
            this.ud.set(pointFWd2.x - f, (pointFWd2.y + f2) - f4, (pointFWd2.x - f) + f4, pointFWd2.y + f2);
            this.qdl.arcTo(this.ud, 90.0f, 90.0f, false);
        }
        this.qdl.lineTo(pointFWd2.x - f, (pointFWd2.y - f2) + fTvp);
        if (fTvp > 0.0f) {
            float f5 = fTvp * 2.0f;
            this.ud.set(pointFWd2.x - f, pointFWd2.y - f2, (pointFWd2.x - f) + f5, (pointFWd2.y - f2) + f5);
            this.qdl.arcTo(this.ud, 180.0f, 90.0f, false);
        }
        this.qdl.lineTo((pointFWd2.x + f) - fTvp, pointFWd2.y - f2);
        if (fTvp > 0.0f) {
            float f6 = fTvp * 2.0f;
            this.ud.set((pointFWd2.x + f) - f6, pointFWd2.y - f2, pointFWd2.x + f, (pointFWd2.y - f2) + f6);
            this.qdl.arcTo(this.ud, 270.0f, 90.0f, false);
        }
        this.qdl.close();
        this.tvp.qdl(this.qdl);
        this.rq = true;
        return this.qdl;
    }
}
