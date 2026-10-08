package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes6.dex */
final class D extends C {
    private OnBackInvokedCallback d;
    private OnBackInvokedDispatcher e;
    private int f;

    private D(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, Runnable runnable) {
        super(runnable);
        this.d = null;
        this.f = i;
        this.e = onBackInvokedDispatcher;
    }

    public static C a(Object obj, int i, Runnable runnable) {
        C d = (PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog))) ? new D(AbstractC3187e.a(obj), i, runnable) : new C(runnable);
        d.registerOnBackPressedCallback();
        return d;
    }

    @Override // com.unity3d.player.C
    protected void registerOnBackPressedCallback() {
        if (this.f3247a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C3185d c3185d = new C3185d(this.f3247a);
            this.d = c3185d;
            AbstractC3187e.a(this.e, this.f, c3185d);
        }
    }

    @Override // com.unity3d.player.C
    protected void unregisterOnBackPressedCallback() {
        if (this.f3247a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC3187e.a(this.e, this.d);
                this.d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}
