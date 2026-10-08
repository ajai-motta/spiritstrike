package com.bytedance.adsdk.ud.qdl.ud;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mml extends wd<Float> {
    public mml(List<com.bytedance.adsdk.ud.wd.qdl<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl
    /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
    public Float qdl(com.bytedance.adsdk.ud.wd.qdl<Float> qdlVar, float f) {
        return Float.valueOf(lnr(qdlVar, f));
    }

    float lnr(com.bytedance.adsdk.ud.wd.qdl<Float> qdlVar, float f) {
        if (qdlVar.qdl == null || qdlVar.ud == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.lnr != null) {
            qdlVar.wd.floatValue();
            mml();
            jpc();
            throw null;
        }
        return com.bytedance.adsdk.ud.mo.mzz.qdl(qdlVar.mo(), qdlVar.wd(), f);
    }

    public float tvp() {
        return lnr(lnr(), mzz());
    }
}
