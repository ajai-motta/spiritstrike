package com.bytedance.sdk.openadsdk.core.rq.lnr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.yt;
import com.bytedance.sdk.openadsdk.core.tvp.bjy;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private ljh lnr;
    private com.bytedance.sdk.openadsdk.core.rq.lnr.qdl mml;
    private final boolean mzz;
    private lnr qdl;
    private Context ud;

    public ud(Context context, ljh ljhVar) {
        this(context, ljhVar, false);
    }

    public ud(Context context, ljh ljhVar, boolean z) {
        this.ud = context;
        this.lnr = ljhVar;
        this.mzz = z;
    }

    public void qdl(bjy bjyVar) {
        lnr lnrVarQdl = qdl.qdl(this.ud, this.lnr, this.mzz);
        this.qdl = lnrVarQdl;
        if (lnrVarQdl != null) {
            lnrVarQdl.qdl();
            this.qdl.qdl(bjyVar);
        }
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.rq.lnr.qdl qdlVar) {
        this.mml = qdlVar;
        lnr lnrVar = this.qdl;
        if (lnrVar != null) {
            lnrVar.qdl(qdlVar);
        }
    }

    public void qdl(int i) {
        hkc hkcVarMzz;
        lnr lnrVar = this.qdl;
        if (!(lnrVar instanceof mml) || (hkcVarMzz = ((mml) lnrVar).mzz()) == null || hkcVarMzz.qdl() == null) {
            return;
        }
        hkcVarMzz.qdl().qdl(i);
    }

    public lnr qdl() {
        return this.qdl;
    }

    public void ud() {
        lnr lnrVar = this.qdl;
        if (lnrVar != null) {
            lnrVar.ud();
        }
    }

    public View lnr() {
        lnr lnrVar = this.qdl;
        if (lnrVar != null) {
            return lnrVar.mml();
        }
        return null;
    }

    public void mml() {
        lnr lnrVar = this.qdl;
        if (lnrVar != null) {
            lnrVar.lnr();
        }
    }

    public static class qdl {
        public static lnr qdl(Context context, ljh ljhVar, boolean z) {
            if (yt.qdl(ljhVar, z)) {
                return new mml(context, ljhVar, z);
            }
            return null;
        }
    }
}
