package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f1683a;

    public a1(b1 b1Var) {
        this.f1683a = b1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1683a.f1684a.evictAll();
        } catch (Throwable unused) {
        }
    }
}
