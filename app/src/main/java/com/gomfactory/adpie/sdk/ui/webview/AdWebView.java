package com.gomfactory.adpie.sdk.ui.webview;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.common.AdRequest;
import com.gomfactory.adpie.sdk.common.DataKeys;
import com.gomfactory.adpie.sdk.network.NetworkServiceManager;
import com.gomfactory.adpie.sdk.pref.Preference;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class AdWebView extends WebView {
    public static final String TAG = "AdWebView";
    private Context mContext;
    private Handler mHandler;
    private String mHtmlData;
    private boolean mIsDestroyed;
    private boolean mIsFinished;
    private boolean mIsWebviewLoadingSkip;
    private int mMonitoring;
    private Date mStartDate;
    private WebViewEventListener mWebViewEventListener;
    private boolean mWebViewPressed;

    public interface WebViewEventListener {
        void onPageDelayed();

        void onPageFinished();

        void onUserClick(String str);
    }

    public AdWebView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.mWebViewEventListener = webViewEventListener;
    }

    private void init() {
        this.mIsFinished = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(0);
        setLayerType(2, null);
        setScrollBarStyle(33554432);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.gomfactory.adpie.sdk.ui.webview.AdWebView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(AdWebView.TAG, "Touch :  " + motionEvent.getAction());
                }
                if (motionEvent.getAction() == 1) {
                    AdWebView.this.mWebViewPressed = true;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.gomfactory.adpie.sdk.ui.webview.AdWebView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdWebView.this.mWebViewPressed = false;
                        }
                    }, 1000L);
                }
                return motionEvent.getAction() == 2;
            }
        });
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportMultipleWindows(true);
        getSettings().setDefaultTextEncodingName("utf-8");
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT < 30) {
            getSettings().setAllowUniversalAccessFromFileURLs(false);
            getSettings().setAllowFileAccessFromFileURLs(false);
        }
        getSettings().setMixedContentMode(0);
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            setWebContentsDebuggingEnabled(true);
        }
        getSettings().setBuiltInZoomControls(false);
        getSettings().setSupportZoom(false);
        getSettings().setDomStorageEnabled(true);
        setWebViewClient(new WebViewClientClass());
        setWebChromeClient(new WebChromeClient() { // from class: com.gomfactory.adpie.sdk.ui.webview.AdWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                try {
                    WebView webView2 = new WebView(AdWebView.this.mContext);
                    webView2.setWebViewClient(AdWebView.this.new WebViewClientInChromeClient());
                    ((WebView.WebViewTransport) message.obj).setWebView(webView2);
                    message.sendToTarget();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.cancel();
                return true;
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        onPause();
        removeCallback();
        this.mWebViewEventListener = null;
        if (this.mIsDestroyed) {
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        this.mIsDestroyed = true;
        removeAllViews();
        super.destroy();
    }

    public void loadData(String str, long j) {
        this.mHtmlData = str;
        removeCallback();
        if (this.mIsWebviewLoadingSkip) {
            this.mIsFinished = true;
            WebViewEventListener webViewEventListener = this.mWebViewEventListener;
            if (webViewEventListener != null) {
                webViewEventListener.onPageFinished();
            }
        } else if (j > 0) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.mHandler = handler;
            handler.postDelayed(new Runnable() { // from class: com.gomfactory.adpie.sdk.ui.webview.AdWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AdWebView.this.mIsFinished) {
                        return;
                    }
                    AdWebView.this.mIsFinished = true;
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        AdPieLog.d(AdWebView.TAG, "Webview loading time is delayed.");
                    }
                    if (AdWebView.this.mWebViewEventListener != null) {
                        AdWebView.this.mWebViewEventListener.onPageFinished();
                    }
                }
            }, j);
        }
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            this.mStartDate = new Date();
        }
        loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCallback() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBrowser(WebView webView, String str) {
        try {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "goToBrowser - url : " + str + ", monitoring : " + this.mMonitoring);
            }
            if (webView != null) {
                webView.stopLoading();
            }
            if (!this.mWebViewPressed) {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, "block goToBrowser - url : " + str + ", monitoring : " + this.mMonitoring);
                }
                int i = this.mMonitoring;
                if (i == 1) {
                    sendAutoScriptCode(str);
                } else {
                    if (i == 2) {
                        return;
                    }
                    if (i == 3) {
                        sendAutoScriptCode(str);
                        return;
                    }
                }
            }
            WebViewEventListener webViewEventListener = this.mWebViewEventListener;
            if (webViewEventListener != null) {
                webViewEventListener.onUserClick(str);
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public void setMonitoring(int i) {
        this.mMonitoring = i;
    }

    private void sendAutoScriptCode(String str) {
        String strReplace;
        try {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, "sendAutoScriptCode : " + str);
            }
            AdRequest adRequest = (AdRequest) AdPieSDK.getInstance().getCommonHeader().clone();
            adRequest.setAppID(AdPieSDK.getInstance().getAppId());
            try {
                String stringValue = Preference.getStringValue(this.mContext, DataKeys.SSP_REQUEST_URL_KEY, "");
                if (TextUtils.isEmpty(stringValue)) {
                    stringValue = AdPieSDK.getInstance().getConfiguration().getAdpieSspUrl();
                }
                strReplace = stringValue.replace("/request", "/trace");
            } catch (Exception unused) {
                strReplace = null;
            }
            adRequest.setRequestURL(strReplace, true);
            Uri.Builder builderBuildUpon = Uri.parse(adRequest.toString()).buildUpon();
            builderBuildUpon.appendQueryParameter("tracetype", "1");
            builderBuildUpon.appendQueryParameter("abus_link", str);
            builderBuildUpon.appendQueryParameter("abus_adm", this.mHtmlData);
            NetworkServiceManager.getInstance().post(adRequest.getRequestURL(), builderBuildUpon.build().getEncodedQuery(), new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.ui.webview.AdWebView.4
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != -1) {
                        if (i == 200 && AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(AdWebView.TAG, "HTTP Connection : Success");
                            return;
                        }
                        return;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        String str2 = AdWebView.TAG;
                        StringBuilder sb = new StringBuilder("HTTP Connection : ERROR ");
                        sb.append(message.obj != null ? message.obj.toString() : "");
                        AdPieLog.d(str2, sb.toString());
                    }
                }
            });
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public void setWebviewLoadingSkip(int i) {
        this.mIsWebviewLoadingSkip = i == 1;
    }

    private class WebViewClientClass extends WebViewClient {
        private WebViewClientClass() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(AdWebView.TAG, "WebViewClient - onReceivedError : " + str2 + ", errorCode : " + i);
                }
            } catch (Exception unused) {
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(AdWebView.TAG, "WebViewClient - onReceivedError : " + webResourceRequest.getUrl().toString() + ", errorCode : " + webResourceError.getErrorCode());
                }
            } catch (Exception unused) {
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(AdWebView.TAG, "WebViewClient - onLoadResource : " + str);
            }
            super.onLoadResource(webView, str);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:20:0x005a
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView r7, java.lang.String r8) {
            /*
                r6 = this;
                com.gomfactory.adpie.sdk.AdPieSDK r7 = com.gomfactory.adpie.sdk.AdPieSDK.getInstance()     // Catch: java.lang.Exception -> L5a
                com.gomfactory.adpie.sdk.common.Configuration r7 = r7.getConfiguration()     // Catch: java.lang.Exception -> L5a
                boolean r7 = r7.isAdpieSdkLog()     // Catch: java.lang.Exception -> L5a
                if (r7 == 0) goto L5a
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L5a
                java.util.Date r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$500(r7)     // Catch: java.lang.Exception -> L5a
                java.lang.String r0 = "WebViewClient - onPageFinished : "
                if (r7 == 0) goto L49
                java.lang.String r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.TAG     // Catch: java.lang.Exception -> L5a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5a
                r1.<init>(r0)     // Catch: java.lang.Exception -> L5a
                r1.append(r8)     // Catch: java.lang.Exception -> L5a
                java.lang.String r8 = ", delayTime : "
                r1.append(r8)     // Catch: java.lang.Exception -> L5a
                java.util.Date r8 = new java.util.Date     // Catch: java.lang.Exception -> L5a
                r8.<init>()     // Catch: java.lang.Exception -> L5a
                long r2 = r8.getTime()     // Catch: java.lang.Exception -> L5a
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r8 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L5a
                java.util.Date r8 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$500(r8)     // Catch: java.lang.Exception -> L5a
                long r4 = r8.getTime()     // Catch: java.lang.Exception -> L5a
                long r2 = r2 - r4
                r4 = 1000(0x3e8, double:4.94E-321)
                long r2 = r2 / r4
                r1.append(r2)     // Catch: java.lang.Exception -> L5a
                java.lang.String r8 = r1.toString()     // Catch: java.lang.Exception -> L5a
                com.gomfactory.adpie.sdk.util.AdPieLog.d(r7, r8)     // Catch: java.lang.Exception -> L5a
                goto L5a
            L49:
                java.lang.String r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.TAG     // Catch: java.lang.Exception -> L5a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5a
                r1.<init>(r0)     // Catch: java.lang.Exception -> L5a
                r1.append(r8)     // Catch: java.lang.Exception -> L5a
                java.lang.String r8 = r1.toString()     // Catch: java.lang.Exception -> L5a
                com.gomfactory.adpie.sdk.util.AdPieLog.d(r7, r8)     // Catch: java.lang.Exception -> L5a
            L5a:
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L7f
                boolean r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$300(r7)     // Catch: java.lang.Exception -> L7f
                if (r7 != 0) goto L93
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L7f
                r8 = 1
                com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$302(r7, r8)     // Catch: java.lang.Exception -> L7f
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L7f
                com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$600(r7)     // Catch: java.lang.Exception -> L7f
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L7f
                com.gomfactory.adpie.sdk.ui.webview.AdWebView$WebViewEventListener r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$400(r7)     // Catch: java.lang.Exception -> L7f
                if (r7 == 0) goto L93
                com.gomfactory.adpie.sdk.ui.webview.AdWebView r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L7f
                com.gomfactory.adpie.sdk.ui.webview.AdWebView$WebViewEventListener r7 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.access$400(r7)     // Catch: java.lang.Exception -> L7f
                r7.onPageFinished()     // Catch: java.lang.Exception -> L7f
                goto L93
            L7f:
                r7 = move-exception
                com.gomfactory.adpie.sdk.AdPieSDK r8 = com.gomfactory.adpie.sdk.AdPieSDK.getInstance()
                com.gomfactory.adpie.sdk.common.Configuration r8 = r8.getConfiguration()
                boolean r8 = r8.isAdpieSdkLog()
                if (r8 == 0) goto L93
                java.lang.String r8 = com.gomfactory.adpie.sdk.ui.webview.AdWebView.TAG
                com.gomfactory.adpie.sdk.util.AdPieLog.e(r8, r7)
            L93:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(AdWebView.TAG, "WebViewClient - shouldOverrideUrlLoading : " + str);
            }
            AdWebView.this.goToBrowser(webView, str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string = webResourceRequest.getUrl().toString();
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(AdWebView.TAG, "WebViewClient - shouldOverrideUrlLoading[N] : " + string);
            }
            AdWebView.this.goToBrowser(webView, string);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(AdWebView.TAG, "WebViewClient - onRenderProcessGone");
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            if (webView == null) {
                return true;
            }
            try {
                if (webView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                }
                webView.onPause();
                webView.destroy();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public class WebViewClientInChromeClient extends WebViewClientClass {
        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        public WebViewClientInChromeClient() {
            super();
        }

        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }
}
