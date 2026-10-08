package com.bytedance.adsdk.ugeno.mml.lnr;

import com.bytedance.adsdk.ugeno.mml.mo;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends com.bytedance.adsdk.ugeno.mml.ud.qdl {
    public lnr(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, String str, mo.qdl qdlVar) {
        super(lnrVar, str, qdlVar);
    }

    @Override // com.bytedance.adsdk.ugeno.mml.ud.qdl
    public void qdl() {
        com.bytedance.adsdk.ugeno.ud.lnr lnrVarUd;
        if (this.lnr == null || (lnrVarUd = this.lnr.ud(this.lnr)) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.ud.lnr lnrVarMo = lnrVarUd.mo("SwiperView");
        if (lnrVarMo instanceof com.bytedance.adsdk.ugeno.ud) {
            ((com.bytedance.adsdk.ugeno.ud) lnrVarMo).mml();
        }
    }
}
