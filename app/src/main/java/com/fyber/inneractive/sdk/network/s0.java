package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes3.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1216a;
    public final /* synthetic */ Exception b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ t0 d;

    public s0(t0 t0Var, Object obj, Exception exc, boolean z) {
        this.d = t0Var;
        this.f1216a = obj;
        this.b = exc;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.b.a(this.f1216a, this.b, this.c);
    }
}
