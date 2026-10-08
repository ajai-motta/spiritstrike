package com.fyber.inneractive.sdk.flow;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.v1;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p0 extends b0 implements com.fyber.inneractive.sdk.interfaces.f {
    public com.fyber.inneractive.sdk.interfaces.e k;
    public Runnable l;
    public v1 m;
    public Runnable n;
    public v1 o;
    public long r;
    public m0 v;
    public boolean p = false;
    public boolean q = false;
    public boolean s = false;
    public boolean t = false;
    public final com.fyber.inneractive.sdk.util.a u = new com.fyber.inneractive.sdk.util.a();

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final int A() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null || eVar.getLayout() == null) {
            return 1;
        }
        return this.k.getLayout().getHeight();
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final int B() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null || eVar.getLayout() == null) {
            return 1;
        }
        return this.k.getLayout().getWidth();
    }

    public abstract boolean K();

    public final void L() {
        if (this.l == null) {
            long jO = O();
            this.r = jO;
            this.l = new l0(this, jO);
            IAlog.a("%senabling close with delay %d", IAlog.a(this), Long.valueOf(this.r));
            x xVar = this.b;
            boolean zB = xVar != null ? b(xVar) : false;
            if (zB && !K()) {
                if (zB) {
                    com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
                    if (eVar != null) {
                        eVar.showCloseCountdown();
                    }
                    m0 m0Var = new m0(this, this.r + 100);
                    this.v = m0Var;
                    m0Var.start();
                    return;
                }
                return;
            }
            if (this.q) {
                return;
            }
            this.q = true;
            v1 v1Var = new v1(TimeUnit.MILLISECONDS, this.r);
            this.m = v1Var;
            v1Var.e = new n0(this);
            t1 t1Var = new t1(v1Var);
            v1Var.c = t1Var;
            v1Var.d = false;
            t1Var.sendEmptyMessage(1932593528);
        }
    }

    public abstract int M();

    public abstract int N();

    public abstract long O();

    public abstract boolean P();

    public abstract long a(long j);

    public void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        if (this.f1036a == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("No spot ad to render");
        }
        if (eVar != null) {
            this.k = eVar;
        } else {
            IAlog.f("%srenderAd called with a null activity!", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Activity is null");
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void b(boolean z) {
    }

    public abstract boolean b(x xVar);

    public final void c(boolean z) {
        com.fyber.inneractive.sdk.network.w wVar;
        if (this.b == null) {
            com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.MRAID_CUSTOM_CLOSE_DETECTED;
            wVar = new com.fyber.inneractive.sdk.network.w((com.fyber.inneractive.sdk.response.e) null);
            wVar.c = uVar;
            wVar.f1220a = null;
            wVar.d = null;
        } else {
            com.fyber.inneractive.sdk.network.u uVar2 = com.fyber.inneractive.sdk.network.u.MRAID_CUSTOM_CLOSE_DETECTED;
            x xVar = this.b;
            InneractiveAdRequest inneractiveAdRequest = xVar.f1126a;
            com.fyber.inneractive.sdk.response.e eVarB = xVar.b();
            JSONArray jSONArrayB = this.b.c.b();
            wVar = new com.fyber.inneractive.sdk.network.w(eVarB);
            wVar.c = uVar2;
            wVar.f1220a = inneractiveAdRequest;
            wVar.d = jSONArrayB;
        }
        JSONObject jSONObject = new JSONObject();
        Boolean boolValueOf = Boolean.valueOf(z);
        try {
            jSONObject.put("fyber_close_enabled", boolValueOf);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "fyber_close_enabled", boolValueOf);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }

    public final void d(boolean z) {
        com.fyber.inneractive.sdk.network.w wVar;
        this.p = true;
        if (z) {
            if (this.b == null) {
                com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.FAIL_SAFE_ACTIVATED;
                wVar = new com.fyber.inneractive.sdk.network.w((com.fyber.inneractive.sdk.response.e) null);
                wVar.c = uVar;
                wVar.f1220a = null;
                wVar.d = null;
            } else {
                com.fyber.inneractive.sdk.network.u uVar2 = com.fyber.inneractive.sdk.network.u.FAIL_SAFE_ACTIVATED;
                x xVar = this.b;
                InneractiveAdRequest inneractiveAdRequest = xVar.f1126a;
                com.fyber.inneractive.sdk.response.e eVarB = xVar.b();
                JSONArray jSONArrayB = this.b.c.b();
                wVar = new com.fyber.inneractive.sdk.network.w(eVarB);
                wVar.c = uVar2;
                wVar.f1220a = inneractiveAdRequest;
                wVar.d = jSONArrayB;
            }
            JSONObject jSONObject = new JSONObject();
            Boolean boolValueOf = Boolean.valueOf(P());
            try {
                jSONObject.put("is_endcard", boolValueOf);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "is_endcard", boolValueOf);
            }
            wVar.f.put(jSONObject);
            wVar.a((String) null);
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.showCloseButton(z, N(), M());
            if (z) {
                return;
            }
            com.fyber.inneractive.sdk.util.a aVar = this.u;
            aVar.d = 0L;
            aVar.e = 0L;
            aVar.f = 0L;
            aVar.b = false;
            aVar.a(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        Runnable runnable = this.l;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.l = null;
        }
        Runnable runnable2 = this.n;
        if (runnable2 != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable2);
            this.n = null;
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.destroy();
        }
        this.k = null;
        m0 m0Var = this.v;
        if (m0Var != null) {
            m0Var.cancel();
            this.v = null;
        }
        v1 v1Var = this.o;
        if (v1Var != null) {
            v1Var.e = null;
            this.o = null;
        }
        v1 v1Var2 = this.m;
        if (v1Var2 != null) {
            v1Var2.e = null;
            this.m = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void initialize(InneractiveAdSpot inneractiveAdSpot) {
        super.initialize(inneractiveAdSpot);
        this.u.f1643a = inneractiveAdSpot;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void n() {
        v1 v1Var = this.m;
        if (v1Var != null) {
            v1Var.d = false;
            v1Var.a(SystemClock.uptimeMillis());
        }
        v1 v1Var2 = this.o;
        if (v1Var2 != null) {
            v1Var2.d = false;
            v1Var2.a(SystemClock.uptimeMillis());
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void s() {
        v1 v1Var = this.m;
        if (v1Var != null) {
            v1Var.d = true;
            t1 t1Var = v1Var.c;
            if (t1Var != null) {
                t1Var.removeMessages(1932593528);
            }
        }
        v1 v1Var2 = this.o;
        if (v1Var2 != null) {
            v1Var2.d = true;
            t1 t1Var2 = v1Var2.c;
            if (t1Var2 != null) {
                t1Var2.removeMessages(1932593528);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final View z() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            return eVar.getLayout();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public boolean b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        IAlog.f("InneractiveFullscreenAdRendererImpl : registerObserver: %s doesnt support Store Promo", getClass().getName());
        return false;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        IAlog.f("InneractiveFullscreenAdRendererImpl : unregisterObserver: %s doesnt support Store Promo", getClass().getName());
    }
}
