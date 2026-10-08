package com.bytedance.adsdk.ugeno.tvp.mo;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.mml;
import com.bytedance.adsdk.ugeno.qdl.jpc;
import com.bytedance.adsdk.ugeno.qdl.wd;

/* JADX INFO: loaded from: classes2.dex */
public class qdl extends TextView implements IAnimation, wd {
    private jpc lnr;
    private float mml;
    private float mo;
    private float mzz;
    private mml qdl;
    private float ud;
    private float wd;

    public qdl(Context context) {
        super(context);
        this.mml = -1.0f;
        this.mo = 1.0f;
        this.wd = 0.0f;
        this.lnr = new jpc(this);
    }

    public void qdl(mml mmlVar) {
        this.qdl = mmlVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            super.onMeasure(iArrQdl[0], iArrQdl[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.qdl(i, i2, i3, i4);
        }
        if (z && this.mml > 0.0f) {
            qdl(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.qdl.wd
    public float getRipple() {
        return this.ud;
    }

    public void setShine(float f) {
        jpc jpcVar = this.lnr;
        if (jpcVar != null) {
            jpcVar.lnr(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getShine() {
        return this.lnr.getShine();
    }

    public void setStretch(float f) {
        jpc jpcVar = this.lnr;
        if (jpcVar != null) {
            jpcVar.mml(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getStretch() {
        return this.lnr.getStretch();
    }

    public void setRubIn(float f) {
        jpc jpcVar = this.lnr;
        if (jpcVar != null) {
            jpcVar.mzz(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getRubIn() {
        return this.lnr.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.ud = f;
        jpc jpcVar = this.lnr;
        if (jpcVar != null) {
            jpcVar.ud(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.qdl(canvas, this);
            this.qdl.qdl(canvas);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.ud(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setBorderRadius(float f) {
        jpc jpcVar = this.lnr;
        if (jpcVar != null) {
            jpcVar.qdl(f);
        }
    }

    public float getBorderRadius() {
        return this.lnr.qdl();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.lnr.qdl(i);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.mzz = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.mzz = getTextSize();
    }

    public void setMinTextSize(float f) {
        this.mml = f;
    }

    private void qdl(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.mzz == 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        float fMax = this.mzz;
        int iQdl = qdl(text, paint, i, fMax);
        while (iQdl > i2 && fMax > this.mml) {
            Log.d("UGTextView", "resizeText: targetSize=" + fMax + "; mMinTextSize=" + this.mml);
            fMax = Math.max(fMax - 1.0f, this.mml);
            iQdl = qdl(text, paint, i, fMax);
        }
        Log.d("UGTextView", "resizeText: targetSize: ".concat(String.valueOf(fMax)));
        setTextSize(0, fMax);
        setLineSpacing(this.wd, this.mo);
    }

    private int qdl(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.mo, this.wd, true).getHeight();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.mo = f2;
        this.wd = f;
    }
}
