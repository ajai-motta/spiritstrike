package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1258Gp implements InterfaceC1704Yf {
    public final /* synthetic */ AbstractC1252Gj A00;

    public C1258Gp(AbstractC1252Gj abstractC1252Gj) {
        this.A00 = abstractC1252Gj;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1704Yf
    public final void AEZ(int i) {
        this.A00.A0d();
        if (this.A00.A01 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = i;
            this.A00.A01.setLayoutParams(layoutParams);
        }
    }
}
