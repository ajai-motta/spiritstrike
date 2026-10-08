package com.fyber.inneractive.sdk.bidder;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f887a;

    public c(d dVar) {
        this.f887a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f887a.b = com.fyber.inneractive.sdk.util.o.h();
    }
}
