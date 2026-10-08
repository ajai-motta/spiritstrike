package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class C0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3248a;

    C0(UnityPlayer unityPlayer) {
        this.f3248a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3248a.setupUnityToBePaused();
        this.f3248a.windowFocusChanged(false);
        this.f3248a.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
