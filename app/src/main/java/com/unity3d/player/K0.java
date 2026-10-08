package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class K0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3262a;

    K0(UnityPlayer unityPlayer) {
        this.f3262a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3262a.nativeSendSurfaceChangedEvent();
    }
}
