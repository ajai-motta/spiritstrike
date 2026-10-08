package com.bytedance.adsdk.ud.qdl.qdl;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.ud.qdl.ud.qdl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class qdl implements mzz, rq, qdl.InterfaceC0180qdl {
    private com.bytedance.adsdk.ud.qdl.ud.qdl<ColorFilter, ColorFilter> bjy;
    private final List<com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float>> exu;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Integer> fs;
    private final com.bytedance.adsdk.ud.tvp jpc;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> jtx;
    float lnr;
    protected final com.bytedance.adsdk.ud.lnr.lnr.qdl qdl;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> rdp;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> rq;
    private final float[] to;
    final Paint ud;
    private com.bytedance.adsdk.ud.qdl.ud.lnr yt;
    private final PathMeasure mml = new PathMeasure();
    private final Path mzz = new Path();
    private final Path mo = new Path();
    private final RectF wd = new RectF();
    private final List<C0179qdl> tvp = new ArrayList();

    qdl(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.ud.lnr.qdl.mml mmlVar, com.bytedance.adsdk.ud.lnr.qdl.ud udVar, List<com.bytedance.adsdk.ud.lnr.qdl.ud> list, com.bytedance.adsdk.ud.lnr.qdl.ud udVar2) {
        com.bytedance.adsdk.ud.qdl.qdl qdlVar2 = new com.bytedance.adsdk.ud.qdl.qdl(1);
        this.ud = qdlVar2;
        this.lnr = 0.0f;
        this.jpc = tvpVar;
        this.qdl = qdlVar;
        qdlVar2.setStyle(Paint.Style.STROKE);
        qdlVar2.setStrokeCap(cap);
        qdlVar2.setStrokeJoin(join);
        qdlVar2.setStrokeMiter(f);
        this.fs = mmlVar.qdl();
        this.rq = udVar.qdl();
        if (udVar2 == null) {
            this.rdp = null;
        } else {
            this.rdp = udVar2.qdl();
        }
        this.exu = new ArrayList(list.size());
        this.to = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.exu.add(list.get(i).qdl());
        }
        qdlVar.qdl(this.fs);
        qdlVar.qdl(this.rq);
        for (int i2 = 0; i2 < this.exu.size(); i2++) {
            qdlVar.qdl(this.exu.get(i2));
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> qdlVar3 = this.rdp;
        if (qdlVar3 != null) {
            qdlVar.qdl(qdlVar3);
        }
        this.fs.qdl(this);
        this.rq.qdl(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.exu.get(i3).qdl(this);
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> qdlVar4 = this.rdp;
        if (qdlVar4 != null) {
            qdlVar4.qdl(this);
        }
        if (qdlVar.to() != null) {
            com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl = qdlVar.to().qdl().qdl();
            this.jtx = qdlVarQdl;
            qdlVarQdl.qdl(this);
            qdlVar.qdl(this.jtx);
        }
        if (qdlVar.rq() != null) {
            this.yt = new com.bytedance.adsdk.ud.qdl.ud.lnr(this, qdlVar, qdlVar.rq());
        }
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        this.jpc.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(java.util.List<com.bytedance.adsdk.ud.qdl.qdl.lnr> r8, java.util.List<com.bytedance.adsdk.ud.qdl.qdl.lnr> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.bytedance.adsdk.ud.qdl.qdl.lnr r3 = (com.bytedance.adsdk.ud.qdl.qdl.lnr) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.ud.qdl.qdl.jyq
            if (r4 == 0) goto L1f
            com.bytedance.adsdk.ud.qdl.qdl.jyq r3 = (com.bytedance.adsdk.ud.qdl.qdl.jyq) r3
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r4 = r3.ud()
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r5 = com.bytedance.adsdk.ud.lnr.ud.exc.qdl.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.qdl(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.bytedance.adsdk.ud.qdl.qdl.lnr r3 = (com.bytedance.adsdk.ud.qdl.qdl.lnr) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.ud.qdl.qdl.jyq
            if (r4 == 0) goto L55
            r4 = r3
            com.bytedance.adsdk.ud.qdl.qdl.jyq r4 = (com.bytedance.adsdk.ud.qdl.qdl.jyq) r4
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r5 = r4.ud()
            com.bytedance.adsdk.ud.lnr.ud.exc$qdl r6 = com.bytedance.adsdk.ud.lnr.ud.exc.qdl.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl> r3 = r7.tvp
            r3.add(r0)
        L4c:
            com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl r0 = new com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl
            r0.<init>(r4)
            r4.qdl(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.bytedance.adsdk.ud.qdl.qdl.exu
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl r0 = new com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.bytedance.adsdk.ud.qdl.qdl.qdl.C0179qdl.qdl(r0)
            com.bytedance.adsdk.ud.qdl.qdl.exu r3 = (com.bytedance.adsdk.ud.qdl.qdl.exu) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl> r8 = r7.tvp
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.qdl.qdl.qdl.qdl(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.ud.mzz.qdl("StrokeContent#draw");
        if (com.bytedance.adsdk.ud.mo.mo.ud(matrix)) {
            com.bytedance.adsdk.ud.mzz.ud("StrokeContent#draw");
            return;
        }
        this.ud.setAlpha(com.bytedance.adsdk.ud.mo.mzz.qdl((int) ((((i / 255.0f) * ((com.bytedance.adsdk.ud.qdl.ud.mo) this.fs).tvp()) / 100.0f) * 255.0f), 0, 255));
        this.ud.setStrokeWidth(((com.bytedance.adsdk.ud.qdl.ud.mml) this.rq).tvp() * com.bytedance.adsdk.ud.mo.mo.qdl(matrix));
        if (this.ud.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.ud.mzz.ud("StrokeContent#draw");
            return;
        }
        qdl(matrix);
        com.bytedance.adsdk.ud.qdl.ud.qdl<ColorFilter, ColorFilter> qdlVar = this.bjy;
        if (qdlVar != null) {
            this.ud.setColorFilter(qdlVar.wd());
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVar2 = this.jtx;
        if (qdlVar2 != null) {
            float fFloatValue = qdlVar2.wd().floatValue();
            if (fFloatValue == 0.0f) {
                this.ud.setMaskFilter(null);
            } else if (fFloatValue != this.lnr) {
                this.ud.setMaskFilter(this.qdl.ud(fFloatValue));
            }
            this.lnr = fFloatValue;
        }
        com.bytedance.adsdk.ud.qdl.ud.lnr lnrVar = this.yt;
        if (lnrVar != null) {
            lnrVar.qdl(this.ud);
        }
        for (int i2 = 0; i2 < this.tvp.size(); i2++) {
            C0179qdl c0179qdl = this.tvp.get(i2);
            if (c0179qdl.ud != null) {
                qdl(canvas, c0179qdl, matrix);
            } else {
                com.bytedance.adsdk.ud.mzz.qdl("StrokeContent#buildPath");
                this.mzz.reset();
                for (int size = c0179qdl.qdl.size() - 1; size >= 0; size--) {
                    this.mzz.addPath(((exu) c0179qdl.qdl.get(size)).mml(), matrix);
                }
                com.bytedance.adsdk.ud.mzz.ud("StrokeContent#buildPath");
                com.bytedance.adsdk.ud.mzz.qdl("StrokeContent#drawPath");
                canvas.drawPath(this.mzz, this.ud);
                com.bytedance.adsdk.ud.mzz.ud("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.ud.mzz.ud("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(android.graphics.Canvas r17, com.bytedance.adsdk.ud.qdl.qdl.qdl.C0179qdl r18, android.graphics.Matrix r19) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.qdl.qdl.qdl.qdl(android.graphics.Canvas, com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl, android.graphics.Matrix):void");
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.ud.mzz.qdl("StrokeContent#getBounds");
        this.mzz.reset();
        for (int i = 0; i < this.tvp.size(); i++) {
            C0179qdl c0179qdl = this.tvp.get(i);
            for (int i2 = 0; i2 < c0179qdl.qdl.size(); i2++) {
                this.mzz.addPath(((exu) c0179qdl.qdl.get(i2)).mml(), matrix);
            }
        }
        this.mzz.computeBounds(this.wd, false);
        float fTvp = ((com.bytedance.adsdk.ud.qdl.ud.mml) this.rq).tvp();
        RectF rectF2 = this.wd;
        float f = fTvp / 2.0f;
        rectF2.set(rectF2.left - f, this.wd.top - f, this.wd.right + f, this.wd.bottom + f);
        rectF.set(this.wd);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.ud.mzz.ud("StrokeContent#getBounds");
    }

    private void qdl(Matrix matrix) {
        com.bytedance.adsdk.ud.mzz.qdl("StrokeContent#applyDashPattern");
        if (this.exu.isEmpty()) {
            com.bytedance.adsdk.ud.mzz.ud("StrokeContent#applyDashPattern");
            return;
        }
        float fQdl = com.bytedance.adsdk.ud.mo.mo.qdl(matrix);
        for (int i = 0; i < this.exu.size(); i++) {
            this.to[i] = this.exu.get(i).wd().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.to;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.to;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.to;
            fArr3[i] = fArr3[i] * fQdl;
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> qdlVar = this.rdp;
        this.ud.setPathEffect(new DashPathEffect(this.to, qdlVar == null ? 0.0f : fQdl * qdlVar.wd().floatValue()));
        com.bytedance.adsdk.ud.mzz.ud("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ud.qdl.qdl.qdl$qdl, reason: collision with other inner class name */
    private static final class C0179qdl {
        private final List<exu> qdl;
        private final jyq ud;

        private C0179qdl(jyq jyqVar) {
            this.qdl = new ArrayList();
            this.ud = jyqVar;
        }
    }
}
