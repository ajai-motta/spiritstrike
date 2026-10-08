package com.bytedance.adsdk.ud.qdl.ud;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class rdp extends qdl<PointF, PointF> {
    private final qdl<Float, Float> jpc;
    protected com.bytedance.adsdk.ud.wd.ud<Float> mml;
    private final PointF mo;
    protected com.bytedance.adsdk.ud.wd.ud<Float> mzz;
    private final qdl<Float, Float> tvp;
    private final PointF wd;

    public rdp(qdl<Float, Float> qdlVar, qdl<Float, Float> qdlVar2) {
        super(Collections.emptyList());
        this.mo = new PointF();
        this.wd = new PointF();
        this.jpc = qdlVar;
        this.tvp = qdlVar2;
        qdl(jpc());
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    public void qdl(float f) {
        this.jpc.qdl(f);
        this.tvp.qdl(f);
        this.mo.set(this.jpc.wd().floatValue(), this.tvp.wd().floatValue());
        for (int i = 0; i < this.qdl.size(); i++) {
            this.qdl.get(i).qdl();
        }
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    /* JADX INFO: renamed from: tvp, reason: merged with bridge method [inline-methods] */
    public PointF wd() {
        return qdl(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
    public PointF qdl(com.bytedance.adsdk.ud.wd.qdl<PointF> qdlVar, float f) {
        com.bytedance.adsdk.ud.wd.qdl<Float> qdlVarLnr;
        com.bytedance.adsdk.ud.wd.qdl<Float> qdlVarLnr2;
        if (this.mml != null && (qdlVarLnr2 = this.jpc.lnr()) != null) {
            this.jpc.mzz();
            Float f2 = qdlVarLnr2.wd;
            if (f2 == null) {
                throw null;
            }
            f2.floatValue();
            throw null;
        }
        if (this.mzz != null && (qdlVarLnr = this.tvp.lnr()) != null) {
            this.tvp.mzz();
            Float f3 = qdlVarLnr.wd;
            if (f3 == null) {
                throw null;
            }
            f3.floatValue();
            throw null;
        }
        this.wd.set(this.mo.x, 0.0f);
        PointF pointF = this.wd;
        pointF.set(pointF.x, this.mo.y);
        return this.wd;
    }
}
