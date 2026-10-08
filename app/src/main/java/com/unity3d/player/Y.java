package com.unity3d.player;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes6.dex */
final class Y implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C3184c0 f3290a;

    Y(C3184c0 c3184c0) {
        this.f3290a = c3184c0;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f3290a.invokeOnClose();
    }
}
