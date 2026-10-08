package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3188e0 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC3186d0 f3303a;

    public C3188e0(Handler handler, InterfaceC3186d0 interfaceC3186d0) {
        super(handler);
        this.f3303a = interfaceC3186d0;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        InterfaceC3186d0 interfaceC3186d0 = this.f3303a;
        if (interfaceC3186d0 != null) {
            ((OrientationLockListener) interfaceC3186d0).b();
        }
    }
}
