package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
class C {
    protected Runnable b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.unity3d.player.a.c f3247a = null;
    protected boolean c = true;

    protected C(Runnable runnable) {
        this.b = runnable;
    }

    protected void registerOnBackPressedCallback() {
        if (this.f3247a != null) {
            return;
        }
        this.f3247a = new B(this.b);
    }

    protected void unregisterOnBackPressedCallback() {
        this.f3247a = null;
    }
}
