package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class RunnableC3200k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3319a;

    RunnableC3200k0(UnityPlayer unityPlayer) {
        this.f3319a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3319a.nativeResume();
    }
}
