package com.bytedance.adsdk.ugeno.mo.ud;

import android.view.View;
import com.bytedance.adsdk.ugeno.jpc.lnr;

/* JADX INFO: loaded from: classes2.dex */
public class qdl implements lnr.mzz {
    @Override // com.bytedance.adsdk.ugeno.jpc.lnr.mzz
    public void qdl(View view, float f) {
        view.setPivotX(f < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f * 90.0f);
    }
}
