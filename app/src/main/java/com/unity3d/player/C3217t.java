package com.unity3d.player;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: renamed from: com.unity3d.player.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3217t extends CameraDevice.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3223w f3335a;

    C3217t(C3223w c3223w) {
        this.f3335a = c3223w;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        C3223w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        AbstractC3229z.Log(5, "Camera2: CameraDevice disconnected.");
        this.f3335a.a(cameraDevice);
        C3223w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        AbstractC3229z.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.f3335a.a(cameraDevice);
        C3223w.D.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        this.f3335a.b = cameraDevice;
        C3223w.D.release();
    }
}
