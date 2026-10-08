package com.applovin.impl;

import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p6 extends r6 {
    protected p6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    private JSONObject a(o4 o4Var) {
        JSONObject jSONObjectE = e();
        JsonUtils.putString(jSONObjectE, "result", o4Var.b());
        Map mapA = o4Var.a();
        if (mapA != null) {
            JsonUtils.putJSONObject(jSONObjectE, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(mapA));
        }
        return jSONObjectE;
    }

    protected abstract void b(JSONObject jSONObject);

    @Override // com.applovin.impl.r6
    protected int g() {
        return ((Integer) this.f428a.a(y4.k1)).intValue();
    }

    protected abstract o4 h();

    protected abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        o4 o4VarH = h();
        if (o4VarH == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Pending reward not found");
            }
            i();
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Reporting pending reward: " + o4VarH + "...");
        }
        a(a(o4VarH), new a());
    }

    class a implements q0.e {
        a() {
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            p6.this.b(jSONObject);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            p6.this.a(i);
        }
    }
}
