package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class bjy extends mo {
    String qdl;
    com.bytedance.sdk.component.adexpress.dynamic.mml.jpc ud;

    public bjy(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, String str) {
        super(context, dynamicRootView, jpcVar);
        this.qdl = str;
        this.ud = jpcVar;
        com.bytedance.sdk.component.adexpress.mo.to lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private com.bytedance.sdk.component.adexpress.mo.to getLottieView() {
        String strZy;
        if (this.exu == null || this.exu.to() == null || this.rq == null || TextUtils.isEmpty(this.qdl)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz = this.exu.to().mzz();
        if (moVarMzz == null) {
            strZy = "";
        } else {
            strZy = moVarMzz.zy();
        }
        if (TextUtils.isEmpty(strZy)) {
            return null;
        }
        String str = this.qdl + "static/lotties/" + strZy + ".json";
        com.bytedance.sdk.component.adexpress.mo.to toVar = new com.bytedance.sdk.component.adexpress.mo.to(this.rq);
        toVar.setImageLottieTosPath(str);
        toVar.jpc();
        return toVar;
    }
}
