package com.moloco.sdk.acm.services;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2016a;
    public final AtomicLong b;

    public f(g timeProviderService) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f2016a = timeProviderService;
        this.b = new AtomicLong(0L);
    }

    public final long a() {
        return this.f2016a.invoke() - this.b.get();
    }

    public final AtomicLong b() {
        return this.b;
    }

    public final void c() {
        this.b.set(this.f2016a.invoke());
    }
}
