package com.fyber.inneractive.sdk.web;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1706a;

    public p(i0 i0Var) {
        this.f1706a = i0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        m mVar = this.f1706a.b;
        if (mVar == null) {
            return false;
        }
        mVar.getViewTreeObserver().removeOnPreDrawListener(this);
        i0 i0Var = this.f1706a;
        i0Var.a(i0Var.b.getContext(), true);
        return false;
    }
}
