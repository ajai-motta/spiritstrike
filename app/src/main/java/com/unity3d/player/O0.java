package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes6.dex */
final class O0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Semaphore f3271a;
    final /* synthetic */ UnityPlayer b;

    O0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.b = unityPlayer;
        this.f3271a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.shutdown();
        this.f3271a.release();
    }
}
