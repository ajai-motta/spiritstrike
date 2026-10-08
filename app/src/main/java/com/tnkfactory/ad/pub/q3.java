package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class q3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u3 f3181a;

    public q3(u3 u3Var) {
        this.f3181a = u3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3181a.b.computeScrollOffset()) {
            u3 u3Var = this.f3181a;
            u3Var.e.scrollTo(u3Var.b.getCurrX(), this.f3181a.b.getCurrY());
        }
        if (this.f3181a.b.isFinished()) {
            return;
        }
        this.f3181a.post(this);
    }
}
