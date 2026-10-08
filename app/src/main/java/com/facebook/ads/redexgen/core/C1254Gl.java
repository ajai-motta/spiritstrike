package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1254Gl implements InterfaceC1699Ya {
    public final /* synthetic */ AbstractC1252Gj A00;

    public C1254Gl(AbstractC1252Gj abstractC1252Gj) {
        this.A00 = abstractC1252Gj;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1699Ya
    public final void ACl(AbstractC1700Yb abstractC1700Yb) {
        if (abstractC1700Yb.getToolbarActionMode() == 8) {
            this.A00.A0g();
            return;
        }
        this.A00.A07.A04(VH.A07, null);
        if (this.A00.A0l()) {
            return;
        }
        this.A00.A05.A0F().AB0();
        this.A00.A0A.A4j(this.A00.A0B.A7w());
    }
}
