package com.fyber.inneractive.sdk.player.exoplayer2.source;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f1417a;
    public final /* synthetic */ p b;

    public k(p pVar, n nVar) {
        this.b = pVar;
        this.f1417a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.f1417a;
        if (nVar.c != null) {
            nVar.c = null;
        }
        int size = this.b.o.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.b.o.valueAt(i)).b();
        }
    }
}
