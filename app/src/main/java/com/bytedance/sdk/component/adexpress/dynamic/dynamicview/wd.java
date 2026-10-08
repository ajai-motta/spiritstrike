package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends mo {
    public wd(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.bjy = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.qdl(context);
        this.bjy.setTag(Integer.valueOf(getClickArea()));
        addView(this.bjy, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.mml.ud() && "fillButton".equals(this.exu.to().ud())) {
            ((TextView) this.bjy).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.bjy).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.fs.jl() * 2;
            widgetLayoutParams.height -= this.fs.jl() * 2;
            widgetLayoutParams.topMargin += this.fs.jl();
            widgetLayoutParams.leftMargin += this.fs.jl();
            widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hkc
    public boolean tvp() {
        super.tvp();
        if (TextUtils.equals("download-progress-button", this.exu.to().ud()) && TextUtils.isEmpty(this.fs.to())) {
            this.bjy.setVisibility(4);
            return true;
        }
        this.bjy.setTextAlignment(this.fs.jpc());
        ((TextView) this.bjy).setText(this.fs.to());
        ((TextView) this.bjy).setTextColor(this.fs.wd());
        ((TextView) this.bjy).setTextSize(this.fs.mzz());
        ((TextView) this.bjy).setGravity(17);
        ((TextView) this.bjy).setIncludeFontPadding(false);
        if ("fillButton".equals(this.exu.to().ud())) {
            this.bjy.setPadding(0, 0, 0, 0);
        } else {
            this.bjy.setPadding(this.fs.lnr(), this.fs.ud(), this.fs.mml(), this.fs.qdl());
        }
        return true;
    }
}
