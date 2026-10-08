package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2725qI implements AnonymousClass24 {
    public static byte[] A0Z;
    public static String[] A0a = {"V6MXy8T8VWr2uYzGQHXNST8x6mkuL2zq", "NPPhtSRrwFXlj8s5Lf5pJApSSy7nWvZn", "Zwnng2X5IOM1TKGeykh69gCIqoxpb9rN", "EKOvtoarjvrGIuXcg3PsyJc7", "ZiMxAAQ9qCUD5Rc2p4Bdqy2u", "SqcuONG3eBJEqSGEKSqUXXYdrjOnl4qF", "9lDPTqOcDpJIt3QmxvZawHsHRg6Gfk5X", "1hwbvE9Xb2ACzfbNO0itJVr"};
    public static final AnonymousClass23<C2725qI> A0b;
    public static final C2725qI A0c;
    public static final String A0d;
    public static final String A0e;
    public static final String A0f;
    public static final String A0g;
    public static final String A0h;
    public static final String A0i;
    public static final String A0j;
    public static final String A0k;
    public static final String A0l;
    public static final String A0m;
    public static final String A0n;
    public static final String A0o;
    public static final String A0p;
    public static final String A0q;
    public static final String A0r;
    public static final String A0s;
    public static final String A0t;
    public static final String A0u;
    public static final String A0v;
    public static final String A0w;
    public static final String A0x;
    public static final String A0y;
    public static final String A0z;
    public static final String A10;
    public static final String A11;
    public static final String A12;
    public static final String A13;
    public static final String A14;
    public static final String A15;
    public static final String A16;
    public static final String A17;
    public static final String A18;
    public int A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final int A0D;
    public final int A0E;
    public final int A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final int A0L;
    public final long A0M;
    public final ColorInfo A0N;
    public final DrmInitData A0O;
    public final Metadata A0P;
    public final Object A0Q;
    public final String A0R;
    public final String A0S;
    public final String A0T;
    public final String A0U;
    public final String A0V;
    public final String A0W;
    public final List<byte[]> A0X;
    public final byte[] A0Y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> T A02(T t, T t2) {
        return t != null ? t : t2;
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Z, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0Z = new byte[]{-38, -50, 0, -12, 47, 32, 73, 76, 71, 59, 78, 2, 81, Ascii.GS, 37, -12, -24, 35, Ascii.US};
    }

    static {
        A05();
        A0c = new C09162p().A14();
        A0p = C5C.A0h(0);
        A0r = C5C.A0h(1);
        A0s = C5C.A0h(2);
        A13 = C5C.A0h(3);
        A0z = C5C.A0h(4);
        A0e = C5C.A0h(5);
        A0w = C5C.A0h(6);
        A0g = C5C.A0h(7);
        A0u = C5C.A0h(8);
        A0i = C5C.A0h(9);
        A11 = C5C.A0h(10);
        A0t = C5C.A0h(11);
        A0q = C5C.A0h(12);
        A0k = C5C.A0h(13);
        A15 = C5C.A0h(14);
        A18 = C5C.A0h(15);
        A0o = C5C.A0h(16);
        A0n = C5C.A0h(17);
        A10 = C5C.A0h(18);
        A0x = C5C.A0h(19);
        A0y = C5C.A0h(20);
        A14 = C5C.A0h(21);
        A0h = C5C.A0h(22);
        A0f = C5C.A0h(23);
        A12 = C5C.A0h(24);
        A0v = C5C.A0h(25);
        A0l = C5C.A0h(26);
        A0m = C5C.A0h(27);
        A0d = C5C.A0h(28);
        A0j = C5C.A0h(29);
        A16 = C5C.A0h(30);
        A17 = C5C.A0h(31);
        A0b = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qJ
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2725qI.A00(bundle);
            }
        };
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Language is not normalized")
    public C2725qI(C09162p c09162p) {
        this.A0T = c09162p.A0R;
        this.A0U = c09162p.A0S;
        if (MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A0k)) {
            this.A0V = C5C.A0k(c09162p.A0T);
        } else {
            this.A0V = c09162p.A0T;
        }
        this.A0H = c09162p.A0F;
        this.A0E = c09162p.A0C;
        this.A04 = c09162p.A03;
        this.A0D = c09162p.A0B;
        this.A05 = this.A0D != -1 ? this.A0D : this.A04;
        this.A0R = c09162p.A0P;
        this.A0P = c09162p.A0N;
        this.A0Q = c09162p.A0O;
        this.A0S = c09162p.A0Q;
        this.A0W = c09162p.A0U;
        this.A0B = c09162p.A09;
        this.A0X = c09162p.A0V == null ? Collections.emptyList() : c09162p.A0V;
        this.A0O = c09162p.A0M;
        this.A0M = c09162p.A0K;
        this.A0L = c09162p.A0J;
        this.A0A = c09162p.A08;
        this.A01 = c09162p.A00;
        this.A0F = c09162p.A0D == -1 ? 0 : c09162p.A0D;
        this.A02 = c09162p.A01 == -1.0f ? 1.0f : c09162p.A01;
        this.A0Y = c09162p.A0W;
        this.A0I = c09162p.A0G;
        this.A0N = c09162p.A0L;
        this.A06 = c09162p.A04;
        this.A0G = c09162p.A0E;
        this.A0C = c09162p.A0A;
        this.A08 = c09162p.A06 == -1 ? 0 : c09162p.A06;
        this.A09 = c09162p.A07 != -1 ? c09162p.A07 : 0;
        this.A03 = c09162p.A02;
        this.A0J = c09162p.A0H;
        this.A0K = c09162p.A0I;
        if (c09162p.A05 != 0 || this.A0O == null) {
            this.A07 = c09162p.A05;
        } else {
            this.A07 = 1;
        }
    }

    public static C2725qI A00(Bundle bundle) {
        C09162p c09162p = new C09162p();
        AnonymousClass44.A02(bundle);
        c09162p.A0y((String) A02(bundle.getString(A0p), A0c.A0T)).A0z((String) A02(bundle.getString(A0r), A0c.A0U)).A10((String) A02(bundle.getString(A0s), A0c.A0V)).A0n(bundle.getInt(A13, A0c.A0H)).A0k(bundle.getInt(A0z, A0c.A0E)).A0a(bundle.getInt(A0e, A0c.A04)).A0j(bundle.getInt(A0w, A0c.A0D)).A0w((String) A02(bundle.getString(A0g), A0c.A0R)).A0v((Metadata) A02((Metadata) bundle.getParcelable(A0u), A0c.A0P)).A0x((String) A02(bundle.getString(A0i), A0c.A0S)).A11((String) A02(bundle.getString(A11), A0c.A0W)).A0h(bundle.getInt(A0t, A0c.A0B));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(A03(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        c09162p.A12(arrayList).A0u((DrmInitData) bundle.getParcelable(A0k)).A0s(bundle.getLong(A15, A0c.A0M)).A0r(bundle.getInt(A18, A0c.A0L)).A0f(bundle.getInt(A0o, A0c.A0A)).A0X(bundle.getFloat(A0n, A0c.A01)).A0l(bundle.getInt(A10, A0c.A0F)).A0Y(bundle.getFloat(A0x, A0c.A02)).A13(bundle.getByteArray(A0y)).A0o(bundle.getInt(A14, A0c.A0I));
        Bundle bundle2 = bundle.getBundle(A0h);
        if (bundle2 != null) {
            ColorInfo colorInfo = (ColorInfo) ColorInfo.A08.A6f(bundle2);
            String[] strArr = A0a;
            if (strArr[0].charAt(2) == strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0a;
            strArr2[0] = "Hj6q80mEs2TaNtyFDcR9WAdUhRzKpc2R";
            strArr2[2] = "QNxytj5q4fkMiXjNnIzm1WM2l3yCLldD";
            c09162p.A0t(colorInfo);
        }
        c09162p.A0b(bundle.getInt(A0f, A0c.A06)).A0m(bundle.getInt(A12, A0c.A0G)).A0i(bundle.getInt(A0v, A0c.A0C)).A0d(bundle.getInt(A0l, A0c.A08)).A0e(bundle.getInt(A0m, A0c.A09)).A0Z(bundle.getInt(A0d, A0c.A03)).A0p(bundle.getInt(A16, A0c.A0J)).A0q(bundle.getInt(A17, A0c.A0K)).A0c(bundle.getInt(A0j, A0c.A07));
        return c09162p.A14();
    }

    public static String A03(int i) {
        return A0q + A04(18, 1, 70) + Integer.toString(i, 36);
    }

    public final int A06() {
        if (this.A0L == -1) {
            return -1;
        }
        int i = this.A0A;
        if (A0a[6].charAt(1) != 'l') {
            throw new RuntimeException();
        }
        A0a[7] = "26nMyN52vPpNzMdMA433IJJ";
        if (i == -1) {
            return -1;
        }
        return this.A0A * this.A0L;
    }

    public final C09162p A07() {
        return new C09162p(this);
    }

    public final C2725qI A08(int i) {
        return A07().A0c(i).A14();
    }

    @Deprecated
    public final C2725qI A09(DrmInitData drmInitData) {
        return A07().A0u(drmInitData).A14();
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A(com.facebook.ads.redexgen.core.C2725qI r5) {
        /*
            r4 = this;
            java.util.List<byte[]> r0 = r4.A0X
            int r1 = r0.size()
            java.util.List<byte[]> r0 = r5.A0X
            int r0 = r0.size()
            r3 = 0
            if (r1 == r0) goto L10
            return r3
        L10:
            r2 = 0
        L11:
            java.util.List<byte[]> r0 = r4.A0X
            int r0 = r0.size()
            if (r2 >= r0) goto L33
            java.util.List<byte[]> r0 = r4.A0X
            java.lang.Object r1 = r0.get(r2)
            byte[] r1 = (byte[]) r1
            java.util.List<byte[]> r0 = r5.A0X
            java.lang.Object r0 = r0.get(r2)
            byte[] r0 = (byte[]) r0
            boolean r0 = java.util.Arrays.equals(r1, r0)
            if (r0 != 0) goto L30
            return r3
        L30:
            int r2 = r2 + 1
            goto L11
        L33:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2725qI.A0A(com.facebook.ads.redexgen.X.qI):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2725qI.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode;
        if (this.A00 == 0) {
            int i = 17 * 31;
            int result = this.A0T == null ? 0 : this.A0T.hashCode();
            int result2 = (((i + result) * 31) + (this.A0U != null ? this.A0U.hashCode() : 0)) * 31;
            int result3 = this.A0V == null ? 0 : this.A0V.hashCode();
            int result4 = (((result2 + result3) * 31) + this.A0H) * 31;
            int result5 = this.A0E;
            int result6 = (((result4 + result5) * 31) + this.A04) * 31;
            int result7 = this.A0D;
            int i2 = (result6 + result7) * 31;
            if (this.A0R == null) {
                iHashCode = 0;
            } else {
                String str = this.A0R;
                String[] strArr = A0a;
                if (strArr[0].charAt(2) == strArr[2].charAt(2)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0a;
                strArr2[3] = "TXy1YAbF7Qkyl7ROldsNtIji";
                strArr2[4] = "lt4q3TmvSSK0Q54eRVJBBfw2";
                iHashCode = str.hashCode();
            }
            int result8 = (i2 + iHashCode) * 31;
            int result9 = this.A0P == null ? 0 : this.A0P.hashCode();
            int result10 = (((result8 + result9) * 31) + (this.A0Q == null ? 0 : this.A0Q.hashCode())) * 31;
            int result11 = this.A0S == null ? 0 : this.A0S.hashCode();
            int result12 = (result10 + result11) * 31;
            int iHashCode2 = this.A0W != null ? this.A0W.hashCode() : 0;
            int result13 = this.A0B;
            int result14 = (((((result12 + iHashCode2) * 31) + result13) * 31) + ((int) this.A0M)) * 31;
            int result15 = this.A0L;
            int result16 = (((result14 + result15) * 31) + this.A0A) * 31;
            int result17 = Float.floatToIntBits(this.A01);
            int result18 = (((result16 + result17) * 31) + this.A0F) * 31;
            int result19 = Float.floatToIntBits(this.A02);
            int result20 = (((result18 + result19) * 31) + this.A0I) * 31;
            int result21 = this.A06;
            int result22 = (((result20 + result21) * 31) + this.A0G) * 31;
            int result23 = this.A0C;
            int result24 = (((result22 + result23) * 31) + this.A08) * 31;
            int result25 = this.A09;
            int result26 = (((result24 + result25) * 31) + this.A03) * 31;
            int result27 = this.A0J;
            int result28 = (((result26 + result27) * 31) + this.A0K) * 31;
            int result29 = this.A07;
            this.A00 = result28 + result29;
        }
        return this.A00;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(A04(5, 7, 96)).append(this.A0T);
        String strA04 = A04(0, 2, 52);
        return sbAppend.append(strA04).append(this.A0U).append(strA04).append(this.A0S).append(strA04).append(this.A0W).append(strA04).append(this.A0R).append(strA04).append(this.A05).append(strA04).append(this.A0V).append(A04(2, 3, 90)).append(this.A0L).append(strA04).append(this.A0A).append(strA04).append(this.A01).append(A04(14, 4, 78)).append(this.A06).append(strA04).append(this.A0G).append(A04(12, 2, 122)).toString();
    }
}
