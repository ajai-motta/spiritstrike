package com.bytedance.sdk.openadsdk.core.fs;

import com.bytedance.sdk.openadsdk.core.fs.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.fs.ud.lnr;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private ljh fs;
    protected String jpc;
    protected qdl.EnumC0233qdl lnr;
    protected qdl.ud mml;
    protected List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> mo;
    protected String mzz;
    protected int qdl;
    private String to;
    protected int ud;
    protected List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> wd;
    private final AtomicBoolean rq = new AtomicBoolean(false);
    protected String tvp = "endcard_click";

    public lnr(int i, int i2, qdl.EnumC0233qdl enumC0233qdl, qdl.ud udVar, String str, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list2, String str2) {
        this.mo = new ArrayList();
        this.wd = new ArrayList();
        this.qdl = i;
        this.ud = i2;
        this.lnr = enumC0233qdl;
        this.mml = udVar;
        this.mzz = str;
        this.mo = list;
        this.wd = list2;
        this.jpc = str2;
    }

    public int ud() {
        return this.qdl;
    }

    public int lnr() {
        return this.ud;
    }

    public void qdl(long j) {
        com.bytedance.sdk.openadsdk.core.fs.ud.lnr.qdl(null, this.mo, null, j, this.to, new lnr.ud(this.tvp, this.fs), null);
    }

    public void ud(long j) {
        if (this.rq.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.fs.ud.lnr.ud((ljh) null, this.wd, (com.bytedance.sdk.openadsdk.core.fs.qdl.qdl) null, j, this.to, (String) null);
        }
    }

    public static float qdl(int i, int i2, int i3, int i4, qdl.ud udVar, qdl.EnumC0233qdl enumC0233qdl) {
        if (i2 == 0 || i4 == 0) {
            return 0.0f;
        }
        float f = i;
        float f2 = i3;
        return qdl(udVar, enumC0233qdl) / ((Math.abs((f / i2) - (f2 / i4)) + Math.abs((f - f2) / f)) + 1.0f);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.fs.lnr$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] qdl;

        static {
            int[] iArr = new int[qdl.ud.values().length];
            qdl = iArr;
            try {
                iArr[qdl.ud.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qdl[qdl.ud.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                qdl[qdl.ud.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static float qdl(qdl.ud udVar, qdl.EnumC0233qdl enumC0233qdl) {
        int i = AnonymousClass1.qdl[udVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (qdl.EnumC0233qdl.JAVASCRIPT.equals(enumC0233qdl)) {
            return 1.0f;
        }
        return qdl.EnumC0233qdl.IMAGE.equals(enumC0233qdl) ? 0.8f : 0.0f;
    }

    public String mml() {
        int i = AnonymousClass1.qdl[this.mml.ordinal()];
        if (i == 1) {
            if (this.lnr == qdl.EnumC0233qdl.IMAGE) {
                return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.mzz + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            }
            if (this.lnr != qdl.EnumC0233qdl.JAVASCRIPT) {
                return null;
            }
            return "<script src=\"" + this.mzz + "\"></script>";
        }
        if (i == 2) {
            return this.mzz;
        }
        if (i != 3) {
            return null;
        }
        return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.qdl + "\" height=\"" + this.ud + "\" src=\"" + this.mzz + "\"></iframe>";
    }

    public String mzz() {
        if (this.mml == qdl.ud.STATIC_RESOURCE && this.lnr == qdl.EnumC0233qdl.IMAGE) {
            return this.mzz;
        }
        return null;
    }

    public String mo() {
        return this.mzz;
    }

    public void qdl(String str) {
        this.to = str;
    }

    public static lnr ud(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int iOptInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        String strOptString = jSONObject.optString("creativeType", qdl.EnumC0233qdl.NONE.toString());
        String strOptString2 = jSONObject.optString("resourceType", qdl.ud.HTML_RESOURCE.toString());
        String strOptString3 = jSONObject.optString("contentUrl");
        String strOptString4 = jSONObject.optString("clickThroughUri");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(new lnr.qdl(jSONArrayOptJSONArray.optString(i)).qdl());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            arrayList2.add(new lnr.qdl(jSONArrayOptJSONArray2.optString(i2)).qdl());
        }
        return new lnr(iOptInt, iOptInt2, qdl.EnumC0233qdl.valueOf(strOptString), qdl.ud.valueOf(strOptString2), strOptString3, arrayList, arrayList2, strOptString4);
    }

    public JSONObject qdl() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.qdl);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.ud);
        jSONObject.put("creativeType", this.lnr.toString());
        jSONObject.put("resourceType", this.mml.toString());
        jSONObject.put("contentUrl", this.mzz);
        jSONObject.put("clickThroughUri", this.jpc);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.fs.ud.lnr.qdl(this.mo));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.fs.ud.lnr.qdl(this.wd));
        return jSONObject;
    }

    public void qdl(ljh ljhVar) {
        this.fs = ljhVar;
    }
}
