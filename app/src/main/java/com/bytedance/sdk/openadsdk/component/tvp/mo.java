package com.bytedance.sdk.openadsdk.component.tvp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.jtx;
import com.bytedance.sdk.openadsdk.core.widget.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.rq;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends lnr {
    private final com.bytedance.sdk.openadsdk.core.mo.mzz exu;
    private final jtx rdp;

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public com.bytedance.sdk.openadsdk.core.mo.mml getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public com.bytedance.sdk.openadsdk.core.mo.jpc getAdTitleTextView() {
        return null;
    }

    public mo(Context context, ljh ljhVar) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#EDFCFF"), Color.parseColor("#FFF6FD")}));
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        this.exu = mzzVar;
        mzzVar.setId(520093758);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ax.ud(context, 24.0f);
        layoutParams.topMargin = ax.ud(context, 56.0f);
        mzzVar.setLayoutParams(layoutParams);
        mzzVar.setClickable(false);
        mzzVar.setGravity(16);
        mzzVar.setOrientation(0);
        this.mo = new yt(context);
        this.mo.setId(520093759);
        this.mo.setLayoutParams(new LinearLayout.LayoutParams(ax.ud(context, 24.0f), ax.ud(context, 24.0f)));
        this.wd = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.wd.setId(520093761);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ax.ud(context, 8.0f);
        this.wd.setLayoutParams(layoutParams2);
        this.wd.setEllipsize(TextUtils.TruncateAt.END);
        this.wd.setMaxLines(2);
        this.wd.setTextColor(Color.parseColor("#161823"));
        this.wd.setTextSize(12.0f);
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar = new com.bytedance.sdk.openadsdk.core.mo.wd(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ax.ud(context, 327.0f), -2);
        layoutParams3.addRule(13);
        layoutParams3.leftMargin = ax.ud(context, 24.0f);
        layoutParams3.rightMargin = ax.ud(context, 24.0f);
        wdVar.setLayoutParams(layoutParams3);
        this.tvp = new yt(context);
        this.tvp.setId(com.bytedance.sdk.openadsdk.utils.jtx.ujt);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ax.ud(context, 80.0f), ax.ud(context, 80.0f));
        layoutParams4.addRule(14);
        this.tvp.setLayoutParams(layoutParams4);
        this.to = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.to.setId(com.bytedance.sdk.openadsdk.utils.jtx.ab);
        this.to.setTextSize(24.0f);
        this.to.setTextColor(Color.parseColor("#161823"));
        this.to.setGravity(17);
        this.to.setMaxLines(1);
        this.to.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, com.bytedance.sdk.openadsdk.utils.jtx.ujt);
        layoutParams5.topMargin = ax.ud(context, 12.0f);
        layoutParams5.addRule(14);
        this.to.setLayoutParams(layoutParams5);
        this.rq = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.rq.setId(com.bytedance.sdk.openadsdk.utils.jtx.icv);
        this.rq.setTextSize(16.0f);
        this.rq.setTextColor(Color.parseColor("#80161823"));
        this.rq.setGravity(17);
        this.rq.setMaxLines(2);
        this.rq.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, com.bytedance.sdk.openadsdk.utils.jtx.ab);
        layoutParams6.topMargin = ax.ud(context, 4.0f);
        layoutParams6.addRule(14);
        this.rq.setLayoutParams(layoutParams6);
        jtx jtxVar = new jtx(context);
        this.rdp = jtxVar;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = ax.ud(context, 12.0f);
        jtxVar.setLayoutParams(layoutParams7);
        this.mzz = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.mzz.setId(520093717);
        this.mzz.setBackground(rq.qdl(context, "tt_reward_full_video_backup_btn_bg"));
        this.mzz.setEllipsize(TextUtils.TruncateAt.END);
        this.mzz.setLines(1);
        this.mzz.setGravity(17);
        this.mzz.setTextColor(-1);
        this.mzz.setTextSize(16.0f);
        this.mzz.setTag("open_ad_click_button_tag");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, ax.ud(context, 44.0f));
        layoutParams8.addRule(3, com.bytedance.sdk.openadsdk.utils.jtx.icv);
        layoutParams8.topMargin = ax.ud(context, 54.0f);
        layoutParams8.addRule(14);
        this.mzz.setLayoutParams(layoutParams8);
        this.mml = PAGLogoView.createPAGLogoViewByMaterial(context, ljhVar);
        this.mml.setId(520093757);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, ax.ud(context, 14.0f));
        layoutParams9.leftMargin = ax.ud(context, 16.0f);
        layoutParams9.bottomMargin = ax.ud(context, 24.0f);
        layoutParams9.addRule(12);
        this.mml.setLayoutParams(layoutParams9);
        addView(this.jpc);
        mzzVar.addView(this.mo);
        mzzVar.addView(this.wd);
        addView(mzzVar);
        wdVar.addView(this.tvp);
        wdVar.addView(this.to);
        wdVar.addView(this.rq);
        wdVar.addView(jtxVar);
        wdVar.addView(this.mzz);
        addView(wdVar);
        addView(this.mml);
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public View getUserInfo() {
        return this.exu;
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public jtx getScoreBar() {
        return this.rdp;
    }
}
