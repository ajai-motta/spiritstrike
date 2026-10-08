package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2441lT implements InterfaceC1367Kv {
    public static byte[] A0D;
    public static String[] A0E = {"eg1HF5xa7z40pAwthJhUwMgyYSflMm57", "vTWXZUhc0T5ye2gU", "5CU7tG4vDC5MrJOvyrKXJFg3lgmAd80k", "DBSeFcO6ZOsoqUplN3HsHa32omlpR5Gp", "ocqdBidFvokLCywFTEXKHS5uCgObv9g8", "Mmwr1Jc9dpTbQpvT", "ugccp26DZT8wLBdxyPVLtxapsfOoaJDE", "eNeWJfNXyWcyw1SOouQPEZVsCwWfQhE2"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public C2725qI A05;
    public InterfaceC1272Hd A06;
    public String A07;
    public boolean A08;
    public boolean A09;
    public final C09714u A0A;
    public final C09724v A0B;
    public final String A0C;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 29;
            String[] strArr = A0E;
            if (strArr[1].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[7] = "llPzXaIPGYOm1jx09XShEDSvCSxFzIZB";
            strArr2[4] = "gGGXbxf7z5B4GQeBG0q6dPqvCPeZy7ri";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0D = new byte[]{-108, -88, -105, -100, -94, 98, -108, -106, 103};
    }

    static {
        A02();
    }

    public C2441lT() {
        this(null);
    }

    public C2441lT(String str) {
        this.A0A = new C09714u(new byte[16]);
        this.A0B = new C09724v(this.A0A.A00);
        this.A02 = 0;
        this.A00 = 0;
        this.A09 = false;
        this.A08 = false;
        this.A04 = C.TIME_UNSET;
        this.A0C = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.4u r1 = r6.A0A
            r0 = 0
            r1.A08(r0)
            com.facebook.ads.redexgen.X.4u r0 = r6.A0A
            com.facebook.ads.redexgen.X.Gt r3 = com.facebook.ads.redexgen.core.AbstractC1263Gu.A04(r0)
            com.facebook.ads.redexgen.X.qI r5 = r6.A05
            r2 = 0
            r1 = 9
            r0 = 22
            java.lang.String r4 = A00(r2, r1, r0)
            if (r5 == 0) goto L57
            int r5 = r3.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2441lT.A0E
            r0 = 1
            r1 = r2[r0]
            r0 = 5
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L33
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L33:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2441lT.A0E
            java.lang.String r1 = "SKD2aiuMz12sC9MEHPwFtgw1C1HH3qQd"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "2YOZvYYyczeO9UVS3DIHqXjJCxImTVhM"
            r0 = 4
            r2[r0] = r1
            com.facebook.ads.redexgen.X.qI r0 = r6.A05
            int r0 = r0.A06
            if (r5 != r0) goto L57
            int r1 = r3.A04
            com.facebook.ads.redexgen.X.qI r0 = r6.A05
            int r0 = r0.A0G
            if (r1 != r0) goto L57
            com.facebook.ads.redexgen.X.qI r0 = r6.A05
            java.lang.String r0 = r0.A0W
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L85
        L57:
            com.facebook.ads.redexgen.X.2p r1 = new com.facebook.ads.redexgen.X.2p
            r1.<init>()
            java.lang.String r0 = r6.A07
            com.facebook.ads.redexgen.X.2p r0 = r1.A0y(r0)
            com.facebook.ads.redexgen.X.2p r1 = r0.A11(r4)
            int r0 = r3.A01
            com.facebook.ads.redexgen.X.2p r1 = r1.A0b(r0)
            int r0 = r3.A04
            com.facebook.ads.redexgen.X.2p r1 = r1.A0m(r0)
            java.lang.String r0 = r6.A0C
            com.facebook.ads.redexgen.X.2p r0 = r1.A10(r0)
            com.facebook.ads.redexgen.X.qI r0 = r0.A14()
            r6.A05 = r0
            com.facebook.ads.redexgen.X.Hd r1 = r6.A06
            com.facebook.ads.redexgen.X.qI r0 = r6.A05
            r1.A6e(r0)
        L85:
            int r0 = r3.A02
            r6.A01 = r0
            int r0 = r3.A03
            long r2 = (long) r0
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 * r0
            com.facebook.ads.redexgen.X.qI r0 = r6.A05
            int r0 = r0.A0G
            long r0 = (long) r0
            long r2 = r2 / r0
            java.lang.String[] r4 = com.facebook.ads.redexgen.core.C2441lT.A0E
            r0 = 7
            r1 = r4[r0]
            r0 = 4
            r4 = r4[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            char r0 = r4.charAt(r0)
            if (r1 == r0) goto Lb0
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        Lb0:
            java.lang.String[] r4 = com.facebook.ads.redexgen.core.C2441lT.A0E
            java.lang.String r1 = "AWQIxDR1BxjJqdSwyyHMPwKr6xoKH6oB"
            r0 = 6
            r4[r0] = r1
            java.lang.String r1 = "F7eavifvP420Kso3ywMcgn0EXVt9uheB"
            r0 = 2
            r4[r0] = r1
            r6.A03 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2441lT.A01():void");
    }

    private boolean A03(C09724v c09724v) {
        int iA0I;
        while (true) {
            if (c09724v.A07() <= 0) {
                return false;
            }
            if (!this.A09) {
                this.A09 = c09724v.A0I() == 172;
            } else {
                iA0I = c09724v.A0I();
                this.A09 = iA0I == 172;
                if (iA0I == 64 || iA0I == 65) {
                    break;
                }
            }
        }
        this.A08 = iA0I == 65;
        return true;
    }

    private boolean A04(C09724v c09724v, byte[] bArr, int i) {
        int iMin = Math.min(c09724v.A07(), i - this.A00);
        int bytesToRead = this.A00;
        c09724v.A0k(bArr, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        return bytesToRead3 == i;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void A5A(C09724v c09724v) {
        AbstractC09493y.A02(this.A06);
        while (c09724v.A07() > 0) {
            switch (this.A02) {
                case 0:
                    if (A03(c09724v)) {
                        this.A02 = 1;
                        this.A0B.A0l()[0] = -84;
                        this.A0B.A0l()[1] = (byte) (this.A08 ? 65 : 64);
                        this.A00 = 2;
                    }
                    break;
                case 1:
                    if (A04(c09724v, this.A0B.A0l(), 16)) {
                        A01();
                        this.A0B.A0f(0);
                        this.A06.AIr(this.A0B, 16);
                        this.A02 = 2;
                    }
                    break;
                case 2:
                    int iMin = Math.min(c09724v.A07(), this.A01 - this.A00);
                    this.A06.AIr(c09724v, iMin);
                    int bytesToRead = this.A00;
                    this.A00 = bytesToRead + iMin;
                    int i = this.A00;
                    int bytesToRead2 = this.A01;
                    if (i != bytesToRead2) {
                        continue;
                    } else {
                        long j = this.A04;
                        String[] strArr = A0E;
                        String str = strArr[1];
                        String str2 = strArr[5];
                        int length = str.length();
                        int bytesToRead3 = str2.length();
                        if (length != bytesToRead3) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0E;
                        strArr2[7] = "IAM9NHxQABFG0hTE5bn7OXwICUUtPCRY";
                        strArr2[4] = "ryput7yIrWVq6mIAY3kQFQghClw5ei8P";
                        if (j != C.TIME_UNSET) {
                            this.A06.AIu(this.A04, 1, this.A01, 0, null);
                            this.A04 += this.A03;
                        }
                        this.A02 = 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A07 = lg.A04();
        this.A06 = ha.AKS(lg.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void AGq(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.A04 = j;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void AJ5() {
        this.A02 = 0;
        this.A00 = 0;
        this.A09 = false;
        this.A08 = false;
        this.A04 = C.TIME_UNSET;
    }
}
