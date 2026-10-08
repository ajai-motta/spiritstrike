package com.bytedance.sdk.openadsdk.rdp;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.jtx;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends to {
    public tvp(Context context) {
        this(context, null);
    }

    public tvp(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public tvp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.rdp.to
    protected void qdl(Context context) {
        int iUd = ax.ud(context, 10.0f);
        int iUd2 = ax.ud(context, 6.0f);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ax.ud(context, 48.0f));
        layoutParams2.addRule(12);
        wdVar2.setLayoutParams(layoutParams2);
        wdVar2.setBackgroundColor(Color.parseColor("#26000000"));
        wdVar2.setGravity(16);
        wdVar2.setPadding(iUd4, 0, 0, 0);
        wdVar.addView(wdVar2);
        this.lnr = wd(context);
        this.lnr.setId(jtx.bx);
        int iUd5 = ax.ud(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iUd5, iUd5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = iUd;
        layoutParams3.setMarginStart(iUd);
        this.lnr.setLayoutParams(layoutParams3);
        wdVar2.addView(this.lnr);
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, jtx.bx);
        layoutParams4.addRule(1, jtx.bx);
        mzzVar.setLayoutParams(layoutParams4);
        mzzVar.setGravity(16);
        mzzVar.setOrientation(1);
        wdVar2.addView(mzzVar);
        this.mml = ud(context);
        this.mml.setId(jtx.xdk);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ax.ud(context, 130.0f), ax.ud(context, 20.0f));
        layoutParams5.leftMargin = iUd2;
        layoutParams5.setMarginStart(iUd2);
        this.mml.setLayoutParams(layoutParams5);
        mzzVar.addView(this.mml);
        this.mzz = lnr(context);
        this.mzz.setId(jtx.dps);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = iUd2;
        layoutParams6.setMarginStart(iUd2);
        this.mzz.setLayoutParams(layoutParams6);
        mzzVar.addView(this.mzz);
        this.mo = mml(context);
        this.mo.setId(jtx.jut);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(ax.ud(context, 80.0f), ax.ud(context, 30.0f));
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        layoutParams7.rightMargin = iUd;
        layoutParams7.setMarginEnd(iUd);
        this.mo.setLayoutParams(layoutParams7);
        wdVar2.addView(this.mo);
        View viewJpc = jpc(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, jtx.zvv);
        layoutParams8.leftMargin = iUd3;
        layoutParams8.bottomMargin = iUd;
        viewJpc.setLayoutParams(layoutParams8);
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
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        jpcVar.setEllipsize(TextUtils.TruncateAt.END);
        jpcVar.setGravity(16);
        jpcVar.setMaxWidth(ax.ud(context, 153.0f));
        jpcVar.setSingleLine();
        jpcVar.setText(ADXLogUtil.PLATFORM_PANGLE);
        jpcVar.setTextColor(-1);
        jpcVar.setTextSize(2, 14.0f);
        return jpcVar;
    }

    @Override // com.bytedance.sdk.openadsdk.rdp.to
    protected com.bytedance.sdk.openadsdk.core.mo.jpc lnr(Context context) {
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVarLnr = super.lnr(context);
        jpcVarLnr.setGravity(16);
        jpcVarLnr.setMaxWidth(ax.ud(context, 153.0f));
        jpcVarLnr.setTextColor(-1);
        jpcVarLnr.setTextSize(2, 13.0f);
        return jpcVarLnr;
    }
}
