package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class b3 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f3111a;

    public b3(i3 i3Var) {
        this.f3111a = i3Var;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (n2.a(view, false)) {
            this.f3111a.m();
        }
    }
}
