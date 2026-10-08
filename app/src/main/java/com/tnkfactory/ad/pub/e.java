package com.tnkfactory.ad.pub;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends b {
    public final c c;

    public e(Context context, c cVar) {
        super(context, cVar.e);
        this.c = cVar;
    }

    public final synchronized void a() {
        c cVar = this.c;
        if (cVar.D) {
            return;
        }
        cVar.D = true;
        String strA = h1.a("d66d03d8e0");
        String strA2 = h1.a("d66a0e95ec428242fe6f76462dea3cbf84");
        c cVar2 = this.c;
        Object[] objArr = {cVar2.c, cVar2.g};
        a0 a0Var = cVar2.p0;
        ArrayList arrayList = cVar2.B;
        s0 s0Var = new s0(this.b, this.f3109a, strA, strA2, objArr, a0Var);
        s0Var.i = arrayList;
        s0Var.start();
    }
}
