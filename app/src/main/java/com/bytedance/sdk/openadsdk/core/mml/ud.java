package com.bytedance.sdk.openadsdk.core.mml;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.compose.animation.core.AnimationConstants;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.exu.ud.mo;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.aaj;
import com.bytedance.sdk.openadsdk.core.tvp.exc;
import com.bytedance.sdk.openadsdk.core.tvp.jl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.exu;
import com.bytedance.sdk.openadsdk.core.widget.fs;
import com.bytedance.sdk.openadsdk.core.widget.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.rq;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends com.bytedance.sdk.openadsdk.core.tvp.qdl {
    public static jl[] qdl = {new jl(1, 6.4f, 320, 50), new jl(4, 1.2f, AnimationConstants.DefaultDurationMillis, 250)};
    private String bjy;
    private qdl exu;
    private PAGBannerAdWrapperListener jtx;
    private aaj rdp;

    public void setClosedListenerKey(String str) {
        this.bjy = str;
    }

    public ud(Context context) {
        super(context);
        this.ud = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.qdl
    protected void qdl(View view, int i, jtx jtxVar) {
        aaj aajVar = this.rdp;
        if (aajVar != null) {
            aajVar.qdl(view, i, jtxVar);
        }
    }

    void qdl(ljh ljhVar, aaj aajVar, com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo moVar) {
        setBackgroundColor(-1);
        this.lnr = ljhVar;
        this.rdp = aajVar;
        this.mo = "banner_ad";
        this.rdp.addView(this, new ViewGroup.LayoutParams(-2, -2));
        ud();
    }

    private void ud() {
        jl jlVarQdl = qdl(this.rdp.getExpectExpressWidth(), this.rdp.getExpectExpressHeight());
        if (this.rdp.getExpectExpressWidth() > 0 && this.rdp.getExpectExpressHeight() > 0) {
            this.wd = ax.ud(this.ud, this.rdp.getExpectExpressWidth());
            this.jpc = ax.ud(this.ud, this.rdp.getExpectExpressHeight());
        } else {
            this.wd = ax.lnr(this.ud);
            this.jpc = Float.valueOf(this.wd / jlVarQdl.ud).intValue();
        }
        if (this.wd > 0 && this.wd > ax.lnr(this.ud)) {
            this.wd = ax.lnr(this.ud);
            this.jpc = Float.valueOf(this.jpc * (ax.lnr(this.ud) / this.wd)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.wd, this.jpc);
        }
        layoutParams.width = this.wd;
        layoutParams.height = this.jpc;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (this.lnr != null) {
            int iVxg = this.lnr.vxg();
            if (iVxg == 1010 || iVxg == 1011 || iVxg == 1012) {
                mml();
            } else {
                qdl(jlVarQdl);
            }
        }
    }

    private void qdl(jl jlVar) {
        if (jlVar.qdl == 1) {
            lnr();
        } else {
            mzz();
        }
    }

    private void lnr() {
        ax.ud(this.ud, 50.0f);
        qdl qdlVarWd = wd();
        this.exu = qdlVarWd;
        ImageView imageView = qdlVarWd.lnr;
        TextView textView = this.exu.ud;
        com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar = this.exu.mml;
        TextView textView2 = this.exu.wd;
        View view = this.exu.mo;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.ud.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TTWebsiteActivity.qdl(ud.this.ud, ud.this.lnr, ud.this.mo);
                }
            });
        }
        if (this.lnr.hcs() != null && !TextUtils.isEmpty(this.lnr.hcs().qdl())) {
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.lnr.hcs().qdl(), this.lnr.hcs().ud(), this.lnr.hcs().lnr(), imageView, this.lnr);
        }
        textView.setText(this.lnr.gsv());
        if (!TextUtils.isEmpty(this.lnr.uvi())) {
            textView2.setText(this.lnr.uvi());
        } else {
            textView2.setVisibility(8);
        }
        ax.qdl((TextView) null, jtxVar, this.lnr);
        qdl((View) imageView, true);
        imageView.setTag(520093762, Boolean.TRUE);
        qdl((View) this, true);
        qdl((View) textView2, true);
    }

    private void mml() {
        qdl qdlVarMo = mo();
        this.exu = qdlVarMo;
        View view = qdlVarMo.mo;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.ud.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TTWebsiteActivity.qdl(ud.this.ud, ud.this.lnr, ud.this.mo);
                }
            });
        }
        exu exuVar = this.exu.qdl;
        if (exuVar != null) {
            List<com.bytedance.sdk.openadsdk.core.model.jl> listVm = this.lnr.vm();
            if (listVm != null && !listVm.isEmpty()) {
                com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(listVm.get(0), exuVar, this.lnr);
            }
            qdl((View) exuVar, true);
            exuVar.setTag(520093762, Boolean.TRUE);
        }
    }

    private void mzz() {
        TextView textView;
        TextView textView2;
        if (this.lnr != null) {
            int iVxg = this.lnr.vxg();
            if (this.lnr.tdy() == null) {
                qdl qdlVarJpc = jpc();
                this.exu = qdlVarJpc;
                exu exuVar = qdlVarJpc.qdl;
                ImageView imageView = this.exu.lnr;
                TextView textView3 = this.exu.ud;
                TextView textView4 = this.exu.wd;
                View view = this.exu.mo;
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.ud.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TTWebsiteActivity.qdl(ud.this.ud, ud.this.lnr, ud.this.mo);
                        }
                    });
                }
                ViewGroup.LayoutParams layoutParams = exuVar.getLayoutParams();
                if (this.wd - (ax.ud(this.ud, 8.0f) * 2) >= ((this.jpc - ax.ud(this.ud, 8.0f)) - (ax.ud(this.ud, 21.0f) * 2)) - ax.ud(this.ud, 52.0f)) {
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                }
                exuVar.setLayoutParams(layoutParams);
                if (iVxg == 33) {
                    exuVar.setRatio(1.0f);
                } else {
                    exuVar.setRatio(1.91f);
                }
                List<com.bytedance.sdk.openadsdk.core.model.jl> listVm = this.lnr.vm();
                if (listVm != null && !listVm.isEmpty()) {
                    com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(listVm.get(0), exuVar, this.lnr);
                    com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(listVm.get(0).qdl(), this.exu.mzz);
                }
                if (this.lnr.hcs() == null || TextUtils.isEmpty(this.lnr.hcs().qdl())) {
                    textView = textView4;
                    textView2 = textView3;
                } else {
                    textView = textView4;
                    textView2 = textView3;
                    com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.lnr.hcs().qdl(), this.lnr.hcs().ud(), this.lnr.hcs().lnr(), imageView, this.lnr);
                }
                textView2.setText(this.lnr.gsv());
                if (!TextUtils.isEmpty(this.lnr.uvi())) {
                    textView.setText(this.lnr.uvi());
                } else {
                    textView.setVisibility(8);
                }
                ax.qdl((TextView) null, this.exu.mml, this.lnr);
                qdl((View) exuVar, true);
                exuVar.setTag(520093762, Boolean.TRUE);
                qdl((View) this, true);
                qdl((View) textView, true);
                return;
            }
            qdl qdlVarTvp = tvp();
            this.exu = qdlVarTvp;
            TextView textView5 = qdlVarTvp.ud;
            TextView textView6 = this.exu.wd;
            fs fsVar = this.exu.jpc;
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.lnr.tdy().to(), this.exu.mzz);
            View view2 = this.exu.mo;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.ud.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        TTWebsiteActivity.qdl(ud.this.ud, ud.this.lnr, ud.this.mo);
                    }
                });
            }
            ViewGroup.LayoutParams layoutParams2 = fsVar.getLayoutParams();
            if (iVxg == 15) {
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                fsVar.setLayoutParams(layoutParams2);
                fsVar.setRatio(0.5625f);
            } else if (iVxg == 5) {
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                fsVar.setLayoutParams(layoutParams2);
                fsVar.setRatio(1.7777778f);
            } else {
                if (this.wd - (ax.ud(this.ud, 8.0f) * 2) >= ((this.jpc - ax.ud(this.ud, 8.0f)) - (ax.ud(this.ud, 21.0f) * 2)) - ax.ud(this.ud, 52.0f)) {
                    layoutParams2.width = -2;
                    layoutParams2.height = -1;
                } else {
                    layoutParams2.width = -1;
                    layoutParams2.height = -2;
                }
                fsVar.setLayoutParams(layoutParams2);
                fsVar.setRatio(1.0f);
            }
            fsVar.removeAllViews();
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            com.bytedance.sdk.openadsdk.core.exu.ud.mo videoView = getVideoView();
            if (videoView != null) {
                if (this.rdp instanceof exc) {
                    videoView.setNeedSelfManagerVideo(!((exc) r7).exu());
                    ((exc) this.rdp).setBackupVideoView(videoView);
                    videoView.setVideoAdInteractionListener((exc) this.rdp);
                }
                fsVar.addView(videoView, layoutParams3);
                videoView.setAdCreativeClickListener(new mo.qdl() { // from class: com.bytedance.sdk.openadsdk.core.mml.ud.5
                    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo.qdl
                    public void qdl(View view3, int i) {
                        if (ud.this.jtx != null) {
                            ud.this.jtx.onAdClicked();
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.core.tvp.jpc clickCreativeListener = this.rdp.getClickCreativeListener();
                if (clickCreativeListener != null) {
                    clickCreativeListener.qdl(videoView.getNativeVideoController());
                }
            }
            if (this.lnr.hcs() != null && !TextUtils.isEmpty(this.lnr.hcs().qdl())) {
                com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.lnr.hcs().qdl(), this.lnr.hcs().ud(), this.lnr.hcs().lnr(), this.exu.lnr, this.lnr);
            }
            textView5.setText(this.lnr.gsv());
            ax.qdl((TextView) null, this.exu.mml, this.lnr);
            if (!TextUtils.isEmpty(this.lnr.uvi())) {
                textView6.setText(this.lnr.uvi());
            } else {
                textView6.setVisibility(8);
            }
            qdl((View) videoView, true);
            if (videoView != null) {
                videoView.setTag(520093762, Boolean.TRUE);
            }
            qdl((View) this, true);
            qdl((View) textView6, true);
            qdl(fsVar);
        }
    }

    public static jl qdl(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 450.0d) / 600.0d) ? qdl[1] : qdl[0];
        } catch (Throwable unused) {
            return qdl[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.qdl
    public void qdl() {
        if (this.mzz != null) {
            this.mzz.show();
        } else if (this.mml != null) {
            this.mml.qdl();
        } else {
            TTDelegateActivity.qdl(this.lnr, this.bjy);
        }
    }

    private qdl mo() {
        int iUd = ax.ud(this.ud, 8.0f);
        exu exuVar = new exu(this.ud);
        exuVar.setId(520093736);
        exuVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(exuVar, layoutParams);
        View viewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.ud, this.lnr);
        viewCreatePAGLogoViewByMaterial.setId(520093739);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(iUd, iUd, 0, 0);
        layoutParams2.gravity = BadgeDrawable.TOP_START;
        viewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams2);
        addView(viewCreatePAGLogoViewByMaterial);
        return new qdl(viewCreatePAGLogoViewByMaterial, exuVar);
    }

    private qdl wd() {
        int iUd = ax.ud(this.ud, 38.0f);
        int iUd2 = (int) (((double) ax.ud(this.ud, 25.0f)) / 5.0d);
        int iUd3 = ax.ud(this.ud, 10.0f);
        int iUd4 = ax.ud(this.ud, 2.0f);
        int iUd5 = ax.ud(this.ud, 6.0f);
        int iUd6 = ax.ud(this.ud, 8.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.ud);
        addView(relativeLayout, -1, -1);
        yt ytVar = new yt(this.ud);
        ytVar.setId(520093738);
        TextView textView = new TextView(this.ud);
        textView.setId(520093730);
        com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar = new com.bytedance.sdk.openadsdk.core.widget.jtx(this.ud);
        jtxVar.setId(520093735);
        View viewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.ud, this.lnr);
        viewCreatePAGLogoViewByMaterial.setId(520093739);
        TextView textView2 = new TextView(this.ud);
        textView2.setId(520093703);
        qdl qdlVar = new qdl(ytVar, textView, jtxVar, viewCreatePAGLogoViewByMaterial, textView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iUd, iUd);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.setMarginStart(iUd5);
        layoutParams.setMargins(iUd5, 0, 0, 0);
        ytVar.setLayoutParams(layoutParams);
        ytVar.setBackgroundColor(-1);
        ytVar.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(ytVar);
        LinearLayout linearLayout = new LinearLayout(this.ud);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(16, textView2.getId());
        layoutParams2.addRule(17, ytVar.getId());
        layoutParams2.setMarginStart(iUd6);
        layoutParams2.setMarginEnd(iUd6);
        layoutParams2.addRule(0, textView2.getId());
        layoutParams2.addRule(1, ytVar.getId());
        layoutParams2.setMargins(iUd6, 0, iUd6, 0);
        relativeLayout.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        textView.setTextDirection(5);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(80);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF333333"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = iUd4;
        jtxVar.setLayoutParams(layoutParams4);
        linearLayout.addView(jtxVar);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(20);
        layoutParams5.addRule(9);
        layoutParams5.addRule(12);
        viewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams5);
        relativeLayout.addView(viewCreatePAGLogoViewByMaterial);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.setMarginEnd(iUd5);
        layoutParams6.addRule(21);
        layoutParams6.rightMargin = iUd5;
        textView2.setBackground(rq.qdl(this.ud, 12));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setPadding(iUd3, iUd2, iUd3, iUd2);
        textView2.setText(com.bytedance.sdk.component.utils.ljh.qdl(this.ud, "tt_video_download_apk"));
        textView2.setTextColor(Color.parseColor("#f0f0f0"));
        textView2.setTextSize(10.0f);
        textView2.setLayoutParams(layoutParams6);
        relativeLayout.addView(textView2);
        return qdlVar;
    }

    private qdl jpc() {
        int iUd = ax.ud(this.ud, 8.0f);
        int iUd2 = ax.ud(this.ud, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.ud);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(iUd, iUd, iUd, iUd2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.ud);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        yt ytVar = new yt(this.ud);
        ytVar.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ax.ud(this.ud, 52.0f), ax.ud(this.ud, 52.0f));
        ytVar.setScaleType(ImageView.ScaleType.FIT_XY);
        ytVar.setLayoutParams(layoutParams3);
        linearLayout.addView(ytVar);
        LinearLayout linearLayout2 = new LinearLayout(this.ud);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = iUd;
        layoutParams4.rightMargin = iUd;
        layoutParams4.setMarginStart(iUd);
        layoutParams4.setMarginEnd(iUd);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.ud);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(16.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar = new com.bytedance.sdk.openadsdk.core.widget.jtx(this.ud);
        jtxVar.setId(520093735);
        linearLayout2.addView(jtxVar, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.ud);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(ax.ud(this.ud, 76.0f), ax.ud(this.ud, 36.0f));
        textView2.setBackground(rq.qdl(this.ud, 18));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.ljh.qdl(this.ud, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams6);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.ud);
        frameLayout.setLayoutDirection(3);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams7.addRule(2, linearLayout.getId());
        layoutParams7.bottomMargin = iUd2;
        frameLayout.setLayoutParams(layoutParams7);
        relativeLayout.addView(frameLayout);
        exu exuVar = new exu(this.ud);
        exuVar.setId(520093736);
        exuVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams8.gravity = 17;
        frameLayout.addView(exuVar, layoutParams8);
        View viewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.ud, this.lnr);
        viewCreatePAGLogoViewByMaterial.setId(520093739);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(10);
        layoutParams9.addRule(9);
        layoutParams9.setMargins(iUd, iUd, 0, 0);
        viewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams9);
        relativeLayout.addView(viewCreatePAGLogoViewByMaterial);
        return new qdl(ytVar, viewCreatePAGLogoViewByMaterial, textView2, textView, exuVar, jtxVar, frameLayout);
    }

    private qdl tvp() {
        int iUd = ax.ud(this.ud, 8.0f);
        int iUd2 = ax.ud(this.ud, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.ud);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(iUd, iUd, iUd, iUd2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.ud);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        yt ytVar = new yt(this.ud);
        ytVar.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ax.ud(this.ud, 52.0f), ax.ud(this.ud, 52.0f));
        ytVar.setScaleType(ImageView.ScaleType.FIT_XY);
        ytVar.setLayoutParams(layoutParams3);
        linearLayout.addView(ytVar);
        LinearLayout linearLayout2 = new LinearLayout(this.ud);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = iUd;
        layoutParams4.rightMargin = iUd;
        layoutParams4.setMarginStart(iUd);
        layoutParams4.setMarginEnd(iUd);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.ud);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(16.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar = new com.bytedance.sdk.openadsdk.core.widget.jtx(this.ud);
        jtxVar.setId(520093735);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = ax.ud(this.ud, 4.0f);
        linearLayout2.addView(jtxVar, layoutParams6);
        TextView textView2 = new TextView(this.ud);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(ax.ud(this.ud, 76.0f), ax.ud(this.ud, 36.0f));
        textView2.setBackground(rq.qdl(this.ud, 18));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.ljh.qdl(this.ud, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams7);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.ud);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams8.addRule(2, linearLayout.getId());
        layoutParams8.bottomMargin = iUd2;
        frameLayout.setLayoutParams(layoutParams8);
        relativeLayout.addView(frameLayout);
        fs fsVar = new fs(this.ud);
        fsVar.setId(520093736);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams9.gravity = 17;
        fsVar.setLayoutParams(layoutParams9);
        frameLayout.addView(fsVar);
        View viewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.ud, this.lnr);
        viewCreatePAGLogoViewByMaterial.setId(520093739);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(10);
        layoutParams10.addRule(9);
        layoutParams10.setMargins(iUd, iUd, 0, 0);
        viewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams10);
        relativeLayout.addView(viewCreatePAGLogoViewByMaterial);
        return new qdl(ytVar, viewCreatePAGLogoViewByMaterial, textView2, textView, fsVar, jtxVar, frameLayout);
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.jtx = pAGBannerAdWrapperListener;
    }

    private static class qdl {
        private fs jpc;
        ImageView lnr;
        com.bytedance.sdk.openadsdk.core.widget.jtx mml;
        View mo;
        FrameLayout mzz;
        public exu qdl;
        public TextView ud;
        TextView wd;

        qdl(ImageView imageView, TextView textView, com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, View view, TextView textView2) {
            this.lnr = imageView;
            this.ud = textView;
            this.mml = jtxVar;
            this.mo = view;
            this.wd = textView2;
        }

        public qdl(ImageView imageView, View view, TextView textView, TextView textView2, exu exuVar, com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, FrameLayout frameLayout) {
            this.lnr = imageView;
            this.mo = view;
            this.wd = textView;
            this.ud = textView2;
            this.qdl = exuVar;
            this.mml = jtxVar;
            this.mzz = frameLayout;
        }

        public qdl(ImageView imageView, View view, TextView textView, TextView textView2, fs fsVar, com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, FrameLayout frameLayout) {
            this.lnr = imageView;
            this.mo = view;
            this.wd = textView;
            this.ud = textView2;
            this.jpc = fsVar;
            this.mml = jtxVar;
            this.mzz = frameLayout;
        }

        public qdl(View view, exu exuVar) {
            this.mo = view;
            this.qdl = exuVar;
        }
    }
}
