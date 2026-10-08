package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.internal.services.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3009j {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2384a;
    public final String b;
    public final String c;

    public C3009j(String applicationName, String packageName, String version) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(version, "version");
        this.f2384a = applicationName;
        this.b = packageName;
        this.c = version;
    }

    public final String a() {
        return this.f2384a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
