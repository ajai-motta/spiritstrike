package com.bytedance.adsdk.ud.qdl.qdl;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.ud.qdl.ud.qdl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mml implements exu, mzz, qdl.InterfaceC0180qdl {
    private final List<lnr> jpc;
    private final Matrix lnr;
    private final Path mml;
    private final String mo;
    private final RectF mzz;
    private final Paint qdl;
    private com.bytedance.adsdk.ud.qdl.ud.jtx rq;
    private List<exu> to;
    private final com.bytedance.adsdk.ud.tvp tvp;
    private final RectF ud;
    private final boolean wd;

    private static List<lnr> qdl(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.wd wdVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, List<com.bytedance.adsdk.ud.lnr.ud.lnr> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            lnr lnrVarQdl = list.get(i).qdl(tvpVar, wdVar, qdlVar);
            if (lnrVarQdl != null) {
                arrayList.add(lnrVarQdl);
            }
        }
        return arrayList;
    }

    static com.bytedance.adsdk.ud.lnr.qdl.fs qdl(List<com.bytedance.adsdk.ud.lnr.ud.lnr> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.ud.lnr.ud.lnr lnrVar = list.get(i);
            if (lnrVar instanceof com.bytedance.adsdk.ud.lnr.qdl.fs) {
                return (com.bytedance.adsdk.ud.lnr.qdl.fs) lnrVar;
            }
        }
        return null;
    }

    public mml(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, com.bytedance.adsdk.ud.lnr.ud.jtx jtxVar, com.bytedance.adsdk.ud.wd wdVar) {
        this(tvpVar, qdlVar, jtxVar.qdl(), jtxVar.lnr(), qdl(tvpVar, wdVar, qdlVar, jtxVar.ud()), qdl(jtxVar.ud()));
    }

    mml(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, String str, boolean z, List<lnr> list, com.bytedance.adsdk.ud.lnr.qdl.fs fsVar) {
        this.qdl = new com.bytedance.adsdk.ud.qdl.qdl();
        this.ud = new RectF();
        this.lnr = new Matrix();
        this.mml = new Path();
        this.mzz = new RectF();
        this.mo = str;
        this.tvp = tvpVar;
        this.wd = z;
        this.jpc = list;
        if (fsVar != null) {
            com.bytedance.adsdk.ud.qdl.ud.jtx jtxVar = fsVar.to();
            this.rq = jtxVar;
            jtxVar.qdl(qdlVar);
            this.rq.qdl(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            lnr lnrVar = list.get(size);
            if (lnrVar instanceof to) {
                arrayList.add((to) lnrVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((to) arrayList.get(size2)).qdl(list.listIterator(list.size()));
        }
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        this.tvp.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    public void qdl(List<lnr> list, List<lnr> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.jpc.size());
        arrayList.addAll(list);
        for (int size = this.jpc.size() - 1; size >= 0; size--) {
            lnr lnrVar = this.jpc.get(size);
            lnrVar.qdl(arrayList, this.jpc.subList(0, size));
            arrayList.add(lnrVar);
        }
    }

    List<exu> ud() {
        if (this.to == null) {
            this.to = new ArrayList();
            for (int i = 0; i < this.jpc.size(); i++) {
                lnr lnrVar = this.jpc.get(i);
                if (lnrVar instanceof exu) {
                    this.to.add((exu) lnrVar);
                }
            }
        }
        return this.to;
    }

    Matrix lnr() {
        com.bytedance.adsdk.ud.qdl.ud.jtx jtxVar = this.rq;
        if (jtxVar != null) {
            return jtxVar.mml();
        }
        this.lnr.reset();
        return this.lnr;
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.exu
    public Path mml() {
        this.lnr.reset();
        com.bytedance.adsdk.ud.qdl.ud.jtx jtxVar = this.rq;
        if (jtxVar != null) {
            this.lnr.set(jtxVar.mml());
        }
        this.mml.reset();
        if (this.wd) {
            return this.mml;
        }
        for (int size = this.jpc.size() - 1; size >= 0; size--) {
            lnr lnrVar = this.jpc.get(size);
            if (lnrVar instanceof exu) {
                this.mml.addPath(((exu) lnrVar).mml(), this.lnr);
            }
        }
        return this.mml;
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(Canvas canvas, Matrix matrix, int i) {
        if (this.wd) {
            return;
        }
        this.lnr.set(matrix);
        com.bytedance.adsdk.ud.qdl.ud.jtx jtxVar = this.rq;
        if (jtxVar != null) {
            this.lnr.preConcat(jtxVar.mml());
            i = (int) (((((this.rq.qdl() == null ? 100 : this.rq.qdl().wd().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.tvp.tvp() && mzz() && i != 255;
        if (z) {
            this.ud.set(0.0f, 0.0f, 0.0f, 0.0f);
            qdl(this.ud, this.lnr, true);
            this.qdl.setAlpha(i);
            com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.ud, this.qdl);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.jpc.size() - 1; size >= 0; size--) {
            lnr lnrVar = this.jpc.get(size);
            if (lnrVar instanceof mzz) {
                ((mzz) lnrVar).qdl(canvas, this.lnr, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean mzz() {
        int i = 0;
        for (int i2 = 0; i2 < this.jpc.size(); i2++) {
            if ((this.jpc.get(i2) instanceof mzz) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(RectF rectF, Matrix matrix, boolean z) {
        this.lnr.set(matrix);
        com.bytedance.adsdk.ud.qdl.ud.jtx jtxVar = this.rq;
        if (jtxVar != null) {
            this.lnr.preConcat(jtxVar.mml());
        }
        this.mzz.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.jpc.size() - 1; size >= 0; size--) {
            lnr lnrVar = this.jpc.get(size);
            if (lnrVar instanceof mzz) {
                ((mzz) lnrVar).qdl(this.mzz, this.lnr, z);
                rectF.union(this.mzz);
            }
        }
    }
}
