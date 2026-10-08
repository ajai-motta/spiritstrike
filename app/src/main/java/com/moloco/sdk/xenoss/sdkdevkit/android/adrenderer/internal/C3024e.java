package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3024e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2513a = "https://appassets.androidplatform.net";

    public static final void a(WebView webView, String data) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        webView.loadDataWithBaseURL(f2513a, data, "text/html", "utf-8", null);
    }
}
