package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.flac.PictureFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1279Hk {
    public static byte[] A00;
    public static String[] A01 = {"AQUfun8uWtpAPz6T54JXA8DVdz19i7cg", "A9xQ060X7I53O0IPhfx7pChTdPn89BVs", "HA6OUY8aFXslM4giueBriDg2S", "9RrkKnX7ioGd8UIKmUAG7ayOJ1mW6fCZ", "mjtW7HF4JFIVQBQAuWhSkP1cuiqQ", "mMlJtFouJ3Md3SAWQWV0HJ1iYftjtiDS", "", "7UUPgjEseHhf3IW21ENlLsXr9tr9mert"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C1278Hj A06(C09724v c09724v) throws C3K {
        A0C(1, c09724v, false);
        int iA0F = c09724v.A0F();
        int iA0I = c09724v.A0I();
        int iA0F2 = c09724v.A0F();
        int iA0E = c09724v.A0E();
        if (iA0E <= 0) {
            iA0E = -1;
        }
        int iA0E2 = c09724v.A0E();
        if (iA0E2 <= 0) {
            iA0E2 = -1;
        }
        int iA0E3 = c09724v.A0E();
        if (iA0E3 <= 0) {
            iA0E3 = -1;
            String[] strArr = A01;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "";
            strArr2[4] = "hx6vx8O5nOwfxHxHuzSsxOXMbdPf";
        }
        int iA0I2 = c09724v.A0I();
        return new C1278Hj(iA0F, iA0I, iA0F2, iA0E, iA0E2, iA0E3, (int) Math.pow(2.0d, iA0I2 & 15), (int) Math.pow(2.0d, (iA0I2 & PsExtractor.VIDEO_STREAM_MASK) >> 4), (c09724v.A0I() & 1) > 0, Arrays.copyOf(c09724v.A0l(), c09724v.A0A()));
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{107, Ascii.EM, 62, 54, 51, 58, 59, 127, 43, 48, 127, 47, 62, 45, 44, 58, 127, 9, 48, 45, Base64.padSymbol, 54, 44, 127, 60, 48, 50, 50, 58, 49, 43, 101, 127, 40, Ascii.SI, 7, 2, Ascii.VT, 10, 78, Ascii.SUB, 1, 78, Ascii.RS, Ascii.SI, Ascii.FS, Ascii.GS, Ascii.VT, 78, Ascii.CAN, 1, Ascii.FS, Ascii.FF, 7, Ascii.GS, 78, Ascii.RS, 7, Ascii.CR, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.VT, 118, 126, 111, 122, 127, 122, 111, 122, 100, 121, 119, 116, 120, 112, 100, 107, 114, 120, 111, 110, 105, 126, 62, 7, Ascii.SUB, 10, 1, Ascii.ESC, Base64.padSymbol, Ascii.FS, 1, 4, 58, 39, 47, 58, 60, 43, 58, 59, 127, 60, 55, 62, 45, 62, 60, 43, 58, 45, 44, 127, 120, 41, 48, 45, Base64.padSymbol, 54, 44, 120, SignedBytes.MAX_POWER_OF_TWO, 93, 85, SignedBytes.MAX_POWER_OF_TWO, 70, 81, SignedBytes.MAX_POWER_OF_TWO, 65, 5, 70, 74, 65, SignedBytes.MAX_POWER_OF_TWO, 5, 71, 74, 74, 78, 5, 81, 74, 5, 86, 81, 68, 87, 81, 5, 82, 76, 81, 77, 5, 126, Ascii.NAK, 93, Ascii.DLE, 19, 9, 5, Ascii.NAK, 93, 17, Ascii.SYN, 9, 5, Ascii.NAK, 93, 17, Ascii.ETB, 120, 5, 68, 81, 5, 62, 35, 43, 62, 56, 47, 62, 63, 123, 51, 62, 58, 63, 62, 41, 123, 47, 34, 43, 62, 123, 107, 97, 98, 98, 127, 45, 121, 116, 125, 104, 45, 106, 127, 104, 108, 121, 104, 127, 45, 121, 101, 108, 99, 45, 60, 45, 99, 98, 121, 45, 105, 104, 110, 98, 105, 108, 111, 97, 104, 55, 45, 97, 117, 102, 106, 110, 105, 96, 39, 101, 110, 115, 39, 102, 97, 115, 98, 117, 39, 106, 104, 99, 98, 116, 39, 105, 104, 115, 39, 116, 98, 115, 39, 102, 116, 39, 98, 127, 119, 98, 100, 115, 98, 99, 38, 50, 33, 45, 41, 46, 39, 96, 34, 41, 52, 96, 37, 56, 48, 37, 35, 52, 37, 36, 96, 52, 47, 96, 34, 37, 96, 51, 37, 52, 2, 1, 1, 5, Ascii.ESC, Ascii.RS, 78, Ascii.SUB, Ascii.ETB, Ascii.RS, Ascii.VT, 78, 9, Ascii.FS, Ascii.VT, Ascii.SI, Ascii.SUB, Ascii.VT, Ascii.FS, 78, Ascii.SUB, 6, Ascii.SI, 0, 78, 92, 78, 0, 1, Ascii.SUB, 78, 10, Ascii.VT, Ascii.CR, 1, 10, Ascii.SI, Ascii.FF, 2, Ascii.VT, 84, 78, 56, 52, 37, 37, 60, 59, 50, 117, 33, 44, 37, 48, 117, 58, 33, Base64.padSymbol, 48, 39, 117, 33, Base64.padSymbol, 52, 59, 117, 101, 117, 59, 58, 33, 117, 38, 32, 37, 37, 58, 39, 33, 48, 49, 111, 117, 108, 112, 125, 127, 121, 116, 115, 112, 120, 121, 110, 60, 115, 122, 60, 104, 117, 113, 121, 60, 120, 115, 113, 125, 117, 114, 60, 104, 110, 125, 114, 111, 122, 115, 110, 113, 111, 60, 114, 115, 104, 60, 102, 121, 110, 115, 121, 120, 60, 115, 105, 104, SignedBytes.MAX_POWER_OF_TWO, 87, 65, 91, 86, 71, 87, 102, 75, 66, 87, Ascii.DC2, 85, SignedBytes.MAX_POWER_OF_TWO, 87, 83, 70, 87, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 70, 90, 83, 92, Ascii.DC2, 0, Ascii.DC2, 91, 65, Ascii.DC2, 92, 93, 70, Ascii.DC2, 86, 87, 81, 93, 86, 83, 80, 94, 87, 93, 70, 9, 91, 76, 90, 76, 91, 95, 76, 77, 9, 75, SignedBytes.MAX_POWER_OF_TWO, 93, 90, 9, 68, 92, 90, 93, 9, 75, 76, 9, 83, 76, 91, 70, 9, 72, 79, 93, 76, 91, 9, 68, 72, 89, 89, SignedBytes.MAX_POWER_OF_TWO, 71, 78, 9, 74, 70, 92, 89, 69, SignedBytes.MAX_POWER_OF_TWO, 71, 78, 9, 90, 93, 76, 89, 90, Ascii.DLE, Ascii.VT, Ascii.VT, 68, Ascii.ETB, Ascii.FF, Ascii.VT, Ascii.SYN, Ascii.DLE, 68, Ascii.FF, 1, 5, 0, 1, Ascii.SYN, 94, 68};
    }

    static {
        A08();
    }

    public static int A00(int i) {
        int val = 0;
        while (i > 0) {
            val++;
            i >>>= 1;
        }
        return val;
    }

    public static long A01(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static Metadata A02(List<String> list) {
        List<String> vorbisComments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrA1P = C5C.A1P(str, A07(0, 1, 56));
            int length = strArrA1P.length;
            String strA07 = A07(85, 10, 6);
            if (length != 2) {
                AbstractC09574g.A07(strA07, A07(1, 32, 49) + str);
            } else {
                String[] strArr = A01;
                String str2 = strArr[6];
                String str3 = strArr[4];
                int i2 = str2.length();
                if (i2 == str3.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[6] = "";
                strArr2[4] = "IFt3u6Tbn0k1mtPtGSJYRwNJh6dv";
                if (strArrA1P[0].equals(A07(63, 22, 85))) {
                    try {
                        vorbisComments.add(PictureFrame.A00(new C09724v(android.util.Base64.decode(strArrA1P[1], 0))));
                    } catch (RuntimeException e) {
                        AbstractC09574g.A0A(strA07, A07(33, 30, 0), e);
                    }
                } else {
                    vorbisComments.add(new VorbisComment(strArrA1P[0], strArrA1P[1]));
                }
            }
        }
        if (vorbisComments.isEmpty()) {
            return null;
        }
        return new Metadata(vorbisComments);
    }

    /* JADX WARN: Incorrect condition in loop: B:25:0x009f */
    /* JADX WARN: Incorrect condition in loop: B:8:0x0026 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C1275Hg A03(com.facebook.ads.redexgen.core.C1274Hf r15) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1279Hk.A03(com.facebook.ads.redexgen.X.Hf):com.facebook.ads.redexgen.X.Hg");
    }

    public static C1276Hh A04(C09724v c09724v) throws C3K {
        return A05(c09724v, true, true);
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x0025 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C1276Hh A05(com.facebook.ads.redexgen.core.C09724v r9, boolean r10, boolean r11) throws com.facebook.ads.redexgen.core.C3K {
        /*
            if (r10 == 0) goto L7
            r1 = 3
            r0 = 0
            A0C(r1, r9, r0)
        L7:
            r3 = 7
            long r1 = r9.A0O()
            int r0 = (int) r1
            int r3 = r3 + 4
            java.lang.String r6 = r9.A0W(r0)
            int r0 = r6.length()
            int r3 = r3 + r0
            long r1 = r9.A0O()
            int r0 = (int) r1
            java.lang.String[] r5 = new java.lang.String[r0]
            int r7 = r3 + 4
            r8 = 0
        L22:
            long r3 = (long) r8
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3e
            long r3 = r9.A0O()
            int r0 = (int) r3
            int r7 = r7 + 4
            java.lang.String r0 = r9.A0W(r0)
            r5[r8] = r0
            r0 = r5[r8]
            int r0 = r0.length()
            int r7 = r7 + r0
            int r8 = r8 + 1
            goto L22
        L3e:
            if (r11 == 0) goto L48
            int r0 = r9.A0I()
            r0 = r0 & 1
            if (r0 == 0) goto L50
        L48:
            int r1 = r7 + 1
            com.facebook.ads.redexgen.X.Hh r0 = new com.facebook.ads.redexgen.X.Hh
            r0.<init>(r6, r5, r1)
            return r0
        L50:
            r2 = 283(0x11b, float:3.97E-43)
            r1 = 30
            r0 = 46
            java.lang.String r1 = A07(r2, r1, r0)
            r0 = 0
            com.facebook.ads.redexgen.X.3K r0 = com.facebook.ads.redexgen.core.C3K.A01(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1279Hk.A05(com.facebook.ads.redexgen.X.4v, boolean, boolean):com.facebook.ads.redexgen.X.Hh");
    }

    public static void A09(int i, C1274Hf c1274Hf) throws C3K {
        int i2;
        int iA02 = c1274Hf.A02(6) + 1;
        for (int i3 = 0; i3 < iA02; i3++) {
            int iA022 = c1274Hf.A02(16);
            if (iA022 != 0) {
                AbstractC09574g.A05(A07(85, 10, 6), A07(355, 41, 59) + iA022);
            } else {
                if (c1274Hf.A04()) {
                    int iA023 = c1274Hf.A02(4);
                    String[] strArr = A01;
                    String str = strArr[7];
                    String str2 = strArr[0];
                    int iCharAt = str.charAt(2);
                    int mappingsCount = str2.charAt(2);
                    if (iCharAt != mappingsCount) {
                        throw new RuntimeException();
                    }
                    A01[5] = "MSIFAaOSOQQOpmu0PO7aKrLsJb3QFagu";
                    i2 = iA023 + 1;
                } else {
                    i2 = 1;
                }
                if (c1274Hf.A04()) {
                    int i4 = c1274Hf.A02(8);
                    int i5 = i4 + 1;
                    for (int i6 = 0; i6 < i5; i6++) {
                        int mappingsCount2 = i - 1;
                        c1274Hf.A03(A00(mappingsCount2));
                        int mappingsCount3 = i - 1;
                        c1274Hf.A03(A00(mappingsCount3));
                    }
                }
                int mappingsCount4 = c1274Hf.A02(2);
                if (mappingsCount4 == 0) {
                    if (i2 > 1) {
                        for (int mappingsCount5 = 0; mappingsCount5 < i; mappingsCount5++) {
                            c1274Hf.A03(4);
                        }
                    }
                    for (int i7 = 0; i7 < i2; i7++) {
                        c1274Hf.A03(8);
                        String[] strArr2 = A01;
                        String str3 = strArr2[6];
                        String str4 = strArr2[4];
                        int length = str3.length();
                        int mappingsCount6 = str4.length();
                        if (length == mappingsCount6) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A01;
                        strArr3[3] = "W7H2tgam7pgMqyIqKZRQoufJib3tzvKG";
                        strArr3[1] = "g3J7gwvZXejdWYIpZtqDt0lnx57dRd6J";
                        c1274Hf.A03(8);
                        c1274Hf.A03(8);
                    }
                } else {
                    throw C3K.A01(A07(491, 58, 71), null);
                }
            }
        }
    }

    public static void A0A(C1274Hf c1274Hf) throws C3K {
        int iA02 = c1274Hf.A02(6) + 1;
        for (int i = 0; i < iA02; i++) {
            int iA022 = c1274Hf.A02(16);
            switch (iA022) {
                case 0:
                    c1274Hf.A03(8);
                    c1274Hf.A03(16);
                    c1274Hf.A03(16);
                    String[] strArr = A01;
                    String str = strArr[6];
                    String str2 = strArr[4];
                    int floorCount = str.length();
                    if (floorCount == str2.length()) {
                        throw new RuntimeException();
                    }
                    A01[2] = "puZWVQ2pTjmoQkTRd3XFOd7V6";
                    c1274Hf.A03(6);
                    c1274Hf.A03(8);
                    int iA023 = c1274Hf.A02(4) + 1;
                    for (int floorCount2 = 0; floorCount2 < iA023; floorCount2++) {
                        c1274Hf.A03(8);
                    }
                    break;
                    break;
                case 1:
                    int j = c1274Hf.A02(5);
                    int i2 = -1;
                    int[] partitionClassList = new int[j];
                    for (int floorCount3 = 0; floorCount3 < j; floorCount3++) {
                        partitionClassList[floorCount3] = c1274Hf.A02(4);
                        if (partitionClassList[floorCount3] > i2) {
                            i2 = partitionClassList[floorCount3];
                        }
                    }
                    int[] iArr = new int[i2 + 1];
                    for (int j2 = 0; j2 < iArr.length; j2++) {
                        iArr[j2] = c1274Hf.A02(3) + 1;
                        int iA024 = c1274Hf.A02(2);
                        if (iA024 > 0) {
                            c1274Hf.A03(8);
                        }
                        for (int floorCount4 = 0; floorCount4 < (1 << iA024); floorCount4++) {
                            c1274Hf.A03(8);
                        }
                    }
                    c1274Hf.A03(2);
                    int k = c1274Hf.A02(4);
                    int j3 = 0;
                    int rangeBits = 0;
                    for (int count = 0; count < j; count++) {
                        int idx = partitionClassList[count];
                        String[] strArr2 = A01;
                        String str3 = strArr2[7];
                        String str4 = strArr2[0];
                        int floorCount5 = str3.charAt(2);
                        if (floorCount5 != str4.charAt(2)) {
                            throw new RuntimeException();
                        }
                        A01[5] = "4gRGDU2vGyXCYhT5FVmyq5RWvUvygEh7";
                        j3 += iArr[idx];
                        while (rangeBits < j3) {
                            c1274Hf.A03(k);
                            rangeBits++;
                        }
                    }
                    break;
                default:
                    throw C3K.A01(A07(199, 41, 99) + iA022, null);
            }
        }
    }

    public static void A0B(C1274Hf c1274Hf) throws C3K {
        int iA02 = c1274Hf.A02(6) + 1;
        for (int i = 0; i < iA02; i++) {
            int residueCount = c1274Hf.A02(16);
            if (residueCount <= 2) {
                c1274Hf.A03(24);
                c1274Hf.A03(24);
                c1274Hf.A03(24);
                int iA022 = c1274Hf.A02(6) + 1;
                c1274Hf.A03(8);
                int[] iArr = new int[iA022];
                for (int i2 = 0; i2 < iA022; i2++) {
                    int residueCount2 = 0;
                    int iA023 = c1274Hf.A02(3);
                    if (c1274Hf.A04()) {
                        String[] strArr = A01;
                        String str = strArr[7];
                        String str2 = strArr[0];
                        int residueCount3 = str.charAt(2);
                        if (residueCount3 != str2.charAt(2)) {
                            throw new RuntimeException();
                        }
                        A01[5] = "QebxPehykfYMwUhUEUOD533arJF7pEEp";
                        residueCount2 = c1274Hf.A02(5);
                    }
                    iArr[i2] = (residueCount2 * 8) + iA023;
                }
                for (int i3 = 0; i3 < iA022; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        int residueCount4 = iArr[i3];
                        if ((residueCount4 & (1 << i4)) != 0) {
                            c1274Hf.A03(8);
                        }
                    }
                }
            } else {
                throw C3K.A01(A07(448, 43, 92), null);
            }
        }
    }

    public static boolean A0C(int i, C09724v c09724v, boolean z) throws C3K {
        if (c09724v.A07() < 7) {
            if (z) {
                return false;
            }
            throw C3K.A01(A07(549, 18, 10) + c09724v.A07(), null);
        }
        if (c09724v.A0I() != i) {
            if (z) {
                return false;
            }
            throw C3K.A01(A07(178, 21, 53) + Integer.toHexString(i), null);
        }
        if (c09724v.A0I() != 118 || c09724v.A0I() != 111 || c09724v.A0I() != 114 || c09724v.A0I() != 98 || c09724v.A0I() != 105 || c09724v.A0I() != 115) {
            if (z) {
                return false;
            }
            throw C3K.A01(A07(95, 28, 49), null);
        }
        return true;
    }

    public static C1277Hi[] A0D(C09724v c09724v, int i) throws C3K {
        A0C(5, c09724v, false);
        int iA0I = c09724v.A0I() + 1;
        C1274Hf c1274Hf = new C1274Hf(c09724v.A0l());
        int numberOfBooks = c09724v.A09();
        c1274Hf.A03(numberOfBooks * 8);
        for (int numberOfBooks2 = 0; numberOfBooks2 < iA0I; numberOfBooks2++) {
            A03(c1274Hf);
        }
        int numberOfBooks3 = c1274Hf.A02(6);
        int timeCount = numberOfBooks3 + 1;
        for (int i2 = 0; i2 < timeCount; i2++) {
            int numberOfBooks4 = c1274Hf.A02(16);
            if (numberOfBooks4 != 0) {
                throw C3K.A01(A07(396, 52, 114), null);
            }
        }
        A0A(c1274Hf);
        A0B(c1274Hf);
        A09(i, c1274Hf);
        C1277Hi[] c1277HiArrA0E = A0E(c1274Hf);
        if (c1274Hf.A04()) {
            return c1277HiArrA0E;
        }
        throw C3K.A01(A07(PsExtractor.VIDEO_STREAM_MASK, 43, 105), null);
    }

    public static C1277Hi[] A0E(C1274Hf c1274Hf) {
        int iA02 = c1274Hf.A02(6) + 1;
        C1277Hi[] c1277HiArr = new C1277Hi[iA02];
        for (int windowType = 0; windowType < iA02; windowType++) {
            boolean zA04 = c1274Hf.A04();
            int iA022 = c1274Hf.A02(16);
            int i = c1274Hf.A02(16);
            c1277HiArr[windowType] = new C1277Hi(zA04, iA022, i, c1274Hf.A02(8));
        }
        return c1277HiArr;
    }
}
