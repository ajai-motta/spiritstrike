package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f3281a;

    T(U u) {
        this.f3281a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S s = this.f3281a.d;
        s.a(s.b(), true);
    }
}
