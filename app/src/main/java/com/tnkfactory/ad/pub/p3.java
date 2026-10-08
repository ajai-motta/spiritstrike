package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class p3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u3 f3176a;

    public p3(u3 u3Var) {
        this.f3176a = u3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3176a.getPageCount() == 0) {
            this.f3176a.k = 0;
        } else {
            u3 u3Var = this.f3176a;
            u3Var.k = (u3Var.k + 1) % u3Var.getPageCount();
        }
        u3 u3Var2 = this.f3176a;
        u3Var2.a(u3Var2.k);
        u3 u3Var3 = this.f3176a;
        o3 o3Var = u3Var3.h;
        if (o3Var != null) {
            o3Var.g = u3Var3.k;
            o3Var.invalidate();
        }
        u3 u3Var4 = this.f3176a;
        u3Var4.postDelayed(this, u3Var4.p);
    }
}
