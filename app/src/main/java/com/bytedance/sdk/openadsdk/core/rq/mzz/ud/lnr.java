package com.bytedance.sdk.openadsdk.core.rq.mzz.ud;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends com.bytedance.adsdk.ugeno.mml.mml.lnr {
    private boolean rq;

    public lnr(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.mml.mml.lnr
    public boolean qdl(Object... objArr) {
        if (this.mzz == null || this.mzz.isEmpty()) {
            return false;
        }
        long jLongValue = ((Long) objArr[0]).longValue() / 1000;
        long jLongValue2 = ((Long) objArr[1]).longValue() / 1000;
        if (jLongValue <= 0) {
            this.rq = false;
        }
        if (this.mzz.containsKey("percent")) {
            float fQdl = com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("percent"), -1.0f);
            if (fQdl >= 0.0f && jLongValue >= (fQdl / 100.0f) * jLongValue2 && !this.rq) {
                this.rq = true;
                if (this.qdl != null) {
                    this.qdl.qdl(this.ud, this.mo, this.lnr.ud());
                }
            }
        } else if (jLongValue >= com.bytedance.adsdk.ugeno.wd.lnr.qdl(this.mzz.get("interval"), -1) && !this.rq) {
            this.rq = true;
            if (this.qdl != null) {
                this.qdl.qdl(this.ud, this.mo, this.lnr.ud());
            }
        }
        return true;
    }
}
