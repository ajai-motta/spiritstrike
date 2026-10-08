package com.facebook.ads.redexgen.core;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2539nG extends AbstractC1199Eh<C2539nG> implements Comparable<C2539nG> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A01(List<C2539nG> list, List<C2539nG> list2) {
        return list.get(0).compareTo(list2.get(0));
    }

    public C2539nG(int i, C2688pg c2688pg, int i2, C10839i c10839i, int i3, String str) {
        List<String> listA03;
        super(i, c2688pg, i2);
        int i4 = 0;
        this.A08 = C10829h.A0S(i3, false);
        int i5 = super.A02.A0H & (~((C2684pc) c10839i).A00);
        this.A06 = (i5 & 1) != 0;
        this.A07 = (i5 & 2) != 0;
        int i6 = Integer.MAX_VALUE;
        int bestLanguageScore = 0;
        if (c10839i.A0K.isEmpty()) {
            listA03 = MetaExoPlayerCustomizedCollections.A03("");
        } else {
            listA03 = c10839i.A0K;
        }
        int bestLanguageIndex = 0;
        while (true) {
            if (bestLanguageIndex >= listA03.size()) {
                break;
            }
            int iA02 = C10829h.A02(super.A02, listA03.get(bestLanguageIndex), c10839i.A0P);
            if (iA02 > 0) {
                i6 = bestLanguageIndex;
                bestLanguageScore = iA02;
                break;
            }
            bestLanguageIndex++;
        }
        this.A00 = i6;
        this.A01 = bestLanguageScore;
        this.A02 = C10829h.A00(super.A02.A0E, ((C2684pc) c10839i).A0C);
        this.A05 = (super.A02.A0E & 1088) != 0;
        this.A03 = C10829h.A02(super.A02, str, C10829h.A0K(str) == null);
        boolean z = this.A01 > 0 || (c10839i.A0K.isEmpty() && this.A02 > 0) || this.A06 || (this.A07 && this.A03 > 0);
        if (C10829h.A0S(i3, c10839i.A0B) && z) {
            i4 = 1;
        }
        this.A04 = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C2539nG c2539nG) {
        AbstractC2577ns abstractC2577nsA06 = AbstractC2577ns.A01().A09(this.A08, c2539nG.A08).A08(Integer.valueOf(this.A00), Integer.valueOf(c2539nG.A00), AbstractC2727qK.A03().A06()).A06(this.A01, c2539nG.A01).A06(this.A02, c2539nG.A02).A09(this.A06, c2539nG.A06).A08(Boolean.valueOf(this.A07), Boolean.valueOf(c2539nG.A07), this.A01 == 0 ? AbstractC2727qK.A03() : AbstractC2727qK.A03().A06()).A06(this.A03, c2539nG.A03);
        if (this.A02 == 0) {
            abstractC2577nsA06 = abstractC2577nsA06.A0A(this.A05, c2539nG.A05);
        }
        return abstractC2577nsA06.A05();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$TextTrackInfo> */
    public static BP<C2539nG> A02(int i, C2688pg c2688pg, C10839i c10839i, int[] iArr, String str) {
        C2K c2kA01 = BP.A01();
        for (int i2 = 0; i2 < c2688pg.A01; i2++) {
            c2kA01.A04(new C2539nG(i, c2688pg, i2, c10839i, iArr[i2], str));
        }
        return c2kA01.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC1199Eh
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final boolean A09(C2539nG c2539nG) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1199Eh
    public final int A08() {
        return this.A04;
    }
}
