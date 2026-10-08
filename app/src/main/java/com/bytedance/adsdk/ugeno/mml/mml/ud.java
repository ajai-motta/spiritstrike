package com.bytedance.adsdk.ugeno.mml.mml;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes2.dex */
public class ud extends lnr implements com.bytedance.adsdk.ugeno.qdl.ud {
    private String rq;

    public ud(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.mml.mml.lnr
    public boolean qdl(Object... objArr) {
        com.bytedance.adsdk.ugeno.ud.lnr lnrVarUd;
        com.bytedance.adsdk.ugeno.qdl.qdl qdlVarExu;
        if (this.mzz != null && this.mzz.size() > 0) {
            String str = this.mzz.get("name");
            this.rq = this.mzz.get("state");
            if (!TextUtils.isEmpty(str) && (lnrVarUd = this.ud.ud(this.ud)) != null && (qdlVarExu = lnrVarUd.jpc(str).exu(str)) != null) {
                qdlVarExu.qdl(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.ud
    public void qdl() {
        if ((TextUtils.equals(this.rq, TtmlNode.START) || TextUtils.isEmpty(this.rq)) && this.qdl != null) {
            this.qdl.qdl(this.ud, this.mo, this.lnr.ud());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.ud
    public void ud() {
        if ((TextUtils.equals(this.rq, "complete") || TextUtils.isEmpty(this.rq)) && this.qdl != null) {
            this.qdl.qdl(this.ud, this.mo, this.lnr.ud());
        }
    }
}
