package com.unity3d.player;

import android.view.SurfaceHolder;

/* JADX INFO: renamed from: com.unity3d.player.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class SurfaceHolderCallbackC3194h0 implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3196i0 f3312a;

    SurfaceHolderCallbackC3194h0(C3196i0 c3196i0) {
        this.f3312a = c3196i0;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f3312a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.f3312a.b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f3312a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        C3196i0 c3196i0 = this.f3312a;
        K k = c3196i0.c;
        UnityPlayer unityPlayer = c3196i0.b;
        J j = k.b;
        if (j == null || j.getParent() != null) {
            return;
        }
        unityPlayer.addView(k.b);
        unityPlayer.bringChildToFront(k.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C3196i0 c3196i0 = this.f3312a;
        K k = c3196i0.c;
        C3189f c3189f = c3196i0.f3314a;
        k.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && k.f3261a != null) {
            if (k.b == null) {
                k.b = new J(k.f3261a);
            }
            k.b.a(c3189f);
        }
        this.f3312a.b.updateGLDisplay(0, null);
    }
}
