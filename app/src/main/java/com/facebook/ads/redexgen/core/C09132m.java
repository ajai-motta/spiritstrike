package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C09132m {
    public static String[] A02 = {"GJxubYlXsZiu90nLIAtZt0ZPoHJfDn5s", "BS8EJfUuntSU9isaC3nv1ANhy", "Gs0aOb6gQMfpDwhZyZjPrCKqfhvLXKwh", "iN3iHRJ6T765oBofKZIxuh5bzIdVCLFB", "wNf5fiO3vn7igkhJYRlF92Iu10jGyY95", "PRW1z97xqqsLulYYbCVWRoDib", "FY0aCr3Onb0", "4J82hMkwk7B8La5ZKR1JgNOMoJvqL0p2"};
    public boolean A00;
    public final SparseBooleanArray A01 = new SparseBooleanArray();

    public final C09132m A00(int i) {
        AbstractC09493y.A08(!this.A00);
        this.A01.append(i, true);
        return this;
    }

    public final C09132m A01(int i, boolean z) {
        if (z) {
            C09132m c09132mA00 = A00(i);
            if (A02[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "oVNjkypXGUiIrzEYrZV4GsKas1KVyN3y";
            strArr[3] = "tIVTdGxG4MXYUs0uHZXzBbuDNAp7p6hg";
            return c09132mA00;
        }
        return this;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.C09132m A02(com.facebook.ads.redexgen.core.C09142n r3) {
        /*
            r2 = this;
            r1 = 0
        L1:
            int r0 = r3.A00()
            if (r1 >= r0) goto L11
            int r0 = r3.A01(r1)
            r2.A00(r0)
            int r1 = r1 + 1
            goto L1
        L11:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C09132m.A02(com.facebook.ads.redexgen.X.2n):com.facebook.ads.redexgen.X.2m");
    }

    public final C09132m A03(int... iArr) {
        for (int i : iArr) {
            A00(i);
        }
        return this;
    }

    public final C09142n A04() {
        AbstractC09493y.A08(!this.A00);
        this.A00 = true;
        return new C09142n(this.A01);
    }
}
