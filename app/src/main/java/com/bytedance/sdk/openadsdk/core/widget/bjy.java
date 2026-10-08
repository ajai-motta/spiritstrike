package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes3.dex */
public class bjy extends com.bytedance.sdk.openadsdk.core.mo.jpc {
    private int lnr;
    private Paint qdl;
    private RectF ud;

    public bjy(Context context) {
        this(context, null);
    }

    public bjy(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bjy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lnr = 0;
        qdl();
    }

    private void qdl() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.qdl = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.qdl.setColor(Color.parseColor("#99333333"));
        this.qdl.setAntiAlias(true);
        this.qdl.setStrokeWidth(0.0f);
        this.ud = new RectF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.mo.jpc, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int iMeasureText = (int) getPaint().measureText("00");
            this.lnr = iMeasureText;
            if (measuredWidth < iMeasureText) {
                measuredWidth = iMeasureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.ud.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.ud.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.ud;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.ud.bottom / 2.0f, this.qdl);
        canvas.translate((this.ud.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
