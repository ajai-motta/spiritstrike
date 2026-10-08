package com.bytedance.sdk.openadsdk.aaj.ud;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private List<C0220qdl> lnr;
    private String qdl;
    private List<C0220qdl> ud;

    public void qdl(String str) {
        this.qdl = str;
    }

    public void qdl(List<C0220qdl> list) {
        this.ud = list;
    }

    public void ud(List<C0220qdl> list) {
        this.lnr = list;
    }

    public String qdl() {
        return this.qdl;
    }

    public List<C0220qdl> ud() {
        return this.ud;
    }

    public List<C0220qdl> lnr() {
        return this.lnr;
    }

    public static qdl ud(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            qdl qdlVar = new qdl();
            qdlVar.qdl(jSONObject.optString("version"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    C0220qdl c0220qdlQdl = C0220qdl.qdl(jSONArrayOptJSONArray.optJSONObject(i));
                    if (c0220qdlQdl != null) {
                        if (c0220qdlQdl.lnr == 1) {
                            arrayList.add(c0220qdlQdl);
                        } else if (c0220qdlQdl.lnr == 2 && arrayList2.size() < 10) {
                            arrayList2.add(c0220qdlQdl);
                        }
                    }
                }
            }
            qdlVar.qdl(arrayList);
            qdlVar.ud(arrayList2);
            return qdlVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.aaj.ud.qdl$qdl, reason: collision with other inner class name */
    public static class C0220qdl {
        private int lnr;
        private String qdl;
        private String ud;

        public static C0220qdl qdl(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0220qdl c0220qdl = new C0220qdl();
            c0220qdl.qdl = jSONObject.optString("url");
            c0220qdl.ud = jSONObject.optString("md5");
            c0220qdl.lnr = jSONObject.optInt("type");
            return c0220qdl;
        }

        public String qdl() {
            return this.qdl;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0220qdl) {
                String str2 = this.qdl;
                if (str2 != null) {
                    C0220qdl c0220qdl = (C0220qdl) obj;
                    if (str2.equals(c0220qdl.qdl) && (str = this.ud) != null && str.equals(c0220qdl.ud)) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }
    }
}
