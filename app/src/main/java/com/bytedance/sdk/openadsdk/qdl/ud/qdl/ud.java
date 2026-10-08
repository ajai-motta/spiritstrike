package com.bytedance.sdk.openadsdk.qdl.ud.qdl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.exc;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends lnr {
    public ud(Context context, ljh ljhVar, AdSlot adSlot) {
        super(context, ljhVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.qdl.ud.qdl.lnr
    protected void qdl() {
        this.to = new exc(this.jpc, this.ud, this.tvp, this.rq, false);
        this.qdl.qdl(((exc) this.to).getVideoController());
        lnr();
    }

    public com.bytedance.sdk.openadsdk.multipro.ud.qdl ud() {
        if (this.to != null) {
            return ((exc) this.to).getVideoModel();
        }
        return null;
    }
}
