package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3174a;

    public p(v vVar) {
        this.f3174a = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v vVar = this.f3174a;
        if (vVar.d.M != 4) {
            vVar.requestFocus();
        }
        this.f3174a.b();
    }
}
