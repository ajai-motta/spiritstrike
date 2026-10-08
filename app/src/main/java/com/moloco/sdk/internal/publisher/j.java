package com.moloco.sdk.internal.publisher;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class j {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2183a;
    public final Float b;

    public j(String burl, Float f) {
        Intrinsics.checkNotNullParameter(burl, "burl");
        this.f2183a = burl;
        this.b = f;
    }

    public final String a() {
        return this.f2183a;
    }

    public final Float b() {
        return this.b;
    }
}
