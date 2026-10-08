package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v4;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class k5 extends j5 {
    k5(com.applovin.impl.sdk.k kVar) {
        super("TaskApiSubmitData", kVar);
    }

    private void b(JSONObject jSONObject) {
        com.applovin.impl.sdk.l lVarA = this.f428a.A();
        Map mapP = lVarA.p();
        o7.a("platform", "type", mapP);
        o7.a("api_level", "sdk_version", mapP);
        JsonUtils.putObject(jSONObject, DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(mapP));
        Map mapF = lVarA.F();
        o7.a("sdk_version", "applovin_sdk_version", mapF);
        o7.a("ia", "installed_at", mapF);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(mapF));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d(this.b, "Submitting user data...");
        }
        Map mapC = r0.c(this.f428a);
        JSONObject jSONObject = new JSONObject();
        b(jSONObject);
        if (((Boolean) this.f428a.a(y4.G5)).booleanValue() || ((Boolean) this.f428a.a(y4.A5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) mapC);
            mapC = null;
        }
        a(mapC, jSONObject);
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            k5.this.a(jSONObject);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            r0.a(i, this.f428a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.f428a.p0().a(y4.f, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.f428a.p0().a(y4.j, JsonUtils.getString(jSONObject2, "device_token", ""));
        r0.a(jSONObject2, this.f428a);
    }

    private void a(Map map, JSONObject jSONObject) {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f428a).b(r0.b("2.0/device", this.f428a)).a(r0.a("2.0/device", this.f428a)).b(map).a(jSONObject).c("POST").b(((Boolean) this.f428a.a(y4.N5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f428a.a(y4.e3)).intValue()).a(v4.a.a(((Integer) this.f428a.a(y4.x5)).intValue())).a(), this.f428a);
        aVar.c(y4.s0);
        aVar.b(y4.t0);
        this.f428a.r0().a(aVar);
    }
}
