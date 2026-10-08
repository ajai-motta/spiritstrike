package com.unity3d.player;

import android.window.OnBackInvokedCallback;

/* JADX INFO: renamed from: com.unity3d.player.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3185d implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unity3d.player.a.c f3301a;

    C3185d(com.unity3d.player.a.c cVar) {
        this.f3301a = cVar;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = ((B) this.f3301a).f3245a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
