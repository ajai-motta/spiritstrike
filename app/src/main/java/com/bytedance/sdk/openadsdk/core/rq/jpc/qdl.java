package com.bytedance.sdk.openadsdk.core.rq.jpc;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private String lnr;
    private String mml;
    private String mzz;
    private String qdl;
    private String ud;

    public String qdl() {
        return this.qdl;
    }

    public qdl qdl(String str) {
        this.qdl = str;
        return this;
    }

    public String ud() {
        return this.ud;
    }

    public qdl ud(String str) {
        this.ud = str;
        return this;
    }

    public String lnr() {
        return this.lnr;
    }

    public qdl lnr(String str) {
        this.lnr = str;
        return this;
    }

    public String mml() {
        return this.mml;
    }

    public qdl mml(String str) {
        this.mml = str;
        return this;
    }

    public String mzz() {
        return this.mzz;
    }

    public qdl mzz(String str) {
        this.mzz = str;
        return this;
    }

    public JSONObject qdl(qdl qdlVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.qdl);
            jSONObject.put("md5", this.ud);
            jSONObject.put("url", this.lnr);
            if (qdlVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", qdlVar.qdl());
                jSONObject2.put("md5", qdlVar.ud());
                jSONObject2.put("url", qdlVar.lnr());
                jSONObject.put("overlay", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
