package com.bytedance.sdk.openadsdk.core.rq.ud.lnr;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.mml;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends View {
    private int exu;
    private ValueAnimator fs;
    private int jpc;
    private RectF lnr;
    private int mml;
    private float mo;
    private int mzz;
    private Paint qdl;
    private float rdp;
    private mml rq;
    private String to;
    private int tvp;
    private Paint ud;
    private float wd;

    public qdl(Context context) {
        super(context);
        this.mml = com.bytedance.adsdk.ugeno.wd.qdl.qdl("#FFD813");
        this.mzz = com.bytedance.adsdk.ugeno.wd.qdl.qdl("rgba(0, 0, 0, 0.5)");
        this.mo = 3.0f;
        this.wd = 0.0f;
        this.jpc = 0;
        this.tvp = 100;
        this.to = "line";
        this.exu = 1000;
        setBackgroundColor(0);
        qdl();
    }

    private void qdl() {
        Paint paint = new Paint(1);
        this.qdl = paint;
        paint.setColor(this.mzz);
        this.qdl.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.ud = paint2;
        paint2.setColor(this.mml);
        this.ud.setStyle(Paint.Style.FILL);
        this.lnr = new RectF();
        this.rdp = this.jpc;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(new float[0]);
        this.fs = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.exu);
        this.fs.setInterpolator(new LinearInterpolator());
        this.fs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.rq.ud.lnr.qdl.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                qdl.this.rdp = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                qdl.this.invalidate();
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.equals(this.to, "ring") || TextUtils.equals(this.to, "ring_reverse")) {
            qdl(canvas);
        } else {
            ud(canvas);
        }
    }

    private void qdl(Canvas canvas) {
        float f;
        int i;
        float f2 = this.mo / 2.0f;
        this.lnr.set(f2, f2, getWidth() - f2, getHeight() - f2);
        this.qdl.setStyle(Paint.Style.STROKE);
        this.qdl.setStrokeWidth(this.mo);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - f2, this.qdl);
        if (TextUtils.equals(this.to, "ring_reverse")) {
            f = this.rdp * (-360.0f);
            i = this.tvp;
        } else {
            f = this.rdp * 360.0f;
            i = this.tvp;
        }
        float f3 = f / i;
        this.ud.setStyle(Paint.Style.STROKE);
        this.ud.setStrokeWidth(this.mo);
        if (this.wd <= 0.0f) {
            this.ud.setStrokeCap(Paint.Cap.SQUARE);
        } else {
            this.ud.setStrokeCap(Paint.Cap.ROUND);
        }
        canvas.drawArc(this.lnr, -90.0f, f3, false, this.ud);
    }

    private void ud(Canvas canvas) {
        this.qdl.setStyle(Paint.Style.FILL);
        float width = getWidth();
        float f = this.mo;
        float f2 = this.wd;
        canvas.drawRoundRect(0.0f, 0.0f, width, f, f2, f2, this.qdl);
        float width2 = (getWidth() * this.rdp) / this.tvp;
        this.ud.setStyle(Paint.Style.FILL);
        if (TextUtils.equals(this.to, "line_reverse")) {
            float width3 = getWidth();
            float f3 = this.mo;
            float f4 = this.wd;
            canvas.drawRoundRect(getWidth() - width2, 0.0f, width3, f3, f4, f4, this.ud);
            return;
        }
        float f5 = this.mo;
        float f6 = this.wd;
        canvas.drawRoundRect(0.0f, 0.0f, width2, f5, f6, f6, this.ud);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        mml mmlVar = this.rq;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            super.onMeasure(iArrQdl[0], iArrQdl[1]);
        } else {
            super.onMeasure(i, i2);
        }
        if (TextUtils.equals(this.to, "ring") || TextUtils.equals(this.to, "ring_reverse")) {
            int iMin = Math.min(getMeasuredWidth(), getMeasuredHeight());
            setMeasuredDimension(iMin, iMin);
        } else {
            setMeasuredDimension(getMeasuredWidth(), (int) this.mo);
        }
        mml mmlVar2 = this.rq;
        if (mmlVar2 != null) {
            mmlVar2.mzz();
        }
    }

    public void setProgress(int i) {
        int iMin = Math.min(i, this.tvp);
        this.jpc = iMin;
        if (iMin < 0) {
            this.jpc = 0;
        }
        ValueAnimator valueAnimator = this.fs;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.fs.setFloatValues(this.rdp, this.jpc);
            Log.d("UGenRender", "setProgress: animatedProgress=" + this.rdp + " progress=" + i);
            this.fs.start();
        }
    }

    public qdl qdl(int i) {
        this.ud.setColor(i);
        return this;
    }

    public qdl ud(int i) {
        this.qdl.setColor(i);
        return this;
    }

    public qdl qdl(float f) {
        this.mo = f;
        invalidate();
        return this;
    }

    public qdl ud(float f) {
        this.wd = f;
        return this;
    }

    public void setMaxProgress(int i) {
        this.tvp = i;
        invalidate();
    }

    public qdl qdl(String str) {
        this.to = str;
        return this;
    }

    public int getProgress() {
        return this.jpc;
    }

    public int getMaxProgress() {
        return this.tvp;
    }

    public void qdl(mml mmlVar) {
        this.rq = mmlVar;
    }

    public void setAnimationDuration(int i) {
        this.exu = i;
        this.fs.setDuration(i);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.fs;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
