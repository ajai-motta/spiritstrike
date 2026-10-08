package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.extractor.mp4.Atom;
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

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Rename the class for A/B Testing")
public final class C2481m7 implements H9 {
    public static byte[] A0Z;
    public static String[] A0a = {"vtb", "vbKonC", "9ohrxt3rIVPnhyMUHrYVmyK7bOK5FZ2r", "2NigTWH0ge82u7sbUdSeL8Wtj6iQtHIS", "zZrcpvCeqeJUqHmK3YGTET67EQVL4Dlr", "FEfAuyU", "TXQt6Bb5wsq1E0rpiydPRGzBJonmO6nW", "L3NiJ083BoYvWzKRwautviQbODBNEwGW"};
    public static final HD A0b;
    public static final C2725qI A0c;
    public static final byte[] A0d;
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

    @MetaExoPlayerCustomization("New field")
    public long A0A;
    public long A0B;
    public long A0C;
    public C09724v A0D;
    public HA A0E;
    public JA A0F;
    public boolean A0G;
    public boolean A0H;
    public InterfaceC1272Hd[] A0I;
    public InterfaceC1272Hd[] A0J;
    public final int A0K;
    public final SparseArray<JA> A0L;
    public final C09724v A0M;
    public final C09724v A0N;
    public final C09724v A0O;
    public final C09724v A0P;
    public final C09724v A0Q;
    public final AnonymousClass53 A0R;
    public final InterfaceC1272Hd A0S;
    public final I0 A0T;
    public final JO A0U;
    public final ArrayDeque<C2488mE> A0V;
    public final ArrayDeque<J9> A0W;
    public final List<C2725qI> A0X;
    public final byte[] A0Y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A01(JA ja, int i, int i2, C09724v c09724v, int i3) throws C3K {
        int iA0C;
        int i4 = i3;
        c09724v.A0f(8);
        int iA00 = AbstractC1314Iu.A00(c09724v.A0C());
        JO jo = ja.A05.A03;
        JQ jq = ja.A09;
        J1 j1 = (J1) C5C.A0f(jq.A06);
        jq.A0C[i] = c09724v.A0L();
        jq.A0E[i] = jq.A04;
        if ((iA00 & 1) != 0) {
            long[] jArr = jq.A0E;
            jArr[i] = jArr[i] + ((long) c09724v.A0C());
        }
        boolean z = (iA00 & 4) != 0;
        int iA0C2 = j1.A01;
        if (z) {
            iA0C2 = c09724v.A0C();
        }
        boolean z2 = (iA00 & 256) != 0;
        boolean z3 = (iA00 & 512) != 0;
        boolean z4 = (iA00 & 1024) != 0;
        boolean z5 = (iA00 & 2048) != 0;
        long j = A0a(jo) ? ((long[]) C5C.A0f(jo.A09))[0] : 0L;
        int[] iArr = jq.A0B;
        long[] jArr2 = jq.A0D;
        boolean[] zArr = jq.A0G;
        boolean z6 = jo.A03 == 2 && (i2 & 1) != 0;
        int i5 = i4 + jq.A0C[i];
        long j2 = jo.A06;
        long j3 = jq.A05;
        while (i4 < i5) {
            if (z2) {
                iA0C = c09724v.A0C();
                if (A0a[5].length() == 30) {
                    throw new RuntimeException();
                }
                A0a[0] = "Vvd";
            } else {
                iA0C = j1.A00;
            }
            int iA002 = A00(iA0C);
            int iA003 = A00(z3 ? c09724v.A0C() : j1.A03);
            int iA0C3 = z4 ? c09724v.A0C() : (i4 == 0 && z) ? iA0C2 : j1.A01;
            jArr2[i4] = C5C.A0U((((long) (z5 ? c09724v.A0C() : 0)) + j3) - j, 1000000L, j2);
            if (!jq.A09) {
                jArr2[i4] = jArr2[i4] + ja.A05.A02;
            }
            iArr[i4] = iA003;
            zArr[i4] = ((iA0C3 >> 16) & 1) == 0 && (!z6 || i4 == 0);
            j3 += (long) iA002;
            i4++;
        }
        jq.A05 = j3;
        return i5;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, C2521my> A05(C09724v c09724v, long j) throws C3K {
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
                throw C3K.A01(A0A(756, 28, 79), null);
            }
            long jA0Q2 = c09724v.A0Q();
            iArr[i] = Integer.MAX_VALUE & iA0C;
            jArr[i] = jA0R2;
            jArr3[i] = jA0U2;
            jA0R += jA0Q2;
            jA0U2 = C5C.A0U(jA0R, 1000000L, jA0Q);
            jArr2[i] = jA0U2 - jArr3[i];
            c09724v.A0g(4);
            jA0R2 += (long) iArr[i];
        }
        return Pair.create(Long.valueOf(jA0U), new C2521my(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JA A09(C09724v c09724v, SparseArray<JA> sparseArray, boolean z) {
        c09724v.A0f(8);
        int iA00 = AbstractC1314Iu.A00(c09724v.A0C());
        JA jaValueAt = z ? sparseArray.valueAt(0) : sparseArray.get(c09724v.A0C());
        if (jaValueAt == null) {
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[1] = "jDobgNhtM";
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0R = c09724v.A0R();
            jaValueAt.A09.A04 = jA0R;
            jaValueAt.A09.A03 = jA0R;
        }
        J1 j1 = jaValueAt.A04;
        jaValueAt.A09.A06 = new J1((iA00 & 2) != 0 ? c09724v.A0C() - 1 : j1.A02, (iA00 & 8) != 0 ? c09724v.A0C() : j1.A00, (iA00 & 16) != 0 ? c09724v.A0C() : j1.A03, (iA00 & 32) != 0 ? c09724v.A0C() : j1.A01);
        return jaValueAt;
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Z, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[5] = "p0M5dFs6dnHIC4r2oiX9lIp2";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
            i4++;
        }
    }

    public static void A0D() {
        A0Z = new byte[]{8, 65, 91, 8, 76, 65, 78, 78, 77, 90, 77, 70, 92, 8, 78, 90, 71, 69, 8, 78, 90, 73, 79, 69, 77, 70, 92, 8, 91, 73, 69, 88, 68, 77, 8, 75, 71, 93, 70, 92, 109, 36, 62, 109, 42, 63, 40, 44, 57, 40, 63, 109, 57, 37, 44, 35, 109, 43, 63, 44, 42, 32, 40, 35, 57, 109, 62, 44, 32, Base64.padSymbol, 33, 40, 109, 46, 34, 56, 35, 57, 47, Ascii.SUB, 1, 3, 78, Ascii.GS, 7, Ascii.DC4, Ascii.VT, 78, 2, Ascii.VT, Ascii.GS, Ascii.GS, 78, Ascii.SUB, 6, Ascii.SI, 0, 78, 6, Ascii.VT, Ascii.SI, 10, Ascii.VT, Ascii.FS, 78, 2, Ascii.VT, 0, 9, Ascii.SUB, 6, 78, 70, Ascii.ESC, 0, Ascii.GS, Ascii.ESC, Ascii.RS, Ascii.RS, 1, Ascii.FS, Ascii.SUB, Ascii.VT, 10, 71, SignedBytes.MAX_POWER_OF_TWO, 70, 109, 119, 113, 122, 35, 96, 108, 118, 109, 119, 35, 106, 109, 35, 112, 97, 100, 115, 35, 34, 62, 35, 50, 35, 43, 118, 109, 112, 118, 115, 115, 108, 113, 119, 102, 103, 42, 45, Ascii.GS, 54, 44, 42, 33, 120, 59, 55, 45, 54, 44, 120, 49, 54, 120, 43, 63, 40, 60, 120, 121, 101, 120, 105, 120, 112, 45, 54, 43, 45, 40, 40, 55, 42, 44, Base64.padSymbol, 60, 113, 118, 71, 115, 96, 102, 108, 100, 111, 117, 100, 101, 76, 113, 53, 68, 121, 117, 115, 96, 98, 117, 110, 115, Ascii.SO, 32, 41, 40, 53, 46, 41, 32, 103, 41, 34, 32, 38, 51, 46, 49, 34, 103, 40, 33, 33, 52, 34, 51, 103, 51, 40, 103, 52, 38, 42, 55, 43, 34, 103, 35, 38, 51, 38, 105, 118, 81, 73, 94, 83, 86, 91, Ascii.US, 113, 126, 115, Ascii.US, 83, 90, 81, 88, 75, 87, 0, 41, 45, 42, 108, 45, 56, 35, 33, 108, 40, 41, 42, 37, 34, 41, 63, 108, 41, 52, 56, 41, 34, 40, 41, 40, 108, 45, 56, 35, 33, 108, 63, 37, 54, 41, 108, 100, 57, 34, 63, 57, 60, 60, 35, 62, 56, 41, 40, 101, 98, 75, 98, 102, 97, 39, 102, 115, 104, 106, 39, 112, 110, 115, 111, 39, 107, 98, 105, 96, 115, 111, 39, 57, 39, 53, 54, 51, 48, 51, 63, 52, 49, 51, 48, 39, 47, 114, 105, 116, 114, 119, 119, 104, 117, 115, 98, 99, 46, 41, 62, Ascii.ETB, Ascii.ETB, 2, Ascii.DC4, 5, 81, 5, Ascii.RS, 81, Ascii.DC4, Ascii.US, Ascii.DC2, 3, 8, 1, 5, Ascii.CAN, Ascii.RS, Ascii.US, 81, Ascii.NAK, Ascii.DLE, 5, Ascii.DLE, 81, 6, Ascii.DLE, 2, 81, Ascii.US, Ascii.DC4, Ascii.SYN, Ascii.DLE, 5, Ascii.CAN, 7, Ascii.DC4, 95, 120, 81, 81, 68, 82, 67, Ascii.ETB, 67, 88, Ascii.ETB, 82, 89, 83, Ascii.ETB, 88, 81, Ascii.ETB, 90, 83, 86, 67, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 86, 68, Ascii.ETB, 89, 82, 80, 86, 67, 94, 65, 82, Ascii.EM, Ascii.ESC, 34, 49, 38, 38, Base64.padSymbol, 48, Base64.padSymbol, 58, 51, 116, 0, 38, 53, 55, 63, 17, 58, 55, 38, 45, 36, 32, Base64.padSymbol, 59, 58, Ascii.SYN, 59, 44, 116, 36, 53, 38, 53, 57, 49, 32, 49, 38, 39, 116, Base64.padSymbol, 39, 116, 33, 58, 39, 33, 36, 36, 59, 38, 32, 49, 48, 122, 35, 17, Ascii.EM, 10, 80, 3, 17, Ascii.GS, 0, Ascii.FS, Ascii.NAK, 80, 19, Ascii.US, 5, Ascii.RS, 4, 80, 70, 112, 123, 118, 53, 102, 116, 120, 101, 121, 112, 53, 118, 122, 96, 123, 97, 53, 5, Base64.padSymbol, 63, 38, 38, 51, 50, 118, 38, 37, 37, 62, 118, 55, 34, 57, 59, 118, 126, 48, 55, 63, 58, 51, 50, 118, 34, 57, 118, 51, 46, 34, 36, 55, 53, 34, 118, 35, 35, 63, 50, 127, 78, 118, 116, 109, 109, 116, 115, 122, Base64.padSymbol, 124, 105, 114, 112, Base64.padSymbol, 106, 116, 105, 117, Base64.padSymbol, 113, 120, 115, 122, 105, 117, Base64.padSymbol, 35, Base64.padSymbol, 47, 44, 41, 42, 41, 37, 46, 43, 41, 42, Base64.padSymbol, 53, 104, 115, 110, 104, 109, 109, 114, 111, 105, 120, 121, 52, 51, 1, 57, 59, 34, 34, 59, 60, 53, 114, 39, 60, 33, 39, 34, 34, Base64.padSymbol, 32, 38, 55, 54, 114, 55, 63, 33, 53, 114, 36, 55, 32, 33, 59, Base64.padSymbol, 60, 104, 114, Ascii.ETB, 44, 39, 58, 50, 39, 33, 54, 39, 38, 98, 47, 45, 45, 52, 98, 32, 45, 58, 108, 92, 103, 108, 113, 121, 108, 106, 125, 108, 109, 41, 103, 108, 110, 104, 125, 96, 127, 108, 41, 127, 104, 101, 124, 108, 51, 41, 35, Ascii.CAN, 19, Ascii.SO, 6, 19, Ascii.NAK, 2, 19, Ascii.DC2, 86, 5, Ascii.ETB, Ascii.US, Ascii.EM, 86, 19, Ascii.CAN, 2, 4, Ascii.SI, 86, Ascii.NAK, Ascii.EM, 3, Ascii.CAN, 2, 76, 86, 80, 107, 109, 100, 107, 97, 105, 96, 97, 37, 108, 107, 97, 108, 119, 96, 102, 113, 37, 119, 96, 99, 96, 119, 96, 107, 102, 96, 114, 69, 86, 77, 69, 70, 72, 65, 4, 72, 65, 74, 67, 80, 76, 4, SignedBytes.MAX_POWER_OF_TWO, 65, 87, 71, 86, 77, 84, 80, 77, 75, 74, 4, 77, 74, 4, 87, 67, 84, SignedBytes.MAX_POWER_OF_TWO, 4, 66, 75, 81, 74, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.FF, 81, 74, 87, 81, 84, 84, 75, 86, 80, 65, SignedBytes.MAX_POWER_OF_TWO, Ascii.CR, 102, 119, 119, 107, 110, 100, 102, 115, 110, 104, 105, 40, 127, 42, 98, 106, 116, 96, 88, 73, 73, 85, 80, 90, 88, 77, 80, 86, 87, Ascii.SYN, 65, Ascii.DC4, 84, 73, Ascii.CR, Ascii.DC4, 79, 77, 77, 52, 32, 49, 60, 58, 122, 52, 54, 97, 72, 87, 90, 91, 81, 17, 86, 91, 72, 93, 126, 97, 108, 109, 103, 39, 101, 120, 60};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Adding Uri for eMsg")
    private void A0H(C09724v c09724v, Uri uri) {
        String str;
        String str2;
        long jA0U;
        long jA0Q;
        if (this.A0J.length == 0) {
            return;
        }
        c09724v.A0f(8);
        if (A0a[3].charAt(19) != 'e') {
            throw new RuntimeException();
        }
        A0a[1] = "i2btDlVidn";
        int iA01 = AbstractC1314Iu.A01(c09724v.A0C());
        long jA0U2 = C.TIME_UNSET;
        long jA05 = C.TIME_UNSET;
        switch (iA01) {
            case 0:
                str = (String) AbstractC09493y.A01(c09724v.A0U());
                str2 = (String) AbstractC09493y.A01(c09724v.A0U());
                long jA0Q2 = c09724v.A0Q();
                jA0U2 = C5C.A0U(c09724v.A0Q(), 1000000L, jA0Q2);
                if (this.A0C != C.TIME_UNSET) {
                    jA05 = this.A0C + jA0U2;
                }
                jA0U = C5C.A0U(c09724v.A0Q(), 1000L, jA0Q2);
                jA0Q = c09724v.A0Q();
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
                AbstractC09574g.A07(A0A(204, 22, 75), A0A(645, 35, 24) + iA01);
                return;
        }
        byte[] bArr = new byte[c09724v.A07()];
        c09724v.A0k(bArr, 0, c09724v.A07());
        int i = 0;
        C09724v c09724v2 = new C09724v(this.A0T.A01(new EventMessage(str, str2, jA0U, jA0Q, bArr)));
        int iA07 = c09724v2.A07();
        InterfaceC1272Hd[] interfaceC1272HdArr = this.A0J;
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
            this.A0W.addLast(new J9(jA0U2, true, iA07));
            this.A03 += iA07;
            return;
        }
        if (!this.A0W.isEmpty()) {
            this.A0W.addLast(new J9(jA05, false, iA07));
            this.A03 += iA07;
            return;
        }
        if (this.A0R != null) {
            AnonymousClass53 anonymousClass53 = this.A0R;
            if (A0a[1].length() != 3) {
                String[] strArr = A0a;
                strArr[4] = "dSij3ZZr7drragDO7KaW8OWZIZwByPGb";
                strArr[6] = "O4MuDOrrUt3KGtyHElmFzP2mmpN9Ut0I";
                jA05 = anonymousClass53.A05(jA05);
            } else {
                jA05 = anonymousClass53.A05(jA05);
            }
        }
        if (this.A0A != C.TIME_UNSET && !MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A11)) {
            jA05 = this.A0A;
        }
        InterfaceC1272Hd[] interfaceC1272HdArr2 = this.A0J;
        if (A0a[0].length() != 3) {
            throw new RuntimeException();
        }
        A0a[2] = "lJ55r5gDB38Ao7rNsYIhv4IUy3LH5Ini";
        for (InterfaceC1272Hd interfaceC1272Hd2 : interfaceC1272HdArr2) {
            interfaceC1272Hd2.AIu(jA05, 1, iA07, 0, null);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0R(C2488mE c2488mE, SparseArray<JA> sparseArray, boolean z, int i, byte[] bArr) throws C3K {
        JA jaA09 = A09(((C2487mD) AbstractC09493y.A01(c2488mE.A07(Atom.TYPE_tfhd))).A00, sparseArray, z);
        if (jaA09 == null) {
            return;
        }
        JQ jq = jaA09.A09;
        long j = jq.A05;
        boolean z2 = jq.A09;
        jaA09.A08();
        jaA09.A06 = true;
        C2487mD c2487mDA07 = c2488mE.A07(Atom.TYPE_tfdt);
        if (c2487mDA07 == null || (i & 2) != 0) {
            jq.A05 = j;
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[7] = "mrSj0GzHTHwkPK2z0oCyoB4jTU17nK7M";
            jq.A09 = z2;
        } else {
            jq.A05 = A03(c2487mDA07.A00);
            jq.A09 = true;
        }
        A0S(c2488mE, jaA09, i);
        JO jo = jaA09.A05.A03;
        Object objA01 = AbstractC09493y.A01(jq.A06);
        String[] strArr2 = A0a;
        if (strArr2[4].charAt(20) == strArr2[6].charAt(20)) {
            throw new RuntimeException();
        }
        A0a[1] = "vW8YzoDO1k8YQphW8Ysx";
        JP jpA00 = jo.A00(((J1) objA01).A02);
        C2487mD c2487mDA072 = c2488mE.A07(Atom.TYPE_saiz);
        if (c2487mDA072 != null) {
            A0V((JP) AbstractC09493y.A01(jpA00), c2487mDA072.A00, jq);
        }
        C2487mD c2487mDA073 = c2488mE.A07(Atom.TYPE_saio);
        if (c2487mDA073 != null) {
            A0I(c2487mDA073.A00, jq);
        }
        C2487mD c2487mDA074 = c2488mE.A07(Atom.TYPE_senc);
        if (c2487mDA074 != null) {
            A0J(c2487mDA074.A00, jq);
        }
        A0T(c2488mE, jpA00 != null ? jpA00.A02 : null, jq);
        int size = c2488mE.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2487mD c2487mD = c2488mE.A02.get(i2);
            if (((AbstractC1314Iu) c2487mD).A00 == 1970628964) {
                A0K(c2487mD.A00, jq, bArr);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0T(C2488mE c2488mE, String str, JQ jq) throws C3K {
        C09724v c09724v = null;
        C09724v c09724v2 = null;
        for (int i = 0; i < c2488mE.A02.size(); i++) {
            C2487mD c2487mD = c2488mE.A02.get(i);
            C09724v c09724v3 = c2487mD.A00;
            if (((AbstractC1314Iu) c2487mD).A00 == 1935828848) {
                c09724v3.A0f(12);
                if (c09724v3.A0C() == 1936025959) {
                    c09724v = c09724v3;
                }
            } else if (((AbstractC1314Iu) c2487mD).A00 == 1936158820) {
                c09724v3.A0f(12);
                if (c09724v3.A0C() == 1936025959) {
                    c09724v2 = c09724v3;
                }
            }
        }
        if (c09724v == null || c09724v2 == null) {
            return;
        }
        c09724v.A0f(8);
        int iA01 = AbstractC1314Iu.A01(c09724v.A0C());
        c09724v.A0g(4);
        if (iA01 == 1) {
            c09724v.A0g(4);
        }
        if (c09724v.A0C() != 1) {
            throw C3K.A00(A0A(126, 39, 73));
        }
        c09724v2.A0f(8);
        int iA012 = AbstractC1314Iu.A01(c09724v2.A0C());
        c09724v2.A0g(4);
        if (iA012 == 1) {
            if (c09724v2.A0Q() == 0) {
                throw C3K.A00(A0A(784, 55, 110));
            }
        } else if (iA012 >= 2) {
            c09724v2.A0g(4);
        }
        if (c09724v2.A0Q() != 1) {
            throw C3K.A00(A0A(165, 39, 18));
        }
        c09724v2.A0g(1);
        int iA0I = c09724v2.A0I();
        int i2 = (iA0I & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        int i3 = iA0I & 15;
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
            jq.A07 = new JP(z, str, iA0I2, bArr, i2, i3, bArr2);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0V(JP jp, C09724v c09724v, JQ jq) throws C3K {
        int i = jp.A00;
        c09724v.A0f(8);
        if ((AbstractC1314Iu.A00(c09724v.A0C()) & 1) == 1) {
            c09724v.A0g(8);
        }
        int iA0I = c09724v.A0I();
        int iA0L = c09724v.A0L();
        if (iA0L > jq.A00) {
            throw C3K.A01(A0A(514, 18, 58) + iA0L + A0A(40, 38, 7) + jq.A00, null);
        }
        int i2 = 0;
        if (iA0I == 0) {
            boolean[] zArr = jq.A0F;
            if (A0a[1].length() == 3) {
                throw new RuntimeException();
            }
            A0a[0] = "ACu";
            for (int i3 = 0; i3 < iA0L; i3++) {
                int iA0I2 = c09724v.A0I();
                i2 += iA0I2;
                zArr[i3] = iA0I2 > i;
            }
        } else {
            i2 = 0 + (iA0I * iA0L);
            Arrays.fill(jq.A0F, 0, iA0L, iA0I > i);
        }
        Arrays.fill(jq.A0F, iA0L, jq.A00, false);
        if (i2 > 0) {
            jq.A02(i2);
        }
    }

    static {
        A0D();
        A0b = new HD() { // from class: com.facebook.ads.redexgen.X.m8
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C2481m7.A0b();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A0d = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        A0c = new C09162p().A11(A0A(839, 18, 77)).A14();
    }

    public C2481m7() {
        this(0);
    }

    public C2481m7(int i) {
        this(i, null);
    }

    public C2481m7(int i, AnonymousClass53 anonymousClass53) {
        this(i, anonymousClass53, null, Collections.emptyList());
    }

    public C2481m7(int i, AnonymousClass53 anonymousClass53, JO jo, List<C2725qI> list) {
        this(i, anonymousClass53, jo, list, null);
    }

    @MetaExoPlayerCustomization("Additional fields for custom behaviors")
    public C2481m7(int i, AnonymousClass53 anonymousClass53, JO jo, List<C2725qI> list, InterfaceC1272Hd interfaceC1272Hd) {
        this.A0A = C.TIME_UNSET;
        this.A0K = i;
        this.A0R = anonymousClass53;
        this.A0U = jo;
        this.A0X = Collections.unmodifiableList(list);
        this.A0S = interfaceC1272Hd;
        this.A0T = new I0();
        this.A0M = new C09724v(16);
        this.A0P = new C09724v(HS.A03);
        this.A0O = new C09724v(5);
        this.A0N = new C09724v();
        this.A0Y = new byte[16];
        this.A0Q = new C09724v(this.A0Y);
        this.A0V = new ArrayDeque<>();
        this.A0W = new ArrayDeque<>();
        this.A0L = new SparseArray<>();
        this.A08 = C.TIME_UNSET;
        this.A0B = C.TIME_UNSET;
        this.A0C = C.TIME_UNSET;
        this.A0E = HA.A00;
        this.A0J = new InterfaceC1272Hd[0];
        this.A0I = new InterfaceC1272Hd[0];
    }

    public static int A00(int i) throws C3K {
        if (i >= 0) {
            return i;
        }
        throw C3K.A01(A0A(TypedValues.TransitionType.TYPE_DURATION, 27, 67) + i, null);
    }

    public static long A02(C09724v c09724v) {
        c09724v.A0f(8);
        int fullAtom = c09724v.A0C();
        return AbstractC1314Iu.A01(fullAtom) == 0 ? c09724v.A0Q() : c09724v.A0R();
    }

    public static long A03(C09724v c09724v) {
        c09724v.A0f(8);
        int fullAtom = c09724v.A0C();
        int version = AbstractC1314Iu.A01(fullAtom);
        return version == 1 ? c09724v.A0R() : c09724v.A0Q();
    }

    public static Pair<Integer, J1> A04(C09724v c09724v) {
        c09724v.A0f(12);
        int defaultSampleDescriptionIndex = c09724v.A0C();
        int trackId = c09724v.A0C();
        int defaultSampleFlags = c09724v.A0C();
        int defaultSampleSize = c09724v.A0C();
        int defaultSampleDuration = c09724v.A0C();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new J1(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A06(List<C2487mD> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2487mD c2487mD = list.get(i);
            int leafChildrenSize = ((AbstractC1314Iu) c2487mD).A00;
            if (leafChildrenSize == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrA0l = c2487mD.A00.A0l();
                UUID uuidA02 = JH.A02(bArrA0l);
                if (uuidA02 == null) {
                    AbstractC09574g.A07(A0A(204, 22, 75), A0A(550, 42, 28));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA02, A0A(897, 9, 66), bArrA0l));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private J1 A07(SparseArray<J1> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (J1) AbstractC09493y.A01(sparseArray.get(i));
    }

    public static JA A08(SparseArray<JA> sparseArray) {
        JA ja = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            JA jaValueAt = sparseArray.valueAt(i);
            if (jaValueAt.A06 || jaValueAt.A01 != jaValueAt.A05.A01) {
                boolean z = jaValueAt.A06;
                if (A0a[7].charAt(28) == 'N') {
                    throw new RuntimeException();
                }
                A0a[2] = "bWFL5LbHycaN2QeAwKakifUxbxentXmn";
                if (!z || jaValueAt.A02 != jaValueAt.A09.A01) {
                    long nextSampleOffset = jaValueAt.A05();
                    if (nextSampleOffset < j) {
                        ja = jaValueAt;
                        j = nextSampleOffset;
                    }
                }
            }
        }
        return ja;
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C() {
        /*
            r7 = this;
            r5 = 100
            r0 = 2
            com.facebook.ads.redexgen.X.Hd[] r0 = new com.facebook.ads.redexgen.core.InterfaceC1272Hd[r0]
            r7.A0J = r0
            r6 = 0
            com.facebook.ads.redexgen.X.Hd r0 = r7.A0S
            if (r0 == 0) goto L15
            com.facebook.ads.redexgen.X.Hd[] r2 = r7.A0J
            int r1 = r6 + 1
            com.facebook.ads.redexgen.X.Hd r0 = r7.A0S
            r2[r6] = r0
            r6 = r1
        L15:
            int r0 = r7.A0K
            r0 = r0 & 4
            if (r0 == 0) goto L2c
            com.facebook.ads.redexgen.X.Hd[] r4 = r7.A0J
            int r3 = r6 + 1
            com.facebook.ads.redexgen.X.HA r2 = r7.A0E
            int r1 = r5 + 1
            r0 = 5
            com.facebook.ads.redexgen.X.Hd r0 = r2.AKS(r5, r0)
            r4[r6] = r0
            r6 = r3
            r5 = r1
        L2c:
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A0J
            java.lang.Object[] r0 = com.facebook.ads.redexgen.core.C5C.A1I(r0, r6)
            com.facebook.ads.redexgen.X.Hd[] r0 = (com.facebook.ads.redexgen.core.InterfaceC1272Hd[]) r0
            r7.A0J = r0
            com.facebook.ads.redexgen.X.Hd[] r4 = r7.A0J
            int r3 = r4.length
            r2 = 0
        L3a:
            if (r2 >= r3) goto L46
            r1 = r4[r2]
            com.facebook.ads.redexgen.X.qI r0 = com.facebook.ads.redexgen.core.C2481m7.A0c
            r1.A6e(r0)
            int r2 = r2 + 1
            goto L3a
        L46:
            java.util.List<com.facebook.ads.redexgen.X.qI> r0 = r7.A0X
            int r0 = r0.size()
            com.facebook.ads.redexgen.X.Hd[] r0 = new com.facebook.ads.redexgen.core.InterfaceC1272Hd[r0]
            r7.A0I = r0
            r3 = 0
        L51:
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A0I
            int r0 = r0.length
            if (r3 >= r0) goto L72
            com.facebook.ads.redexgen.X.HA r1 = r7.A0E
            int r2 = r5 + 1
            r0 = 3
            com.facebook.ads.redexgen.X.Hd r1 = r1.AKS(r5, r0)
            java.util.List<com.facebook.ads.redexgen.X.qI> r0 = r7.A0X
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.qI r0 = (com.facebook.ads.redexgen.core.C2725qI) r0
            r1.A6e(r0)
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A0I
            r0[r3] = r1
            int r3 = r3 + 1
            r5 = r2
            goto L51
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2481m7.A0C():void");
    }

    private void A0E(long j) {
        while (!this.A0W.isEmpty()) {
            J9 j9RemoveFirst = this.A0W.removeFirst();
            this.A03 -= j9RemoveFirst.A00;
            if (A0a[7].charAt(28) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A0a;
            strArr[4] = "VR2FeNKrGWLUx6XQMfWHox9ZNtks2zuu";
            strArr[6] = "s2y9CEVkGFcMGmJDsuNOnRFQ2pMNKAx2";
            long jA05 = j9RemoveFirst.A01;
            if (j9RemoveFirst.A02) {
                jA05 += j;
            }
            if (this.A0R != null) {
                jA05 = this.A0R.A05(jA05);
            }
            for (InterfaceC1272Hd interfaceC1272Hd : this.A0J) {
                interfaceC1272Hd.AIu(jA05, 1, j9RemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0F(long j) throws C3K {
        while (!this.A0V.isEmpty() && this.A0V.peek().A00 == j) {
            A0N(this.A0V.pop());
        }
        A0B();
    }

    public static void A0G(C09724v c09724v, int i, JQ jq) throws C3K {
        c09724v.A0f(i + 8);
        int fullAtom = c09724v.A0C();
        int flags = AbstractC1314Iu.A00(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z = fullAtom3 != 0;
            int sampleCount = c09724v.A0L();
            if (sampleCount == 0) {
                boolean[] zArr = jq.A0F;
                int fullAtom4 = jq.A00;
                Arrays.fill(zArr, 0, fullAtom4, false);
                return;
            }
            int fullAtom5 = jq.A00;
            if (sampleCount == fullAtom5) {
                Arrays.fill(jq.A0F, 0, sampleCount, z);
                int fullAtom6 = c09724v.A07();
                jq.A02(fullAtom6);
                jq.A04(c09724v);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append(A0A(532, 18, 95)).append(sampleCount).append(A0A(0, 40, 98));
            int fullAtom7 = jq.A00;
            throw C3K.A01(sbAppend.append(fullAtom7).toString(), null);
        }
        throw C3K.A00(A0A(FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 56, 30));
    }

    public static void A0I(C09724v c09724v, JQ jq) throws C3K {
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
        throw C3K.A01(A0A(727, 29, 60) + iA0L, null);
    }

    public static void A0J(C09724v c09724v, JQ jq) throws C3K {
        A0G(c09724v, 0, jq);
    }

    public static void A0K(C09724v c09724v, JQ jq, byte[] bArr) throws C3K {
        c09724v.A0f(8);
        c09724v.A0k(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0d)) {
            return;
        }
        A0G(c09724v, 16, jq);
    }

    @MetaExoPlayerCustomization("New parameter for getUri()")
    private void A0L(InterfaceC2516ms interfaceC2516ms) throws IOException {
        int i = ((int) this.A07) - this.A00;
        C09724v c09724v = this.A0D;
        if (c09724v != null) {
            interfaceC2516ms.readFully(c09724v.A0l(), 8, i);
            A0U(new C2487mD(this.A01, c09724v), interfaceC2516ms.A8n(), interfaceC2516ms.A9P());
        } else {
            interfaceC2516ms.AK3(i);
        }
        A0F(interfaceC2516ms.A8n());
    }

    private void A0M(InterfaceC2516ms interfaceC2516ms) throws IOException {
        JA jaValueAt = null;
        long j = Long.MAX_VALUE;
        int size = this.A0L.size();
        for (int i = 0; i < size; i++) {
            JA nextTrackBundle = this.A0L.valueAt(i);
            JQ jq = nextTrackBundle.A09;
            if (jq.A0A && jq.A03 < j) {
                j = jq.A03;
                jaValueAt = this.A0L.valueAt(i);
            }
        }
        if (jaValueAt == null) {
            this.A02 = 3;
            return;
        }
        int iA8n = (int) (j - interfaceC2516ms.A8n());
        if (iA8n >= 0) {
            interfaceC2516ms.AK3(iA8n);
            jaValueAt.A09.A05(interfaceC2516ms);
            return;
        }
        throw C3K.A01(A0A(RendererCapabilities.MODE_SUPPORT_MASK, 39, 59), null);
    }

    private void A0N(C2488mE c2488mE) throws C3K {
        if (((AbstractC1314Iu) c2488mE).A00 == 1836019574) {
            A0P(c2488mE);
            return;
        }
        if (((AbstractC1314Iu) c2488mE).A00 == 1836019558) {
            A0O(c2488mE);
            return;
        }
        if (this.A0V.isEmpty()) {
            return;
        }
        C2488mE c2488mEPeek = this.A0V.peek();
        if (A0a[1].length() == 3) {
            throw new RuntimeException();
        }
        A0a[5] = "pjYwVuiFyV8fJrHeJXv5AlOqs";
        c2488mEPeek.A08(c2488mE);
    }

    private void A0O(C2488mE c2488mE) throws C3K {
        A0Q(c2488mE, this.A0L, this.A0U != null, this.A0K, this.A0Y);
        DrmInitData drmInitDataA06 = A06(c2488mE.A02);
        if (drmInitDataA06 != null) {
            int i = this.A0L.size();
            for (int trackCount = 0; trackCount < i; trackCount++) {
                this.A0L.valueAt(trackCount).A0B(drmInitDataA06);
            }
        }
        long j = this.A0B;
        if (A0a[5].length() != 30) {
            String[] strArr = A0a;
            strArr[4] = "qdUBZHhFhQeTbxiPtlDH0srS7WoJbCtx";
            strArr[6] = "eg1L367OGrFS41anHFQFHM93YBMqVnGW";
            if (j != C.TIME_UNSET) {
                int size = this.A0L.size();
                for (int i2 = 0; i2 < size; i2++) {
                    JA jaValueAt = this.A0L.valueAt(i2);
                    long j2 = this.A0B;
                    int trackCount2 = A0a[5].length();
                    if (trackCount2 != 30) {
                        A0a[3] = "ExaTttTG7QLu5ZnLvMbeVx0ab4jt6cU8";
                        jaValueAt.A0A(j2);
                    }
                }
                this.A0B = C.TIME_UNSET;
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0P(C2488mE c2488mE) throws C3K {
        AbstractC09493y.A0A(this.A0U == null, A0A(680, 20, 8));
        DrmInitData drmInitDataA06 = A06(c2488mE.A02);
        C2488mE c2488mE2 = (C2488mE) AbstractC09493y.A01(c2488mE.A06(Atom.TYPE_mvex));
        SparseArray<J1> sparseArray = new SparseArray<>();
        long jA02 = C.TIME_UNSET;
        int size = c2488mE2.A02.size();
        for (int i = 0; i < size; i++) {
            C2487mD c2487mD = c2488mE2.A02.get(i);
            if (((AbstractC1314Iu) c2487mD).A00 == 1953654136) {
                Pair<Integer, J1> pairA04 = A04(c2487mD.A00);
                Object obj = pairA04.first;
                if (A0a[7].charAt(28) == 'N') {
                    throw new RuntimeException();
                }
                A0a[2] = "1hJqa9Igz9YM2Xn7uSuVVZMPlDpSi7YR";
                sparseArray.put(((Integer) obj).intValue(), (J1) pairA04.second);
            } else if (((AbstractC1314Iu) c2487mD).A00 == 1835362404) {
                jA02 = A02(c2487mD.A00);
            }
        }
        List<JR> listA0O = J0.A0O(c2488mE, new HK(), jA02, drmInitDataA06, (this.A0K & 16) != 0, false, new InterfaceC2376kO() { // from class: com.facebook.ads.redexgen.X.m9
            @Override // com.facebook.ads.redexgen.core.InterfaceC2376kO
            public final Object A4B(Object obj2) {
                return this.A00.A0c((JO) obj2);
            }
        });
        int size2 = listA0O.size();
        if (this.A0L.size() == 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                JR jr = listA0O.get(i2);
                JO jo = jr.A03;
                this.A0L.put(jo.A00, new JA(this.A0E.AKS(i2, jo.A03), jr, A07(sparseArray, jo.A00)));
                this.A08 = Math.max(this.A08, jo.A04);
            }
            this.A0E.A6O();
            return;
        }
        AbstractC09493y.A08(this.A0L.size() == size2);
        for (int i3 = 0; i3 < size2; i3++) {
            JR jr2 = listA0O.get(i3);
            JO jo2 = jr2.A03;
            this.A0L.get(jo2.A00).A0C(jr2, A07(sparseArray, jo2.A00));
        }
    }

    public static void A0Q(C2488mE c2488mE, SparseArray<JA> sparseArray, boolean z, int i, byte[] bArr) throws C3K {
        int size = c2488mE.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2488mE child = c2488mE.A01.get(i2);
            int i3 = ((AbstractC1314Iu) child).A00;
            if (i3 == 1953653094) {
                A0R(child, sparseArray, z, i, bArr);
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0S(com.facebook.ads.redexgen.core.C2488mE r8, com.facebook.ads.redexgen.core.JA r9, int r10) throws com.facebook.ads.redexgen.core.C3K {
        /*
            r4 = 0
            r3 = 0
            java.util.List<com.facebook.ads.redexgen.X.mD> r8 = r8.A02
            int r7 = r8.size()
            r5 = 0
        L9:
            r6 = 1953658222(0x7472756e, float:7.683823E31)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2481m7.A0a
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 30
            if (r1 == r0) goto L67
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2481m7.A0a
            java.lang.String r1 = "g5KWW"
            r0 = 1
            r2[r0] = r1
            if (r5 >= r7) goto L3f
            java.lang.Object r1 = r8.get(r5)
            com.facebook.ads.redexgen.X.mD r1 = (com.facebook.ads.redexgen.core.C2487mD) r1
            int r0 = r1.A00
            if (r0 != r6) goto L3c
            com.facebook.ads.redexgen.X.4v r1 = r1.A00
            r0 = 12
            r1.A0f(r0)
            int r0 = r1.A0L()
            if (r0 <= 0) goto L3c
            int r3 = r3 + r0
            int r4 = r4 + 1
        L3c:
            int r5 = r5 + 1
            goto L9
        L3f:
            r0 = 0
            r9.A02 = r0
            r9.A00 = r0
            r9.A01 = r0
            com.facebook.ads.redexgen.X.JQ r0 = r9.A09
            r0.A03(r4, r3)
            r5 = 0
            r0 = 0
            r4 = 0
        L4e:
            if (r4 >= r7) goto L66
            java.lang.Object r3 = r8.get(r4)
            com.facebook.ads.redexgen.X.mD r3 = (com.facebook.ads.redexgen.core.C2487mD) r3
            int r1 = r3.A00
            if (r1 != r6) goto L63
            int r2 = r5 + 1
            com.facebook.ads.redexgen.X.4v r1 = r3.A00
            int r0 = A01(r9, r5, r10, r1, r0)
            r5 = r2
        L63:
            int r4 = r4 + 1
            goto L4e
        L66:
            return
        L67:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2481m7.A0S(com.facebook.ads.redexgen.X.mE, com.facebook.ads.redexgen.X.JA, int):void");
    }

    @MetaExoPlayerCustomization("Adding Uri for eMsg")
    private void A0U(C2487mD c2487mD, long j, Uri uri) throws C3K {
        if (!this.A0V.isEmpty()) {
            this.A0V.peek().A09(c2487mD);
            return;
        }
        if (((AbstractC1314Iu) c2487mD).A00 == 1936286840) {
            Pair<Long, C2521my> pairA05 = A05(c2487mD.A00, j);
            Long l = (Long) pairA05.first;
            if (A0a[2].charAt(14) == 'D') {
                throw new RuntimeException();
            }
            A0a[2] = "KqHjYmkkmLRftUSzBx7x8q1P7pbSwwaZ";
            this.A0C = l.longValue();
            this.A0E.AJ7((HY) pairA05.second);
            this.A0G = true;
            return;
        }
        if (((AbstractC1314Iu) c2487mD).A00 != 1701671783 || uri == null) {
            return;
        }
        A0H(c2487mD.A00, uri);
    }

    public static boolean A0W(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0X(int r4) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2481m7.A0X(int):boolean");
    }

    private boolean A0Y(InterfaceC2516ms interfaceC2516ms) throws IOException {
        int trackCount;
        int i;
        if (this.A00 == 0) {
            C09724v c09724v = this.A0M;
            if (A0a[2].charAt(14) != 'D') {
                A0a[5] = "Du9yMjOrUhZNFJE5GgCY";
                if (!interfaceC2516ms.AHR(c09724v.A0l(), 0, 8, true)) {
                    return false;
                }
                this.A00 = 8;
                this.A0M.A0f(0);
                this.A07 = this.A0M.A0Q();
                int iA0C = this.A0M.A0C();
                if (A0a[5].length() != 30) {
                    A0a[0] = "Nk2";
                    this.A01 = iA0C;
                }
            }
            throw new RuntimeException();
        }
        if (this.A07 == 1) {
            interfaceC2516ms.readFully(this.A0M.A0l(), 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A07 = this.A0M.A0R();
        } else if (this.A07 == 0) {
            long jA8O = interfaceC2516ms.A8O();
            if (jA8O == -1 && !this.A0V.isEmpty()) {
                jA8O = this.A0V.peek().A00;
            }
            if (jA8O != -1) {
                long jA8n = jA8O - interfaceC2516ms.A8n();
                int trackCount2 = this.A00;
                this.A07 = jA8n + ((long) trackCount2);
            }
        }
        if (this.A07 >= this.A00) {
            long jA8n2 = interfaceC2516ms.A8n() - ((long) this.A00);
            if ((this.A01 == 1836019558 || this.A01 == 1835295092) && !this.A0G) {
                this.A0E.AJ7(new C2511mn(this.A08, jA8n2));
                this.A0G = true;
            }
            if (this.A01 == 1836019558) {
                SparseArray<JA> sparseArray = this.A0L;
                if (A0a[0].length() != 3) {
                    A0a[7] = "3NdiubR5fLBwA18U1YAUjfhOdAcmjZCx";
                    trackCount = sparseArray.size();
                    i = 0;
                } else {
                    A0a[0] = "3Yh";
                    trackCount = sparseArray.size();
                    i = 0;
                }
                while (i < trackCount) {
                    JQ jq = this.A0L.valueAt(i).A09;
                    jq.A02 = jA8n2;
                    jq.A03 = jA8n2;
                    jq.A04 = jA8n2;
                    i++;
                }
            }
            int trackCount3 = this.A01;
            if (trackCount3 == 1835295092) {
                this.A0F = null;
                this.A09 = this.A07 + jA8n2;
                this.A02 = 2;
                return true;
            }
            if (A0W(this.A01)) {
                long jA8n3 = (interfaceC2516ms.A8n() + this.A07) - 8;
                this.A0V.push(new C2488mE(this.A01, jA8n3));
                if (this.A07 == this.A00) {
                    A0F(jA8n3);
                } else {
                    A0B();
                }
            } else if (A0X(this.A01)) {
                if (this.A00 != 8) {
                    throw C3K.A00(A0A(284, 51, 6));
                }
                if (this.A07 <= 2147483647L) {
                    C09724v c09724v2 = new C09724v((int) this.A07);
                    C09724v atomData = this.A0M;
                    System.arraycopy(atomData.A0l(), 0, c09724v2.A0l(), 0, 8);
                    this.A0D = c09724v2;
                    this.A02 = 1;
                } else {
                    throw C3K.A00(A0A(335, 49, 77));
                }
            } else if (this.A07 <= 2147483647L) {
                this.A0D = null;
                this.A02 = 1;
            } else {
                throw C3K.A00(A0A(592, 53, 87));
            }
            return true;
        }
        throw C3K.A00(A0A(78, 48, 36));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (r3 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        r19.AK3(r3);
        A0B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        if (r3 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0246, code lost:
    
        throw com.facebook.ads.redexgen.core.C3K.A01(A0A(androidx.constraintlayout.core.motion.utils.TypedValues.CycleType.TYPE_WAVE_PERIOD, 35, 125), null);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ba  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Mark text samples as sync frames")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0Z(com.facebook.ads.redexgen.core.InterfaceC2516ms r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 774
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2481m7.A0Z(com.facebook.ads.redexgen.X.ms):boolean");
    }

    public static boolean A0a(JO jo) {
        if (jo.A08 == null || jo.A08.length != 1 || jo.A09 == null) {
            return false;
        }
        if (jo.A08[0] == 0) {
            return true;
        }
        long editListEndMediaTimeUs = C5C.A0U(jo.A08[0] + jo.A09[0], 1000000L, jo.A05);
        if (A0a[2].charAt(14) == 'D') {
            throw new RuntimeException();
        }
        A0a[1] = "wHdUW";
        return editListEndMediaTimeUs >= jo.A04;
    }

    public static /* synthetic */ H9[] A0b() {
        return new H9[]{new C2480m6()};
    }

    public final JO A0c(JO jo) {
        return jo;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A0E = ha;
        A0B();
        A0C();
        if (this.A0U != null) {
            this.A0L.put(0, new JA(ha.AKS(0, this.A0U.A03), new JR(this.A0U, new long[0], new int[0], 0, new long[0], new int[0], 0L), new J1(0, 0, 0, 0)));
            this.A0E.A6O();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        while (true) {
            switch (this.A02) {
                case 0:
                    if (!A0Y(interfaceC2516ms)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0L(interfaceC2516ms);
                    break;
                case 2:
                    A0M(interfaceC2516ms);
                    break;
                default:
                    if (A0Z(interfaceC2516ms)) {
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
        int size = this.A0L.size();
        for (int i = 0; i < size; i++) {
            this.A0L.valueAt(i).A08();
        }
        this.A0W.clear();
        this.A03 = 0;
        this.A0B = j2;
        this.A0V.clear();
        A0B();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC2516ms interfaceC2516ms) throws IOException {
        return JM.A01(interfaceC2516ms);
    }
}
