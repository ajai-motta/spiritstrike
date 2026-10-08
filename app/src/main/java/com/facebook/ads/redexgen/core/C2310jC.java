package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2310jC implements O3 {
    public final /* synthetic */ C1443Nu A00;

    public C2310jC(C1443Nu c1443Nu) {
        this.A00 = c1443Nu;
    }

    @Override // com.facebook.ads.redexgen.core.O3
    public final void AFF(AdError adError) {
        this.A00.A04.ACo(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.O3
    public final void AFG() {
        this.A00.A04.ACp();
    }
}
