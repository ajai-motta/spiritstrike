package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f963a = new HashMap();

    public m() {
    }

    public m(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        JSONArray jSONArrayNames2 = jSONObject.names();
        for (int i = 0; i < jSONArrayNames2.length(); i++) {
            String strOptString = jSONArrayNames2.optString(i, null);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
            l lVar = new l();
            if (jSONObjectOptJSONObject != null && (jSONArrayNames = jSONObjectOptJSONObject.names()) != null) {
                for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
                    String strOptString2 = jSONArrayNames.optString(i2, null);
                    String strOptString3 = jSONObjectOptJSONObject.optString(strOptString2, null);
                    if (strOptString2 != null && strOptString3 != null) {
                        lVar.f961a.put(strOptString2, strOptString3);
                    }
                }
            }
            this.f963a.put(strOptString, lVar);
        }
    }
}
