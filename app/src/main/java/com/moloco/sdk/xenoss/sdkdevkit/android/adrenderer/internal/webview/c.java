package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements j {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3014a;

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3014a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.j
    public String a(String fileName) throws IOException {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        InputStream inputStreamOpen = this.f3014a.getAssets().open(fileName);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return text;
        } finally {
        }
    }
}
