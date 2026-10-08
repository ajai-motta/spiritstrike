package com.fyber.inneractive.sdk.network;

import android.os.Process;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f1201a;

    public i0(l0 l0Var) {
        this.f1201a = l0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t0 t0Var;
        o0 o0VarA;
        p0 p0Var;
        p0 p0Var2;
        i1 i1Var;
        Boolean boolC;
        p0 p0Var3;
        l0 l0Var = this.f1201a;
        l0Var.getClass();
        Process.setThreadPriority(10);
        while (l0Var.b) {
            o0 o0Var = null;
            try {
                t0Var = (t0) l0Var.f1206a.take();
            } catch (InterruptedException unused) {
                if (!l0Var.b) {
                    Thread.currentThread().interrupt();
                }
                t0Var = null;
            }
            if (t0Var != null && !t0Var.f1217a) {
                i1 i1Var2 = i1.RUNNING;
                t0Var.f = i1Var2;
                if (i1Var2 == i1.QUEUED_FOR_RETRY && (p0Var3 = t0Var.d) != null) {
                    p0Var3.a("sdkRequestEndedButWillBeRetried");
                }
                boolean z = (t0Var.o && ((boolC = ((com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.k.class)).c("should_manage_request_watchdog")) == null || boolC.booleanValue())) || t0Var.v();
                IAlog.a("%s : NetworkExecutorImpl : should enabled watchdog : %s", IAlog.a(l0Var), Boolean.valueOf(z));
                if (z) {
                    j1 j1Var = l0Var.f;
                    Thread threadCurrentThread = Thread.currentThread();
                    j1Var.getClass();
                    IAlog.a("%s : NetworkRequestWatchdog : register request: %s", IAlog.a(j1Var), t0Var.g);
                    int iS = t0Var.s();
                    l1 l1VarP = t0Var.p();
                    n1 n1Var = new n1(t0Var, threadCurrentThread, l1VarP.f1207a + l1VarP.b + iS);
                    j1Var.f1203a.putIfAbsent(t0Var.g, n1Var);
                    com.fyber.inneractive.sdk.util.r.b.postDelayed(n1Var.d, n1Var.c);
                }
                try {
                } catch (Exception e) {
                    IAlog.a("failed fetching cache data", e, new Object[0]);
                    if (!t0Var.f1217a) {
                        t0Var.a((Object) null, e, true);
                    }
                }
                a aVarI = (t0Var.f1217a || t0Var.h() == null) ? null : t0Var.i();
                if (aVarI != null && aVarI.b != null && !t0Var.f1217a) {
                    t0Var.a(aVarI.b, (Exception) null, true);
                }
                try {
                    l lVarA = l0Var.a(t0Var, aVarI);
                    o0VarA = l0Var.a(t0Var, lVarA);
                    try {
                        l0.a(t0Var, lVarA, o0VarA);
                        l0.a(t0Var, o0VarA);
                        try {
                            t0Var.e();
                        } catch (Exception unused2) {
                        }
                        i1Var = i1.DONE;
                        t0Var.f = i1Var;
                    } catch (t1 unused3) {
                        o0Var = o0VarA;
                        l0.a(t0Var, o0Var);
                        try {
                            t0Var.e();
                        } catch (Exception unused4) {
                        }
                        i1 i1Var3 = i1.DONE;
                        t0Var.f = i1Var3;
                        if (i1Var3 == i1.QUEUED_FOR_RETRY && (p0Var2 = t0Var.d) != null) {
                        }
                        l0Var.b(t0Var);
                    } catch (Exception e2) {
                        e = e2;
                        if (!t0Var.f1217a) {
                            t0Var.a((Object) null, e, false);
                        }
                        l0.a(t0Var, o0VarA);
                        try {
                            t0Var.e();
                        } catch (Exception unused5) {
                        }
                        i1 i1Var4 = i1.DONE;
                        t0Var.f = i1Var4;
                        if (i1Var4 == i1.QUEUED_FOR_RETRY && (p0Var2 = t0Var.d) != null) {
                        }
                        l0Var.b(t0Var);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!t0Var.f1217a) {
                                t0Var.a((Object) null, new Exception(th), false);
                            }
                            l0.a(t0Var, o0VarA);
                            try {
                                t0Var.e();
                            } catch (Exception unused6) {
                            }
                            i1 i1Var5 = i1.DONE;
                            t0Var.f = i1Var5;
                            if (i1Var5 == i1.QUEUED_FOR_RETRY && (p0Var2 = t0Var.d) != null) {
                            }
                            l0Var.b(t0Var);
                        } catch (Throwable th2) {
                            l0.a(t0Var, o0VarA);
                            try {
                                t0Var.e();
                            } catch (Exception unused7) {
                            }
                            i1 i1Var6 = i1.DONE;
                            t0Var.f = i1Var6;
                            if (i1Var6 == i1.QUEUED_FOR_RETRY && (p0Var = t0Var.d) != null) {
                                p0Var.a("sdkRequestEndedButWillBeRetried");
                            }
                            l0Var.b(t0Var);
                            throw th2;
                        }
                    }
                } catch (t1 unused8) {
                } catch (Exception e3) {
                    e = e3;
                    o0VarA = null;
                } catch (Throwable th3) {
                    th = th3;
                    o0VarA = null;
                }
                if (i1Var == i1.QUEUED_FOR_RETRY && (p0Var2 = t0Var.d) != null) {
                    p0Var2.a("sdkRequestEndedButWillBeRetried");
                }
                l0Var.b(t0Var);
            }
        }
    }
}
