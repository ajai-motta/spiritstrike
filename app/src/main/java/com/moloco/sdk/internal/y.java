package com.moloco.sdk.internal;

import com.moloco.sdk.service_locator.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2417a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.y$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return y.a();
        }
    });
    public static final String b = "[ERROR_CODE]";
    public static final String c = "[HAPPENED_AT_TS]";

    public static final x a() {
        return new x(a.i.f2427a.c());
    }

    public static final w b() {
        return c();
    }

    public static final x c() {
        return (x) f2417a.getValue();
    }
}
