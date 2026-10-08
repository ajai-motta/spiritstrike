package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C10829h extends AbstractC2536nD {
    public static byte[] A07;
    public static String[] A08 = {"yr7s5jzv1addyUjDczkFmKgb3TbXTjPI", "k5bxDF12X7IfueMvpCyLhsS14secbcRr", "A1nn9z9SPvnfAziOnMuSk0GZzxZ0jVfY", "Bn8GSVMc2Ww3cTp6j1ZQIVGuo4fvIYJ3", "KOSGSA", "kbDMqlVGuQuF7sZpY9G1V32bVqx23m", "bfxskyCfRQ3e5JfVyMYK1TBq", "KPf5jweXKATwb3ocWNu711OjnnCWcsTU"};
    public static final AbstractC2727qK<Integer> A09;
    public static final AbstractC2727qK<Integer> A0A;
    public C2731qQ A00;
    public C10839i A01;
    public C1197Ef A02;
    public final Context A03;
    public final InterfaceC1204Em A04;
    public final Object A05;
    public final boolean A06;

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c7, code lost:
    
        if (r18.A01.A0A == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if (r7.isEmpty() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d5, code lost:
    
        if (r7.size() != r10.A01) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d7, code lost:
    
        r6.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e7, code lost:
    
        if (com.facebook.ads.redexgen.core.C10829h.A08[1].charAt(16) == 'p') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e9, code lost:
    
        com.facebook.ads.redexgen.core.C10829h.A08[4] = "67hsDi";
        r6.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f3, code lost:
    
        r14.addAll(r6);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
    
        com.facebook.ads.redexgen.core.C10829h.A08[4] = "yJ8LwG";
        r6.add(r7);
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("D25277746")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T extends com.facebook.ads.redexgen.core.AbstractC1199Eh<T>> android.util.Pair<com.facebook.ads.redexgen.core.C1203El, java.lang.Integer> A0A(int r19, com.facebook.ads.redexgen.core.C1206Eo r20, int[][][] r21, com.facebook.ads.redexgen.core.InterfaceC1198Eg<T> r22, java.util.Comparator<java.util.List<T>> r23) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A0A(int, com.facebook.ads.redexgen.X.Eo, int[][][], com.facebook.ads.redexgen.X.Eg, java.util.Comparator):android.util.Pair");
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A08[5].length() == 27) {
                throw new RuntimeException();
            }
            A08[4] = "58VoVy";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 10);
            i4++;
        }
    }

    public static void A0M() {
        A07 = new byte[]{91, 92, -112, 127, -124, -118, 59, 126, -125, 124, -119, -119, -128, -121, 59, 126, -118, -112, -119, -113, 59, 126, -118, -119, -114, -113, -115, 124, -124, -119, -113, -114, 59, 126, 124, -119, -119, -118, -113, 59, 125, -128, 59, 124, -117, -117, -121, -124, -128, 127, 59, -110, -124, -113, -125, -118, -112, -113, 59, -115, -128, -127, -128, -115, -128, -119, 126, -128, 59, -113, -118, 59, 94, -118, -119, -113, -128, -109, -113, 73, 59, 93, -112, -124, -121, 127, 59, -113, -125, -128, 59, -113, -115, 124, 126, -122, 59, -114, -128, -121, -128, 126, -113, -118, -115, 59, -124, -119, -114, -113, 124, -119, 126, -128, 59, -110, -124, -113, -125, 59, -118, -119, -128, 59, -118, -127, 59, -113, -125, -128, 59, -119, -118, -119, 72, 127, -128, -117, -115, -128, 126, 124, -113, -128, 127, 59, 126, -118, -119, -114, -113, -115, -112, 126, -113, -118, -115, -114, 59, -113, -125, 124, -113, 59, -113, 124, -122, -128, 59, 124, 59, 94, -118, -119, -113, -128, -109, -113, 59, 124, -115, -126, -112, -120, -128, -119, -113, 73, -103, -70, -69, -74, -54, -63, -55, -87, -57, -74, -72, -64, -88, -70, -63, -70, -72, -55, -60, -57, -57, -37, -54, -49, -43, -107, -57, -55, -103, -83, -63, -80, -75, -69, 123, -83, -81, -128, -49, -29, -46, -41, -35, -99, -45, -49, -47, -95, -70, -50, -67, -62, -56, -120, -66, -70, -68, -116, -122, -61, -56, -68, -54, -61, -71, -119, 124, 119, 120, -126, 66, 116, -119, 67, 68, -98, -111, -116, -115, -105, 87, -119, -98, -117, -33, -46, -51, -50, -40, -104, -51, -40, -43, -53, -30, -106, -33, -46, -36, -46, -40, -41, -92, -105, -110, -109, -99, 93, -106, -109, -92, -111, -11, -24, -29, -28, -18, -82, -9, -84, -11, -19, -29, -83, -18, -19, -79, -83, -11, -17, -72};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0N(C2555nW c2555nW, C2684pc c2684pc, Map<Integer, C2686pe> map) {
        C2686pe c2686pe;
        for (int i = 0; i < c2555nW.A01; i++) {
            C2686pe c2686pe2 = c2684pc.A0G.get(c2555nW.A05(i));
            if (c2686pe2 != null && ((c2686pe = map.get(Integer.valueOf(c2686pe2.A01()))) == null || (c2686pe.A01.isEmpty() && !c2686pe2.A01.isEmpty()))) {
                map.put(Integer.valueOf(c2686pe2.A01()), c2686pe2);
            }
        }
    }

    static {
        A0M();
        A09 = AbstractC2727qK.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.EZ
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C10829h.A05((Integer) obj, (Integer) obj2);
            }
        });
        A0A = AbstractC2727qK.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.Ea
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C10829h.A06((Integer) obj, (Integer) obj2);
            }
        });
    }

    @Deprecated
    public C10829h() {
        this(C10839i.A0J, new C2550nR());
    }

    @MetaExoPlayerCustomization(type = {"NEW_CONSTRUCTOR"}, value = "Backward Compatible Constructor")
    public C10829h(InterfaceC1204Em interfaceC1204Em) {
        this(C10839i.A0J, interfaceC1204Em);
    }

    @Deprecated
    public C10829h(C2684pc c2684pc, InterfaceC1204Em interfaceC1204Em) {
        this(c2684pc, interfaceC1204Em, null);
    }

    public C10829h(C2684pc c2684pc, InterfaceC1204Em interfaceC1204Em, Context context) {
        this.A05 = new Object();
        this.A03 = context != null ? context.getApplicationContext() : null;
        this.A04 = interfaceC1204Em;
        if (c2684pc instanceof C10839i) {
            this.A01 = (C10839i) c2684pc;
        } else {
            C10839i defaultParameters = context == null ? C10839i.A0J : C10839i.A02(context);
            this.A01 = defaultParameters.A0P().A0u(c2684pc).A0p();
        }
        this.A00 = C2731qQ.A07;
        this.A06 = context != null && C5C.A18(context);
        if (!this.A06 && context != null && C5C.A02 >= 32) {
            this.A02 = C1197Ef.A00(context);
        }
        if (this.A01.A08 && context == null) {
            AbstractC09574g.A07(A0J(TsExtractor.TS_PACKET_SIZE, 20, 75), A0J(1, 187, 17));
        }
    }

    public static int A00(int i, int i2) {
        if (i != 0 && i == i2) {
            return Integer.MAX_VALUE;
        }
        return Integer.bitCount(i & i2);
    }

    public static int A02(C2725qI c2725qI, String str, boolean z) {
        String strA0K;
        if (TextUtils.isEmpty(str)) {
            String strA0K2 = A0K(str);
            strA0K = A0K(c2725qI.A0V);
            if (strA0K != null) {
            }
            if (z) {
                return 0;
            }
        }
        String str2 = c2725qI.A0V;
        String[] strArr = A08;
        if (strArr[6].length() != strArr[3].length()) {
            A08[7] = "utaRfuDCbQDIc6IM3a2tNPgwwhECnGgZ";
            if (str.equals(str2)) {
                if (A08[4].length() != 6) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[6] = "bdPum8qTTDlHeCQDHcvgSGFt";
                strArr2[3] = "zx28NE7Z14W3AzzAuoWnzSjL1M2eUdTs";
                return 4;
            }
            String strA0K22 = A0K(str);
            strA0K = A0K(c2725qI.A0V);
            if (strA0K != null || strA0K22 == null) {
                return (z && strA0K == null) ? 1 : 0;
            }
            if (strA0K.startsWith(strA0K22) || strA0K22.startsWith(strA0K)) {
                return 3;
            }
            String strA0J = A0J(0, 1, 36);
            String str3 = C5C.A1P(strA0K, strA0J)[0];
            String formatMainLanguage = C5C.A1P(strA0K22, strA0J)[0];
            String[] strArr3 = A08;
            String str4 = strArr3[6];
            String formatLanguage = strArr3[3];
            if (str4.length() != formatLanguage.length()) {
                A08[4] = "rXSrCW";
                if (!str3.equals(formatMainLanguage)) {
                    return 0;
                }
                return 2;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x000e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A03(com.facebook.ads.redexgen.core.C2688pg r8, int r9, int r10, boolean r11) {
        /*
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r0) goto L7
            if (r10 != r0) goto L8
        L7:
            return r0
        L8:
            r5 = 2147483647(0x7fffffff, float:NaN)
            r4 = 0
        Lc:
            int r0 = r8.A01
            if (r4 >= r0) goto L44
            com.facebook.ads.redexgen.X.qI r7 = r8.A08(r4)
            int r0 = r7.A0L
            if (r0 <= 0) goto L41
            int r0 = r7.A0A
            if (r0 <= 0) goto L41
            int r1 = r7.A0L
            int r0 = r7.A0A
            android.graphics.Point r6 = A09(r11, r9, r10, r1, r0)
            int r3 = r7.A0L
            int r0 = r7.A0A
            int r3 = r3 * r0
            int r1 = r7.A0L
            int r0 = r6.x
            float r0 = (float) r0
            r2 = 1065017672(0x3f7ae148, float:0.98)
            float r0 = r0 * r2
            int r0 = (int) r0
            if (r1 < r0) goto L41
            int r1 = r7.A0A
            int r0 = r6.y
            float r0 = (float) r0
            float r0 = r0 * r2
            int r0 = (int) r0
            if (r1 < r0) goto L41
            if (r3 >= r5) goto L41
            r5 = r3
        L41:
            int r4 = r4 + 1
            goto Lc
        L44:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A03(com.facebook.ads.redexgen.X.pg, int, int, boolean):int");
    }

    public static /* synthetic */ int A05(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        int iIntValue = num.intValue();
        int iIntValue2 = num2.intValue();
        if (A08[4].length() != 6) {
            throw new RuntimeException();
        }
        A08[1] = "gB7bm57sTKDjvfC8pNahT9wGVNX6TDKL";
        return iIntValue - iIntValue2;
    }

    public static /* synthetic */ int A06(Integer num, Integer num2) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[RETURN] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A07(java.lang.String r9) {
        /*
            r8 = 0
            if (r9 != 0) goto L4
            return r8
        L4:
            int r0 = r9.hashCode()
            r7 = 1
            r6 = 2
            r5 = 3
            r4 = 4
            switch(r0) {
                case -1851077871: goto L75;
                case -1662735862: goto L4a;
                case -1662541442: goto L38;
                case 1331836730: goto L26;
                case 1599127257: goto L14;
                default: goto Lf;
            }
        Lf:
            r0 = -1
        L10:
            switch(r0) {
                case 0: goto L8b;
                case 1: goto L8a;
                case 2: goto L89;
                case 3: goto L88;
                case 4: goto L87;
                default: goto L13;
            }
        L13:
            return r8
        L14:
            r2 = 300(0x12c, float:4.2E-43)
            r1 = 19
            r0 = 117(0x75, float:1.64E-43)
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 3
            goto L10
        L26:
            r2 = 263(0x107, float:3.69E-43)
            r1 = 9
            r0 = 30
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 4
            goto L10
        L38:
            r2 = 290(0x122, float:4.06E-43)
            r1 = 10
            r0 = 36
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 2
            goto L10
        L4a:
            r3 = 253(0xfd, float:3.55E-43)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L8d
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "cKYBOGEqW486lDdcpu93NQ9TicEen6vk"
            r0 = 1
            r2[r0] = r1
            r1 = 10
            r0 = 9
            java.lang.String r0 = A0J(r3, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 1
            goto L10
        L75:
            r2 = 272(0x110, float:3.81E-43)
            r1 = 18
            r0 = 95
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 0
            goto L10
        L87:
            return r7
        L88:
            return r6
        L89:
            return r5
        L8a:
            return r4
        L8b:
            r0 = 5
            return r0
        L8d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A07(java.lang.String):int");
    }

    @MetaExoPlayerCustomization("Made public in D13395849")
    public static Point A09(boolean z, int tempViewportWidth, int i, int i2, int i3) {
        if (z) {
            if ((i2 > i3) != (tempViewportWidth > i)) {
                tempViewportWidth = i;
                i = tempViewportWidth;
            }
        }
        if (i2 * i >= i3 * tempViewportWidth) {
            return new Point(tempViewportWidth, C5C.A05(tempViewportWidth * i3, i2));
        }
        return new Point(C5C.A05(i * i2, i3), i);
    }

    private final Pair<C1203El, Integer> A0B(C1206Eo c1206Eo, int[][][] iArr, final C10839i c10839i, final String str) throws AD {
        return A0A(3, c1206Eo, iArr, new InterfaceC1198Eg() { // from class: com.facebook.ads.redexgen.X.nN
            @Override // com.facebook.ads.redexgen.core.InterfaceC1198Eg
            public final List A5F(int i, C2688pg c2688pg, int[] iArr2) {
                return C2539nG.A02(i, c2688pg, c10839i, iArr2, str);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EY
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2539nG.A01((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<C1203El, Integer> A0C(C1206Eo c1206Eo, int[][][] iArr, int[] iArr2, final C10839i c10839i) throws AD {
        final boolean z = false;
        int i = 0;
        while (true) {
            if (i < c1206Eo.A02()) {
                if (2 == c1206Eo.A03(i) && c1206Eo.A07(i).A01 > 0) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return A0A(1, c1206Eo, iArr, new InterfaceC1198Eg() { // from class: com.facebook.ads.redexgen.X.nO
            @Override // com.facebook.ads.redexgen.core.InterfaceC1198Eg
            public final List A5F(int i2, C2688pg c2688pg, int[] iArr3) {
                return this.A01.A0e(c10839i, z, i2, c2688pg, iArr3);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EX
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2545nM.A02((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<C1203El, Integer> A0D(C1206Eo c1206Eo, int[][][] iArr, final int[] iArr2, final C10839i c10839i, final String str) throws AD {
        return A0A(2, c1206Eo, iArr, new InterfaceC1198Eg() { // from class: com.facebook.ads.redexgen.X.nQ
            @Override // com.facebook.ads.redexgen.core.InterfaceC1198Eg
            public final List A5F(int i, C2688pg c2688pg, int[] iArr3) {
                return C2538nF.A06(i, c2688pg, c10839i, iArr3, str, iArr2[i]);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EW
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2538nF.A05((List) obj, (List) obj2);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.core.C1203El A0E(int r13, com.facebook.ads.redexgen.core.C2555nW r14, int[][] r15, com.facebook.ads.redexgen.core.C10839i r16) throws com.facebook.ads.redexgen.core.AD {
        /*
            r12 = this;
            r7 = 0
            r11 = 0
            r6 = 0
            r5 = 0
        L4:
            int r0 = r14.A01
            if (r5 >= r0) goto L8c
            com.facebook.ads.redexgen.X.pg r4 = r14.A05(r5)
            r10 = r15[r5]
            r3 = 0
        Lf:
            int r8 = r4.A01
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 7
            r1 = r1[r0]
            r0 = 4
            char r1 = r1.charAt(r0)
            r0 = 114(0x72, float:1.6E-43)
            if (r1 == r0) goto L86
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "eXe48tlcaaFOVphj3tBJsJZ33XViaUIe"
            r0 = 7
            r2[r0] = r1
            if (r3 >= r8) goto L7d
            r8 = r10[r3]
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 7
            r1 = r1[r0]
            r0 = 4
            char r1 = r1.charAt(r0)
            r0 = 114(0x72, float:1.6E-43)
            if (r1 == r0) goto L80
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "FFBXZuvHsKfXoft1igGzNsuMgLJqlaBK"
            r0 = 7
            r2[r0] = r1
            r0 = r16
            boolean r0 = r0.A0B
            boolean r0 = A0S(r8, r0)
            if (r0 == 0) goto L7a
            com.facebook.ads.redexgen.X.qI r1 = r4.A08(r3)
            com.facebook.ads.redexgen.X.Ec r8 = new com.facebook.ads.redexgen.X.Ec
            r0 = r10[r3]
            r8.<init>(r1, r0)
            if (r6 == 0) goto L77
            int r9 = r8.compareTo(r6)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 0
            r1 = r2[r0]
            r0 = 2
            r2 = r2[r0]
            r0 = 9
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L86
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "us6BKPnONaHSk6j2pgBHNNPTLKUclzqr"
            r0 = 1
            r2[r0] = r1
            if (r9 <= 0) goto L7a
        L77:
            r7 = r4
            r11 = r3
            r6 = r8
        L7a:
            int r3 = r3 + 1
            goto Lf
        L7d:
            int r5 = r5 + 1
            goto L4
        L80:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L86:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L8c:
            if (r7 != 0) goto L90
            r1 = 0
        L8f:
            return r1
        L90:
            int[] r0 = new int[]{r11}
            com.facebook.ads.redexgen.X.El r1 = new com.facebook.ads.redexgen.X.El
            r1.<init>(r7, r0)
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A0E(int, com.facebook.ads.redexgen.X.nW, int[][], com.facebook.ads.redexgen.X.9i):com.facebook.ads.redexgen.X.El");
    }

    public static String A0K(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, A0J(250, 3, 75))) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        boolean z;
        synchronized (this.A05) {
            z = this.A01.A08 && !this.A06 && C5C.A02 >= 32 && this.A02 != null && this.A02.A06();
        }
        if (z) {
            A01();
        }
    }

    public static void A0P(C1206Eo c1206Eo, C2684pc c2684pc, C1203El[] c1203ElArr) {
        C1203El c1203El;
        int iA02 = c1206Eo.A02();
        HashMap map = new HashMap();
        for (int i = 0; i < iA02; i++) {
            A0N(c1206Eo.A07(i), c2684pc, map);
        }
        A0N(c1206Eo.A06(), c2684pc, map);
        for (int i2 = 0; i2 < iA02; i2++) {
            int rendererCount = c1206Eo.A03(i2);
            C2686pe c2686pe = (C2686pe) map.get(Integer.valueOf(rendererCount));
            if (c2686pe != null) {
                boolean zIsEmpty = c2686pe.A01.isEmpty();
                if (A08[7].charAt(4) == 'r') {
                    throw new RuntimeException();
                }
                A08[4] = "YbaSeo";
                if (!zIsEmpty && c1206Eo.A07(i2).A04(c2686pe.A00) != -1) {
                    c1203El = new C1203El(c2686pe.A00, AbstractC1109As.A0B(c2686pe.A01));
                } else {
                    c1203El = null;
                }
                c1203ElArr[i2] = c1203El;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0Q(com.facebook.ads.redexgen.core.C1206Eo r8, com.facebook.ads.redexgen.core.C10839i r9, com.facebook.ads.redexgen.core.C1203El[] r10) {
        /*
            int r5 = r8.A02()
            r4 = 0
        L5:
            if (r4 >= r5) goto L71
            com.facebook.ads.redexgen.X.nW r3 = r8.A07(r4)
            boolean r0 = r9.A0S(r4, r3)
            if (r0 != 0) goto L14
        L11:
            int r4 = r4 + 1
            goto L5
        L14:
            com.facebook.ads.redexgen.X.nH r6 = r9.A0Q(r4, r3)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L6b
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "K8f1XF422sl3cXXm"
            r0 = 5
            r2[r0] = r1
            if (r6 == 0) goto L63
            int[] r0 = r6.A03
            int r7 = r0.length
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L65
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "KnBpd5"
            r0 = 4
            r2[r0] = r1
            if (r7 == 0) goto L63
            int r0 = r6.A00
            com.facebook.ads.redexgen.X.pg r3 = r3.A05(r0)
            int[] r2 = r6.A03
            int r1 = r6.A02
            com.facebook.ads.redexgen.X.El r0 = new com.facebook.ads.redexgen.X.El
            r0.<init>(r3, r2, r1)
        L60:
            r10[r4] = r0
            goto L11
        L63:
            r0 = 0
            goto L60
        L65:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L6b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A0Q(com.facebook.ads.redexgen.X.Eo, com.facebook.ads.redexgen.X.9i, com.facebook.ads.redexgen.X.El[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if (r4 != 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r4 != 2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r3 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (A0W(r12[r7], r11.A07(r7), r3) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r4 != 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r9 == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r8 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r4 != 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0R(com.facebook.ads.redexgen.core.C1206Eo r11, int[][][] r12, com.facebook.ads.redexgen.core.C10477s[] r13, com.facebook.ads.redexgen.core.InterfaceC2537nE[] r14) {
        /*
            r9 = -1
            r8 = -1
            r10 = 1
            r7 = 0
        L4:
            int r3 = r11.A02()
            r6 = -1
            r5 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 6
            if (r1 == r0) goto L1c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1c:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "NZY9D9dgjYLNZ0XYpF4W2GrX5uVEwVhV"
            r0 = 1
            r2[r0] = r1
            if (r7 >= r3) goto L5e
            int r4 = r11.A03(r7)
            r3 = r14[r7]
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            r0 = 0
            r1 = r2[r0]
            r0 = 2
            r2 = r2[r0]
            r0 = 9
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L76
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "nPMicF"
            r0 = 4
            r2[r0] = r1
            if (r4 == r5) goto L4b
        L48:
            r0 = 2
            if (r4 != r0) goto L88
        L4b:
            if (r3 == 0) goto L88
            r1 = r12[r7]
            com.facebook.ads.redexgen.X.nW r0 = r11.A07(r7)
            boolean r0 = A0W(r1, r0, r3)
            if (r0 == 0) goto L88
            if (r4 != r5) goto L72
            if (r9 == r6) goto L85
            r10 = 0
        L5e:
            if (r9 == r6) goto L70
            if (r8 == r6) goto L70
            r0 = 1
        L63:
            r10 = r10 & r0
            if (r10 == 0) goto L6f
            com.facebook.ads.redexgen.X.7s r0 = new com.facebook.ads.redexgen.X.7s
            r0.<init>(r5)
            r13[r9] = r0
            r13[r8] = r0
        L6f:
            return
        L70:
            r0 = 0
            goto L63
        L72:
            if (r8 == r6) goto L87
            r10 = 0
            goto L5e
        L76:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C10829h.A08
            java.lang.String r1 = "5F5ko3NIDU1YMXmZZUDVXdSE"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "1c60xx4jFCOb1nSxKeVAoj10cRAS07b7"
            r0 = 3
            r2[r0] = r1
            if (r4 == r5) goto L4b
            goto L48
        L85:
            r9 = r7
            goto L88
        L87:
            r8 = r7
        L88:
            int r7 = r7 + 1
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A0R(com.facebook.ads.redexgen.X.Eo, int[][][], com.facebook.ads.redexgen.X.7s[], com.facebook.ads.redexgen.X.nE[]):void");
    }

    @MetaExoPlayerCustomization("Made public for customization on DashManifestHelper")
    public static boolean A0S(int i, boolean z) {
        int iA03 = AbstractC10377i.A03(i);
        return iA03 == 4 || (z && iA03 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0T(C2725qI c2725qI) {
        boolean z;
        synchronized (this.A05) {
            z = !this.A01.A08 || this.A06 || c2725qI.A06 <= 2 || (A0U(c2725qI) && (C5C.A02 < 32 || this.A02 == null || !this.A02.A06())) || (C5C.A02 >= 32 && this.A02 != null && this.A02.A06() && this.A02.A04() && this.A02.A05() && this.A02.A07(this.A00, c2725qI));
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0U(com.facebook.ads.redexgen.core.C2725qI r6) {
        /*
            java.lang.String r0 = r6.A0W
            r5 = 0
            if (r0 != 0) goto L6
            return r5
        L6:
            java.lang.String r3 = r6.A0W
            int r0 = r3.hashCode()
            r4 = 1
            switch(r0) {
                case -2123537834: goto L4b;
                case 187078296: goto L39;
                case 187078297: goto L27;
                case 1504578661: goto L15;
                default: goto L10;
            }
        L10:
            r0 = -1
        L11:
            switch(r0) {
                case 0: goto L5d;
                case 1: goto L5d;
                case 2: goto L5d;
                case 3: goto L5d;
                default: goto L14;
            }
        L14:
            return r5
        L15:
            r2 = 226(0xe2, float:3.17E-43)
            r1 = 10
            r0 = 100
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L27:
            r2 = 217(0xd9, float:3.04E-43)
            r1 = 9
            r0 = 66
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L10
            r0 = 3
            goto L11
        L39:
            r2 = 208(0xd0, float:2.91E-43)
            r1 = 9
            r0 = 92
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L4b:
            r2 = 236(0xec, float:3.31E-43)
            r1 = 14
            r0 = 79
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L10
            r0 = 2
            goto L11
        L5d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C10829h.A0U(com.facebook.ads.redexgen.X.qI):boolean");
    }

    public static boolean A0W(int[][] iArr, C2555nW c2555nW, InterfaceC2537nE interfaceC2537nE) {
        if (interfaceC2537nE == null) {
            return false;
        }
        int iA04 = c2555nW.A04(interfaceC2537nE.A9L());
        for (int i = 0; i < interfaceC2537nE.length(); i++) {
            int trackGroupIndex = AbstractC10377i.A05(iArr[iA04][interfaceC2537nE.A8H(i)]);
            if (trackGroupIndex != 32) {
                return false;
            }
        }
        return true;
    }

    private final C1203El[] A0X(C1206Eo c1206Eo, int[][][] iArr, int[] iArr2, C10839i c10839i) throws AD {
        String str;
        int iA02 = c1206Eo.A02();
        C1203El[] c1203ElArr = new C1203El[iA02];
        Pair<C1203El, Integer> pairA0C = A0C(c1206Eo, iArr, iArr2, c10839i);
        if (pairA0C != null) {
            Object obj = pairA0C.second;
            String[] strArr = A08;
            String str2 = strArr[0];
            String str3 = strArr[2];
            int iCharAt = str2.charAt(9);
            int rendererCount = str3.charAt(9);
            if (iCharAt == rendererCount) {
                throw new RuntimeException();
            }
            A08[7] = "yBKbxgl1qoYBYNtasAVV61g1RQWhRN9O";
            c1203ElArr[((Integer) obj).intValue()] = (C1203El) pairA0C.first;
        }
        if (pairA0C == null) {
            str = null;
        } else {
            C2688pg c2688pg = ((C1203El) pairA0C.first).A01;
            int rendererCount2 = ((C1203El) pairA0C.first).A02[0];
            str = c2688pg.A08(rendererCount2).A0V;
        }
        Pair<C1203El, Integer> pairA0D = A0D(c1206Eo, iArr, iArr2, c10839i, str);
        if (pairA0D != null) {
            c1203ElArr[((Integer) pairA0D.second).intValue()] = (C1203El) pairA0D.first;
        }
        Pair<C1203El, Integer> pairA0B = A0B(c1206Eo, iArr, c10839i, str);
        if (pairA0B != null) {
            c1203ElArr[((Integer) pairA0B.second).intValue()] = (C1203El) pairA0B.first;
        }
        for (int i = 0; i < iA02; i++) {
            int i2 = c1206Eo.A03(i);
            if (i2 != 2 && i2 != 1) {
                String[] strArr2 = A08;
                String str4 = strArr2[0];
                String str5 = strArr2[2];
                int iCharAt2 = str4.charAt(9);
                int rendererCount3 = str5.charAt(9);
                if (iCharAt2 == rendererCount3) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A08;
                strArr3[6] = "1xsmyE1OdjkvrsbXr4cEFZBV";
                strArr3[3] = "D4xPicyrc2caIP01Cw6NBhV2pRXBVsmG";
                if (i2 != 3) {
                    c1203ElArr[i] = A0E(i2, c1206Eo.A07(i), iArr[i], c10839i);
                }
            }
        }
        return c1203ElArr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1214Ew
    public final boolean A0Y() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2536nD
    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "final removed in D35162315")
    public final Pair<C10477s[], InterfaceC2537nE[]> A0d(C1206Eo c1206Eo, int[][][] iArr, int[] iArr2, C2573no c2573no, Timeline timeline) throws Throwable {
        C10839i c10839i;
        synchronized (this.A05) {
            try {
                c10839i = this.A01;
                if (c10839i.A08 && C5C.A02 >= 32 && this.A02 != null) {
                    this.A02.A03(this, (Looper) AbstractC09493y.A02(Looper.myLooper()));
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        int iA02 = c1206Eo.A02();
        C1203El[] c1203ElArrA0X = A0X(c1206Eo, iArr, iArr2, c10839i);
        A0P(c1206Eo, c10839i, c1203ElArrA0X);
        A0Q(c1206Eo, c10839i, c1203ElArrA0X);
        for (int rendererCount = 0; rendererCount < iA02; rendererCount++) {
            int iA03 = c1206Eo.A03(rendererCount);
            if (c10839i.A0R(rendererCount) || c10839i.A0H.contains(Integer.valueOf(iA03))) {
                c1203ElArrA0X[rendererCount] = null;
            }
        }
        InterfaceC2537nE[] interfaceC2537nEArrA5b = this.A04.A5b(c1203ElArrA0X, A00(), c2573no, timeline);
        C10477s[] c10477sArr = new C10477s[iA02];
        for (int i = 0; i < iA02; i++) {
            c10477sArr[i] = !(c10839i.A0R(i) || c10839i.A0H.contains(Integer.valueOf(c1206Eo.A03(i)))) && (c1206Eo.A03(i) == -2 || interfaceC2537nEArrA5b[i] != null) ? C10477s.A01 : null;
        }
        if (c10839i.A0D) {
            A0R(c1206Eo, iArr, c10477sArr, interfaceC2537nEArrA5b);
        }
        return Pair.create(c10477sArr, interfaceC2537nEArrA5b);
    }

    public final /* synthetic */ BP A0e(C10839i c10839i, boolean z, int i, C2688pg c2688pg, int[] iArr) {
        return C2545nM.A03(i, c2688pg, c10839i, iArr, z, new InterfaceC2396kj() { // from class: com.facebook.ads.redexgen.X.nP
            @Override // com.facebook.ads.redexgen.core.InterfaceC2396kj
            public final boolean A4C(Object obj) {
                return this.A00.A0T((C2725qI) obj);
            }
        });
    }
}
