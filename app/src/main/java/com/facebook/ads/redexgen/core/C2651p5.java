package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2651p5 extends C09785b {
    public static byte[] A02;
    public final int A00;
    public final C09855i A01;

    static {
        A06();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{-39, -30, -37, -41, -24, -22, -37, -18, -22, -92, -96, -28, -27, -22, -106, -26, -37, -24, -29, -33, -22, -22, -37, -38, -92, -96};
    }

    public C2651p5(C09855i c09855i, int i, int i2) {
        super(A03(i, i2));
        this.A01 = c09855i;
        this.A00 = i2;
    }

    public C2651p5(IOException iOException, C09855i c09855i, int i, int i2) {
        super(iOException, A03(i, i2));
        this.A01 = c09855i;
        this.A00 = i2;
    }

    public C2651p5(String str, C09855i c09855i, int i, int i2) {
        super(str, A03(i, i2));
        this.A01 = c09855i;
        this.A00 = i2;
    }

    public C2651p5(String str, IOException iOException, C09855i c09855i, int i, int i2) {
        super(str, iOException, A03(i, i2));
        this.A01 = c09855i;
        this.A00 = i2;
    }

    public static int A03(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C2651p5 A04(java.io.IOException r4, com.facebook.ads.redexgen.core.C09855i r5, int r6) {
        /*
            java.lang.String r1 = r4.getMessage()
            boolean r0 = r4 instanceof java.net.SocketTimeoutException
            if (r0 == 0) goto L1a
            r1 = 2002(0x7d2, float:2.805E-42)
        La:
            r0 = 2007(0x7d7, float:2.812E-42)
            if (r1 != r0) goto L14
            com.facebook.ads.redexgen.X.AM r0 = new com.facebook.ads.redexgen.X.AM
            r0.<init>(r4, r5)
        L13:
            return r0
        L14:
            com.facebook.ads.redexgen.X.p5 r0 = new com.facebook.ads.redexgen.X.p5
            r0.<init>(r4, r5, r1, r6)
            goto L13
        L1a:
            boolean r0 = r4 instanceof java.io.InterruptedIOException
            if (r0 == 0) goto L21
            r1 = 1004(0x3ec, float:1.407E-42)
            goto La
        L21:
            if (r1 == 0) goto L39
            java.lang.String r3 = com.facebook.ads.redexgen.core.AbstractC2360k7.A01(r1)
            r2 = 0
            r1 = 26
            r0 = 62
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r3.matches(r0)
            if (r0 == 0) goto L39
            r1 = 2007(0x7d7, float:2.812E-42)
            goto La
        L39:
            r1 = 2001(0x7d1, float:2.804E-42)
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2651p5.A04(java.io.IOException, com.facebook.ads.redexgen.X.5i, int):com.facebook.ads.redexgen.X.p5");
    }
}
