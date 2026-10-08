package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JL {
    public static byte[] A03;
    public static String[] A04 = {"1LFyGIpszZgsQUUW5R18ay4ATJEAL43c", "dt6orGbglcsjMqs", "9FFDgagoC1", "foXErnBO9GEWWKnhx2CBLj59I1mQsasl", "8wc6iy8fDBcca8zNmQv", "", "jjxV28nHyp6my1wOvIi", "qfRjwVGa5Ot2KmC8yJE9Z4CCjcQdKZvd"};
    public static final C2402kp A05;
    public static final C2402kp A06;
    public int A01;
    public final List<JI> A02 = new ArrayList();
    public int A00 = 0;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 58);
            if (A04[0].charAt(18) != '1') {
                throw new RuntimeException();
            }
            A04[1] = "QzkInJPgctLD5w2";
            bArrCopyOfRange[i4] = b;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{45, 10, Ascii.DC2, 5, 8, Ascii.CR, 0, 68, 55, 33, 34, 68, 10, 5, 9, 1, 56, 7, 4, Ascii.FS, 38, 4, Ascii.US, 2, 4, 5, 52, 47, 10, Ascii.US, 10, 93, 123, 126, 107, 124, 81, 93, 98, 97, 121, 67, 97, 122, 103, 97, 96, 81, 76, 73, 67, 94, 120, 125, 104, 127, 82, 94, 97, 98, 122, SignedBytes.MAX_POWER_OF_TWO, 98, 121, 100, 98, 99, 82, 73, 108, 121, 108, 50, Ascii.DC4, 17, 4, 19, 62, 50, Ascii.CR, Ascii.SO, Ascii.SYN, 44, Ascii.SO, Ascii.NAK, 8, Ascii.SO, Ascii.SI, 62, 37, 4, 7, Ascii.CR, 8, 2, 10, 4, 19, 8, Ascii.SI, 6, 62, 46, Ascii.SI, 65, 103, 98, 119, 96, 77, 65, 126, 125, 101, 95, 125, 102, 123, 125, 124, 77, 87, 118, 123, 102, 77, 86, 115, 102, 115};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A06(InterfaceC2516ms interfaceC2516ms, List<Metadata.Entry> list) throws IOException {
        long jA8n = interfaceC2516ms.A8n();
        int iA8O = (int) ((interfaceC2516ms.A8O() - interfaceC2516ms.A8n()) - ((long) this.A01));
        C09724v c09724v = new C09724v(iA8O);
        interfaceC2516ms.readFully(c09724v.A0l(), 0, iA8O);
        for (int i = 0; i < this.A02.size(); i++) {
            JI ji = this.A02.get(i);
            c09724v.A0f((int) (ji.A02 - jA8n));
            c09724v.A0g(4);
            int iA0E = c09724v.A0E();
            String[] strArr = A04;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            A04[7] = "1HViS9NC9rn2qgqFvoB7LQiD1FLq6ChH";
            int iA00 = A00(c09724v.A0W(iA0E));
            int i2 = ji.A01 - (iA0E + 8);
            switch (iA00) {
                case 2192:
                    list.add(A01(c09724v, i2));
                    break;
                case 2816:
                case 2817:
                case 2819:
                case 2820:
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    static {
        A03();
        A06 = C2402kp.A02(AbstractJsonLexerKt.COLON);
        A05 = C2402kp.A02(GMTDateParser.ANY);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(java.lang.String r3) throws com.facebook.ads.redexgen.core.C3K {
        /*
            int r0 = r3.hashCode()
            switch(r0) {
                case -1711564334: goto L62;
                case -1332107749: goto L50;
                case -1251387154: goto L3e;
                case -830665521: goto L2c;
                case 1760745220: goto L1a;
                default: goto L7;
            }
        L7:
            r0 = -1
        L8:
            switch(r0) {
                case 0: goto L80;
                case 1: goto L7d;
                case 2: goto L7a;
                case 3: goto L77;
                case 4: goto L74;
                default: goto Lb;
            }
        Lb:
            r2 = 0
            r1 = 16
            r0 = 94
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 0
            com.facebook.ads.redexgen.X.3K r0 = com.facebook.ads.redexgen.core.C3K.A01(r1, r0)
            throw r0
        L1a:
            r2 = 31
            r1 = 20
            r0 = 52
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7
            r0 = 2
            goto L8
        L2c:
            r2 = 72
            r1 = 32
            r0 = 91
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7
            r0 = 4
            goto L8
        L3e:
            r2 = 51
            r1 = 21
            r0 = 55
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7
            r0 = 1
            goto L8
        L50:
            r2 = 104(0x68, float:1.46E-43)
            r1 = 26
            r0 = 40
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7
            r0 = 3
            goto L8
        L62:
            r2 = 16
            r1 = 15
            r0 = 81
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7
            r0 = 0
            goto L8
        L74:
            r0 = 2820(0xb04, float:3.952E-42)
            return r0
        L77:
            r0 = 2819(0xb03, float:3.95E-42)
            return r0
        L7a:
            r0 = 2817(0xb01, float:3.947E-42)
            return r0
        L7d:
            r0 = 2816(0xb00, float:3.946E-42)
            return r0
        L80:
            r0 = 2192(0x890, float:3.072E-42)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.JL.A00(java.lang.String):int");
    }

    public static SlowMotionData A01(C09724v c09724v, int i) throws C3K {
        List<SlowMotionData.Segment> segments = new ArrayList<>();
        String dataString = c09724v.A0W(i);
        List<String> listA06 = A05.A06(dataString);
        for (int i2 = 0; i2 < listA06.size(); i2++) {
            List<String> listA062 = A06.A06(listA06.get(i2));
            if (listA062.size() == 3) {
                try {
                    long j = Long.parseLong(listA062.get(0));
                    long startTimeMs = Long.parseLong(listA062.get(1));
                    segments.add(new SlowMotionData.Segment(j, startTimeMs, 1 << (Integer.parseInt(listA062.get(2)) - 1)));
                } catch (NumberFormatException e) {
                    throw C3K.A01(null, e);
                }
            } else {
                throw C3K.A01(null, null);
            }
        }
        return new SlowMotionData(segments);
    }

    private void A04(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        C09724v c09724v = new C09724v(8);
        interfaceC2516ms.readFully(c09724v.A0l(), 0, 8);
        this.A01 = c09724v.A0E() + 8;
        if (c09724v.A0C() != 1397048916) {
            hv.A00 = 0L;
        } else {
            hv.A00 = interfaceC2516ms.A8n() - ((long) (this.A01 - 12));
            this.A00 = 2;
        }
    }

    private void A05(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        long jA8O = interfaceC2516ms.A8O();
        int i = (this.A01 - 12) - 8;
        C09724v c09724v = new C09724v(i);
        interfaceC2516ms.readFully(c09724v.A0l(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            c09724v.A0g(2);
            int i3 = c09724v.A0a();
            switch (i3) {
                case 2192:
                case 2816:
                case 2817:
                case 2819:
                case 2820:
                    long streamLength = this.A01;
                    long j = jA8O - streamLength;
                    long streamLength2 = c09724v.A0E();
                    int size = c09724v.A0E();
                    this.A02.add(new JI(i3, j - streamLength2, size));
                    break;
                default:
                    c09724v.A0g(8);
                    break;
            }
        }
        if (this.A02.isEmpty()) {
            hv.A00 = 0L;
            return;
        }
        this.A00 = 3;
        long streamLength3 = this.A02.get(0).A02;
        hv.A00 = streamLength3;
    }

    public final int A07(InterfaceC2516ms interfaceC2516ms, HV hv, List<Metadata.Entry> slowMotionMetadataEntries) throws IOException {
        long j = 0;
        switch (this.A00) {
            case 0:
                long jA8O = interfaceC2516ms.A8O();
                if (jA8O != -1 && jA8O >= 8) {
                    j = jA8O - 8;
                }
                hv.A00 = j;
                this.A00 = 1;
                return 1;
            case 1:
                A04(interfaceC2516ms, hv);
                return 1;
            case 2:
                A05(interfaceC2516ms, hv);
                return 1;
            case 3:
                A06(interfaceC2516ms, slowMotionMetadataEntries);
                hv.A00 = 0L;
                return 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final void A08() {
        this.A02.clear();
        this.A00 = 0;
    }
}
