package com.bytedance.sdk.openadsdk.bch.ud;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private final float lnr;
    private final int qdl;
    private final int ud;

    public qdl(int i, int i2, float f) {
        this.qdl = i;
        this.ud = i2;
        this.lnr = f;
    }

    public static JSONObject qdl(qdl qdlVar) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, qdlVar.qdl);
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, qdlVar.ud);
        jSONObject.put("alpha", qdlVar.lnr);
        return jSONObject;
    }
}
