package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public class rdp extends com.bytedance.sdk.openadsdk.core.mo.mml {
    private Paint qdl;
    private RectF ud;

    public rdp(Context context) {
        super(context);
        qdl();
    }

    private void qdl() {
        Paint paint = new Paint();
        this.qdl = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.qdl.setColor(Color.parseColor("#99333333"));
        this.qdl.setAntiAlias(true);
        this.qdl.setStrokeWidth(0.0f);
        this.ud = new RectF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.mo.mml, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ud.right == getMeasuredWidth() && this.ud.bottom == getMeasuredHeight()) {
            return;
        }
        this.ud.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.ud;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.ud.bottom / 2.0f, this.qdl);
        super.onDraw(canvas);
    }
}
