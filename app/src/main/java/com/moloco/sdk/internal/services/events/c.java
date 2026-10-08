package com.moloco.sdk.internal.services.events;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2351a = d.f2352a;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public void a(boolean z, boolean z2, String appForegroundUrl, String appBackgroundUrl) {
        Intrinsics.checkNotNullParameter(appForegroundUrl, "appForegroundUrl");
        Intrinsics.checkNotNullParameter(appBackgroundUrl, "appBackgroundUrl");
        this.f2351a = new e(z, z2, appForegroundUrl, appBackgroundUrl);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public boolean b() {
        return this.f2351a.h();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public boolean c() {
        return this.f2351a.g();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public String d() {
        return this.f2351a.f();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c
    public String a() {
        return this.f2351a.e();
    }
}
