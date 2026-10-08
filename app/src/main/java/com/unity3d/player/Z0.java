package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
public final class Z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a1 f3292a;
    private boolean b = false;

    public Z0(a1 a1Var) {
        this.f3292a = a1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.b) {
            return;
        }
        int i = a1.A;
        this.f3292a.cancelOnPrepare();
    }
}
