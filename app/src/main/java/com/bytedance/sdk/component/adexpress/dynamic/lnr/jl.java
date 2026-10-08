package com.bytedance.sdk.component.adexpress.dynamic.lnr;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class jl implements wd<com.bytedance.sdk.component.adexpress.mo.rq> {
    private final com.bytedance.sdk.component.adexpress.mo.rq qdl;

    public jl(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz mzzVar, com.bytedance.sdk.component.adexpress.dynamic.mml.wd wdVar) {
        int iWak;
        com.bytedance.sdk.component.adexpress.mo.rq rqVar = new com.bytedance.sdk.component.adexpress.mo.rq(context);
        this.qdl = rqVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (wdVar.wak() > 0) {
            iWak = wdVar.wak();
        } else {
            iWak = com.bytedance.sdk.component.adexpress.mml.ud() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, iWak);
        rqVar.setLayoutParams(layoutParams);
        rqVar.setClipChildren(false);
        rqVar.setText(wdVar.jjk());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr.wd
    public void qdl() {
        com.bytedance.sdk.component.adexpress.mo.rq rqVar = this.qdl;
        if (rqVar != null) {
            rqVar.qdl();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr.wd
    public void ud() {
        com.bytedance.sdk.component.adexpress.mo.rq rqVar = this.qdl;
        if (rqVar != null) {
            rqVar.ud();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr.wd
    /* JADX INFO: renamed from: mml, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.mo.rq lnr() {
        return this.qdl;
    }
}
