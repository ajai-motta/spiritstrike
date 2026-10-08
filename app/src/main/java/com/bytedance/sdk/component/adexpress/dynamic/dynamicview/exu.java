package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class exu extends mo {
    public exu(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.bjy = new TextView(context);
        this.bjy.setTag(Integer.valueOf(getClickArea()));
        addView(this.bjy, getWidgetLayoutParams());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0082  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hkc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean tvp() {
        /*
            r4 = this;
            super.tvp()
            android.view.View r0 = r4.bjy
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r1 = r4.fs
            int r1 = r1.jpc()
            r0.setTextAlignment(r1)
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r1 = r4.fs
            int r1 = r1.wd()
            r0.setTextColor(r1)
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r1 = r4.fs
            float r1 = r1.mzz()
            r0.setTextSize(r1)
            boolean r0 = com.bytedance.sdk.component.adexpress.mml.ud()
            if (r0 == 0) goto L8c
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            r0.setIncludeFontPadding(r1)
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.Context r2 = com.bytedance.sdk.component.adexpress.mml.qdl()
            int r3 = r4.jpc
            float r3 = (float) r3
            int r2 = com.bytedance.sdk.component.adexpress.mml.wd.ud(r2, r3)
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r3 = r4.fs
            int r3 = r3.ud()
            int r2 = r2 - r3
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r3 = r4.fs
            int r3 = r3.qdl()
            int r2 = r2 - r3
            float r2 = (float) r2
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 - r3
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r3 = r4.fs
            float r3 = r3.mzz()
            float r2 = java.lang.Math.min(r2, r3)
            r0.setTextSize(r2)
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView r0 = r4.rdp
            if (r0 == 0) goto L82
            com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView r0 = r4.rdp
            com.bytedance.sdk.component.adexpress.ud.exu r0 = r0.getRenderRequest()
            if (r0 == 0) goto L82
            java.lang.String r0 = r0.koa()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L82
            android.view.View r2 = r4.bjy
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setText(r0)
            goto L84
        L82:
            r1 = 8
        L84:
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r1)
            goto Lc5
        L8c:
            boolean r0 = r4.qdl()
            if (r0 == 0) goto Lb4
            boolean r0 = com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.ud()
            if (r0 == 0) goto La4
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.qdl()
            r0.setText(r1)
            goto Lc5
        La4:
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.bytedance.sdk.component.adexpress.dynamic.mml.wd r1 = r4.fs
            java.lang.String r1 = r1.ud
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.qdl(r1)
            r0.setText(r1)
            goto Lc5
        Lb4:
            android.view.View r0 = r4.bjy
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "tt_logo_cn"
            int r1 = com.bytedance.sdk.component.utils.ljh.ud(r1, r2)
            r0.setText(r1)
        Lc5:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.exu.tvp():boolean");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz
    public void mo() {
        com.bytedance.sdk.component.adexpress.ud.exu renderRequest = this.rdp.getRenderRequest();
        if (renderRequest != null && TextUtils.isEmpty(renderRequest.bqt())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.wd, this.jpc);
            layoutParams.gravity = 17;
            setLayoutParams(layoutParams);
            return;
        }
        super.mo();
    }

    private boolean qdl() {
        if (com.bytedance.sdk.component.adexpress.mml.ud()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.fs.ud) && this.fs.ud.contains("adx:")) || com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.ud();
    }
}
