package com.facebook.ads.redexgen.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C9<T> implements InterfaceC2396kj<T>, Serializable {
    public static byte[] A01;
    public static final long serialVersionUID = 0;
    public final List<? extends InterfaceC2396kj<? super T>> A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{52, 65, 55};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public C9(List<? extends InterfaceC2396kj<? super T>> components) {
        this.A00 = components;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2396kj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A4C(@com.google.common.base.ParametricNullness T r3) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.List<? extends com.facebook.ads.redexgen.X.kj<? super T>> r0 = r2.A00
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.List<? extends com.facebook.ads.redexgen.X.kj<? super T>> r0 = r2.A00
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.kj r0 = (com.facebook.ads.redexgen.core.InterfaceC2396kj) r0
            boolean r0 = r0.A4C(r3)
            if (r0 != 0) goto L19
            r0 = 0
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9.A4C(java.lang.Object):boolean");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof C9) {
            return this.A00.equals(((C9) obj).A00);
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public final int hashCode() {
        return this.A00.hashCode() + 306654252;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.google.common.base.Predicates$AndPredicate<T> */
    public final String toString() {
        return AbstractC2398kl.A02(A00(0, 3, 112), this.A00);
    }
}
