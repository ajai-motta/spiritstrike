package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class jpc extends View {
    private static final int[] qdl = {Color.parseColor("#1AFFFFFF"), Color.parseColor("#4DFFFFFF"), Color.parseColor("#99FFFFFF")};
    private int jpc;
    private final RectF lnr;
    private final ArrayList<qdl> mml;
    private final Paint mo;
    private final Paint mzz;
    private int tvp;
    private final RectF ud;
    private int wd;

    public jpc(Context context) {
        super(context);
        this.ud = new RectF();
        this.lnr = new RectF();
        this.mml = new ArrayList<>();
        this.mo = new Paint();
        Paint paint = new Paint();
        this.mzz = paint;
        paint.setColor(Color.parseColor("#D9D9D9"));
    }

    public void setProgress(int i) {
        int i2 = this.jpc;
        if (i2 == i) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i2 == i) {
            return;
        }
        this.jpc = i;
        qdl();
    }

    private void qdl() {
        if (this.wd <= 0) {
            return;
        }
        int width = (int) (((this.jpc * 1.0f) / 100.0f) * getWidth());
        this.lnr.right = Math.max(this.tvp, width);
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i2 / 2;
        this.wd = i5;
        this.tvp = i5 * 5;
        float f = i;
        float f2 = i2;
        this.ud.set(0.0f, 0.0f, f, f2);
        this.lnr.set(0.0f, 0.0f, 0.0f, f2);
        this.mo.setShader(new LinearGradient(0.0f, 0.0f, f, f2, new int[]{Color.parseColor("#90C0FF"), Color.parseColor("#196BE4")}, (float[]) null, Shader.TileMode.CLAMP));
        this.mml.clear();
        float f3 = this.wd / 4.0f;
        for (int i6 : qdl) {
            Paint paint = new Paint();
            paint.setColor(i6);
            this.mml.add(new qdl(paint, this.wd / 2.0f, f3, f2 / 2.0f));
            f3 += (this.wd / 2.0f) * 3.0f;
        }
        qdl();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.ud;
        int i = this.wd;
        canvas.drawRoundRect(rectF, i, i, this.mzz);
        RectF rectF2 = this.lnr;
        int i2 = this.wd;
        canvas.drawRoundRect(rectF2, i2, i2, this.mo);
        int iSave = canvas.save();
        canvas.translate(this.lnr.right - this.tvp, 0.0f);
        for (qdl qdlVar : this.mml) {
            canvas.drawCircle(qdlVar.lnr, qdlVar.mml, qdlVar.ud, qdlVar.qdl);
        }
        canvas.restoreToCount(iSave);
    }

    private static final class qdl {
        float lnr;
        float mml;
        public Paint qdl;
        public float ud;

        public qdl(Paint paint, float f, float f2, float f3) {
            this.qdl = paint;
            this.ud = f;
            this.lnr = f2;
            this.mml = f3;
        }
    }
}
