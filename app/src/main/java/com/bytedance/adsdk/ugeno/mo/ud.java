package com.bytedance.adsdk.ugeno.mo;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ud extends qdl<com.bytedance.adsdk.ugeno.ud.lnr> {
    private com.bytedance.adsdk.ugeno.mml mml;

    public ud(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.mo.qdl
    public View to(int i) {
        return ((com.bytedance.adsdk.ugeno.ud.lnr) this.qdl.get(i)).rq();
    }

    public void qdl(com.bytedance.adsdk.ugeno.mml mmlVar) {
        this.mml = mmlVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.mml mmlVar = this.mml;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            super.onMeasure(iArrQdl[0], iArrQdl[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.mml mmlVar2 = this.mml;
        if (mmlVar2 != null) {
            mmlVar2.mzz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.mo();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.mml mmlVar2 = this.mml;
        if (mmlVar2 != null) {
            mmlVar2.qdl(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.mml mmlVar = this.mml;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
