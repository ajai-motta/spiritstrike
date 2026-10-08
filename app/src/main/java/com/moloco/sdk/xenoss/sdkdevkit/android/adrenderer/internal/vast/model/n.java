package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class n {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2832a;
    public final String b;

    public n(String str, String impressionUrl) {
        Intrinsics.checkNotNullParameter(impressionUrl, "impressionUrl");
        this.f2832a = str;
        this.b = impressionUrl;
    }

    public final String a() {
        return this.f2832a;
    }

    public final String b() {
        return this.b;
    }
}
