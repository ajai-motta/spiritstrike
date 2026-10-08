package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class V implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ X f3285a;

    V(X x) {
        this.f3285a = x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3285a.c.requestFocus();
        this.f3285a.f();
    }
}
