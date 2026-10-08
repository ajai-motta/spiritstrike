package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h3 extends y2 {
    protected h3(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.h hVar, com.applovin.impl.sdk.k kVar) {
        super(a3Var, jSONObject, jSONObject2, hVar, kVar);
    }

    public float c0() {
        return a("viewability_min_alpha", ((Float) this.f440a.a(y4.B1)).floatValue() / 100.0f);
    }

    public int d0() {
        return a("viewability_min_pixels", -1);
    }

    public int e0() {
        MaxAdFormat format = getFormat();
        y4 y4Var = format == MaxAdFormat.BANNER ? y4.u1 : format == MaxAdFormat.MREC ? y4.w1 : format == MaxAdFormat.LEADER ? y4.y1 : format == MaxAdFormat.NATIVE ? y4.A1 : null;
        if (y4Var != null) {
            return a("viewability_min_height", ((Integer) this.f440a.a(y4Var)).intValue());
        }
        return 0;
    }

    public float f0() {
        return a("viewability_min_percentage_dp", -1.0f);
    }

    public float g0() {
        return a("viewability_min_percentage_pixels", -1.0f);
    }

    public long h0() {
        return a("viewability_timer_min_visible_ms", ((Long) this.f440a.a(y4.C1)).longValue());
    }

    public int i0() {
        MaxAdFormat format = getFormat();
        y4 y4Var = format == MaxAdFormat.BANNER ? y4.t1 : format == MaxAdFormat.MREC ? y4.v1 : format == MaxAdFormat.LEADER ? y4.x1 : format == MaxAdFormat.NATIVE ? y4.z1 : null;
        if (y4Var != null) {
            return a("viewability_min_width", ((Integer) this.f440a.a(y4Var)).intValue());
        }
        return 0;
    }

    public boolean j0() {
        return d0() >= 0 || f0() >= 0.0f || g0() >= 0.0f;
    }
}
