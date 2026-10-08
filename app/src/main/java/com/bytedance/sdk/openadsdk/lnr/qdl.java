package com.bytedance.sdk.openadsdk.lnr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends com.bytedance.sdk.openadsdk.core.mo.jpc {
    private boolean lnr;
    private int mml;
    private Paint qdl;
    private float ud;

    public qdl(Context context) {
        super(context);
        qdl();
    }

    private void qdl() {
        this.ud = ax.qdl(getContext(), 8.0f);
        this.qdl = new Paint();
    }

    public void setMinTextSize(float f) {
        if (f <= 0.0f) {
            return;
        }
        this.ud = f;
    }

    private void qdl(String str, int i) {
        if (!this.lnr && i > 0) {
            float textSize = getTextSize();
            this.qdl.set(getPaint());
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            float fQdl = qdl(textSize, str);
            while (fQdl > paddingLeft) {
                textSize -= 1.0f;
                this.qdl.setTextSize(textSize);
                if (textSize <= this.ud) {
                    break;
                } else {
                    fQdl = qdl(textSize, str);
                }
            }
            setTextSize(0, textSize);
            this.lnr = true;
        }
    }

    private float qdl(float f, String str) {
        this.qdl.setTextSize(f);
        return this.qdl.measureText(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.mo.jpc, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mml = getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, this.mml);
        } else {
            layoutParams.height = this.mml;
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.mo.jpc, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        int i = this.mml;
        if (i == 0 || layoutParams == null) {
            return;
        }
        layoutParams.height = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        qdl(getText().toString(), getWidth());
    }
}
