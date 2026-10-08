package com.fyber.inneractive.sdk.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1037a;

    public c(d dVar) {
        this.f1037a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.util.r.b.post(this.f1037a.c);
    }
}
