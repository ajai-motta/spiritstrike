package com.tnkfactory.ad.pub;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.tnkfactory.ad.AdError;
import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.FeedAdView;

/* JADX INFO: loaded from: classes6.dex */
public final class d2 extends c1 {
    public final FeedAdView f;
    public final int g;
    public final int h;
    public final int i;
    public float j;
    public float k;

    public d2(AdItem adItem, String str) {
        super(str);
        FeedAdView feedAdView = (FeedAdView) adItem;
        this.f = feedAdView;
        m2 m2VarB = n2.b(feedAdView.getContext());
        int i = m2VarB.f3159a;
        this.h = i;
        this.i = m2VarB.b;
        float f = i;
        this.j = f;
        this.k = f / 3.2f;
        this.g = (int) TypedValue.applyDimension(1, 90.0f, feedAdView.getResources().getDisplayMetrics());
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final void a(Context context, boolean z) {
        if (!e()) {
            a(this.f, AdError.FAIL_NO_PLACEMENT_ID);
        } else if (this.d != 0) {
            a(this.f, AdError.FAIL_DUP_LOAD);
        } else {
            this.d = 1;
            new a2(context).a(this.f3115a, 5, z, new b2(this));
        }
    }

    @Override // com.tnkfactory.ad.pub.c1
    public final int[] a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE && mode == 0) {
            this.j = this.h;
        } else {
            this.j = size;
        }
        float f = this.j;
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
            this.k = this.i;
        } else {
            this.k = size2;
        }
        float f2 = this.k;
        float f3 = this.j;
        if (f3 / f2 > 3.2f) {
            this.j = 3.2f * f2;
        } else {
            float f4 = f3 / 3.2f;
            this.k = f4;
            if (mode2 != 1073741824) {
                f2 = f4;
            }
        }
        return new int[]{(int) f, (int) f2};
    }
}
