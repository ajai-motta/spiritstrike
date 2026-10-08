package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes6.dex */
public class OrientationLockListener implements InterfaceC3186d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3190f0 f3272a;
    private Context b;

    OrientationLockListener(Context context) {
        this.b = context;
        this.f3272a = new C3190f0(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        this.f3272a.a(this);
    }

    public final void a() {
        this.f3272a.a();
        this.f3272a = null;
    }

    public final void b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int i);
}
