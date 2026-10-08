package com.unity3d.player;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes6.dex */
final class Z implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3184c0 f3291a;

    Z(C3184c0 c3184c0) {
        this.f3291a = c3184c0;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f3291a.reportSoftInputArea();
        this.f3291a.h.b();
    }
}
