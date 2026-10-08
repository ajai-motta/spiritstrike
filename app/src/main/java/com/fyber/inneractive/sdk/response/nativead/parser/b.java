package com.fyber.inneractive.sdk.response.nativead.parser;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (strOptString != null && !strOptString.isEmpty() && !strOptString.equals(AbstractJsonLexerKt.NULL)) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }
}
