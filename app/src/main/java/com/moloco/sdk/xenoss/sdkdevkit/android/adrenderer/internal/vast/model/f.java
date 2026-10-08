package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2824a;
    public final List<String> b;

    public f(String clickThroughUrl, List<String> clickTrackingUrls) {
        Intrinsics.checkNotNullParameter(clickThroughUrl, "clickThroughUrl");
        Intrinsics.checkNotNullParameter(clickTrackingUrls, "clickTrackingUrls");
        this.f2824a = clickThroughUrl;
        this.b = clickTrackingUrls;
    }

    public final String a() {
        return this.f2824a;
    }

    public final List<String> b() {
        return this.b;
    }
}
