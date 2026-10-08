package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: renamed from: com.unity3d.player.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3190f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3306a;
    private C3188e0 b;

    public C3190f0(Context context) {
        this.f3306a = context;
    }

    public final void a() {
        if (this.b != null) {
            this.f3306a.getContentResolver().unregisterContentObserver(this.b);
            this.b = null;
        }
    }

    public final void a(InterfaceC3186d0 interfaceC3186d0) {
        this.b = new C3188e0(new Handler(Looper.getMainLooper()), interfaceC3186d0);
        this.f3306a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.b);
    }
}
