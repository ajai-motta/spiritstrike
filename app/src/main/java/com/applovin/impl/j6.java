package com.applovin.impl;

import com.applovin.impl.e6;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class j6 extends j5 {
    private final WeakReference g;
    private final Object h;

    protected j6(t4 t4Var, Object obj, String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
        this.g = new WeakReference(t4Var);
        this.h = obj;
    }

    public static void a(long j, t4 t4Var, Object obj, String str, com.applovin.impl.sdk.k kVar) {
        if (j <= 0) {
            return;
        }
        kVar.r0().a(new j6(t4Var, obj, str, kVar), e6.b.TIMEOUT, j);
    }

    @Override // java.lang.Runnable
    public void run() {
        t4 t4Var = (t4) this.g.get();
        if (t4Var == null || t4Var.c()) {
            return;
        }
        this.f428a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f428a.O().d(this.b, "Attempting to timeout pending task " + t4Var.b() + " with " + this.h);
        }
        t4Var.a(this.h);
    }
}
