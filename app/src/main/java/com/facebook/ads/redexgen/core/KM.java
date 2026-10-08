package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KM {
    public static byte[] A0D;
    public static String[] A0E = {"GeuvjWmU0qMIecUET3rH1sSpSiCCpV8d", "VWuGBdV", "r1UddSi70yifv9lgmWBFhDm81yvqf6sz", "XTFXH6doUzlPXpn0lOcCpEMXSJ", "Gs3RvICYSdgYtTZ", "LUo1PxiU5xdJ1hZxjmijWXp8gfNxa8cO", "PBxwyL5R7nlTE13P8yY94OOBBe", "AYtcaoWRC0gFrEQm0SEPSBapgfKgyhaj"};
    public List<KM> A00;
    public final long A01;
    public final long A02;
    public final KM A03;
    public final KT A04;
    public final String A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final boolean A09;
    public final HashMap<String, Integer> A0A;
    public final HashMap<String, Integer> A0B;
    public final String[] A0C;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0E[1].length() == 19) {
                throw new RuntimeException();
            }
            A0E[1] = "X7T2v9MzXPQN9wm4iApZn5l";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
            i4++;
        }
    }

    public static void A04() {
        A0D = new byte[]{Ascii.RS, Ascii.SO, 38, 43, 52, 92, 84, 69, 80, 85, 80, 69, 80, 95};
    }

    static {
        A04();
    }

    public KM(String str, String str2, long j, long j2, KT kt, String[] strArr, String str3, String str4, KM km) {
        this.A07 = str;
        this.A08 = str2;
        this.A05 = str4;
        this.A04 = kt;
        this.A0C = strArr;
        this.A09 = str2 != null;
        this.A02 = j;
        this.A01 = j2;
        this.A06 = (String) AbstractC09493y.A01(str3);
        this.A03 = km;
        this.A0B = new HashMap<>();
        this.A0A = new HashMap<>();
    }

    public static SpannableStringBuilder A00(String str, Map<String, C09393o> map) {
        if (!map.containsKey(str)) {
            C09393o c09393o = new C09393o();
            c09393o.A0G(new SpannableStringBuilder());
            map.put(str, c09393o);
        }
        C09393o regionOutput = map.get(str);
        return (SpannableStringBuilder) AbstractC09493y.A01(regionOutput.A0I());
    }

    public static KM A01(String str) {
        return new KM(null, KO.A04(str), C.TIME_UNSET, C.TIME_UNSET, null, null, A03(0, 0, 119), null, null);
    }

    public static KM A02(String str, long j, long j2, KT kt, String[] strArr, String str2, String str3, KM km) {
        return new KM(str, null, j, j2, kt, strArr, str2, str3, km);
    }

    private void A05(long j, String str, List<Pair<String, String>> regionImageList) {
        if (!A03(0, 0, 119).equals(this.A06)) {
            str = this.A06;
        }
        if (A0B(j)) {
            String strA03 = A03(2, 3, 18);
            String resolvedRegionId = this.A07;
            if (strA03.equals(resolvedRegionId)) {
                String resolvedRegionId2 = this.A05;
                if (resolvedRegionId2 != null) {
                    regionImageList.add(new Pair<>(str, this.A05));
                    return;
                }
            }
        }
        for (int i = 0; i < A0C(); i++) {
            A0D(i).A05(j, str, regionImageList);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:20:0x0089 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(long r21, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.KT> r23, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.KN> r24, java.lang.String r25, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.C09393o> r26) {
        /*
            r20 = this;
            r2 = r20
            r3 = r25
            r2 = r2
            r14 = r21
            boolean r0 = r2.A0B(r14)
            if (r0 != 0) goto Le
            return
        Le:
            r4 = 0
            r1 = 0
            r0 = 119(0x77, float:1.67E-43)
            java.lang.String r1 = A03(r4, r1, r0)
            java.lang.String r0 = r2.A06
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L81
        L1e:
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r2.A0A
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r7 = r0.iterator()
        L28:
            boolean r0 = r7.hasNext()
            r5 = r26
            r4 = r24
            r9 = r23
            if (r0 == 0) goto L84
            java.lang.Object r6 = r7.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r1 = r6.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r2.A0B
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L7f
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r2.A0B
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r11 = r0.intValue()
        L54:
            java.lang.Object r0 = r6.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r12 = r0.intValue()
            if (r11 == r12) goto L28
            java.lang.Object r0 = r5.get(r1)
            com.facebook.ads.redexgen.X.3o r0 = (com.facebook.ads.redexgen.core.C09393o) r0
            java.lang.Object r10 = com.facebook.ads.redexgen.core.AbstractC09493y.A01(r0)
            com.facebook.ads.redexgen.X.3o r10 = (com.facebook.ads.redexgen.core.C09393o) r10
            java.lang.Object r0 = r4.get(r3)
            com.facebook.ads.redexgen.X.KN r0 = (com.facebook.ads.redexgen.core.KN) r0
            java.lang.Object r0 = com.facebook.ads.redexgen.core.AbstractC09493y.A01(r0)
            com.facebook.ads.redexgen.X.KN r0 = (com.facebook.ads.redexgen.core.KN) r0
            int r13 = r0.A08
            r8 = r2
            r8.A09(r9, r10, r11, r12, r13)
            goto L28
        L7f:
            r11 = 0
            goto L54
        L81:
            java.lang.String r3 = r2.A06
            goto L1e
        L84:
            r1 = 0
        L85:
            int r0 = r2.A0C()
            if (r1 >= r0) goto L9d
            com.facebook.ads.redexgen.X.KM r13 = r2.A0D(r1)
            r16 = r9
            r19 = r5
            r18 = r3
            r17 = r4
            r13.A06(r14, r16, r17, r18, r19)
            int r1 = r1 + 1
            goto L85
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.KM.A06(long, java.util.Map, java.util.Map, java.lang.String, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(long r12, boolean r14, java.lang.String r15, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.C09393o> r16) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.KM.A07(long, boolean, java.lang.String, java.util.Map):void");
    }

    public static void A08(SpannableStringBuilder spannableStringBuilder) {
        for (KF kf : (KF[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), KF.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(kf), spannableStringBuilder.getSpanEnd(kf), (CharSequence) A03(0, 0, 119));
        }
        loop1: for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                while (i2 < spannableStringBuilder.length()) {
                    char cCharAt = spannableStringBuilder.charAt(i2);
                    String[] strArr = A0E;
                    String str = strArr[5];
                    String str2 = strArr[7];
                    int i3 = str.charAt(24);
                    if (i3 != str2.charAt(24)) {
                        break loop1;
                    }
                    String[] strArr2 = A0E;
                    strArr2[0] = "TbkeKkbvotKRDkL3aJkR6CKPV2CRZepO";
                    strArr2[2] = "HOyzJt7YVHsiDEtesdPQS8q1On7uoMtF";
                    if (cCharAt != ' ') {
                        break;
                    } else {
                        i2++;
                    }
                }
                int j = i + 1;
                String[] strArr3 = A0E;
                String str3 = strArr3[0];
                String str4 = strArr3[2];
                int i4 = str3.charAt(26);
                if (i4 == str4.charAt(26)) {
                    throw new RuntimeException();
                }
                A0E[1] = "2IIAODStabB9";
                int i5 = i2 - j;
                if (i5 > 0) {
                    spannableStringBuilder.delete(i, i + i5);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i6 + 1) == ' ') {
                int i7 = i6 + 1;
                spannableStringBuilder.delete(i7, i6 + 2);
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
            if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i8 + 1) == '\n') {
                spannableStringBuilder.delete(i8, i8 + 1);
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void A09(Map<String, KT> map, C09393o c09393o, int i, int i2, int i3) {
        KT ktA02 = KO.A02(this.A04, this.A0C, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c09393o.A0I();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c09393o.A0G(spannableStringBuilder);
        }
        if (ktA02 != null) {
            KO.A06(spannableStringBuilder, i, i2, ktA02, this.A03, map, i3);
            if (A03(13, 1, 127).equals(this.A07)) {
                if (ktA02.A04() != Float.MAX_VALUE) {
                    c09393o.A05((ktA02.A04() * (-90.0f)) / 100.0f);
                }
                if (ktA02.A0C() != null) {
                    c09393o.A0F(ktA02.A0C());
                }
                if (ktA02.A0B() != null) {
                    c09393o.A0E(ktA02.A0B());
                }
            }
        }
    }

    private void A0A(TreeSet<Long> treeSet, boolean z) {
        boolean zEquals = A03(13, 1, 127).equals(this.A07);
        boolean isPNode = A03(2, 3, 18).equals(this.A07);
        if (z || zEquals || (isPNode && this.A05 != null)) {
            if (this.A02 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(this.A02));
            }
            if (this.A01 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(this.A01));
            }
        }
        if (this.A00 == null) {
            return;
        }
        for (int i = 0; i < this.A00.size(); i++) {
            KM km = this.A00.get(i);
            boolean isPNode2 = z || zEquals;
            km.A0A(treeSet, isPNode2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0B(long r8) {
        /*
            r7 = this;
            long r1 = r7.A02
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L11
            long r1 = r7.A01
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 == 0) goto L4e
        L11:
            long r1 = r7.A02
            int r0 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r0 > 0) goto L36
            long r2 = r7.A01
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.KM.A0E
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 19
            if (r1 == r0) goto L52
            java.lang.String[] r4 = com.facebook.ads.redexgen.core.KM.A0E
            java.lang.String r1 = "RgXDLQ3a08cIBfoVnl1r1eLIg5MUrfoW"
            r0 = 5
            r4[r0] = r1
            java.lang.String r1 = "Ter36j0QNwpTucwH0VATqUwzgkfFz8sj"
            r0 = 7
            r4[r0] = r1
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 == 0) goto L4e
        L36:
            long r1 = r7.A02
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L42
            long r1 = r7.A01
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 < 0) goto L4e
        L42:
            long r1 = r7.A02
            int r0 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r0 > 0) goto L50
            long r1 = r7.A01
            int r0 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r0 >= 0) goto L50
        L4e:
            r0 = 1
        L4f:
            return r0
        L50:
            r0 = 0
            goto L4f
        L52:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.KM.A0B(long):boolean");
    }

    public final int A0C() {
        if (this.A00 == null) {
            return 0;
        }
        List<KM> list = this.A00;
        if (A0E[4].length() == 7) {
            throw new RuntimeException();
        }
        A0E[1] = "iiL";
        return list.size();
    }

    public final KM A0D(int i) {
        if (this.A00 != null) {
            return this.A00.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<C2675pT> A0E(long j, Map<String, KT> map, Map<String, KN> map2, Map<String, String> imageMap) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        A05(j, this.A06, arrayList);
        TreeMap treeMap = new TreeMap();
        A07(j, false, this.A06, treeMap);
        A06(j, map, map2, this.A06, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = imageMap.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                KN kn = (KN) AbstractC09493y.A01(map2.get(pair.first));
                arrayList2.add(new C09393o().A0D(bitmapDecodeByteArray).A04(kn.A02).A0A(0).A07(kn.A01, 0).A09(kn.A05).A06(kn.A04).A03(kn.A00).A0B(kn.A08).A0H());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            KN kn2 = (KN) AbstractC09493y.A01(map2.get(entry.getKey()));
            C09393o c09393o = (C09393o) entry.getValue();
            A08((SpannableStringBuilder) AbstractC09493y.A01(c09393o.A0I()));
            c09393o.A07(kn2.A01, kn2.A06);
            c09393o.A09(kn2.A05);
            c09393o.A04(kn2.A02);
            c09393o.A06(kn2.A04);
            c09393o.A08(kn2.A03, kn2.A07);
            c09393o.A0B(kn2.A08);
            arrayList2.add(c09393o.A0H());
        }
        return arrayList2;
    }

    public final void A0F(KM km) {
        if (this.A00 == null) {
            this.A00 = new ArrayList();
        }
        this.A00.add(km);
    }

    public final long[] A0G() {
        TreeSet<Long> treeSet = new TreeSet<>();
        A0A(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        int i = 0;
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public final String[] A0H() {
        return this.A0C;
    }
}
