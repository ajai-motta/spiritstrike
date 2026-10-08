package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class DialogInterfaceOnCancelListenerC3180a0 implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3184c0 f3295a;

    DialogInterfaceOnCancelListenerC3180a0(C3184c0 c3184c0) {
        this.f3295a = c3184c0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        F f = this.f3295a.f;
        if (f != null) {
            ((C3202l0) f).a();
        }
    }
}
