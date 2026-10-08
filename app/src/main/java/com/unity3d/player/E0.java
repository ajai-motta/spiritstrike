package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class E0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f3251a;
    final /* synthetic */ UnityPlayer b;

    E0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.f3251a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.mGlView.a(this.f3251a);
    }
}
