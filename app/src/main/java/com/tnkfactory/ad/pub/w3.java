package com.tnkfactory.ad.pub;

import android.view.View;
import com.tnkfactory.ad.AdListener;

/* JADX INFO: loaded from: classes6.dex */
public final class w3 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c4 f3214a;

    public w3(c4 c4Var) {
        this.f3214a = c4Var;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3 - i < i4 - i2 ? 1 : 0;
        c4 c4Var = this.f3214a;
        if (c4Var.d.M != i9) {
            c4Var.f = false;
            c4Var.a(AdListener.CLOSE_SIMPLE, false);
        }
    }
}
