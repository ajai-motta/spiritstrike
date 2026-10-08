package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3037s implements r {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2607a;

    public C3037s(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2607a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r
    public boolean a(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return C3038t.b(this.f2607a, uri);
    }
}
