package com.bytedance.sdk.component.utils;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public class rdp {
    private static final qdl qdl = new ud();

    private static class qdl {
        private qdl() {
        }

        public void qdl(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    private static class ud extends qdl {
        private ud() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.rdp.qdl
        public void qdl(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    return;
                } catch (Throwable th) {
                    boolean z = th instanceof IllegalStateException;
                }
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void qdl(WebView webView, String str) {
        qdl.qdl(webView, str);
    }
}
