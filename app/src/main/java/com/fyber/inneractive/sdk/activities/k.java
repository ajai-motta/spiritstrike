package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f872a;

    public k(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f872a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView = this.f872a.e;
        if (webView != null) {
            webView.reload();
            int i = IAlog.f1642a;
            IAlog.d("%s %s", "AD_INTERNAL_BROWSER_REFRESH", this.f872a.e.getUrl());
        }
    }
}
