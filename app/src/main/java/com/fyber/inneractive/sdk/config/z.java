package com.fyber.inneractive.sdk.config;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f988a;

    public z(a0 a0Var) {
        this.f988a = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f988a.f926a.K = new com.fyber.inneractive.sdk.measurement.e();
        a0 a0Var = this.f988a;
        com.fyber.inneractive.sdk.measurement.e eVar = a0Var.f926a.K;
        Context context = a0Var.b;
        if (eVar.f1146a) {
            return;
        }
        eVar.f1146a = true;
        com.fyber.inneractive.sdk.util.r.b.post(new com.fyber.inneractive.sdk.measurement.d(eVar, context));
    }
}
