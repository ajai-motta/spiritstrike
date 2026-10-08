package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EE implements InterfaceC2050er {
    public final View A00;
    public final C2165gi A01;

    public EE(C2165gi c2165gi, View view) {
        this.A01 = c2165gi;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2050er
    public final double A9V() {
        C2111fq result = C2110fp.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
