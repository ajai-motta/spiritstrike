package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1242Fz implements InterfaceC1929cs {
    public final /* synthetic */ C1241Fy A00;

    public C1242Fz(C1241Fy c1241Fy) {
        this.A00 = c1241Fy;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1929cs
    public final void AGW(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1929cs
    public final void AGY(View view) {
        AbstractC1326Jg abstractC1326Jg = (AbstractC1326Jg) view;
        abstractC1326Jg.A1T();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC1326Jg.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
