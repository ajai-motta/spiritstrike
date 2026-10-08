package com.bytedance.adsdk.ugeno.core;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wd {
    private float jpc;
    private String lnr;
    private JSONObject mml;
    private JSONObject mo;
    private String mzz;
    private JSONObject qdl;
    private float tvp;
    private JSONObject ud;
    private boolean wd;

    public wd(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public wd(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.qdl = jSONObject.optJSONObject(TtmlNode.TAG_BODY);
            } else {
                this.qdl = jSONObject.optJSONObject("main_template");
            }
            this.ud = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has(Constants.REFERRER_API_META)) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject(Constants.REFERRER_API_META);
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has(TtmlNode.TAG_BODY)) {
                    this.wd = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.lnr = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.lnr = "3.0";
                    }
                } else {
                    this.lnr = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.mzz = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has(TtmlNode.TAG_BODY)) {
                this.lnr = "3.0";
                this.wd = true;
            }
            this.mml = jSONObject2;
            this.mo = jSONObject3;
        }
    }

    public qdl qdl() {
        return mzz();
    }

    public void qdl(float f, float f2) {
        this.jpc = f;
        this.tvp = f2;
    }

    private qdl mzz() {
        if (!mml()) {
            return qdl(this.qdl, (qdl) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "match_parent");
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "wrap_content");
            float f = this.jpc;
            if (f > 0.0f) {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, f);
            }
            float f2 = this.tvp;
            if (f2 > 0.0f) {
                jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, f2);
            }
            JSONObject jSONObject2 = this.mml;
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString("xSize");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    if (jSONObject3.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY) > 0) {
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, jSONObject3.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                    }
                    if (jSONObject3.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY) > 0) {
                        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, jSONObject3.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        qdl qdlVar = new qdl();
        qdlVar.ud = "View";
        qdlVar.qdl = "virtualNode";
        qdlVar.lnr = jSONObject;
        qdlVar.mo = null;
        qdlVar.wd = this.lnr;
        qdlVar.jpc = this.mzz;
        qdlVar.qdl(qdl(this.qdl, qdlVar));
        return qdlVar;
    }

    public String ud() {
        return this.lnr;
    }

    public List<qdl> lnr() {
        if (this.ud == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.ud.keys();
        while (itKeys.hasNext()) {
            qdl qdlVarQdl = qdl(this.ud.optJSONObject(itKeys.next()), (qdl) null);
            if (qdlVarQdl != null) {
                arrayList.add(qdlVarQdl);
            }
        }
        return arrayList;
    }

    private qdl qdl(JSONObject jSONObject, qdl qdlVar) {
        String strOptString;
        String strOptString2;
        qdl qdlVarQdl;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString("name");
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        qdl qdlVar2 = new qdl();
        qdlVar2.qdl = strOptString3;
        if (this.wd && TextUtils.equals("Video", strOptString)) {
            qdlVar2.ud = strOptString + "V3";
        } else {
            qdlVar2.ud = strOptString;
        }
        qdlVar2.lnr = jSONObject2;
        qdlVar2.mo = qdlVar;
        qdlVar2.wd = this.lnr;
        qdlVar2.jpc = this.mzz;
        if (jSONObject2.has("i18n")) {
            qdlVar2.mml = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            qdl(jSONObject, qdlVar2.lnr);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString("name");
                }
                String strQdl = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObjectOptJSONObject.optString("id"), this.mml);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.ud;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strQdl);
                        qdlVarQdl = qdl(jSONObjectOptJSONObject, qdlVar2);
                    } else {
                        qdlVarQdl = null;
                    }
                } else {
                    qdlVarQdl = qdl(jSONObjectOptJSONObject, qdlVar2);
                }
                if (qdlVarQdl != null) {
                    qdlVarQdl.ud(ud(qdlVarQdl));
                    qdlVarQdl.qdl(qdl(qdlVarQdl));
                }
                if (lnr(qdlVarQdl)) {
                    i++;
                    qdlVar2.ud(qdlVarQdl);
                } else if (qdlVarQdl != null) {
                    qdlVar2.qdl(i2 - i, qdlVarQdl);
                }
            }
        }
        return qdlVar2;
    }

    public boolean qdl(qdl qdlVar) {
        JSONObject jSONObjectMml;
        if (qdlVar == null || (jSONObjectMml = qdlVar.mml()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectMml.optString(ViewHierarchyConstants.DIMENSION_WIDTH_KEY), "match_parent");
    }

    public boolean ud(qdl qdlVar) {
        JSONObject jSONObjectMml;
        if (qdlVar == null || (jSONObjectMml = qdlVar.mml()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectMml.optString(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY), "match_parent");
    }

    public boolean lnr(qdl qdlVar) {
        JSONObject jSONObjectMml;
        if (qdlVar == null || (jSONObjectMml = qdlVar.mml()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectMml.optString("position"), com.facebook.appevents.codeless.internal.Constants.PATH_TYPE_ABSOLUTE);
    }

    public boolean mml() {
        return this.wd;
    }

    private void qdl(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.mo == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.mo.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.wd.ud.qdl(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean mml(qdl qdlVar) {
        return (qdlVar == null || qdlVar.lnr == null) ? false : true;
    }

    public static class qdl {
        private String jpc;
        private JSONObject lnr;
        private JSONObject mml;
        private qdl mo;
        private LinkedList<qdl> mzz;
        private String qdl;
        private boolean to;
        private boolean tvp;
        private String ud;
        private String wd;

        public String qdl() {
            return this.qdl;
        }

        public String ud() {
            return this.wd;
        }

        public String lnr() {
            return this.ud;
        }

        public void qdl(String str) {
            this.ud = str;
        }

        public void qdl(boolean z) {
            this.tvp = z;
        }

        public void ud(boolean z) {
            this.to = z;
        }

        public JSONObject mml() {
            return this.lnr;
        }

        public List<qdl> mzz() {
            return this.mzz;
        }

        public void qdl(qdl qdlVar) {
            if (this.mzz == null) {
                this.mzz = new LinkedList<>();
            }
            this.mzz.add(qdlVar);
        }

        public void ud(qdl qdlVar) {
            if (this.mzz == null) {
                this.mzz = new LinkedList<>();
            }
            this.mzz.addLast(qdlVar);
        }

        public void qdl(int i, qdl qdlVar) {
            if (this.mzz == null) {
                this.mzz = new LinkedList<>();
            }
            this.mzz.add(i, qdlVar);
        }

        public JSONObject mo() {
            return this.mml;
        }

        public String toString() {
            return "UGNode{id='" + this.qdl + "', name='" + this.ud + "'}";
        }
    }
}
