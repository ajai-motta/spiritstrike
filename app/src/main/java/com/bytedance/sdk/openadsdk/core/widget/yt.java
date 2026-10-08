package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes3.dex */
public class yt extends com.bytedance.sdk.openadsdk.core.mo.mml {
    private int lnr;
    private final Matrix mml;
    private BitmapShader mo;
    private final RectF mzz;
    private final Paint qdl;
    private int ud;

    public yt(Context context) {
        this(context, null);
    }

    public yt(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public yt(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ud = 25;
        this.lnr = 25;
        this.mzz = new RectF();
        Paint paint = new Paint();
        this.qdl = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.mml = new Matrix();
    }

    public void setXRound(int i) {
        this.ud = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.lnr = i;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mzz.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapQdl;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            super.onDraw(canvas);
            return;
        }
        if (this.mo == null && (bitmapQdl = qdl(drawable)) != null) {
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mo = new BitmapShader(bitmapQdl, tileMode, tileMode);
            float fMax = (bitmapQdl.getWidth() == getWidth() && bitmapQdl.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapQdl.getWidth(), (getHeight() * 1.0f) / bitmapQdl.getHeight());
            this.mml.setScale(fMax, fMax);
            this.mo.setLocalMatrix(this.mml);
        }
        BitmapShader bitmapShader = this.mo;
        if (bitmapShader != null) {
            this.qdl.setShader(bitmapShader);
            canvas.drawRoundRect(this.mzz, this.ud, this.lnr, this.qdl);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.mo = null;
    }

    private Bitmap qdl(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
