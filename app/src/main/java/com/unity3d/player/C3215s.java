package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;

/* JADX INFO: renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3215s extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3223w f3333a;

    C3215s(C3223w c3223w) {
        this.f3333a = c3223w;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC3229z.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        String str;
        C3223w c3223w = this.f3333a;
        if (c3223w.b == null) {
            return;
        }
        synchronized (c3223w.s) {
            C3223w c3223w2 = this.f3333a;
            c3223w2.r = cameraCaptureSession;
            try {
                c3223w2.q = c3223w2.b.createCaptureRequest(1);
                C3223w c3223w3 = this.f3333a;
                c3223w3.q.addTarget(c3223w3.v);
                C3223w c3223w4 = this.f3333a;
                c3223w4.q.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, c3223w4.n);
                this.f3333a.g();
            } catch (CameraAccessException e) {
                str = "Camera2: CameraAccessException " + e;
                AbstractC3229z.Log(6, str);
            } catch (IllegalStateException e2) {
                str = "Camera2: IllegalStateException " + e2;
                AbstractC3229z.Log(6, str);
            }
        }
    }
}
