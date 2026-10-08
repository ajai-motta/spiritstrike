package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class N0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3268a;

    N0(UnityPlayer unityPlayer) {
        this.f3268a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3268a.destroy();
    }
}
