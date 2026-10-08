package com.fyber.inneractive.sdk.player.ui;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f1526a;

    public k(l lVar) {
        this.f1526a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f1526a;
        int i = lVar.j;
        if (i != 0) {
            int i2 = (lVar.i / i) + lVar.E;
            lVar.E = i2;
            lVar.a(i2);
        }
        l lVar2 = this.f1526a;
        if (lVar2.E < lVar2.F) {
            lVar2.postDelayed(lVar2.D, lVar2.k);
            return;
        }
        lVar2.D = null;
        lVar2.E = 0;
        lVar2.F = 0;
    }
}
