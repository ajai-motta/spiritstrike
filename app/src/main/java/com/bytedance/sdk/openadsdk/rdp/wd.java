package com.bytedance.sdk.openadsdk.rdp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.jtx;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends to {
    public wd(Context context) {
        this(context, null);
    }

    public wd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public wd(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.rdp.to
    protected void qdl(Context context) {
        int iUd = ax.ud(context, 10.0f);
        int iUd2 = ax.ud(context, 5.0f);
        int iUd3 = ax.ud(context, 16.0f);
        int iUd4 = ax.ud(context, 15.0f);
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar = new com.bytedance.sdk.openadsdk.core.mo.wd(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        wdVar.setLayoutParams(layoutParams);
        addView(wdVar);
        this.qdl = mzz(context);
        this.qdl.setId(jtx.lme);
        this.qdl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        wdVar.addView(this.qdl);
        this.ud = mo(context);
        this.ud.setId(jtx.iw);
        this.ud.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        wdVar.addView(this.ud);
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar2 = new com.bytedance.sdk.openadsdk.core.mo.wd(context);
        wdVar2.setId(jtx.zvv);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ax.ud(context, 60.0f));
        layoutParams2.addRule(12);
        wdVar2.setBackgroundColor(Color.parseColor("#26000000"));
        wdVar2.setLayoutParams(layoutParams2);
        wdVar.addView(wdVar2);
        this.lnr = wd(context);
        this.lnr.setId(jtx.bx);
        int iUd5 = ax.ud(context, 50.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iUd5, iUd5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = iUd4;
        layoutParams3.setMarginStart(iUd4);
        this.lnr.setLayoutParams(layoutParams3);
        wdVar2.addView(this.lnr);
        this.mml = ud(context);
        this.mml.setId(jtx.xdk);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = iUd2;
        layoutParams4.setMarginStart(iUd2);
        layoutParams4.addRule(1, jtx.bx);
        layoutParams4.addRule(17, jtx.bx);
        this.mml.setLayoutParams(layoutParams4);
        wdVar2.addView(this.mml);
        this.mo = mml(context);
        this.mo.setId(jtx.jut);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ax.ud(context, 70.0f), ax.ud(context, 36.0f));
        layoutParams5.addRule(21);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.rightMargin = iUd4;
        layoutParams5.setMarginEnd(iUd4);
        this.mo.setLayoutParams(layoutParams5);
        wdVar2.addView(this.mo);
        View viewJpc = jpc(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, jtx.zvv);
        layoutParams6.leftMargin = iUd3;
        layoutParams6.bottomMargin = iUd;
        viewJpc.setLayoutParams(layoutParams6);
        wdVar.addView(viewJpc);
    }

    @Override // com.bytedance.sdk.openadsdk.rdp.to
    protected com.bytedance.sdk.openadsdk.core.mo.jpc mml(Context context) {
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVarMml = super.mml(context);
        jpcVarMml.setBackground(com.bytedance.sdk.openadsdk.utils.rq.qdl(context, "tt_download_corner_bg"));
        jpcVarMml.setTextSize(2, 14.0f);
        return jpcVarMml;
    }

    @Override // com.bytedance.sdk.openadsdk.rdp.to
    protected com.bytedance.sdk.openadsdk.core.mo.jpc ud(Context context) {
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVarUd = super.ud(context);
        jpcVarUd.setGravity(16);
        jpcVarUd.setMaxWidth(ax.ud(context, 150.0f));
        jpcVarUd.setTextColor(Color.parseColor("#B7B7B7"));
        jpcVarUd.setTextSize(2, 15.0f);
        jpcVarUd.setText("APP NAME");
        return jpcVarUd;
    }
}
