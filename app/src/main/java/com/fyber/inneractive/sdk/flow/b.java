package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1035a;

    public b(d dVar) {
        this.f1035a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("%s : ContentLoadTimeoutHandler Executing timeout task", IAlog.a(this.f1035a));
        this.f1035a.b.a();
    }
}
