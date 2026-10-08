package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f940a;
    public final /* synthetic */ String b;

    public f0(String str, String str2) {
        this.f940a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        WebView webView;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (iAConfigManager.L == null && (context = iAConfigManager.f) != null) {
            try {
                webView = new WebView(context);
                webView.setWebViewClient(new y());
            } catch (Throwable unused) {
                IAlog.a("failed to create a new webview", new Object[0]);
                webView = null;
            }
            iAConfigManager.L = webView;
        }
        WebView webView2 = iAConfigManager.L;
        String str = this.f940a;
        String str2 = this.b;
        if (webView2 != null) {
            if (str2 == null) {
                str2 = "";
            }
            webView2.loadDataWithBaseURL(str, str2, "text/html", "utf-8", null);
        }
        com.fyber.inneractive.sdk.util.r.b.postDelayed(IAConfigManager.Q, TimeUnit.SECONDS.toMillis(10L));
    }
}
