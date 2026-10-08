package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C10537y extends AbstractC2304j4 {
    public final /* synthetic */ C10517w A00;
    public final /* synthetic */ AbstractC2334jh A01;
    public final /* synthetic */ C10407l A02;
    public final /* synthetic */ boolean A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10537y(C10517w c10517w, boolean z, boolean z2, C10407l c10407l, AbstractC2334jh abstractC2334jh) {
        super(z);
        this.A00 = c10517w;
        this.A03 = z2;
        this.A02 = c10407l;
        this.A01 = abstractC2334jh;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2304j4
    public final void A00() {
        this.A00.A01.AFp(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2304j4
    public final void A01(boolean z) {
        if (!C1615Up.A1t(this.A00.A04) || !this.A03) {
            if (this.A00.A05 == WK.A0J) {
                this.A00.A04.A0F().AER();
            }
            this.A00.A0C.set(true);
            this.A00.A01.AFm(this.A01);
            return;
        }
        this.A00.A06 = AbstractC1950dD.A01(this.A00.A04, this.A02, 0, new C2343jq(this));
    }
}
