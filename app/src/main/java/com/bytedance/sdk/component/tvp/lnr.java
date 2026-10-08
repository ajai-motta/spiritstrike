package com.bytedance.sdk.component.tvp;

import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public abstract class lnr implements View.OnTouchListener {
    private ViewConfiguration qdl;
    private int ud = -1;

    abstract void qdl(View.OnTouchListener onTouchListener);

    boolean qdl(float f, float f2, float f3, float f4, Context context) {
        if (this.qdl == null) {
            this.qdl = ViewConfiguration.get(context);
        }
        if (this.ud == -1) {
            this.ud = this.qdl.getScaledTouchSlop();
        }
        Integer.valueOf(this.ud);
        if (Math.abs(f - f3) <= this.ud && Math.abs(f2 - f4) <= this.ud) {
            Float.valueOf(f);
            Float.valueOf(f3);
            Float.valueOf(f2);
            Float.valueOf(f4);
            return true;
        }
        Float.valueOf(f);
        Float.valueOf(f3);
        Float.valueOf(f2);
        Float.valueOf(f4);
        return false;
    }
}
