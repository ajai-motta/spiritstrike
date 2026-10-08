package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2480m6 implements H9 {
    public static byte[] A0e;
    public static String[] A0f = {"ywSCwlzG1SMdvvW", "WbYO2rYjmhbf4R3oYDPvQZ3H98amgjSr", "Za", "aa8pMmtLKrvpWkukTfymetmlHniL9M", "752FE5aLUbaesINptKDix8v", "1m6bsNbzXuacY99BBbBsLUDHw0asFdhp", "tFAwrqTGVJ2tUOf2i", "X0elgRXJnrwhMbXNAucG6j3nQ1B9k96A"};
    public static final HD A0g;
    public static final C2725qI A0h;
    public static final byte[] A0i;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public SparseArray<J7> A0D;
    public C09724v A0E;
    public HA A0F;
    public J7 A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public InterfaceC1272Hd[] A0K;
    public InterfaceC1272Hd[] A0L;
    public final int A0M;
    public final DrmInitData A0N;
    public final C09724v A0O;
    public final C09724v A0P;
    public final C09724v A0Q;
    public final C09724v A0R;
    public final C09724v A0S;
    public final AnonymousClass53 A0T;
    public final InterfaceC1272Hd A0U;
    public final I0 A0V;
    public final JO A0W;
    public final ArrayDeque<C2488mE> A0X;
    public final ArrayDeque<J6> A0Y;
    public final List<C2725qI> A0Z;
    public final boolean A0a;
    public final boolean A0b;
    public final boolean A0c;
    public final byte[] A0d;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(com.facebook.ads.redexgen.core.J7 r25, int r26, long r27, int r29, com.facebook.ads.redexgen.core.C09724v r30, int r31) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2480m6.A00(com.facebook.ads.redexgen.X.J7, int, long, int, com.facebook.ads.redexgen.X.4v, int):int");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, C2521my> A04(C09724v c09724v, long j) throws C3K {
        long jA0R;
        long jA0R2;
        c09724v.A0f(8);
        int iA01 = AbstractC1314Iu.A01(c09724v.A0C());
        c09724v.A0g(4);
        long jA0Q = c09724v.A0Q();
        if (iA01 == 0) {
            jA0R = c09724v.A0Q();
            jA0R2 = j + c09724v.A0Q();
        } else {
            jA0R = c09724v.A0R();
            jA0R2 = j + c09724v.A0R();
        }
        long jA0U = C5C.A0U(jA0R, 1000000L, jA0Q);
        c09724v.A0g(2);
        int iA0M = c09724v.A0M();
        int[] iArr = new int[iA0M];
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        long[] jArr3 = new long[iA0M];
        long jA0U2 = jA0U;
        for (int i = 0; i < iA0M; i++) {
            int iA0C = c09724v.A0C();
            if ((Integer.MIN_VALUE & iA0C) != 0) {
                throw new C3K(A0B(634, 28, 93));
            }
            long jA0Q2 = c09724v.A0Q();
            iArr[i] = Integer.MAX_VALUE & iA0C;
            jArr[i] = jA0R2;
            jArr3[i] = jA0U2;
            jA0R += jA0Q2;
            jA0U2 = C5C.A0U(jA0R, 1000000L, jA0Q);
            String[] strArr = A0f;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0f[7] = "mBjUzKzbBV9DJWZlH52EoviqXd7Fx3w7";
            jArr2[i] = jA0U2 - jArr3[i];
            c09724v.A0g(4);
            jA0R2 += (long) iArr[i];
        }
        return Pair.create(Long.valueOf(jA0U), new C2521my(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static J7 A09(C09724v c09724v, SparseArray<J7> sparseArray, boolean z) {
        c09724v.A0f(8);
        int iA00 = AbstractC1314Iu.A00(c09724v.A0C());
        J7 j7A08 = A08(sparseArray, c09724v.A0C(), z);
        if (j7A08 == null) {
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0R = c09724v.A0R();
            j7A08.A07.A04 = jA0R;
            j7A08.A07.A03 = jA0R;
        }
        J1 j1 = j7A08.A04;
        j7A08.A07.A06 = new J1((iA00 & 2) != 0 ? c09724v.A0L() - 1 : j1.A02, (iA00 & 8) != 0 ? c09724v.A0L() : j1.A00, (iA00 & 16) != 0 ? c09724v.A0L() : j1.A03, (iA00 & 32) != 0 ? c09724v.A0L() : j1.A01);
        return j7A08;
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0e, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        String[] strArr = A0f;
        if (strArr[1].charAt(23) != strArr[5].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[1] = "BGZmKOZPo9hBykc2GdFNUQpHC0I3sPv1";
        strArr2[5] = "CvUkm70dQ0grN9w1V6xWMg6HVylPciNL";
        A0e = new byte[]{84, 88, 95, 106, 113, 115, 62, 109, 119, 100, 123, 62, 114, 123, 109, 109, 62, 106, 118, 127, 112, 62, 118, 123, 127, 122, 123, 108, 62, 114, 123, 112, 121, 106, 118, 62, 54, 107, 112, 109, 107, 110, 110, 113, 108, 106, 123, 122, 55, 48, 99, 72, 82, 84, 95, 6, 69, 73, 83, 72, 82, 6, 79, 72, 6, 85, 68, 65, 86, 6, 7, Ascii.ESC, 6, Ascii.ETB, 6, Ascii.SO, 83, 72, 85, 83, 86, 86, 73, 84, 82, 67, 66, Ascii.SI, 8, 73, 98, 120, 126, 117, 44, 111, 99, 121, 98, 120, 44, 101, 98, 44, 127, 107, 124, 104, 44, 45, 49, 44, Base64.padSymbol, 44, 36, 121, 98, 127, 121, 124, 124, 99, 126, 120, 105, 104, 37, 34, 104, 92, 79, 73, 67, 75, SignedBytes.MAX_POWER_OF_TWO, 90, 75, 74, 99, 94, Ascii.SUB, 107, 86, 90, 92, 79, 77, 90, 65, 92, 57, Ascii.ETB, Ascii.RS, Ascii.US, 2, Ascii.EM, Ascii.RS, Ascii.ETB, 80, Ascii.RS, Ascii.NAK, Ascii.ETB, 17, 4, Ascii.EM, 6, Ascii.NAK, 80, Ascii.US, Ascii.SYN, Ascii.SYN, 3, Ascii.NAK, 4, 80, 4, Ascii.US, 80, 3, 17, Ascii.GS, 0, Ascii.FS, Ascii.NAK, 80, Ascii.DC4, 17, 4, 17, 94, 116, 83, 75, 92, 81, 84, 89, Ascii.GS, 115, 124, 113, Ascii.GS, 81, 88, 83, 90, 73, 85, 113, 88, 92, 91, Ascii.GS, 92, 73, 82, 80, Ascii.GS, 89, 88, 91, 84, 83, 88, 78, Ascii.GS, 88, 69, 73, 88, 83, 89, 88, 89, Ascii.GS, 92, 73, 82, 80, Ascii.GS, 78, 84, 71, 88, Ascii.GS, Ascii.NAK, 72, 83, 78, 72, 77, 77, 82, 79, 73, 88, 89, Ascii.DC4, 19, 62, Ascii.ETB, 19, Ascii.DC4, 82, 19, 6, Ascii.GS, Ascii.US, 82, 5, Ascii.ESC, 6, Ascii.SUB, 82, Ascii.RS, Ascii.ETB, Ascii.FS, Ascii.NAK, 6, Ascii.SUB, 82, 76, 82, SignedBytes.MAX_POWER_OF_TWO, 67, 70, 69, 70, 74, 65, 68, 70, 69, 82, 90, 7, Ascii.FS, 1, 7, 2, 2, Ascii.GS, 0, 6, Ascii.ETB, Ascii.SYN, 91, 92, 2, 43, 32, 41, 58, 38, 110, 35, 39, Base64.padSymbol, 35, 47, 58, 45, 38, 116, 110, 82, 123, 123, 110, 120, 105, Base64.padSymbol, 105, 114, Base64.padSymbol, 120, 115, 126, 111, 100, 109, 105, 116, 114, 115, Base64.padSymbol, 121, 124, 105, 124, Base64.padSymbol, 106, 124, 110, Base64.padSymbol, 115, 120, 122, 124, 105, 116, 107, 120, 51, 123, 82, 82, 71, 81, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 91, Ascii.DC4, 81, 90, 80, Ascii.DC4, 91, 82, Ascii.DC4, 89, 80, 85, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 67, 85, 71, Ascii.DC4, 90, 81, 83, 85, SignedBytes.MAX_POWER_OF_TWO, 93, 66, 81, Ascii.SUB, Base64.padSymbol, 4, Ascii.ETB, 0, 0, Ascii.ESC, Ascii.SYN, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, 38, 0, 19, 17, Ascii.EM, 55, Ascii.FS, 17, 0, Ascii.VT, 2, 6, Ascii.ESC, Ascii.GS, Ascii.FS, 48, Ascii.GS, 10, 82, 2, 19, 0, 19, Ascii.US, Ascii.ETB, 6, Ascii.ETB, 0, 1, 82, Ascii.ESC, 1, 82, 7, Ascii.FS, 1, 7, 2, 2, Ascii.GS, 0, 6, Ascii.ETB, Ascii.SYN, 92, 84, 108, 110, 119, 119, 98, 99, 39, 119, 116, 116, 111, 39, 102, 115, 104, 106, 39, 47, 97, 102, 110, 107, 98, 99, 39, 115, 104, 39, 98, 127, 115, 117, 102, 100, 115, 39, 114, 114, 110, 99, 46, 60, 4, 6, Ascii.US, Ascii.US, 6, 1, 8, 79, Ascii.SO, Ascii.ESC, 0, 2, 79, Ascii.CAN, 6, Ascii.ESC, 7, 79, 3, 10, 1, 8, Ascii.ESC, 7, 79, 81, 79, 93, 94, 91, 88, 91, 87, 92, 89, 91, 88, 79, 71, Ascii.SUB, 1, Ascii.FS, Ascii.SUB, Ascii.US, Ascii.US, 0, Ascii.GS, Ascii.ESC, 10, Ascii.VT, 70, 65, 79, 119, 117, 108, 108, 117, 114, 123, 60, 105, 114, 111, 105, 108, 108, 115, 110, 104, 121, 120, 60, 121, 113, 111, 123, 60, 106, 121, 110, 111, 117, 115, 114, 38, 60, 57, 2, 9, Ascii.DC4, Ascii.FS, 9, Ascii.SI, Ascii.CAN, 9, 8, 76, 1, 3, 3, Ascii.SUB, 76, Ascii.SO, 3, Ascii.DC4, 66, 71, 124, 119, 106, 98, 119, 113, 102, 119, 118, 50, 97, 115, 123, 125, 50, 119, 124, 102, 96, 107, 50, 113, 125, 103, 124, 102, 40, 50, 107, 80, 86, 95, 80, 90, 82, 91, 90, Ascii.RS, 87, 80, 90, 87, 76, 91, 93, 74, Ascii.RS, 76, 91, 88, 91, 76, 91, 80, 93, 91, 107, 92, 79, 84, 92, 95, 81, 88, Ascii.GS, 81, 88, 83, 90, 73, 85, Ascii.GS, 89, 88, 78, 94, 79, 84, 77, 73, 84, 82, 83, Ascii.GS, 84, 83, Ascii.GS, 78, 90, 77, 89, Ascii.GS, 91, 82, 72, 83, 89, Ascii.GS, Ascii.NAK, 72, 83, 78, 72, 77, 77, 82, 79, 73, 88, 89, Ascii.DC4, 83, 66, 66, 94, 91, 81, 83, 70, 91, 93, 92, Ascii.GS, 74, Ascii.US, 87, 95, 65, 85, 66, 83, 83, 79, 74, SignedBytes.MAX_POWER_OF_TWO, 66, 87, 74, 76, 77, Ascii.FF, 91, Ascii.SO, 78, 83, Ascii.ETB, Ascii.SO, 85, 87, 87, 70, 89, 84, 85, 95, Ascii.US, 88, 85, 70, 83, 40, 55, 58, 59, 49, 113, 51, 46, 106};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0I(C09724v c09724v, Uri uri) {
        String str;
        String str2;
        long jA0U;
        long jA0Q;
        if (this.A0L == null || this.A0L.length == 0) {
            return;
        }
        c09724v.A0f(8);
        int iA01 = AbstractC1314Iu.A01(c09724v.A0C());
        long jA0U2 = C.TIME_UNSET;
        long jA05 = C.TIME_UNSET;
        switch (iA01) {
            case 0:
                str = (String) AbstractC09493y.A01(c09724v.A0U());
                str2 = (String) AbstractC09493y.A01(c09724v.A0U());
                if (A0f[2].length() != 2) {
                    throw new RuntimeException();
                }
                A0f[0] = "4yWaL9iFGGaDiXT";
                long jA0Q2 = c09724v.A0Q();
                jA0U2 = C5C.A0U(c09724v.A0Q(), 1000000L, jA0Q2);
                if (this.A0C != C.TIME_UNSET) {
                    jA05 = this.A0C + jA0U2;
                }
                jA0U = C5C.A0U(c09724v.A0Q(), 1000L, jA0Q2);
                jA0Q = c09724v.A0Q();
                break;
                break;
            case 1:
                long jA0Q3 = c09724v.A0Q();
                jA05 = C5C.A0U(c09724v.A0R(), 1000000L, jA0Q3);
                jA0U = C5C.A0U(c09724v.A0Q(), 1000L, jA0Q3);
                jA0Q = c09724v.A0Q();
                str = (String) AbstractC09493y.A01(c09724v.A0U());
                str2 = (String) AbstractC09493y.A01(c09724v.A0U());
                break;
            default:
                AbstractC09574g.A07(A0B(128, 22, 77), A0B(550, 35, 127) + iA01);
                return;
        }
        byte[] bArr = new byte[c09724v.A07()];
        c09724v.A0k(bArr, 0, c09724v.A07());
        int i = 0;
        C09724v c09724v2 = new C09724v(this.A0V.A01(new EventMessage(str, str2, jA0U, jA0Q, bArr)));
        int iA07 = c09724v2.A07();
        InterfaceC1272Hd[] interfaceC1272HdArr = this.A0L;
        int length = interfaceC1272HdArr.length;
        int i2 = 0;
        while (i2 < length) {
            InterfaceC1272Hd interfaceC1272Hd = interfaceC1272HdArr[i2];
            c09724v2.A0f(i);
            interfaceC1272Hd.AKf(uri);
            interfaceC1272Hd.AIr(c09724v2, iA07);
            i2++;
            i = 0;
        }
        if (jA05 == C.TIME_UNSET) {
            this.A0Y.addLast(new J6(jA0U2, iA07));
            this.A03 += iA07;
            return;
        }
        if (this.A0T != null) {
            jA05 = this.A0T.A05(jA05);
        }
        if (this.A0b && this.A0A != C.TIME_UNSET) {
            jA05 = this.A0A;
        }
        for (InterfaceC1272Hd interfaceC1272Hd2 : this.A0L) {
            interfaceC1272Hd2.AIu(jA05, 1, iA07, 0, null);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0J(C09724v c09724v, C09724v c09724v2, String str, JQ jq) throws C3K {
        c09724v.A0f(8);
        int iA0C = c09724v.A0C();
        if (c09724v.A0C() != 1936025959) {
            return;
        }
        int iA01 = AbstractC1314Iu.A01(iA0C);
        if (A0f[2].length() != 2) {
            throw new RuntimeException();
        }
        A0f[0] = "QrVDtjxvyixdHPq";
        if (iA01 == 1) {
            c09724v.A0g(4);
        }
        if (c09724v.A0C() != 1) {
            throw new C3K(A0B(50, 39, 69));
        }
        c09724v2.A0f(8);
        int iA0C2 = c09724v2.A0C();
        if (c09724v2.A0C() != 1936025959) {
            return;
        }
        int iA012 = AbstractC1314Iu.A01(iA0C2);
        if (iA012 == 1) {
            if (c09724v2.A0Q() == 0) {
                throw new C3K(A0B(662, 55, 94));
            }
        } else if (iA012 >= 2) {
            c09724v2.A0g(4);
        }
        if (c09724v2.A0Q() != 1) {
            throw new C3K(A0B(89, 39, 111));
        }
        c09724v2.A0g(1);
        int iA0I = c09724v2.A0I();
        int i = (iA0I & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        int i2 = iA0I & 15;
        boolean z = c09724v2.A0I() == 1;
        if (z) {
            int iA0I2 = c09724v2.A0I();
            byte[] bArr = new byte[16];
            c09724v2.A0k(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (iA0I2 == 0) {
                int iA0I3 = c09724v2.A0I();
                bArr2 = new byte[iA0I3];
                c09724v2.A0k(bArr2, 0, iA0I3);
            }
            jq.A08 = true;
            jq.A07 = new JP(z, str, iA0I2, bArr, i, i2, bArr2);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0R(com.facebook.ads.redexgen.core.C2488mE r17) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2480m6.A0R(com.facebook.ads.redexgen.X.mE):void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[PHI: r0 r3
  0x006a: PHI (r0v33 com.facebook.ads.redexgen.X.mD) = (r0v12 com.facebook.ads.redexgen.X.mD), (r0v38 com.facebook.ads.redexgen.X.mD) binds: [B:43:0x0106, B:17:0x0068] A[DONT_GENERATE, DONT_INLINE]
  0x006a: PHI (r3v6 com.facebook.ads.redexgen.X.JP) = (r3v1 com.facebook.ads.redexgen.X.JP), (r3v7 com.facebook.ads.redexgen.X.JP) binds: [B:43:0x0106, B:17:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0T(com.facebook.ads.redexgen.core.C2488mE r9, android.util.SparseArray<com.facebook.ads.redexgen.core.J7> r10, int r11, byte[] r12, boolean r13) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2480m6.A0T(com.facebook.ads.redexgen.X.mE, android.util.SparseArray, int, byte[], boolean):void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0W(JP jp, C09724v c09724v, JQ jq) throws C3K {
        int i = jp.A00;
        c09724v.A0f(8);
        if ((AbstractC1314Iu.A00(c09724v.A0C()) & 1) == 1) {
            c09724v.A0g(8);
        }
        int iA0I = c09724v.A0I();
        int iA0L = c09724v.A0L();
        if (iA0L != jq.A00) {
            throw new C3K(A0B(308, 17, 45) + iA0L + A0B(0, 2, 27) + jq.A00);
        }
        int i2 = 0;
        if (iA0I == 0) {
            boolean[] zArr = jq.A0F;
            for (int i3 = 0; i3 < iA0L; i3++) {
                int iA0I2 = c09724v.A0I();
                i2 += iA0I2;
                zArr[i3] = iA0I2 > i;
            }
        } else {
            i2 = 0 + (iA0I * iA0L);
            Arrays.fill(jq.A0F, 0, iA0L, iA0I > i);
        }
        jq.A02(i2);
    }

    static {
        A0E();
        A0g = new HD() { // from class: com.facebook.ads.redexgen.X.mA
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C2480m6.A0b();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A0i = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        A0h = new C09162p().A11(A0B(717, 18, 81)).A14();
    }

    public C2480m6() {
        this(0);
    }

    public C2480m6(int i) {
        this(i, null);
    }

    public C2480m6(int i, AnonymousClass53 anonymousClass53) {
        this(i, anonymousClass53, null, null);
    }

    public C2480m6(int i, AnonymousClass53 anonymousClass53, JO jo, DrmInitData drmInitData) {
        this(i, anonymousClass53, jo, drmInitData, Collections.emptyList());
    }

    public C2480m6(int i, AnonymousClass53 anonymousClass53, JO jo, DrmInitData drmInitData, List<C2725qI> list) {
        this(i, anonymousClass53, jo, drmInitData, list, null, false, false, false);
    }

    public C2480m6(int i, AnonymousClass53 anonymousClass53, JO jo, DrmInitData drmInitData, List<C2725qI> list, InterfaceC1272Hd interfaceC1272Hd, boolean z, boolean z2, boolean z3) {
        this.A0A = C.TIME_UNSET;
        this.A0M = (jo != null ? 8 : 0) | i;
        this.A0T = anonymousClass53;
        this.A0W = jo;
        this.A0N = drmInitData;
        this.A0Z = Collections.unmodifiableList(list);
        this.A0U = interfaceC1272Hd;
        this.A0c = z;
        this.A0b = z2;
        this.A0a = z3;
        this.A0V = new I0();
        this.A0O = new C09724v(16);
        this.A0R = new C09724v(HS.A03);
        this.A0Q = new C09724v(5);
        this.A0P = new C09724v();
        this.A0d = new byte[16];
        this.A0S = new C09724v(this.A0d);
        this.A0X = new ArrayDeque<>();
        this.A0Y = new ArrayDeque<>();
        this.A0D = new SparseArray<>();
        this.A08 = C.TIME_UNSET;
        this.A0B = C.TIME_UNSET;
        this.A0C = C.TIME_UNSET;
        A0C();
    }

    public static long A01(C09724v c09724v) {
        c09724v.A0f(8);
        int fullAtom = c09724v.A0C();
        return AbstractC1314Iu.A01(fullAtom) == 0 ? c09724v.A0Q() : c09724v.A0R();
    }

    public static long A02(C09724v c09724v) {
        c09724v.A0f(8);
        int fullAtom = c09724v.A0C();
        int version = AbstractC1314Iu.A01(fullAtom);
        return version == 1 ? c09724v.A0R() : c09724v.A0Q();
    }

    public static Pair<Integer, J1> A03(C09724v c09724v) {
        c09724v.A0f(12);
        int defaultSampleDescriptionIndex = c09724v.A0C();
        int trackId = c09724v.A0L();
        int defaultSampleFlags = c09724v.A0L();
        int defaultSampleSize = c09724v.A0L();
        int defaultSampleDuration = c09724v.A0C();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new J1(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A05(List<C2487mD> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2487mD c2487mD = list.get(i);
            int leafChildrenSize = A0f[4].length();
            if (leafChildrenSize != 23) {
                throw new RuntimeException();
            }
            A0f[0] = "gRucWkmmr3YeQcV";
            C2487mD c2487mD2 = c2487mD;
            int leafChildrenSize2 = ((AbstractC1314Iu) c2487mD2).A00;
            if (leafChildrenSize2 == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = c2487mD2.A00.A00;
                UUID uuidA02 = JH.A02(bArr);
                if (uuidA02 == null) {
                    AbstractC09574g.A07(A0B(128, 22, 77), A0B(455, 42, 100));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA02, A0B(766, 9, 61), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private J1 A06(SparseArray<J1> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (J1) AbstractC09493y.A01(sparseArray.get(i));
    }

    public static J7 A07(SparseArray<J7> sparseArray) {
        J7 j7 = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            J7 j7ValueAt = sparseArray.valueAt(i);
            if (j7ValueAt.A02 != j7ValueAt.A07.A01) {
                long nextTrackRunOffset = j7ValueAt.A07.A0E[j7ValueAt.A02];
                if (nextTrackRunOffset < j) {
                    j7 = j7ValueAt;
                    j = nextTrackRunOffset;
                }
            }
        }
        return j7;
    }

    public static J7 A08(SparseArray<J7> sparseArray, int i, boolean z) {
        if (sparseArray.size() == 1 && !z) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i);
    }

    private final JO A0A(JO jo) {
        return jo;
    }

    private void A0C() {
        this.A02 = 0;
        this.A00 = 0;
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x007e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0D() {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.Hd[] r0 = r6.A0L
            if (r0 != 0) goto L6c
            r0 = 2
            com.facebook.ads.redexgen.X.Hd[] r0 = new com.facebook.ads.redexgen.core.InterfaceC1272Hd[r0]
            r6.A0L = r0
            r3 = 0
            com.facebook.ads.redexgen.X.Hd r0 = r6.A0U
            if (r0 == 0) goto L17
            com.facebook.ads.redexgen.X.Hd[] r2 = r6.A0L
            int r1 = r3 + 1
            com.facebook.ads.redexgen.X.Hd r0 = r6.A0U
            r2[r3] = r0
            r3 = r1
        L17:
            int r0 = r6.A0M
            r0 = r0 & 4
            if (r0 == 0) goto L4c
            com.facebook.ads.redexgen.X.Hd[] r4 = r6.A0L
            int r5 = r3 + 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2480m6.A0f
            r0 = 7
            r1 = r1[r0]
            r0 = 29
            char r1 = r1.charAt(r0)
            r0 = 48
            if (r1 == r0) goto L66
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2480m6.A0f
            java.lang.String r1 = "2Ynf6gmdLfe6xE9EEWKUzFfHKl41sL7a"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "AN0qqeacVBgpTr6ZS3JdezHHRUzhKU8l"
            r0 = 5
            r2[r0] = r1
            com.facebook.ads.redexgen.X.HA r2 = r6.A0F
            android.util.SparseArray<com.facebook.ads.redexgen.X.J7> r0 = r6.A0D
            int r1 = r0.size()
            r0 = 5
            com.facebook.ads.redexgen.X.Hd r0 = r2.AKS(r1, r0)
            r4[r3] = r0
            r3 = r5
        L4c:
            com.facebook.ads.redexgen.X.Hd[] r0 = r6.A0L
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            com.facebook.ads.redexgen.X.Hd[] r0 = (com.facebook.ads.redexgen.core.InterfaceC1272Hd[]) r0
            r6.A0L = r0
            com.facebook.ads.redexgen.X.Hd[] r4 = r6.A0L
            int r3 = r4.length
            r2 = 0
        L5a:
            if (r2 >= r3) goto L6c
            r1 = r4[r2]
            com.facebook.ads.redexgen.X.qI r0 = com.facebook.ads.redexgen.core.C2480m6.A0h
            r1.A6e(r0)
            int r2 = r2 + 1
            goto L5a
        L66:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L6c:
            com.facebook.ads.redexgen.X.Hd[] r0 = r6.A0K
            if (r0 != 0) goto La2
            java.util.List<com.facebook.ads.redexgen.X.qI> r0 = r6.A0Z
            int r0 = r0.size()
            com.facebook.ads.redexgen.X.Hd[] r0 = new com.facebook.ads.redexgen.core.InterfaceC1272Hd[r0]
            r6.A0K = r0
            r3 = 0
        L7b:
            com.facebook.ads.redexgen.X.Hd[] r0 = r6.A0K
            int r0 = r0.length
            if (r3 >= r0) goto La2
            com.facebook.ads.redexgen.X.HA r2 = r6.A0F
            android.util.SparseArray<com.facebook.ads.redexgen.X.J7> r0 = r6.A0D
            int r0 = r0.size()
            int r1 = r0 + 1
            int r1 = r1 + r3
            r0 = 3
            com.facebook.ads.redexgen.X.Hd r1 = r2.AKS(r1, r0)
            java.util.List<com.facebook.ads.redexgen.X.qI> r0 = r6.A0Z
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.qI r0 = (com.facebook.ads.redexgen.core.C2725qI) r0
            r1.A6e(r0)
            com.facebook.ads.redexgen.X.Hd[] r0 = r6.A0K
            r0[r3] = r1
            int r3 = r3 + 1
            goto L7b
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2480m6.A0D():void");
    }

    private void A0F(long j) {
        while (!this.A0Y.isEmpty()) {
            J6 j6RemoveFirst = this.A0Y.removeFirst();
            this.A03 -= j6RemoveFirst.A00;
            long jA05 = j + j6RemoveFirst.A01;
            if (this.A0T != null) {
                jA05 = this.A0T.A05(jA05);
            }
            for (InterfaceC1272Hd interfaceC1272Hd : this.A0L) {
                interfaceC1272Hd.AIu(jA05, 1, j6RemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0G(long j) throws C3K {
        while (!this.A0X.isEmpty() && this.A0X.peek().A00 == j) {
            A0P(this.A0X.pop());
        }
        A0C();
    }

    public static void A0H(C09724v c09724v, int i, JQ jq) throws C3K {
        c09724v.A0f(i + 8);
        int fullAtom = c09724v.A0C();
        int flags = AbstractC1314Iu.A00(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z = fullAtom3 != 0;
            int sampleCount = c09724v.A0L();
            int fullAtom4 = jq.A00;
            if (sampleCount == fullAtom4) {
                Arrays.fill(jq.A0F, 0, sampleCount, z);
                int fullAtom5 = c09724v.A07();
                jq.A02(fullAtom5);
                jq.A04(c09724v);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append(A0B(308, 17, 45)).append(sampleCount).append(A0B(0, 2, 27));
            int fullAtom6 = jq.A00;
            throw new C3K(sbAppend.append(fullAtom6).toString());
        }
        throw new C3K(A0B(399, 56, 17));
    }

    public static void A0K(C09724v c09724v, JQ jq) throws C3K {
        c09724v.A0f(8);
        int flags = c09724v.A0C();
        int fullAtom = AbstractC1314Iu.A00(flags) & 1;
        if (fullAtom == 1) {
            c09724v.A0g(8);
        }
        int iA0L = c09724v.A0L();
        if (iA0L == 1) {
            int entryCount = AbstractC1314Iu.A01(flags);
            jq.A03 += entryCount == 0 ? c09724v.A0Q() : c09724v.A0R();
            return;
        }
        throw new C3K(A0B(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 29, 113) + iA0L);
    }

    public static void A0L(C09724v c09724v, JQ jq) throws C3K {
        A0H(c09724v, 0, jq);
    }

    public static void A0M(C09724v c09724v, JQ jq, byte[] bArr) throws C3K {
        c09724v.A0f(8);
        c09724v.A0k(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0i)) {
            return;
        }
        A0H(c09724v, 16, jq);
    }

    private void A0N(InterfaceC2516ms interfaceC2516ms) throws IOException {
        int i = ((int) this.A07) - this.A00;
        if (this.A0E != null) {
            interfaceC2516ms.readFully(this.A0E.A00, 8, i);
            A0V(new C2487mD(this.A01, this.A0E), interfaceC2516ms);
        } else {
            interfaceC2516ms.AK3(i);
        }
        A0G(interfaceC2516ms.A8n());
    }

    private void A0O(InterfaceC2516ms interfaceC2516ms) throws IOException {
        J7 j7ValueAt = null;
        long j = Long.MAX_VALUE;
        int size = this.A0D.size();
        int i = 0;
        while (true) {
            if (i < size) {
                J7 nextTrackBundle = this.A0D.valueAt(i);
                JQ jq = nextTrackBundle.A07;
                if (jq.A0A) {
                    long nextDataOffset = jq.A03;
                    String[] strArr = A0f;
                    if (strArr[3].length() == strArr[6].length()) {
                        break;
                    }
                    A0f[4] = "mIjUpcDFQdM2YkTgY6cnbvy";
                    if (nextDataOffset < j) {
                        j = jq.A03;
                        j7ValueAt = this.A0D.valueAt(i);
                    }
                }
                i++;
            } else {
                if (j7ValueAt != null) {
                    int iA8n = (int) (j - interfaceC2516ms.A8n());
                    if (iA8n >= 0) {
                        interfaceC2516ms.AK3(iA8n);
                        j7ValueAt.A07.A05(interfaceC2516ms);
                        return;
                    }
                    throw new C3K(A0B(325, 39, 126));
                }
                if (A0f[4].length() == 23) {
                    A0f[0] = "NbtoUSPOiQE3wq0";
                    this.A02 = 3;
                    return;
                }
            }
        }
        throw new RuntimeException();
    }

    private void A0P(C2488mE c2488mE) throws C3K {
        if (((AbstractC1314Iu) c2488mE).A00 == 1836019574) {
            A0R(c2488mE);
        } else if (((AbstractC1314Iu) c2488mE).A00 == 1836019558) {
            A0Q(c2488mE);
        } else {
            if (this.A0X.isEmpty()) {
                return;
            }
            this.A0X.peek().A08(c2488mE);
        }
    }

    private void A0Q(C2488mE c2488mE) throws C3K {
        A0S(c2488mE, this.A0D, this.A0M, this.A0d, this.A0c);
        DrmInitData drmInitDataA05 = this.A0N != null ? null : A05(c2488mE.A02);
        if (drmInitDataA05 != null) {
            int i = this.A0D.size();
            for (int trackCount = 0; trackCount < i; trackCount++) {
                this.A0D.valueAt(trackCount).A07(drmInitDataA05);
            }
        }
        if (this.A0B != C.TIME_UNSET) {
            int size = this.A0D.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A0D.valueAt(i2).A06(this.A0B);
            }
            this.A0B = C.TIME_UNSET;
        }
    }

    public static void A0S(C2488mE c2488mE, SparseArray<J7> sparseArray, int i, byte[] bArr, boolean z) throws C3K {
        int size = c2488mE.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2488mE child = c2488mE.A01.get(i2);
            int i3 = ((AbstractC1314Iu) child).A00;
            if (i3 == 1953653094) {
                boolean z2 = true;
                if (size <= 1 || !z) {
                    z2 = false;
                }
                A0T(child, sparseArray, i, bArr, z2);
            }
        }
    }

    public static void A0U(C2488mE c2488mE, J7 j7, long j, int i) {
        int i2 = 0;
        int i3 = 0;
        List<C2487mD> list = c2488mE.A02;
        int size = list.size();
        int i4 = 0;
        while (true) {
            String[] strArr = A0f;
            if (strArr[1].charAt(23) != strArr[5].charAt(23)) {
                throw new RuntimeException();
            }
            A0f[0] = "3b9EJYgpciD07do";
            if (i4 < size) {
                C2487mD c2487mD = list.get(i4);
                if (((AbstractC1314Iu) c2487mD).A00 == 1953658222) {
                    C09724v trunData = c2487mD.A00;
                    trunData.A0f(12);
                    int iA0L = trunData.A0L();
                    if (iA0L > 0) {
                        i3 += iA0L;
                        i2++;
                    }
                }
                i4++;
            } else {
                j7.A02 = 0;
                j7.A00 = 0;
                j7.A01 = 0;
                j7.A07.A03(i2, i3);
                int i5 = 0;
                int trunStartPosition = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    C2487mD c2487mD2 = list.get(i6);
                    if (((AbstractC1314Iu) c2487mD2).A00 == 1953658222) {
                        trunStartPosition = A00(j7, i5, j, i, c2487mD2.A00, trunStartPosition);
                        i5++;
                    }
                }
                return;
            }
        }
    }

    private void A0V(C2487mD c2487mD, InterfaceC2516ms interfaceC2516ms) throws C3K {
        Uri uriA9P;
        if (!this.A0X.isEmpty()) {
            this.A0X.peek().A09(c2487mD);
            return;
        }
        if (((AbstractC1314Iu) c2487mD).A00 == 1936286840) {
            Pair<Long, C2521my> pairA04 = A04(c2487mD.A00, interfaceC2516ms.A8n());
            this.A0C = ((Long) pairA04.first).longValue();
            this.A0F.AJ7((HY) pairA04.second);
            if (A0f[2].length() != 2) {
                throw new RuntimeException();
            }
            A0f[2] = "jw";
            this.A0H = true;
            return;
        }
        if (((AbstractC1314Iu) c2487mD).A00 != 1701671783 || (uriA9P = interfaceC2516ms.A9P()) == null) {
            return;
        }
        A0I(c2487mD.A00, uriA9P);
    }

    public static boolean A0X(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    public static boolean A0Y(int i) {
        if (i != 1751411826 && i != 1835296868 && i != 1836476516 && i != 1936286840 && i != 1937011556 && i != 1952867444 && i != 1952868452 && i != 1953196132 && i != 1953654136 && i != 1953658222 && i != 1886614376) {
            if (A0f[0].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[1] = "pufslWDHGkolcxIdleA53YlHTmcCni23";
            strArr[5] = "pxTVwd0BvZHkKJbeu8mcyfUHnPvesqsQ";
            if (i != 1935763834 && i != 1935763823 && i != 1936027235 && i != 1970628964 && i != 1935828848 && i != 1936158820 && i != 1701606260 && i != 1835362404 && i != 1701671783) {
                return false;
            }
        }
        return true;
    }

    private boolean A0Z(InterfaceC2516ms interfaceC2516ms) throws IOException {
        if (this.A00 == 0) {
            if (!interfaceC2516ms.AHR(this.A0O.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0O.A0f(0);
            this.A07 = this.A0O.A0Q();
            this.A01 = this.A0O.A0C();
        }
        if (this.A07 == 1) {
            interfaceC2516ms.readFully(this.A0O.A00, 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A07 = this.A0O.A0R();
        } else if (this.A07 == 0) {
            long jA8O = interfaceC2516ms.A8O();
            if (jA8O == -1 && !this.A0X.isEmpty()) {
                jA8O = this.A0X.peek().A00;
            }
            if (jA8O != -1) {
                long jA8n = jA8O - interfaceC2516ms.A8n();
                int trackCount = this.A00;
                this.A07 = jA8n + ((long) trackCount);
            }
        }
        if (this.A07 >= this.A00) {
            long jA8n2 = interfaceC2516ms.A8n() - ((long) this.A00);
            if (this.A01 == 1836019558) {
                int size = this.A0D.size();
                for (int i = 0; i < size; i++) {
                    JQ jq = this.A0D.valueAt(i).A07;
                    jq.A02 = jA8n2;
                    jq.A03 = jA8n2;
                    jq.A04 = jA8n2;
                }
            }
            if (this.A01 == 1835295092) {
                this.A0G = null;
                this.A09 = this.A07 + jA8n2;
                if (!this.A0H) {
                    this.A0F.AJ7(new C2511mn(this.A08, jA8n2));
                    this.A0H = true;
                }
                this.A02 = 2;
                return true;
            }
            boolean zA0X = A0X(this.A01);
            String[] strArr = A0f;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0f[7] = "BTpsgrbOJA5y808qoKaZGmPima83kMX9";
            if (zA0X) {
                long jA8n3 = (interfaceC2516ms.A8n() + this.A07) - 8;
                this.A0X.push(new C2488mE(this.A01, jA8n3));
                if (this.A07 == this.A00) {
                    A0G(jA8n3);
                } else {
                    A0C();
                }
            } else if (A0Y(this.A01)) {
                if (this.A00 != 8) {
                    throw new C3K(A0B(208, 51, 94));
                }
                if (this.A07 <= 2147483647L) {
                    this.A0E = new C09724v((int) this.A07);
                    System.arraycopy(this.A0O.A00, 0, this.A0E.A00, 0, 8);
                    this.A02 = 1;
                } else {
                    throw new C3K(A0B(259, 49, 17));
                }
            } else if (this.A07 <= 2147483647L) {
                this.A0E = null;
                this.A02 = 1;
            } else {
                throw new C3K(A0B(497, 53, 12));
            }
            return true;
        }
        throw new C3K(A0B(2, 48, 125));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02bb  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0a(com.facebook.ads.redexgen.core.InterfaceC2516ms r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2480m6.A0a(com.facebook.ads.redexgen.X.ms):boolean");
    }

    public static /* synthetic */ H9[] A0b() {
        return new H9[]{new C2480m6()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A0F = ha;
        if (this.A0W != null) {
            J7 j7 = new J7(ha.AKS(0, this.A0W.A03));
            j7.A08(this.A0W, new J1(0, 0, 0, 0));
            this.A0D.put(0, j7);
            A0D();
            this.A0F.A6O();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        while (true) {
            int i = this.A02;
            if (A0f[0].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[3] = "yYIiClYY3RZS73RDJ5vLPk2bDdZFXU";
            strArr[6] = "bGm4sUzBrXbQjG5ES";
            switch (i) {
                case 0:
                    if (!A0Z(interfaceC2516ms)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0N(interfaceC2516ms);
                    break;
                case 2:
                    A0O(interfaceC2516ms);
                    break;
                default:
                    if (A0a(interfaceC2516ms)) {
                        return 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j, long j2) {
        int size = this.A0D.size();
        for (int i = 0; i < size; i++) {
            this.A0D.valueAt(i).A05();
        }
        this.A0Y.clear();
        this.A03 = 0;
        this.A0B = j2;
        this.A0X.clear();
        this.A0I = false;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC2516ms interfaceC2516ms) throws IOException {
        return JM.A01(interfaceC2516ms);
    }
}
