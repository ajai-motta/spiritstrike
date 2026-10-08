package com.bytedance.sdk.openadsdk.rq.qdl;

import com.bytedance.sdk.component.qdl.lnr;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rdp extends com.bytedance.sdk.component.qdl.lnr<JSONObject, JSONObject> {
    private long lnr;
    private HashSet<Integer> mml = new HashSet<>();
    private WeakReference<hkc> qdl;
    private ljh ud;

    public static void qdl(com.bytedance.sdk.component.qdl.bjy bjyVar, final hkc hkcVar, final ljh ljhVar) {
        bjyVar.qdl("requestDelayCallback", new lnr.ud() { // from class: com.bytedance.sdk.openadsdk.rq.qdl.rdp.1
            @Override // com.bytedance.sdk.component.qdl.lnr.ud
            public com.bytedance.sdk.component.qdl.lnr qdl() {
                return new rdp(hkcVar, ljhVar);
            }
        });
    }

    public rdp(hkc hkcVar, ljh ljhVar) {
        this.qdl = new WeakReference<>(hkcVar);
        this.ud = ljhVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.qdl.lnr
    public void qdl(JSONObject jSONObject, com.bytedance.sdk.component.qdl.mzz mzzVar) throws Exception {
        hkc hkcVar = this.qdl.get();
        if (hkcVar == null || jSONObject == null) {
            lnr();
            return;
        }
        hkcVar.qdl(new com.bytedance.sdk.openadsdk.fs.ud() { // from class: com.bytedance.sdk.openadsdk.rq.qdl.rdp.2
            @Override // com.bytedance.sdk.openadsdk.fs.ud
            public void qdl(int i) {
                rdp.this.mml.add(Integer.valueOf(i));
                if (rdp.this.mml.size() >= rdp.this.lnr) {
                    try {
                        rdp.this.qdl(new JSONObject());
                        rdp.this.mml.clear();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        });
        if (jSONObject.optInt("delay", -1) < 0) {
            return;
        }
        this.lnr = r2 / 1000;
    }
}
