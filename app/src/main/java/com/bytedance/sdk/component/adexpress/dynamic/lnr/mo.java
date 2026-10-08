package com.bytedance.sdk.component.adexpress.dynamic.lnr;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.mo.aaj;
import com.bytedance.sdk.component.adexpress.mo.exc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends yt<com.bytedance.sdk.component.adexpress.mo.mo> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr.yt
    protected void mml() {
    }

    public mo(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz mzzVar, com.bytedance.sdk.component.adexpress.dynamic.mml.wd wdVar, int i, int i2, int i3, JSONObject jSONObject) {
        super(context, mzzVar, wdVar);
        this.ud = context;
        this.mml = wdVar;
        this.lnr = mzzVar;
        qdl(i, i2, i3, jSONObject, wdVar);
    }

    private void qdl(int i, int i2, int i3, JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.mml.wd wdVar) {
        int iWak;
        this.qdl = new com.bytedance.sdk.component.adexpress.mo.mo(this.ud, i, i2, i3, jSONObject);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.ud, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.ud;
        if (wdVar.wak() > 0) {
            iWak = wdVar.wak();
        } else {
            iWak = com.bytedance.sdk.component.adexpress.mml.ud() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(context, iWak);
        this.qdl.setLayoutParams(layoutParams);
        this.qdl.setClipChildren(false);
        this.qdl.setSlideText(this.mml.jjk());
        if (this.qdl instanceof com.bytedance.sdk.component.adexpress.mo.mo) {
            ((com.bytedance.sdk.component.adexpress.mo.mo) this.qdl).setShakeText(this.mml.taz());
            final aaj shakeView = ((com.bytedance.sdk.component.adexpress.mo.mo) this.qdl).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new exc.qdl() { // from class: com.bytedance.sdk.component.adexpress.dynamic.lnr.mo.1
                });
                shakeView.setOnClickListener((View.OnClickListener) this.lnr.getDynamicClickListener());
            }
        }
    }
}
