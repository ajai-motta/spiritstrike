package com.bytedance.adsdk.qdl.ud.ud.qdl;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class oth implements com.bytedance.adsdk.qdl.ud.ud.qdl {
    private final String qdl;

    public oth(String str) {
        this.qdl = str;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public Object qdl(Map<String, JSONObject> map) {
        Object objQdl;
        if (map == null || map.size() <= 0 || (objQdl = qdl(this.qdl, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objQdl;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public com.bytedance.adsdk.qdl.ud.mml.mzz qdl() {
        return com.bytedance.adsdk.qdl.ud.mml.mo.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.qdl + "]";
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public String ud() {
        return this.qdl;
    }

    public Object qdl(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return qdl(str.split("\\."), 0, jSONObject);
    }

    private Object qdl(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return qdl(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException unused2) {
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return qdl(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
