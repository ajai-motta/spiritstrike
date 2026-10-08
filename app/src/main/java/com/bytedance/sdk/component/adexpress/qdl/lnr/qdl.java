package com.bytedance.sdk.component.adexpress.qdl.lnr;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private String lnr;
    private List<C0201qdl> mml;
    private String mo;
    private ud mzz;
    private String qdl;
    private String ud;
    private Map<String, qdl> wd = new ConcurrentHashMap();

    public Map<String, qdl> qdl() {
        return this.wd;
    }

    public String ud() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public String lnr() {
        return this.ud;
    }

    public void ud(String str) {
        this.ud = str;
    }

    public String mml() {
        return this.lnr;
    }

    public void lnr(String str) {
        this.lnr = str;
    }

    public void qdl(ud udVar) {
        this.mzz = udVar;
    }

    public ud mzz() {
        return this.mzz;
    }

    public List<C0201qdl> mo() {
        if (this.mml == null) {
            this.mml = new ArrayList();
        }
        return this.mml;
    }

    public void qdl(List<C0201qdl> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mml = list;
    }

    public void mml(String str) {
        this.mo = str;
    }

    public String wd() {
        return this.mo;
    }

    public boolean jpc() {
        return (TextUtils.isEmpty(mml()) || TextUtils.isEmpty(lnr()) || TextUtils.isEmpty(ud())) ? false : true;
    }

    public JSONObject tvp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", ud());
            jSONObject.putOpt("version", lnr());
            jSONObject.putOpt("main", mml());
            if (!TextUtils.isEmpty(this.mo)) {
                jSONObject.put("template_fetch_url", this.mo);
            }
            JSONArray jSONArray = new JSONArray();
            if (mo() != null) {
                for (C0201qdl c0201qdl : mo()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0201qdl.qdl());
                    jSONObject2.putOpt("md5", c0201qdl.ud());
                    jSONObject2.putOpt("level", Integer.valueOf(c0201qdl.lnr()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.wd.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.wd.keySet()) {
                    qdl qdlVar = this.wd.get(str);
                    if (qdlVar != null) {
                        jSONObject3.put(str, qdlVar.tvp());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            ud udVarMzz = mzz();
            if (udVarMzz != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", udVarMzz.qdl);
                jSONObject4.put("md5", udVarMzz.ud);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listUd = udVarMzz.ud();
                if (listUd != null) {
                    for (Pair<String, String> pair : listUd) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String to() {
        JSONObject jSONObjectTvp;
        if (!jpc() || (jSONObjectTvp = tvp()) == null) {
            return null;
        }
        return jSONObjectTvp.toString();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.qdl.lnr.qdl$qdl, reason: collision with other inner class name */
    public static class C0201qdl {
        private int lnr;
        private String qdl;
        private String ud;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0201qdl) {
                String str2 = this.qdl;
                if (str2 != null) {
                    C0201qdl c0201qdl = (C0201qdl) obj;
                    if (str2.equals(c0201qdl.qdl()) && (str = this.ud) != null && str.equals(c0201qdl.ud())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

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
    }

    public static class ud {
        private List<Pair<String, String>> lnr;
        private String qdl;
        private String ud;

        public String qdl() {
            return this.qdl;
        }

        public void qdl(String str) {
            this.qdl = str;
        }

        public void ud(String str) {
            this.ud = str;
        }

        public void qdl(List<Pair<String, String>> list) {
            this.lnr = list;
        }

        public List<Pair<String, String>> ud() {
            return this.lnr;
        }
    }

    public static qdl mzz(String str) {
        if (str == null) {
            return null;
        }
        try {
            return qdl(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static qdl qdl(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        qdl qdlVar = new qdl();
        qdlVar.qdl(jSONObject.optString("name"));
        qdlVar.ud(jSONObject.optString("version"));
        qdlVar.lnr(jSONObject.optString("main"));
        qdlVar.mml(jSONObject.optString("template_fetch_url", ""));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0201qdl c0201qdl = new C0201qdl();
                c0201qdl.qdl(jSONObjectOptJSONObject2.optString("url"));
                c0201qdl.ud(jSONObjectOptJSONObject2.optString("md5"));
                c0201qdl.qdl(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0201qdl);
            }
        }
        qdlVar.qdl(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    qdl qdlVarQdl = qdl(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (qdlVarQdl != null) {
                        qdlVar.qdl().put(next, qdlVarQdl);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            ud udVar = new ud();
            udVar.qdl(jSONObjectOptJSONObject.optString("url"));
            udVar.ud(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                udVar.qdl(arrayList2);
            }
            qdlVar.qdl(udVar);
        }
        if (qdlVar.jpc()) {
            return qdlVar;
        }
        return null;
    }
}
