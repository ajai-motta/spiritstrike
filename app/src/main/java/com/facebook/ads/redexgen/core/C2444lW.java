package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2444lW implements InterfaceC1367Kv {
    public static byte[] A0C;
    public static String[] A0D = {"zgZfEJGGgdHtew2g1FfNkkcnB", "zHXWmVVfspRqZTFEHweYGYwJXvEszQMx", "7abqffqd10TBp3FWdGN7VvMrN7O1UkYM", "p0MVW5l5", "JyEkXe6y14TztCHpc8kpfDGRXJv0nuKA", "euIGF7oBB7KZa", "ak0CBs2Ex4lMz9dSuXO", "PviIixxcvW6ZcpMh0sztGl9"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public C2725qI A05;
    public InterfaceC1272Hd A06;
    public String A07;
    public boolean A08;
    public final C09714u A09;
    public final C09724v A0A;
    public final String A0B;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{40, 60, 45, 32, 38, 102, 40, 42, 122};
    }

    static {
        A02();
    }

    public C2444lW() {
        this(null);
    }

    public C2444lW(String str) {
        this.A09 = new C09714u(new byte[128]);
        this.A0A = new C09724v(this.A09.A00);
        this.A02 = 0;
        this.A04 = C.TIME_UNSET;
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2444lW.A01():void");
    }

    private boolean A03(C09724v c09724v) {
        while (true) {
            if (c09724v.A07() <= 0) {
                return false;
            }
            boolean z = this.A08;
            if (A0D[3].length() != 8) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "9XFIg7618hJvvA4xETZzayJ4sl88kXfd";
            strArr[1] = "F6kFQyxnROPq81yNs7RnOkiGPjgAvEmB";
            if (!z) {
                this.A08 = c09724v.A0I() == 11;
            } else {
                int iA0I = c09724v.A0I();
                if (iA0I == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = iA0I == 11;
            }
        }
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
            int i = this.A02;
            String[] strArr = A0D;
            if (strArr[0].length() != strArr[5].length()) {
                String[] strArr2 = A0D;
                strArr2[0] = "xuhMWsLm7IhyfpFjlZpQdmw9F";
                strArr2[5] = "BOgMYXTSIypYk";
                switch (i) {
                    case 0:
                        if (A03(c09724v)) {
                            this.A02 = 1;
                            this.A0A.A0l()[0] = Ascii.VT;
                            this.A0A.A0l()[1] = 119;
                            this.A00 = 2;
                        }
                        break;
                    case 1:
                        if (A04(c09724v, this.A0A.A0l(), 128)) {
                            A01();
                            this.A0A.A0f(0);
                            this.A06.AIr(this.A0A, 128);
                            this.A02 = 2;
                        }
                        break;
                    case 2:
                        int iMin = Math.min(c09724v.A07(), this.A01 - this.A00);
                        this.A06.AIr(c09724v, iMin);
                        this.A00 += iMin;
                        if (this.A00 == this.A01) {
                            if (this.A04 != C.TIME_UNSET) {
                                this.A06.AIu(this.A04, 1, this.A01, 0, null);
                                this.A04 += this.A03;
                            }
                            this.A02 = 0;
                        }
                        break;
                }
            } else {
                throw new RuntimeException();
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
        this.A08 = false;
        this.A04 = C.TIME_UNSET;
    }
}
