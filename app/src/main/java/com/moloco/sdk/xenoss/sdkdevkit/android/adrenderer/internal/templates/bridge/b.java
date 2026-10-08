package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements a {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f2629a;

    public b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f2629a = webView;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.a
    public void a() {
        this.f2629a.evaluateJavascript("notifyReadyEvent()", null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.a
    public void a(boolean z) {
        this.f2629a.evaluateJavascript("setIsViewable(" + z + ')', null);
    }
}
