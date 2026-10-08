package com.bytedance.adsdk.ud.qdl.ud;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class fs extends wd<com.bytedance.adsdk.ud.wd.lnr> {
    private final com.bytedance.adsdk.ud.wd.lnr mml;

    public fs(List<com.bytedance.adsdk.ud.wd.qdl<com.bytedance.adsdk.ud.wd.lnr>> list) {
        super(list);
        this.mml = new com.bytedance.adsdk.ud.wd.lnr();
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ud.wd.lnr qdl(com.bytedance.adsdk.ud.wd.qdl<com.bytedance.adsdk.ud.wd.lnr> qdlVar, float f) {
        if (qdlVar.qdl == null || qdlVar.ud == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.ud.wd.lnr lnrVar = qdlVar.qdl;
        com.bytedance.adsdk.ud.wd.lnr lnrVar2 = qdlVar.ud;
        if (this.lnr != null) {
            qdlVar.wd.floatValue();
            mml();
            jpc();
            throw null;
        }
        this.mml.qdl(com.bytedance.adsdk.ud.mo.mzz.qdl(lnrVar.qdl(), lnrVar2.qdl(), f), com.bytedance.adsdk.ud.mo.mzz.qdl(lnrVar.ud(), lnrVar2.ud(), f));
        return this.mml;
    }
}
