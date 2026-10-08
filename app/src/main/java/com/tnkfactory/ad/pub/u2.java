package com.tnkfactory.ad.pub;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes6.dex */
public final class u2 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w2 f3202a;

    public u2(w2 w2Var) {
        this.f3202a = w2Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (n2.a((View) this.f3202a, false)) {
            w2 w2Var = this.f3202a;
            w2Var.i = true;
            w2Var.a();
        }
    }
}
