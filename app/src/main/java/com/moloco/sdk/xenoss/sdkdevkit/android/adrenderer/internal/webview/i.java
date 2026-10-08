package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements h {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f3018a;
    public final f b;
    public final g c;

    public i(j localAssetLoader, f contentEncoder, g cssMarginHandler) {
        Intrinsics.checkNotNullParameter(localAssetLoader, "localAssetLoader");
        Intrinsics.checkNotNullParameter(contentEncoder, "contentEncoder");
        Intrinsics.checkNotNullParameter(cssMarginHandler, "cssMarginHandler");
        this.f3018a = localAssetLoader;
        this.b = contentEncoder;
        this.c = cssMarginHandler;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.h
    public String a(String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        String strA = this.f3018a.a(w.k);
        return StringsKt.trimIndent("\n            <script>" + this.f3018a.a("mraid-bridge.js") + "</script>\n            <iframe id=\"adFrame\"\n                style=\"width:100vw; height:100vh; border:none;\"\n                src=\"data:text/html;base64," + this.b.a(StringsKt.replace$default(this.c.a(html), "<script src=\"mraid.js\"></script>", "<script>" + strA + "</script>", false, 4, (Object) null)) + "\"\n                sandbox=\"allow-scripts allow-same-origin\"\n            >\n            </iframe>\n        ");
    }

    public /* synthetic */ i(j jVar, f fVar, g gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jVar, fVar, (i & 4) != 0 ? new g() : gVar);
    }
}
