package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2299iz extends AbstractRunnableC1652Wc {
    public final /* synthetic */ C2352jz A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C10387j A02;

    public C2299iz(C10387j c10387j, O8 o8, C2352jz c2352jz) {
        this.A02 = c10387j;
        this.A01 = o8;
        this.A00 = c2352jz;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        C1637Vm c1637VmA00 = C1637Vm.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0F().A5g(c1637VmA00.A03().getErrorCode(), c1637VmA00.A04());
        this.A02.A07.A0G(c1637VmA00);
    }
}
