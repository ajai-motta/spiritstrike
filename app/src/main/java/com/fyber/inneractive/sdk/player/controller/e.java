package com.fyber.inneractive.sdk.player.controller;

import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1241a;

    public e(f fVar) {
        this.f1241a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.f1241a.s;
        if (gVar != null) {
            gVar.a(gVar.a(), C.TIME_UNSET);
            this.f1241a.s.d.f.sendEmptyMessage(5);
            com.fyber.inneractive.sdk.player.exoplayer2.g gVar2 = this.f1241a.s;
            gVar2.d.d();
            gVar2.c.removeCallbacksAndMessages(null);
            this.f1241a.s = null;
        }
    }
}
