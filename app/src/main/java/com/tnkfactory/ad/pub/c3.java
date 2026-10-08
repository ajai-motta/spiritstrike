package com.tnkfactory.ad.pub;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes6.dex */
public final class c3 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3117a;
    public final /* synthetic */ i3 b;

    public c3(i3 i3Var, View view) {
        this.b = i3Var;
        this.f3117a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (n2.a(this.f3117a, true)) {
            this.b.b(this.f3117a);
            this.b.m();
        }
    }
}
