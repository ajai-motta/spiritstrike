package com.tnkfactory.ad.pub;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class a3 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i3 f3105a;

    public a3(i3 i3Var) {
        this.f3105a = i3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i3 i3Var = this.f3105a;
        Context context = view.getContext();
        if (i3Var.e.C != null) {
            new o4(i3Var.e.C).start();
        }
        i3Var.a(context, i3Var.e.j);
    }
}
