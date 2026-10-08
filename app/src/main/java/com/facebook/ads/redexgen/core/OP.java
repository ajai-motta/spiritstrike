package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OP {

    @Nullable
    public static OO A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static OO A00(C2161ge c2161ge) {
        if (A00 == null) {
            A00 = new OO(c2161ge);
        }
        return A00;
    }

    public static void A01(C2161ge c2161ge) {
        if (AbstractC1618Us.A0F(c2161ge)) {
            A03(c2161ge);
        }
    }

    public static void A02(C2161ge c2161ge) {
        if (AbstractC1618Us.A0E(c2161ge)) {
            A03(c2161ge);
        }
    }

    public static void A03(C2161ge c2161ge) {
        if (A01.compareAndSet(false, true)) {
            Y4.A01.execute(new C2264iN(c2161ge));
        }
    }
}
