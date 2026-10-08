package com.bytedance.sdk.openadsdk.core.tvp;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.tvp.mo;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.fco;
import com.bytedance.sdk.openadsdk.core.tvp.lnr;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.facebook.internal.NativeProtocol;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends com.bytedance.sdk.component.tvp.mo implements lnr.InterfaceC0258lnr {
    private int bjy;
    private List<String> exu;
    private int fs;
    private ljh jpc;
    private long jtx;
    protected boolean mml;
    AtomicBoolean mo;
    protected boolean mzz;
    private ud rdp;
    private String rq;
    private com.bytedance.sdk.openadsdk.core.model.ljh to;
    private lnr tvp;
    AtomicBoolean wd;

    public interface ud {
        View qdl();

        void qdl(int i, int i2);

        void qdl(View view, int i);

        void ud();
    }

    public mzz(Context context) {
        super(context, mo.lnr.DSP);
        this.mml = false;
        this.mzz = false;
        this.mo = new AtomicBoolean(false);
        this.wd = new AtomicBoolean(false);
        this.fs = 0;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, ud udVar, String str) {
        this.rdp = udVar;
        this.to = ljhVar;
        this.rq = str;
        this.tvp = new lnr();
        this.jpc = new ljh(getContext());
        setWebViewClient(new qdl(this));
        setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.core.tvp.mzz.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                mzz.this.bjy = i;
                super.onProgressChanged(webView, i);
                if (i >= 100) {
                    mzz.this.qdl();
                }
            }
        });
        com.bytedance.sdk.component.utils.tvp.ud().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.mzz.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = mzz.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.tvp.mzz.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            mzz.this.jpc.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
        });
    }

    private void jyq() {
        if (this.exu == null) {
            com.bytedance.sdk.openadsdk.mml.lnr.ud(this.to, this.rq, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(new com.bytedance.sdk.component.jpc.jpc("dsp_html_error_url") { // from class: com.bytedance.sdk.openadsdk.core.tvp.mzz.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (mzz.this.exu != null && mzz.this.wd.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = mzz.this.exu.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.mml.lnr.ud(mzz.this.to, mzz.this.rq, "dsp_html_error_url", jSONObject);
                            mzz.this.exu = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.tvp.mo
    public void jtx() {
        this.tvp.ud();
        super.jtx();
    }

    public void qdl(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.tvp.qdl(view, friendlyObstructionPurpose);
    }

    @Override // com.bytedance.sdk.component.tvp.mo, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mml) {
            this.tvp.qdl(getWebView());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        this.mzz = z;
        this.tvp.qdl(z);
    }

    @Override // com.bytedance.sdk.component.tvp.mo, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.tvp.qdl();
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.bjy / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.mml.lnr.ud(this.to, this.rq, "load_rate", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.lnr.InterfaceC0258lnr
    public void qdl(String str) {
        boolean zQdl;
        if (TextUtils.isEmpty(str) || this.to == null || !this.jpc.ud()) {
            return;
        }
        int iQdl = gy.qdl(this.rq);
        View viewQdl = null;
        if (!com.bytedance.sdk.component.utils.jl.qdl(str) && (this.to.bo() == null || TextUtils.isEmpty(this.to.bo().qdl()))) {
            com.bytedance.sdk.openadsdk.core.model.exu exuVar = new com.bytedance.sdk.openadsdk.core.model.exu();
            exuVar.qdl(str);
            this.to.qdl(exuVar);
            str = null;
        }
        this.to.lnr(true);
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.to;
        if (ljhVar == null || ljhVar.bo() == null || TextUtils.isEmpty(this.to.bo().qdl())) {
            zQdl = false;
        } else {
            zQdl = fco.qdl(getContext(), this.to, iQdl, this.rq, true, (Map<String, Object>) null);
            if (!zQdl && !TextUtils.isEmpty(this.to.bo().ud())) {
                str = this.to.bo().ud();
                com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.to, this.rq, "open_fallback_url", (Map<String, Object>) null);
            }
        }
        String str2 = str;
        if (!zQdl) {
            if (TextUtils.isEmpty(str2)) {
                return;
            } else {
                fco.qdl(getContext(), this.to, iQdl, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.mml.qdl) null, this.rq, true, str2);
            }
        }
        if (this.jpc != null) {
            ud udVar = this.rdp;
            if (udVar != null) {
                viewQdl = udVar.qdl();
                this.rdp.qdl(this, 2);
            }
            com.bytedance.sdk.openadsdk.core.model.fs fsVarQdl = this.jpc.qdl(getContext(), viewQdl);
            HashMap map = new HashMap();
            map.put("click_scence", 1);
            com.bytedance.sdk.openadsdk.mml.lnr.qdl("click", this.to, fsVarQdl, this.rq, true, (Map<String, Object>) map, this.jpc.ud() ? 1 : 2);
        }
        ljh ljhVar2 = this.jpc;
        if (ljhVar2 != null) {
            ljhVar2.qdl();
        }
    }

    public void exc() {
        ud udVar = this.rdp;
        if (udVar != null) {
            udVar.ud();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.jtx);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.mml.lnr.ud(this.to, this.rq, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.lnr.InterfaceC0258lnr
    public void qdl(int i, int i2) {
        ud udVar = this.rdp;
        if (udVar != null) {
            udVar.qdl(i, i2);
        }
        this.fs = i2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i2);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.jtx);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.mml.lnr.ud(this.to, this.rq, "render_html_fail", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.lnr.InterfaceC0258lnr
    public void ud(String str) {
        if (this.exu == null) {
            this.exu = new ArrayList();
        }
        this.exu.add(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.lnr.InterfaceC0258lnr
    public void qdl() {
        if (this.mo.compareAndSet(false, true)) {
            this.mml = true;
            this.tvp.qdl(getWebView());
            this.tvp.qdl(this.mzz);
            exc();
            jyq();
        }
    }

    public void aaj() {
        this.mo.set(false);
        String strFk = this.to.fk();
        if (TextUtils.isEmpty(strFk)) {
            return;
        }
        String strQdl = com.bytedance.sdk.openadsdk.core.fs.mzz.qdl(strFk);
        String str = TextUtils.isEmpty(strQdl) ? strFk : strQdl;
        this.fs = 0;
        qdl(null, str, "text/html", "UTF-8", null);
        this.jtx = SystemClock.elapsedRealtime();
    }

    static class qdl extends mo.qdl {
        public static final Set<String> qdl = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.tvp.mzz.qdl.1
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        lnr.InterfaceC0258lnr ud;

        public qdl(lnr.InterfaceC0258lnr interfaceC0258lnr) {
            this.ud = interfaceC0258lnr;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.ud.qdl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                qdl(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            qdl(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return;
            }
            qdl(webResourceRequest.getUrl().toString());
        }

        private void qdl(String str) {
            int iLastIndexOf;
            lnr.InterfaceC0258lnr interfaceC0258lnr;
            if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(".")) > 0) {
                if (!qdl.contains(str.substring(iLastIndexOf).toLowerCase()) || (interfaceC0258lnr = this.ud) == null) {
                    return;
                }
                interfaceC0258lnr.ud(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            lnr.InterfaceC0258lnr interfaceC0258lnr = this.ud;
            if (interfaceC0258lnr != null) {
                interfaceC0258lnr.qdl();
            }
        }

        private void qdl(String str, int i, String str2) {
            lnr.InterfaceC0258lnr interfaceC0258lnr = this.ud;
            if (interfaceC0258lnr != null) {
                interfaceC0258lnr.qdl(106, i);
            }
        }
    }

    public static class lnr {
        protected int qdl = 0;
        private com.bytedance.sdk.openadsdk.core.fs.mo ud = com.bytedance.sdk.openadsdk.core.fs.mo.qdl();

        lnr() {
        }

        public void qdl(WebView webView) {
            if (webView != null && this.qdl == 0) {
                if (this.ud == null) {
                    this.ud = com.bytedance.sdk.openadsdk.core.fs.mo.qdl();
                }
                this.ud.qdl(webView);
                this.ud.ud();
                this.qdl = 1;
            }
        }

        public void qdl(boolean z) {
            com.bytedance.sdk.openadsdk.core.fs.mo moVar;
            if (this.qdl == 1 && z && (moVar = this.ud) != null) {
                moVar.lnr();
                this.qdl = 3;
            }
        }

        public void qdl(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.fs.mo moVar = this.ud;
            if (moVar != null) {
                moVar.qdl(view, friendlyObstructionPurpose);
            }
        }

        public void qdl() {
            com.bytedance.sdk.openadsdk.core.fs.mo moVar;
            int i = this.qdl;
            if (i != 0 && i != 4 && (moVar = this.ud) != null) {
                moVar.mml();
            }
            this.qdl = 4;
            this.ud = null;
        }

        public void ud() {
            qdl();
        }
    }
}
