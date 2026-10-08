package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.tvp.mo;
import com.bytedance.sdk.component.utils.ljh;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.bjy;
import com.bytedance.sdk.openadsdk.common.fs;
import com.bytedance.sdk.openadsdk.common.jtx;
import com.bytedance.sdk.openadsdk.common.rdp;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.rq;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTVideoLandingPageLink2Activity extends TTVideoLandingPageActivity implements com.bytedance.sdk.openadsdk.to.mml {
    private TextView car;
    private LinearLayout en;
    bjy gt;
    private boolean ijp;
    TTAdDislikeToast irn;
    private PAGLogoView kab;
    private long lte;
    private TextView mlb;
    private com.bytedance.sdk.openadsdk.common.mml nz;
    private com.bytedance.sdk.openadsdk.core.widget.qdl.mzz ra;
    private boolean sy;
    private View taz;
    private View tid;
    private fs zlt;
    private jtx zy;
    private boolean dk = false;
    final AtomicBoolean xi = new AtomicBoolean(false);
    final AtomicBoolean jjk = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!rdp.mzz() || this.jtx == null || this.qdl == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.common.mml mmlVarQdl = gy.qdl(this.jtx, this.qdl, this.mzz, this.kdv);
        this.nz = mmlVarQdl;
        if (mmlVarQdl != null) {
            mmlVarQdl.qdl("landingpage_split_screen");
        }
        this.ijp = yt.mml().kdv();
        if (this.qdl.getWebView() != null) {
            this.qdl.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (TTVideoLandingPageLink2Activity.this.ax != null) {
                        TTVideoLandingPageLink2Activity.this.ax.ud(i2);
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.widget.qdl.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.widget.qdl.mzz(this.mzz, this.to, this.mo, this.nz, this.ax, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mzz, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageLink2Activity.this.taz != null && !TTVideoLandingPageLink2Activity.this.sy) {
                        TTVideoLandingPageLink2Activity.this.taz.setVisibility(8);
                    }
                    if (TTVideoLandingPageLink2Activity.this.en != null) {
                        TTVideoLandingPageLink2Activity.this.en.setVisibility(0);
                    }
                    TTVideoLandingPageLink2Activity.this.dk = true;
                    TTVideoLandingPageLink2Activity.this.jtx();
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl(TTVideoLandingPageLink2Activity.this.jtx, TTVideoLandingPageLink2Activity.this.kdv, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.lte, true);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mzz, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                TTVideoLandingPageLink2Activity.this.lte = System.currentTimeMillis();
            }
        };
        this.ra = mzzVar;
        mzzVar.qdl(this.jtx);
        this.qdl.setWebViewClient(this.ra);
        this.qdl.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.qdl.mml(this.to, this.ax, this.nz) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.8
            @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mml, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoLandingPageLink2Activity.this.ijp && TTVideoLandingPageLink2Activity.this.zy != null && i == 100) {
                    TTVideoLandingPageLink2Activity.this.zy.qdl(webView, TTVideoLandingPageLink2Activity.this.cx);
                }
                if (TTVideoLandingPageLink2Activity.this.zlt != null) {
                    TTVideoLandingPageLink2Activity.this.zlt.qdl(i);
                }
            }
        });
        TextView textView = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.djz);
        if (textView != null && this.jtx.aaj() != null) {
            textView.setText(this.jtx.aaj().mzz());
        }
        rdp.lnr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTVideoLandingPageLink2Activity.this.sy = true;
                    if (TTVideoLandingPageLink2Activity.this.zlt != null) {
                        TTVideoLandingPageLink2Activity.this.zlt.ud();
                    }
                    TTVideoLandingPageLink2Activity.this.tid.setVisibility(0);
                    if (TTVideoLandingPageLink2Activity.this.kab != null) {
                        TTVideoLandingPageLink2Activity.this.kab.setVisibility(0);
                    }
                    if (TTVideoLandingPageLink2Activity.this.dk) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl(TTVideoLandingPageLink2Activity.this.jtx, TTVideoLandingPageLink2Activity.this.kdv, System.currentTimeMillis() - TTVideoLandingPageLink2Activity.this.lte, false);
                } catch (Exception unused) {
                }
            }
        }, (this.jtx == null || this.jtx.aaj() == null) ? 10000L : this.jtx.aaj().qdl() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected View lnr() {
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.mo.mzz(this);
        if (Build.VERSION.SDK_INT >= 35) {
            mzzVar.setFitsSystemWindows(true);
        }
        mzzVar.setOrientation(1);
        mzzVar.setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(this);
        mzzVar.addView(lnrVar, new LinearLayout.LayoutParams(-1, ax.ud(this, 220.0f)));
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar2 = new com.bytedance.sdk.openadsdk.core.mo.lnr(this);
        lnrVar2.setId(com.bytedance.sdk.openadsdk.utils.jtx.fco);
        lnrVar.addView(lnrVar2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar2 = new com.bytedance.sdk.openadsdk.core.mo.mzz(this);
        mzzVar2.setOrientation(0);
        mzzVar2.setPadding(0, ax.ud(this, 20.0f), 0, 0);
        lnrVar.addView(mzzVar2, new FrameLayout.LayoutParams(-1, -2));
        View view = new View(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        mzzVar2.addView(view, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.bjy bjyVar = new com.bytedance.sdk.openadsdk.core.widget.bjy(this);
        bjyVar.setId(520093713);
        bjyVar.setGravity(17);
        bjyVar.setText(ljh.qdl(this, "tt_reward_feedback"));
        bjyVar.setTextColor(-1);
        bjyVar.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, ax.ud(this, 28.0f));
        int iUd = ax.ud(this, 16.0f);
        layoutParams2.rightMargin = iUd;
        layoutParams2.leftMargin = iUd;
        mzzVar2.addView(bjyVar, layoutParams2);
        com.bytedance.sdk.openadsdk.core.widget.rdp rdpVar = new com.bytedance.sdk.openadsdk.core.widget.rdp(this);
        rdpVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.mrf);
        rdpVar.setPadding(ax.ud(this, 7.0f), ax.ud(this, 7.0f), ax.ud(this, 7.0f), ax.ud(this, 7.0f));
        rdpVar.setImageResource(ljh.mml(this, "tt_video_close_drawable"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ax.ud(this, 28.0f), ax.ud(this, 28.0f));
        layoutParams3.rightMargin = ax.ud(this, 12.0f);
        mzzVar2.addView(rdpVar, layoutParams3);
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar = new com.bytedance.sdk.openadsdk.core.mo.wd(this);
        wdVar.setVisibility(8);
        wdVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.gy);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = ax.ud(this, 10.0f);
        mzzVar.addView(wdVar, layoutParams4);
        com.bytedance.sdk.openadsdk.core.widget.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.widget.qdl(this);
        qdlVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.ax);
        qdlVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        qdlVar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(ax.ud(this, 44.0f), ax.ud(this, 44.0f));
        layoutParams5.addRule(9);
        layoutParams5.leftMargin = ax.ud(this, 5.0f);
        wdVar.addView(qdlVar, layoutParams5);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar = new com.bytedance.sdk.openadsdk.core.mo.jpc(this);
        jpcVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.ag);
        jpcVar.setBackground(rq.qdl(this, "tt_circle_solid_mian"));
        jpcVar.setGravity(17);
        jpcVar.setTextColor(-1);
        jpcVar.setTextSize(2, 19.0f);
        jpcVar.setTypeface(Typeface.DEFAULT_BOLD);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(ax.ud(this, 44.0f), ax.ud(this, 44.0f));
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = ax.ud(this, 5.0f);
        wdVar.addView(jpcVar, layoutParams6);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar2 = new com.bytedance.sdk.openadsdk.core.mo.jpc(this);
        jpcVar2.setId(com.bytedance.sdk.openadsdk.utils.jtx.wc);
        jpcVar2.setMaxLines(1);
        jpcVar2.setEllipsize(TextUtils.TruncateAt.END);
        jpcVar2.setTextColor(Color.parseColor("#e5000000"));
        jpcVar2.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(15);
        layoutParams7.leftMargin = ax.ud(this, 5.0f);
        layoutParams7.rightMargin = ax.ud(this, 80.0f);
        layoutParams7.addRule(1, com.bytedance.sdk.openadsdk.utils.jtx.ag);
        wdVar.addView(jpcVar2, layoutParams7);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar3 = new com.bytedance.sdk.openadsdk.core.mo.jpc(this);
        jpcVar3.setId(com.bytedance.sdk.openadsdk.utils.jtx.om);
        jpcVar3.setClickable(true);
        jpcVar3.setMaxLines(1);
        jpcVar3.setEllipsize(TextUtils.TruncateAt.END);
        jpcVar3.setFocusable(true);
        jpcVar3.setGravity(17);
        jpcVar3.setText(ljh.qdl(this, "tt_video_mobile_go_detail"));
        jpcVar3.setTextColor(-1);
        jpcVar3.setTextSize(2, 14.0f);
        jpcVar3.setPadding(ax.ud(this, 2.0f), ax.ud(this, 2.0f), ax.ud(this, 2.0f), ax.ud(this, 2.0f));
        jpcVar3.setBackground(rq.qdl(this, "tt_ad_cover_btn_begin_bg"));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(ax.ud(this, 90.0f), ax.ud(this, 36.0f));
        layoutParams8.addRule(11);
        layoutParams8.addRule(15);
        layoutParams8.rightMargin = ax.ud(this, 5.0f);
        wdVar.addView(jpcVar3, layoutParams8);
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar3 = new com.bytedance.sdk.openadsdk.core.mo.lnr(this);
        mzzVar.addView(lnrVar3, new LinearLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.component.tvp.mo moVar = new com.bytedance.sdk.component.tvp.mo(this, mo.lnr.LANDING_PAGE);
        moVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.cx);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.topMargin = ax.ud(this, 2.0f);
        lnrVar3.addView(moVar, layoutParams9);
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar2 = new com.bytedance.sdk.openadsdk.core.mo.wd(this);
        wdVar2.setId(com.bytedance.sdk.openadsdk.utils.jtx.yh);
        wdVar2.setBackgroundColor(Color.parseColor("#F8F8F8"));
        lnrVar3.addView(wdVar2, new FrameLayout.LayoutParams(-1, -1));
        fs fsVar = new fs(this);
        fsVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.wak);
        wdVar2.addView(fsVar, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar3 = new com.bytedance.sdk.openadsdk.core.mo.mzz(this);
        mzzVar3.setId(com.bytedance.sdk.openadsdk.utils.jtx.hzv);
        mzzVar3.setOrientation(1);
        mzzVar3.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams10.addRule(13);
        wdVar2.addView(mzzVar3, layoutParams10);
        com.bytedance.sdk.openadsdk.core.widget.yt ytVar = new com.bytedance.sdk.openadsdk.core.widget.yt(this);
        ytVar.setId(com.bytedance.sdk.openadsdk.utils.jtx.gt);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(ax.ud(this, 80.0f), ax.ud(this, 80.0f));
        layoutParams11.gravity = 17;
        mzzVar3.addView(ytVar, layoutParams11);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar4 = new com.bytedance.sdk.openadsdk.core.mo.jpc(this);
        jpcVar4.setId(com.bytedance.sdk.openadsdk.utils.jtx.irn);
        jpcVar4.setTextColor(Color.parseColor("#161823"));
        jpcVar4.setTextSize(0, ax.ud(this, 24.0f));
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.gravity = 17;
        layoutParams12.topMargin = ax.ud(this, 12.0f);
        mzzVar3.addView(jpcVar4, layoutParams12);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar5 = new com.bytedance.sdk.openadsdk.core.mo.jpc(this);
        jpcVar5.setId(com.bytedance.sdk.openadsdk.utils.jtx.xi);
        jpcVar5.setTextColor(Color.parseColor("#80161823"));
        jpcVar5.setTextSize(0, ax.ud(this, 16.0f));
        jpcVar5.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.gravity = 17;
        int iUd2 = ax.ud(this, 60.0f);
        layoutParams13.rightMargin = iUd2;
        layoutParams13.leftMargin = iUd2;
        layoutParams13.topMargin = ax.ud(this, 8.0f);
        mzzVar3.addView(jpcVar5, layoutParams13);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar6 = new com.bytedance.sdk.openadsdk.core.mo.jpc(this);
        jpcVar6.setId(com.bytedance.sdk.openadsdk.utils.jtx.jjk);
        jpcVar6.setGravity(17);
        jpcVar6.setTextColor(-1);
        jpcVar6.setText(ljh.qdl(this, "tt_video_mobile_go_detail"));
        jpcVar6.setBackground(rq.qdl(this, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(ax.ud(this, 255.0f), ax.ud(this, 44.0f));
        layoutParams14.gravity = 17;
        layoutParams14.topMargin = ax.ud(this, 32.0f);
        mzzVar3.addView(jpcVar6, layoutParams14);
        PAGLogoView pAGLogoView = new PAGLogoView(this);
        this.kab = pAGLogoView;
        pAGLogoView.setId(com.bytedance.sdk.openadsdk.utils.jtx.zlt);
        this.kab.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, ax.ud(this, 14.0f));
        layoutParams15.addRule(12);
        layoutParams15.leftMargin = ax.ud(this, 18.0f);
        layoutParams15.bottomMargin = ax.ud(this, 61.0f);
        wdVar2.addView(this.kab, layoutParams15);
        com.bytedance.sdk.openadsdk.common.rdp rdpVar2 = new com.bytedance.sdk.openadsdk.common.rdp(this, new rdp.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.10
            @Override // com.bytedance.sdk.openadsdk.common.rdp.qdl
            public View qdl(Context context) {
                return new com.bytedance.sdk.openadsdk.common.wd(context);
            }
        });
        rdpVar2.setId(com.bytedance.sdk.openadsdk.utils.jtx.taz);
        FrameLayout.LayoutParams layoutParams16 = new FrameLayout.LayoutParams(-1, ax.ud(this, 48.0f));
        layoutParams16.gravity = 81;
        lnrVar3.addView(rdpVar2, layoutParams16);
        com.bytedance.sdk.openadsdk.common.rdp rdpVar3 = new com.bytedance.sdk.openadsdk.common.rdp(this, new rdp.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.11
            @Override // com.bytedance.sdk.openadsdk.common.rdp.qdl
            public View qdl(Context context) {
                return new com.bytedance.sdk.openadsdk.common.jpc(context);
            }
        });
        rdpVar3.setId(com.bytedance.sdk.openadsdk.utils.jtx.tid);
        FrameLayout.LayoutParams layoutParams17 = new FrameLayout.LayoutParams(-1, ax.ud(this, 44.0f));
        layoutParams17.gravity = 80;
        lnrVar3.addView(rdpVar3, layoutParams17);
        return mzzVar;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void mzz() {
        super.mzz();
        TextView textView = (TextView) findViewById(520093713);
        if (textView != null) {
            textView.setText(ljh.qdl(yt.qdl(), "tt_reward_feedback"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoLandingPageLink2Activity.this.rdp();
                }
            });
        }
        this.car = (TextView) findViewById(520093714);
        this.zlt = (fs) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.wak);
        this.taz = findViewById(com.bytedance.sdk.openadsdk.utils.jtx.yh);
        this.tid = findViewById(com.bytedance.sdk.openadsdk.utils.jtx.hzv);
        TextView textView2 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.irn);
        TextView textView3 = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.xi);
        com.bytedance.sdk.openadsdk.core.widget.yt ytVar = (com.bytedance.sdk.openadsdk.core.widget.yt) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.gt);
        this.mlb = (TextView) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.jjk);
        if (this.jtx.hcs() != null && !TextUtils.isEmpty(this.jtx.hcs().qdl())) {
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.jtx.hcs(), ytVar, this.jtx);
        }
        textView2.setText(this.jtx.ca());
        textView3.setText(this.jtx.hvi());
        View viewFindViewById = findViewById(com.bytedance.sdk.openadsdk.utils.jtx.zlt);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTWebsiteActivity.qdl(TTVideoLandingPageLink2Activity.this.mzz, TTVideoLandingPageLink2Activity.this.jtx, TTVideoLandingPageLink2Activity.this.kdv);
            }
        });
        if (viewFindViewById instanceof PAGLogoView) {
            ((PAGLogoView) viewFindViewById).initData(this.jtx);
        }
        if (this.qdl != null && this.qdl.getWebView() != null) {
            gy.qdl(this.jtx, this.qdl);
        }
        boolean zKdv = yt.mml().kdv();
        this.ijp = zKdv;
        if (zKdv) {
            ((com.bytedance.sdk.openadsdk.common.rdp) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.tid)).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) findViewById(com.bytedance.sdk.openadsdk.utils.jtx.kab);
            this.en = linearLayout;
            linearLayout.setVisibility(8);
            this.zy = new jtx(this, this.en, this.qdl, this.jtx, "landingpage_split_screen");
            if (this.qdl.getWebView() != null) {
                this.qdl.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.14
                    float qdl = 0.0f;

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (motionEvent.getAction() == 0) {
                            this.qdl = motionEvent.getY();
                        }
                        if (TTVideoLandingPageLink2Activity.this.ax != null) {
                            TTVideoLandingPageLink2Activity.this.ax.qdl(motionEvent);
                        }
                        if (TTVideoLandingPageLink2Activity.this.nz != null) {
                            TTVideoLandingPageLink2Activity.this.nz.qdl(motionEvent);
                        }
                        if (motionEvent.getAction() == 2) {
                            float y = motionEvent.getY();
                            float f = this.qdl;
                            if (y - f > 8.0f) {
                                if (TTVideoLandingPageLink2Activity.this.zy != null) {
                                    TTVideoLandingPageLink2Activity.this.zy.qdl();
                                }
                                return false;
                            }
                            if (y - f < -8.0f && TTVideoLandingPageLink2Activity.this.zy != null) {
                                TTVideoLandingPageLink2Activity.this.zy.ud();
                            }
                        }
                        return false;
                    }
                });
            }
        } else if (this.qdl.getWebView() != null) {
            this.qdl.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTVideoLandingPageLink2Activity.this.ax != null) {
                        TTVideoLandingPageLink2Activity.this.ax.qdl(motionEvent);
                    }
                    if (TTVideoLandingPageLink2Activity.this.nz == null) {
                        return false;
                    }
                    TTVideoLandingPageLink2Activity.this.nz.qdl(motionEvent);
                    return false;
                }
            });
        }
        fs fsVar = this.zlt;
        if (fsVar != null) {
            fsVar.qdl(this.jtx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjy() {
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.jtx, "landingpage_split_screen", "click_video", (JSONObject) null);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fs fsVar = this.zlt;
        if (fsVar != null) {
            fsVar.qdl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected void mo() {
        if (wd()) {
            super.mo();
            if (this.rdp != null) {
                if (this.rdp.getNativeVideoController() != null) {
                    this.rdp.getNativeVideoController().qdl(false);
                    this.rdp.getNativeVideoController().mo(false);
                    this.fs.setClickable(true);
                    this.fs.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.3
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 0) {
                                return false;
                            }
                            TTVideoLandingPageLink2Activity.this.bjy();
                            return false;
                        }
                    });
                }
                this.rdp.getNativeVideoController().qdl(new lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.4
                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
                    public void qdl() {
                    }

                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
                    public void qdl(long j, int i) {
                    }

                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
                    public void ud(long j, int i) {
                    }

                    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.qdl
                    public void qdl(long j, long j2) {
                        if (TTVideoLandingPageLink2Activity.this.car != null) {
                            int iMax = (int) Math.max(0L, (j2 - j) / 1000);
                            TTVideoLandingPageLink2Activity.this.car.setText(String.valueOf(iMax));
                            if (iMax <= 0) {
                                TTVideoLandingPageLink2Activity.this.car.setVisibility(8);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.jtx.vm().get(0), imageView, this.jtx);
            this.fs.setVisibility(0);
            this.fs.removeAllViews();
            this.fs.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.mml.lnr.ud(TTVideoLandingPageLink2Activity.this.jtx, "landingpage_split_screen");
                }
            });
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    protected boolean wd() {
        return this.exu == 5 || this.exu == 15 || this.exu == 50;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity
    public void rq() {
        super.rq();
        if (this.jtx != null) {
            this.jtx.rq(true);
        }
        TextView textView = this.mlb;
        if (textView != null) {
            textView.setText(mml());
            this.mlb.setClickable(true);
            this.mlb.setOnClickListener(this.wak);
            this.mlb.setOnTouchListener(this.wak);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtx() {
        fs fsVar = this.zlt;
        if (fsVar != null) {
            fsVar.ud();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        jtx();
        if (!this.sy && this.ax != null && this.qdl != null && this.zlt.getVisibility() == 8) {
            this.ax.qdl(this.qdl);
        }
        super.onDestroy();
    }

    private void yt() {
        TTAdDislikeToast tTAdDislikeToast = this.irn;
        if (tTAdDislikeToast == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
    }

    protected void rdp() {
        if (isFinishing()) {
            return;
        }
        if (this.jjk.get()) {
            yt();
            return;
        }
        if (this.gt == null) {
            jl();
        }
        bjy bjyVar = this.gt;
        if (bjyVar != null) {
            bjyVar.qdl();
        }
    }

    private void jl() {
        try {
            if (this.gt == null) {
                bjy bjyVar = new bjy(this.mzz, this.jtx);
                this.gt = bjyVar;
                bjyVar.setDislikeSource("landing_page");
                this.gt.setCallback(new bjy.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity.6
                    @Override // com.bytedance.sdk.openadsdk.common.bjy.qdl
                    public void qdl(View view) {
                        TTVideoLandingPageLink2Activity.this.xi.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.bjy.qdl
                    public void ud(View view) {
                        TTVideoLandingPageLink2Activity.this.xi.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.bjy.qdl
                    public void qdl(FilterWord filterWord) {
                        if (TTVideoLandingPageLink2Activity.this.jjk.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        TTVideoLandingPageLink2Activity.this.jjk.set(true);
                        TTVideoLandingPageLink2Activity.this.exc();
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
            frameLayout.addView(this.gt);
            if (this.irn == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.mzz);
                this.irn = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTVideoLandingPageLink2Activity", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exc() {
        TTAdDislikeToast tTAdDislikeToast;
        if (isFinishing() || (tTAdDislikeToast = this.irn) == null) {
            return;
        }
        tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
    }
}
