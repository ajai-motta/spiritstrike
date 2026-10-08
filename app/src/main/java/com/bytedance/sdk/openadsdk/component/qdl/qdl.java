package com.bytedance.sdk.openadsdk.component.qdl;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends com.bytedance.sdk.openadsdk.core.lnr.qdl {
    private final com.bytedance.sdk.openadsdk.component.jpc.qdl qdl;

    public qdl(Context context, ljh ljhVar, String str, int i, com.bytedance.sdk.openadsdk.component.jpc.qdl qdlVar) {
        super(context, ljhVar, str, i);
        this.qdl = qdlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.lnr.qdl, com.bytedance.sdk.openadsdk.core.lnr.ud, com.bytedance.sdk.openadsdk.core.lnr.lnr
    public void qdl(View view, float f, float f2, float f3, float f4, SparseArray<lnr.qdl> sparseArray, boolean z) {
        if (view.getTag() == "open_ad_click_button_tag") {
            qdl("click_bar");
        } else {
            qdl("click_material");
        }
        HashMap map = new HashMap();
        map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.qdl.lnr()));
        qdl(map);
        super.qdl(view, f, f2, f3, f4, sparseArray, z);
        mzz.qdl(this.mo, 9);
    }
}
