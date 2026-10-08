package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.u1;
import com.fyber.inneractive.sdk.util.v1;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f1090a;

    public o0(p0 p0Var) {
        this.f1090a = p0Var;
    }

    @Override // com.fyber.inneractive.sdk.util.u1
    public final void a() {
        Runnable runnable = this.f1090a.n;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.post(runnable);
        }
        p0 p0Var = this.f1090a;
        v1 v1Var = p0Var.o;
        if (v1Var != null) {
            v1Var.e = null;
            p0Var.o = null;
        }
    }
}
