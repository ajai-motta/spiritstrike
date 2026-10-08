package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i1 f3307a;

    f1(i1 i1Var) {
        this.f3307a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i1 i1Var = this.f3307a;
        a1 a1Var = i1Var.f;
        if (a1Var != null) {
            i1Var.f3315a.addViewToPlayer(a1Var, true);
            i1 i1Var2 = this.f3307a;
            i1Var2.i = true;
            i1Var2.f.requestFocus();
        }
    }
}
