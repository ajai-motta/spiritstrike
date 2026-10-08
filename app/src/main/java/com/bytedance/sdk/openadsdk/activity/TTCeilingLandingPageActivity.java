package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.tvp.mo;
import com.bytedance.sdk.component.utils.vu;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.koa;
import com.bytedance.sdk.openadsdk.core.model.exc;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.widget.qdl.mo;
import com.bytedance.sdk.openadsdk.mml.fs;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jyq;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: classes3.dex */
public class TTCeilingLandingPageActivity extends TTBaseLandingPageActivity {
    private com.bytedance.sdk.component.tvp.mo fs;
    private hkc lnr;
    private String mml;
    private int mo;
    private String mzz;
    qdl qdl;
    private com.bytedance.sdk.openadsdk.common.mml rq;
    private fs to;
    private ljh ud;
    private String wd;

    public interface qdl {
        void qdl();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!rdp.mzz()) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.mo = intent.getIntExtra("source", -1);
        ljh ljhVarQdl = koa.qdl().qdl(koa.qdl(intent));
        this.ud = ljhVarQdl;
        if (ljhVarQdl == null) {
            finish();
            return;
        }
        this.wd = ljhVarQdl.tvp();
        this.mml = this.ud.yre();
        this.mzz = this.ud.ir();
        this.mo = this.ud.ji().getDurationSlotType() != 7 ? 5 : 7;
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(this);
        qdl(this, lnrVar);
        setContentView(lnrVar);
        lnr();
    }

    private void qdl(Context context, FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.core.mo.mml mmlVar;
        this.fs = new com.bytedance.sdk.component.tvp.mo(context, mo.lnr.LANDING_PAGE);
        frameLayout.addView(this.fs, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.mo.mml mmlVarUd = com.bytedance.sdk.openadsdk.core.widget.mo.ud(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = ax.ud(context, 18.0f);
        layoutParams.rightMargin = ax.ud(context, 18.0f);
        frameLayout.addView(mmlVarUd, layoutParams);
        final int iWd = this.ud.oth().wd();
        if (iWd != 3) {
            mmlVar = new com.bytedance.sdk.openadsdk.core.mo.mml(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ax.ud(context, 28.0f), ax.ud(context, 28.0f));
            layoutParams2.gravity = BadgeDrawable.TOP_START;
            layoutParams2.topMargin = ax.ud(context, 18.0f);
            layoutParams2.leftMargin = ax.ud(context, 18.0f);
            int iUd = ax.ud(context, 5.0f);
            mmlVar.setPadding(iUd, iUd, iUd, iUd);
            mmlVar.setScaleType(ImageView.ScaleType.FIT_XY);
            mmlVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.mml.qdl());
            mmlVar.setImageDrawable(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_white_lefterbackicon_titlebar"));
            frameLayout.addView(mmlVar, layoutParams2);
        } else {
            mmlVar = null;
        }
        jyq.qdl(this.fs, this.wd);
        final WebView webView = this.fs.getWebView();
        mmlVarUd.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTCeilingLandingPageActivity.this.finish();
            }
        });
        fs fsVar = new fs(this.ud, webView, true);
        this.to = fsVar;
        fsVar.qdl("landingpage_split_ceiling");
        final mo.qdl qdlVar = this.to.qdl;
        if (mmlVar != null) {
            mmlVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = iWd;
                    if (i == 1) {
                        TTCeilingLandingPageActivity.this.finish();
                    } else if (i != 2) {
                        return;
                    }
                    WebView webView2 = webView;
                    if (webView2 != null && webView2.canGoBack()) {
                        webView.goBack();
                        mo.qdl qdlVar2 = qdlVar;
                        if (qdlVar2 != null) {
                            qdlVar2.qdl();
                            return;
                        }
                        return;
                    }
                    TTCeilingLandingPageActivity.this.finish();
                }
            });
        }
        com.bytedance.sdk.openadsdk.common.mml mmlVarQdl = gy.qdl(this.ud, this.fs, this, "landingpage_split_ceiling");
        this.rq = mmlVarQdl;
        if (mmlVarQdl != null) {
            mmlVarQdl.qdl("landingpage_split_ceiling");
            this.rq.qdl();
        }
        gy.qdl(this.ud, this.fs, true);
        this.qdl = new qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.3
            @Override // com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.qdl
            public void qdl() {
                if (TTCeilingLandingPageActivity.this.ud.oth().jpc() == exc.ud) {
                    TTCeilingLandingPageActivity.this.finish();
                }
            }
        };
        com.bytedance.sdk.openadsdk.core.widget.qdl.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.widget.qdl.mzz(this, this.lnr, this.mml, this.rq, this.to, true, true, this.qdl) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mzz, android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }
        };
        mzzVar.qdl(this.ud);
        com.bytedance.sdk.openadsdk.core.widget.qdl.mml mmlVar2 = new com.bytedance.sdk.openadsdk.core.widget.qdl.mml(this.lnr, this.to, this.rq) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mml, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                super.onProgressChanged(webView2, i);
            }
        };
        com.bytedance.sdk.component.tvp.mo moVar = this.fs;
        if (moVar != null) {
            moVar.setWebViewClient(mzzVar);
            this.fs.setWebChromeClient(mmlVar2);
        }
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTCeilingLandingPageActivity.this.to == null) {
                        return false;
                    }
                    TTCeilingLandingPageActivity.this.to.qdl(motionEvent);
                    return false;
                }
            });
            webView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.7
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (TTCeilingLandingPageActivity.this.to != null) {
                        TTCeilingLandingPageActivity.this.to.ud(i2);
                    }
                }
            });
        }
    }

    private void lnr() {
        hkc hkcVar = new hkc(this);
        this.lnr = hkcVar;
        hkcVar.ud(this.fs).lnr(this.mml).mml(this.mzz).qdl(this.ud).ud(this.mo).qdl(this.ud.jle()).mzz(this.ud.htl()).qdl(this.fs).ud("landingpage_split_ceiling");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        fs fsVar = this.to;
        if (fsVar != null) {
            fsVar.jpc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.component.tvp.mo moVar = this.fs;
        if (moVar != null) {
            vu.qdl(moVar);
        }
    }
}
