package com.bytedance.adsdk.ud.lnr.lnr;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bytedance.adsdk.ud.lnr.lnr.mzz;
import com.bytedance.adsdk.ud.lnr.ud.jpc;
import com.bytedance.adsdk.ud.lnr.ud.rdp;
import com.bytedance.adsdk.ud.qdl.ud.jtx;
import com.bytedance.adsdk.ud.qdl.ud.qdl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class qdl implements com.bytedance.adsdk.ud.qdl.qdl.mzz, qdl.InterfaceC0180qdl {
    private final String aaj;
    private qdl bch;
    private final RectF bjy;
    private boolean bqt;
    private final RectF exc;
    private final Paint exu;
    private final RectF jl;
    private final RectF jtx;
    private com.bytedance.adsdk.ud.qdl.ud.jpc jyq;
    private float kdv;
    private boolean koa;
    private qdl ljh;
    final mzz lnr;
    final jtx mml;
    BlurMaskFilter mo;
    float mzz;
    private com.bytedance.adsdk.ud.qdl.ud.mml oth;
    final Matrix qdl;
    private final Matrix rc;
    private final Paint rdp;
    final com.bytedance.adsdk.ud.tvp ud;
    private List<qdl> uw;
    private Paint vu;
    private final List<com.bytedance.adsdk.ud.qdl.ud.qdl<?, ?>> xmv;
    private final RectF yt;
    private final Path wd = new Path();
    private final Matrix jpc = new Matrix();
    private final Matrix tvp = new Matrix();
    private final Paint to = new com.bytedance.adsdk.ud.qdl.qdl(1);
    private final Paint rq = new com.bytedance.adsdk.ud.qdl.qdl(1, PorterDuff.Mode.DST_IN);
    private final Paint fs = new com.bytedance.adsdk.ud.qdl.qdl(1, PorterDuff.Mode.DST_OUT);

    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    public void qdl(List<com.bytedance.adsdk.ud.qdl.qdl.lnr> list, List<com.bytedance.adsdk.ud.qdl.qdl.lnr> list2) {
    }

    static qdl qdl(ud udVar, mzz mzzVar, com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.wd wdVar, Context context) {
        switch (AnonymousClass2.qdl[mzzVar.rq().ordinal()]) {
            case 1:
                return new wd(tvpVar, mzzVar, udVar, wdVar);
            case 2:
                return new ud(tvpVar, mzzVar, wdVar.ud(mzzVar.wd()), wdVar, context);
            case 3:
                return new jpc(tvpVar, mzzVar);
            case 4:
                if (qdl(tvpVar, mzzVar, "text:")) {
                    return new lnr(tvpVar, mzzVar, context);
                }
                if (qdl(tvpVar, mzzVar, "videoview:")) {
                    return new to(tvpVar, mzzVar, context);
                }
                return new mml(tvpVar, mzzVar);
            case 5:
                return new mo(tvpVar, mzzVar);
            case 6:
                return new tvp(tvpVar, mzzVar);
            default:
                Objects.toString(mzzVar.rq());
                return null;
        }
    }

    private static boolean qdl(com.bytedance.adsdk.ud.tvp tvpVar, mzz mzzVar, String str) {
        com.bytedance.adsdk.ud.to toVarMo;
        if (tvpVar == null || mzzVar == null || str == null || (toVarMo = tvpVar.mo(mzzVar.wd())) == null) {
            return false;
        }
        return str.equals(toVarMo.to());
    }

    qdl(com.bytedance.adsdk.ud.tvp tvpVar, mzz mzzVar) {
        com.bytedance.adsdk.ud.qdl.qdl qdlVar = new com.bytedance.adsdk.ud.qdl.qdl(1);
        this.exu = qdlVar;
        this.rdp = new com.bytedance.adsdk.ud.qdl.qdl(PorterDuff.Mode.CLEAR);
        this.bjy = new RectF();
        this.jtx = new RectF();
        this.yt = new RectF();
        this.jl = new RectF();
        this.exc = new RectF();
        this.qdl = new Matrix();
        this.xmv = new ArrayList();
        this.bqt = true;
        this.mzz = 0.0f;
        this.rc = new Matrix();
        this.kdv = 1.0f;
        this.ud = tvpVar;
        this.lnr = mzzVar;
        this.aaj = mzzVar.mo() + "#draw";
        if (mzzVar.fs() == mzz.ud.INVERT) {
            qdlVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            qdlVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        jtx jtxVar = mzzVar.bjy().to();
        this.mml = jtxVar;
        jtxVar.qdl((qdl.InterfaceC0180qdl) this);
        if (mzzVar.to() != null && !mzzVar.to().isEmpty()) {
            com.bytedance.adsdk.ud.qdl.ud.jpc jpcVar = new com.bytedance.adsdk.ud.qdl.ud.jpc(mzzVar.to());
            this.jyq = jpcVar;
            Iterator<com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path>> it = jpcVar.ud().iterator();
            while (it.hasNext()) {
                it.next().qdl(this);
            }
            for (com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2 : this.jyq.lnr()) {
                qdl(qdlVar2);
                qdlVar2.qdl(this);
            }
        }
        fs();
    }

    void qdl(boolean z) {
        if (z && this.vu == null) {
            this.vu = new com.bytedance.adsdk.ud.qdl.qdl();
        }
        this.koa = z;
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        exu();
    }

    mzz ud() {
        return this.lnr;
    }

    void qdl(qdl qdlVar) {
        this.ljh = qdlVar;
    }

    boolean lnr() {
        return this.ljh != null;
    }

    void ud(qdl qdlVar) {
        this.bch = qdlVar;
    }

    private void fs() {
        if (!this.lnr.mml().isEmpty()) {
            com.bytedance.adsdk.ud.qdl.ud.mml mmlVar = new com.bytedance.adsdk.ud.qdl.ud.mml(this.lnr.mml());
            this.oth = mmlVar;
            mmlVar.qdl();
            this.oth.qdl(new qdl.InterfaceC0180qdl() { // from class: com.bytedance.adsdk.ud.lnr.lnr.qdl.1
                @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
                public void qdl() {
                    qdl qdlVar = qdl.this;
                    qdlVar.ud(qdlVar.oth.tvp() == 1.0f);
                }
            });
            ud(this.oth.wd().floatValue() == 1.0f);
            qdl(this.oth);
            return;
        }
        ud(true);
    }

    private void exu() {
        this.ud.invalidateSelf();
    }

    public void qdl(com.bytedance.adsdk.ud.qdl.ud.qdl<?, ?> qdlVar) {
        if (qdlVar == null) {
            return;
        }
        this.xmv.add(qdlVar);
    }

    public Matrix mml() {
        return this.rc;
    }

    public String mzz() {
        mzz mzzVar = this.lnr;
        if (mzzVar != null) {
            return mzzVar.wd();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(RectF rectF, Matrix matrix, boolean z) {
        this.bjy.set(0.0f, 0.0f, 0.0f, 0.0f);
        bjy();
        this.qdl.set(matrix);
        if (z) {
            List<qdl> list = this.uw;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.qdl.preConcat(this.uw.get(size).mml.mml());
                }
            } else {
                qdl qdlVar = this.bch;
                if (qdlVar != null) {
                    this.qdl.preConcat(qdlVar.mml.mml());
                }
            }
        }
        this.qdl.preConcat(this.mml.mml());
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numWd;
        com.bytedance.adsdk.ud.mzz.qdl(this.aaj);
        if (!this.bqt || this.lnr.oth()) {
            com.bytedance.adsdk.ud.mzz.ud(this.aaj);
            return;
        }
        bjy();
        com.bytedance.adsdk.ud.mzz.qdl("Layer#parentMatrix");
        this.rc.set(matrix);
        this.jpc.reset();
        this.jpc.set(matrix);
        for (int size = this.uw.size() - 1; size >= 0; size--) {
            this.jpc.preConcat(this.uw.get(size).mml.mml());
        }
        com.bytedance.adsdk.ud.mzz.ud("Layer#parentMatrix");
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Integer> qdlVarQdl = this.mml.qdl();
        int iIntValue = (int) ((((i / 255.0f) * ((qdlVarQdl == null || (numWd = qdlVarQdl.wd()) == null) ? 100 : numWd.intValue())) / 100.0f) * 255.0f);
        if (!lnr() && !wd()) {
            this.jpc.preConcat(this.mml.mml());
            com.bytedance.adsdk.ud.mzz.qdl("Layer#drawLayer");
            ud(canvas, this.jpc, iIntValue);
            com.bytedance.adsdk.ud.mzz.ud("Layer#drawLayer");
            lnr(com.bytedance.adsdk.ud.mzz.ud(this.aaj));
            return;
        }
        com.bytedance.adsdk.ud.mzz.qdl("Layer#computeBounds");
        qdl(this.bjy, this.jpc, false);
        ud(this.bjy, matrix);
        this.jpc.preConcat(this.mml.mml());
        qdl(this.bjy, this.jpc);
        this.jtx.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.tvp);
        if (!this.tvp.isIdentity()) {
            Matrix matrix2 = this.tvp;
            matrix2.invert(matrix2);
            this.tvp.mapRect(this.jtx);
        }
        if (!this.bjy.intersect(this.jtx)) {
            this.bjy.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.ud.mzz.ud("Layer#computeBounds");
        if (this.bjy.width() >= 1.0f && this.bjy.height() >= 1.0f) {
            com.bytedance.adsdk.ud.mzz.qdl("Layer#saveLayer");
            this.to.setAlpha(255);
            com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.to);
            com.bytedance.adsdk.ud.mzz.ud("Layer#saveLayer");
            qdl(canvas);
            com.bytedance.adsdk.ud.mzz.qdl("Layer#drawLayer");
            ud(canvas, this.jpc, iIntValue);
            com.bytedance.adsdk.ud.mzz.ud("Layer#drawLayer");
            if (wd()) {
                qdl(canvas, this.jpc);
            }
            if (lnr()) {
                com.bytedance.adsdk.ud.mzz.qdl("Layer#drawMatte");
                com.bytedance.adsdk.ud.mzz.qdl("Layer#saveLayer");
                com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.exu, 19);
                com.bytedance.adsdk.ud.mzz.ud("Layer#saveLayer");
                qdl(canvas);
                this.ljh.qdl(canvas, matrix, iIntValue);
                com.bytedance.adsdk.ud.mzz.qdl("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.ud.mzz.ud("Layer#restoreLayer");
                com.bytedance.adsdk.ud.mzz.ud("Layer#drawMatte");
            }
            com.bytedance.adsdk.ud.mzz.qdl("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.ud.mzz.ud("Layer#restoreLayer");
        }
        if (this.koa && (paint = this.vu) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.vu.setColor(-251901);
            this.vu.setStrokeWidth(4.0f);
            canvas.drawRect(this.bjy, this.vu);
            this.vu.setStyle(Paint.Style.FILL);
            this.vu.setColor(1357638635);
            canvas.drawRect(this.bjy, this.vu);
        }
        lnr(com.bytedance.adsdk.ud.mzz.ud(this.aaj));
    }

    private void lnr(float f) {
        this.ud.xmv().lnr().qdl(this.lnr.mo(), f);
    }

    private void qdl(Canvas canvas) {
        com.bytedance.adsdk.ud.mzz.qdl("Layer#clearLayer");
        canvas.drawRect(this.bjy.left - 1.0f, this.bjy.top - 1.0f, this.bjy.right + 1.0f, this.bjy.bottom + 1.0f, this.rdp);
        com.bytedance.adsdk.ud.mzz.ud("Layer#clearLayer");
    }

    private void qdl(RectF rectF, Matrix matrix) {
        this.yt.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (wd()) {
            int size = this.jyq.qdl().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.ud.lnr.ud.jpc jpcVar = this.jyq.qdl().get(i);
                Path pathWd = this.jyq.ud().get(i).wd();
                if (pathWd != null) {
                    this.wd.set(pathWd);
                    this.wd.transform(matrix);
                    int i2 = AnonymousClass2.ud[jpcVar.qdl().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && jpcVar.mml()) {
                        return;
                    }
                    this.wd.computeBounds(this.exc, false);
                    if (i == 0) {
                        this.yt.set(this.exc);
                    } else {
                        RectF rectF2 = this.yt;
                        rectF2.set(Math.min(rectF2.left, this.exc.left), Math.min(this.yt.top, this.exc.top), Math.max(this.yt.right, this.exc.right), Math.max(this.yt.bottom, this.exc.bottom));
                    }
                }
            }
            if (rectF.intersect(this.yt)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ud.lnr.lnr.qdl$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] qdl;
        static final /* synthetic */ int[] ud;

        static {
            int[] iArr = new int[jpc.qdl.values().length];
            ud = iArr;
            try {
                iArr[jpc.qdl.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ud[jpc.qdl.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ud[jpc.qdl.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                ud[jpc.qdl.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[mzz.qdl.values().length];
            qdl = iArr2;
            try {
                iArr2[mzz.qdl.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                qdl[mzz.qdl.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                qdl[mzz.qdl.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                qdl[mzz.qdl.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                qdl[mzz.qdl.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                qdl[mzz.qdl.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                qdl[mzz.qdl.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void ud(RectF rectF, Matrix matrix) {
        if (lnr() && this.lnr.fs() != mzz.ud.INVERT) {
            this.jl.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.ljh.qdl(this.jl, matrix, true);
            if (rectF.intersect(this.jl)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float mo() {
        return this.kdv;
    }

    protected void qdl(int i) {
        this.kdv = ((this.mml.qdl() != null ? this.mml.qdl().wd().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void ud(Canvas canvas, Matrix matrix, int i) {
        qdl(i);
    }

    private void qdl(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.ud.mzz.qdl("Layer#saveLayer");
        com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.rq, 19);
        if (Build.VERSION.SDK_INT < 28) {
            qdl(canvas);
        }
        com.bytedance.adsdk.ud.mzz.ud("Layer#saveLayer");
        for (int i = 0; i < this.jyq.qdl().size(); i++) {
            com.bytedance.adsdk.ud.lnr.ud.jpc jpcVar = this.jyq.qdl().get(i);
            com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar = this.jyq.ud().get(i);
            com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2 = this.jyq.lnr().get(i);
            int i2 = AnonymousClass2.ud[jpcVar.qdl().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.to.setColor(-16777216);
                        this.to.setAlpha(255);
                        canvas.drawRect(this.bjy, this.to);
                    }
                    if (jpcVar.mml()) {
                        lnr(canvas, matrix, qdlVar, qdlVar2);
                    } else {
                        qdl(canvas, matrix, qdlVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (jpcVar.mml()) {
                            ud(canvas, matrix, qdlVar, qdlVar2);
                        } else {
                            qdl(canvas, matrix, qdlVar, qdlVar2);
                        }
                    }
                } else if (jpcVar.mml()) {
                    mzz(canvas, matrix, qdlVar, qdlVar2);
                } else {
                    mml(canvas, matrix, qdlVar, qdlVar2);
                }
            } else if (rdp()) {
                this.to.setAlpha(255);
                canvas.drawRect(this.bjy, this.to);
            }
        }
        com.bytedance.adsdk.ud.mzz.qdl("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.ud.mzz.ud("Layer#restoreLayer");
    }

    private boolean rdp() {
        if (this.jyq.ud().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.jyq.qdl().size(); i++) {
            if (this.jyq.qdl().get(i).qdl() != jpc.qdl.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void qdl(Canvas canvas, Matrix matrix, com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar, com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2) {
        this.wd.set(qdlVar.wd());
        this.wd.transform(matrix);
        this.to.setAlpha((int) (qdlVar2.wd().intValue() * 2.55f));
        canvas.drawPath(this.wd, this.to);
    }

    private void ud(Canvas canvas, Matrix matrix, com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar, com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2) {
        com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.to);
        canvas.drawRect(this.bjy, this.to);
        this.wd.set(qdlVar.wd());
        this.wd.transform(matrix);
        this.to.setAlpha((int) (qdlVar2.wd().intValue() * 2.55f));
        canvas.drawPath(this.wd, this.fs);
        canvas.restore();
    }

    private void qdl(Canvas canvas, Matrix matrix, com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar) {
        this.wd.set(qdlVar.wd());
        this.wd.transform(matrix);
        canvas.drawPath(this.wd, this.fs);
    }

    private void lnr(Canvas canvas, Matrix matrix, com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar, com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2) {
        com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.fs);
        canvas.drawRect(this.bjy, this.to);
        this.fs.setAlpha((int) (qdlVar2.wd().intValue() * 2.55f));
        this.wd.set(qdlVar.wd());
        this.wd.transform(matrix);
        canvas.drawPath(this.wd, this.fs);
        canvas.restore();
    }

    private void mml(Canvas canvas, Matrix matrix, com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar, com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2) {
        com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.rq);
        this.wd.set(qdlVar.wd());
        this.wd.transform(matrix);
        this.to.setAlpha((int) (qdlVar2.wd().intValue() * 2.55f));
        canvas.drawPath(this.wd, this.to);
        canvas.restore();
    }

    private void mzz(Canvas canvas, Matrix matrix, com.bytedance.adsdk.ud.qdl.ud.qdl<rdp, Path> qdlVar, com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2) {
        com.bytedance.adsdk.ud.mo.mo.qdl(canvas, this.bjy, this.rq);
        canvas.drawRect(this.bjy, this.to);
        this.fs.setAlpha((int) (qdlVar2.wd().intValue() * 2.55f));
        this.wd.set(qdlVar.wd());
        this.wd.transform(matrix);
        canvas.drawPath(this.wd, this.fs);
        canvas.restore();
    }

    boolean wd() {
        com.bytedance.adsdk.ud.qdl.ud.jpc jpcVar = this.jyq;
        return (jpcVar == null || jpcVar.ud().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(boolean z) {
        if (z != this.bqt) {
            this.bqt = z;
            exu();
        }
    }

    public boolean jpc() {
        return this.bqt;
    }

    void qdl(float f) {
        this.mml.qdl(f);
        if (this.jyq != null) {
            for (int i = 0; i < this.jyq.ud().size(); i++) {
                this.jyq.ud().get(i).qdl(f);
            }
        }
        com.bytedance.adsdk.ud.qdl.ud.mml mmlVar = this.oth;
        if (mmlVar != null) {
            mmlVar.qdl(f);
        }
        qdl qdlVar = this.ljh;
        if (qdlVar != null) {
            qdlVar.qdl(f);
        }
        for (int i2 = 0; i2 < this.xmv.size(); i2++) {
            this.xmv.get(i2).qdl(f);
        }
    }

    private void bjy() {
        if (this.uw != null) {
            return;
        }
        if (this.bch == null) {
            this.uw = Collections.emptyList();
            return;
        }
        this.uw = new ArrayList();
        for (qdl qdlVar = this.bch; qdlVar != null; qdlVar = qdlVar.bch) {
            this.uw.add(qdlVar);
        }
    }

    public String tvp() {
        return this.lnr.mo();
    }

    public com.bytedance.adsdk.ud.lnr.ud.qdl to() {
        return this.lnr.ljh();
    }

    public BlurMaskFilter ud(float f) {
        if (this.mzz == f) {
            return this.mo;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.mo = blurMaskFilter;
        this.mzz = f;
        return blurMaskFilter;
    }

    public com.bytedance.adsdk.ud.mzz.to rq() {
        return this.lnr.bch();
    }
}
