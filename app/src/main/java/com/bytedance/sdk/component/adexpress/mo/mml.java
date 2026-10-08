package com.bytedance.sdk.component.adexpress.mo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends View {
    private float exu;
    private float fs;
    private List<Integer> jpc;
    private float lnr;
    private int mml;
    private int mo;
    private float mzz;
    private int qdl;
    private int rdp;
    private Paint rq;
    private Paint to;
    private List<Integer> tvp;
    private int ud;
    private boolean wd;

    public mml(Context context) {
        this(context, null);
    }

    public mml(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public mml(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qdl = -1;
        this.ud = SupportMenu.CATEGORY_MASK;
        this.lnr = 18.0f;
        this.mml = 3;
        this.mzz = 50.0f;
        this.mo = 2;
        this.wd = false;
        this.jpc = new ArrayList();
        this.tvp = new ArrayList();
        this.rdp = 24;
        lnr();
    }

    private void lnr() {
        Paint paint = new Paint();
        this.to = paint;
        paint.setAntiAlias(true);
        this.to.setStrokeWidth(this.rdp);
        this.jpc.add(255);
        this.tvp.add(0);
        Paint paint2 = new Paint();
        this.rq = paint2;
        paint2.setAntiAlias(true);
        this.rq.setColor(Color.parseColor("#0FFFFFFF"));
        this.rq.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.fs = f;
        this.exu = i2 / 2.0f;
        float f2 = f - (this.rdp / 2.0f);
        this.mzz = f2;
        this.lnr = f2 / 4.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.to.setShader(new LinearGradient(this.fs, 0.0f, this.exu, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.jpc.size()) {
                break;
            }
            Integer num = this.jpc.get(i);
            this.to.setAlpha(num.intValue());
            Integer num2 = this.tvp.get(i);
            if (this.lnr + num2.intValue() < this.mzz) {
                canvas.drawCircle(this.fs, this.exu, this.lnr + num2.intValue(), this.to);
            }
            if (num.intValue() > 0 && num2.intValue() < this.mzz) {
                this.jpc.set(i, Integer.valueOf(num.intValue() - this.mo > 0 ? num.intValue() - (this.mo * 3) : 1));
                this.tvp.set(i, Integer.valueOf(num2.intValue() + this.mo));
            }
            i++;
        }
        List<Integer> list = this.tvp;
        if (list.get(list.size() - 1).intValue() >= this.mzz / this.mml) {
            this.jpc.add(255);
            this.tvp.add(0);
        }
        if (this.tvp.size() >= 3) {
            this.tvp.remove(0);
            this.jpc.remove(0);
        }
        this.to.setAlpha(255);
        this.to.setColor(this.ud);
        canvas.drawCircle(this.fs, this.exu, this.lnr, this.rq);
        if (this.wd) {
            invalidate();
        }
    }

    public void qdl() {
        this.wd = true;
        invalidate();
    }

    public void ud() {
        this.wd = false;
        this.tvp.clear();
        this.jpc.clear();
        this.jpc.add(255);
        this.tvp.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.qdl = i;
    }

    public void setCoreColor(int i) {
        this.ud = i;
    }

    public void setCoreRadius(int i) {
        this.lnr = i;
    }

    public void setDiffuseWidth(int i) {
        this.mml = i;
    }

    public void setMaxWidth(int i) {
        this.mzz = i;
    }

    public void setDiffuseSpeed(int i) {
        this.mo = i;
    }
}
