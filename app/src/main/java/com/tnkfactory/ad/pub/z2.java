package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class z2 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f3230a;

    public z2(i3 i3Var) {
        this.f3230a = i3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c0.a(view.getContext(), this.f3230a.e.z, false);
    }
}
