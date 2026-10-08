package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import com.moloco.sdk.service_locator.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3048a = "NonPersistentRequest";
    public static final Lazy b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.h$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return h.a();
        }
    });
    public static final long c = 10000;

    public static final g a() {
        return new g(a.i.f2427a.a());
    }

    public static final f b() {
        return c();
    }

    public static final g c() {
        return (g) b.getValue();
    }
}
