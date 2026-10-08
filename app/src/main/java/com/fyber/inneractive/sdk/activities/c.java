package com.fyber.inneractive.sdk.activities;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveFullscreenAdActivity f864a;

    public c(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f864a = inneractiveFullscreenAdActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f864a.isFinishing()) {
            return;
        }
        this.f864a.hideNavigationBar();
    }
}
