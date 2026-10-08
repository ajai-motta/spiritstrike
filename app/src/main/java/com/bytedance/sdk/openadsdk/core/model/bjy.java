package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bjy {
    private final int qdl;
    private final int ud;

    public bjy(JSONObject jSONObject) {
        this.qdl = jSONObject.optInt("auto_click", 0);
        this.ud = jSONObject.optInt("hidden_bar", 0);
    }

    public int qdl() {
        return this.qdl;
    }

    public boolean ud() {
        return this.ud == 1;
    }

    public JSONObject lnr() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = this.qdl;
            if (i == 1) {
                jSONObject.put("auto_click", i);
            }
            if (this.ud == 1) {
                jSONObject.put("hidden_bar", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean qdl(ljh ljhVar) {
        if (ljhVar == null || !ljhVar.uj() || ljhVar.yfh() == null) {
            return false;
        }
        return ljhVar.yfh().ud();
    }
}
