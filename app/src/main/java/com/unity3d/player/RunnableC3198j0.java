package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class RunnableC3198j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3317a;

    RunnableC3198j0(UnityPlayer unityPlayer) {
        this.f3317a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3317a.nativeLowMemory();
    }
}
