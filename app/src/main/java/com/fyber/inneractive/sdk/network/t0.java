package com.fyber.inneractive.sdk.network;

import android.util.Log;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f1217a;
    public final f0 b;
    public final h c;
    public p0 d;
    public l e;
    public volatile i1 f;
    public final String g;
    public final com.fyber.inneractive.sdk.config.global.r h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public final Object n;
    public boolean o;

    public t0(f0 f0Var, h hVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.f1217a = false;
        this.f = i1.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.o = false;
        this.b = f0Var;
        this.c = hVar;
        this.g = UUID.randomUUID().toString();
        this.h = rVar;
    }

    public abstract o0 a(l lVar, Map map, int i);

    public void a(o0 o0Var, String str, String str2) {
    }

    public void b(long j) {
        synchronized (this.n) {
            if (this.m) {
                this.k = (int) ((j - this.i) + ((long) this.k));
                this.m = false;
            }
        }
    }

    public void c() {
        this.f1217a = true;
    }

    public void d() {
        boolean z;
        synchronized (this.n) {
            z = this.l;
        }
        if (z) {
            a(System.currentTimeMillis());
        } else if (t()) {
            b(System.currentTimeMillis());
        }
    }

    public void e() {
        try {
            l lVar = this.e;
            if (lVar != null) {
                lVar.a();
            }
            this.c.getClass();
        } catch (Exception unused) {
        }
    }

    public byte[] f() {
        return null;
    }

    public abstract int g();

    public String h() {
        return null;
    }

    public a i() {
        return null;
    }

    public int j() {
        return this.k;
    }

    public com.fyber.inneractive.sdk.config.global.r k() {
        return this.h;
    }

    public Map l() {
        return null;
    }

    public abstract m0 m();

    public String n() {
        return "application/json; charset=utf-8";
    }

    public abstract g1 o();

    public l1 p() {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        return new l1(iAConfigManager.u.b.a("connect_timeout", 5000, 1), iAConfigManager.u.b.a("read_timeout", 5000, 1));
    }

    public int q() {
        int i;
        synchronized (this.n) {
            i = this.k;
        }
        return i;
    }

    public abstract String r();

    public int s() {
        Integer numA;
        com.fyber.inneractive.sdk.config.global.r rVar = this.h;
        if (rVar == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.k) rVar.a(com.fyber.inneractive.sdk.config.global.features.k.class)).a("watchdog_buffer_time_ms")) == null) {
            return 500;
        }
        return numA.intValue();
    }

    public final boolean t() {
        boolean z;
        synchronized (this.n) {
            z = this.m;
        }
        return z;
    }

    public abstract boolean u();

    public final boolean v() {
        com.fyber.inneractive.sdk.config.global.features.k kVar;
        Boolean boolC;
        Boolean boolC2;
        return this.o && (((boolC = (kVar = (com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.k.class)).c("should_add_request_watchdog")) != null && boolC.booleanValue()) || ((boolC2 = kVar.c("should_report_request_watchdog")) != null && boolC2.booleanValue()));
    }

    public l a(String str) throws Exception {
        try {
            p0 p0Var = this.d;
            if (p0Var != null) {
                p0Var.a("sdkInitNetworkRequest");
            }
            this.e = this.c.a(this, com.fyber.inneractive.sdk.util.o.h(), str);
            p0 p0Var2 = this.d;
            if (p0Var2 != null) {
                p0Var2.a("sdkGotServerResponse");
            }
            return this.e;
        } catch (b e) {
            IAlog.a("failed start network request", e, new Object[0]);
            throw e;
        } catch (q1 e2) {
            IAlog.a("failed read network response", e2, new Object[0]);
            throw e2;
        } catch (Exception e3) {
            IAlog.a("failed start network request", e3, new Object[0]);
            throw e3;
        }
    }

    public void c(long j) {
        synchronized (this.n) {
            if (!this.l) {
                this.l = true;
                this.j = j;
            }
        }
    }

    public void d(long j) {
        synchronized (this.n) {
            if (!this.m) {
                this.m = true;
                this.i = j;
            }
        }
    }

    public final void a(Object obj, Exception exc, boolean z) {
        p0 p0Var;
        if (!z) {
            i1 i1Var = i1.RESOLVED;
            this.f = i1Var;
            if (i1Var == i1.QUEUED_FOR_RETRY && (p0Var = this.d) != null) {
                p0Var.a("sdkRequestEndedButWillBeRetried");
            }
        }
        com.fyber.inneractive.sdk.util.r.b.post(new s0(this, obj, exc, z));
    }

    public final com.fyber.inneractive.sdk.response.e a(int i, o oVar, com.fyber.inneractive.sdk.response.j jVar, com.fyber.inneractive.sdk.dv.j jVar2) throws n0 {
        try {
            com.fyber.inneractive.sdk.response.a aVarA = com.fyber.inneractive.sdk.response.a.a(i);
            if (aVarA == null) {
                aVarA = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            com.fyber.inneractive.sdk.factories.f fVar = com.fyber.inneractive.sdk.factories.d.f1028a;
            com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) fVar.f1029a.get(aVarA);
            com.fyber.inneractive.sdk.response.b bVarB = eVar != null ? eVar.b() : null;
            if (bVarB == null) {
                IAlog.f("Received ad type %s does not have an appropriate parser!", Integer.valueOf(i));
                if (fVar.f1029a.size() == 0) {
                    Log.e("Inneractive_error", "Critical error raised while fetching an ad - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
                }
                throw new n0("Could not find parser for ad type " + i);
            }
            IAlog.a("Received ad type %s - Got parser! %s", Integer.valueOf(i), bVarB);
            if (jVar != null) {
                bVarB.c = jVar;
            }
            bVarB.f1610a = bVarB.a();
            if (oVar != null) {
                bVarB.c = new com.fyber.inneractive.sdk.response.k(oVar);
            }
            com.fyber.inneractive.sdk.response.e eVarA = bVarB.a(null);
            eVarA.K = j();
            if (jVar2 != null) {
                eVarA.u = jVar2;
            }
            p0 p0Var = this.d;
            if (p0Var != null) {
                p0Var.a("sdkParsedResponse");
            }
            return eVarA;
        } catch (Exception e) {
            IAlog.a("failed parse ad network request", e, new Object[0]);
            throw new n0(e);
        }
    }

    public t0(t0 t0Var) {
        this.f1217a = false;
        this.f = i1.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.o = false;
        this.b = t0Var.b;
        this.c = t0Var.c;
        this.g = UUID.randomUUID().toString();
        this.h = t0Var.h;
        this.k = t0Var.k;
        this.i = t0Var.i;
        this.j = t0Var.j;
    }

    public static int a(Map map) {
        List list = map != null ? (List) map.get(HttpHeaders.CONTENT_LENGTH) : null;
        if (list != null) {
            return com.fyber.inneractive.sdk.util.v.a((String) list.get(0), -1);
        }
        return -1;
    }

    public void a(long j) {
        synchronized (this.n) {
            if (this.l) {
                this.k = (int) ((j - this.j) + ((long) this.k));
                this.l = false;
            }
        }
    }
}
