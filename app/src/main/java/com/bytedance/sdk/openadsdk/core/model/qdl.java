package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private ljh fs;
    private String lnr;
    private uw mo;
    private ljh mzz;
    private String qdl;
    private String rq;
    private oth to;
    private int tvp;
    private int ud;
    private List<ljh> mml = new ArrayList();
    private JSONObject wd = new JSONObject();
    private volatile boolean jpc = false;

    public JSONObject qdl() {
        return this.wd;
    }

    public void qdl(JSONObject jSONObject) {
        this.wd = jSONObject;
    }

    public String ud() {
        ljh ljhVarMo = mo();
        if (ljhVarMo != null) {
            return ljhVarMo.cev();
        }
        return "";
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public int lnr() {
        return this.ud;
    }

    public void qdl(int i) {
        this.ud = i;
    }

    public void ud(String str) {
        this.lnr = str;
    }

    public List<ljh> mml() {
        return this.mml;
    }

    public void qdl(ljh ljhVar) {
        this.mml.add(ljhVar);
        if (this.fs == null) {
            this.fs = ljhVar;
        }
    }

    public void qdl(List<ljh> list) {
        this.mml = list;
        if (list.isEmpty()) {
            return;
        }
        this.fs = list.get(0);
    }

    public static Map<String, ljh> qdl(qdl qdlVar) {
        if (qdlVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (ljh ljhVar : qdlVar.mml()) {
            if (!TextUtils.isEmpty(ljhVar.xmr())) {
                map.put(ljhVar.xmr(), ljhVar);
            }
        }
        if (map.size() != 0) {
            return map;
        }
        return null;
    }

    public boolean mzz() {
        List<ljh> list = this.mml;
        return list != null && list.size() > 0;
    }

    public ljh mo() {
        if (this.mml.size() > 0) {
            return this.mml.get(0);
        }
        return null;
    }

    public oth wd() {
        return this.to;
    }

    public void qdl(oth othVar) {
        this.to = othVar;
    }

    public boolean jpc() {
        return this.jpc;
    }

    public void tvp() {
        this.jpc = false;
    }

    public void ud(int i) {
        this.tvp = i;
    }

    public boolean to() {
        return this.tvp == 1;
    }

    public ljh rq() {
        return this.fs;
    }

    public void qdl(uw uwVar) {
        this.mo = uwVar;
    }

    public uw fs() {
        return this.mo;
    }

    public JSONObject exu() {
        try {
            JSONObject jSONObject = new JSONObject();
            oth othVarWd = wd();
            if (othVarWd != null) {
                jSONObject.put("loop_config", othVarWd.rq());
            }
            uw uwVarFs = fs();
            if (uwVarFs != null) {
                jSONObject.put("multi_ad_config", uwVarFs.jl());
            }
            List<ljh> list = this.mml;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.mml.size(); i++) {
                    jSONArray.put(this.mml.get(i).rdz());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("multi_ad_style", this.tvp);
            jSONObject.put("request_id", this.qdl);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl("AdInfo", "toJsonObj: ", th);
            return null;
        }
    }

    public static qdl ud(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            qdl qdlVar = new qdl();
            qdlVar.qdl(oth.qdl(jSONObject.optJSONObject("loop_config")));
            qdlVar.ud(jSONObject.optInt("multi_ad_style", 0));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    ljh ljhVarQdl = com.bytedance.sdk.openadsdk.core.ud.qdl(jSONArrayOptJSONArray.optJSONObject(i), null, null, qdlVar, i);
                    if (ljhVarQdl != null) {
                        arrayList.add(ljhVarQdl);
                    }
                }
                qdlVar.qdl(arrayList);
            }
            qdlVar.qdl(jSONObject.optString("request_id", ""));
            String strOptString = jSONObject.optString("multi_ad_config");
            if (!TextUtils.isEmpty(strOptString)) {
                qdlVar.qdl(uw.qdl(strOptString));
            }
            return qdlVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl("AdInfo", "fromJson: ", th);
            return null;
        }
    }

    public void lnr(String str) {
        this.rq = str;
    }

    public String rdp() {
        return this.rq;
    }

    public ljh bjy() {
        return this.mzz;
    }

    public void ud(ljh ljhVar) {
        this.mzz = ljhVar;
    }
}
