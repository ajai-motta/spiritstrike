package com.bytedance.adsdk.ud.lnr.lnr;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.ud.lnr.ud.jtx;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class wd extends qdl {
    private final ud jpc;
    private final com.bytedance.adsdk.ud.qdl.qdl.mml wd;

    wd(com.bytedance.adsdk.ud.tvp tvpVar, mzz mzzVar, ud udVar, com.bytedance.adsdk.ud.wd wdVar) {
        super(tvpVar, mzzVar);
        this.jpc = udVar;
        com.bytedance.adsdk.ud.qdl.qdl.mml mmlVar = new com.bytedance.adsdk.ud.qdl.qdl.mml(tvpVar, this, new jtx("__container", mzzVar.rdp(), false), wdVar);
        this.wd = mmlVar;
        mmlVar.qdl(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.qdl
    public void ud(Canvas canvas, Matrix matrix, int i) {
        super.ud(canvas, matrix, i);
        this.wd.qdl(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.qdl, com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(RectF rectF, Matrix matrix, boolean z) {
        super.qdl(rectF, matrix, z);
        this.wd.qdl(rectF, this.qdl, z);
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.qdl
    public com.bytedance.adsdk.ud.lnr.ud.qdl to() {
        com.bytedance.adsdk.ud.lnr.ud.qdl qdlVar = super.to();
        return qdlVar != null ? qdlVar : this.jpc.to();
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.qdl
    public com.bytedance.adsdk.ud.mzz.to rq() {
        com.bytedance.adsdk.ud.mzz.to toVarRq = super.rq();
        return toVarRq != null ? toVarRq : this.jpc.rq();
    }
}
