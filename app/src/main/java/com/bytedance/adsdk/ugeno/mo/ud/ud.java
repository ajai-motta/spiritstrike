package com.bytedance.adsdk.ugeno.mo.ud;

import android.view.View;
import com.bytedance.adsdk.ugeno.jpc.lnr;

/* JADX INFO: loaded from: classes2.dex */
public class ud implements lnr.mzz {
    @Override // com.bytedance.adsdk.ugeno.jpc.lnr.mzz
    public void qdl(View view, float f) {
        int width = view.getWidth();
        if (f >= -1.0f && f <= 1.0f) {
            if (f < 0.0f) {
                view.setTranslationX((-width) * f);
            } else {
                view.setTranslationX(width);
                view.setTranslationX((-width) * f);
            }
            view.setAlpha(Math.max(0.0f, 1.0f - Math.abs(f)));
            return;
        }
        view.setAlpha(0.0f);
    }
}
