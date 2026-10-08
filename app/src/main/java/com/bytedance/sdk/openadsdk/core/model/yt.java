package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class yt {
    private qdl qdl;
    private qdl ud;

    public yt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_playable");
        if (jSONObjectOptJSONObject != null) {
            this.qdl = new qdl(jSONObjectOptJSONObject.optJSONObject("components"));
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("popup");
        if (jSONObjectOptJSONObject2 != null) {
            this.ud = new qdl(jSONObjectOptJSONObject2.optJSONObject("components"));
        }
    }

    public static boolean qdl(ljh ljhVar) {
        return qdl(ljhVar, false);
    }

    public static boolean qdl(ljh ljhVar, boolean z) {
        yt ytVarXv;
        if (ljhVar == null || (ytVarXv = ljhVar.xv()) == null) {
            return false;
        }
        if (z) {
            qdl qdlVar = ytVarXv.ud;
            return qdlVar != null && qdlVar.qdl();
        }
        qdl qdlVar2 = ytVarXv.qdl;
        return qdlVar2 != null && qdlVar2.qdl();
    }

    public static qdl ud(ljh ljhVar) {
        yt ytVarXv;
        if (ljhVar == null || (ytVarXv = ljhVar.xv()) == null) {
            return null;
        }
        return ytVarXv.ud;
    }

    public static qdl lnr(ljh ljhVar) {
        yt ytVarXv;
        if (ljhVar == null || (ytVarXv = ljhVar.xv()) == null) {
            return null;
        }
        return ytVarXv.qdl;
    }

    public static class qdl {
        C0240qdl qdl;
        C0240qdl ud;

        public qdl(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.has("vertical")) {
                this.qdl = new C0240qdl(jSONObject.optJSONObject("vertical"));
            }
            if (jSONObject.has("horizontal")) {
                this.ud = new C0240qdl(jSONObject.optJSONObject("horizontal"));
            }
        }

        public boolean qdl() {
            C0240qdl c0240qdl = this.ud;
            if (c0240qdl != null && c0240qdl.qdl()) {
                return true;
            }
            C0240qdl c0240qdl2 = this.qdl;
            return c0240qdl2 != null && c0240qdl2.qdl();
        }

        public String qdl(boolean z) {
            if (z) {
                C0240qdl c0240qdl = this.qdl;
                if (c0240qdl != null) {
                    return c0240qdl.qdl;
                }
                return "";
            }
            C0240qdl c0240qdl2 = this.ud;
            if (c0240qdl2 != null) {
                return c0240qdl2.qdl;
            }
            return "";
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.model.yt$qdl$qdl, reason: collision with other inner class name */
        public static class C0240qdl {
            String qdl;

            public C0240qdl(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.qdl = jSONObject.optString("entry");
            }

            public boolean qdl() {
                return !TextUtils.isEmpty(this.qdl);
            }
        }
    }
}
