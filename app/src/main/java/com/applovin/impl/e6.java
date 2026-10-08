package com.applovin.impl;

import com.google.android.exoplayer2.ExoPlayer;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e6 {
    private static final ExecutorService r = Executors.newFixedThreadPool(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f369a;
    private final com.applovin.impl.sdk.o b;
    private final ScheduledThreadPoolExecutor c;
    private final ScheduledThreadPoolExecutor d;
    private final ScheduledThreadPoolExecutor e;
    private final ScheduledThreadPoolExecutor f;
    private final ScheduledThreadPoolExecutor g;
    private final ScheduledThreadPoolExecutor h;
    private final ScheduledThreadPoolExecutor i;
    private ExecutorService k;
    private ExecutorService l;
    private boolean o;
    private boolean p;
    private final boolean q;
    private final Map j = new HashMap();
    private final List m = new ArrayList(5);
    private final Object n = new Object();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f370a;

        static {
            int[] iArr = new int[b.values().length];
            f370a = iArr;
            try {
                iArr[b.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f370a[b.CACHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f370a[b.MEDIATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f370a[b.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        CORE,
        CACHING,
        MEDIATION,
        TIMEOUT,
        OTHER
    }

    private static class c extends e {
        private final long f;

        public c(com.applovin.impl.sdk.k kVar, j5 j5Var, b bVar, long j) {
            super(kVar, j5Var, bVar);
            this.f = j;
        }
    }

    private class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f372a;

        class a implements Thread.UncaughtExceptionHandler {
            a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                com.applovin.impl.sdk.o unused = e6.this.b;
                if (com.applovin.impl.sdk.o.a()) {
                    e6.this.b.a("TaskManager", "Caught unhandled exception", th);
                }
            }
        }

        d(String str) {
            this.f372a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:" + this.f372a);
            thread.setDaemon(true);
            thread.setPriority(((Integer) e6.this.f369a.a(y4.Q)).intValue());
            thread.setUncaughtExceptionHandler(new a());
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.k f374a;
        private final String b;
        private final com.applovin.impl.sdk.o c;
        protected final j5 d;
        protected final b e;

        public e(com.applovin.impl.sdk.k kVar, j5 j5Var, b bVar) {
            this.f374a = kVar;
            this.c = kVar.O();
            this.b = j5Var.c();
            this.d = j5Var;
            this.e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o0.a();
                if (!this.f374a.F0() || this.d.d()) {
                    ScheduledFuture scheduledFutureB = this.d.b(Thread.currentThread(), ((Long) this.f374a.a(y4.w)).longValue());
                    this.d.run();
                    if (scheduledFutureB != null) {
                        scheduledFutureB.cancel(false);
                    }
                } else {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.d(this.b, "Task re-scheduled...");
                    }
                    this.f374a.r0().a(this.d, this.e, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.d(this.b, this.e + " queue finished task " + this.d.c());
                }
            } catch (Throwable th) {
                try {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "Task failed execution", th);
                    }
                    this.d.a(th);
                } finally {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.d(this.b, this.e + " queue finished task " + this.d.c());
                    }
                }
            }
        }
    }

    public e6(com.applovin.impl.sdk.k kVar) {
        this.f369a = kVar;
        this.b = kVar.O();
        this.p = ((Boolean) kVar.a(y4.T)).booleanValue();
        this.q = ((Boolean) kVar.a(y4.T6)).booleanValue();
        this.c = b("auxiliary_operations", ((Integer) kVar.a(y4.O)).intValue());
        this.d = b("shared_thread_pool", ((Integer) kVar.a(y4.N)).intValue());
        this.e = b("core", ((Integer) kVar.a(y4.U)).intValue());
        this.g = b("caching", ((Integer) kVar.a(y4.V)).intValue());
        this.h = b("mediation", ((Integer) kVar.a(y4.W)).intValue());
        this.f = b("timeout", ((Integer) kVar.a(y4.X)).intValue());
        this.i = b("other", ((Integer) kVar.a(y4.Y)).intValue());
        if (((Boolean) kVar.a(y4.N0)).booleanValue() && ((Boolean) kVar.a(y4.O0)).booleanValue()) {
            this.k = Executors.newFixedThreadPool(((Integer) kVar.a(y4.P0)).intValue(), new d("com.applovin.sdk.caching.shared"));
            this.l = Executors.newFixedThreadPool(((Integer) kVar.a(y4.Q0)).intValue(), new d("com.applovin.sdk.caching.html.shared"));
        }
    }

    public ExecutorService c() {
        return this.p ? this.g : r;
    }

    public Executor d() {
        return this.p ? this.e : this.d;
    }

    public ExecutorService e() {
        return this.l;
    }

    public boolean f() {
        return (a() == null || e() == null) ? false : true;
    }

    public boolean g() {
        return this.o;
    }

    public void h() {
        synchronized (this.n) {
            this.o = true;
            for (e eVar : this.m) {
                if (this.q) {
                    c cVar = (c) eVar;
                    a(cVar.d, cVar.e, cVar.f);
                } else {
                    a(eVar.d, eVar.e);
                }
            }
            this.m.clear();
        }
    }

    public void i() {
        synchronized (this.n) {
            this.o = false;
        }
    }

    public ExecutorService a() {
        return this.k;
    }

    public ScheduledFuture b(j5 j5Var, b bVar, long j) {
        return this.p ? a(new e(this.f369a, j5Var, bVar)).schedule(j5Var, j, TimeUnit.MILLISECONDS) : this.c.schedule(j5Var, j, TimeUnit.MILLISECONDS);
    }

    public void a(j5 j5Var, b bVar) {
        a(j5Var, bVar, 0L);
    }

    public void a(j5 j5Var, b bVar, long j) {
        a(j5Var, bVar, j, false);
    }

    public void a(j5 j5Var, b bVar, long j, boolean z) {
        e eVar;
        if (j5Var == null) {
            throw new IllegalArgumentException("No task specified");
        }
        if (j >= 0) {
            if (this.q) {
                eVar = new c(this.f369a, j5Var, bVar, j);
            } else {
                eVar = new e(this.f369a, j5Var, bVar);
            }
            if (!b(eVar)) {
                a(eVar, j, z);
                return;
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.d(j5Var.c(), "Task execution delayed until after init");
                    return;
                }
                return;
            }
        }
        throw new IllegalArgumentException("Invalid delay (millis) specified: " + j);
    }

    public ExecutorService b() {
        return this.p ? this.i : this.c;
    }

    private boolean b(e eVar) {
        if (eVar.d.d()) {
            return false;
        }
        synchronized (this.n) {
            if (this.o) {
                return false;
            }
            this.m.add(eVar);
            return true;
        }
    }

    public void a(Runnable runnable, b bVar) {
        if (this.p) {
            com.applovin.impl.sdk.k kVar = this.f369a;
            e eVar = new e(kVar, new s6(kVar, "auxiliaryOperation", runnable), bVar);
            a(eVar).submit(eVar);
            return;
        }
        this.c.submit(runnable);
    }

    private ScheduledThreadPoolExecutor b(String str, int i) {
        return new ScheduledThreadPoolExecutor(i, new d(str));
    }

    public Executor a(final String str) {
        return new Executor() { // from class: com.applovin.impl.e6$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.a(str, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        a(new s6(this.f369a, str, runnable));
    }

    public void a(j5 j5Var) {
        if (j5Var != null) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.p ? this.e : this.d;
            try {
                if (o7.h()) {
                    scheduledThreadPoolExecutor.submit(new e(this.f369a, j5Var, b.CORE));
                    return;
                }
                ScheduledFuture scheduledFutureB = j5Var.b(Thread.currentThread(), ((Long) this.f369a.a(y4.w)).longValue());
                j5Var.run();
                if (scheduledFutureB != null) {
                    scheduledFutureB.cancel(false);
                    return;
                }
                return;
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.a(j5Var.c(), "Task failed execution", th);
                }
                j5Var.a(th);
                return;
            }
        }
        throw new IllegalArgumentException("No task specified");
    }

    public void a(j5 j5Var, k3 k3Var) {
        String strB = k3Var.b();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = (ScheduledThreadPoolExecutor) this.j.get(strB);
        if (scheduledThreadPoolExecutorB == null) {
            scheduledThreadPoolExecutorB = b(strB, 1);
            this.j.put(strB, scheduledThreadPoolExecutorB);
        }
        scheduledThreadPoolExecutorB.submit(new e(this.f369a, j5Var, b.MEDIATION));
    }

    private void a(final e eVar, long j, boolean z) {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutorA = this.p ? a(eVar) : this.d;
        if (j <= 0) {
            scheduledThreadPoolExecutorA.submit(eVar);
        } else if (z) {
            g0.a(j, this.f369a, new Runnable() { // from class: com.applovin.impl.e6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledThreadPoolExecutorA.execute(eVar);
                }
            });
        } else {
            scheduledThreadPoolExecutorA.schedule(eVar, j, TimeUnit.MILLISECONDS);
        }
    }

    private ScheduledThreadPoolExecutor a(e eVar) {
        int i = a.f370a[eVar.e.ordinal()];
        if (i == 1) {
            return this.e;
        }
        if (i == 2) {
            return this.g;
        }
        if (i == 3) {
            return this.h;
        }
        if (i != 4) {
            return this.i;
        }
        return this.f;
    }

    public ExecutorService a(String str, int i) {
        return Executors.newFixedThreadPool(i, new d(str));
    }

    public List a(List list, ExecutorService executorService) {
        try {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.a("TaskManager", "Awaiting " + list.size() + " tasks...");
            }
            return executorService.invokeAll(list);
        } catch (Throwable th) {
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            this.b.a("TaskManager", "Awaiting tasks were interrupted", th);
            return null;
        }
    }
}
