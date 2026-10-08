package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class ED extends RelativeLayout implements InterfaceC2053eu {
    public C1202Ek A00;

    public ED(C2165gi c2165gi) {
        super(c2165gi);
    }

    public ED(C2165gi c2165gi, AttributeSet attributeSet, int i) {
        super(c2165gi, attributeSet, i);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2053eu
    public final void AAv(C1202Ek c1202Ek) {
        this.A00 = c1202Ek;
        A07();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2053eu
    public final void AKV(C1202Ek c1202Ek) {
        A08();
        this.A00 = null;
    }

    public C1202Ek getVideoView() {
        return this.A00;
    }
}
