package com.google.androidgamesdk;

import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes5.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1815a;
    final /* synthetic */ SwappyDisplayManager b;

    c(SwappyDisplayManager swappyDisplayManager, int i) {
        this.b = swappyDisplayManager;
        this.f1815a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Window window = this.b.mActivity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.preferredDisplayModeId = this.f1815a;
        window.setAttributes(attributes);
    }
}
