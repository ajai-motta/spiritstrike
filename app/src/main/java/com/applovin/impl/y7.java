package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y7 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f727a;
    private String b;

    private y7() {
    }

    public static y7 a(q8 q8Var, y7 y7Var, com.applovin.impl.sdk.k kVar) {
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (y7Var == null) {
            try {
                y7Var = new y7();
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastSystemInfo", "Error occurred while initializing", th);
                }
                kVar.D().a("VastSystemInfo", th);
                return null;
            }
        }
        if (!StringUtils.isValidString(y7Var.f727a)) {
            String strD = q8Var.d();
            if (StringUtils.isValidString(strD)) {
                y7Var.f727a = strD;
            }
        }
        if (!StringUtils.isValidString(y7Var.b)) {
            String str = (String) q8Var.a().get("version");
            if (StringUtils.isValidString(str)) {
                y7Var.b = str;
            }
        }
        return y7Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y7)) {
            return false;
        }
        y7 y7Var = (y7) obj;
        String str = this.f727a;
        if (str == null ? y7Var.f727a != null : !str.equals(y7Var.f727a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = y7Var.b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.f727a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f727a + "', version='" + this.b + "'}";
    }

    public static y7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        y7 y7Var = new y7();
        y7Var.f727a = JsonUtils.getString(jSONObject, "name", null);
        y7Var.b = JsonUtils.getString(jSONObject, "version", null);
        return y7Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", this.f727a);
        JsonUtils.putString(jSONObject, "version", this.b);
        return jSONObject;
    }
}
