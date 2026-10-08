package com.bytedance.sdk.openadsdk.rq.qdl;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class exu extends com.bytedance.sdk.component.qdl.mml<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.component.tvp.mo> qdl;

    public static void qdl(com.bytedance.sdk.component.qdl.bjy bjyVar, com.bytedance.sdk.component.tvp.mo moVar) {
        bjyVar.qdl("preventTouchEvent", new exu(moVar));
    }

    public exu(com.bytedance.sdk.component.tvp.mo moVar) {
        this.qdl = new WeakReference<>(moVar);
    }

    @Override // com.bytedance.sdk.component.qdl.mml
    public JSONObject qdl(String str, JSONObject jSONObject, com.bytedance.sdk.component.qdl.mzz mzzVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            com.bytedance.sdk.component.tvp.mo moVar = this.qdl.get();
            if (moVar != null) {
                moVar.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
