package com.fyber.inneractive.sdk.response.nativead.parser;

import com.fyber.inneractive.sdk.response.nativead.h;
import com.fyber.inneractive.sdk.util.v;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static h a(JSONObject jSONObject) {
        h hVar = new h();
        if (jSONObject == null) {
            return hVar;
        }
        hVar.f1620a = v.a(jSONObject, "url");
        hVar.c = v.a(jSONObject, "fallback");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clicktrackers");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (strOptString != null && !strOptString.isEmpty() && !strOptString.equals(AbstractJsonLexerKt.NULL)) {
                    hVar.b.add(strOptString);
                }
            }
        }
        return hVar;
    }
}
