package com.facebook.ads.redexgen.core;

import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2506mi extends H2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2506mi(final HJ hj, int i, long j, long j2) {
        super(new InterfaceC1266Gx() { // from class: com.facebook.ads.redexgen.X.mk
            @Override // com.facebook.ads.redexgen.core.InterfaceC1266Gx
            public final long AKQ(long j3) {
                return hj.A07(j3);
            }
        }, new C2507mj(hj, i), hj.A06(), 0L, hj.A09, j, j2, hj.A05(), Math.max(6, hj.A06));
        Objects.requireNonNull(hj);
    }
}
