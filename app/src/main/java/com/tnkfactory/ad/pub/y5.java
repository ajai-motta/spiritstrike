package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class y5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z5 f3227a;

    public y5(z5 z5Var) {
        this.f3227a = z5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a6 a6Var = this.f3227a.f3233a;
        a6Var.getClass();
        a6Var.f3108a.post(new w5(a6Var, h1.a("d674008fdf58956efc372d")));
    }
}
