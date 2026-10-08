package com.bytedance.sdk.component.qdl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class wd {
    private to qdl;

    static wd qdl(to toVar) {
        return new wd(toVar);
    }

    private wd(to toVar) {
        this.qdl = toVar;
    }

    <T> T qdl(String str, Type type) throws JSONException {
        qdl(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.qdl.qdl(str, type);
    }

    <T> String qdl(T t) {
        String string;
        if (t == null) {
            return JsonUtils.EMPTY_JSON;
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.qdl.qdl(t);
        }
        qdl(string);
        return string;
    }

    private static void qdl(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        jpc.qdl(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
