package com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class jpc implements View.OnTouchListener {
    private final int lnr = 10;
    private float mml;
    private float mo;
    private float mzz;
    private final com.bytedance.sdk.component.adexpress.dynamic.lnr.jpc qdl;
    private final boolean ud;
    private float wd;

    public jpc(com.bytedance.sdk.component.adexpress.dynamic.lnr.jpc jpcVar, boolean z) {
        this.qdl = jpcVar;
        this.ud = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.lnr.jpc jpcVar;
        com.bytedance.sdk.component.adexpress.dynamic.lnr.jpc jpcVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mml = motionEvent.getX();
            this.mzz = motionEvent.getY();
            Float.valueOf(this.mml);
            new StringBuilder(", mStartY: ").append(this.mzz);
        } else if (action == 1) {
            this.mo = motionEvent.getX();
            this.wd = motionEvent.getY();
            Float.valueOf(this.mo);
            new StringBuilder(", mEndY: ").append(this.wd);
            if (!this.ud && (jpcVar2 = this.qdl) != null) {
                jpcVar2.qdl();
            } else {
                float f = this.mo - this.mml;
                float f2 = this.wd - this.mzz;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                Float.valueOf(fSqrt);
                float fUd = com.bytedance.sdk.component.adexpress.mml.wd.ud(com.bytedance.sdk.component.adexpress.mml.qdl(), Math.abs(fSqrt));
                Float.valueOf(fUd);
                Integer.valueOf(10);
                if (fUd > 10.0f && (jpcVar = this.qdl) != null) {
                    jpcVar.qdl();
                }
            }
        }
        return true;
    }
}
