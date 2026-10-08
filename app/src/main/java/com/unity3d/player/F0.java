package com.unity3d.player;

import android.view.WindowManager;

/* JADX INFO: loaded from: classes6.dex */
final class F0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f3252a;
    final /* synthetic */ UnityPlayer b;

    F0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.f3252a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.b.m_Window.getAttributes();
        attributes.screenBrightness = this.f3252a;
        this.b.m_Window.setAttributes(attributes);
    }
}
