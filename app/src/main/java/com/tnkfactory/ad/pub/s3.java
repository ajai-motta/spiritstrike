package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class s3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u3 f3192a;

    public s3(u3 u3Var) {
        this.f3192a = u3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3192a.b.computeScrollOffset()) {
            u3 u3Var = this.f3192a;
            u3Var.f.scrollTo(u3Var.b.getCurrX(), this.f3192a.b.getCurrY());
        }
        if (this.f3192a.b.isFinished()) {
            return;
        }
        this.f3192a.post(this);
    }
}
