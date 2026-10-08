package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1511a;
    public final /* synthetic */ p b;

    public j(p pVar, int i) {
        this.b = pVar;
        this.f1511a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.b;
        int i = this.f1511a;
        String strB = pVar.b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        pVar.seekTo(i);
        IAlog.e(strB + "timelog: seekTo took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " msec", new Object[0]);
    }
}
