package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f1700a;

    public l0(m0 m0Var) {
        this.f1700a = m0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v0 v0Var = this.f1700a.f1702a;
        if (v0Var.y) {
            return;
        }
        v0Var.e(v0Var.k);
    }
}
