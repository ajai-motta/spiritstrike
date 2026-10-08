package com.facebook.ads.redexgen.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C10387j extends AbstractC2300j0 {
    public C10387j(C2165gi c2165gi, O7 o7) {
        super(c2165gi, o7);
    }

    private C2298iy A00(Runnable runnable) {
        return new C2298iy(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2300j0
    public final NQ A0I() {
        C2352jz successfullyLoadedAdapter = (C2352jz) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2300j0
    public final void A0P() {
        C2352jz interstitialAdapter = (C2352jz) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2300j0
    public final void A0R(N1 n1, C1596Tw c1596Tw, C1594Tu c1594Tu, O8 o8) {
        C2352jz c2352jz = (C2352jz) n1;
        C2299iz c2299iz = new C2299iz(this, o8, c2352jz);
        A0H().postDelayed(c2299iz, c1596Tw.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c2352jz.A0A(this.A0B, A00(c2299iz), o8, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
