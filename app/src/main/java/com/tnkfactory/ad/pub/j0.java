package com.tnkfactory.ad.pub;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes6.dex */
public final class j0 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f3144a;

    public j0(l0 l0Var) {
        this.f3144a = l0Var;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        k0 k0Var = this.f3144a.b;
        if (k0Var != null) {
            k0Var.b();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        k0 k0Var = this.f3144a.b;
        if (k0Var != null) {
            k0Var.a();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f3144a.a(str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return this.f3144a.a(webResourceRequest != null ? webResourceRequest.getUrl().toString() : null);
    }
}
