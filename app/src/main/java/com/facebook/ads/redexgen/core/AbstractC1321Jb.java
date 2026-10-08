package com.facebook.ads.redexgen.core;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1321Jb {
    public static String[] A0D = {"XeH1UKKuz1EDpBeQKhAXaKjrjZgsodJU", "Qh9sfVWsiKdbMkoZ0Fly5mM08PFSskfX", "g5Vgu", "IbV76iHRvjKg6MHaSQGzPOhr6f1ApNQX", "p6vckuBwU2Q2AllMmzSrbAD", "CWShENYx4MqsFhdcA74Ut20lXSF9FxoW", "efy3JamC8vBQUYLSbDR2yGzuJR", "AxMKck"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public HA A06;
    public InterfaceC1272Hd A07;
    public JY A08;
    public boolean A0A;
    public boolean A0B;
    public final JW A0C = new JW();
    public C1320Ja A09 = new C1320Ja();

    public abstract long A09(C09724v c09724v);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean A0C(C09724v c09724v, long j, C1320Ja c1320Ja) throws IOException;

    @RequiresNonNull({"trackOutput"})
    private int A00(InterfaceC2516ms interfaceC2516ms) throws IOException {
        if (A03(interfaceC2516ms)) {
            this.A00 = this.A09.A00.A0G;
            if (!this.A0A) {
                this.A07.A6e(this.A09.A00);
                this.A0A = true;
            }
            JY jy = this.A09.A01;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                throw new RuntimeException();
            }
            A0D[7] = "ikA5IIIrIRBN8L1z";
            if (jy != null) {
                this.A08 = this.A09.A01;
            } else if (interfaceC2516ms.A8O() == -1) {
                this.A08 = new C2468lu();
            } else {
                JX jxA02 = this.A0C.A02();
                this.A08 = new C2474m0(this, this.A04, interfaceC2516ms.A8O(), jxA02.A01 + jxA02.A00, jxA02.A05, (jxA02.A04 & 4) != 0);
            }
            this.A01 = 2;
            this.A0C.A04();
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput", "oggSeeker", "extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(com.facebook.ads.redexgen.core.InterfaceC2516ms r19, com.facebook.ads.redexgen.core.HV r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1321Jb.A01(com.facebook.ads.redexgen.X.ms, com.facebook.ads.redexgen.X.HV):int");
    }

    @EnsuresNonNull({"trackOutput", "extractorOutput"})
    private void A02() {
        AbstractC09493y.A02(this.A07);
    }

    @EnsuresNonNullIf(expression = {"setupData.format"}, result = true)
    private boolean A03(InterfaceC2516ms interfaceC2516ms) throws IOException {
        while (true) {
            JW jw = this.A0C;
            String[] strArr = A0D;
            if (strArr[5].charAt(2) == strArr[3].charAt(2)) {
                break;
            }
            A0D[7] = "RUb6h5R55PuDixsZqq";
            if (!jw.A05(interfaceC2516ms)) {
                this.A01 = 3;
                return false;
            }
            this.A03 = interfaceC2516ms.A8n() - this.A04;
            if (A0C(this.A0C.A01(), this.A04, this.A09)) {
                long jA8n = interfaceC2516ms.A8n();
                if (A0D[7].length() == 17) {
                    break;
                }
                A0D[0] = "MjaWWlFxdP245keDLyVkXHL1D0C1Hazn";
                this.A04 = jA8n;
            } else {
                return true;
            }
        }
        throw new RuntimeException();
    }

    public final int A04(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        A02();
        switch (this.A01) {
            case 0:
                return A00(interfaceC2516ms);
            case 1:
                interfaceC2516ms.AK3((int) this.A04);
                this.A01 = 2;
                return 0;
            case 2:
                return A01(interfaceC2516ms, hv);
            case 3:
                return -1;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A05(long j) {
        return (1000000 * j) / ((long) this.A00);
    }

    public final long A06(long j) {
        return (((long) this.A00) * j) / 1000000;
    }

    public final void A07(long j, long j2) {
        this.A0C.A03();
        if (j == 0) {
            A0B(!this.A0B);
        } else {
            if (this.A01 == 0) {
                return;
            }
            this.A05 = A06(j2);
            ((JY) C5C.A0f(this.A08)).AKC(this.A05);
            this.A01 = 2;
        }
    }

    public final void A08(HA ha, InterfaceC1272Hd interfaceC1272Hd) {
        this.A06 = ha;
        this.A07 = interfaceC1272Hd;
        A0B(true);
    }

    public void A0A(long j) {
        this.A02 = j;
    }

    public void A0B(boolean z) {
        if (z) {
            this.A09 = new C1320Ja();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }
}
