package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class v5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a6 f3210a;

    public v5(a6 a6Var) {
        this.f3210a = a6Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a6 a6Var = this.f3210a;
        if (a6Var.k) {
            a6Var.k = false;
            a6Var.f3108a.post(new w5(a6Var, h1.a("d3762c83fd54d922")));
        } else {
            a6Var.k = true;
            a6Var.f3108a.post(new w5(a6Var, h1.a("cb6d1593a118")));
        }
    }
}
