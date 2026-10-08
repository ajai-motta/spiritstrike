package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3064a {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2819a;
    public final Integer b;
    public final AbstractC3065b c;

    public C3064a(String str, Integer num, AbstractC3065b child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.f2819a = str;
        this.b = num;
        this.c = child;
    }

    public final AbstractC3065b a() {
        return this.c;
    }

    public final String b() {
        return this.f2819a;
    }

    public final Integer c() {
        return this.b;
    }
}
