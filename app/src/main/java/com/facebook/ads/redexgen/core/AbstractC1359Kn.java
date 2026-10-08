package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.animation.core.AnimationConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1359Kn {
    public static byte[] A00;
    public static String[] A01 = {"6VJGxYRVGzkOFylAWqo", "TQDRStRjVTcp84EAqriMHD1W", "Y0YMWliml1c9R0RakThzWHnpZrTCSrBu", "hjS3TiOTsIfHHkhXtOFrFHFAaycKEbQY", "GvjOo5wC83Psjizly91M8Dr7lGNbFkes", "VFbjP0ZwmY6IK0pKGb7V8NSJj5u1SgyV", "T0F9FjreghpLds1JHOV1Zh8xCqpA0ysb", "F9ZBXP7xE9Rr53rKOaE"};
    public static final Pattern A02;
    public static final Map<String, Integer> A03;
    public static final Map<String, Integer> A04;
    public static final Pattern A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A06(List<C1347Kb> list, String str, C1355Kj c1355Kj) {
        List<C1356Kk> listA0E = A0E(list, str, c1355Kj);
        for (int i = 0; i < listA0E.size(); i++) {
            C1347Kb c1347Kb = listA0E.get(i).A01;
            if (c1347Kb.A07() != -1) {
                return c1347Kb.A07();
            }
        }
        return -1;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.text.SpannedString A07(java.lang.String r11, java.lang.String r12, java.util.List<com.facebook.ads.redexgen.core.C1347Kb> r13) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A07(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1351Kf A0A(C09724v c09724v, List<C1347Kb> list) {
        String strA0T = c09724v.A0T();
        if (strA0T == null) {
            return null;
        }
        Matcher matcher = A02.matcher(strA0T);
        if (matcher.matches()) {
            return A0B(null, matcher, c09724v, list);
        }
        String strA0T2 = c09724v.A0T();
        if (strA0T2 == null) {
            return null;
        }
        Matcher matcher2 = A02.matcher(strA0T2);
        if (matcher2.matches()) {
            return A0B(strA0T.trim(), matcher2, c09724v, list);
        }
        return null;
    }

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0F() {
        A00 = new byte[]{81, 0, 85, 68, 48, 63, 71, 83, 69, 86, 68, 48, 63, 71, 69, 0, 106, 118, 51, Ascii.DC4, Ascii.FF, Ascii.ESC, Ascii.SYN, 19, Ascii.RS, 90, 93, Ascii.FF, Ascii.US, 8, Ascii.SO, 19, Ascii.EM, Ascii.ESC, Ascii.SYN, 93, 90, Ascii.FF, Ascii.ESC, Ascii.SYN, Ascii.SI, Ascii.US, SignedBytes.MAX_POWER_OF_TWO, 90, 63, Ascii.CAN, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, 86, Ascii.ETB, Ascii.SUB, Ascii.US, 17, Ascii.CAN, Ascii.ESC, 19, Ascii.CAN, 2, 86, 0, Ascii.ETB, Ascii.SUB, 3, 19, 76, 86, 82, 117, 109, 122, 119, 114, 127, 59, 122, 117, 120, 115, 116, 105, 59, 109, 122, 119, 110, 126, 33, 59, 46, Ascii.SYN, Ascii.DC4, Ascii.CR, Ascii.CR, Ascii.DC4, 19, Ascii.SUB, 93, Ascii.US, Ascii.FS, Ascii.EM, 93, Ascii.RS, 8, Ascii.CAN, 93, Ascii.SO, Ascii.CAN, 9, 9, Ascii.DC4, 19, Ascii.SUB, 71, 93, 63, 7, 5, Ascii.FS, Ascii.FS, 5, 2, Ascii.VT, 76, Ascii.SI, Ascii.EM, 9, 76, Ascii.ESC, 5, Ascii.CAN, 4, 76, Ascii.SO, Ascii.CR, 8, 76, 4, 9, Ascii.CR, 8, 9, Ascii.RS, 86, 76, 53, Ascii.SO, Ascii.VT, Ascii.SO, Ascii.SI, Ascii.ETB, Ascii.SO, SignedBytes.MAX_POWER_OF_TWO, 3, Ascii.NAK, 5, SignedBytes.MAX_POWER_OF_TWO, 19, 5, Ascii.DC4, Ascii.DC4, 9, Ascii.SO, 7, SignedBytes.MAX_POWER_OF_TWO, 10, 56, 63, 43, 41, 41, Ascii.RS, 40, 56, Ascii.CR, 60, 47, 46, 56, 47, 40, 83, 47, 93, 46, 123, Ascii.CR, 121, 118, Ascii.SO, Ascii.FF, 121, 86, Ascii.SO, 8, 8, Ascii.ESC, 121, 86, Ascii.SO, Ascii.CR, 121, 118, Ascii.SO, Ascii.FF, Ascii.CR, Ascii.VT, Ascii.SI, Ascii.FF, Ascii.SUB, 1, 81, 92, 89, 87, 94, 10, 6, Ascii.ESC, 45, 93, 88, 96, 93, 83, 94, 92, 84, 4, 1, 57, 4, 10, 19, 3, 119, 114, 74, 118, 108, 116, 123, 118, 115, 75, 120, 125, 121, 113, 7, 2, 58, 8, 4, 2, 0, Ascii.VT, 17, 4, 39, 34, Ascii.SUB, 55, 32, 33, SignedBytes.MAX_POWER_OF_TWO, 69, 125, 85, 74, 75, 86, 71, 91, 94, 102, SignedBytes.MAX_POWER_OF_TWO, 92, 85, 85, 86, 78, 6, 8, 5, 7, Ascii.SI, Ascii.SI, 1, Ascii.CAN, 8, 7, 101, 99, 104, 114, 99, 116, 7, Ascii.GS, 5, 10, 117, 126, 116, 65, 82, 0, 3, Ascii.CR, 4, 5, Ascii.CAN, 3, 4, Ascii.CR, 74, Ascii.US, 4, Ascii.EM, Ascii.US, Ascii.SUB, Ascii.SUB, 5, Ascii.CAN, Ascii.RS, Ascii.SI, Ascii.SO, 74, Ascii.SI, 4, Ascii.RS, 3, Ascii.RS, 19, 80, 74, 77, 76, 90, 87, 88, 81, 69, 76, 79, 93, 107, 110, 106, 98, 65, 68, 67, 72, 35, 38, 33, 42, 98, 35, 42, 41, 59, 113, 116, 115, 120, 48, 111, 116, 122, 117, 105, 106, 116, 113, 105, 79, 67, 69, 71, 76, 86, 67, 5, 1, Ascii.FF, Ascii.FF, 4, Ascii.CR, 53, 57, 40, 43, Ascii.GS, 2, Ascii.RS, 4, Ascii.EM, 4, 2, 3, 73, 94, 95, 84, 79, 65, 78, 82, 37, 59, 69, 67, 7, 0, Ascii.ETB, Ascii.FF, 86, 76, 95, SignedBytes.MAX_POWER_OF_TWO, 0, 7, Ascii.DC2, 1, 7, 110, 124, 44, 63, 40, 46, 51, 57, 59, 54, 68, 91, 90, 71, 86, 52, 40, 33, 33, 34, 58};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0H(SpannableStringBuilder spannableStringBuilder, String str, C1355Kj c1355Kj, List<C1354Ki> list, List<C1347Kb> list2) {
        int iA06 = A06(list2, str, c1355Kj);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, C1354Ki.A03());
        int length = 0;
        int i = c1355Kj.A00;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (A0C(TTAdConstant.VIDEO_COVER_URL_CODE, 2, 49).equals(((C1354Ki) arrayList.get(i2)).A01.A01)) {
                C1354Ki c1354Ki = (C1354Ki) arrayList.get(i2);
                int iA00 = A00(A06(list2, str, c1354Ki.A01), iA06, 1);
                int i3 = c1354Ki.A01.A00 - length;
                int i4 = c1354Ki.A00 - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i3, i4);
                spannableStringBuilder.delete(i3, i4);
                spannableStringBuilder.setSpan(new C2671pP(charSequenceSubSequence.toString(), iA00), i, i3, 33);
                length += charSequenceSubSequence.length();
                i = i3;
            }
        }
    }

    static {
        A0F();
        A02 = Pattern.compile(A0C(187, 26, 35));
        A05 = Pattern.compile(A0C(3, 12, 106));
        HashMap map = new HashMap();
        map.put(A0C(440, 5, 53), Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put(A0C(349, 4, 1), Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put(A0C(AnimationConstants.DefaultDurationMillis, 4, 98), Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put(A0C(TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE, 3, 61), Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put(A0C(445, 6, 75), Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put(A0C(380, 7, 36), Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put(A0C(289, 4, 107), Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put(A0C(284, 5, 98), Integer.valueOf(Color.rgb(0, 0, 0)));
        Map<String, Integer> defaultColors = Collections.unmodifiableMap(map);
        A04 = defaultColors;
        HashMap map2 = new HashMap();
        map2.put(A0C(267, 8, 36), Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put(A0C(244, 7, 18), Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put(A0C(237, 7, 19), Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put(A0C(261, 6, 67), Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put(A0C(275, 9, 63), Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put(A0C(251, 10, 99), Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put(A0C(230, 7, 96), Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put(A0C(222, 8, 57), Integer.valueOf(Color.rgb(0, 0, 0)));
        Map<String, Integer> defaultBackgroundColors = Collections.unmodifiableMap(map2);
        A03 = defaultBackgroundColors;
    }

    public static int A00(int i, int i2, int i3) {
        if (i != -1) {
            return i;
        }
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r7 = 2
            r6 = 1
            r5 = 0
            switch(r0) {
                case -1364013995: goto L80;
                case -1074341483: goto L5b;
                case 100571: goto L4a;
                case 109757538: goto L39;
                default: goto La;
            }
        La:
            r0 = -1
        Lb:
            switch(r0) {
                case 0: goto L93;
                case 1: goto L92;
                case 2: goto L92;
                case 3: goto L91;
                default: goto Le;
            }
        Le:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 69
            r1 = 22
            r0 = 29
            java.lang.String r0 = A0C(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r3 = r0.toString()
            r2 = 167(0xa7, float:2.34E-43)
            r1 = 15
            r0 = 91
            java.lang.String r0 = A0C(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC09574g.A07(r0, r3)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            return r0
        L39:
            r2 = 425(0x1a9, float:5.96E-43)
            r1 = 5
            r0 = 117(0x75, float:1.64E-43)
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 0
            goto Lb
        L4a:
            r2 = 304(0x130, float:4.26E-43)
            r1 = 3
            r0 = 22
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 3
            goto Lb
        L5b:
            r4 = 387(0x183, float:5.42E-43)
            r3 = 6
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AbstractC1359Kn.A01
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 9
            if (r1 == r0) goto L94
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC1359Kn.A01
            java.lang.String r1 = "zDr3pXiReOD9C2voGl4pNyTssnTsthj2"
            r0 = 4
            r2[r0] = r1
            r0 = 110(0x6e, float:1.54E-43)
            java.lang.String r0 = A0C(r4, r3, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 2
            goto Lb
        L80:
            r2 = 294(0x126, float:4.12E-43)
            r1 = 6
            r0 = 0
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 1
            goto Lb
        L91:
            return r7
        L92:
            return r6
        L93:
            return r5
        L94:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A01(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A02(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A02(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A03(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A03(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A04(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r3 = 1
            switch(r0) {
                case 3462: goto L48;
                case 3642: goto L37;
                default: goto L8;
            }
        L8:
            r0 = -1
        L9:
            switch(r0) {
                case 0: goto L5a;
                case 1: goto L58;
                default: goto Lc;
            }
        Lc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 18
            r1 = 26
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = A0C(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r3 = r0.toString()
            r2 = 167(0xa7, float:2.34E-43)
            r1 = 15
            r0 = 91
            java.lang.String r0 = A0C(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC09574g.A07(r0, r3)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            return r0
        L37:
            r2 = 413(0x19d, float:5.79E-43)
            r1 = 2
            r0 = 81
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L8
            r0 = 0
            goto L9
        L48:
            r2 = 376(0x178, float:5.27E-43)
            r1 = 2
            r0 = 0
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L8
            r0 = 1
            goto L9
        L58:
            r0 = 2
            return r0
        L5a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A04(java.lang.String):int");
    }

    public static int A05(String str, int i) {
        int iIndexOf = str.indexOf(62, i);
        if (iIndexOf == -1) {
            int index = str.length();
            return index;
        }
        int index2 = iIndexOf + 1;
        return index2;
    }

    public static C09393o A08(String str) {
        C1358Km builder = new C1358Km();
        A0L(str, builder);
        return builder.A07();
    }

    public static C2675pT A09(CharSequence charSequence) {
        C1358Km infoBuilder = new C1358Km();
        infoBuilder.A0A = charSequence;
        return infoBuilder.A07().A0H();
    }

    public static C1351Kf A0B(String str, Matcher matcher, C09724v c09724v, List<C1347Kb> list) {
        C1358Km c1358Km = new C1358Km();
        try {
            c1358Km.A09 = AbstractC1360Ko.A01((String) AbstractC09493y.A01(matcher.group(1)));
            c1358Km.A08 = AbstractC1360Ko.A01((String) AbstractC09493y.A01(matcher.group(2)));
            A0L((String) AbstractC09493y.A01(matcher.group(3)), c1358Km);
            StringBuilder sb = new StringBuilder();
            String strA0T = c09724v.A0T();
            while (true) {
                boolean zIsEmpty = TextUtils.isEmpty(strA0T);
                if (A01[5].charAt(2) == 'h') {
                    throw new RuntimeException();
                }
                A01[1] = "2AwiW2AhFaTR";
                if (!zIsEmpty) {
                    if (sb.length() > 0) {
                        sb.append(A0C(0, 1, 93));
                    }
                    sb.append(strA0T.trim());
                    strA0T = c09724v.A0T();
                } else {
                    c1358Km.A0A = A07(str, sb.toString(), list);
                    return c1358Km.A08();
                }
            }
        } catch (NumberFormatException unused) {
            AbstractC09574g.A07(A0C(167, 15, 91), A0C(117, 30, 106) + matcher.group());
            return null;
        }
    }

    public static String A0D(String str) {
        String strTrim = str.trim();
        AbstractC09493y.A07(!strTrim.isEmpty());
        return C5C.A1P(strTrim, A0C(182, 5, 117))[0];
    }

    public static List<C1356Kk> A0E(List<C1347Kb> list, String str, C1355Kj c1355Kj) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C1347Kb c1347Kb = list.get(i);
            int i2 = c1347Kb.A09(str, c1355Kj.A01, c1355Kj.A03, c1355Kj.A02);
            if (i2 > 0) {
                arrayList.add(new C1356Kk(i2, c1347Kb));
            }
        }
        Collections.sort(arrayList);
        if (A01[3].charAt(21) == 'Z') {
            throw new RuntimeException();
        }
        A01[3] = "10DtqaDx3Mjis7pngfRsmCfeCaw0vB2Q";
        return arrayList;
    }

    public static void A0G(SpannableStringBuilder spannableStringBuilder, C1347Kb c1347Kb, int i, int i2) {
        if (c1347Kb == null) {
            return;
        }
        if (c1347Kb.A08() != -1) {
            AbstractC09443t.A00(spannableStringBuilder, new StyleSpan(c1347Kb.A08()), i, i2, 33);
        }
        if (c1347Kb.A0S()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        boolean zA0T = c1347Kb.A0T();
        if (A01[3].charAt(21) != 'Z') {
            A01[3] = "1YLI45HvZzSZe2yut9V0MUcCwjpGC5gE";
            if (zA0T) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (c1347Kb.A0R()) {
                AbstractC09443t.A00(spannableStringBuilder, new ForegroundColorSpan(c1347Kb.A05()), i, i2, 33);
            }
            if (c1347Kb.A0Q()) {
                AbstractC09443t.A00(spannableStringBuilder, new BackgroundColorSpan(c1347Kb.A04()), i, i2, 33);
            }
            if (c1347Kb.A0K() != null) {
                AbstractC09443t.A00(spannableStringBuilder, new TypefaceSpan(c1347Kb.A0K()), i, i2, 33);
            }
            switch (c1347Kb.A06()) {
                case 1:
                    AbstractC09443t.A00(spannableStringBuilder, new AbsoluteSizeSpan((int) c1347Kb.A03(), true), i, i2, 33);
                    break;
                case 2:
                    AbstractC09443t.A00(spannableStringBuilder, new RelativeSizeSpan(c1347Kb.A03()), i, i2, 33);
                    break;
                case 3:
                    AbstractC09443t.A00(spannableStringBuilder, new RelativeSizeSpan(c1347Kb.A03() / 100.0f), i, i2, 33);
                    break;
            }
            if (c1347Kb.A0P()) {
                spannableStringBuilder.setSpan(new C2672pQ(), i, i2, 33);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public static void A0I(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i, int i2) {
        for (String str : set) {
            boolean zContainsKey = A04.containsKey(str);
            if (A01[1].length() == 9) {
                throw new RuntimeException();
            }
            A01[5] = "YNIn8hUAyZDjSH3JhERqEXsouXgj93JS";
            if (zContainsKey) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(A04.get(str).intValue()), i, i2, 33);
            } else {
                Map<String, Integer> map = A03;
                String className = A01[3];
                if (className.charAt(21) != 'Z') {
                    A01[3] = "z1JdxX10iLj514Di1TKQv9nGlpU0X7eV";
                    if (map.containsKey(str)) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(A03.get(str).intValue()), i, i2, 33);
                    }
                } else if (map.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(A03.get(str).intValue()), i, i2, 33);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0J(java.lang.String r4, android.text.SpannableStringBuilder r5) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A0J(java.lang.String, android.text.SpannableStringBuilder):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0 A[LOOP:0: B:42:0x00ea->B:44:0x00f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017 A[RETURN] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0K(java.lang.String r8, com.facebook.ads.redexgen.core.C1355Kj r9, java.util.List<com.facebook.ads.redexgen.core.C1354Ki> r10, android.text.SpannableStringBuilder r11, java.util.List<com.facebook.ads.redexgen.core.C1347Kb> r12) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A0K(java.lang.String, com.facebook.ads.redexgen.X.Kj, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    public static void A0L(String str, C1358Km c1358Km) {
        String value = A0C(167, 15, 91);
        Matcher matcher = A05.matcher(str);
        while (matcher.find()) {
            Object objA01 = AbstractC09493y.A01(matcher.group(1));
            String[] strArr = A01;
            if (strArr[2].charAt(10) == strArr[6].charAt(10)) {
                throw new RuntimeException();
            }
            A01[3] = "IuLRiWa83LmFflMS6GnqXQo4BkpBDAaM";
            String str2 = (String) objA01;
            String str3 = (String) AbstractC09493y.A01(matcher.group(2));
            try {
                if (A0C(353, 4, 43).equals(str2)) {
                    A0M(str3, c1358Km);
                } else if (A0C(213, 5, 54).equals(str2)) {
                    c1358Km.A06 = A03(str3);
                } else if (A0C(397, 8, 107).equals(str2)) {
                    A0N(str3, c1358Km);
                } else if (A0C(421, 4, 35).equals(str2)) {
                    c1358Km.A02 = AbstractC1360Ko.A00(str3);
                } else if (A0C(432, 8, 92).equals(str2)) {
                    c1358Km.A07 = A04(str3);
                } else {
                    AbstractC09574g.A07(value, A0C(147, 20, 102) + str2 + A0C(15, 1, 60) + str3);
                }
            } catch (NumberFormatException unused) {
                AbstractC09574g.A07(value, A0C(91, 26, 123) + matcher.group());
            }
        }
    }

    public static void A0M(String str, C1358Km c1358Km) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            int commaIndex = iIndexOf + 1;
            c1358Km.A03 = A01(str.substring(commaIndex));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith(A0C(2, 1, 118))) {
            c1358Km.A00 = AbstractC1360Ko.A00(str);
            c1358Km.A04 = 0;
        } else {
            int commaIndex2 = Integer.parseInt(str);
            c1358Km.A00 = commaIndex2;
            c1358Km.A04 = 1;
        }
    }

    public static void A0N(String str, C1358Km c1358Km) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            int commaIndex = iIndexOf + 1;
            c1358Km.A05 = A02(str.substring(commaIndex));
            str = str.substring(0, iIndexOf);
        }
        c1358Km.A01 = AbstractC1360Ko.A00(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[RETURN] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0O(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1359Kn.A0O(java.lang.String):boolean");
    }
}
