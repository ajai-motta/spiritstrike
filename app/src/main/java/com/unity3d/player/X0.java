package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class X0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a1 f3289a;

    X0(a1 a1Var) {
        this.f3289a = a1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3289a.destroyPlayer();
        this.f3289a.a(3);
    }
}
