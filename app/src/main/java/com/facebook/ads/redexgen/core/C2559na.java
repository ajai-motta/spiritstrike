package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.na, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2559na implements InterfaceC1272Hd {
    public static byte[] A0Y;
    public static String[] A0Z = {"85R60pw", "bhfqNyhgsMMcgxDZV18ZYvPWnAETveJ8", "tBTQ49uE8lCvjdowyQOxeOaVlddkkQsD", "cRYvTCVhA9B6pxggP4HMUODB0FrVm2He", "qWsUB7mYWdY8z", "PljQg4leV4XdGi9pMhsrxdm25IT3iHNc", "UH2NGYtrpmiPe", "fmnhpkR"};
    public int A00;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public long A08;

    @MetaExoPlayerCustomization("Added in D14652852 for LiveTrace")
    public Uri A0A;
    public C2725qI A0B;
    public C2725qI A0C;
    public C2725qI A0D;
    public InterfaceC10919s A0E;
    public DP A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final A1 A0T;
    public final A6 A0U;
    public final DL A0V;
    public final DN A0W = new DN();
    public int A01 = 1000;
    public int[] A0P = new int[this.A01];
    public long[] A0Q = new long[this.A01];
    public long[] A0R = new long[this.A01];
    public int[] A0N = new int[this.A01];
    public int[] A0O = new int[this.A01];
    public C1270Hb[] A0S = new C1270Hb[this.A01];
    public final C1170De<DO> A0X = new C1170De<>(new AnonymousClass49() { // from class: com.facebook.ads.redexgen.X.nb
        @Override // com.facebook.ads.redexgen.core.AnonymousClass49
        public final void A39(Object obj) {
            ((DO) obj).A01.AHb();
        }
    });
    public long A09 = Long.MIN_VALUE;
    public long A06 = Long.MIN_VALUE;
    public long A07 = Long.MIN_VALUE;
    public boolean A0L = true;
    public boolean A0M = true;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private synchronized int A03(C10286z c10286z, C2646p0 c2646p0, boolean z, boolean z2, DN dn) {
        c2646p0.A04 = false;
        if (!A0K()) {
            if (!z2 && !this.A0G) {
                if (this.A0D == null || (!z && this.A0D == this.A0B)) {
                    return -3;
                }
                A0H((C2725qI) AbstractC09493y.A01(this.A0D), c10286z);
                return -5;
            }
            c2646p0.A02(4);
            return -4;
        }
        C2725qI c2725qI = this.A0X.A01(A0O()).A00;
        if (z || c2725qI != this.A0B) {
            A0H(c2725qI, c10286z);
            return -5;
        }
        int iA00 = A00(this.A03);
        if (!A0L(iA00)) {
            c2646p0.A04 = true;
            return -3;
        }
        c2646p0.A02(this.A0N[iA00]);
        c2646p0.A01 = this.A0R[iA00];
        if (c2646p0.A01 < this.A09) {
            c2646p0.A00(Integer.MIN_VALUE);
        }
        dn.A00 = this.A0O[iA00];
        dn.A01 = this.A0Q[iA00];
        dn.A02 = this.A0S[iA00];
        return -4;
    }

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Y, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0Y = new byte[]{35, 74, 57, 70, 70, Base64.padSymbol, 56, Base64.padSymbol, 66, 59, -12, 73, 66, 57, 76, 68, 57, 55, 72, 57, 56, -12, 66, 67, 66, 1, 71, 77, 66, 55, -12, 71, 53, 65, 68, SignedBytes.MAX_POWER_OF_TWO, 57, -12, 58, 67, 70, -12, 58, 67, 70, 65, 53, 72, Ascii.SO, -12, -62, -48, -36, -33, -37, -44, -64, -28, -44, -28, -44};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private synchronized void A0G(long j, int i, long j2, int i2, C1270Hb c1270Hb) {
        if (this.A02 > 0) {
            int iA00 = A00(this.A02 - 1);
            AbstractC09493y.A07(this.A0Q[iA00] + ((long) this.A0O[iA00]) <= j2);
        }
        this.A0G = (536870912 & i) != 0;
        this.A07 = Math.max(this.A07, j);
        int iA002 = A00(this.A02);
        this.A0R[iA002] = j;
        this.A0Q[iA002] = j2;
        this.A0O[iA002] = i2;
        this.A0N[iA002] = i;
        this.A0S[iA002] = c1270Hb;
        this.A0P[iA002] = this.A05;
        if (this.A0X.A06() || !this.A0X.A00().A00.equals(this.A0D)) {
            this.A0X.A05(A0P(), new DO((C2725qI) AbstractC09493y.A01(this.A0D), this.A0U != null ? this.A0U.AH3(this.A0T, this.A0D) : A5.A00));
        }
        this.A02++;
        if (this.A02 == this.A01) {
            int i3 = this.A01 + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            C1270Hb[] c1270HbArr = new C1270Hb[i3];
            int i4 = this.A01 - this.A04;
            System.arraycopy(this.A0Q, this.A04, jArr, 0, i4);
            System.arraycopy(this.A0R, this.A04, jArr2, 0, i4);
            System.arraycopy(this.A0N, this.A04, iArr2, 0, i4);
            System.arraycopy(this.A0O, this.A04, iArr3, 0, i4);
            System.arraycopy(this.A0S, this.A04, c1270HbArr, 0, i4);
            System.arraycopy(this.A0P, this.A04, iArr, 0, i4);
            int i5 = this.A04;
            System.arraycopy(this.A0Q, 0, jArr, i4, i5);
            System.arraycopy(this.A0R, 0, jArr2, i4, i5);
            System.arraycopy(this.A0N, 0, iArr2, i4, i5);
            System.arraycopy(this.A0O, 0, iArr3, i4, i5);
            System.arraycopy(this.A0S, 0, c1270HbArr, i4, i5);
            System.arraycopy(this.A0P, 0, iArr, i4, i5);
            this.A0Q = jArr;
            this.A0R = jArr2;
            this.A0N = iArr2;
            this.A0O = iArr3;
            this.A0S = c1270HbArr;
            this.A0P = iArr;
            this.A04 = 0;
            this.A01 = i3;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized long A0S() {
        return this.A02 == 0 ? Long.MIN_VALUE : this.A0R[this.A04];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final /* synthetic */ int AIp(InterfaceC09052c interfaceC09052c, int i, boolean z) {
        return AbstractC1269Ha.A00(this, interfaceC09052c, i, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final /* synthetic */ void AIr(C09724v c09724v, int i) {
        AbstractC1269Ha.A01(this, c09724v, i);
    }

    static {
        A0E();
    }

    public C2559na(F0 f0, A6 a6, A1 a1) {
        this.A0U = a6;
        this.A0T = a1;
        this.A0V = new DL(f0);
    }

    private int A00(int i) {
        int i2 = this.A04 + i;
        int relativeIndex = this.A01;
        if (i2 < relativeIndex) {
            return i2;
        }
        int relativeIndex2 = this.A01;
        return i2 - relativeIndex2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0027 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(int r6, int r7, long r8, boolean r10) {
        /*
            r5 = this;
            r4 = -1
            r3 = 0
        L2:
            if (r3 >= r7) goto L1f
            long[] r0 = r5.A0R
            r1 = r0[r6]
            int r0 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r0 > 0) goto L1f
            if (r10 == 0) goto L16
            int[] r0 = r5.A0N
            r0 = r0[r6]
            r0 = r0 & 1
            if (r0 == 0) goto L20
        L16:
            r4 = r3
            long[] r0 = r5.A0R
            r1 = r0[r6]
            int r0 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r0 != 0) goto L20
        L1f:
            return r4
        L20:
            int r6 = r6 + 1
            int r0 = r5.A01
            if (r6 != r0) goto L27
            r6 = 0
        L27:
            int r3 = r3 + 1
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2559na.A01(int, int, long, boolean):int");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A02(long r6) {
        /*
            r5 = this;
            int r4 = r5.A02
            int r0 = r5.A02
            int r0 = r0 + (-1)
            int r3 = r5.A00(r0)
        La:
            int r0 = r5.A03
            if (r4 <= r0) goto L42
            long[] r0 = r5.A0R
            r1 = r0[r3]
            int r0 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r0 < 0) goto L42
            int r4 = r4 + (-1)
            int r3 = r3 + (-1)
            r0 = -1
            if (r3 != r0) goto La
            int r3 = r5.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            r0 = 5
            r1 = r2[r0]
            r0 = 2
            r2 = r2[r0]
            r0 = 3
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L38
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L38:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            java.lang.String r1 = "AmG8zl9kQR5zaFQB0ENdPerRnzM6g9Ua"
            r0 = 1
            r2[r0] = r1
            int r3 = r3 + (-1)
            goto La
        L42:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2559na.A02(long):int");
    }

    private synchronized long A04() {
        if (this.A02 == 0) {
            return -1L;
        }
        return A06(this.A02);
    }

    private final synchronized long A05() {
        return Math.max(this.A06, A08(this.A03));
    }

    private long A06(int i) {
        this.A06 = Math.max(this.A06, A08(i));
        this.A02 -= i;
        this.A00 += i;
        this.A04 += i;
        if (this.A04 >= this.A01) {
            this.A04 -= this.A01;
        }
        this.A03 -= i;
        if (this.A03 < 0) {
            this.A03 = 0;
        }
        this.A0X.A04(this.A00);
        if (this.A02 == 0) {
            int relativeLastDiscardIndex = this.A04 == 0 ? this.A01 : this.A04;
            int i2 = relativeLastDiscardIndex - 1;
            long j = this.A0Q[i2];
            int relativeLastDiscardIndex2 = this.A0O[i2];
            return j + ((long) relativeLastDiscardIndex2);
        }
        return this.A0Q[this.A04];
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A07(int r8) {
        /*
            r7 = this;
            int r6 = r7.A0P()
            int r6 = r6 - r8
            r4 = 0
            r5 = 1
            if (r6 < 0) goto L43
            int r1 = r7.A02
            int r0 = r7.A03
            int r1 = r1 - r0
            if (r6 > r1) goto L43
            r0 = 1
        L11:
            com.facebook.ads.redexgen.core.AbstractC09493y.A07(r0)
            int r0 = r7.A02
            int r0 = r0 - r6
            r7.A02 = r0
            long r2 = r7.A06
            int r0 = r7.A02
            long r0 = r7.A08(r0)
            long r0 = java.lang.Math.max(r2, r0)
            r7.A07 = r0
            if (r6 != 0) goto L54
            boolean r3 = r7.A0G
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            r0 = 0
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L45
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L43:
            r0 = 0
            goto L11
        L45:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            java.lang.String r1 = "9q2py6RZjKVKU"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "N5i42TN5jvK54"
            r0 = 6
            r2[r0] = r1
            if (r3 == 0) goto L54
            r4 = 1
        L54:
            r7.A0G = r4
            com.facebook.ads.redexgen.X.De<com.facebook.ads.redexgen.X.DO> r0 = r7.A0X
            r0.A03(r8)
            int r0 = r7.A02
            if (r0 == 0) goto L71
            int r0 = r7.A02
            int r0 = r0 - r5
            int r1 = r7.A00(r0)
            long[] r0 = r7.A0Q
            r2 = r0[r1]
            int[] r0 = r7.A0O
            r0 = r0[r1]
            long r0 = (long) r0
            long r2 = r2 + r0
            return r2
        L71:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2559na.A07(int):long");
    }

    private long A08(int i) {
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        long jMax = Long.MIN_VALUE;
        int iA00 = A00(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.A0R[iA00]);
            int i3 = this.A0N[iA00];
            if ((i3 & 1) != 0) {
                break;
            }
            iA00--;
            if (iA00 == -1) {
                iA00 = this.A01 - 1;
            }
        }
        return jMax;
    }

    private synchronized long A09(long j, boolean z, boolean z2) {
        if (this.A02 != 0 && j >= this.A0R[this.A04]) {
            int iA01 = A01(this.A04, (!z2 || this.A03 == this.A02) ? this.A02 : this.A03 + 1, j, z);
            if (iA01 == -1) {
                return -1L;
            }
            return A06(iA01);
        }
        return -1L;
    }

    private final C2725qI A0A(C2725qI c2725qI) {
        if (this.A08 != 0 && c2725qI.A0M != Long.MAX_VALUE) {
            return c2725qI.A07().A0s(c2725qI.A0M + this.A08).A14();
        }
        return c2725qI;
    }

    public static C2559na A0B(F0 f0, A6 a6, A1 a1) {
        return new C2559na(f0, (A6) AbstractC09493y.A01(a6), (A1) AbstractC09493y.A01(a1));
    }

    private void A0D() {
        if (this.A0E != null) {
            this.A0E.AHc(this.A0T);
            this.A0E = null;
            this.A0B = null;
        }
    }

    private synchronized void A0F() {
        this.A03 = 0;
        this.A0V.A0B();
    }

    private void A0H(C2725qI c2725qI, C10286z c10286z) {
        C2725qI c2725qIA08;
        boolean z = this.A0B == null;
        DrmInitData newDrmInitData = z ? null : this.A0B.A0O;
        this.A0B = c2725qI;
        DrmInitData oldDrmInitData = c2725qI.A0O;
        if (this.A0U != null) {
            c2725qIA08 = c2725qI.A08(this.A0U.A7W(c2725qI));
        } else {
            c2725qIA08 = c2725qI;
        }
        c10286z.A00 = c2725qIA08;
        c10286z.A01 = this.A0E;
        if (this.A0U == null) {
            return;
        }
        if (!z) {
            boolean zA1E = C5C.A1E(newDrmInitData, oldDrmInitData);
            String[] strArr = A0Z;
            if (strArr[5].charAt(3) != strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Z;
            strArr2[5] = "kvzQNhfSOapIkFZHH0bucpMR2mlOE4Ro";
            strArr2[2] = "pNWQqJuQrvmashmvXYzFnQ0x9nljUjVN";
            if (zA1E) {
                return;
            }
        }
        if (Looper.myLooper() == null) {
            return;
        }
        InterfaceC10919s interfaceC10919s = this.A0E;
        this.A0E = this.A0U.A3C(this.A0T, c2725qI);
        c10286z.A01 = this.A0E;
        if (interfaceC10919s != null) {
            interfaceC10919s.AHc(this.A0T);
        }
    }

    private final void A0J(boolean z) {
        this.A0V.A0A();
        this.A02 = 0;
        this.A00 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A0M = true;
        this.A09 = Long.MIN_VALUE;
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        this.A0G = false;
        this.A0X.A02();
        if (z) {
            this.A0C = null;
            this.A0D = null;
            this.A0L = true;
        }
    }

    private boolean A0K() {
        return this.A03 != this.A02;
    }

    private boolean A0L(int i) {
        return this.A0E == null || this.A0E.A9A() == 4 || ((this.A0N[i] & 1073741824) == 0 && this.A0E.AH1());
    }

    private synchronized boolean A0M(long j) {
        boolean z = true;
        if (this.A02 == 0) {
            if (j <= this.A06) {
                z = false;
            }
            return z;
        }
        if (A05() >= j) {
            return false;
        }
        int iA02 = A02(j);
        int retainCount = this.A00;
        A07(retainCount + iA02);
        return true;
    }

    private synchronized boolean A0N(C2725qI c2725qI) {
        this.A0L = false;
        if (C5C.A1E(c2725qI, this.A0D)) {
            return false;
        }
        if (!this.A0X.A06() && this.A0X.A00().A00.equals(c2725qI)) {
            this.A0D = this.A0X.A00().A00;
        } else {
            this.A0D = c2725qI;
        }
        this.A0J = C3J.A0G(this.A0D.A0W, this.A0D.A0R);
        this.A0H = false;
        return true;
    }

    public final int A0O() {
        return this.A00 + this.A03;
    }

    public final int A0P() {
        return this.A00 + this.A02;
    }

    public final synchronized int A0Q(long j, boolean z) {
        int iA00 = A00(this.A03);
        if (A0K() && j >= this.A0R[iA00]) {
            if (j > this.A07 && z) {
                int i = this.A02;
                int relativeReadIndex = this.A03;
                return i - relativeReadIndex;
            }
            int i2 = this.A02;
            int relativeReadIndex2 = this.A03;
            int offset = A01(iA00, i2 - relativeReadIndex2, j, true);
            if (offset == -1) {
                return 0;
            }
            return offset;
        }
        return 0;
    }

    public final int A0R(C10286z c10286z, C2646p0 c2646p0, int i, boolean z) {
        int iA03 = A03(c10286z, c2646p0, (i & 2) != 0, z, this.A0W);
        if (iA03 == -4 && !c2646p0.A05()) {
            int result = i & 1;
            boolean z2 = result != 0;
            int result2 = i & 4;
            if (result2 == 0) {
                if (z2) {
                    this.A0V.A0E(c2646p0, this.A0W);
                } else {
                    this.A0V.A0F(c2646p0, this.A0W);
                }
            }
            if (!z2) {
                int result3 = this.A03;
                this.A03 = result3 + 1;
            }
        }
        return iA03;
    }

    public final synchronized long A0T() {
        return this.A07;
    }

    public final synchronized C2725qI A0U() {
        return this.A0L ? null : this.A0D;
    }

    public final void A0V() {
        this.A0V.A0C(A04());
    }

    public final void A0W() throws IOException {
        if (this.A0E == null || this.A0E.A9A() != 1) {
        } else {
            throw ((C10899q) AbstractC09493y.A01(this.A0E.A80()));
        }
    }

    public final void A0X() {
        A0V();
        A0D();
    }

    public final void A0Y() {
        A0J(true);
        A0D();
    }

    public final void A0Z() {
        A0J(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void A0a(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Lc
            int r1 = r2.A03     // Catch: java.lang.Throwable -> L17
            int r1 = r1 + r3
            int r0 = r2.A02     // Catch: java.lang.Throwable -> L17
            if (r1 > r0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            com.facebook.ads.redexgen.core.AbstractC09493y.A07(r0)     // Catch: java.lang.Throwable -> L17
            int r0 = r2.A03     // Catch: java.lang.Throwable -> L17
            int r0 = r0 + r3
            r2.A03 = r0     // Catch: java.lang.Throwable -> L17
            monitor-exit(r2)
            return
        L17:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2559na.A0a(int):void");
    }

    public final void A0b(long j) {
        this.A09 = j;
    }

    public final void A0c(long j, boolean z, boolean z2) {
        this.A0V.A0C(A09(j, z, z2));
    }

    public final void A0d(DP dp) {
        this.A0F = dp;
    }

    public final synchronized boolean A0e() {
        return this.A0G;
    }

    public final synchronized boolean A0f(long j, boolean z) {
        A0F();
        int iA00 = A00(this.A03);
        if (!A0K() || j < this.A0R[iA00] || (j > this.A07 && !z)) {
            return false;
        }
        int i = this.A02;
        int relativeReadIndex = this.A03;
        int offset = A01(iA00, i - relativeReadIndex, j, true);
        if (offset == -1) {
            return false;
        }
        this.A09 = j;
        int relativeReadIndex2 = this.A03;
        this.A03 = relativeReadIndex2 + offset;
        return true;
    }

    public final synchronized boolean A0g(boolean z) {
        boolean z2 = true;
        if (!A0K()) {
            if (!z && !this.A0G && (this.A0D == null || this.A0D == this.A0B)) {
                z2 = false;
            }
            return z2;
        }
        if (this.A0X.A01(A0O()).A00 != this.A0B) {
            return true;
        }
        return A0L(A00(this.A03));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final void A6e(C2725qI c2725qI) {
        C2725qI c2725qIA0A = A0A(c2725qI);
        this.A0K = false;
        this.A0C = c2725qI;
        boolean upstreamFormatChanged = A0N(c2725qIA0A);
        if (this.A0F != null && upstreamFormatChanged) {
            this.A0F.AGL(c2725qIA0A);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final int AIq(InterfaceC09052c interfaceC09052c, int i, boolean z, int i2) throws IOException {
        return this.A0V.A08(interfaceC09052c, i, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final void AIs(C09724v c09724v, int i, int i2) {
        this.A0V.A0D(c09724v, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AIu(long r16, int r18, int r19, int r20, com.facebook.ads.redexgen.core.C1270Hb r21) {
        /*
            r15 = this;
            r10 = r18
            r8 = r16
            r5 = r15
            boolean r0 = r5.A0K
            if (r0 == 0) goto L14
            com.facebook.ads.redexgen.X.qI r0 = r5.A0C
            java.lang.Object r0 = com.facebook.ads.redexgen.core.AbstractC09493y.A02(r0)
            com.facebook.ads.redexgen.X.qI r0 = (com.facebook.ads.redexgen.core.C2725qI) r0
            r5.A6e(r0)
        L14:
            r0 = r10 & 1
            r4 = 0
            r6 = 1
            if (r0 == 0) goto L22
            r7 = 1
        L1b:
            boolean r0 = r5.A0M
            if (r0 == 0) goto L26
            if (r7 != 0) goto L24
            return
        L22:
            r7 = 0
            goto L1b
        L24:
            r5.A0M = r4
        L26:
            long r0 = r5.A08
            long r8 = r8 + r0
            boolean r0 = r5.A0J
            if (r0 == 0) goto L69
            long r0 = r5.A09
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 >= 0) goto L34
            return
        L34:
            r0 = r10 & 1
            if (r0 != 0) goto L69
            boolean r0 = r5.A0H
            if (r0 != 0) goto L67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 0
            r1 = 50
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = A0C(r2, r1, r0)
            java.lang.StringBuilder r1 = r3.append(r0)
            com.facebook.ads.redexgen.X.qI r0 = r5.A0D
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r3 = r0.toString()
            r2 = 50
            r1 = 11
            r0 = 13
            java.lang.String r0 = A0C(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC09574g.A07(r0, r3)
            r5.A0H = r6
        L67:
            r10 = r10 | 1
        L69:
            boolean r0 = r5.A0I
            if (r0 == 0) goto L97
            if (r7 == 0) goto L94
            boolean r3 = r5.A0M(r8)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            r0 = 0
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L8b
        L85:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L8b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            java.lang.String r1 = "Q9ljdKDjpshc47nqlMYBFO0YDotnOqX8"
            r0 = 3
            r2[r0] = r1
            if (r3 != 0) goto L95
        L94:
            return
        L95:
            r5.A0I = r4
        L97:
            com.facebook.ads.redexgen.X.DL r0 = r5.A0V
            long r11 = r0.A09()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2559na.A0Z
            r0 = 1
            r1 = r1[r0]
            r0 = 24
            char r1 = r1.charAt(r0)
            r0 = 110(0x6e, float:1.54E-43)
            if (r1 == r0) goto Lad
            goto L85
        Lad:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2559na.A0Z
            java.lang.String r1 = "281h4YOhy96mUgaRFHojQOWi7hgLUzVm"
            r0 = 3
            r2[r0] = r1
            r13 = r19
            long r0 = (long) r13
            long r11 = r11 - r0
            r0 = r20
            long r0 = (long) r0
            long r11 = r11 - r0
            r7 = r15
            r14 = r21
            r7.A0G(r8, r10, r11, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2559na.AIu(long, int, int, int, com.facebook.ads.redexgen.X.Hb):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    @MetaExoPlayerCustomization("Added in D14652852 for LiveTrace")
    public final void AKf(Uri uri) {
        this.A0A = uri;
    }
}
