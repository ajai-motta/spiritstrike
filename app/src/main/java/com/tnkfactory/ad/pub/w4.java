package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class w4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i5 f3215a;

    public w4(i5 i5Var) {
        this.f3215a = i5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i5 i5Var = this.f3215a;
        if (!i5Var.o || i5Var.b.getPlayTimeLeft() <= 0) {
            return;
        }
        this.f3215a.setPanelVisible(false);
    }
}
