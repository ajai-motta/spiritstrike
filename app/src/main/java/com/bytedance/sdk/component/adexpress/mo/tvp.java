package com.bytedance.sdk.component.adexpress.mo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends View {
    private int jpc;
    private final RectF lnr;
    private Paint mml;
    private int mo;
    private Paint mzz;
    private int qdl;
    private int ud;
    private Paint wd;

    public tvp(Context context) {
        super(context);
        this.lnr = new RectF();
        qdl();
    }

    private void qdl() {
        Paint paint = new Paint();
        this.mml = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.wd = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mzz = paint3;
        paint3.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.mo = i;
    }

    public void setDislikeColor(int i) {
        this.wd.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.wd.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.mml.setStyle(Paint.Style.STROKE);
        this.mml.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.mml.setStrokeWidth(i);
        this.jpc = i;
    }

    public void setBgColor(int i) {
        this.mzz.setStyle(Paint.Style.FILL);
        this.mzz.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.lnr;
        int i = this.mo;
        canvas.drawRoundRect(rectF, i, i, this.mzz);
        RectF rectF2 = this.lnr;
        int i2 = this.mo;
        canvas.drawRoundRect(rectF2, i2, i2, this.mml);
        int i3 = this.qdl;
        int i4 = this.ud;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.wd);
        int i5 = this.qdl;
        int i6 = this.ud;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.wd);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.qdl = i;
        this.ud = i2;
        RectF rectF = this.lnr;
        int i5 = this.jpc;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }
}
