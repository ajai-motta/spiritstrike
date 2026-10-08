package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3016a = 0;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.f
    public String a(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        byte[] bytes = StringsKt.trimIndent(content).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 1);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
