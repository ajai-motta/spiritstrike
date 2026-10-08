package com.applovin.impl;

import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r6 extends j5 {
    protected r6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    protected abstract void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, q0.e eVar) {
        Map mapC = r0.c(this.f428a);
        if (((Boolean) this.f428a.a(y4.H5)).booleanValue() || ((Boolean) this.f428a.a(y4.A5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f428a).b(r0.b(f(), this.f428a)).a(r0.a(f(), this.f428a)).b(mapC).a(jSONObject).c("POST").b(((Boolean) this.f428a.a(y4.Q5)).booleanValue()).a((Object) new JSONObject()).a(g()).a(v4.a.a(((Integer) this.f428a.a(y4.y5)).intValue())).a(), this.f428a, eVar);
        aVar.c(y4.s0);
        aVar.b(y4.t0);
        this.f428a.r0().a(aVar);
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        String strE = this.f428a.x0().e();
        if (((Boolean) this.f428a.a(y4.G3)).booleanValue() && StringUtils.isValidString(strE)) {
            JsonUtils.putString(jSONObject, "cuid", strE);
        }
        if (((Boolean) this.f428a.a(y4.I3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f428a.u());
        }
        if (((Boolean) this.f428a.a(y4.K3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f428a.i0());
        }
        a(jSONObject);
        return jSONObject;
    }

    protected abstract String f();

    protected abstract int g();

    class a extends m6 {
        final /* synthetic */ q0.e m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, q0.e eVar) {
            super(aVar, kVar);
            this.m = eVar;
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            this.m.a(str, jSONObject, i);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            this.m.a(str, i, str2, jSONObject);
        }
    }

    protected void a(int i) {
        r0.a(i, this.f428a);
    }
}
