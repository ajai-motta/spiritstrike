package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.bqt;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.rdp;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.koa;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.widget.qdl.mo;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.fs;
import com.bytedance.sdk.openadsdk.mml.lnr;
import com.bytedance.sdk.openadsdk.mml.rq;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.exc;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jtx;
import com.bytedance.sdk.openadsdk.utils.jyq;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TTVideoLandingPageActivity extends TTBaseLandingPageActivity implements com.bytedance.sdk.openadsdk.to.mml {
    protected fs ax;
    protected com.bytedance.sdk.openadsdk.core.widget.qdl bch;
    protected long bjy;
    protected rdp bqt;
    protected mo.qdl cx;
    protected FrameLayout fs;
    private ILoader gt;
    protected com.bytedance.sdk.openadsdk.multipro.ud.qdl gy;
    protected ljh jtx;
    protected String kdv;
    protected Button koa;
    protected TextView ljh;
    protected ImageView lnr;
    protected TextView mml;
    protected String mo;
    protected int mrf;
    protected Context mzz;
    protected String om;
    protected RelativeLayout oth;
    protected com.bytedance.sdk.component.tvp.mo qdl;
    protected com.bytedance.sdk.openadsdk.core.exu.ud.mo rdp;
    protected int rq;
    private int taz;
    protected hkc to;
    protected ImageView ud;
    protected TextView uw;
    protected com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo vu;
    protected String wd;
    protected TextView xmv;
    private int zlt;
    protected int exu = -1;
    protected int yt = 0;
    protected int jl = 0;
    protected int exc = 0;
    protected int aaj = 0;
    protected String jyq = "ダウンロード";
    protected boolean rc = false;
    protected boolean ekw = false;
    protected boolean hkc = true;
    protected boolean hzv = false;
    protected String fco = null;
    protected AtomicBoolean ag = new AtomicBoolean(true);
    protected JSONArray wc = null;
    private final AtomicInteger irn = new AtomicInteger(0);
    private final AtomicInteger xi = new AtomicInteger(0);
    private final AtomicInteger jjk = new AtomicInteger(0);
    int yh = -1;
    protected com.bytedance.sdk.openadsdk.core.lnr.qdl wak = null;
    private final lnr.ud tid = new lnr.ud() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.11
        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.ud
        public void qdl(boolean z) {
            TTVideoLandingPageActivity.this.rc = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                ax.qdl((View) TTVideoLandingPageActivity.this.qdl, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.fs.getLayoutParams();
                TTVideoLandingPageActivity.this.jl = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.yt = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.exc = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.aaj = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.fs.setLayoutParams(marginLayoutParams);
                return;
            }
            ax.qdl((View) TTVideoLandingPageActivity.this.qdl, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.fs.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.exc;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.aaj;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.jl;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.yt;
            TTVideoLandingPageActivity.this.fs.setLayoutParams(marginLayoutParams2);
        }
    };
    private final bqt.qdl sy = new bqt.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2
        @Override // com.bytedance.sdk.component.utils.bqt.qdl
        public void qdl(Context context, Intent intent, boolean z, final int i) {
            fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    qdl(i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qdl(int i) {
            if (TTVideoLandingPageActivity.this.mrf == 0 && i != 0 && TTVideoLandingPageActivity.this.qdl != null && TTVideoLandingPageActivity.this.fco != null) {
                TTVideoLandingPageActivity.this.qdl.a_(TTVideoLandingPageActivity.this.fco);
            }
            if (TTVideoLandingPageActivity.this.rdp != null && TTVideoLandingPageActivity.this.rdp.getNativeVideoController() != null && !TTVideoLandingPageActivity.this.ekw && TTVideoLandingPageActivity.this.mrf != i) {
                TTVideoLandingPageActivity.this.rdp.getNativeVideoController().lnr(i);
            }
            TTVideoLandingPageActivity.this.mrf = i;
        }
    };

    protected abstract View lnr();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean qdl() {
        return true;
    }

    protected abstract boolean wd();

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String strGsv;
        super.onCreate(bundle);
        if (!com.bytedance.sdk.openadsdk.core.rdp.mzz()) {
            finish();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            yt.ud(this);
        } catch (Throwable unused2) {
        }
        this.mrf = jl.lnr(getApplicationContext());
        try {
            setContentView(lnr());
            this.mzz = this;
            Intent intent = getIntent();
            this.hzv = intent.getBooleanExtra("video_is_auto_play", true);
            if (bundle != null && bundle.getLong("video_play_position") > 0) {
                this.bjy = bundle.getLong("video_play_position", 0L);
            }
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra2 != null) {
                    try {
                        this.jtx = com.bytedance.sdk.openadsdk.core.ud.qdl(new JSONObject(stringExtra2));
                    } catch (Exception unused3) {
                    }
                }
                ljh ljhVar = this.jtx;
                if (ljhVar != null) {
                    this.exu = ljhVar.vxg();
                }
                this.mo = intent.getStringExtra("adid");
                this.wd = intent.getStringExtra("log_extra");
                strGsv = intent.getStringExtra("web_title");
                this.om = intent.getStringExtra("gecko_id");
                this.kdv = intent.getStringExtra("event_tag");
                this.rq = intent.getIntExtra("source", -1);
                this.fco = intent.getStringExtra("url");
            } else {
                ljh ljhVarQdl = koa.qdl().qdl(koa.qdl(intent));
                this.jtx = ljhVarQdl;
                if (ljhVarQdl != null) {
                    this.exu = ljhVarQdl.vxg();
                    this.mo = this.jtx.yre();
                    this.wd = this.jtx.ir();
                    strGsv = this.jtx.gsv();
                    this.om = this.jtx.xmr();
                    this.fco = this.jtx.tvp();
                    this.rq = this.jtx.rq();
                    this.kdv = this.jtx.to();
                } else {
                    strGsv = null;
                }
            }
            if (this.jtx == null) {
                finish();
                return;
            }
            if (!TextUtils.isEmpty(this.om)) {
                this.gt = com.bytedance.sdk.openadsdk.wd.ud.qdl().ud();
                int iQdl = com.bytedance.sdk.openadsdk.wd.ud.qdl().qdl(this.gt, this.om);
                this.zlt = iQdl;
                this.taz = iQdl > 0 ? 2 : 0;
            }
            if (stringExtra != null) {
                try {
                    this.gy = com.bytedance.sdk.openadsdk.multipro.ud.qdl.qdl(new JSONObject(stringExtra));
                } catch (Exception unused4) {
                }
                com.bytedance.sdk.openadsdk.multipro.ud.qdl qdlVar = this.gy;
                if (qdlVar != null) {
                    this.bjy = qdlVar.wd;
                }
            }
            if (bundle != null) {
                this.jtx = koa.qdl().qdl(bundle.getInt("meta_index", -1));
                long j = bundle.getLong("video_play_position");
                if (j > 0) {
                    this.bjy = j;
                }
            }
            mzz();
            rq();
            bjy();
            qdl(4);
            if (this.qdl != null) {
                com.bytedance.sdk.openadsdk.core.widget.qdl.lnr.qdl(this.mzz).qdl(true).ud(false).qdl(this.qdl.getWebView());
                fs fsVarUd = new fs(this.jtx, this.qdl.getWebView(), new rq() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.1
                    @Override // com.bytedance.sdk.openadsdk.mml.rq
                    public void qdl(int i) {
                        lnr.qdl.qdl(TTVideoLandingPageActivity.this.zlt, TTVideoLandingPageActivity.this.jjk.get(), TTVideoLandingPageActivity.this.xi.get(), TTVideoLandingPageActivity.this.irn.get() - TTVideoLandingPageActivity.this.xi.get(), TTVideoLandingPageActivity.this.jtx, "landingpage_split_screen", i);
                    }
                }, this.taz).ud(true);
                this.ax = fsVarUd;
                this.cx = fsVarUd.qdl;
                this.ax.qdl("landingpage_split_screen");
            }
            com.bytedance.sdk.component.tvp.mo moVar = this.qdl;
            if (moVar != null) {
                moVar.setLandingPage(true);
                this.qdl.setTag("landingpage_split_screen");
                this.qdl.setMaterialMeta(this.jtx.il());
                this.qdl.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.qdl.mzz(this.mzz, this.to, this.mo, this.ax, true) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mzz, android.webkit.WebViewClient
                    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                        try {
                            if (!TextUtils.isEmpty(TTVideoLandingPageActivity.this.om)) {
                                TTVideoLandingPageActivity.this.irn.incrementAndGet();
                                WebResourceResponseModel webResourceResponseModelQdl = com.bytedance.sdk.openadsdk.wd.ud.qdl().qdl(TTVideoLandingPageActivity.this.gt, TTVideoLandingPageActivity.this.om, str);
                                if (webResourceResponseModelQdl != null && webResourceResponseModelQdl.getWebResourceResponse() != null) {
                                    TTVideoLandingPageActivity.this.xi.incrementAndGet();
                                    return webResourceResponseModelQdl.getWebResourceResponse();
                                }
                                if (webResourceResponseModelQdl != null && webResourceResponseModelQdl.getMsg() == 2) {
                                    TTVideoLandingPageActivity.this.jjk.incrementAndGet();
                                }
                                return super.shouldInterceptRequest(webView, str);
                            }
                            return super.shouldInterceptRequest(webView, str);
                        } catch (Throwable th) {
                            aaj.qdl("TTVideoLandingPage", "shouldInterceptRequest url error", th);
                            return super.shouldInterceptRequest(webView, str);
                        }
                    }
                });
                com.bytedance.sdk.component.tvp.mo moVar2 = this.qdl;
                moVar2.setUserAgentString(exc.qdl(moVar2.getWebView(), BuildConfig.VERSION_CODE));
            }
            com.bytedance.sdk.component.tvp.mo moVar3 = this.qdl;
            if (moVar3 != null) {
                moVar3.setMixedContentMode(0);
            }
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.jtx, "landingpage_split_screen", this.taz);
            jyq.qdl(this.qdl, this.fco);
            this.qdl.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.qdl.mml(this.to, this.ax) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.5
                @Override // com.bytedance.sdk.openadsdk.core.widget.qdl.mml, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                }
            });
            this.qdl.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.6
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    if (TTVideoLandingPageActivity.this.vu != null) {
                        TTVideoLandingPageActivity.this.vu.lnr(TTVideoLandingPageActivity.this.jtx);
                    }
                }
            });
            TextView textView = this.mml;
            if (textView != null) {
                if (TextUtils.isEmpty(strGsv)) {
                    strGsv = com.bytedance.sdk.component.utils.ljh.qdl(this, "tt_web_title_default");
                }
                textView.setText(strGsv);
            }
            fs();
            mo();
            rdp();
            lnr.qdl.qdl(SystemClock.elapsedRealtime() - jElapsedRealtime, this.jtx, "landingpage_split_screen", this.gt, this.om);
        } catch (Throwable unused5) {
            finish();
        }
    }

    private void rdp() {
        ljh ljhVar = this.jtx;
        if (ljhVar == null || ljhVar.ygv() != 4) {
            return;
        }
        this.bqt.setVisibility(0);
        Button button = (Button) findViewById(jtx.lq);
        this.koa = button;
        if (button != null) {
            qdl(mml());
            this.koa.setOnClickListener(this.wak);
            this.koa.setOnTouchListener(this.wak);
        }
    }

    protected String mml() {
        ljh ljhVar = this.jtx;
        if (ljhVar != null && !TextUtils.isEmpty(ljhVar.uvi())) {
            this.jyq = this.jtx.uvi();
        }
        return this.jyq;
    }

    private void qdl(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.koa) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoLandingPageActivity.this.koa == null || TTVideoLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoLandingPageActivity.this.koa.setText(str);
            }
        });
    }

    protected void mzz() {
        this.bqt = (rdp) findViewById(jtx.taz);
        this.qdl = (com.bytedance.sdk.component.tvp.mo) findViewById(jtx.cx);
        ImageView imageView = (ImageView) findViewById(520093720);
        this.ud = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.qdl != null) {
                        if (TTVideoLandingPageActivity.this.cx != null) {
                            TTVideoLandingPageActivity.this.cx.qdl();
                        }
                        if (!TTVideoLandingPageActivity.this.qdl.tvp()) {
                            if (TTVideoLandingPageActivity.this.aaj()) {
                                TTVideoLandingPageActivity.this.onBackPressed();
                                return;
                            } else {
                                com.bytedance.sdk.openadsdk.mml.lnr.qdl(TTVideoLandingPageActivity.this.jtx, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.jpc(), TTVideoLandingPageActivity.this.tvp(), (TTVideoLandingPageActivity.this.rdp == null || TTVideoLandingPageActivity.this.rdp.getNativeVideoController() == null) ? null : gy.qdl(TTVideoLandingPageActivity.this.jtx, TTVideoLandingPageActivity.this.rdp.getNativeVideoController().wd(), TTVideoLandingPageActivity.this.rdp.getNativeVideoController().rq()), (com.bytedance.sdk.openadsdk.mml.wd) null);
                                TTVideoLandingPageActivity.this.finish();
                                return;
                            }
                        }
                        TTVideoLandingPageActivity.this.qdl.to();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar != null) {
            moVar.setIsAutoPlay(this.hzv);
        }
        ImageView imageView2 = (ImageView) findViewById(jtx.mrf);
        this.lnr = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.rdp != null) {
                        com.bytedance.sdk.openadsdk.mml.lnr.qdl(TTVideoLandingPageActivity.this.jtx, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.jpc(), TTVideoLandingPageActivity.this.tvp(), TTVideoLandingPageActivity.this.rdp.getNativeVideoController() != null ? gy.qdl(TTVideoLandingPageActivity.this.jtx, TTVideoLandingPageActivity.this.rdp.getNativeVideoController().wd(), TTVideoLandingPageActivity.this.rdp.getNativeVideoController().rq()) : null, (com.bytedance.sdk.openadsdk.mml.wd) null);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.mml = (TextView) findViewById(jtx.rzg);
        this.fs = (FrameLayout) findViewById(jtx.fco);
        this.oth = (RelativeLayout) findViewById(jtx.gy);
        this.ljh = (TextView) findViewById(jtx.ag);
        this.uw = (TextView) findViewById(jtx.wc);
        this.xmv = (TextView) findViewById(jtx.om);
        this.bch = (com.bytedance.sdk.openadsdk.core.widget.qdl) findViewById(jtx.ax);
        to();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        rdp();
    }

    protected void mo() {
        if (wd()) {
            try {
                com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = new com.bytedance.sdk.openadsdk.core.exu.ud.mo(this.mzz, this.jtx, true, null);
                this.rdp = moVar;
                if (moVar.getNativeVideoController() != null) {
                    this.rdp.getNativeVideoController().qdl(false);
                }
                if (this.ekw) {
                    this.fs.setVisibility(0);
                    this.fs.removeAllViews();
                    this.fs.addView(this.rdp);
                    this.rdp.ud(true);
                } else {
                    if (!this.hzv) {
                        this.bjy = 0L;
                    }
                    if (this.gy != null && this.rdp.getNativeVideoController() != null) {
                        this.rdp.getNativeVideoController().lnr(this.gy.wd);
                        this.rdp.getNativeVideoController().mml(this.gy.mzz);
                        this.rdp.qdl(yt.mml().lnr(String.valueOf(this.jtx.fz())), "landingPageInit");
                    }
                    if (this.rdp.qdl(this.bjy, this.hkc, this.ekw)) {
                        this.fs.setVisibility(0);
                        this.fs.removeAllViews();
                        this.fs.addView(this.rdp);
                    }
                    if (this.rdp.getNativeVideoController() != null) {
                        this.rdp.getNativeVideoController().qdl(false);
                        this.rdp.getNativeVideoController().qdl(this.tid);
                    }
                }
                String strQdl = this.jtx.vm().get(0).qdl();
                com.bytedance.sdk.openadsdk.tvp.mml.qdl().qdl(strQdl).qdl(this.jtx.vm().get(0).ud()).ud(this.jtx.vm().get(0).lnr()).mzz(ax.mzz(yt.qdl())).mml(ax.lnr(yt.qdl())).lnr(2).qdl(new com.bytedance.sdk.openadsdk.tvp.ud(this.jtx, strQdl, new com.bytedance.sdk.component.mzz.jtx() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.10
                    @Override // com.bytedance.sdk.component.mzz.jtx
                    public void qdl(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.mzz.jtx
                    public void qdl(com.bytedance.sdk.component.mzz.rq rqVar) {
                        try {
                            Object objUd = rqVar.ud();
                            if (objUd instanceof Bitmap) {
                                new qdl((Bitmap) objUd, TTVideoLandingPageActivity.this.rdp.getNativeVideoController().fs()).execute(new Void[0]);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }), 4);
                this.rdp.findViewById(520093726).setOnTouchListener(null);
                this.rdp.findViewById(520093726).setOnClickListener(null);
            } catch (Exception e) {
                aaj.lnr("TTVideoLandingPage", e.getMessage());
                if (this.rdp == null) {
                    ApmHelper.reportCustomError("mNativeVideoTsView is null", "FUNCTION EXCEPTION", e);
                }
            }
            if (this.mrf == 0) {
                try {
                    Toast.makeText(this, com.bytedance.sdk.component.utils.ljh.qdl(this, "tt_no_network"), 0).show();
                } catch (Throwable unused) {
                }
            }
        }
    }

    protected long jpc() {
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar == null || moVar.getNativeVideoController() == null) {
            return 0L;
        }
        return this.rdp.getNativeVideoController().tvp();
    }

    protected int tvp() {
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar == null || moVar.getNativeVideoController() == null) {
            return 0;
        }
        return this.rdp.getNativeVideoController().to();
    }

    protected void to() {
        String strCa;
        ljh ljhVar = this.jtx;
        if (ljhVar == null || ljhVar.ygv() != 4) {
            return;
        }
        ax.qdl((View) this.oth, 0);
        if (!TextUtils.isEmpty(this.jtx.gsv())) {
            strCa = this.jtx.gsv();
        } else if (!TextUtils.isEmpty(this.jtx.hvi())) {
            strCa = this.jtx.hvi();
        } else if (TextUtils.isEmpty(this.jtx.ca())) {
            strCa = "";
        } else {
            strCa = this.jtx.ca();
        }
        if (this.jtx.hcs() != null && this.jtx.hcs().qdl() != null) {
            ax.qdl((View) this.bch, 0);
            ax.qdl((View) this.ljh, 4);
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.jtx.hcs(), this.bch, this.jtx);
        } else if (!TextUtils.isEmpty(strCa)) {
            ax.qdl((View) this.bch, 4);
            ax.qdl((View) this.ljh, 0);
            this.ljh.setText(strCa.substring(0, 1));
        }
        if (!TextUtils.isEmpty(this.jtx.uvi())) {
            this.xmv.setText(this.jtx.uvi());
        }
        if (!TextUtils.isEmpty(strCa)) {
            this.uw.setText(strCa);
        }
        ax.qdl((View) this.uw, 0);
        ax.qdl((View) this.xmv, 0);
    }

    public void rq() {
        if (this.jtx == null) {
            return;
        }
        this.vu = com.bytedance.sdk.openadsdk.exc.qdl.qdl.wd.qdl(this, this.kdv);
        com.bytedance.sdk.openadsdk.core.lnr.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.lnr.qdl(this, this.jtx, this.kdv, this.rq);
        this.wak = qdlVar;
        qdlVar.qdl(false);
        this.wak.lnr(true);
        this.xmv.setOnClickListener(this.wak);
        this.xmv.setOnTouchListener(this.wak);
        this.wak.qdl(this.vu);
    }

    private void bjy() {
        hkc hkcVar = new hkc(this);
        this.to = hkcVar;
        hkcVar.ud(this.qdl).lnr(this.mo).mml(this.wd).ud(this.rq).qdl(this.jtx).qdl(this.jtx.jle()).qdl(this.qdl).ud("landingpage_split_screen").mzz(this.jtx.htl());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        jtx();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void ud() {
        jtx();
    }

    private void jtx() {
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar;
        if (this.rc && (moVar = this.rdp) != null && moVar.getNativeVideoController() != null) {
            this.rdp.getNativeVideoController().mzz(null, null);
            this.rc = false;
        } else if (aaj() && !this.ag.getAndSet(true)) {
            jyq();
            qdl(0);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        int iQdl = this.jtx != null ? koa.qdl().qdl(this.jtx) : -1;
        this.yh = iQdl;
        bundle.putInt("meta_index", iQdl);
        bundle.putLong("video_play_position", this.bjy);
        bundle.putBoolean("is_complete", this.ekw);
        long jMo = this.bjy;
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar != null && moVar.getNativeVideoController() != null) {
            jMo = this.rdp.getNativeVideoController().mo();
        }
        bundle.putLong("video_play_position", jMo);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.hkc) {
            yt();
        }
        this.hkc = false;
        hkc hkcVar = this.to;
        if (hkcVar != null) {
            hkcVar.rq();
        }
        fs fsVar = this.ax;
        if (fsVar != null) {
            fsVar.wd();
        }
    }

    private void yt() {
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar == null || moVar.getNativeVideoController() == null || exc()) {
            return;
        }
        this.rdp.rdp();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        jl();
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar == null || moVar.getNativeVideoController() == null) {
            return;
        }
        qdl(this.rdp.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        fs fsVar = this.ax;
        if (fsVar != null) {
            fsVar.jpc();
        }
    }

    private void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar) {
        this.ekw = this.ekw || lnrVar.exu();
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.TRUE);
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(this.ekw));
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(lnrVar.mo()));
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(lnrVar.tvp() + lnrVar.wd()));
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_native_video_data", "key_video_duration", Long.valueOf(lnrVar.tvp()));
    }

    private void jl() {
        if (this.rdp == null || exc()) {
            return;
        }
        this.rdp.rdp();
    }

    private boolean exc() {
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.rdp;
        if (moVar == null || moVar.getNativeVideoController() == null) {
            return true;
        }
        return this.rdp.getNativeVideoController().exu();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        exu();
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
            this.jtx.rq(false);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.tvp.mo moVar = this.qdl;
        if (moVar != null) {
            com.bytedance.sdk.openadsdk.core.gy.qdl(moVar.getWebView());
        }
        this.qdl = null;
        hkc hkcVar = this.to;
        if (hkcVar != null) {
            hkcVar.fs();
        }
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar2 = this.rdp;
        if (moVar2 != null && moVar2.getNativeVideoController() != null) {
            this.rdp.getNativeVideoController().mzz();
        }
        this.rdp = null;
        this.jtx = null;
        fs fsVar = this.ax;
        if (fsVar != null) {
            fsVar.mml(true);
        }
        if (!TextUtils.isEmpty(this.om)) {
            lnr.qdl.qdl(this.xi.get(), this.irn.get(), this.jtx);
        }
        com.bytedance.sdk.openadsdk.wd.ud.qdl().qdl(this.gt);
    }

    protected void fs() {
        bqt.qdl(this.sy, this.mzz);
    }

    protected void exu() {
        try {
            bqt.qdl(this.sy);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaj() {
        return !TextUtils.isEmpty(this.fco) && this.fco.contains("__luban_sdk");
    }

    private void qdl(final int i) {
        if (this.lnr == null || !aaj()) {
            return;
        }
        fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ax.qdl((View) TTVideoLandingPageActivity.this.lnr, i);
            }
        });
    }

    private void jyq() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", true);
            this.to.qdl("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.to.mml
    public void qdl(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.wc = jSONArray;
    }

    private static class qdl extends AsyncTask<Void, Void, Drawable> {
        private final Bitmap qdl;
        private final WeakReference<com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud> ud;

        private qdl(Bitmap bitmap, com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud udVar) {
            this.qdl = bitmap;
            this.ud = new WeakReference<>(udVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public Drawable doInBackground(Void... voidArr) {
            try {
                Bitmap bitmapQdl = com.bytedance.sdk.component.adexpress.mml.qdl.qdl(yt.qdl(), this.qdl, 25);
                if (bitmapQdl == null) {
                    return null;
                }
                return new BitmapDrawable(yt.qdl().getResources(), bitmapQdl);
            } catch (Throwable th) {
                aaj.lnr("TTVideoLandingPage", th.getMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Drawable drawable) {
            WeakReference<com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud> weakReference;
            if (drawable == null || (weakReference = this.ud) == null || weakReference.get() == null) {
                return;
            }
            this.ud.get().qdl(drawable);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.yh >= 0) {
            koa.qdl().lnr(this.yh);
            this.yh = -1;
        }
        com.bytedance.sdk.openadsdk.utils.mml.qdl(this, this.jtx);
    }
}
