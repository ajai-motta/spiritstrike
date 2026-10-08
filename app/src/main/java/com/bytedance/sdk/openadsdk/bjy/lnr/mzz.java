package com.bytedance.sdk.openadsdk.bjy.lnr;

/* JADX INFO: loaded from: classes3.dex */
class mzz implements lnr {
    private static volatile mzz qdl;

    @Override // com.bytedance.sdk.openadsdk.bjy.lnr.lnr
    public void qdl(com.bytedance.sdk.openadsdk.bjy.ud udVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.bjy.lnr.lnr
    public void qdl(com.bytedance.sdk.openadsdk.bjy.ud udVar, boolean z) {
    }

    public static mzz qdl() {
        if (qdl == null) {
            synchronized (mzz.class) {
                if (qdl == null) {
                    qdl = new mzz();
                }
            }
        }
        return qdl;
    }

    private mzz() {
    }
}
