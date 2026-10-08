package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L6 {
    public static byte[] A08;
    public static String[] A09 = {"voRQ6Eoiy", "dM5sUr3BWW4nkGo5nRVfbphD0FkiLgeI", "t4ngtozvUcRON5qFCPMw9NZHviWOcz8N", "2o", "HR4o0SgaegzvmEvMyBsSV3cy", "Fxd3YqblXENYapC", "iFe6DhKEBr1iW4qwRCto7Lk6hMgexe67", "drzzj9o5hc6Li6ZR2JGiBSJ"};
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final AnonymousClass53 A07 = new AnonymousClass53(0);
    public long A01 = C.TIME_UNSET;
    public long A02 = C.TIME_UNSET;
    public long A00 = C.TIME_UNSET;
    public final C09724v A06 = new C09724v();

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A08 = new byte[]{-19, -33, Ascii.DC4, 50, 40, 45, 38, -33, 19, 8, Ascii.FF, 4, Ascii.RS, Ascii.DC4, Ascii.CR, Ascii.DC2, 4, 19, -33, 40, 45, 50, 51, 36, 32, 35, -19, Ascii.DC2, 55, 63, 42, 53, 50, 45, -23, 45, 62, 59, 42, Base64.padSymbol, 50, 56, 55, 3, -23, Ascii.SYN, 57, 10, 59, 56, 39, 58, 47, 53, 52, Ascii.CAN, 43, 39, 42, 43, 56};
    }

    static {
        A09();
    }

    private int A00(InterfaceC2516ms interfaceC2516ms) {
        this.A06.A0i(C5C.A07);
        this.A03 = true;
        interfaceC2516ms.AIl();
        return 0;
    }

    private int A01(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        int iMin = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, interfaceC2516ms.A8O());
        if (interfaceC2516ms.A8n() != 0) {
            hv.A00 = 0;
            return 1;
        }
        C09724v c09724v = this.A06;
        int bytesToSearch = A09[6].length();
        if (bytesToSearch == 30) {
            throw new RuntimeException();
        }
        A09[6] = "JjjcAHcIe3bphcpehmdhx0lOvmd2";
        c09724v.A0d(iMin);
        interfaceC2516ms.AIl();
        interfaceC2516ms.AGt(this.A06.A0l(), 0, iMin);
        this.A01 = A04(this.A06);
        this.A04 = true;
        return 0;
    }

    private int A02(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        long jA8O = interfaceC2516ms.A8O();
        int iMin = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, jA8O);
        long j = jA8O - ((long) iMin);
        long searchStartPosition = interfaceC2516ms.A8n();
        if (searchStartPosition != j) {
            hv.A00 = j;
            return 1;
        }
        this.A06.A0d(iMin);
        interfaceC2516ms.AIl();
        interfaceC2516ms.AGt(this.A06.A0l(), 0, iMin);
        long inputLength = A05(this.A06);
        this.A02 = inputLength;
        this.A05 = true;
        return 0;
    }

    private int A03(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A04(com.facebook.ads.redexgen.core.C09724v r8) {
        /*
            r7 = this;
            int r6 = r8.A09()
            int r5 = r8.A0A()
        L8:
            int r0 = r5 + (-3)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= r0) goto L2e
            byte[] r0 = r8.A0l()
            int r1 = r7.A03(r0, r6)
            r0 = 442(0x1ba, float:6.2E-43)
            if (r1 != r0) goto L2b
            int r0 = r6 + 4
            r8.A0f(r0)
            long r1 = A06(r8)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 == 0) goto L2b
            return r1
        L2b:
            int r6 = r6 + 1
            goto L8
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.L6.A04(com.facebook.ads.redexgen.X.4v):long");
    }

    private long A05(C09724v c09724v) {
        int iA09 = c09724v.A09();
        int searchStartPosition = c09724v.A0A();
        for (int nextStartCode = searchStartPosition - 4; nextStartCode >= iA09; nextStartCode--) {
            int searchEndPosition = A03(c09724v.A0l(), nextStartCode);
            if (searchEndPosition == 442) {
                int searchStartPosition2 = nextStartCode + 4;
                c09724v.A0f(searchStartPosition2);
                long jA06 = A06(c09724v);
                int searchEndPosition2 = A09[1].charAt(26);
                if (searchEndPosition2 != 107) {
                    throw new RuntimeException();
                }
                A09[6] = "fZ";
                if (jA06 != C.TIME_UNSET) {
                    return jA06;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static long A06(C09724v c09724v) {
        int iA09 = c09724v.A09();
        if (c09724v.A07() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        int originalPosition = bArr.length;
        c09724v.A0k(bArr, 0, originalPosition);
        c09724v.A0f(iA09);
        return !A0A(bArr) ? C.TIME_UNSET : A07(bArr);
    }

    public static long A07(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public static boolean A0A(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public final int A0B(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        if (!this.A05) {
            return A02(interfaceC2516ms, hv);
        }
        if (this.A02 == C.TIME_UNSET) {
            return A00(interfaceC2516ms);
        }
        if (!this.A04) {
            return A01(interfaceC2516ms, hv);
        }
        if (this.A01 == C.TIME_UNSET) {
            return A00(interfaceC2516ms);
        }
        this.A00 = this.A07.A06(this.A02) - this.A07.A06(this.A01);
        if (this.A00 < 0) {
            AbstractC09574g.A07(A08(45, 16, 119), A08(27, 18, 122) + this.A00 + A08(0, 27, 112));
            this.A00 = C.TIME_UNSET;
        }
        return A00(interfaceC2516ms);
    }

    public final long A0C() {
        return this.A00;
    }

    public final AnonymousClass53 A0D() {
        return this.A07;
    }

    public final boolean A0E() {
        return this.A03;
    }
}
