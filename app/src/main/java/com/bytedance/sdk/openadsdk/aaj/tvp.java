package com.bytedance.sdk.openadsdk.aaj;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    private static void ud(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            wd.qdl("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    private static void qdl(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            wd.qdl("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    public static void qdl(WebView webView) {
        if (webView == null) {
            return;
        }
        ud(webView);
        WebSettings settings = webView.getSettings();
        qdl(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable th) {
            wd.qdl("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            settings.setSupportZoom(false);
        } catch (Throwable th2) {
            wd.qdl("WebViewSettings", "setSupportZoom error", th2);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSavePassword(false);
        boolean z = Build.VERSION.SDK_INT >= 28;
        try {
        } catch (Throwable th3) {
            wd.qdl("WebViewSettings", "setLayerType error", th3);
        }
        if (!z) {
            webView.setLayerType(0, null);
        } else {
            if (z) {
                webView.setLayerType(2, null);
            }
            webView.getSettings().setMixedContentMode(0);
        }
        webView.getSettings().setMixedContentMode(0);
    }
}
