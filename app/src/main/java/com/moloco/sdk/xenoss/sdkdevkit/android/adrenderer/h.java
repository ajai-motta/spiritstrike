package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements InterfaceC3019c {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f2439a;
    public final f b;
    public final f c;

    public h(y vastOptions, f mraidOptions, f staticOptions) {
        Intrinsics.checkNotNullParameter(vastOptions, "vastOptions");
        Intrinsics.checkNotNullParameter(mraidOptions, "mraidOptions");
        Intrinsics.checkNotNullParameter(staticOptions, "staticOptions");
        this.f2439a = vastOptions;
        this.b = mraidOptions;
        this.c = staticOptions;
    }

    public final f a() {
        return this.b;
    }

    public final f b() {
        return this.c;
    }

    public final y c() {
        return this.f2439a;
    }
}
