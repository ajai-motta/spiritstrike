package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f1703a;

    public n0(v0 v0Var) {
        this.f1703a = v0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v0 v0Var = this.f1703a;
        v0Var.f1719a.stopLoading();
        IAlog.a("%sonLoadTimeout after %d msec", IAlog.a(v0Var), Long.valueOf(v0Var.n));
        com.fyber.inneractive.sdk.flow.v vVar = v0Var.h;
        if (vVar == null || v0Var.d == null) {
            return;
        }
        vVar.a(com.fyber.inneractive.sdk.network.t.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, v0Var.k, com.fyber.inneractive.sdk.ignite.j.LOAD_WEBPAGE_TIMEOUT.a(), v0Var.d);
    }
}
