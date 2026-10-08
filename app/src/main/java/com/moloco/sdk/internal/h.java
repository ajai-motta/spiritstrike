package com.moloco.sdk.internal;

import com.moloco.sdk.service_locator.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2056a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.h$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return h.b();
        }
    });

    public static final f a() {
        return c();
    }

    public static final g b() {
        return new g(a.i.f2427a.c());
    }

    public static final g c() {
        return (g) f2056a.getValue();
    }
}
