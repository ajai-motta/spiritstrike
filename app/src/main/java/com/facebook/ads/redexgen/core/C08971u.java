package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import androidx.compose.material.TextFieldImplKt;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C08971u implements InterfaceC1103Al {
    public static byte[] A09;
    public static String[] A0A = {"5g", "bfnfjiUri9kvxuLEKnZU3kJc1ieY23zz", "NIX", "B1MUzprhDDigVQ4p3NlPN3VyWdkPEAJB", "UzK", "rOCmuOM4l5uJjn2akKGm2JxYL79BUlOr", "kAulvLpzcmVynuK8kNGYEaaJbNqcwElD", "7ScKsdjGN77oK2tO1d"};
    public static final String A0B;
    public long A00;
    public InterfaceC2771rK A01;
    public final InterfaceC2770rJ A02;
    public final C2763rB A03;
    public final C2763rB A04;
    public final List<Rect> A05;
    public final Map<String, C2762rA> A06;
    public final boolean A07;
    public final boolean A08;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0A;
            if (strArr[3].charAt(2) == strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "GBjOApmdB9meVYu3h8dWYwSrfWPE5QmB";
            strArr2[6] = "rSzbUr5mB5cqWCHa6t40U5C3uIAdU8ry";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 73);
            i4++;
        }
    }

    public static void A03() {
        A09 = new byte[]{Ascii.DC4, 40, 41, 51, 96, 54, 41, 37, 55, 48, 47, 41, 46, 52, 96, 40, 33, 51, 96, 46, 47, 52, 96, 34, 37, 37, 46, 96, 45, 37, 33, 51, 53, 50, 37, 36, 96, 47, 50, 96, 41, 51, 96, 33, 96, 39, 50, 47, 53, 48, 96, 55, 40, 41, 35, 40, 96, 55, 41, 44, 44, 96, 46, 37, 54, 37, 50, 96, 50, 37, 52, 53, 50, 46, 96, 33, 96, 45, 37, 33, 51, 53, 50, 37, 45, 37, 46, 52, 96, 51, 41, 46, 35, 37, 96, 41, 52, 103, 51, 96, 45, 33, 36, 37, 96, 53, 48, 96, 47, 38, 96, 51, 53, 34, 54, 41, 37, 55, 51, 96, 52, 40, 33, 52, 96, 35, 47, 53, 44, 36, 96, 34, 37, 96, 47, 38, 38, 51, 35, 50, 37, 37, 46, Ascii.DLE, Ascii.ESC, 9, 45, Ascii.GS, Ascii.US, Ascii.DLE, Base64.padSymbol, 38, 63, 63, 115, 37, 58, 54, 36, 115, 35, 33, 60, 35, 54, 33, 39, 42, 115, 53, 60, 33, 115, 33, 54, 62, 60, 37, 54, 55, 115, 58, 39, 54, 62, 115, Ascii.RS, 2, Ascii.VT, Ascii.EM, 63, 8, Ascii.GS, 2, Ascii.US, Ascii.EM};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1103Al
    public final void A6P(List<C2774rN<?, ?>> list) {
        if (list != null && !list.isEmpty()) {
            A06(list);
        }
        A05(this.A04);
        A04(this.A04);
        A05(this.A03);
        A04(this.A03);
        if (0 != 0) {
            new C2761r9(toString(), this, this.A05, this.A04.A00(), this.A03.A00());
            throw new NullPointerException(A02(143, 7, 55));
        }
    }

    static {
        A03();
        A0B = C08971u.class.getSimpleName();
    }

    public C08971u(InterfaceC2770rJ interfaceC2770rJ) {
        this(interfaceC2770rJ, false, false);
    }

    public C08971u(InterfaceC2770rJ interfaceC2770rJ, boolean z, boolean z2) {
        this.A06 = new HashMap();
        this.A04 = new C2763rB();
        this.A03 = new C2763rB();
        this.A05 = new ArrayList(1);
        this.A02 = interfaceC2770rJ;
        this.A08 = z;
        this.A07 = z2;
    }

    public static Rect A00(C2762rA c2762rA) {
        if (c2762rA == null || c2762rA.A02.top == Integer.MIN_VALUE || c2762rA.A02.left == Integer.MIN_VALUE || c2762rA.A02.right == Integer.MIN_VALUE || c2762rA.A02.bottom == Integer.MIN_VALUE) {
            throw new IllegalStateException(A02(0, 143, 9));
        }
        return c2762rA.A02;
    }

    private C2762rA A01(C2774rN c2774rN, Rect rect, Rect rect2) {
        C2762rA c2762rAA03 = this.A06.get(c2774rN.A02);
        if (this.A04.A06(c2774rN)) {
            if (c2762rAA03 != null) {
                c2762rAA03.A01 = EnumC2766rE.A04;
            } else {
                c2762rAA03 = C2762rA.A03(this.A00);
                this.A06.put(c2774rN.A02, c2762rAA03);
            }
        }
        if (c2762rAA03 != null) {
            c2762rAA03.A02.set(rect2);
            c2762rAA03.A03.add(new Rect(rect));
        }
        return c2762rAA03;
    }

    private void A04(C2763rB c2763rB) {
        for (C2774rN c2774rN : c2763rB.A01()) {
            C2762rA c2762rA = this.A06.get(c2774rN.A02);
            if (c2762rA == null) {
                if (0 != 0) {
                    String str = A02(TextFieldImplKt.AnimationDuration, 36, 26) + c2774rN.A02;
                    throw new NullPointerException(A02(186, 10, 36));
                }
            } else {
                c2762rA.A01 = EnumC2766rE.A03;
                c2762rA.A03.clear();
                if (A07(c2774rN)) {
                    c2774rN.A03(this);
                }
                if (this.A08) {
                    this.A06.remove(c2762rA);
                }
            }
        }
    }

    private void A05(C2763rB c2763rB) {
        for (C2774rN visible : c2763rB.A00()) {
            if (A07(visible)) {
                visible.A03(this);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(java.util.List<com.facebook.ads.redexgen.core.C2774rN<?, ?>> r7) {
        /*
            r6 = this;
            java.util.Iterator r5 = r7.iterator()
        L4:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L6f
            java.lang.Object r3 = r5.next()
            com.facebook.ads.redexgen.X.rN r3 = (com.facebook.ads.redexgen.core.C2774rN) r3
            java.util.Map<java.lang.String, com.facebook.ads.redexgen.X.rA> r1 = r6.A06
            java.lang.String r0 = r3.A02
            java.lang.Object r0 = r1.get(r0)
            com.facebook.ads.redexgen.X.rA r0 = (com.facebook.ads.redexgen.core.C2762rA) r0
            if (r0 == 0) goto L4
            boolean r4 = r3.A04
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C08971u.A0A
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L30
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L30:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08971u.A0A
            java.lang.String r1 = "nPwsVC"
            r0 = 7
            r2[r0] = r1
            if (r4 == 0) goto L4
            com.facebook.ads.redexgen.X.rE r4 = r3.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08971u.A0A
            r0 = 5
            r1 = r2[r0]
            r0 = 6
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L60
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08971u.A0A
            java.lang.String r1 = "zj"
            r0 = 0
            r2[r0] = r1
            if (r4 == 0) goto L4
        L56:
            com.facebook.ads.redexgen.X.rE r1 = r3.A01
            com.facebook.ads.redexgen.X.rE r0 = com.facebook.ads.redexgen.core.EnumC2766rE.A03
            if (r1 == r0) goto L4
            r3.A03(r6)
            goto L4
        L60:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08971u.A0A
            java.lang.String r1 = "4Gl"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "t26"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L4
            goto L56
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C08971u.A06(java.util.List):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public static boolean A07(C2774rN<?, ?> c2774rN) {
        if (c2774rN.A04) {
            EnumC2775rO enumC2775rO = c2774rN.A00;
            EnumC2775rO enumC2775rO2 = EnumC2775rO.A04;
            String[] strArr = A0A;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A0A[7] = "iICfc1p4CYNR1vFaz";
            if (enumC2775rO == enumC2775rO2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1103Al
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A46(com.facebook.ads.redexgen.core.C2774rN r8, android.graphics.Rect r9, android.graphics.Rect r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C08971u.A46(com.facebook.ads.redexgen.X.rN, android.graphics.Rect, android.graphics.Rect, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1103Al
    public final void A4h(long j, List<Rect> list) {
        this.A00 = j;
        this.A05.clear();
        Iterator<Rect> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A0A;
            if (strArr[3].charAt(2) == strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[4] = "xWg";
            strArr2[2] = "l5f";
            if (zHasNext) {
                this.A05.add(new Rect(it.next()));
            } else {
                Iterator it2 = this.A04.A01().iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    if (A0A[0].length() == 2) {
                        String[] strArr3 = A0A;
                        strArr3[3] = "KXc0LwnJCEJYYpq44EYPYXvj71LHxLBt";
                        strArr3[1] = "SZ9db6jeJg1WeryC8zmRUBHGUrGxU8hd";
                        if (!zHasNext2) {
                            break;
                        }
                        this.A06.remove(((C2774rN) it2.next()).A02);
                    } else {
                        if (!zHasNext2) {
                            break;
                        }
                        this.A06.remove(((C2774rN) it2.next()).A02);
                    }
                }
                Collection<C2774rN> collectionA01 = this.A03.A01();
                if (A0A[0].length() != 2) {
                    throw new RuntimeException();
                }
                A0A[0] = "Au";
                for (C2774rN viewpointData : collectionA01) {
                    this.A06.remove(viewpointData.A02);
                }
                Iterator<C2762rA> it3 = this.A06.values().iterator();
                while (it3.hasNext()) {
                    it3.next().A03.clear();
                }
                this.A04.A04();
                this.A03.A04();
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2765rD
    public final void A8D(C2774rN c2774rN, Rect rect) {
        if (!this.A06.containsKey(c2774rN.A02)) {
            return;
        }
        rect.setEmpty();
        for (Rect rect2 : this.A06.get(c2774rN.A02).A03) {
            if (A0A[7].length() == 26) {
                throw new RuntimeException();
            }
            A0A[7] = "8y";
            rect.union(rect2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2765rD
    public final EnumC2766rE A9U(C2774rN c2774rN) {
        if (!this.A06.containsKey(c2774rN.A02)) {
            return EnumC2766rE.A02;
        }
        EnumC2766rE enumC2766rE = this.A06.get(c2774rN.A02).A01;
        if (c2774rN.A04) {
            if (c2774rN.A00 == EnumC2775rO.A04) {
                EnumC2766rE viewState = EnumC2766rE.A03;
                return viewState;
            }
            EnumC2766rE viewState2 = EnumC2766rE.A04;
            if (enumC2766rE == viewState2 && !c2774rN.A04()) {
                EnumC2766rE viewState3 = EnumC2766rE.A02;
                return viewState3;
            }
        }
        return enumC2766rE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2765rD
    public final void A9W(Rect rect) {
        rect.setEmpty();
        Iterator<Rect> it = this.A05.iterator();
        while (it.hasNext()) {
            rect.union(it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2765rD
    public final float A9X(C2774rN c2774rN) {
        C2762rA c2762rA = this.A06.get(c2774rN.A02);
        if (c2762rA != null) {
            Rect rectA00 = A00(c2762rA);
            int iHeight = rectA00.height() * rectA00.width();
            int totalVisibleArea = 0;
            for (Rect rect : c2762rA.A03) {
                totalVisibleArea += rect.height() * rect.width();
            }
            return totalVisibleArea / iHeight;
        }
        return 0.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1103Al
    public final void AJu(InterfaceC2771rK interfaceC2771rK) {
        this.A01 = interfaceC2771rK;
    }
}
