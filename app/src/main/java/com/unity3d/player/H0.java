package com.unity3d.player;

import android.os.SystemClock;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes6.dex */
final class H0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3255a;

    H0(UnityPlayer unityPlayer) {
        this.f3255a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(jUptimeMillis, jUptimeMillis, 0, 4, 1, 0, -1, 0, 0, 257);
        KeyEvent keyEvent2 = new KeyEvent(jUptimeMillis, jUptimeMillis + 1, 1, 4, 1, 0, -1, 0, 0, 257);
        this.f3255a.mActivity.dispatchKeyEvent(keyEvent);
        this.f3255a.mActivity.dispatchKeyEvent(keyEvent2);
    }
}
