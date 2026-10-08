package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public class C3023d extends WebView {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g f2512a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3023d(Context context) {
        super(context.getApplicationContext());
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2512a = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        super.destroy();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g getHtmlCssFixer() {
        return this.f2512a;
    }
}
