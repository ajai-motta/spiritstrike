package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1601a;

    public j(Context context, float f) {
        super(context);
        this.f1601a = f;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        View.MeasureSpec.getMode(i);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == 0 || (mode == Integer.MIN_VALUE && View.MeasureSpec.getSize(i2) > 0)) {
            int size = View.MeasureSpec.getSize(i);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            float f = this.f1601a;
            if (f != 0.0f) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (size * f), 1073741824);
            }
            iMakeMeasureSpec = iMakeMeasureSpec2;
        } else {
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i2);
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }
}
