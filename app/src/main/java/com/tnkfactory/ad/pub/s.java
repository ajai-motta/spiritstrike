package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3189a;
    public final /* synthetic */ v b;

    public s(v vVar, int i) {
        this.b = vVar;
        this.f3189a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v vVar = this.b;
        int i = this.f3189a;
        c cVar = vVar.d;
        c0.a(vVar.getContext(), c0.a(cVar.d, cVar.j, cVar.g, i, vVar.i), true);
        if (vVar.d.C != null) {
            new o4(vVar.d.C).start();
        }
        k2 k2Var = vVar.c;
        if (k2Var != null) {
            k2Var.a();
        }
    }
}
