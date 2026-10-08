package com.fyber.inneractive.sdk.util;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeUnit f1677a;
    public final long b;
    public t1 c;
    public boolean d;
    public u1 e;
    public long f;

    public v1(TimeUnit timeUnit, long j) {
        this.d = false;
        this.f = 0L;
        this.b = j;
        this.f1677a = timeUnit;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }

    public final void a(long j) {
        long jUptimeMillis = (SystemClock.uptimeMillis() - j) + 50 + this.f;
        this.f = jUptimeMillis;
        if (this.e != null && jUptimeMillis > this.f1677a.toMillis(this.b)) {
            this.e.a();
            return;
        }
        t1 t1Var = this.c;
        if (t1Var == null || this.e == null) {
            return;
        }
        t1Var.removeMessages(1932593528);
        this.c.sendEmptyMessageDelayed(1932593528, 50L);
    }

    public v1(TimeUnit timeUnit, long j, long j2) {
        this.d = false;
        this.b = j;
        this.f1677a = timeUnit;
        this.f = j2;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }
}
