package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class exu {
    private int lnr;
    private String qdl;
    private String ud;

    public String qdl() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public String ud() {
        return this.ud;
    }

    public void ud(String str) {
        this.ud = str;
    }

    public int lnr() {
        return this.lnr;
    }

    public void qdl(int i) {
        this.lnr = i;
    }

    public JSONObject mml() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("u", this.qdl);
            jSONObject.put("ft", this.lnr);
            jSONObject.put("fu", this.ud);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
