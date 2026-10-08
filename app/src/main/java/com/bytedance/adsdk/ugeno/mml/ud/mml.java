package com.bytedance.adsdk.ugeno.mml.ud;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.mml.mo;

/* JADX INFO: loaded from: classes2.dex */
public class mml extends qdl {
    @Override // com.bytedance.adsdk.ugeno.mml.ud.qdl
    public void ud() {
    }

    public mml(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, String str, mo.qdl qdlVar) {
        super(lnrVar, str, qdlVar);
    }

    @Override // com.bytedance.adsdk.ugeno.mml.ud.qdl
    public void qdl() {
        com.bytedance.adsdk.ugeno.ud.lnr lnrVarUd;
        com.bytedance.adsdk.ugeno.qdl.qdl qdlVarExu;
        if (this.mo == null || this.mo.size() <= 0) {
            return;
        }
        String str = this.mo.get("name");
        if (TextUtils.isEmpty(str) || (lnrVarUd = this.lnr.ud(this.lnr)) == null || (qdlVarExu = lnrVarUd.jpc(str).exu(str)) == null) {
            return;
        }
        qdlVarExu.ud();
        qdlVarExu.qdl(new com.bytedance.adsdk.ugeno.qdl.ud() { // from class: com.bytedance.adsdk.ugeno.mml.ud.mml.1
            @Override // com.bytedance.adsdk.ugeno.qdl.ud
            public void qdl() {
            }

            @Override // com.bytedance.adsdk.ugeno.qdl.ud
            public void ud() {
                mml.this.lnr();
            }
        });
    }
}
