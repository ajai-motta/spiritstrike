package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class o1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l2 f3170a;
    public final /* synthetic */ x1 b;

    public o1(x1 x1Var, l2 l2Var) {
        this.b = x1Var;
        this.f3170a = l2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.f3170a.b);
    }
}
