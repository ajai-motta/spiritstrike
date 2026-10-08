package com.applovin.impl;

import com.applovin.impl.e6;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f439a;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.k kVar) {
        if (f439a) {
            return;
        }
        kVar.D().a(d2.S0, "no_ads_loaded");
    }

    public static void b(final com.applovin.impl.sdk.k kVar) {
        Long l = (Long) kVar.a(r3.s8);
        if (l.longValue() <= 0) {
            return;
        }
        kVar.r0().a(new s6(kVar, true, "submitIntegrationErrorReport", new Runnable() { // from class: com.applovin.impl.k2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                k2.a(kVar);
            }
        }), e6.b.OTHER, TimeUnit.SECONDS.toMillis(l.longValue()));
    }

    public static void a() {
        f439a = true;
    }
}
