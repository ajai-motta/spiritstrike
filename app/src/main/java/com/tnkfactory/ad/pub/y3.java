package com.tnkfactory.ad.pub;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes6.dex */
public final class y3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3225a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ c4 c;

    public y3(c4 c4Var, int i, boolean z) {
        this.c = c4Var;
        this.f3225a = i;
        this.b = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        c4 c4Var = this.c;
        c4Var.f = false;
        c4Var.a(this.f3225a, this.b);
    }
}
