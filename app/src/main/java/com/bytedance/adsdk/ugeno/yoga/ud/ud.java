package com.bytedance.adsdk.ugeno.yoga.ud;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.rq;
import com.bytedance.adsdk.ugeno.yoga.to;
import com.bytedance.adsdk.ugeno.yoga.ud.lnr;
import com.bytedance.adsdk.ugeno.yoga.wd;

/* JADX INFO: loaded from: classes2.dex */
public class ud extends ViewGroup {
    public to getYogaNode() {
        throw null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof ud) {
            throw null;
        }
        to toVarQdl = rq.qdl();
        lnr.qdl(new lnr.qdl(layoutParams), toVarQdl, view);
        toVarQdl.qdl(view);
        toVarQdl.qdl((wd) new lnr.ud());
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new lnr.qdl(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new lnr.qdl(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof lnr.qdl;
    }
}
