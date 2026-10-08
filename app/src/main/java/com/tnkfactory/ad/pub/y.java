package com.tnkfactory.ad.pub;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public final class y extends l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3222a;
    public final l4 b;

    public y(Context context, l4 l4Var) {
        this.f3222a = context;
        this.b = l4Var;
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Object obj) {
        l0 w2Var;
        c cVar = (c) obj;
        if (c0.a(cVar.k)) {
            b(cVar);
            return;
        }
        int i = cVar.h;
        boolean z = true;
        if (i == 4) {
            w2Var = new l0(this.f3222a);
            if (cVar.j != null) {
                w2Var.c = true;
                w2Var.d.f3182a.b = new i0(w2Var);
            }
        } else if (i == 5) {
            int i2 = cVar.M;
            if (i2 != 0 && i2 != 1) {
                z = false;
            }
            w2Var = new w2(this.f3222a, z);
        } else {
            w2Var = null;
        }
        if (w2Var == null) {
            b(cVar);
            return;
        }
        cVar.h0 = w2Var;
        if (cVar.i0 >= 3) {
            b(cVar);
        } else {
            w2Var.setPageListener(new x(this, cVar));
            cVar.h0.loadDataWithBaseURL(cVar.q, cVar.k, "text/html", "utf-8", null);
        }
    }

    public final void b(Object obj) {
        l4 l4Var = this.b;
        if (l4Var != null) {
            l4Var.a(obj);
        }
    }

    @Override // com.tnkfactory.ad.pub.l4
    public final void a(Throwable th) {
        l4 l4Var = this.b;
        if (l4Var != null) {
            l4Var.a(th);
        }
    }
}
