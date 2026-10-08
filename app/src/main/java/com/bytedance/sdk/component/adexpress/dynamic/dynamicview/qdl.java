package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends ud {
    private final Bitmap lnr;
    private final Rect ud = new Rect();
    private final Paint mml = new Paint(1);

    public qdl(Bitmap bitmap, ud udVar) {
        this.lnr = bitmap;
        if (udVar != null) {
            this.qdl = udVar.qdl;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.lnr.getWidth();
        int height = this.lnr.getHeight();
        this.ud.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                this.ud.left = (width - iWidth) / 2;
                Rect rect2 = this.ud;
                rect2.right = rect2.left + iWidth;
            }
            if (height > iHeight) {
                this.ud.top = (height - iHeight) / 2;
                Rect rect3 = this.ud;
                rect3.bottom = rect3.top + iHeight;
                return;
            }
            return;
        }
        float f = iHeight;
        float f2 = f * 1.0f;
        float f3 = height;
        float f4 = f2 / f3;
        float f5 = iWidth;
        float f6 = 1.0f * f5;
        float f7 = width;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.ud.top = (height - i) / 2;
            Rect rect4 = this.ud;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.ud.left = (width - i2) / 2;
        Rect rect5 = this.ud;
        rect5.right = rect5.left + i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ud
    protected void qdl(Canvas canvas) {
        canvas.drawBitmap(this.lnr, this.ud, getBounds(), this.mml);
    }
}
