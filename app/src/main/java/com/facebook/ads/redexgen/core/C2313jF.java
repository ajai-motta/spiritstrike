package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2313jF implements SM {
    public final /* synthetic */ AbstractC2330jd A00;
    public final /* synthetic */ InterfaceC1442Nt A01;
    public final /* synthetic */ C1443Nu A02;
    public final /* synthetic */ C2165gi A03;
    public final /* synthetic */ boolean A04;

    public C2313jF(C1443Nu c1443Nu, C2165gi c2165gi, boolean z, AbstractC2330jd abstractC2330jd, InterfaceC1442Nt interfaceC1442Nt) {
        this.A02 = c1443Nu;
        this.A03 = c2165gi;
        this.A04 = z;
        this.A00 = abstractC2330jd;
        this.A01 = interfaceC1442Nt;
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACx() {
        if (C1615Up.A1q(this.A03) && this.A04) {
            this.A02.A02.add(AbstractC1950dD.A01(this.A03, this.A00, 1, new C2314jG(this)));
        } else {
            this.A01.ACp();
        }
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACy() {
        this.A01.ACo(AdError.CACHE_ERROR);
    }
}
