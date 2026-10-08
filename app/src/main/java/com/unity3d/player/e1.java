package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class e1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i1 f3304a;

    e1(i1 i1Var) {
        this.f3304a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3304a.f3315a.onPause();
    }
}
