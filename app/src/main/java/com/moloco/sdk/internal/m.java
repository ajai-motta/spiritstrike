package com.moloco.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class m {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2094a;
    public final int b;

    public m(String description, int i) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.f2094a = description;
        this.b = i;
    }

    public final String a() {
        return this.f2094a;
    }

    public final int b() {
        return this.b;
    }
}
