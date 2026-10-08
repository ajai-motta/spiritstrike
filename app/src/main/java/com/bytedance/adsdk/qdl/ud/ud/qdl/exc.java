package com.bytedance.adsdk.qdl.ud.ud.qdl;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class exc implements com.bytedance.adsdk.qdl.ud.ud.ud {
    private com.bytedance.adsdk.qdl.ud.ud.qdl lnr;
    private com.bytedance.adsdk.qdl.ud.ud.qdl qdl;
    private com.bytedance.adsdk.qdl.ud.ud.qdl ud;

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public Object qdl(Map<String, JSONObject> map) {
        Object objQdl = this.qdl.qdl(map);
        if (objQdl == null) {
            return null;
        }
        if (((Boolean) objQdl).booleanValue()) {
            return this.ud.qdl(map);
        }
        return this.lnr.qdl(map);
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public com.bytedance.adsdk.qdl.ud.mml.mzz qdl() {
        return com.bytedance.adsdk.qdl.ud.mml.mo.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.ud
    public void qdl(com.bytedance.adsdk.qdl.ud.ud.qdl qdlVar) {
        this.qdl = qdlVar;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.ud
    public void ud(com.bytedance.adsdk.qdl.ud.ud.qdl qdlVar) {
        this.ud = qdlVar;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.ud
    public void lnr(com.bytedance.adsdk.qdl.ud.ud.qdl qdlVar) {
        this.lnr = qdlVar;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public String ud() {
        return this.qdl.ud() + "?" + this.ud.ud() + ":" + this.lnr.ud();
    }

    public String toString() {
        return ud();
    }
}
