package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1379Lh extends AbstractRunnableC1652Wc {
    public final WeakReference<C2110fp> A00;

    public C1379Lh(C2110fp c2110fp) {
        this.A00 = new WeakReference<>(c2110fp);
    }

    public C1379Lh(WeakReference<C2110fp> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        C2110fp viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
