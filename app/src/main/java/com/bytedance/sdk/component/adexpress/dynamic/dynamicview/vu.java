package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class vu extends mo implements com.bytedance.sdk.component.adexpress.dynamic.lnr {
    private boolean qdl;

    public vu(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.wd = this.jpc;
        this.bjy = new ImageView(context);
        this.bjy.setTag(Integer.valueOf(getClickArea()));
        addView(this.bjy, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            if (!dynamicRootView.getRenderRequest().xmv()) {
                this.bjy.setVisibility(8);
                setVisibility(8);
            }
            this.qdl = dynamicRootView.getRenderRequest().exu();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hkc
    public boolean tvp() {
        Drawable drawableLnr;
        super.tvp();
        if (this.bjy != null) {
            ((ImageView) this.bjy).setScaleType(ImageView.ScaleType.CENTER_CROP);
            Drawable drawableQdl = com.bytedance.sdk.component.adexpress.mml.lnr.qdl(getContext(), this.fs);
            if (drawableQdl != null) {
                ((ImageView) this.bjy).setBackground(drawableQdl);
            }
            if (this.qdl) {
                drawableLnr = com.bytedance.sdk.component.utils.ljh.lnr(getContext(), "tt_close_btn");
            } else {
                drawableLnr = com.bytedance.sdk.component.utils.ljh.lnr(getContext(), "tt_skip_btn");
            }
            if (drawableLnr != null) {
                drawableLnr.setAutoMirrored(true);
                ((ImageView) this.bjy).setImageDrawable(drawableLnr);
            }
            int iQdl = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, this.fs.ud());
            this.bjy.setPadding(iQdl, iQdl, iQdl, iQdl);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr
    public void qdl(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
