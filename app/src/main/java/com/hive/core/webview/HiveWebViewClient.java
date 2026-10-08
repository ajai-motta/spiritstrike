package com.hive.core.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.MimeTypeMap;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.core.cache.HiveResourceLoader;
import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HiveWebViewClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0017J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J \u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0017J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J,\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0017J$\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010'H\u0017J,\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0002J,\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\b2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, d2 = {"Lcom/hive/core/webview/HiveWebViewClient;", "Landroid/webkit/WebViewClient;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "<init>", "(Lcom/hive/core/webview/SchemeHandler;)V", "timeLogMap", "", "", "", "currentTimeMillis", "getCurrentTimeMillis", "()J", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "hiveResourceHandle", "onLoadResource", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "Landroid/webkit/WebResourceError;", "mainFrameErrorReload", "receivedErrorEvent", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HiveWebViewClient extends WebViewClient {
    private final SchemeHandler schemeHandler;
    private final Map<String, Long> timeLogMap;

    public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public HiveWebViewClient(SchemeHandler schemeHandler) {
        Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
        this.schemeHandler = schemeHandler;
        this.timeLogMap = new LinkedHashMap();
    }

    private final long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.INSTANCE.d("[HiveWebViewClient] onPageStarted : " + url);
        this.timeLogMap.put(url, Long.valueOf(getCurrentTimeMillis()));
        HiveResourceLoader.delayed$default(HiveResourceLoader.INSTANCE, 0L, 1, null);
        if (view instanceof HiveWebView) {
            ((HiveWebView) view).blacklistDomain(!HiveWebView.INSTANCE.isWhitelistDomain(url));
        }
        super.onPageStarted(view, url, favicon);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Object objValueOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Logger logger = Logger.INSTANCE;
        StringBuilder sb = new StringBuilder("[HiveWebViewClient] onPageFinished : ");
        sb.append(url);
        sb.append(" (");
        Long l = this.timeLogMap.get(url);
        if (l != null) {
            objValueOf = Long.valueOf(getCurrentTimeMillis() - l.longValue());
        } else {
            objValueOf = "unknown";
        }
        sb.append(objValueOf);
        sb.append(" Millis)");
        logger.d(sb.toString());
        super.onPageFinished(view, url);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        return hiveResourceHandle(url);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return hiveResourceHandle(string);
    }

    private final WebResourceResponse hiveResourceHandle(String url) {
        byte[] bArrLoadResourceImmediately;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        if (mimeTypeFromExtension == null || !StringsKt.startsWith(mimeTypeFromExtension, "image", true) || StringsKt.endsWith(url, "favicon.ico", true) || (bArrLoadResourceImmediately = HiveResourceLoader.INSTANCE.loadResourceImmediately(url)) == null) {
            return null;
        }
        Logger.INSTANCE.d("[HiveWebViewClient] intercept request success: " + url + " (" + fileExtensionFromUrl + ", " + mimeTypeFromExtension + ')');
        return new WebResourceResponse(mimeTypeFromExtension, "utf-8", new ByteArrayInputStream(bArrLoadResourceImmediately));
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(error, "error");
        Logger.INSTANCE.w("[HiveWebViewClient] onReceivedSslError errorCode: " + error.getPrimaryError() + ", failingUrl : " + error.getUrl());
        super.onReceivedSslError(view, handler, error);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Logger.INSTANCE.d("[HiveWebViewClient] shouldOverrideUrlLoading url : " + url);
        try {
            return this.schemeHandler.handle(view, Uri.parse(url));
        } catch (Exception e) {
            Logger.INSTANCE.w("[HiveWebViewClient] schemeEvent Exception : " + e);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Logger.INSTANCE.d("[HiveWebViewClient] shouldOverrideUrlLoading WebResourceRequest : " + request.getUrl());
        SchemeHandler schemeHandler = this.schemeHandler;
        Uri url = request.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        return schemeHandler.handle(view, url);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.INSTANCE.w("[HiveWebViewClient] onReceivedError \n    errorCode: " + errorCode + "\n    description: " + description + "\n    failingUrl: " + failingUrl);
        mainFrameErrorReload(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        CharSequence description;
        CharSequence description2;
        Intrinsics.checkNotNullParameter(view, "view");
        Logger logger = Logger.INSTANCE;
        StringBuilder sb = new StringBuilder("[HiveWebViewClient] onReceivedError \n    request url: ");
        sb.append(request != null ? request.getUrl() : null);
        sb.append("\n    request isForMainFrame: ");
        sb.append(request != null ? Boolean.valueOf(request.isForMainFrame()) : null);
        sb.append("\n    request headers: ");
        sb.append(request != null ? request.getRequestHeaders() : null);
        sb.append("\n    error errorCode: ");
        sb.append(error != null ? Integer.valueOf(error.getErrorCode()) : null);
        sb.append("\n    error description: ");
        sb.append((Object) (error != null ? error.getDescription() : null));
        logger.w(sb.toString());
        if (request != null && request.isForMainFrame()) {
            int errorCode = error != null ? error.getErrorCode() : -99;
            String string = (error == null || (description2 = error.getDescription()) == null) ? null : description2.toString();
            Uri url = request.getUrl();
            mainFrameErrorReload(view, errorCode, string, url != null ? url.toString() : null);
            return;
        }
        if (Logger.INSTANCE.getCoreLogEnable() && HiveCoreInitializer.INSTANCE.isInitContextInitialized()) {
            Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
            StringBuilder sb2 = new StringBuilder("onReceivedError in SubFrame(");
            if (error != null && (description = error.getDescription()) != null) {
                string = description.toString();
            }
            sb2.append(string);
            sb2.append(')');
            Toast.makeText(initContext, sb2.toString(), 1).show();
        }
    }

    private final void mainFrameErrorReload(WebView view, int errorCode, String description, String failingUrl) {
        if (view.getSettings().getCacheMode() == -1 && Intrinsics.areEqual(description, "net::ERR_CACHE_MISS")) {
            Logger.INSTANCE.w("[HiveWebViewClient] Main frame cache miss error, Try no cache reload.");
            view.getSettings().setCacheMode(2);
            if (failingUrl != null) {
                if (view instanceof HiveWebView) {
                    ((HiveWebView) view).getRequestOptions().setSupportHiveTheme(false);
                }
                view.loadUrl(failingUrl);
                return;
            }
            view.reload();
            return;
        }
        receivedErrorEvent(view, errorCode, description, failingUrl);
    }
}
