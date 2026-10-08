package com.digitalturbine.ignite.authenticator.parsers;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static com.digitalturbine.ignite.authenticator.entities.a a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        String str = "";
        boolean z = true;
        try {
        } catch (Exception e) {
            e = e;
        }
        if (!jSONObject.has("data") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            z = false;
        } else {
            String strOptString = jSONObjectOptJSONObject.optString("igniteVersion", "");
            try {
                if (jSONObjectOptJSONObject.has("features") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("features")) != null) {
                    for (int length = jSONArrayOptJSONArray.length() - 1; length >= 0; length--) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(length);
                        if (jSONObjectOptJSONObject2.has("type") && "GET_PROPERTY".equalsIgnoreCase(jSONObjectOptJSONObject2.optString("type", ""))) {
                            str = strOptString;
                            break;
                        }
                    }
                }
                str = strOptString;
            } catch (Exception e2) {
                e = e2;
                str = strOptString;
                com.digitalturbine.ignite.authenticator.logger.a.b("IgniteVersionParser: exception on parse: %s", e.getMessage());
            }
            z = false;
        }
        return new com.digitalturbine.ignite.authenticator.entities.a(z, str);
    }
}
