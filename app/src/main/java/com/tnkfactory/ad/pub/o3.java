package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes6.dex */
public final class o3 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3171a;
    public float b;
    public float c;
    public final Paint d;
    public final Paint e;
    public final Paint f;
    public int g;
    public int h;
    public final int i;

    public o3(Context context, int i) {
        super(context);
        this.i = i;
        Paint paint = new Paint(1);
        this.d = paint;
        Paint paint2 = new Paint(1);
        this.e = paint2;
        Paint paint3 = new Paint(1);
        this.f = paint3;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        paint3.setStyle(style);
        paint.setStyle(Paint.Style.STROKE);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.c = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        float fApplyDimension = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        this.f3171a = fApplyDimension;
        float f = this.c;
        this.b = fApplyDimension - (0.5f * f);
        paint.setStrokeWidth(f);
        paint2.setColor(-1);
        paint3.setColor(ViewCompat.MEASURED_SIZE_MASK);
        paint.setColor(-4473925);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int height;
        float f;
        super.onDraw(canvas);
        if (this.i == 1) {
            width = getHeight();
            height = getWidth();
        } else {
            width = getWidth();
            height = getHeight();
        }
        float f2 = height / 2.0f;
        float f3 = this.f3171a;
        float f4 = ((width - (((this.h * f3) * 3.0f) - f3)) / 2.0f) + f3;
        float strokeWidth = this.b - (this.d.getStrokeWidth() * 0.5f);
        for (int i = 0; i < this.h; i++) {
            float f5 = this.f3171a;
            float f6 = (i * f5 * 3.0f) + f4;
            if (this.i == 1) {
                f = f6;
                f6 = f2;
            } else {
                f = f2;
            }
            if (i == this.g) {
                canvas.drawCircle(f6, f, f5, this.e);
            } else {
                if (this.f.getAlpha() > 0) {
                    canvas.drawCircle(f6, f, strokeWidth, this.f);
                }
                canvas.drawCircle(f6, f, this.b, this.d);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (this.i == 1) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != 1073741824) {
                size = (int) ((this.f3171a * 2.0f) + 10.0f);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                float f = this.h * 3;
                float f2 = this.f3171a;
                size2 = (int) (((f * f2) - f2) + 10.0f);
            }
            setMeasuredDimension(size, size2);
            return;
        }
        int mode3 = View.MeasureSpec.getMode(i);
        int size3 = View.MeasureSpec.getSize(i);
        if (mode3 != 1073741824) {
            float f3 = this.h * 3;
            float f4 = this.f3171a;
            size3 = (int) (((f3 * f4) - f4) + 10.0f);
        }
        int mode4 = View.MeasureSpec.getMode(i2);
        int size4 = View.MeasureSpec.getSize(i2);
        if (mode4 != 1073741824) {
            size4 = (int) ((this.f3171a * 2.0f) + 10.0f);
        }
        setMeasuredDimension(size3, size4);
    }

    public void setCount(int i) {
        this.h = i;
    }

    public void setLineColor(int i) {
        this.d.setColor(i);
    }

    public void setLineWidth(float f) {
        this.c = f;
        this.d.setStrokeWidth(f);
        this.b = this.f3171a - (this.c * 0.5f);
    }

    public void setOffFillColor(int i) {
        this.f.setColor(i);
    }

    public void setOffRadius(float f) {
        this.b = f;
    }

    public void setOnFillColor(int i) {
        this.e.setColor(i);
    }

    public void setRadius(float f) {
        this.f3171a = f;
        this.b = f - (this.c * 0.5f);
    }
}
