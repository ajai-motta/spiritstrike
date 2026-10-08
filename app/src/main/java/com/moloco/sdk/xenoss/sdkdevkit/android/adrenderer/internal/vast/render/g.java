package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2958a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r b;

    public g(String url, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r offset) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.f2958a = url;
        this.b = offset;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r a() {
        return this.b;
    }

    public final String b() {
        return this.f2958a;
    }
}
