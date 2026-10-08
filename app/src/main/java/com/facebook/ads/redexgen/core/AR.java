package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AR extends Timeline {
    public static String[] A04 = {"nDkuZZEFG4iGMwbsGEvKBo4ueCI7wxif", "OM6NJOBBZMKrUazjZz4CdR8Ljfz9nzwy", "h9AdYD37MAF4FmuzDOyGIvEw", "VkmtOVI9Gbc78hEhNGIz4LiMtzYnUrU2", "bkWqGplua99PBwc9ED6yZtwvDtuw6KwN", "305DBImSoaz5MlD7g6qLfpiwFg5d3Fl", "QtOjLPNYFNek9UnmHWOFtbeX9w", "y2avdvKeY0dhYPEmFhuJXZmeyR2ks2D4"};
    public final BP<C2692pl> A00;
    public final BP<C2690pj> A01;
    public final int[] A02;
    public final int[] A03;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Period> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Window> */
    /* JADX WARN: Incorrect condition in loop: B:7:0x001b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AR(com.facebook.ads.redexgen.core.BP<com.facebook.ads.redexgen.core.C2690pj> r4, com.facebook.ads.redexgen.core.BP<com.facebook.ads.redexgen.core.C2692pl> r5, int[] r6) {
        /*
            r3 = this;
            r3.<init>()
            int r1 = r4.size()
            int r0 = r6.length
            if (r1 != r0) goto L26
            r0 = 1
        Lb:
            com.facebook.ads.redexgen.core.AbstractC09493y.A07(r0)
            r3.A01 = r4
            r3.A00 = r5
            r3.A02 = r6
            int r0 = r6.length
            int[] r0 = new int[r0]
            r3.A03 = r0
            r2 = 0
        L1a:
            int r0 = r6.length
            if (r2 >= r0) goto L28
            int[] r1 = r3.A03
            r0 = r6[r2]
            r1[r0] = r2
            int r2 = r2 + 1
            goto L1a
        L26:
            r0 = 0
            goto Lb
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AR.<init>(com.facebook.ads.redexgen.X.BP, com.facebook.ads.redexgen.X.BP, int[]):void");
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A06() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A07() {
        return this.A01.size();
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A08(int i, int i2, boolean z) {
        if (i2 == 1) {
            return i;
        }
        if (i == A0C(z)) {
            if (i2 == 2) {
                return A0B(z);
            }
            return -1;
        }
        if (z) {
            return this.A02[this.A03[i] + 1];
        }
        return i + 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0A(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0B(boolean z) {
        if (A0N()) {
            return -1;
        }
        if (!z) {
            return 0;
        }
        int[] iArr = this.A02;
        if (A04[1].charAt(22) == 'H') {
            throw new RuntimeException();
        }
        A04[7] = "6ncpOYdEr0xsUZdZBYFnYejLEosAstPL";
        return iArr[0];
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0C(boolean z) {
        if (A0N()) {
            return -1;
        }
        if (z) {
            return this.A02[A07() - 1];
        }
        return A07() - 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2692pl A0I(int i, C2692pl p, boolean z) {
        C2692pl p2 = this.A00.get(i);
        p.A0G(p2.A03, p2.A04, p2.A00, p2.A01, p2.A02, p2.A06, p2.A05);
        return p;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C2690pj A0L(int i, C2690pj c2690pj, long j) {
        C2690pj c2690pj2 = this.A01.get(i);
        c2690pj.A07(c2690pj2.A0C, c2690pj2.A09, c2690pj2.A0A, c2690pj2.A06, c2690pj2.A07, c2690pj2.A04, c2690pj2.A0G, c2690pj2.A0D, c2690pj2.A08, c2690pj2.A02, c2690pj2.A03, c2690pj2.A00, c2690pj2.A01, c2690pj2.A05);
        c2690pj.A0F = c2690pj2.A0F;
        return c2690pj;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final Object A0M(int i) {
        throw new UnsupportedOperationException();
    }
}
