package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n6 extends p6 {
    private final com.applovin.impl.sdk.ad.b g;

    public n6(com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar) {
        super("TaskReportAppLovinReward", kVar);
        this.g = bVar;
    }

    @Override // com.applovin.impl.r6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.g.getAdZone().e());
        JsonUtils.putInt(jSONObject, "fire_percent", this.g.P());
        String clCode = this.g.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.p6
    protected void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Reported reward successfully for ad: " + this.g);
        }
    }

    @Override // com.applovin.impl.r6
    protected String f() {
        return "2.0/cr";
    }

    @Override // com.applovin.impl.p6
    protected o4 h() {
        return this.g.i();
    }

    @Override // com.applovin.impl.p6
    protected void i() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "No reward result was found for ad: " + this.g);
        }
    }

    @Override // com.applovin.impl.r6
    protected void a(int i) {
        super.a(i);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Failed to report reward for ad: " + this.g + " - error code: " + i);
        }
        this.f428a.g().a(d2.G, this.g);
    }
}
