package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class a4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3106a;
    public final /* synthetic */ c4 b;

    public a4(c4 c4Var, int i) {
        this.b = c4Var;
        this.f3106a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c4 c4Var = this.b;
        int i = this.f3106a;
        c4Var.setVisibility(8);
        c4Var.postDelayed(new b4(c4Var, i), c4Var.b.getDuration());
        c4Var.startAnimation(c4Var.b);
    }
}
