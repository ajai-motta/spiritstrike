package com.tnkfactory.ad.pub;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;

/* JADX INFO: loaded from: classes6.dex */
public final class j1 extends Shape {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3145a;
    public final float b;
    public final Path c = new Path();
    public final Paint d;
    public final Paint e;
    public final int f;

    public j1(float f, int i, int i2, int i3, int i4) {
        Paint paint = new Paint(1);
        this.d = paint;
        Paint paint2 = new Paint(1);
        this.e = paint2;
        this.b = f;
        this.f3145a = i;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(i2);
        paint2.setStyle(style);
        paint2.setColor(i3);
        this.f = i4;
    }

    @Override // android.graphics.drawable.shapes.Shape
    public final Shape clone() {
        return new j1(this.b, this.f3145a, this.d.getColor(), this.e.getColor(), this.f);
    }

    @Override // android.graphics.drawable.shapes.Shape
    public final void draw(Canvas canvas, Paint paint) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        int i = this.f3145a;
        int i2 = (int) (width / i);
        if (height < i2) {
            i2 = (int) height;
        }
        float f = i2;
        int i3 = ((int) (height - f)) / 2;
        int i4 = i * i2;
        int i5 = (int) (i4 * this.b);
        int i6 = (i2 + i3) - 2;
        int i7 = 0;
        canvas.drawRect(new Rect(0, i3, i5, i6), this.d);
        canvas.drawRect(new Rect(i5, i3, i4, i6), this.e);
        float f2 = f / 2.0f;
        float f3 = i3 + f2;
        float f4 = 0.98f * f * 0.5f;
        float f5 = 0.4f * f4;
        double d = 6.283185307179586d / ((double) 5);
        this.c.reset();
        this.c.setFillType(Path.FillType.INVERSE_WINDING);
        while (i7 < this.f3145a) {
            double d2 = f2;
            int i8 = i7;
            double d3 = f4;
            double d4 = d;
            double d5 = f3;
            float f6 = f3;
            float f7 = f4;
            this.c.moveTo((float) ((Math.cos(-1.5707999467849731d) * d3) + d2), (float) ((Math.sin(-1.5707999467849731d) * d3) + d5));
            double d6 = f5;
            double d7 = d4 / 2.0d;
            double d8 = d7 - 1.5707999467849731d;
            this.c.lineTo((float) ((Math.cos(d8) * d6) + d2), (float) ((Math.sin(d8) * d6) + d5));
            int i9 = 1;
            while (i9 < 5) {
                double d9 = (((double) i9) * d4) - 1.5707999467849731d;
                this.c.lineTo((float) ((Math.cos(d9) * d3) + d2), (float) ((Math.sin(d9) * d3) + d5));
                double d10 = d9 + d7;
                this.c.lineTo((float) ((Math.cos(d10) * d6) + d2), (float) ((Math.sin(d10) * d6) + d5));
                i9++;
                f = f;
                f5 = f5;
            }
            this.c.close();
            f2 += f;
            i7 = i8 + 1;
            f3 = f6;
            d = d4;
            f4 = f7;
        }
        paint.setColor(this.f);
        canvas.drawPath(this.c, paint);
    }

    @Override // android.graphics.drawable.shapes.Shape
    public final Object clone() {
        return new j1(this.b, this.f3145a, this.d.getColor(), this.e.getColor(), this.f);
    }
}
