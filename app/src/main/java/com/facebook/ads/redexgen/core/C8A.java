package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8A {
    public static String[] A06 = {"jkVScMAnmSDw5NjtFKaMDw93YHVTZfVV", "X8vR6FaiUrrVUV4OyPqbjTz4nTbdT", "DJqg7VUdCo9q2ysxPrWS1RTdTLsj", "4FrbkvGGO58oIWN02YSUZA4iQkwc41Il", "lEgbsVLzgPUjgc1", "ISDPu1y88m9uUW9z", "L6djBwtYOA2bka2PQ69EdZLSIG4ne", "x8MPEelqUvAzBLNZGFUUNdgpeh0HUacA"};
    public C2573no A00;
    public C2573no A01;
    public C2573no A02;
    public BP<C2573no> A03 = BP.A03();
    public AbstractC2617oX<C2573no, Timeline> A04 = AbstractC2617oX.A04();
    public final C2692pl A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C2573no A00(com.facebook.ads.redexgen.core.InterfaceC09283b r13, com.facebook.ads.redexgen.core.BP<com.facebook.ads.redexgen.core.C2573no> r14, com.facebook.ads.redexgen.core.C2573no r15, com.facebook.ads.redexgen.core.C2692pl r16) {
        /*
            com.facebook.ads.androidx.media3.common.Timeline r5 = r13.A7g()
            int r4 = r13.A7c()
            boolean r0 = r5.A0N()
            r6 = 0
            if (r0 == 0) goto L34
            r8 = r6
        L10:
            boolean r0 = r13.AAd()
            if (r0 != 0) goto L42
            boolean r3 = r5.A0N()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C8A.A06
            r0 = 7
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 14
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L39
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L34:
            java.lang.Object r8 = r5.A0M(r4)
            goto L10
        L39:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C8A.A06
            java.lang.String r1 = "fPIpfte6042F2VeKOBsTFTkNJVxhR"
            r0 = 6
            r2[r0] = r1
            if (r3 == 0) goto L67
        L42:
            r12 = -1
        L43:
            r1 = 0
        L44:
            r2 = r14
            int r0 = r2.size()
            if (r1 >= r0) goto L7f
            java.lang.Object r7 = r2.get(r1)
            com.facebook.ads.redexgen.X.no r7 = (com.facebook.ads.redexgen.core.C2573no) r7
            boolean r9 = r13.AAd()
            int r10 = r13.A7Y()
            int r11 = r13.A7Z()
            boolean r0 = A04(r7, r8, r9, r10, r11, r12)
            if (r0 == 0) goto L64
            return r7
        L64:
            int r1 = r1 + 1
            goto L44
        L67:
            r7 = r16
            com.facebook.ads.redexgen.X.pl r4 = r5.A0H(r4, r7)
            long r0 = r13.A7e()
            long r2 = com.facebook.ads.redexgen.core.C5C.A0O(r0)
            long r0 = r7.A0C()
            long r2 = r2 - r0
            int r12 = r4.A07(r2)
            goto L43
        L7f:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L9d
            r7 = r15
            if (r7 == 0) goto L9d
            boolean r9 = r13.AAd()
            int r10 = r13.A7Y()
            int r11 = r13.A7Z()
            r8 = r8
            r12 = r12
            boolean r0 = A04(r7, r8, r9, r10, r11, r12)
            if (r0 == 0) goto L9d
            return r7
        L9d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C8A.A00(com.facebook.ads.redexgen.X.3b, com.facebook.ads.redexgen.X.BP, com.facebook.ads.redexgen.X.no, com.facebook.ads.redexgen.X.pl):com.facebook.ads.redexgen.X.no");
    }

    public C8A(C2692pl c2692pl) {
        this.A05 = c2692pl;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<com.facebook.ads.androidx.media3.exoplayer.source.MediaSource$MediaPeriodId, com.facebook.ads.androidx.media3.common.Timeline> */
    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "builder of ImmutableMap should be a buildOrThrow")
    private void A02(Timeline timeline) {
        C2615oV<C2573no, Timeline> c2615oVA03 = AbstractC2617oX.A03();
        if (this.A03.isEmpty()) {
            A03(c2615oVA03, this.A01, timeline);
            C2573no c2573no = this.A02;
            C2573no c2573no2 = this.A01;
            if (A06[4].length() == 25) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[2] = "UxUdIKnoAyUMpq9t4QIr4fpxRPT3";
            strArr[1] = "6BCX8szW2uTmGViuSf00Yq1AObOIr";
            if (!CB.A01(c2573no, c2573no2)) {
                A03(c2615oVA03, this.A02, timeline);
            }
            if (!CB.A01(this.A00, this.A01) && !CB.A01(this.A00, this.A02)) {
                A03(c2615oVA03, this.A00, timeline);
            }
        } else {
            for (int i = 0; i < this.A03.size(); i++) {
                A03(c2615oVA03, this.A03.get(i), timeline);
            }
            if (!this.A03.contains(this.A00)) {
                A03(c2615oVA03, this.A00, timeline);
            }
        }
        this.A04 = c2615oVA03.A07();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.ImmutableMap$Builder<com.facebook.ads.androidx.media3.exoplayer.source.MediaSource$MediaPeriodId, com.facebook.ads.androidx.media3.common.Timeline> */
    private void A03(C2615oV<C2573no, Timeline> c2615oV, C2573no c2573no, Timeline timeline) {
        if (c2573no == null) {
            return;
        }
        if (timeline.A0A(c2573no.A04) != -1) {
            c2615oV.A05(c2573no, timeline);
            return;
        }
        Timeline existingTimeline = this.A04.get(c2573no);
        if (existingTimeline == null) {
            return;
        }
        c2615oV.A05(c2573no, existingTimeline);
    }

    public static boolean A04(C2573no c2573no, Object obj, boolean z, int i, int i2, int i3) {
        if (c2573no.A04.equals(obj)) {
            return (z && c2573no.A00 == i && c2573no.A01 == i2) || (!z && c2573no.A00 == -1 && c2573no.A02 == i3);
        }
        return false;
    }

    public final Timeline A05(C2573no c2573no) {
        return this.A04.get(c2573no);
    }

    public final C2573no A06() {
        return this.A00;
    }

    public final void A07(InterfaceC09283b interfaceC09283b) {
        this.A00 = A00(interfaceC09283b, this.A03, this.A01, this.A05);
        A02(interfaceC09283b.A7g());
    }
}
