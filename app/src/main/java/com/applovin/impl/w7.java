package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f712a;
    private final String b;

    private w7(String str, String str2) {
        this.f712a = str;
        this.b = str2;
    }

    public static w7 a(q8 q8Var, com.applovin.impl.sdk.k kVar) {
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            return new w7((String) q8Var.a().get("apiFramework"), q8Var.d());
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("VastJavaScriptResource", "Error occurred while initializing", th);
            }
            kVar.D().a("VastJavaScriptResource", th);
            return null;
        }
    }

    public String b() {
        return this.f712a;
    }

    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        w7 w7Var = (w7) obj;
        String str = this.f712a;
        if (str == null ? w7Var.f712a != null : !str.equals(w7Var.f712a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = w7Var.b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f712a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.f712a + "', javascriptResourceUrl='" + this.b + "'}";
    }

    public static w7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        return new w7(JsonUtils.getString(jSONObject, "api_framework", null), JsonUtils.getString(jSONObject, "javascript_resource_url", null));
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "api_framework", this.f712a);
        JsonUtils.putString(jSONObject, "javascript_resource_url", this.b);
        return jSONObject;
    }
}
