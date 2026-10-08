package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f870a;

    public i(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f870a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView = this.f870a.e;
        if (webView == null || !webView.canGoBack()) {
            return;
        }
        this.f870a.e.goBack();
    }
}
