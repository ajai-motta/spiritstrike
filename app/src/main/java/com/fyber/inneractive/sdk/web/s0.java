package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f1714a;

    public s0(v0 v0Var) {
        this.f1714a = v0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1714a.u.compareAndSet(false, true)) {
            this.f1714a.d("onCancelResult(true);");
            this.f1714a.v.set(false);
        }
    }
}
