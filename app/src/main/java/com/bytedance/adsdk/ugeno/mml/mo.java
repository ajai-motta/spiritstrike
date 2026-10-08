package com.bytedance.adsdk.ugeno.mml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class mo {
    private qdl qdl;
    private List<qdl> ud;

    public qdl qdl() {
        return this.qdl;
    }

    public List<qdl> ud() {
        return this.ud;
    }

    public static class qdl {
        private String lnr = "global";
        private String mml;
        private Map<String, Object> mo;
        private Map<String, String> mzz;
        private String qdl;
        private String ud;

        public String qdl() {
            return this.lnr;
        }

        public void qdl(String str) {
            this.lnr = str;
        }

        public String ud() {
            return this.mml;
        }

        public void ud(String str) {
            this.mml = str;
        }

        public Map<String, String> lnr() {
            return this.mzz;
        }

        public void qdl(Map<String, String> map) {
            this.mzz = map;
        }

        public void lnr(String str) {
            this.qdl = str;
        }

        public String mml() {
            return this.qdl;
        }

        public void mml(String str) {
            this.ud = str;
        }

        public String mzz() {
            return this.ud;
        }

        public void ud(Map<String, Object> map) {
            this.mo = map;
        }

        public String toString() {
            return "Action{scheme='" + this.lnr + "', name='" + this.mml + "', params=" + this.mzz + ", host='" + this.ud + "', origin='" + this.qdl + "', extra=" + this.mo + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static mo qdl(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        mo moVar = new mo();
        String strOptString = jSONObject.optString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        moVar.qdl = fs.qdl(strOptString, jSONObject2);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            qdl qdlVarQdl = fs.qdl(jSONArrayOptJSONArray.optString(i), jSONObject2);
            if (qdlVarQdl != null) {
                arrayList.add(qdlVarQdl);
            }
        }
        moVar.ud = arrayList;
        return moVar;
    }
}
