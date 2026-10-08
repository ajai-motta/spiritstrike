package com.bytedance.sdk.component.tvp;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.tvp.qdl;
import com.bytedance.sdk.component.utils.uw;
import com.bytedance.sdk.component.utils.vu;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends FrameLayout {
    private static mml ag;
    private boolean aaj;
    private mzz ax;
    private boolean bch;
    private View bjy;
    private float bqt;
    private uw ekw;
    private com.bytedance.sdk.component.tvp.mml exc;
    private boolean exu;
    private AtomicBoolean fco;
    private long fs;
    private AtomicBoolean gy;
    private AttributeSet hkc;
    private Context hzv;
    private List<String> jl;
    private float jpc;
    private qdl.InterfaceC0211qdl jtx;
    private boolean jyq;
    private ud kdv;
    private float koa;
    private boolean ljh;
    public int lnr;
    private com.bytedance.sdk.component.tvp.ud.qdl mml;
    private JSONObject mo;
    private AtomicBoolean mrf;
    private String mzz;
    private long om;
    private boolean oth;
    public int qdl;
    private int rc;
    private volatile WebView rdp;
    private long rq;
    private long to;
    private float tvp;
    public int ud;
    private WebViewClient uw;
    private float vu;
    private long wc;
    private boolean wd;
    private lnr xmv;
    private com.bytedance.sdk.component.tvp.qdl yt;

    public interface mml {
        WebView createWebView(Context context, AttributeSet attributeSet, int i, lnr lnrVar);
    }

    public interface mzz {
    }

    public interface ud {
    }

    private static void lnr(Context context) {
    }

    private static Context qdl(Context context) {
        return context;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public com.bytedance.sdk.component.tvp.ud.qdl getMaterialMeta() {
        return this.mml;
    }

    public boolean i_() {
        return this.aaj;
    }

    public void setLpPreRender(boolean z) {
        this.aaj = z;
    }

    public boolean ud() {
        return this.jyq;
    }

    public void setPreStart(boolean z) {
        this.jyq = z;
    }

    public boolean lnr() {
        return this.oth;
    }

    public void setPreFinish(boolean z) {
        this.oth = z;
    }

    public boolean mml() {
        return this.ljh;
    }

    public void setPreProgressHundred(boolean z) {
        this.ljh = z;
    }

    public void setPreError(boolean z) {
        this.bch = z;
    }

    public void setMaterialMeta(com.bytedance.sdk.component.tvp.ud.qdl qdlVar) {
        this.mml = qdlVar;
    }

    @Override // android.view.View
    public String getTag() {
        return this.mzz;
    }

    public void setTag(String str) {
        this.mzz = str;
        com.bytedance.sdk.component.tvp.qdl qdlVar = this.yt;
        if (qdlVar != null) {
            qdlVar.qdl(str);
        }
        com.bytedance.sdk.component.tvp.mml mmlVar = this.exc;
        if (mmlVar != null) {
            mmlVar.qdl(str);
        }
    }

    public void setLandingPage(boolean z) {
        this.wd = z;
    }

    public void setTouchStateListener(mzz mzzVar) {
        this.ax = mzzVar;
    }

    public lnr getScene() {
        return this.xmv;
    }

    public mo(Context context, lnr lnrVar) {
        this(qdl(context), false, lnrVar);
    }

    public mo(Context context, boolean z, lnr lnrVar) {
        super(qdl(context));
        this.jpc = 0.0f;
        this.tvp = 0.0f;
        this.to = 0L;
        this.rq = 0L;
        this.fs = 0L;
        this.exu = false;
        this.bqt = 20.0f;
        this.vu = 50.0f;
        this.fco = new AtomicBoolean();
        this.mrf = new AtomicBoolean();
        this.gy = new AtomicBoolean();
        this.hzv = context;
        this.xmv = lnrVar;
        if (z) {
            return;
        }
        try {
            this.rdp = qdl((AttributeSet) null, 0);
            mo();
        } catch (Throwable unused) {
        }
        ud(qdl(context));
    }

    public void qdl(boolean z, int i, int i2, List<Integer> list, int i3, List<String> list2) {
        if (z && this.rdp != null && (this.rdp instanceof com.bytedance.sdk.component.tvp.mzz)) {
            this.yt = new com.bytedance.sdk.component.tvp.qdl(this.hzv, i, i2, list, i3);
            this.jl = list2;
            if (!TextUtils.isEmpty(this.mzz)) {
                this.yt.qdl(this.mzz);
            }
            ((com.bytedance.sdk.component.tvp.mzz) this.rdp).setTouchListenerProxy(this.yt);
            this.jtx = this.yt.qdl();
        }
    }

    public void qdl(int i, long j) {
        if (this.rdp == null || !(this.rdp instanceof com.bytedance.sdk.component.tvp.mzz)) {
            return;
        }
        this.exc = new com.bytedance.sdk.component.tvp.mml(this.hzv, this.yt, i, j, this);
        if (!TextUtils.isEmpty(this.mzz)) {
            this.exc.qdl(this.mzz);
        }
        ((com.bytedance.sdk.component.tvp.mzz) this.rdp).setTouchListenerProxy(this.exc);
    }

    public void qdl(boolean z, View view) {
        if (z) {
            this.bjy = view;
            view.setVisibility(8);
            View view2 = this.bjy;
            if (view2 == null || view2.getParent() != null) {
                return;
            }
            addView(this.bjy, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public View getArbitrageLoadingView() {
        return this.bjy;
    }

    public void setWebView(WebView webView) {
        this.rdp = webView;
    }

    public void mzz() {
        try {
            if (this.rdp == null) {
                this.rdp = qdl(this.hkc, 0);
            }
            mo();
            ud(qdl(this.hzv));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void setWebViewProvider(mml mmlVar) {
        ag = mmlVar;
    }

    private WebView qdl(AttributeSet attributeSet, int i) {
        mml mmlVar = ag;
        if (mmlVar != null) {
            return mmlVar.createWebView(getContext(), attributeSet, i, this.xmv);
        }
        if (attributeSet == null) {
            return new WebView(qdl(this.hzv));
        }
        return new WebView(qdl(this.hzv), attributeSet);
    }

    public void setRecycler(boolean z) {
        if (this.rdp == null || !(this.rdp instanceof com.bytedance.sdk.component.tvp.mzz)) {
            return;
        }
        ((com.bytedance.sdk.component.tvp.mzz) this.rdp).setRecycler(z);
    }

    public void mo() {
        if (this.rdp != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.rdp.setId(520093704);
            } catch (Throwable unused) {
            }
            addView(this.rdp, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void ud(Context context) {
        lnr(context);
        aaj();
        exc();
    }

    public void setNetworkAvailable(boolean z) {
        try {
            this.rdp.setNetworkAvailable(z);
        } catch (Throwable unused) {
        }
    }

    public void qdl(String str, Map<String, String> map) {
        try {
            setJavaScriptEnabled(str);
            this.rdp.loadUrl(str, map);
        } catch (Throwable unused) {
        }
    }

    public void a_(String str) {
        try {
            setJavaScriptEnabled(str);
            this.rdp.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void qdl(String str, String str2, String str3, String str4, String str5) {
        try {
            setJavaScriptEnabled(str);
            this.rdp.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } catch (Throwable unused) {
        }
    }

    public void wd() {
        try {
            this.rdp.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void jpc() {
        try {
            this.rdp.reload();
        } catch (Throwable unused) {
        }
    }

    public boolean tvp() {
        if (this.rdp == null) {
            return false;
        }
        try {
            return this.rdp.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void to() {
        try {
            this.rdp.goBack();
        } catch (Throwable unused) {
        }
    }

    public boolean rq() {
        if (this.rdp == null) {
            return false;
        }
        try {
            return this.rdp.canGoForward();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void fs() {
        try {
            this.rdp.goForward();
        } catch (Throwable unused) {
        }
    }

    public void exu() {
        if (this.rdp != null) {
            this.rdp.onResume();
        }
    }

    public String getUrl() {
        if (this.rdp == null) {
            return null;
        }
        try {
            return this.rdp.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOriginalUrl() {
        String url;
        if (this.rdp == null) {
            return null;
        }
        try {
            String originalUrl = this.rdp.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = this.rdp.getUrl()) == null) ? originalUrl : url.startsWith("file://") ? url : originalUrl;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        if (this.rdp == null) {
            return 0;
        }
        try {
            return this.rdp.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public int getContentHeight() {
        if (this.rdp == null) {
            return 0;
        }
        try {
            return this.rdp.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public void qdl(boolean z) {
        try {
            this.rdp.clearCache(z);
        } catch (Throwable unused) {
        }
    }

    public void rdp() {
        try {
            this.rdp.clearHistory();
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof mzz) {
                setTouchStateListener((mzz) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == 0) {
                webViewClient = new qdl();
            }
            this.uw = webViewClient;
            this.rdp.setWebViewClient(new wd(this.jtx, webViewClient, this.jl));
        } catch (Throwable unused) {
        }
    }

    public WebViewClient getWebViewClient() {
        return this.uw;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.rdp.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.rdp.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        try {
            this.rdp.setBackgroundColor(i);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.rdp == null) {
            return;
        }
        try {
            this.rdp.computeScroll();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent viewParentQdl;
        try {
            qdl(motionEvent);
            boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.exu && (viewParentQdl = qdl(this)) != null) {
                viewParentQdl.requestDisallowInterceptTouchEvent(true);
            }
            return zOnInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void setIsPreventTouchEvent(boolean z) {
        this.exu = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewParent qdl(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (ud(view2) || lnr(view2)) ? parent : qdl(view2);
    }

    private static boolean ud(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ViewPager");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static boolean lnr(View view) {
        try {
            Class<?> clsLoadClass = view.getClass().getClassLoader().loadClass("android.support.v4.view.ScrollingView");
            if (clsLoadClass != null) {
                if (clsLoadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> clsLoadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (clsLoadClass2 != null) {
                return clsLoadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    @Override // android.view.View
    public void setLayerType(int i, Paint paint) {
        try {
            this.rdp.setLayerType(i, paint);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        try {
            this.rdp.setOverScrollMode(i);
            super.setOverScrollMode(i);
        } catch (Throwable unused) {
        }
    }

    private void exc() {
        if (this.rdp == null) {
            return;
        }
        try {
            this.rdp.removeJavascriptInterface("searchBoxJavaBridge_");
            this.rdp.removeJavascriptInterface("accessibility");
            this.rdp.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public void qdl(Object obj, String str) {
        try {
            this.rdp.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        try {
            this.rdp.getSettings().setJavaScriptEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z) {
        try {
            this.rdp.getSettings().setDisplayZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i) {
        try {
            this.rdp.getSettings().setCacheMode(i);
        } catch (Throwable unused) {
        }
    }

    private void aaj() {
        try {
            WebSettings settings = this.rdp.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = this.rdp.getSettings()) == null) {
                return;
            }
            if (Uri.parse(str).getScheme().equalsIgnoreCase(ShareInternalUtility.STAGING_PARAM)) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    public void bjy() {
        if (this.rdp == null) {
            return;
        }
        try {
            this.rdp.onPause();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public String getUserAgentString() {
        if (this.rdp == null) {
            return "";
        }
        try {
            return this.rdp.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.rdp;
    }

    public void jtx() {
        if (this.rdp == null) {
            return;
        }
        if (this.xmv != lnr.ADS && this.xmv != lnr.ADS_V3) {
            vu.qdl(this);
        } else {
            try {
                this.rdp.destroy();
            } catch (Throwable unused) {
            }
        }
    }

    public void b_(String str) {
        try {
            this.rdp.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    public void setSupportZoom(boolean z) {
        try {
            this.rdp.getSettings().setSupportZoom(z);
        } catch (Throwable unused) {
        }
    }

    public void setUseWideViewPort(boolean z) {
        try {
            this.rdp.getSettings().setUseWideViewPort(z);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        try {
            this.rdp.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z) {
        try {
            this.rdp.getSettings().setDomStorageEnabled(z);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        try {
            this.rdp.getSettings().setBuiltInZoomControls(z);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.rdp.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        try {
            this.rdp.getSettings().setLoadWithOverviewMode(z);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.rdp.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.rdp.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultFontSize(int i) {
        try {
            this.rdp.getSettings().setDefaultFontSize(i);
        } catch (Throwable unused) {
        }
    }

    public void setMixedContentMode(int i) {
        try {
            this.rdp.getSettings().setMixedContentMode(i);
        } catch (Throwable unused) {
        }
    }

    public void setDatabaseEnabled(boolean z) {
        try {
            this.rdp.getSettings().setDatabaseEnabled(z);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        try {
            super.setVisibility(i);
            this.rdp.setVisibility(i);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        try {
            super.setAlpha(f);
            this.rdp.setAlpha(f);
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z) {
        try {
            this.rdp.getSettings().setAllowFileAccess(z);
        } catch (Throwable unused) {
        }
    }

    public void yt() {
        try {
            this.rdp.clearView();
        } catch (Throwable unused) {
        }
    }

    public void jl() {
        try {
            this.rdp.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.rdp.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    private void jyq() {
        if (this.ekw == null) {
            this.gy.set(false);
            this.ekw = new uw(getContext());
        }
        new Object() { // from class: com.bytedance.sdk.component.tvp.mo.1
        };
        this.gy.set(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fco.set(true);
        if (!this.mrf.get() || this.gy.get()) {
            return;
        }
        jyq();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fco.set(false);
    }

    public long getLandingPageClickBegin() {
        return this.wc;
    }

    public void setLandingPageClickBegin(long j) {
        this.wc = j;
    }

    public long getLandingPageClickEnd() {
        return this.om;
    }

    public void setLandingPageClickEnd(long j) {
        this.om = j;
    }

    private void qdl(MotionEvent motionEvent) {
        if (!this.wd || this.mml == null) {
            return;
        }
        if ((this.mzz == null && this.mo == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.jpc = motionEvent.getRawX();
                this.tvp = motionEvent.getRawY();
                this.to = System.currentTimeMillis();
                this.mo = new JSONObject();
                if (this.rdp != null) {
                    this.wc = this.to;
                    return;
                }
                return;
            }
            if (action == 1 || action == 3) {
                this.mo.put("start_x", String.valueOf(this.jpc));
                this.mo.put("start_y", String.valueOf(this.tvp));
                this.mo.put("offset_x", String.valueOf(motionEvent.getRawX() - this.jpc));
                this.mo.put("offset_y", String.valueOf(motionEvent.getRawY() - this.tvp));
                this.mo.put("url", String.valueOf(getUrl()));
                this.mo.put(ViewHierarchyConstants.TAG_KEY, "");
                this.rq = System.currentTimeMillis();
                if (this.rdp != null) {
                    this.om = this.rq;
                }
                this.mo.put("down_time", this.to);
                this.mo.put("up_time", this.rq);
                if (com.bytedance.sdk.component.tvp.qdl.qdl.qdl().ud() != null) {
                    long j = this.fs;
                    long j2 = this.to;
                    if (j != j2) {
                        this.fs = j2;
                        com.bytedance.sdk.component.tvp.qdl.qdl.qdl().ud().qdl(this.mml, this.mzz, "in_web_click", this.mo, this.rq - this.to);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setShakeValue(float f) {
        this.bqt = f;
    }

    public void setDeepShakeValue(float f) {
        this.koa = f;
    }

    public void setWriggleValue(float f) {
        this.vu = f;
    }

    public void setCalculationMethod(int i) {
        this.rc = i;
    }

    public void setOnShakeListener(ud udVar) {
        this.kdv = udVar;
    }

    public static class qdl extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(final WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView == null) {
                return true;
            }
            webView.post(new Runnable() { // from class: com.bytedance.sdk.component.tvp.mo.qdl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
    }

    public enum lnr {
        ADS("ads"),
        ADS_V3("ads_v3"),
        ENDCARD("endcard"),
        USER_AGENT("ua"),
        PLAYABLE("playable"),
        DSP("dsp"),
        PRIVACY(ShareConstants.WEB_DIALOG_PARAM_PRIVACY),
        VAST_ENDCARD("vast_endcard"),
        EASY_PLAYABLE("easy_playable"),
        LANDING_PAGE("landing_page"),
        LANDING_PAGE_LOADING("lp_loading"),
        LANDING_PAGE_PRE_RENDER("lp_pre_render");

        public final String exu;

        lnr(String str) {
            this.exu = str;
        }
    }
}
