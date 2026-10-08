package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.u1;
import com.fyber.inneractive.sdk.util.v1;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f1071a;

    public n0(p0 p0Var) {
        this.f1071a = p0Var;
    }

    @Override // com.fyber.inneractive.sdk.util.u1
    public final void a() {
        com.fyber.inneractive.sdk.util.r.b.post(this.f1071a.l);
        p0 p0Var = this.f1071a;
        v1 v1Var = p0Var.m;
        if (v1Var != null) {
            v1Var.e = null;
            p0Var.m = null;
        }
        p0Var.q = false;
    }
}
