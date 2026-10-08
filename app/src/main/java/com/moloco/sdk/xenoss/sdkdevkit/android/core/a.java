package com.moloco.sdk.xenoss.sdkdevkit.android.core;

import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final void a(HttpRequestBuilder httpRequestBuilder, final long j) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HttpTimeoutKt.timeout(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.core.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a(j, (HttpTimeoutConfig) obj);
            }
        });
    }

    public static final Unit a(long j, HttpTimeoutConfig timeout) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setRequestTimeoutMillis(Long.valueOf(j));
        return Unit.INSTANCE;
    }
}
