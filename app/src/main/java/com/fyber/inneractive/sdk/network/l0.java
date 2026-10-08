package com.fyber.inneractive.sdk.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {
    public static final h0 g = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f1206a = new PriorityBlockingQueue(100, new k0());
    public volatile boolean b = false;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final ThreadPoolExecutor d = new ThreadPoolExecutor(6, 6, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100), g);
    public final i0 e = new i0(this);
    public final j1 f = new j1();

    public final void a(t0 t0Var) {
        p0 p0Var;
        if (!this.f1206a.offer(t0Var)) {
            IAlog.a("Request queue is full! current request is dropped! %s", t0Var.r());
            return;
        }
        i1 i1Var = i1.QUEUED;
        t0Var.f = i1Var;
        if (i1Var != i1.QUEUED_FOR_RETRY || (p0Var = t0Var.d) == null) {
            return;
        }
        p0Var.a("sdkRequestEndedButWillBeRetried");
    }

    public final void b(t0 t0Var) {
        j1 j1Var = this.f;
        j1Var.getClass();
        String str = t0Var.g;
        IAlog.a("%s : NetworkRequestWatchdog : finalize request: %s", IAlog.a(j1Var), str);
        n1 n1Var = (n1) j1Var.f1203a.get(str);
        if (n1Var != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(n1Var.d);
        }
        j1Var.f1203a.remove(str);
    }

    public final boolean c(t0 t0Var) {
        if (!t0Var.u()) {
            return false;
        }
        t0Var.f = i1.QUEUED_FOR_RETRY;
        p0 p0Var = t0Var.d;
        if (p0Var != null) {
            p0Var.a("sdkRequestEndedButWillBeRetried");
        }
        long jG = t0Var.g();
        IAlog.e("retryNetworkRequest queue up in main thread - %s with delay of %d", t0Var.getClass().getName(), Long.valueOf(jG));
        this.c.postDelayed(new j0(this, t0Var), jG);
        return true;
    }

    public static void a(t0 t0Var, l lVar, o0 o0Var) {
        try {
            if (t0Var.f1217a || t0Var.h() == null || o0Var == null || lVar == null || lVar.f1205a != 200) {
                return;
            }
            t0Var.a(o0Var, t0Var.h(), lVar.e);
        } catch (Exception e) {
            IAlog.a("Failed cache network response data", e, new Object[0]);
        }
    }

    public static void a(t0 t0Var, o0 o0Var) {
        try {
            if (t0Var.f1217a || o0Var == null) {
                return;
            }
            t0Var.a(o0Var.f1211a, (Exception) null, false);
        } catch (Exception e) {
            IAlog.a("failed notifying the listener request complete", e, new Object[0]);
            if (t0Var.f1217a) {
                return;
            }
            t0Var.a((Object) null, e, false);
        }
    }

    public final o0 a(t0 t0Var, l lVar) throws Exception {
        o0 o0VarA = null;
        if (lVar != null) {
            try {
                if (!t0Var.f1217a) {
                    int i = lVar.f1205a;
                    if (i == 200 || (i >= 300 && i < 304)) {
                        o0VarA = t0Var.a(lVar, lVar.d, i);
                    } else if (i == 304) {
                        t0Var.a((Object) null, (Exception) new g(), false);
                    } else {
                        t0Var.a((Object) null, (Exception) new k1(lVar.b, lVar.f1205a), false);
                    }
                }
            } catch (t1 e) {
                IAlog.a("failed parsing network request but will retry", e, new Object[0]);
                if (c(t0Var)) {
                    throw e;
                }
                throw new s1(e);
            } catch (Exception e2) {
                IAlog.a("failed parsing network request", e2, new Object[0]);
                throw e2;
            }
        }
        return o0VarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.network.l a(com.fyber.inneractive.sdk.network.t0 r4, com.fyber.inneractive.sdk.network.a r5) throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.String r0 = "failed sending network request"
            r1 = 0
            boolean r2 = r4.f1217a     // Catch: java.lang.Exception -> L18 java.net.SocketTimeoutException -> L1f com.fyber.inneractive.sdk.network.b -> L21 java.net.UnknownHostException -> L23 com.fyber.inneractive.sdk.network.t1 -> L3b
            if (r2 != 0) goto L16
            if (r5 == 0) goto Lc
            java.lang.String r5 = r5.f1190a     // Catch: java.lang.Exception -> L18 java.net.SocketTimeoutException -> L1f com.fyber.inneractive.sdk.network.b -> L21 java.net.UnknownHostException -> L23 com.fyber.inneractive.sdk.network.t1 -> L3b
            goto Le
        Lc:
            java.lang.String r5 = ""
        Le:
            a()     // Catch: java.lang.Exception -> L18 java.net.SocketTimeoutException -> L1f com.fyber.inneractive.sdk.network.b -> L21 java.net.UnknownHostException -> L23 com.fyber.inneractive.sdk.network.t1 -> L3b
            com.fyber.inneractive.sdk.network.l r4 = r4.a(r5)     // Catch: java.lang.Exception -> L18 java.net.SocketTimeoutException -> L1f com.fyber.inneractive.sdk.network.b -> L21 java.net.UnknownHostException -> L23 com.fyber.inneractive.sdk.network.t1 -> L3b
            goto L17
        L16:
            r4 = 0
        L17:
            return r4
        L18:
            r4 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r1]
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r4, r5)
            throw r4
        L1f:
            r5 = move-exception
            goto L24
        L21:
            r5 = move-exception
            goto L24
        L23:
            r5 = move-exception
        L24:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r5, r1)
            boolean r4 = r3.c(r4)
            if (r4 == 0) goto L35
            com.fyber.inneractive.sdk.network.t1 r4 = new com.fyber.inneractive.sdk.network.t1
            r4.<init>(r5)
            throw r4
        L35:
            com.fyber.inneractive.sdk.network.s1 r4 = new com.fyber.inneractive.sdk.network.s1
            r4.<init>(r5)
            throw r4
        L3b:
            r5 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "failed sending network request but will retry"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r5, r0)
            boolean r4 = r3.c(r4)
            if (r4 == 0) goto L4a
            throw r5
        L4a:
            com.fyber.inneractive.sdk.network.s1 r4 = new com.fyber.inneractive.sdk.network.s1
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.l0.a(com.fyber.inneractive.sdk.network.t0, com.fyber.inneractive.sdk.network.a):com.fyber.inneractive.sdk.network.l");
    }

    public static void a() throws b {
        Boolean boolC = ((com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.k.class)).c("should_use_is_network_connected");
        if (boolC == null || !boolC.booleanValue()) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.fyber.inneractive.sdk.util.o.f1662a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_NETWORK_STATE") && activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnectedOrConnecting()) {
                    return;
                }
            }
            throw new b("No network connection");
        } catch (Throwable unused) {
            IAlog.b("Error retrieved when trying to get the network state - Perhaps you forgot to declare android.permission.ACCESS_NETWORK_STATE in your Android manifest file.", new Object[0]);
        }
    }
}
