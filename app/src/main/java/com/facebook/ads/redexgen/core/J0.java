package com.facebook.ads.redexgen.core;

import android.util.Pair;
import androidx.compose.runtime.ComposerKt;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MdtaMetadataEntry;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class J0 {
    public static byte[] A00;
    public static String[] A01 = {"3VpIAtFn", "NjWxo0tcAFilzYXB2gd1dub2S4KYfC0G", "7dc9OwNzjfbA4WDbGdH3UDrd", "kTLJpOKA", "odl5U202HvuloegJiYsgd2o0Bsn6ktlS", "Tqd8q9EAW1nxLdrfn3G624yWy86zlBE3", "GM6CYLF4x47fKf9mrP144TBtf3lMkKEe", "FJhXpGWKImafMZTrlZrsHtUKnb1aBvQ9"};
    public static final byte[] A02;

    @MetaExoPlayerCustomization("Needed for oculus customization")
    public static final int[] A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.androidx.media3.common.ColorInfo A0B(com.facebook.ads.redexgen.core.C09724v r10) {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A0B(com.facebook.ads.redexgen.X.4v):com.facebook.ads.androidx.media3.common.ColorInfo");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Metadata A0F(C2488mE c2488mE) {
        C2487mD c2487mDA07 = c2488mE.A07(Atom.TYPE_hdlr);
        C2487mD c2487mDA072 = c2488mE.A07(Atom.TYPE_keys);
        C2487mD c2487mDA073 = c2488mE.A07(Atom.TYPE_ilst);
        if (c2487mDA07 == null || c2487mDA072 == null || c2487mDA073 == null || A03(c2487mDA07.A00) != 1835299937) {
            return null;
        }
        C09724v c09724v = c2487mDA072.A00;
        c09724v.A0f(12);
        int iA0C = c09724v.A0C();
        String[] strArr = new String[iA0C];
        for (int i = 0; i < iA0C; i++) {
            int iA0C2 = c09724v.A0C();
            c09724v.A0g(4);
            strArr[i] = c09724v.A0W(iA0C2 - 8);
        }
        C09724v c09724v2 = c2487mDA073.A00;
        c09724v2.A0f(8);
        ArrayList arrayList = new ArrayList();
        while (c09724v2.A07() > 8) {
            int iA09 = c09724v2.A09();
            int iA0C3 = c09724v2.A0C();
            int iA0C4 = c09724v2.A0C() - 1;
            if (iA0C4 < 0 || iA0C4 >= strArr.length) {
                AbstractC09574g.A07(A0M(178, 11, 68), A0M(359, 41, 107) + iA0C4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryA09 = JB.A09(c09724v2, iA09 + iA0C3, strArr[iA0C4]);
                if (mdtaMetadataEntryA09 != null) {
                    arrayList.add(mdtaMetadataEntryA09);
                }
            }
            c09724v2.A0f(iA09 + iA0C3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1316Iw A0G(C09724v c09724v, int i) {
        c09724v.A0f(i + 8 + 4);
        c09724v.A0g(1);
        A02(c09724v);
        c09724v.A0g(2);
        int iA0I = c09724v.A0I();
        if ((iA0I & 128) != 0) {
            c09724v.A0g(2);
        }
        if ((iA0I & 64) != 0) {
            c09724v.A0g(c09724v.A0I());
        }
        if ((iA0I & 32) != 0) {
            c09724v.A0g(2);
        }
        c09724v.A0g(1);
        A02(c09724v);
        String strA05 = C3J.A05(c09724v.A0I());
        if (A0M(947, 10, 17).equals(strA05) || A0M(989, 13, 117).equals(strA05) || A0M(1002, 16, 39).equals(strA05)) {
            return new C1316Iw(strA05, null, -1L, -1L);
        }
        c09724v.A0g(4);
        long jA0Q = c09724v.A0Q();
        long jA0Q2 = c09724v.A0Q();
        c09724v.A0g(1);
        int iA02 = A02(c09724v);
        byte[] bArr = new byte[iA02];
        c09724v.A0k(bArr, 0, iA02);
        if (jA0Q2 <= 0) {
            jA0Q2 = -1;
        }
        if (jA0Q <= 0) {
            jA0Q = -1;
        }
        return new C1316Iw(strA05, bArr, jA0Q2, jA0Q);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1319Iz A0I(C09724v c09724v) {
        long jA0Q;
        c09724v.A0f(8);
        int iA01 = AbstractC1314Iu.A01(c09724v.A0C());
        c09724v.A0g(iA01 == 0 ? 8 : 16);
        int iA0C = c09724v.A0C();
        c09724v.A0g(4);
        boolean z = true;
        int iA09 = c09724v.A09();
        int i = iA01 == 0 ? 4 : 8;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (c09724v.A0l()[iA09 + i2] != -1) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            c09724v.A0g(i);
            jA0Q = C.TIME_UNSET;
        } else {
            jA0Q = iA01 == 0 ? c09724v.A0Q() : c09724v.A0R();
            if (jA0Q == 0) {
                jA0Q = C.TIME_UNSET;
            }
        }
        c09724v.A0g(16);
        int iA0C2 = c09724v.A0C();
        int iA0C3 = c09724v.A0C();
        c09724v.A0g(4);
        int iA0C4 = c09724v.A0C();
        int iA0C5 = c09724v.A0C();
        return new C1319Iz(iA0C, jA0Q, (iA0C2 == 0 && iA0C3 == 65536 && iA0C4 == (-65536) && iA0C5 == 0) ? 90 : (iA0C2 == 0 && iA0C3 == (-65536) && iA0C4 == 65536 && iA0C5 == 0) ? 270 : (iA0C2 == (-65536) && iA0C3 == 0 && iA0C4 == 0 && iA0C5 == (-65536)) ? 180 : 0);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static JO A0J(C2488mE c2488mE, C2487mD c2487mD, long j, DrmInitData drmInitData, boolean z, boolean z2) throws C3K {
        C2488mE c2488mEA06;
        long j2 = j;
        C2488mE c2488mE2 = (C2488mE) AbstractC09493y.A01(c2488mE.A06(Atom.TYPE_mdia));
        int iA01 = A01(A03(((C2487mD) AbstractC09493y.A01(c2488mE2.A07(Atom.TYPE_hdlr))).A00));
        if (iA01 == -1) {
            return null;
        }
        C1319Iz c1319IzA0I = A0I(((C2487mD) AbstractC09493y.A01(c2488mE.A07(Atom.TYPE_tkhd))).A00);
        if (j2 == C.TIME_UNSET) {
            j2 = c1319IzA0I.A02;
        }
        long jA05 = A05(c2487mD.A00);
        long jA0U = j2 == C.TIME_UNSET ? C.TIME_UNSET : C5C.A0U(j2, 1000000L, jA05);
        C2488mE c2488mE3 = (C2488mE) AbstractC09493y.A01(((C2488mE) AbstractC09493y.A01(c2488mE2.A06(Atom.TYPE_minf))).A06(Atom.TYPE_stbl));
        Pair<Long, String> pairA06 = A06(((C2487mD) AbstractC09493y.A01(c2488mE2.A07(Atom.TYPE_mdhd))).A00);
        C2487mD c2487mDA07 = c2488mE3.A07(Atom.TYPE_stsd);
        if (c2487mDA07 == null) {
            throw C3K.A01(A0M(288, 63, 20), null);
        }
        C1318Iy c1318IyA0H = A0H(c2487mDA07.A00, c1319IzA0I.A00, c1319IzA0I.A01, (String) pairA06.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z && (c2488mEA06 = c2488mE.A06(Atom.TYPE_edts)) != null) {
            Pair<long[], long[]> pairA09 = A09(c2488mEA06);
            String[] strArr = A01;
            if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "IbqpVMf9BLmnuF5BFBlg7Wi48qFbo4Yh";
            strArr2[4] = "amD11xiy90bj3UvdeHvItss5MLCDKaRi";
            if (pairA09 != null) {
                jArr = (long[]) pairA09.first;
                jArr2 = (long[]) pairA09.second;
            }
        }
        if (c1318IyA0H.A02 == null) {
            return null;
        }
        return new JO(c1319IzA0I.A00, iA01, ((Long) pairA06.first).longValue(), jA05, jA0U, c1318IyA0H.A02, c1318IyA0H.A01, c1318IyA0H.A03, c1318IyA0H.A00, jArr, jArr2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JP A0K(C09724v c09724v, int i, int i2, String str) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c09724v.A0f(i3);
            int iA0C = c09724v.A0C();
            if (c09724v.A0C() == 1952804451) {
                int iA01 = AbstractC1314Iu.A01(c09724v.A0C());
                c09724v.A0g(1);
                int i4 = 0;
                int i5 = 0;
                if (iA01 == 0) {
                    c09724v.A0g(1);
                } else {
                    int iA0I = c09724v.A0I();
                    i4 = (iA0I & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                    i5 = iA0I & 15;
                }
                boolean z = c09724v.A0I() == 1;
                int iA0I2 = c09724v.A0I();
                byte[] bArr = new byte[16];
                c09724v.A0k(bArr, 0, bArr.length);
                byte[] bArr2 = null;
                if (z && iA0I2 == 0) {
                    int iA0I3 = c09724v.A0I();
                    bArr2 = new byte[iA0I3];
                    c09724v.A0k(bArr2, 0, iA0I3);
                }
                return new JP(z, str, iA0I2, bArr, i4, i5, bArr2);
            }
            i3 += iA0C;
        }
        return null;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static JR A0L(JO jo, C2488mE c2488mE, HK hk) throws C3K {
        InterfaceC1317Ix c2485mB;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        String strA0M;
        long j;
        JO jo2;
        String strA0M2;
        long[] jArr;
        int i;
        int[] iArr;
        C2487mD c2487mDA07 = c2488mE.A07(Atom.TYPE_stsz);
        if (c2487mDA07 != null) {
            c2485mB = new C2486mC(c2487mDA07, jo.A07);
        } else {
            C2487mD c2487mDA072 = c2488mE.A07(Atom.TYPE_stz2);
            if (c2487mDA072 == null) {
                throw C3K.A01(A0M(400, 42, 111), null);
            }
            c2485mB = new C2485mB(c2487mDA072);
        }
        int iA8v = c2485mB.A8v();
        String[] strArr = A01;
        if (strArr[7].charAt(30) != strArr[4].charAt(30)) {
            A01[5] = "VWWx1kGHZbX2q2PAsWKgJgHWMUDi0u3b";
            if (iA8v == 0) {
                return new JR(jo, new long[0], new int[0], 0, new long[0], new int[0], 0L);
            }
            boolean z = false;
            C2487mD c2487mDA073 = c2488mE.A07(Atom.TYPE_stco);
            if (c2487mDA073 == null) {
                z = true;
                c2487mDA073 = (C2487mD) AbstractC09493y.A01(c2488mE.A07(Atom.TYPE_co64));
            }
            C09724v c09724v = c2487mDA073.A00;
            C09724v c09724v2 = ((C2487mD) AbstractC09493y.A01(c2488mE.A07(Atom.TYPE_stsc))).A00;
            C09724v c09724v3 = ((C2487mD) AbstractC09493y.A01(c2488mE.A07(Atom.TYPE_stts))).A00;
            C2487mD c2487mDA074 = c2488mE.A07(Atom.TYPE_stss);
            C09724v c09724v4 = c2487mDA074 != null ? c2487mDA074.A00 : null;
            C2487mD c2487mDA075 = c2488mE.A07(Atom.TYPE_ctts);
            C09724v c09724v5 = c2487mDA075 != null ? c2487mDA075.A00 : null;
            C1315Iv c1315Iv = new C1315Iv(c09724v2, c09724v, z);
            c09724v3.A0f(12);
            int iA0L = c09724v3.A0L() - 1;
            int iA0L2 = c09724v3.A0L();
            int iA0L3 = c09724v3.A0L();
            int iA0L4 = 0;
            int iA0L5 = 0;
            int iA0C = 0;
            if (c09724v5 != null) {
                c09724v5.A0f(12);
                iA0L5 = c09724v5.A0L();
            }
            int iA0L6 = -1;
            int iA0L7 = 0;
            if (c09724v4 != null) {
                c09724v4.A0f(12);
                iA0L7 = c09724v4.A0L();
                if (iA0L7 > 0) {
                    iA0L6 = c09724v4.A0L() - 1;
                } else {
                    c09724v4 = null;
                }
            }
            int iA8A = c2485mB.A8A();
            String str = jo.A07.A0W;
            int i2 = 0;
            long j2 = 0;
            if (iA8A != -1 && (A0M(967, 9, 94).equals(str) || A0M(897, 15, 77).equals(str) || A0M(882, 15, 96).equals(str)) && iA0L == 0 && iA0L5 == 0 && iA0L7 == 0) {
                long[] jArr2 = new long[c1315Iv.A05];
                String[] strArr2 = A01;
                if (strArr2[1].charAt(26) != strArr2[6].charAt(26)) {
                    A01[2] = "it49YraTc1fDpxLwGLRBh0ec";
                    iArr = new int[c1315Iv.A05];
                } else {
                    String[] strArr3 = A01;
                    strArr3[0] = "cQxifTbk";
                    strArr3[3] = "kvbBtLxb";
                    iArr = new int[c1315Iv.A05];
                }
                while (c1315Iv.A02()) {
                    jArr2[c1315Iv.A00] = c1315Iv.A02;
                    iArr[c1315Iv.A00] = c1315Iv.A01;
                }
                J3 j3A00 = J4.A00(iA8A, jArr2, iArr, iA0L3);
                jArrCopyOf = j3A00.A04;
                iArrCopyOf = j3A00.A03;
                i2 = j3A00.A00;
                jArrCopyOf2 = j3A00.A05;
                iArrCopyOf2 = j3A00.A02;
                j = j3A00.A01;
                jo2 = jo;
            } else {
                jArrCopyOf = new long[iA8v];
                iArrCopyOf = new int[iA8v];
                jArrCopyOf2 = new long[iA8v];
                iArrCopyOf2 = new int[iA8v];
                long j3 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    strA0M = A0M(178, 11, 68);
                    if (i4 >= iA8v) {
                        i4 = iA8v;
                        break;
                    }
                    boolean zA02 = true;
                    while (i3 == 0) {
                        zA02 = c1315Iv.A02();
                        if (!zA02) {
                            break;
                        }
                        if (A01[5].charAt(23) != 'W') {
                            throw new RuntimeException();
                        }
                        A01[5] = "M5jbBIfsv36G8eW66Ax72viWGVpCEb4z";
                        j3 = c1315Iv.A02;
                        i3 = c1315Iv.A01;
                    }
                    if (!zA02) {
                        AbstractC09574g.A07(strA0M, A0M(442, 28, 94));
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i4);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i4);
                        break;
                    }
                    if (c09724v5 != null) {
                        while (iA0L4 == 0 && iA0L5 > 0) {
                            iA0L4 = c09724v5.A0L();
                            iA0C = c09724v5.A0C();
                            iA0L5--;
                        }
                        iA0L4--;
                    }
                    jArrCopyOf[i4] = j3;
                    iArrCopyOf[i4] = c2485mB.AHS();
                    if (iArrCopyOf[i4] > i2) {
                        i2 = iArrCopyOf[i4];
                    }
                    jArrCopyOf2[i4] = j2 + ((long) iA0C);
                    iArrCopyOf2[i4] = c09724v4 == null ? 1 : 0;
                    if (i4 == iA0L6) {
                        iArrCopyOf2[i4] = 1;
                        iA0L7--;
                        if (iA0L7 > 0) {
                            iA0L6 = ((C09724v) AbstractC09493y.A01(c09724v4)).A0L() - 1;
                        }
                    }
                    j2 += (long) iA0L3;
                    iA0L2--;
                    if (iA0L2 == 0 && iA0L > 0) {
                        iA0L2 = c09724v3.A0L();
                        iA0L3 = c09724v3.A0C();
                        iA0L--;
                    }
                    j3 += (long) iArrCopyOf[i4];
                    i3--;
                    i4++;
                }
                j = j2 + ((long) iA0C);
                boolean z2 = true;
                if (c09724v5 != null) {
                    while (true) {
                        if (iA0L5 <= 0) {
                            break;
                        }
                        if (c09724v5.A0L() != 0) {
                            z2 = false;
                            break;
                        }
                        c09724v5.A0C();
                        iA0L5--;
                    }
                }
                if (iA0L7 == 0 && iA0L2 == 0 && i3 == 0 && iA0L == 0 && iA0L4 == 0 && z2) {
                    jo2 = jo;
                } else {
                    jo2 = jo;
                    StringBuilder sbAppend = new StringBuilder().append(A0M(ComposerKt.reuseKey, 32, 24)).append(jo2.A00).append(A0M(144, 34, 36)).append(iA0L7).append(A0M(14, 35, 65)).append(iA0L2).append(A0M(85, 26, 14)).append(i3).append(A0M(111, 33, 41)).append(iA0L).append(A0M(49, 36, 31)).append(iA0L4);
                    if (!z2) {
                        strA0M2 = A0M(0, 14, 12);
                    } else if (A01[5].charAt(23) != 'W') {
                        strA0M2 = A0M(0, 0, 93);
                    } else {
                        String[] strArr4 = A01;
                        strArr4[7] = "aaylILcGBS6VDtnpev9y5b4BJZBYR2y3";
                        strArr4[4] = "0XgNPN0ZQsO4pNqGOHtpLFxyHM4aJjFv";
                        strA0M2 = A0M(0, 0, 93);
                    }
                    AbstractC09574g.A07(strA0M, sbAppend.append(strA0M2).toString());
                }
                iA8v = i4;
            }
            long j4 = jo2.A06;
            if (A01[2].length() == 24) {
                String[] strArr5 = A01;
                strArr5[7] = "ipyvZTOv07cYtbuH1DKg84aCsuigBUI1";
                strArr5[4] = "ch7TyunNM6oXEfHdpbs8btnx2NdPJSj4";
                long jA0U = C5C.A0U(j, 1000000L, j4);
                if (jo2.A08 == null) {
                    C5C.A13(jArrCopyOf2, 1000000L, jo2.A06);
                    return new JR(jo, jArrCopyOf, iArrCopyOf, i2, jArrCopyOf2, iArrCopyOf2, jA0U);
                }
                if (jo2.A08.length == 1 && jo2.A03 == 1 && jArrCopyOf2.length >= 2) {
                    long j5 = ((long[]) AbstractC09493y.A01(jo2.A09))[0];
                    long jA0U2 = j5 + C5C.A0U(jo2.A08[0], jo2.A06, jo2.A05);
                    jArrCopyOf2 = jArrCopyOf2;
                    if (A0V(jArrCopyOf2, j, j5, jA0U2)) {
                        long jA0U3 = C5C.A0U(j5 - jArrCopyOf2[0], jo2.A07.A0G, jo2.A06);
                        long jA0U4 = C5C.A0U(j - jA0U2, jo2.A07.A0G, jo2.A06);
                        if ((jA0U3 != 0 || jA0U4 != 0) && jA0U3 <= 2147483647L && jA0U4 <= 2147483647L) {
                            hk.A00 = (int) jA0U3;
                            hk.A01 = (int) jA0U4;
                            C5C.A13(jArrCopyOf2, 1000000L, jo2.A06);
                            return new JR(jo, jArrCopyOf, iArrCopyOf, i2, jArrCopyOf2, iArrCopyOf2, C5C.A0U(jo2.A08[0], 1000000L, jo2.A05));
                        }
                    }
                }
                if (jo2.A08.length == 1 && jo2.A08[0] == 0) {
                    long j6 = ((long[]) AbstractC09493y.A01(jo2.A09))[0];
                    for (int i5 = 0; i5 < jArrCopyOf2.length; i5++) {
                        jArrCopyOf2[i5] = C5C.A0U(jArrCopyOf2[i5] - j6, 1000000L, jo2.A06);
                    }
                    return new JR(jo, jArrCopyOf, iArrCopyOf, i2, jArrCopyOf2, iArrCopyOf2, C5C.A0U(j - j6, 1000000L, jo2.A06));
                }
                boolean z3 = jo2.A03 == 1;
                int i6 = 0;
                int i7 = 0;
                boolean z4 = false;
                int[] iArr2 = new int[jo2.A08.length];
                int[] iArr3 = new int[jo2.A08.length];
                long[] jArr3 = jo2.A09;
                if (A01[5].charAt(23) != 'W') {
                    jArr = (long[]) AbstractC09493y.A01(jArr3);
                    i = 0;
                } else {
                    String[] strArr6 = A01;
                    strArr6[0] = "YPXXFbwg";
                    strArr6[3] = "nX0rcUWc";
                    jArr = (long[]) AbstractC09493y.A01(jArr3);
                    i = 0;
                }
                while (true) {
                    if (i < jo2.A08.length) {
                        long j7 = jArr[i];
                        if (j7 != -1) {
                            long jA0U5 = C5C.A0U(jo2.A08[i], jo2.A06, jo2.A05);
                            iArr2[i] = C5C.A0L(jArrCopyOf2, j7, true, true);
                            iArr3[i] = C5C.A0K(jArrCopyOf2, j7 + jA0U5, z3, false);
                            while (iArr2[i] < iArr3[i] && (iArrCopyOf2[iArr2[i]] & 1) == 0) {
                                iArr2[i] = iArr2[i] + 1;
                            }
                            i6 += iArr3[i] - iArr2[i];
                            String[] strArr7 = A01;
                            if (strArr7[1].charAt(26) == strArr7[6].charAt(26)) {
                                break;
                            }
                            String[] strArr8 = A01;
                            strArr8[0] = "N8MUiUXq";
                            strArr8[3] = "O0bSFd8k";
                            z4 |= i7 != iArr2[i];
                            i7 = iArr3[i];
                        }
                        i++;
                    } else {
                        boolean z5 = z4 | (i6 != iA8v);
                        long[] jArr4 = z5 ? new long[i6] : jArrCopyOf;
                        int[] iArr4 = z5 ? new int[i6] : iArrCopyOf;
                        if (z5) {
                            i2 = 0;
                        }
                        String[] strArr9 = A01;
                        if (strArr9[7].charAt(30) != strArr9[4].charAt(30)) {
                            A01[5] = "xPfk6NQdScK777382m5CuwBWtM3rjqH6";
                            int[] iArr5 = z5 ? new int[i6] : iArrCopyOf2;
                            long[] jArr5 = new long[i6];
                            long j8 = 0;
                            int i8 = 0;
                            for (int i9 = 0; i9 < jo2.A08.length; i9++) {
                                long j9 = jo2.A09[i9];
                                int i10 = iArr2[i9];
                                int i11 = iArr3[i9];
                                if (z5) {
                                    int i12 = i11 - i10;
                                    System.arraycopy(jArrCopyOf, i10, jArr4, i8, i12);
                                    System.arraycopy(iArrCopyOf, i10, iArr4, i8, i12);
                                    System.arraycopy(iArrCopyOf2, i10, iArr5, i8, i12);
                                } else if (A01[5].charAt(23) != 'W') {
                                    A01[2] = "bpFLG5yiCjaNBTatiJL832yJ";
                                } else {
                                    String[] strArr10 = A01;
                                    strArr10[0] = "uU6cy1oD";
                                    strArr10[3] = "C1luViVj";
                                }
                                while (i10 < i11) {
                                    jArr5[i8] = C5C.A0U(j8, 1000000L, jo2.A05) + C5C.A0U(Math.max(0L, jArrCopyOf2[i10] - j9), 1000000L, jo2.A06);
                                    if (z5 && iArr4[i8] > i2) {
                                        i2 = iArrCopyOf[i10];
                                    }
                                    i8++;
                                    i10++;
                                }
                                j8 += jo2.A08[i9];
                            }
                            return new JR(jo, jArr4, iArr4, i2, jArr5, iArr5, C5C.A0U(j8, 1000000L, jo2.A05));
                        }
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    public static String A0M(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A00 = new byte[]{70, 74, 9, Ascii.RS, Ascii.RS, Ascii.EM, 74, 3, 4, Ascii.FS, Ascii.VT, 6, 3, Ascii.SO, Ascii.VT, 7, 85, 66, 74, 70, 78, 73, 78, 73, SignedBytes.MAX_POWER_OF_TWO, 116, 70, 74, 87, 75, 66, 84, 102, 83, 115, 78, 74, 66, 84, 83, 70, 74, 87, 99, 66, 75, 83, 70, 7, 85, 89, Ascii.VT, Ascii.FS, Ascii.DC4, Ascii.CAN, Ascii.DLE, Ascii.ETB, Ascii.DLE, Ascii.ETB, Ascii.RS, 42, Ascii.CAN, Ascii.DC4, 9, Ascii.NAK, Ascii.FS, 10, 56, Ascii.CR, 45, Ascii.DLE, Ascii.DC4, Ascii.FS, 10, Ascii.CR, Ascii.CAN, Ascii.DC4, 9, 54, Ascii.US, Ascii.US, 10, Ascii.FS, Ascii.CR, 89, 68, 72, Ascii.SUB, Ascii.CR, 5, 9, 1, 6, 1, 6, Ascii.SI, 59, 9, 5, Ascii.CAN, 4, Ascii.CR, Ascii.ESC, 33, 6, 43, 0, Ascii.GS, 6, 3, 72, 99, 111, Base64.padSymbol, 42, 34, 46, 38, 33, 38, 33, 40, Ascii.ESC, 38, 34, 42, 60, 59, 46, 34, 63, Ascii.VT, 42, 35, 59, 46, Ascii.FF, 39, 46, 33, 40, 42, 60, 111, 120, 98, 48, 39, 47, 35, 43, 44, 43, 44, 37, 17, 59, 44, 33, 42, 48, 45, 44, 43, 56, 35, 54, 43, 45, 44, 17, 35, 47, 50, 46, 39, 49, 98, 99, 86, 77, 79, 114, 67, 80, 81, 71, 80, 81, Ascii.RS, 35, 56, 62, 40, 40, 50, 45, 62, 123, 52, 57, 46, 4, 40, 50, 33, 62, 55, Ascii.DLE, Ascii.GS, 17, Ascii.DLE, Ascii.CR, Ascii.ETB, Ascii.CR, 10, Ascii.ESC, Ascii.DLE, 10, 94, Ascii.CR, 10, Ascii.FS, Ascii.DC2, 94, Ascii.FS, 17, 6, 94, Ascii.CAN, 17, Ascii.FF, 94, 10, Ascii.FF, Ascii.US, Ascii.GS, Ascii.NAK, 94, 8, 47, 55, 32, 45, 40, 37, 97, 50, 32, 44, 49, 45, 36, 97, 51, 32, 53, 36, 97, 39, 46, 51, 97, 5, 46, 45, 35, 56, 97, Ascii.NAK, 51, 52, 36, 9, 5, 97, Ascii.FF, Ascii.CR, 17, 97, 50, 53, 51, 36, 32, 44, 123, 97, 63, 19, Ascii.RS, Ascii.DC4, Ascii.GS, 0, Ascii.US, Ascii.ETB, Ascii.SYN, 82, 1, 19, Ascii.US, 2, Ascii.RS, Ascii.ETB, 82, 6, 19, Ascii.DLE, Ascii.RS, Ascii.ETB, 82, 90, 1, 6, Ascii.DLE, Ascii.RS, 91, 82, Ascii.US, Ascii.ESC, 1, 1, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, 1, 19, Ascii.US, 2, Ascii.RS, Ascii.ETB, 82, Ascii.SYN, Ascii.ETB, 1, 17, 0, Ascii.ESC, 2, 6, Ascii.ESC, Ascii.GS, Ascii.FS, 82, 90, 1, 6, 1, Ascii.SYN, 91, 33, Ascii.RS, Ascii.ESC, Ascii.GS, 38, Ascii.VT, Ascii.SI, 10, 94, 102, 100, 125, 125, 104, 105, 45, 96, 104, 121, 108, 105, 108, 121, 108, 45, 122, 100, 121, 101, 45, 120, 99, 102, 99, 98, 122, 99, 45, 102, 104, 116, 45, 100, 99, 105, 104, 117, 55, 45, 93, 123, 104, 106, 98, 41, 97, 104, 122, 41, 103, 102, 41, 122, 104, 100, 121, 101, 108, 41, 125, 104, 107, 101, 108, 41, 122, 96, 115, 108, 41, 96, 103, 111, 102, 123, 100, 104, 125, 96, 102, 103, 109, 86, 93, SignedBytes.MAX_POWER_OF_TWO, 72, 93, 91, 76, 93, 92, Ascii.CAN, 93, 86, 92, Ascii.CAN, 87, 94, Ascii.CAN, 91, 80, 77, 86, 83, Ascii.CAN, 92, 89, 76, 89, 90, 97, 124, 122, 127, 127, 96, 125, 123, 106, 107, 47, 108, 96, 99, 96, 125, 47, 123, 118, 127, 106, 53, 47, 72, 115, 110, 104, 109, 109, 114, 111, 105, 120, 121, Base64.padSymbol, 116, 115, 116, 105, 116, 124, 113, 66, 121, 116, 110, 109, 113, 124, 100, 66, 121, 120, 113, 124, 100, 66, 109, 111, 120, 110, 120, 115, 105, 66, 123, 113, 124, 122, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, Ascii.FS, 81, 89, 88, 85, 93, Ascii.FS, 78, 93, 72, 89, Ascii.DC2, Ascii.EM, 34, 63, 57, 60, 60, 35, 62, 56, 41, 40, 108, 35, 46, 57, 19, 41, 52, 56, 41, 34, 63, 37, 35, 34, 19, 42, 32, 45, 43, 100, 95, 66, 68, 65, 65, 94, 67, 69, 84, 85, 17, 94, 83, 68, 110, 69, 72, 65, 84, Ascii.VT, 17, 83, 104, 117, 115, 118, 118, 105, 116, 114, 99, 98, 38, 116, 99, 98, 115, 101, 99, 98, 89, 117, 114, 111, 106, 106, 89, 118, 111, 101, 114, 115, 116, 99, 89, 110, 99, 103, 98, 99, 116, 52, Ascii.SI, Ascii.DC2, Ascii.DC4, 17, 17, Ascii.SO, 19, Ascii.NAK, 4, 5, 65, Ascii.NAK, 8, Ascii.FF, 8, Ascii.SI, 6, 62, 8, Ascii.SI, 7, Ascii.SO, 62, 17, 19, 4, Ascii.DC2, 4, Ascii.SI, Ascii.NAK, 62, 7, Ascii.CR, 0, 6, 96, 113, 113, 109, 104, 98, 96, 117, 104, 110, 111, 46, 117, 117, 108, 109, 42, 121, 108, 109, 33, 48, 48, 44, 41, 35, 33, 52, 41, 47, 46, 111, 56, 109, 35, 33, 45, 37, 50, 33, 109, 45, 47, 52, 41, 47, 46, 78, 95, 95, 67, 70, 76, 78, 91, 70, SignedBytes.MAX_POWER_OF_TWO, 65, 0, 87, 2, 66, 95, Ascii.ESC, 2, 76, 74, 78, 2, Ascii.EM, Ascii.US, Ascii.ETB, 95, 78, 78, 82, 87, 93, 95, 74, 87, 81, 80, 17, 70, 19, 83, 78, 10, 19, 72, 74, 74, Base64.padSymbol, 44, 44, 48, 53, 63, Base64.padSymbol, 40, 53, 51, 50, 115, 36, 113, 45, 41, 53, 63, 55, 40, 53, 49, 57, 113, 40, 36, 111, 59, 80, 68, 85, 88, 94, Ascii.RS, 2, 86, 65, 65, 58, 46, 63, 50, 52, 116, 58, 56, 104, 42, 62, 47, 34, 36, 100, 42, 40, 127, 46, 58, 43, 38, 32, 96, 46, 35, 46, 44, 34, 54, 39, 42, 44, 108, 34, 46, 49, 110, 52, 33, 77, 89, 72, 69, 67, 3, 73, 77, 79, Ascii.US, 3, Ascii.ETB, 6, Ascii.VT, Ascii.CR, 77, 4, Ascii.SO, 3, 1, 103, 115, 98, 111, 105, 41, 97, 49, 55, 55, 43, 103, 106, 103, 113, 74, 94, 79, 66, 68, 4, 76, Ascii.FS, Ascii.SUB, Ascii.SUB, 6, 70, 71, 74, 92, 34, 54, 39, 42, 44, 108, 46, 43, 34, 114, Ascii.ETB, 3, Ascii.DC2, Ascii.US, Ascii.EM, 89, Ascii.ESC, Ascii.RS, Ascii.ESC, 71, 96, 116, 101, 104, 110, 46, 108, 113, 53, 96, 44, 109, 96, 117, 108, Ascii.SYN, 2, 19, Ascii.RS, Ascii.CAN, 88, Ascii.SUB, 7, Ascii.DC2, Ascii.DLE, 68, 80, 65, 76, 74, 10, 74, 85, 80, 86, 89, 77, 92, 81, 87, Ascii.ETB, 74, 89, 79, 74, 94, 79, 66, 68, 4, 95, 89, 94, 78, 6, 67, 79, 114, 102, 119, 122, 124, 60, 101, 125, 119, Base64.padSymbol, 119, 
        103, 96, 32, 52, 37, 40, 46, 110, 55, 47, 37, 111, 37, 53, 50, 111, 41, 37, 68, 80, 65, 76, 74, 10, 83, 75, 65, Ascii.VT, 65, 81, 86, Ascii.VT, 77, 65, Ascii.RS, 85, 87, 74, 67, 76, 73, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, 73, 71, 87, 88, 76, 93, 80, 86, Ascii.SYN, 79, 87, 93, Ascii.ETB, 93, 77, 74, Ascii.ETB, 76, 81, 93, 2, 73, 75, 86, 95, 80, 85, 92, 4, 73, Ascii.VT, 54, 55, 54, 100, 87, 86, 87, 71, 79, 73, 66, 79, 50, 52, 63, 34, 74, 65, SignedBytes.MAX_POWER_OF_TWO, 69, 77, 104, 93, 70, 68, 122, SignedBytes.MAX_POWER_OF_TWO, 83, 76, 9, 68, 92, 90, 93, 9, 75, 76, 9, 89, 70, 90, SignedBytes.MAX_POWER_OF_TWO, 93, SignedBytes.MAX_POWER_OF_TWO, 95, 76, 49, 37, 58, 54, 119, 54, 35, 56, 58, 119, 62, 36, 119, 58, 54, 57, 51, 54, 35, 56, 37, 46, 59, 43, 32, 33, 104, 41, 60, 39, 37, 104, 33, 59, 104, 37, 41, 38, 44, 41, 60, 39, 58, 49, Ascii.SI, Ascii.RS, Ascii.NAK, Ascii.CAN, 91, Ascii.SUB, Ascii.SI, Ascii.DC4, Ascii.SYN, 91, Ascii.DC2, 8, 91, Ascii.SYN, Ascii.SUB, Ascii.NAK, Ascii.US, Ascii.SUB, Ascii.SI, Ascii.DC4, 9, 2, 5, Ascii.SUB, Ascii.ETB, Ascii.SYN, Ascii.FS, 92, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 3, 3, 67, 92, 81, 80, 90, Ascii.SUB, 84, 67, 5, 4, 35, 60, 49, 48, 58, 122, 52, 35, 54, 72, 87, 90, 91, 81, 17, 90, 81, 82, 92, 71, 19, 72, 87, 77, 87, 81, 80, 68, 91, 86, 87, 93, Ascii.GS, 90, 87, 68, 81, Ascii.SUB, 5, 8, 9, 3, 67, 1, Ascii.FS, 9, Ascii.VT, 95, SignedBytes.MAX_POWER_OF_TWO, 77, 76, 70, 6, 81, 4, 95, 71, 77, 7, 70, 71, Ascii.ESC, 7, 95, 89, 17, 3, Ascii.FS, 17, Ascii.DLE, Ascii.SUB, 90, Ascii.CR, 88, 3, Ascii.ESC, 17, 91, Ascii.SUB, Ascii.ESC, 71, 91, 3, 5, 76};
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
    
        if (r6 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
    
        r3 = new com.facebook.ads.redexgen.core.C09162p().A0g(r37).A11(r6).A0w(r13).A0r(r29).A0f(r28).A0Y(r27).A0l(r38).A13(r26).A0o(r11).A12(r12).A0u(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
    
        if (r8 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f2, code lost:
    
        if (r5 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
    
        if (r7 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f6, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f9, code lost:
    
        if (r4 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fb, code lost:
    
        r4 = r4.array();
        r2 = com.facebook.ads.redexgen.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0111, code lost:
    
        if (r2[7].charAt(30) == r2[4].charAt(30)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0113, code lost:
    
        r2 = com.facebook.ads.redexgen.core.J0.A01;
        r2[1] = "iNSGYMD2WjZqNKpCGRiE11Ag0KcZMJ4O";
        r2[6] = "kUdBVFFCHZ7OFsLW60c88KXDOWnZQcPh";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011f, code lost:
    
        r3.A0t(new com.facebook.ads.androidx.media3.common.ColorInfo(r8, r5, r7, r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0127, code lost:
    
        if (r17 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0129, code lost:
    
        r3.A0a(com.facebook.ads.redexgen.core.AbstractC1109As.A03(r17.A00)).A0j(com.facebook.ads.redexgen.core.AbstractC1109As.A03(r17.A01));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0140, code lost:
    
        r40.A02 = r3.A14();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0148, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0149, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b6 A[PHI: r2
  0x01b6: PHI (r2v12 int) = (r2v11 int), (r2v56 int) binds: [B:58:0x01b3, B:48:0x0171] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0284  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Adding Colorspace support for AV1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0R(com.facebook.ads.redexgen.core.C09724v r33, int r34, int r35, int r36, int r37, int r38, com.facebook.ads.androidx.media3.common.DrmInitData r39, com.facebook.ads.redexgen.core.C1318Iy r40, int r41) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 1228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A0R(com.facebook.ads.redexgen.X.4v, int, int, int, int, int, com.facebook.ads.androidx.media3.common.DrmInitData, com.facebook.ads.redexgen.X.Iy, int):void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0T(com.facebook.ads.redexgen.core.C09724v r19, int r20, int r21, int r22, int r23, java.lang.String r24, boolean r25, com.facebook.ads.androidx.media3.common.DrmInitData r26, com.facebook.ads.redexgen.core.C1318Iy r27, int r28) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 1455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A0T(com.facebook.ads.redexgen.X.4v, int, int, int, int, java.lang.String, boolean, com.facebook.ads.androidx.media3.common.DrmInitData, com.facebook.ads.redexgen.X.Iy, int):void");
    }

    static {
        A0P();
        A03 = new int[]{-3374493, -128628077, -2011932550, 38936541};
        A02 = C5C.A1G(A0M(351, 8, 8));
    }

    public static float A00(C09724v c09724v, int i) {
        c09724v.A0f(i + 8);
        int vSpacing = c09724v.A0L();
        int hSpacing = c09724v.A0L();
        return vSpacing / hSpacing;
    }

    public static int A01(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "Iy7m3jJh";
        strArr2[3] = "9tkcHcc8";
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        if (i == 1835365473) {
            return 5;
        }
        return -1;
    }

    public static int A02(C09724v c09724v) {
        int iA0I = c09724v.A0I();
        int i = iA0I & 127;
        while (true) {
            int i2 = iA0I & 128;
            String[] strArr = A01;
            String str = strArr[7];
            String str2 = strArr[4];
            int size = str.charAt(30);
            int currentByte = str2.charAt(30);
            if (size == currentByte) {
                throw new RuntimeException();
            }
            A01[5] = "pSNibJ1kKp1RE21akOqiyNuWX3n84SWQ";
            if (i2 == 128) {
                iA0I = c09724v.A0I();
                int i3 = i << 7;
                String[] strArr2 = A01;
                String str3 = strArr2[0];
                String str4 = strArr2[3];
                int size2 = str3.length();
                int currentByte2 = str4.length();
                if (size2 != currentByte2) {
                    String[] strArr3 = A01;
                    strArr3[0] = "dUXzi2Ex";
                    strArr3[3] = "FqHw8aws";
                    int currentByte3 = iA0I & 127;
                    i = i3 | currentByte3;
                } else {
                    A01[2] = "53iEjHDa99dBpQfClHLnj3Lr";
                    int currentByte4 = iA0I & 127;
                    i = i3 | currentByte4;
                }
            } else {
                return i;
            }
        }
    }

    public static int A03(C09724v c09724v) {
        c09724v.A0f(16);
        return c09724v.A0C();
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A04(com.facebook.ads.redexgen.core.C09724v r7, int r8, int r9, int r10) throws com.facebook.ads.redexgen.core.C3K {
        /*
            int r3 = r7.A09()
            if (r3 < r9) goto L52
            r1 = 1
        L7:
            r0 = 0
            com.facebook.ads.redexgen.core.HB.A01(r1, r0)
        Lb:
            int r0 = r3 - r9
            if (r0 >= r10) goto L54
            r7.A0f(r3)
            int r6 = r7.A0C()
            if (r6 <= 0) goto L50
            r4 = 1
        L19:
            r5 = 1090(0x442, float:1.527E-42)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.J0.A01
            r0 = 5
            r1 = r1[r0]
            r0 = 23
            char r1 = r1.charAt(r0)
            r0 = 87
            if (r1 == r0) goto L30
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L30:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "6gtDIh58mAlo0zqgdjwPUqi1ndJRBK82"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "DRBAnAjKoyJp6qnYv3HHxzBKoLLYYD5q"
            r0 = 4
            r2[r0] = r1
            r1 = 30
            r0 = 79
            java.lang.String r0 = A0M(r5, r1, r0)
            com.facebook.ads.redexgen.core.HB.A01(r4, r0)
            int r0 = r7.A0C()
            if (r0 != r8) goto L4e
            return r3
        L4e:
            int r3 = r3 + r6
            goto Lb
        L50:
            r4 = 0
            goto L19
        L52:
            r1 = 0
            goto L7
        L54:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A04(com.facebook.ads.redexgen.X.4v, int, int, int):int");
    }

    public static long A05(C09724v c09724v) {
        int fullAtom = 8;
        c09724v.A0f(8);
        if (AbstractC1314Iu.A01(c09724v.A0C()) != 0) {
            fullAtom = 16;
        }
        c09724v.A0g(fullAtom);
        return c09724v.A0Q();
    }

    public static Pair<Long, String> A06(C09724v c09724v) {
        c09724v.A0f(8);
        int fullAtom = AbstractC1314Iu.A01(c09724v.A0C());
        int languageCode = fullAtom == 0 ? 8 : 16;
        c09724v.A0g(languageCode);
        long jA0Q = c09724v.A0Q();
        int version = fullAtom == 0 ? 4 : 8;
        c09724v.A0g(version);
        int iA0M = c09724v.A0M();
        int languageCode2 = iA0M >> 10;
        StringBuilder sbAppend = new StringBuilder().append(A0M(0, 0, 93)).append((char) ((languageCode2 & 31) + 96));
        int languageCode3 = iA0M >> 5;
        StringBuilder sbAppend2 = sbAppend.append((char) ((languageCode3 & 31) + 96));
        int languageCode4 = iA0M & 31;
        return Pair.create(Long.valueOf(jA0Q), sbAppend2.append((char) (languageCode4 + 96)).toString());
    }

    public static Pair<Integer, JP> A07(C09724v c09724v, int i, int i2) throws C3K {
        int i3 = i + 8;
        int childAtomType = -1;
        int childAtomSize = 0;
        String strA0W = null;
        Integer numValueOf = null;
        while (true) {
            int childPosition = i3 - i;
            if (childPosition < i2) {
                c09724v.A0f(i3);
                int iA0C = c09724v.A0C();
                int iA0C2 = c09724v.A0C();
                int schemeInformationBoxPosition = A01[2].length();
                if (schemeInformationBoxPosition != 24) {
                    break;
                }
                String[] strArr = A01;
                strArr[0] = "312zVnav";
                strArr[3] = "fwhHyPzp";
                if (iA0C2 == 1718775137) {
                    int childPosition2 = c09724v.A0C();
                    numValueOf = Integer.valueOf(childPosition2);
                } else if (iA0C2 == 1935894637) {
                    c09724v.A0g(4);
                    strA0W = c09724v.A0W(4);
                } else if (iA0C2 == 1935894633) {
                    childAtomType = i3;
                    childAtomSize = iA0C;
                }
                i3 += iA0C;
            } else {
                int schemeInformationBoxPosition2 = A01[2].length();
                if (schemeInformationBoxPosition2 == 24) {
                    A01[5] = "Q2dt9svTwucQVjxlQtJloRQWafbIItZ7";
                    if (A0M(1082, 4, 74).equals(strA0W) || A0M(1074, 4, 51).equals(strA0W) || A0M(1086, 4, 55).equals(strA0W) || A0M(1078, 4, 82).equals(strA0W)) {
                        boolean z = true;
                        HB.A01(numValueOf != null, A0M(1120, 22, 49));
                        HB.A01(childAtomType != -1, A0M(1142, 22, 46));
                        JP jpA0K = A0K(c09724v, childAtomType, childAtomSize, strA0W);
                        if (jpA0K == null) {
                            z = false;
                        }
                        HB.A01(z, A0M(1164, 22, 29));
                        return Pair.create(numValueOf, (JP) C5C.A0f(jpA0K));
                    }
                    return null;
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050 A[PHI: r0
  0x0050: PHI (r0v16 'childPosition' int) = (r0v13 'childPosition' int), (r0v19 'childPosition' int) binds: [B:20:0x007e, B:12:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[PHI: r0
  0x0081: PHI (r0v14 'childPosition' int) = (r0v13 'childPosition' int), (r0v19 'childPosition' int) binds: [B:20:0x007e, B:12:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, com.facebook.ads.redexgen.core.JP> A08(com.facebook.ads.redexgen.core.C09724v r6, int r7, int r8) throws com.facebook.ads.redexgen.core.C3K {
        /*
            int r3 = r6.A09()
        L4:
            int r4 = r3 - r7
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            r0 = 0
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L1e
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "alPn9WvAmZr8sIghV9sZ4SJG"
            r0 = 2
            r2[r0] = r1
            if (r4 >= r8) goto L85
            r6.A0f(r3)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            r0 = 1
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L6e
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "bSC6gQO3"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "sEisHoVo"
            r0 = 3
            r2[r0] = r1
            int r0 = r6.A0C()
            if (r0 <= 0) goto L81
        L50:
            r5 = 1
        L51:
            r4 = 1090(0x442, float:1.527E-42)
            r2 = 30
            r1 = 79
            java.lang.String r1 = A0M(r4, r2, r1)
            com.facebook.ads.redexgen.core.HB.A01(r5, r1)
            int r2 = r6.A0C()
            r1 = 1936289382(0x73696e66, float:1.8494329E31)
            if (r2 != r1) goto L83
            android.util.Pair r1 = A07(r6, r3, r0)
            if (r1 == 0) goto L83
            return r1
        L6e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "sCQufaVXehZdAx160HDrkvqq2FYTSg6V"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "xgFgm7GbjtAXUGsxujgneuzUGgVoDuJS"
            r0 = 6
            r2[r0] = r1
            int r0 = r6.A0C()
            if (r0 <= 0) goto L81
            goto L50
        L81:
            r5 = 0
            goto L51
        L83:
            int r3 = r3 + r0
            goto L4
        L85:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A08(com.facebook.ads.redexgen.X.4v, int, int):android.util.Pair");
    }

    public static Pair<long[], long[]> A09(C2488mE c2488mE) {
        long jA0P;
        C2487mD elstAtom = c2488mE.A07(Atom.TYPE_elst);
        if (elstAtom == null) {
            return null;
        }
        C09724v c09724v = elstAtom.A00;
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "nlx0JEXKjNTNdSyjBy8qhdzuridSUNe7";
        strArr2[4] = "QPF9oPdHODxNb0EXvgymvar5stnTE0Tg";
        c09724v.A0f(8);
        int version = AbstractC1314Iu.A01(c09724v.A0C());
        int fullAtom = c09724v.A0L();
        long[] jArr = new long[fullAtom];
        long[] jArr2 = new long[fullAtom];
        for (int i = 0; i < fullAtom; i++) {
            jArr[i] = version == 1 ? c09724v.A0R() : c09724v.A0Q();
            if (version == 1) {
                jA0P = c09724v.A0P();
            } else {
                int entryCount = c09724v.A0C();
                jA0P = entryCount;
            }
            jArr2[i] = jA0P;
            int entryCount2 = c09724v.A0b();
            if (entryCount2 == 1) {
                c09724v.A0g(2);
            } else {
                throw new IllegalArgumentException(A0M(540, 23, 90));
            }
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair<Metadata, Metadata> A0A(C2487mD c2487mD) {
        C09724v c09724v = c2487mD.A00;
        c09724v.A0f(8);
        Metadata metadataA0E = null;
        Metadata metadataA0D = null;
        while (true) {
            int iA07 = c09724v.A07();
            String[] strArr = A01;
            if (strArr[7].charAt(30) == strArr[4].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "ATF6ss1I";
            strArr2[3] = "jntry4xS";
            if (iA07 >= 8) {
                int iA09 = c09724v.A09();
                int iA0C = c09724v.A0C();
                int iA0C2 = c09724v.A0C();
                if (iA0C2 == 1835365473) {
                    c09724v.A0f(iA09);
                    metadataA0E = A0E(c09724v, iA09 + iA0C);
                } else if (iA0C2 == 1936553057) {
                    c09724v.A0f(iA09);
                    metadataA0D = A0D(c09724v, iA09 + iA0C);
                }
                c09724v.A0f(iA09 + iA0C);
            } else {
                return Pair.create(metadataA0E, metadataA0D);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return new com.facebook.ads.androidx.media3.common.Metadata(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.androidx.media3.common.Metadata A0C(com.facebook.ads.redexgen.core.C09724v r5, int r6) {
        /*
            r0 = 8
            r5.A0g(r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        La:
            int r0 = r5.A09()
            if (r0 >= r6) goto L39
            com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame r4 = com.facebook.ads.redexgen.core.JB.A04(r5)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.J0.A01
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 24
            if (r1 == r0) goto L27
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L27:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "lHUs7TBcARFSvdLvQvihflkVmEpZ1MYm"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "ww6ZL200nHcHREaExV9g08P8Dpl3Z1fQ"
            r0 = 4
            r2[r0] = r1
            if (r4 == 0) goto La
            r3.add(r4)
            goto La
        L39:
            boolean r4 = r3.isEmpty()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            r0 = 1
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L61
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "WnDUA4AhIDsAjF22CXXz4OtQUCX0JoWn"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "j7UA12dewj7emLVLNadXlb6UYVuvbHls"
            r0 = 4
            r2[r0] = r1
            if (r4 == 0) goto L64
        L5f:
            r0 = 0
        L60:
            return r0
        L61:
            if (r4 == 0) goto L64
            goto L5f
        L64:
            com.facebook.ads.androidx.media3.common.Metadata r0 = new com.facebook.ads.androidx.media3.common.Metadata
            r0.<init>(r3)
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A0C(com.facebook.ads.redexgen.X.4v, int):com.facebook.ads.androidx.media3.common.Metadata");
    }

    public static Metadata A0D(C09724v c09724v, int i) {
        c09724v.A0g(12);
        while (true) {
            int iA09 = c09724v.A09();
            if (A01[5].charAt(23) != 'W') {
                throw new RuntimeException();
            }
            A01[2] = "yKVAIw0tCkGB7M4Cua27Coqh";
            if (iA09 >= i) {
                return null;
            }
            int atomSize = c09724v.A09();
            int iA0C = c09724v.A0C();
            int atomPosition = c09724v.A0C();
            if (atomPosition == 1935766900) {
                if (iA0C < 14) {
                    return null;
                }
                c09724v.A0g(5);
                int iA0I = c09724v.A0I();
                if (iA0I != 12 && iA0I != 13) {
                    return null;
                }
                float f = iA0I == 12 ? 240.0f : 120.0f;
                c09724v.A0g(1);
                return new Metadata(new SmtaMetadataEntry(f, c09724v.A0I()));
            }
            c09724v.A0f(atomSize + iA0C);
        }
    }

    public static Metadata A0E(C09724v c09724v, int i) {
        c09724v.A0g(8);
        A0Q(c09724v);
        while (c09724v.A09() < i) {
            int iA09 = c09724v.A09();
            int atomType = c09724v.A0C();
            int atomSize = c09724v.A0C();
            if (atomSize == 1768715124) {
                c09724v.A0f(iA09);
                return A0C(c09724v, iA09 + atomType);
            }
            c09724v.A0f(iA09 + atomType);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C1318Iy A0H(com.facebook.ads.redexgen.core.C09724v r24, int r25, int r26, java.lang.String r27, com.facebook.ads.androidx.media3.common.DrmInitData r28, boolean r29) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A0H(com.facebook.ads.redexgen.X.4v, int, int, java.lang.String, com.facebook.ads.androidx.media3.common.DrmInitData, boolean):com.facebook.ads.redexgen.X.Iy");
    }

    public static ByteBuffer A0N() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kO != com.google.common.base.Function<com.facebook.ads.androidx.media3.extractor.mp4.Track, com.facebook.ads.androidx.media3.extractor.mp4.Track> */
    public static List<JR> A0O(C2488mE c2488mE, HK hk, long j, DrmInitData drmInitData, boolean z, boolean z2, InterfaceC2376kO<JO, JO> interfaceC2376kO) throws C3K {
        JO joA4B;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c2488mE.A01.size(); i++) {
            C2488mE c2488mE2 = c2488mE.A01.get(i);
            if (((AbstractC1314Iu) c2488mE2).A00 == 1953653099 && (joA4B = interfaceC2376kO.A4B(A0J(c2488mE2, (C2487mD) AbstractC09493y.A01(c2488mE.A07(Atom.TYPE_mvhd)), j, drmInitData, z, z2))) != null) {
                C2488mE c2488mE3 = (C2488mE) AbstractC09493y.A01(c2488mE2.A06(Atom.TYPE_mdia));
                if (A01[2].length() != 24) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "jveTcVJC";
                strArr[3] = "kDhQUkZe";
                arrayList.add(A0L(joA4B, (C2488mE) AbstractC09493y.A01(((C2488mE) AbstractC09493y.A01(c2488mE3.A06(Atom.TYPE_minf))).A06(Atom.TYPE_stbl)), hk));
            }
        }
        return arrayList;
    }

    public static void A0Q(C09724v c09724v) {
        int iA09 = c09724v.A09();
        c09724v.A0g(4);
        if (c09724v.A0C() != 1751411826) {
            iA09 += 4;
        }
        c09724v.A0f(iA09);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<byte[]> */
    public static void A0S(C09724v c09724v, int i, int i2, int i3, int i4, String str, C1318Iy c1318Iy) {
        String strA0M;
        c09724v.A0f(i2 + 8 + 8);
        BP bpA04 = null;
        long j = Long.MAX_VALUE;
        if (i == 1414810956) {
            strA0M = A0M(691, 20, 103);
        } else if (i == 1954034535) {
            strA0M = A0M(784, 28, 58);
            int sampleDescriptionLength = (i3 - 8) - 8;
            byte[] bArr = new byte[sampleDescriptionLength];
            c09724v.A0k(bArr, 0, sampleDescriptionLength);
            bpA04 = BP.A04(bArr);
        } else if (i == 2004251764) {
            strA0M = A0M(763, 21, 88);
        } else if (i == 1937010800) {
            strA0M = A0M(691, 20, 103);
            j = 0;
        } else if (i == 1664495672) {
            strA0M = A0M(738, 25, 73);
            c1318Iy.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        c1318Iy.A02 = new C09162p().A0g(i4).A11(strA0M).A10(str).A0s(j).A12(bpA04).A14();
    }

    public static void A0U(C09724v c09724v, int i, int i2, int i3, C1318Iy c1318Iy) {
        c09724v.A0f(i2 + 8 + 8);
        if (i == 1835365492) {
            c09724v.A0U();
            String strA0U = c09724v.A0U();
            if (strA0U != null) {
                c1318Iy.A02 = new C09162p().A0g(i3).A11(strA0U).A14();
            }
        }
    }

    public static boolean A0V(long[] jArr, long j, long j2, long j3) {
        int latestDelayIndex = jArr.length - 1;
        int iA07 = C5C.A07(4, 0, latestDelayIndex);
        int lastIndex = jArr.length;
        int latestDelayIndex2 = C5C.A07(lastIndex - 4, 0, latestDelayIndex);
        if (jArr[0] <= j2) {
            long j4 = jArr[iA07];
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[3];
            int length = str.length();
            int lastIndex2 = str2.length();
            if (length != lastIndex2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "4d2838LB6zuHL2SDSRFgaAe0bfX5eWcN";
            strArr2[4] = "2DmC9sheXkti4jYQDflGydtNBiOhlXlc";
            if (j2 < j4 && jArr[latestDelayIndex2] < j3 && j3 <= j) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] A0W(com.facebook.ads.redexgen.core.C09724v r6, int r7, int r8) {
        /*
            int r3 = r7 + 8
        L2:
            int r0 = r3 - r7
            if (r0 >= r8) goto L49
            r6.A0f(r3)
            int r5 = r6.A0C()
            int r4 = r6.A0C()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            r0 = 7
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L43
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.J0.A01
            java.lang.String r1 = "QfAHDCYR"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "If6V2JqI"
            r0 = 3
            r2[r0] = r1
            r0 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r4 != r0) goto L41
            byte[] r1 = r6.A0l()
            int r0 = r3 + r5
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
            return r0
        L41:
            int r3 = r3 + r5
            goto L2
        L43:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L49:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.J0.A0W(com.facebook.ads.redexgen.X.4v, int, int):byte[]");
    }
}
