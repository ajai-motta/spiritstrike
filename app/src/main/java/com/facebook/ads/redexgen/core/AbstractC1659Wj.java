package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1659Wj {
    public static final AtomicReference<InterfaceC1658Wi> A00 = new AtomicReference<>(null);

    public static InterfaceC1658Wi A00() {
        InterfaceC1658Wi errorLogger = A00.get();
        if (errorLogger == null) {
            return new R1();
        }
        return errorLogger;
    }

    public static void A01(InterfaceC1658Wi interfaceC1658Wi) {
        A00.set(interfaceC1658Wi);
    }
}
