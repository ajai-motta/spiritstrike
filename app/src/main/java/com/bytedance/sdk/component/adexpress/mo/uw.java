package com.bytedance.sdk.component.adexpress.mo;

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
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class uw extends ImageView {
    private int lnr;
    private Matrix mml;
    private Paint qdl;
    private int ud;

    public uw(Context context) {
        this(context, null);
    }

    public uw(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public uw(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ud = 25;
        this.lnr = 25;
        Paint paint = new Paint();
        this.qdl = paint;
        paint.setAntiAlias(true);
        this.qdl.setFilterBitmap(true);
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

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            super.onDraw(canvas);
            return;
        }
        if (drawable != null) {
            Bitmap bitmapQdl = qdl(drawable);
            if (bitmapQdl != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(bitmapQdl, tileMode, tileMode);
                float fMax = (bitmapQdl.getWidth() == getWidth() && bitmapQdl.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapQdl.getWidth(), (getHeight() * 1.0f) / bitmapQdl.getHeight());
                this.mml.setScale(fMax, fMax);
                bitmapShader.setLocalMatrix(this.mml);
                this.qdl.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.ud, this.lnr, this.qdl);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
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
