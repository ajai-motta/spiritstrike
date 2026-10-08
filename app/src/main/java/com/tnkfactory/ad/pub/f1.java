package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3129a;
    public final /* synthetic */ g1 b;

    public f1(g1 g1Var, int i) {
        this.b = g1Var;
        this.f3129a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            t5 t5VarA = g1.a(this.b.getParent());
            if (t5VarA != null) {
                t5VarA.a();
            }
            g1 g1Var = this.b;
            int i = this.f3129a;
            k2 k2Var = g1Var.c;
            if (k2Var != null) {
                k2Var.a(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
