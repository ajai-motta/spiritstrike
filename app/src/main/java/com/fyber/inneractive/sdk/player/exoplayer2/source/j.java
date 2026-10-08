package com.fyber.inneractive.sdk.player.exoplayer2.source;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1416a;

    public j(p pVar) {
        this.f1416a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.f1416a;
        if (pVar.G) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) pVar.p;
        lVar.getClass();
        lVar.f.obtainMessage(9, pVar).sendToTarget();
    }
}
