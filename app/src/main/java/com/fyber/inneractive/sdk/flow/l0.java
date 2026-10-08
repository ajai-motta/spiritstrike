package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.v1;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1069a;
    public final /* synthetic */ p0 b;

    public l0(p0 p0Var, long j) {
        this.b = p0Var;
        this.f1069a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.K()) {
            p0 p0Var = this.b;
            p0Var.n = new k0(this);
            long jA = p0Var.a(this.f1069a);
            p0 p0Var2 = this.b;
            p0Var2.getClass();
            v1 v1Var = new v1(TimeUnit.MILLISECONDS, jA);
            p0Var2.o = v1Var;
            v1Var.e = new o0(p0Var2);
            t1 t1Var = new t1(v1Var);
            v1Var.c = t1Var;
            v1Var.d = false;
            t1Var.sendEmptyMessage(1932593528);
            p0 p0Var3 = this.b;
            p0Var3.getClass();
            IAlog.a("%sad contains custom close. Will show transparent x in %d", IAlog.a(p0Var3), Long.valueOf(jA));
            this.b.l = null;
        } else {
            p0 p0Var4 = this.b;
            p0Var4.getClass();
            IAlog.a("%sad does not contain custom close. Showing close button", IAlog.a(p0Var4));
            this.b.d(false);
        }
        Runnable runnable = this.b.l;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.b.l = null;
        }
    }
}
