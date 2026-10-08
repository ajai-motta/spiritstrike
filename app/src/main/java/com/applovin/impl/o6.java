package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o6 extends p6 {
    private final c3 g;

    public o6(c3 c3Var, com.applovin.impl.sdk.k kVar) {
        super("TaskReportMaxReward", kVar);
        this.g = c3Var;
    }

    @Override // com.applovin.impl.r6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, this.g.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.g.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.g.e());
        String strL0 = this.g.l0();
        if (!StringUtils.isValidString(strL0)) {
            strL0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strL0);
        String strB = this.g.B();
        if (!StringUtils.isValidString(strB)) {
            strB = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strB);
    }

    @Override // com.applovin.impl.p6
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Reported reward successfully for mediated ad: " + this.g);
        }
    }

    @Override // com.applovin.impl.r6
    protected String f() {
        return "2.0/mcr";
    }

    @Override // com.applovin.impl.p6
    protected o4 h() {
        return this.g.h0();
    }

    @Override // com.applovin.impl.p6
    protected void i() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "No reward result was found for mediated ad: " + this.g);
        }
    }

    @Override // com.applovin.impl.r6
    protected void a(int i) {
        super.a(i);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Failed to report reward for mediated ad: " + this.g + " - error code: " + i);
        }
        this.f428a.P().a(d2.t0, this.g);
    }
}
