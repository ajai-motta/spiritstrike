package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class e3 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f3125a;

    public e3(i3 i3Var) {
        this.f3125a = i3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c0.a(view.getContext(), this.f3125a.e.z, false);
    }
}
