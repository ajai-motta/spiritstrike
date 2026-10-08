package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c3 extends y2 implements t1 {
    private final Bundle t;
    private final AtomicReference u;
    private final AtomicBoolean v;
    private final AtomicBoolean w;
    private final AtomicBoolean x;
    private boolean y;
    private String z;

    public c3(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        super(a3Var, jSONObject, jSONObject2, null, kVar);
        this.t = new Bundle();
        this.w = new AtomicBoolean();
        this.x = new AtomicBoolean();
        this.u = new AtomicReference();
        this.v = new AtomicBoolean();
    }

    private long d0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f440a.a(r3.W7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.y2
    public y2 a(com.applovin.impl.mediation.h hVar) {
        return new c3(this, hVar);
    }

    public void c0() {
        this.v.set(true);
    }

    public long e0() {
        return a("ahdm", ((Long) this.f440a.a(r3.Q7)).longValue());
    }

    public long f0() {
        long jA = a("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f440a.a(r3.e8)).longValue());
    }

    public long g0() {
        long jA = a("ad_hidden_timeout_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_timeout_ms", ((Long) this.f440a.a(r3.b8)).longValue());
    }

    @Override // com.applovin.impl.t1
    public long getTimeToLiveMillis() {
        return d0() - (SystemClock.elapsedRealtime() - G());
    }

    public o4 h0() {
        return (o4) this.u.getAndSet(null);
    }

    public long i0() {
        if (G() > 0) {
            return SystemClock.elapsedRealtime() - G();
        }
        return -1L;
    }

    public void j(String str) {
        this.z = str;
    }

    public Bundle j0() {
        return this.t;
    }

    public long k0() {
        long jA = a("fullscreen_display_delay_ms", -1L);
        return jA >= 0 ? jA : ((Long) this.f440a.a(r3.O7)).longValue();
    }

    public String l0() {
        return b("mcode", "");
    }

    public AtomicBoolean m0() {
        return this.w;
    }

    public String n0() {
        return this.z;
    }

    public AtomicBoolean o0() {
        return this.x;
    }

    public boolean p0() {
        return this.v.get();
    }

    public boolean q0() {
        if (a("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f440a.a(r3.c8)).booleanValue();
    }

    public boolean r0() {
        if (a("schedule_ad_hidden_on_single_task_app_relaunch", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) this.f440a.a(r3.d8)).booleanValue();
    }

    public boolean s0() {
        return a("susaode", (Boolean) this.f440a.a(r3.P7)).booleanValue();
    }

    @Override // com.applovin.impl.t1
    public void setExpired() {
        this.y = true;
    }

    @Override // com.applovin.impl.y2
    public void a(Bundle bundle) {
        Bundle bundle2;
        super.a(bundle);
        if (bundle == null || (bundle2 = bundle.getBundle("applovin_ad_view_info")) == null) {
            return;
        }
        this.t.putBundle("applovin_ad_view_info", bundle2);
    }

    public void a(o4 o4Var) {
        this.u.set(o4Var);
    }

    private c3(c3 c3Var, com.applovin.impl.mediation.h hVar) {
        super(c3Var.L(), c3Var.a(), c3Var.g(), hVar, c3Var.f440a);
        this.t = new Bundle();
        this.w = new AtomicBoolean();
        this.x = new AtomicBoolean();
        this.u = c3Var.u;
        this.v = c3Var.v;
    }
}
