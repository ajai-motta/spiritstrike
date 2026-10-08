package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class J0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3260a;

    J0(UnityPlayer unityPlayer) {
        this.f3260a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer = this.f3260a;
        unityPlayer.removeView(unityPlayer.m_SplashScreen);
        this.f3260a.m_SplashScreen = null;
    }
}
