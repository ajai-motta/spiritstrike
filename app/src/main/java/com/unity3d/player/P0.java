package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes6.dex */
final class P0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Semaphore f3274a;
    final /* synthetic */ UnityPlayer b;

    P0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.b = unityPlayer;
        this.f3274a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.nativePause()) {
            UnityPlayer unityPlayer = this.b;
            unityPlayer.mQuitting = true;
            unityPlayer.shutdown();
            this.b.queueDestroy();
        }
        this.f3274a.release();
    }
}
