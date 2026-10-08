package com.fyber.inneractive.sdk.config.global;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f952a;

    public o(JSONObject jSONObject) {
        this.f952a = jSONObject;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Integer a(String str) {
        if (this.f952a.has(str)) {
            try {
                return Integer.valueOf(this.f952a.getInt(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final String b(String str) {
        if (this.f952a.has(str)) {
            try {
                return this.f952a.getString(str);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Boolean c(String str) {
        if (this.f952a.has(str)) {
            try {
                return Boolean.valueOf(this.f952a.getBoolean(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final String toString() {
        JSONObject jSONObject = this.f952a;
        return jSONObject != null ? jSONObject.toString() : "no params";
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final String a(String str, String str2) {
        return this.f952a.optString(str, str2);
    }

    @Override // com.fyber.inneractive.sdk.config.global.n
    public final Map a() {
        HashMap map = new HashMap();
        Iterator<String> itKeys = this.f952a.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, this.f952a.get(next));
            } catch (Exception unused) {
            }
        }
        return map;
    }
}
