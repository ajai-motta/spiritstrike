package com.fyber.inneractive.sdk.player.mediaplayer;

import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Surface f1507a;
    public final /* synthetic */ p b;

    public f(p pVar, Surface surface) {
        this.b = pVar;
        this.f1507a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.b, this.f1507a);
    }
}
