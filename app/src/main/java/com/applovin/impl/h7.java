package com.applovin.impl;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class h7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f405a;
    private Timer b;
    private long c;
    private long d;
    private long e;
    private boolean f;
    private final Runnable g;
    private long h;
    private final Object i = new Object();

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                h7.this.g.run();
                synchronized (h7.this.i) {
                    if (h7.this.f) {
                        h7.this.c = System.currentTimeMillis();
                        h7 h7Var = h7.this;
                        h7Var.d = h7Var.e;
                    } else {
                        h7.this.b = null;
                    }
                }
            } catch (Throwable th) {
                try {
                    if (h7.this.f405a != null) {
                        h7.this.f405a.O();
                        if (com.applovin.impl.sdk.o.a()) {
                            h7.this.f405a.O().a("Timer", "Encountered error while executing timed task", th);
                        }
                        h7.this.f405a.D().a("Timer", "executingTimedTask", th);
                    }
                    synchronized (h7.this.i) {
                        if (h7.this.f) {
                            h7.this.c = System.currentTimeMillis();
                            h7 h7Var2 = h7.this;
                            h7Var2.d = h7Var2.e;
                        } else {
                            h7.this.b = null;
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (h7.this.i) {
                        if (h7.this.f) {
                            h7.this.c = System.currentTimeMillis();
                            h7 h7Var3 = h7.this;
                            h7Var3.d = h7Var3.e;
                        } else {
                            h7.this.b = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private h7(com.applovin.impl.sdk.k kVar, Runnable runnable) {
        this.f405a = kVar;
        this.g = runnable;
    }

    public long c() {
        if (this.b == null) {
            return this.d - this.h;
        }
        return this.d - (System.currentTimeMillis() - this.c);
    }

    public void d() {
        synchronized (this.i) {
            Timer timer = this.b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.h = Math.max(1L, System.currentTimeMillis() - this.c);
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.k kVar = this.f405a;
                        if (kVar != null) {
                            kVar.O();
                            if (com.applovin.impl.sdk.o.a()) {
                                this.f405a.O();
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.f405a.O().a("Timer", "Encountered error while pausing timer", th);
                                }
                            }
                        }
                        this.b = null;
                    } finally {
                        this.b = null;
                    }
                }
            }
        }
    }

    public void e() {
        synchronized (this.i) {
            long j = this.h;
            if (j > 0) {
                try {
                    long j2 = this.d - j;
                    this.d = j2;
                    if (j2 < 0) {
                        this.d = 0L;
                    }
                    this.b = new Timer();
                    a(b(), this.d, this.f, this.e);
                    this.c = System.currentTimeMillis();
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.k kVar = this.f405a;
                        if (kVar != null) {
                            kVar.O();
                            if (com.applovin.impl.sdk.o.a()) {
                                this.f405a.O();
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.f405a.O().a("Timer", "Encountered error while resuming timer", th);
                                }
                            }
                        }
                        this.h = 0L;
                    } finally {
                        this.h = 0L;
                    }
                }
            }
        }
    }

    private TimerTask b() {
        return new a();
    }

    public static h7 a(long j, com.applovin.impl.sdk.k kVar, Runnable runnable) {
        return a(j, false, kVar, runnable);
    }

    public static h7 a(long j, boolean z, com.applovin.impl.sdk.k kVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        }
        if (runnable != null) {
            h7 h7Var = new h7(kVar, runnable);
            h7Var.c = System.currentTimeMillis();
            h7Var.d = j;
            h7Var.f = z;
            h7Var.e = j;
            try {
                h7Var.b = new Timer();
                h7Var.a(h7Var.b(), j, z, h7Var.e);
            } catch (OutOfMemoryError e) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("Timer", "Failed to create timer due to OOM error", e);
                }
            }
            return h7Var;
        }
        throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
    }

    public void a() {
        synchronized (this.i) {
            Timer timer = this.b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.b = null;
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.k kVar = this.f405a;
                        if (kVar != null) {
                            kVar.O();
                            if (com.applovin.impl.sdk.o.a()) {
                                this.f405a.O();
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.f405a.O().a("Timer", "Encountered error while cancelling timer", th);
                                }
                            }
                        }
                        this.b = null;
                    } catch (Throwable th2) {
                        this.b = null;
                        this.h = 0L;
                        throw th2;
                    }
                }
                this.h = 0L;
            }
        }
    }

    private void a(TimerTask timerTask, long j, boolean z, long j2) {
        if (z) {
            this.b.schedule(timerTask, j, j2);
        } else {
            this.b.schedule(timerTask, j);
        }
    }
}
