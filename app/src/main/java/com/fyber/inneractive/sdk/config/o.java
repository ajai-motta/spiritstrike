package com.fyber.inneractive.sdk.config;

import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f965a = new HashMap();
    public final HashMap b = new HashMap();

    public final String a(String str, String str2) {
        return this.f965a.containsKey(str) ? (String) this.f965a.get(str) : str2;
    }

    public final int b(String str, int i, int i2) {
        int i3;
        try {
            i3 = Integer.parseInt(a(str, Integer.toString(i)));
        } catch (Throwable unused) {
            i3 = i;
        }
        return (i3 < i2 || i3 > 30) ? i : i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f965a.equals(oVar.f965a) && this.b.equals(oVar.b);
    }

    public final int hashCode() {
        return this.f965a.hashCode();
    }

    public static o a(JSONObject jSONObject) {
        o oVar = new o();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("overrides");
        JSONArray jSONArrayNames = jSONObjectOptJSONObject.names();
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String strOptString = jSONArrayNames.optString(i, null);
            String strOptString2 = jSONObjectOptJSONObject.optString(strOptString, null);
            if (strOptString != null && strOptString2 != null) {
                oVar.f965a.put(strOptString, strOptString2);
            }
        }
        if (jSONObjectOptJSONObject2 != null) {
            JSONArray jSONArrayNames2 = jSONObjectOptJSONObject2.names();
            for (int i2 = 0; i2 < jSONArrayNames2.length(); i2++) {
                String strOptString3 = jSONArrayNames2.optString(i2, null);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(strOptString3);
                if (strOptString3 != null && jSONObjectOptJSONObject3 != null) {
                    oVar.b.put(strOptString3, new m(jSONObjectOptJSONObject3));
                }
            }
        }
        return oVar;
    }

    public final int a(String str, int i, int i2) {
        try {
            i = Integer.parseInt(a(str, Integer.toString(i)));
        } catch (Throwable unused) {
        }
        return Math.max(i, i2);
    }

    public final boolean a(boolean z, String str) {
        try {
            return Boolean.parseBoolean(a(str, Boolean.toString(z)));
        } catch (Throwable unused) {
            return z;
        }
    }

    public final l a(String str) {
        m mVar;
        String str2 = IAConfigManager.O.d;
        if (this.b.containsKey(str2)) {
            mVar = (m) this.b.get(str2);
        } else {
            mVar = new m();
        }
        mVar.getClass();
        return mVar.f963a.containsKey(str) ? (l) mVar.f963a.get(str) : new l();
    }
}
