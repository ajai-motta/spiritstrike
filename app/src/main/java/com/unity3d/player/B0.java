package com.unity3d.player;

import android.app.Activity;

/* JADX INFO: loaded from: classes6.dex */
final class B0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnityPlayer f3246a;

    B0(UnityPlayer unityPlayer) {
        this.f3246a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        Activity activity;
        if (!this.f3246a.nativeIsAutorotationOn() || (activity = (unityPlayer = this.f3246a).mActivity) == null) {
            return;
        }
        activity.setRequestedOrientation(unityPlayer.mInitialScreenOrientation);
    }
}
