package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC10849j implements InterfaceC2537nE {
    public int A00;

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1742")
    public boolean A01;
    public final int A02;
    public final long[] A03;
    public final C2725qI[] A04;
    public final int A05;
    public final C2688pg A06;
    public final int[] A07;

    /* JADX WARN: Incorrect condition in loop: B:12:0x0044 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0020 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AbstractC10849j(com.facebook.ads.redexgen.core.C2688pg r5, int[] r6, int r7) {
        /*
            r4 = this;
            r4.<init>()
            int r0 = r6.length
            r3 = 0
            if (r0 <= 0) goto L2f
            r0 = 1
        L8:
            com.facebook.ads.redexgen.core.AbstractC09493y.A08(r0)
            r4.A02 = r7
            java.lang.Object r0 = com.facebook.ads.redexgen.core.AbstractC09493y.A01(r5)
            com.facebook.ads.redexgen.X.pg r0 = (com.facebook.ads.redexgen.core.C2688pg) r0
            r4.A06 = r0
            int r0 = r6.length
            r4.A05 = r0
            int r0 = r4.A05
            com.facebook.ads.redexgen.X.qI[] r0 = new com.facebook.ads.redexgen.core.C2725qI[r0]
            r4.A04 = r0
            r2 = 0
        L1f:
            int r0 = r6.length
            if (r2 >= r0) goto L31
            com.facebook.ads.redexgen.X.qI[] r1 = r4.A04
            r0 = r6[r2]
            com.facebook.ads.redexgen.X.qI r0 = r5.A08(r0)
            r1[r2] = r0
            int r2 = r2 + 1
            goto L1f
        L2f:
            r0 = 0
            goto L8
        L31:
            com.facebook.ads.redexgen.X.qI[] r1 = r4.A04
            com.facebook.ads.redexgen.X.EV r0 = new com.facebook.ads.redexgen.X.EV
            r0.<init>()
            java.util.Arrays.sort(r1, r0)
            int r0 = r4.A05
            int[] r0 = new int[r0]
            r4.A07 = r0
            r2 = 0
        L42:
            int r0 = r4.A05
            if (r2 >= r0) goto L55
            int[] r1 = r4.A07
            com.facebook.ads.redexgen.X.qI[] r0 = r4.A04
            r0 = r0[r2]
            int r0 = r5.A07(r0)
            r1[r2] = r0
            int r2 = r2 + 1
            goto L42
        L55:
            int r0 = r4.A05
            long[] r0 = new long[r0]
            r4.A03 = r0
            r4.A01 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC10849j.<init>(com.facebook.ads.redexgen.X.pg, int[], int):void");
    }

    public static /* synthetic */ int A07(C2725qI c2725qI, C2725qI c2725qI2) {
        return c2725qI2.A05 - c2725qI.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2537nE
    public void A5x() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2537nE
    public void A6K() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1208Eq
    public final C2725qI A8B(int i) {
        return this.A04[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1208Eq
    public final int A8H(int i) {
        return this.A07[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2537nE
    public final C2725qI A92() {
        return this.A04[A93()];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1208Eq
    public final C2688pg A9L() {
        return this.A06;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0003 */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1208Eq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int AA6(int r3) {
        /*
            r2 = this;
            r1 = 0
        L1:
            int r0 = r2.A05
            if (r1 >= r0) goto Lf
            int[] r0 = r2.A07
            r0 = r0[r1]
            if (r0 != r3) goto Lc
            return r1
        Lc:
            int r1 = r1 + 1
            goto L1
        Lf:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC10849j.AA6(int):int");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2537nE
    public void AFJ(float f) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC10849j abstractC10849j = (AbstractC10849j) obj;
        return this.A06 == abstractC10849j.A06 && Arrays.equals(this.A07, abstractC10849j.A07);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (System.identityHashCode(this.A06) * 31) + Arrays.hashCode(this.A07);
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1208Eq
    public final int length() {
        return this.A07.length;
    }
}
