package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class Camera2Wrapper implements com.unity3d.player.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3249a;
    private C3223w b = null;

    public Camera2Wrapper(Context context) {
        this.f3249a = context;
        initCamera2Jni();
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    public final void a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    public final void a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    public final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    protected void closeCamera2() {
        C3223w c3223w = this.b;
        if (c3223w != null) {
            c3223w.a();
        }
        this.b = null;
    }

    protected int getCamera2Count() {
        return C3223w.a(this.f3249a);
    }

    protected int getCamera2FocalLengthEquivalent(int i) {
        return C3223w.a(this.f3249a, i);
    }

    protected int[] getCamera2Resolutions(int i) {
        return C3223w.b(this.f3249a, i);
    }

    protected int getCamera2SensorOrientation(int i) {
        return C3223w.c(this.f3249a, i);
    }

    protected Rect getFrameSizeCamera2() {
        C3223w c3223w = this.b;
        return c3223w != null ? c3223w.c() : new Rect();
    }

    protected boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        if (this.b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C3223w c3223w = new C3223w(this);
        this.b = c3223w;
        return c3223w.a(this.f3249a, i, i2, i3, i4, i5, surface);
    }

    protected boolean isCamera2AutoFocusPointSupported(int i) {
        return C3223w.d(this.f3249a, i);
    }

    protected boolean isCamera2FrontFacing(int i) {
        return C3223w.e(this.f3249a, i);
    }

    protected void pauseCamera2() {
        C3223w c3223w = this.b;
        if (c3223w != null) {
            c3223w.d();
        }
    }

    protected boolean setAutoFocusPoint(float f, float f2) {
        C3223w c3223w = this.b;
        if (c3223w != null) {
            return c3223w.a(f, f2);
        }
        return false;
    }

    protected void startCamera2() {
        C3223w c3223w = this.b;
        if (c3223w != null) {
            c3223w.h();
        }
    }

    protected void stopCamera2() {
        C3223w c3223w = this.b;
        if (c3223w != null) {
            c3223w.i();
        }
    }
}
