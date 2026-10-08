package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
public class exc extends Drawable {
    private int lnr;
    private RectF mml;
    private Paint qdl;
    private int ud;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public exc(int i, int i2) {
        this.lnr = i;
        this.ud = i2;
        Paint paint = new Paint();
        this.qdl = paint;
        paint.setColor(0);
        this.qdl.setAntiAlias(true);
        this.qdl.setShadowLayer(i2, 0.0f, 0.0f, -16777216);
        this.qdl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.ud;
        this.mml = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.mml;
        int i = this.lnr;
        canvas.drawRoundRect(rectF, i, i, this.qdl);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.qdl.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.qdl.setColorFilter(colorFilter);
    }
}
