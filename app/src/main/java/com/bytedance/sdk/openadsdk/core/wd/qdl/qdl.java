package com.bytedance.sdk.openadsdk.core.wd.qdl;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.ud.rq;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends lnr implements com.bytedance.sdk.component.adexpress.dynamic.mo.qdl {
    protected WeakReference<View> qdl;
    private rq ud;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mo.qdl
    public void qdl(rq rqVar) {
        this.ud = rqVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mo.qdl
    public void qdl(View view) {
        this.qdl = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.lnr.lnr
    public void qdl(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, boolean z) {
        qdl(view, ((Integer) view.getTag()).intValue(), f, f2, f3, f4, sparseArray);
    }

    private void qdl(View view, int i, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray) {
        if (this.ud != null) {
            String strValueOf = "";
            try {
                if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.qdl.jyq) != null) {
                    strValueOf = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.qdl.jyq));
                }
            } catch (Exception unused) {
            }
            this.ud.qdl(view, i, new jtx.qdl().mml(f).lnr(f2).ud(f3).qdl(f4).ud(this.bch).qdl(this.uw).qdl(sparseArray).qdl(this.rc).qdl(strValueOf).qdl());
        }
    }
}
