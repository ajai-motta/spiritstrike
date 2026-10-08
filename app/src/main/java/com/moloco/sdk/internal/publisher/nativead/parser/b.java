package com.moloco.sdk.internal.publisher.nativead.parser;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends Exception {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2225a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b;

    public b(int i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c errorSubType) {
        Intrinsics.checkNotNullParameter(errorSubType, "errorSubType");
        this.f2225a = i;
        this.b = errorSubType;
    }

    public final int a() {
        return this.f2225a;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
        return this.b;
    }
}
