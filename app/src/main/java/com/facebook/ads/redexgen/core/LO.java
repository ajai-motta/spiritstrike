package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class LO {
    public final int A00;
    public final long A01;

    public LO(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static LO A00(InterfaceC2516ms interfaceC2516ms, C09724v c09724v) throws IOException {
        interfaceC2516ms.AGt(c09724v.A0l(), 0, 8);
        c09724v.A0f(0);
        int iA0C = c09724v.A0C();
        long size = c09724v.A0O();
        return new LO(iA0C, size);
    }
}
