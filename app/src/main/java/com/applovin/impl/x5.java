package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x5 extends j5 {
    private final q0.e g;

    public x5(q0.e eVar, com.applovin.impl.sdk.k kVar) {
        super("TaskFetchMediationDebuggerInfo", kVar, true);
        this.g = eVar;
    }

    protected Map e() {
        HashMap map = new HashMap();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.f428a.a(y4.l5)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f428a.j0());
        }
        Map mapF = this.f428a.A().F();
        map.put("package_name", String.valueOf(mapF.get("package_name")));
        map.put("app_version", String.valueOf(mapF.get("app_version")));
        Map mapM = this.f428a.A().M();
        map.put("platform", String.valueOf(mapM.get("platform")));
        map.put("os", String.valueOf(mapM.get("os")));
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map mapE = e();
        JSONObject jSONObjectA = a(a());
        if (((Boolean) this.f428a.a(y4.D5)).booleanValue() || ((Boolean) this.f428a.a(y4.A5)).booleanValue()) {
            JsonUtils.putAll(jSONObjectA, (Map<String, ?>) mapE);
            mapE = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f428a).c("POST").b(l3.i(this.f428a)).a(l3.h(this.f428a)).b(mapE).a(jSONObjectA).a((Object) new JSONObject()).c(((Long) this.f428a.a(r3.y7)).intValue()).a(v4.a.a(((Integer) this.f428a.a(y4.s5)).intValue())).a(), this.f428a, d());
        aVar.c(r3.u7);
        aVar.b(r3.v7);
        this.f428a.r0().a(aVar);
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z) {
            super(aVar, kVar, z);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            x5.this.g.a(str, jSONObject, i);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            x5.this.g.a(str, i, str2, jSONObject);
        }
    }

    private JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", w3.b(this.f428a));
        JsonUtils.putBoolean(jSONObject, "is_tablet", AppLovinSdkUtils.isTablet(context));
        v.a aVarF = this.f428a.A().f();
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVarF.b().b());
        JsonUtils.putStringIfValid(jSONObject, "idfa", aVarF.a());
        Map mapL0 = this.f428a.l0();
        if (!CollectionUtils.isEmpty(mapL0)) {
            JsonUtils.putJSONObject(jSONObject, "segments", new JSONObject(mapL0));
        }
        return jSONObject;
    }
}
