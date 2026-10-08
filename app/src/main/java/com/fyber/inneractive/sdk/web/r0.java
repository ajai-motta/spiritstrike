package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f1711a;

    public r0(v0 v0Var) {
        this.f1711a = v0Var;
    }

    public final void a(boolean z) {
        if (this.f1711a.u.compareAndSet(false, true)) {
            this.f1711a.d("onCancelResult(" + z + ");");
            this.f1711a.v.set(false);
        }
    }
}
