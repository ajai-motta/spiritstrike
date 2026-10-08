package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bqt extends mo implements com.bytedance.sdk.component.adexpress.dynamic.lnr {
    private int aaj;
    private int jyq;
    private boolean oth;
    int qdl;
    boolean ud;

    public bqt(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.jyq = 0;
        setTag(Integer.valueOf(getClickArea()));
        qdl();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().xmv()) {
            return;
        }
        if (this.bjy != null) {
            this.bjy.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz
    public void mo() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.ud) {
            layoutParams.leftMargin = this.tvp;
        } else {
            layoutParams.leftMargin = this.tvp + this.jyq;
        }
        if (this.oth && this.fs != null) {
            layoutParams.leftMargin = ((this.tvp + this.jyq) - ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.lnr()))) - ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.mml()));
        }
        if (com.bytedance.sdk.component.adexpress.mml.ud()) {
            layoutParams.topMargin = this.to - ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.ud()));
        } else {
            layoutParams.topMargin = this.to;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hkc
    public boolean tvp() {
        if (com.bytedance.sdk.component.adexpress.mml.mo.ud(this.rdp.getRenderRequest().mml())) {
            return true;
        }
        super.tvp();
        setPadding((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.lnr()), (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.ud()), (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.mml()), (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.qdl()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.oth && this.fs != null) {
            setMeasuredDimension(this.aaj + ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.lnr())) + ((int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.fs.mml())), this.jpc);
        } else if (this.ud) {
            setMeasuredDimension(this.wd, this.jpc);
        } else {
            setMeasuredDimension(this.qdl, this.jpc);
        }
    }

    private void qdl() {
        List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> listRq = this.exu.rq();
        if (listRq == null || listRq.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it = listRq.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.mml.jpc next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.to().ud())) {
                this.aaj = (int) com.bytedance.sdk.component.adexpress.mml.wd.qdl(this.rq, next.jpc() + (com.bytedance.sdk.component.adexpress.mml.ud() ? next.exu() : 0));
                this.qdl = this.wd - this.aaj;
            }
        }
        this.jyq = this.wd - this.qdl;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr
    public void qdl(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.oth != z2) {
            this.oth = z2;
            mo();
            return;
        }
        if (z && this.ud != z) {
            this.ud = z;
            mo();
        }
        this.ud = z;
    }
}
