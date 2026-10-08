package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b3 extends h3 {
    public b3(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        super(a3Var, jSONObject, jSONObject2, null, kVar);
    }

    @Override // com.applovin.impl.y2
    public y2 a(com.applovin.impl.mediation.h hVar) {
        return new b3(this, hVar);
    }

    public long k0() {
        long jA = a("ad_refresh_ms", -1L);
        return jA >= 0 ? jA : b("ad_refresh_ms", ((Long) this.f440a.a(r3.D7)).longValue());
    }

    public long l0() {
        return o7.e(a("bg_color", (String) null));
    }

    public int m0() {
        int iA = a("ad_view_height", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public long n0() {
        return a("viewability_imp_delay_ms", ((Long) this.f440a.a(y4.s1)).longValue());
    }

    public int o0() {
        int iA = a("ad_view_width", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public boolean p0() {
        return k0() >= 0;
    }

    public boolean q0() {
        return a("proe", (Boolean) this.f440a.a(r3.f8)).booleanValue();
    }

    private b3(b3 b3Var, com.applovin.impl.mediation.h hVar) {
        super(b3Var.L(), b3Var.a(), b3Var.g(), hVar, b3Var.f440a);
    }
}
