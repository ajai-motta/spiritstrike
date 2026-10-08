package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1289Hu {
    public final InterfaceC1272Hd A00;

    public abstract boolean A0B(C09724v c09724v) throws C3K;

    public abstract boolean A0C(C09724v c09724v, long j) throws C3K;

    public AbstractC1289Hu(InterfaceC1272Hd interfaceC1272Hd) {
        this.A00 = interfaceC1272Hd;
    }

    public final boolean A00(C09724v c09724v, long j) throws C3K {
        return A0B(c09724v) && A0C(c09724v, j);
    }
}
