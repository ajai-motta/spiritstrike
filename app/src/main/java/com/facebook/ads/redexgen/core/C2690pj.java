package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2690pj implements AnonymousClass24 {
    public static byte[] A0H;
    public static String[] A0I = {"AtN4gZlBq", "c6vG0ZoB350sNCwGTcbmyQxG", "GzjisXMF7MeBETThzgY0McLZmUxvZEHG", "X6Q", "OR9IAwpAbXPQPDykEqLOHO0nD", "OJOMvHQBuYweGyqOlvOJ7Ft7l3L2", "Cgb", "Ei80eZ3oJ"};
    public static final AnonymousClass23<C2690pj> A0J;
    public static final Object A0K;
    public static final C2714q7 A0L;
    public static final Object A0M;
    public static final String A0N;
    public static final String A0O;
    public static final String A0P;
    public static final String A0Q;
    public static final String A0R;
    public static final String A0S;
    public static final String A0T;
    public static final String A0U;
    public static final String A0V;
    public static final String A0W;
    public static final String A0X;
    public static final String A0Y;
    public static final String A0Z;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public C2717qA A08;
    public Object A0A;

    @Deprecated
    public Object A0B;
    public boolean A0D;

    @Deprecated
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public Object A0C = A0K;
    public C2714q7 A09 = A0L;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C2690pj A00(Bundle bundle) {
        C2717qA c2717qA;
        Bundle bundle2 = bundle.getBundle(A0W);
        C2714q7 c2714q7 = bundle2 != null ? (C2714q7) C2714q7.A08.A6f(bundle2) : C2714q7.A09;
        long j = bundle.getLong(A0Y, C.TIME_UNSET);
        long j2 = bundle.getLong(A0Z, C.TIME_UNSET);
        long j3 = bundle.getLong(A0P, C.TIME_UNSET);
        boolean z = bundle.getBoolean(A0T, false);
        boolean z2 = bundle.getBoolean(A0R, false);
        Bundle bundle3 = bundle.getBundle(A0V);
        if (bundle3 != null) {
            c2717qA = (C2717qA) C2717qA.A06.A6f(bundle3);
        } else {
            c2717qA = null;
            if (A0I[2].charAt(1) != 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0I;
            strArr[6] = "auZ";
            strArr[3] = "aKQ";
        }
        boolean z3 = bundle.getBoolean(A0S, false);
        long j4 = bundle.getLong(A0N, 0L);
        long j5 = bundle.getLong(A0O, C.TIME_UNSET);
        int i = bundle.getInt(A0Q, 0);
        int i2 = bundle.getInt(A0U, 0);
        long j6 = bundle.getLong(A0X, 0L);
        C2690pj c2690pj = new C2690pj();
        c2690pj.A07(A0M, c2714q7, null, j, j2, j3, z, z2, c2717qA, j4, j5, i, i2, j6);
        c2690pj.A0F = z3;
        return c2690pj;
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0H = new byte[]{6, 10, 8, 75, 3, 4, 6, 0, 7, 10, 10, Ascii.SO, 75, 4, 1, Ascii.SYN, 75, 4, Ascii.VT, 1, Ascii.ETB, 10, Ascii.FF, 1, Ascii.GS, 75, 8, 0, 1, Ascii.FF, 4, 86, 75, 6, 10, 8, 8, 10, Ascii.VT, 75, 49, Ascii.FF, 8, 0, 9, Ascii.FF, Ascii.VT, 0};
    }

    static {
        A03();
        A0K = new Object();
        A0M = new Object();
        A0L = new C09212u().A03(A02(0, 48, 107)).A00(Uri.EMPTY).A05();
        A0W = C5C.A0h(1);
        A0Y = C5C.A0h(2);
        A0Z = C5C.A0h(3);
        A0P = C5C.A0h(4);
        A0T = C5C.A0h(5);
        A0R = C5C.A0h(6);
        A0V = C5C.A0h(7);
        A0S = C5C.A0h(8);
        A0N = C5C.A0h(9);
        A0O = C5C.A0h(10);
        A0Q = C5C.A0h(11);
        A0U = C5C.A0h(12);
        A0X = C5C.A0h(13);
        A0J = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pk
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2690pj.A00(bundle);
            }
        };
    }

    public final long A04() {
        return C5C.A0P(this.A02);
    }

    public final long A05() {
        return this.A02;
    }

    public final long A06() {
        return C5C.A0P(this.A03);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.C2690pj A07(java.lang.Object r6, com.facebook.ads.redexgen.core.C2714q7 r7, java.lang.Object r8, long r9, long r11, long r13, boolean r15, boolean r16, com.facebook.ads.redexgen.core.C2717qA r17, long r18, long r20, int r22, int r23, long r24) {
        /*
            r5 = this;
            r3 = r5
            r3.A0C = r6
            if (r7 == 0) goto L1c
            r0 = r7
        L6:
            r3.A09 = r0
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2690pj.A0I
            r0 = 2
            r1 = r1[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            r0 = 122(0x7a, float:1.71E-43)
            if (r1 == r0) goto L1f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1c:
            com.facebook.ads.redexgen.X.q7 r0 = com.facebook.ads.redexgen.core.C2690pj.A0L
            goto L6
        L1f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2690pj.A0I
            java.lang.String r1 = "sHLAwqiYlmMVa087WjDP7yFYW"
            r0 = 5
            r2[r0] = r1
            if (r7 == 0) goto L82
            com.facebook.ads.redexgen.X.32 r4 = r7.A03
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2690pj.A0I
            r0 = 2
            r1 = r1[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            r0 = 122(0x7a, float:1.71E-43)
            if (r1 == r0) goto L78
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2690pj.A0I
            java.lang.String r1 = "JzGzHC0FwGnnWhMzWBrJaCXM29VIx9g1"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L82
        L41:
            com.facebook.ads.redexgen.X.32 r0 = r7.A03
            java.lang.Object r0 = r0.A03
        L45:
            r3.A0B = r0
            r3.A0A = r8
            r3.A06 = r9
            r3.A07 = r11
            r3.A04 = r13
            r3.A0G = r15
            r0 = r16
            r3.A0D = r0
            r1 = r17
            if (r1 == 0) goto L76
            r0 = 1
        L5a:
            r3.A0E = r0
            r3.A08 = r1
            r0 = r18
            r3.A02 = r0
            r0 = r20
            r3.A03 = r0
            r0 = r22
            r3.A00 = r0
            r0 = r23
            r3.A01 = r0
            r0 = r24
            r3.A05 = r0
            r0 = 0
            r3.A0F = r0
            return r3
        L76:
            r0 = 0
            goto L5a
        L78:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2690pj.A0I
            java.lang.String r1 = "IGwZtC"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto L82
            goto L41
        L82:
            r0 = 0
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2690pj.A07(java.lang.Object, com.facebook.ads.redexgen.X.q7, java.lang.Object, long, long, long, boolean, boolean, com.facebook.ads.redexgen.X.qA, long, long, int, int, long):com.facebook.ads.redexgen.X.pj");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        C2690pj c2690pj = (C2690pj) obj;
        if (C5C.A1E(this.A0C, c2690pj.A0C) && C5C.A1E(this.A09, c2690pj.A09) && C5C.A1E(this.A0A, c2690pj.A0A) && C5C.A1E(this.A08, c2690pj.A08) && this.A06 == c2690pj.A06 && this.A07 == c2690pj.A07 && this.A04 == c2690pj.A04 && this.A0G == c2690pj.A0G && this.A0D == c2690pj.A0D && this.A0F == c2690pj.A0F && this.A02 == c2690pj.A02 && this.A03 == c2690pj.A03 && this.A00 == c2690pj.A00 && this.A01 == c2690pj.A01) {
            long j = this.A05;
            long j2 = c2690pj.A05;
            String[] strArr = A0I;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[6] = "Zdu";
            strArr2[3] = "ITW";
            if (j == j2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((((((((7 * 31) + this.A0C.hashCode()) * 31) + this.A09.hashCode()) * 31) + (this.A0A == null ? 0 : this.A0A.hashCode())) * 31) + (this.A08 != null ? this.A08.hashCode() : 0)) * 31) + ((int) (this.A06 ^ (this.A06 >>> 32)))) * 31) + ((int) (this.A07 ^ (this.A07 >>> 32)))) * 31) + ((int) (this.A04 ^ (this.A04 >>> 32)))) * 31) + (this.A0G ? 1 : 0);
        if (A0I[2].charAt(1) != 'z') {
            throw new RuntimeException();
        }
        String[] strArr = A0I;
        strArr[6] = "6VN";
        strArr[3] = "iNJ";
        return (((((((((((((iHashCode * 31) + (this.A0D ? 1 : 0)) * 31) + (this.A0F ? 1 : 0)) * 31) + ((int) (this.A02 ^ (this.A02 >>> 32)))) * 31) + ((int) (this.A03 ^ (this.A03 >>> 32)))) * 31) + this.A00) * 31) + this.A01) * 31) + ((int) (this.A05 ^ (this.A05 >>> 32)));
    }
}
