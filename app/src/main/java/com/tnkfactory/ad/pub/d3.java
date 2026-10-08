package com.tnkfactory.ad.pub;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes6.dex */
public final class d3 implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3121a;
    public final /* synthetic */ i3 b;

    public d3(i3 i3Var, View view) {
        this.b = i3Var;
        this.f3121a = view;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        if (n2.a(this.f3121a, true)) {
            this.b.b(this.f3121a);
            this.b.m();
        }
    }
}
