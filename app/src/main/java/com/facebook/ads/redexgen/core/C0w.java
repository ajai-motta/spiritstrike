package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0w, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0w extends C1J {
    public C6X A00;
    public List<C2003e5> A01;

    public C0w(C2165gi c2165gi) {
        super(c2165gi);
        this.A00 = new C6X(this, 1, null, null, null);
    }

    public final void A20(C2110fp c2110fp) {
        if (this.A00 != null) {
            this.A00.A0c(c2110fp);
        }
    }

    public C6X getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0d(this.A01);
    }
}
