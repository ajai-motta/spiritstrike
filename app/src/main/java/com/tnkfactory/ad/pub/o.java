package com.tnkfactory.ad.pub;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes6.dex */
public final class o implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3168a;

    public o(v vVar) {
        this.f3168a = vVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        if (n2.a((View) this.f3168a, true)) {
            this.f3168a.c();
            this.f3168a.d();
        }
    }
}
