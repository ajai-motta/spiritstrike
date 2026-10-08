package com.tnkfactory.ad.pub;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes6.dex */
public final class n implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3163a;

    public n(v vVar) {
        this.f3163a = vVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (n2.a((View) this.f3163a, true)) {
            this.f3163a.c();
            this.f3163a.d();
        }
    }
}
