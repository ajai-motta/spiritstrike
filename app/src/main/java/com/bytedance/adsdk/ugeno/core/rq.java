package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class rq {
    private JSONObject lnr;
    private Map<String, Object> mml;
    private Context qdl;
    private JSONObject ud;

    public void qdl(Context context) {
        this.qdl = context;
    }

    public void qdl(JSONObject jSONObject) {
        this.ud = jSONObject;
    }

    public JSONObject qdl() {
        return this.lnr;
    }

    public void ud(JSONObject jSONObject) {
        this.lnr = jSONObject;
    }

    public Map<String, Object> ud() {
        return this.mml;
    }

    public void qdl(Map<String, Object> map) {
        this.mml = map;
    }
}
