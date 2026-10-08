package com.bytedance.sdk.component.jpc.ud;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public int lnr;
    public int mml;
    public int qdl;
    public int ud;

    public qdl(int i, int i2, int i3, int i4) {
        this.qdl = i;
        this.ud = i2;
        this.lnr = i3;
        this.mml = i4;
    }

    public JSONObject qdl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.qdl);
            jSONObject.put("sdk_max_thread_num", this.ud);
            jSONObject.put("app_thread_num", this.lnr);
            jSONObject.put("app_max_thread_num", this.mml);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
