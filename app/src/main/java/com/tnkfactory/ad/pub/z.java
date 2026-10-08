package com.tnkfactory.ad.pub;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public abstract class z extends b {
    public z(Context context) {
        super(context);
    }

    public final void a(String str, int i, boolean z, l4 l4Var) {
        String strA = h1.a("d66d03d8f9");
        String strA2 = h1.a("c17d15b7ed7d9878e7");
        Object[] objArr = {str, Integer.valueOf(i)};
        w wVar = new w(this);
        y yVar = new y(this.b, l4Var);
        s0 s0Var = new s0(this.b, this.f3109a, strA, strA2, objArr, null);
        s0Var.j = wVar;
        s0Var.h = z;
        s0Var.g = new a(yVar);
        s0Var.start();
    }
}
