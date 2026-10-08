package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class RunnableC3206n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3325a;

    RunnableC3206n0(UnityPlayer unityPlayer) {
        this.f3325a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3196i0 c3196i0 = this.f3325a.mGlView;
        if (c3196i0 != null) {
            c3196i0.b();
        }
    }
}
