package com.fyber.inneractive.sdk.player.cache;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1226a;

    public a(g gVar) {
        this.f1226a = gVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f1226a) {
            g gVar = this.f1226a;
            if (gVar.i == null) {
                return null;
            }
            gVar.d();
            g gVar2 = this.f1226a;
            int i = gVar2.k;
            if (i >= 2000 && i >= gVar2.j.size()) {
                this.f1226a.c();
                this.f1226a.k = 0;
            }
            return null;
        }
    }
}
