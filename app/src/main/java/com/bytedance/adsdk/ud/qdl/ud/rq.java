package com.bytedance.adsdk.ud.qdl.ud;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class rq extends wd<PointF> {
    private final PointF mml;

    public rq(List<com.bytedance.adsdk.ud.wd.qdl<PointF>> list) {
        super(list);
        this.mml = new PointF();
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
    public PointF qdl(com.bytedance.adsdk.ud.wd.qdl<PointF> qdlVar, float f) {
        return qdl(qdlVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
    public PointF qdl(com.bytedance.adsdk.ud.wd.qdl<PointF> qdlVar, float f, float f2, float f3) {
        if (qdlVar.qdl == null || qdlVar.ud == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = qdlVar.qdl;
        PointF pointF2 = qdlVar.ud;
        if (this.lnr != null) {
            qdlVar.wd.floatValue();
            mml();
            jpc();
            throw null;
        }
        this.mml.set(pointF.x + (f2 * (pointF2.x - pointF.x)), pointF.y + (f3 * (pointF2.y - pointF.y)));
        return this.mml;
    }
}
