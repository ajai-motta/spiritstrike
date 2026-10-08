package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AQ implements InterfaceC2661pF {
    public static String[] A04 = {"fHQEiP1zlTMmcDhuRJvCUYhlqM3A1WdS", "0xjR5o24wRXCnK6P48nvJnLVp1A7yIdC", "SqWyKblZmsOi3mnFjBlOyIvINI4fuoz1", "GUT90kd8g0iIA", "yfLAFjbfQv", "f1jCtkpjn8LmH02gI7EE0X95Og8KENXi", "pIy67q2NMZ", "VUF0F4IbO37j7MJUWX75PYUeN7L9nYYd"};
    public int A00;
    public C09855i A01;
    public final ArrayList<InterfaceC09965t> A02 = new ArrayList<>(1);
    public final boolean A03;

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public /* synthetic */ Map A8t() {
        return C5X.A00(this);
    }

    public AQ(boolean z) {
        this.A03 = z;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0D(com.facebook.ads.redexgen.core.C09855i r4, boolean r5) {
        /*
            r3 = this;
            r3.A01 = r4
            r2 = 0
        L3:
            int r0 = r3.A00
            if (r2 >= r0) goto L17
            java.util.ArrayList<com.facebook.ads.redexgen.X.5t> r0 = r3.A02
            java.lang.Object r1 = r0.get(r2)
            com.facebook.ads.redexgen.X.5t r1 = (com.facebook.ads.redexgen.core.InterfaceC09965t) r1
            boolean r0 = r3.A03
            r1.AGH(r3, r4, r0, r5)
            int r2 = r2 + 1
            goto L3
        L17:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AQ.A0D(com.facebook.ads.redexgen.X.5i, boolean):void");
    }

    public final void A0E() {
        C09855i c09855i = (C09855i) C5C.A0f(this.A01);
        for (int i = 0; i < this.A00; i++) {
            this.A02.get(i).AGG(this, c09855i, this.A03);
        }
        this.A01 = null;
    }

    public final void A0F(int i) {
        C09855i c09855i = (C09855i) C5C.A0f(this.A01);
        for (int i2 = 0; i2 < this.A00; i2++) {
            this.A02.get(i2).ADK(this, c09855i, this.A03, i);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0003 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0G(com.facebook.ads.redexgen.core.C09855i r5) {
        /*
            r4 = this;
            r3 = 0
        L1:
            int r0 = r4.A00
            if (r3 >= r0) goto L29
            java.util.ArrayList<com.facebook.ads.redexgen.X.5t> r0 = r4.A02
            r0.get(r3)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AQ.A04
            r0 = 7
            r1 = r1[r0]
            r0 = 14
            char r1 = r1.charAt(r0)
            r0 = 80
            if (r1 == r0) goto L23
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AQ.A04
            java.lang.String r1 = "KcnUkvSyZAFqCmq9nk7LLPyjKQRUe1pa"
            r0 = 2
            r2[r0] = r1
            int r3 = r3 + 1
            goto L1
        L23:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AQ.A0G(com.facebook.ads.redexgen.X.5i):void");
    }

    public final void A0H(C09855i c09855i) {
        A0D(c09855i, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final void A43(InterfaceC09965t interfaceC09965t) {
        AbstractC09493y.A01(interfaceC09965t);
        if (!this.A02.contains(interfaceC09965t)) {
            this.A02.add(interfaceC09965t);
            this.A00++;
        }
    }
}
