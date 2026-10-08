package com.facebook.ads.redexgen.core;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YS {
    public static YS A02;
    public final C1488Pp A00;
    public final YU A01;

    public YS(C2165gi c2165gi, Executor executor, C1596Tw c1596Tw) {
        this.A01 = new YU(c2165gi);
        this.A00 = new C1488Pp(executor, c1596Tw, c2165gi);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C2165gi c2165gi, Executor executor, C1596Tw c1596Tw) {
        if (!C1615Up.A1c(c2165gi)) {
            return;
        }
        if (A02 == null) {
            A02 = new YS(c2165gi, executor, c1596Tw);
            A02.A00();
        } else {
            A02.A02(c1596Tw);
        }
    }

    private void A02(C1596Tw c1596Tw) {
        this.A00.A07(c1596Tw);
    }
}
