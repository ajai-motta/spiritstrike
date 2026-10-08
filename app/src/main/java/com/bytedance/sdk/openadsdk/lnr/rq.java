package com.bytedance.sdk.openadsdk.lnr;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class rq extends View {
    private final int qdl;

    public rq(Context context) {
        this(context, Color.parseColor("#25000000"));
    }

    public rq(Context context, int i) {
        super(context);
        setBackgroundColor(i);
        this.qdl = ax.ud(getContext(), 0.66f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), this.qdl);
    }
}
