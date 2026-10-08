package com.bytedance.sdk.openadsdk.rdp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.jtx;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends to {
    public mml(Context context) {
        this(context, null);
    }

    public mml(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public mml(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.rdp.to
    protected void qdl(Context context) {
        int iUd = ax.ud(context, 10.0f);
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        mzzVar.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        mzzVar.setOrientation(1);
        mzzVar.setPadding(iUd, iUd, iUd, iUd);
        addView(mzzVar);
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        lnrVar.setLayoutParams(layoutParams2);
        mzzVar.addView(lnrVar);
        this.qdl = mzz(context);
        this.qdl.setId(jtx.lme);
        this.qdl.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        lnrVar.addView(this.qdl);
        this.ud = mo(context);
        this.ud.setId(jtx.iw);
        this.ud.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        lnrVar.addView(this.ud);
        PAGLogoView pAGLogoViewJpc = jpc(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = iUd;
        layoutParams3.topMargin = iUd;
        layoutParams3.bottomMargin = iUd;
        pAGLogoViewJpc.setLayoutParams(layoutParams3);
        lnrVar.addView(pAGLogoViewJpc);
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar = new com.bytedance.sdk.openadsdk.core.mo.wd(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        wdVar.setLayoutParams(layoutParams4);
        mzzVar.addView(wdVar);
        this.lnr = wd(context);
        this.lnr.setId(jtx.bx);
        int iUd2 = ax.ud(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iUd2, iUd2);
        layoutParams5.addRule(15);
        this.lnr.setLayoutParams(layoutParams5);
        wdVar.addView(this.lnr);
        this.mml = ud(context);
        this.mml.setId(jtx.xdk);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = iUd;
        layoutParams6.setMarginStart(iUd);
        layoutParams6.addRule(1, jtx.bx);
        layoutParams6.addRule(17, jtx.bx);
        this.mml.setLayoutParams(layoutParams6);
        wdVar.addView(this.mml);
        this.mo = mml(context);
        this.mo.setId(jtx.jut);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(ax.ud(context, 100.0f), ax.ud(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.mo.setLayoutParams(layoutParams7);
        wdVar.addView(this.mo);
    }
}
