package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t0 f1202a;
    public final /* synthetic */ l0 b;

    public j0(l0 l0Var, t0 t0Var) {
        this.b = l0Var;
        this.f1202a = t0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.e("retryNetworkRequest pre-execute - %s", this.f1202a.getClass().getName());
        this.b.a(this.f1202a);
    }
}
