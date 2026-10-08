package com.bytedance.adsdk.ugeno.tvp.ud;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.core.exu;
import com.bytedance.adsdk.ugeno.mml;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class qdl extends FrameLayout {
    private mml qdl;
    private Map<Integer, exu> ud;

    public qdl(Context context) {
        super(context);
    }

    public void setEventMap(Map<Integer, exu> map) {
        this.ud = map;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            super.onMeasure(iArrQdl[0], iArrQdl[1]);
        } else {
            super.onMeasure(i, i2);
        }
        mml mmlVar2 = this.qdl;
        if (mmlVar2 != null) {
            mmlVar2.mzz();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.mo();
        }
        super.onLayout(z, i, i2, i3, i4);
        mml mmlVar2 = this.qdl;
        if (mmlVar2 != null) {
            mmlVar2.qdl(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, exu> map = this.ud;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void qdl(mml mmlVar) {
        this.qdl = mmlVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i4);
        }
    }
}
