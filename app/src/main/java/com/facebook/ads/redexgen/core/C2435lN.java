package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2435lN implements InterfaceC1367Kv {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02 = C.TIME_UNSET;
    public boolean A03;
    public final List<LC> A04;
    public final InterfaceC1272Hd[] A05;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{1, Ascii.DLE, Ascii.DLE, Ascii.FF, 9, 3, 1, Ascii.DC4, 9, Ascii.SI, Ascii.SO, -49, 4, Ascii.SYN, 2, 19, Ascii.NAK, 2, 19};
    }

    public C2435lN(List<LC> list) {
        this.A04 = list;
        this.A05 = new InterfaceC1272Hd[list.size()];
    }

    private boolean A02(C09724v c09724v, int i) {
        if (c09724v.A07() == 0) {
            return false;
        }
        if (c09724v.A0I() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void A5A(C09724v c09724v) {
        if (this.A03) {
            if (this.A00 == 2 && !A02(c09724v, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(c09724v, 0)) {
                return;
            }
            int iA09 = c09724v.A09();
            int iA07 = c09724v.A07();
            for (InterfaceC1272Hd interfaceC1272Hd : this.A05) {
                c09724v.A0f(iA09);
                interfaceC1272Hd.AIr(c09724v, iA07);
            }
            int dataPosition = this.A01;
            this.A01 = dataPosition + iA07;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5c(com.facebook.ads.redexgen.core.HA r8, com.facebook.ads.redexgen.core.LG r9) {
        /*
            r7 = this;
            r4 = 0
        L1:
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A05
            int r0 = r0.length
            if (r4 >= r0) goto L52
            java.util.List<com.facebook.ads.redexgen.X.LC> r0 = r7.A04
            java.lang.Object r6 = r0.get(r4)
            com.facebook.ads.redexgen.X.LC r6 = (com.facebook.ads.redexgen.core.LC) r6
            r9.A05()
            int r1 = r9.A03()
            r0 = 3
            com.facebook.ads.redexgen.X.Hd r3 = r8.AKS(r1, r0)
            com.facebook.ads.redexgen.X.2p r1 = new com.facebook.ads.redexgen.X.2p
            r1.<init>()
            java.lang.String r0 = r9.A04()
            com.facebook.ads.redexgen.X.2p r5 = r1.A0y(r0)
            r2 = 0
            r1 = 19
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.2p r1 = r5.A11(r0)
            byte[] r0 = r6.A02
            java.util.List r0 = java.util.Collections.singletonList(r0)
            com.facebook.ads.redexgen.X.2p r1 = r1.A12(r0)
            java.lang.String r0 = r6.A01
            com.facebook.ads.redexgen.X.2p r0 = r1.A10(r0)
            com.facebook.ads.redexgen.X.qI r0 = r0.A14()
            r3.A6e(r0)
            com.facebook.ads.redexgen.X.Hd[] r0 = r7.A05
            r0[r4] = r3
            int r4 = r4 + 1
            goto L1
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2435lN.A5c(com.facebook.ads.redexgen.X.HA, com.facebook.ads.redexgen.X.LG):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void AGp() {
        if (this.A03) {
            if (this.A02 != C.TIME_UNSET) {
                for (InterfaceC1272Hd interfaceC1272Hd : this.A05) {
                    interfaceC1272Hd.AIu(this.A02, 1, this.A01, 0, null);
                }
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void AGq(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.A03 = true;
        if (j != C.TIME_UNSET) {
            this.A02 = j;
        }
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1367Kv
    public final void AJ5() {
        this.A03 = false;
        this.A02 = C.TIME_UNSET;
    }
}
