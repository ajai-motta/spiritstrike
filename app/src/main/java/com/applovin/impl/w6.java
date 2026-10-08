package com.applovin.impl;

import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w6 extends r6 {
    protected w6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    private o4 b(JSONObject jSONObject) {
        Map<String, String> mapEmptyMap;
        String string;
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        r0.c(jSONObject2, this.f428a);
        r0.b(jSONObject, this.f428a);
        r0.a(jSONObject, this.f428a);
        try {
            mapEmptyMap = JsonUtils.toStringMap((JSONObject) jSONObject2.get(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Throwable unused) {
            mapEmptyMap = Collections.emptyMap();
        }
        try {
            string = jSONObject2.getString("result");
        } catch (Throwable unused2) {
            string = "network_timeout";
        }
        return o4.a(string, mapEmptyMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        o4 o4VarB = b(jSONObject);
        a(o4VarB);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Pending reward handled: " + o4VarB);
        }
    }

    protected abstract void a(o4 o4Var);

    @Override // com.applovin.impl.r6
    protected int g() {
        return ((Integer) this.f428a.a(y4.j1)).intValue();
    }

    protected abstract boolean h();

    @Override // java.lang.Runnable
    public void run() {
        a(e(), new a());
    }

    class a implements q0.e {
        a() {
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (w6.this.h()) {
                com.applovin.impl.sdk.o oVar = w6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    w6 w6Var = w6.this;
                    w6Var.c.b(w6Var.b, "Reward validation succeeded with code " + i + " but task was cancelled already");
                }
                com.applovin.impl.sdk.o oVar2 = w6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    w6 w6Var2 = w6.this;
                    w6Var2.c.b(w6Var2.b, "Response: " + jSONObject);
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.o oVar3 = w6.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                w6 w6Var3 = w6.this;
                w6Var3.c.a(w6Var3.b, "Reward validation succeeded with code " + i + " and response: " + jSONObject);
            }
            w6.this.c(jSONObject);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            if (w6.this.h()) {
                com.applovin.impl.sdk.o oVar = w6.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    w6 w6Var = w6.this;
                    w6Var.c.b(w6Var.b, "Reward validation failed with error code " + i + " but task was cancelled already");
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.o oVar2 = w6.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                w6 w6Var2 = w6.this;
                w6Var2.c.b(w6Var2.b, "Reward validation failed with code " + i + " and error: " + str2);
            }
            w6.this.a(i);
        }
    }
}
