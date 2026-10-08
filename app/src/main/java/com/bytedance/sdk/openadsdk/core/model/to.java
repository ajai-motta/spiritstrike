package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class to {
    private String qdl;
    private List<String> ud;

    public to(String str) {
        this.qdl = "";
        this.ud = new ArrayList();
        HashMap<String, Object> map = TextUtils.isEmpty(str) ? new HashMap<>() : qdl(str);
        try {
            this.qdl = (String) map.get("auto_test_param");
            JSONArray jSONArray = new JSONArray((String) map.get("auto_test_hosts"));
            this.ud = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.ud.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr("AutoTestModel", e.getMessage());
        }
    }

    public String qdl() {
        return this.qdl;
    }

    public List<String> ud() {
        return this.ud;
    }

    private static final HashMap<String, Object> qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                map.put(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.optString("value"));
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }
}
