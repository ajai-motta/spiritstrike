package com.fyber.inneractive.sdk.util;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f1663a;

    public o0(WebView webView) {
        this.f1663a = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1663a.getSettings().setDisplayZoomControls(false);
    }
}
