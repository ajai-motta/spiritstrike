package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class b4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3112a;
    public final /* synthetic */ c4 b;

    public b4(c4 c4Var, int i) {
        this.b = c4Var;
        this.f3112a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t5 t5VarA = c4.a(this.b.getParent());
        if (t5VarA != null) {
            t5VarA.a();
        }
        c4 c4Var = this.b;
        int i = this.f3112a;
        k2 k2Var = c4Var.c;
        if (k2Var != null) {
            k2Var.a(i);
        }
    }
}
