package com.applovin.impl;

import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v;
import com.applovin.impl.v4;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t6 extends j5 {
    private final p2 g;
    private final Exception h;

    public t6(com.applovin.impl.sdk.k kVar, p2 p2Var, Exception exc) {
        super("TaskValidateLicense", kVar);
        this.g = p2Var;
        this.h = exc;
    }

    private String e() {
        return r0.a((String) this.f428a.a(y4.A0), (String) this.f428a.a(y4.B0), this.f428a);
    }

    private JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        v.a aVarF = this.f428a.A().f();
        JsonUtils.putBoolean(jSONObject, "dnt", aVarF.c());
        JsonUtils.putString(jSONObject, "dnt_code", aVarF.b().b());
        if (((Boolean) this.f428a.a(y4.D3)).booleanValue() && StringUtils.isValidString(aVarF.a())) {
            JsonUtils.putString(jSONObject, "idfa", aVarF.a());
        }
        l.b bVarG = this.f428a.A().G();
        if (((Boolean) this.f428a.a(y4.E3)).booleanValue() && bVarG != null) {
            JsonUtils.putString(jSONObject, "idfv", bVarG.f644a);
            JsonUtils.putInt(jSONObject, "idfv_scope", bVarG.b);
        }
        String strE = this.f428a.x0().e();
        if (((Boolean) this.f428a.a(y4.F3)).booleanValue() && StringUtils.isValidString(strE)) {
            JsonUtils.putString(jSONObject, "cuid", strE);
        }
        if (((Boolean) this.f428a.a(y4.I3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f428a.u());
        }
        if (((Boolean) this.f428a.a(y4.K3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f428a.i0());
        }
        JsonUtils.putAll(jSONObject, (Map<String, ?>) this.f428a.A().e());
        JSONObject jSONObject2 = new JSONObject();
        p2 p2Var = this.g;
        if (p2Var != null) {
            JsonUtils.putString(jSONObject2, "lsig", p2Var.d());
            JsonUtils.putString(jSONObject2, "lsigd", this.g.e());
            JsonUtils.putInt(jSONObject2, "r_code", this.g.c());
            JsonUtils.putInt(jSONObject2, "n", this.g.b());
        }
        Exception exc = this.h;
        if (exc != null) {
            JsonUtils.putStringIfValid(jSONObject2, "lvfr", exc.toString());
        }
        JsonUtils.putObject(jSONObject, "lvd", jSONObject2);
        return jSONObject;
    }

    private String g() {
        return r0.a((String) this.f428a.a(y4.z0), (String) this.f428a.a(y4.B0), this.f428a);
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f428a).b(g()).a(e()).a(f()).c("POST").b(((Boolean) this.f428a.a(y4.R5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f428a.a(y4.y3)).intValue()).a(v4.a.a(((Integer) this.f428a.a(y4.z5)).intValue())).a(), this.f428a);
        aVar.c(y4.z0);
        aVar.b(y4.A0);
        this.f428a.r0().a(aVar);
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "License Validation successful");
            }
            b5.b(a5.i, Boolean.FALSE, com.applovin.impl.sdk.k.o());
            Map map = CollectionUtils.map("code", String.valueOf(i));
            CollectionUtils.putStringIfValid("url", str, map);
            this.f428a.w0().d(d2.k, map);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to validate license: ");
            }
            if (!this.f428a.c(y4.A).contains(String.valueOf(i))) {
                b5.b(a5.i, Boolean.FALSE, com.applovin.impl.sdk.k.o());
            }
            Map map = CollectionUtils.map(NativeProtocol.BRIDGE_ARG_ERROR_CODE, String.valueOf(i));
            CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2, map);
            CollectionUtils.putStringIfValid("url", str, map);
            this.f428a.w0().d(d2.l, map);
        }
    }
}
