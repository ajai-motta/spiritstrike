package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.it, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2293it extends AbstractRunnableC1652Wc {
    public final /* synthetic */ C10517w A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C10297a A02;

    public C2293it(C10297a c10297a, O8 o8, C10517w c10517w) {
        this.A02 = c10297a;
        this.A01 = o8;
        this.A00 = c10517w;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        AdErrorType adErrorType = AdErrorType.RV_AD_TIMEOUT;
        this.A02.A0B.A0F().A5g(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        this.A02.A07.A0G(new C1637Vm(adErrorType, ""));
    }
}
