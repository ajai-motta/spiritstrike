package com.bytedance.adsdk.ud.qdl.ud;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class tvp extends com.bytedance.adsdk.ud.wd.qdl<PointF> {
    private final com.bytedance.adsdk.ud.wd.qdl<PointF> rq;
    private Path to;

    public tvp(com.bytedance.adsdk.ud.wd wdVar, com.bytedance.adsdk.ud.wd.qdl<PointF> qdlVar) {
        super(wdVar, qdlVar.qdl, qdlVar.ud, qdlVar.lnr, qdlVar.mml, qdlVar.mzz, qdlVar.mo, qdlVar.wd);
        this.rq = qdlVar;
        qdl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void qdl() {
        boolean z = (this.ud == 0 || this.qdl == 0 || !((PointF) this.qdl).equals(((PointF) this.ud).x, ((PointF) this.ud).y)) ? false : true;
        if (this.qdl == 0 || this.ud == 0 || z) {
            return;
        }
        this.to = com.bytedance.adsdk.ud.mo.mo.qdl((PointF) this.qdl, (PointF) this.ud, this.rq.jpc, this.rq.tvp);
    }

    Path ud() {
        return this.to;
    }
}
