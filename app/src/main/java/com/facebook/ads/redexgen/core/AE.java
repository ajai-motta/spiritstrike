package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AE implements InterfaceC2634oo, InterfaceC10447p {
    public int A00;
    public int A01;
    public long A02;
    public long A04;
    public C10477s A05;
    public C8O A06;
    public DT A07;
    public boolean A08;
    public boolean A09;
    public C2725qI[] A0A;
    public final int A0C;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D18870411: Adding start stall debug reason")
    public EnumC2291ir A0B = EnumC2291ir.A09;
    public final C10286z A0D = new C10286z();
    public long A03 = Long.MIN_VALUE;

    public abstract void A1Z();

    public abstract void A1a(long j, boolean z) throws AD;

    public abstract void A1c(C2725qI[] c2725qIArr, long j, long j2) throws AD;

    public AE(int i) {
        this.A0C = i;
    }

    private final int A1O() {
        return this.A00;
    }

    private void A1P(long j, boolean z) throws AD {
        this.A08 = false;
        this.A02 = j;
        this.A03 = j;
        A1a(j, z);
    }

    public final int A1Q(long j) {
        return ((DT) AbstractC09493y.A01(this.A07)).AK2(j - this.A04);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Keep track of the non-adjusted timestamp")
    public final int A1R(C10286z c10286z, C2646p0 c2646p0, int i) {
        int iAHP = ((DT) AbstractC09493y.A01(this.A07)).AHP(c10286z, c2646p0, i);
        if (iAHP == -4) {
            if (c2646p0.A05()) {
                this.A03 = Long.MIN_VALUE;
                return this.A08 ? -4 : -3;
            }
            c2646p0.A00 = c2646p0.A01;
            c2646p0.A01 += this.A04;
            this.A03 = Math.max(this.A03, c2646p0.A01);
        } else if (iAHP == -5) {
            C2725qI c2725qI = (C2725qI) AbstractC09493y.A01(c10286z.A00);
            if (c2725qI.A0M != Long.MAX_VALUE) {
                c10286z.A00 = c2725qI.A07().A0s(c2725qI.A0M + this.A04).A14();
            }
        }
        return iAHP;
    }

    public final AD A1S(Throwable th, C2725qI c2725qI, int i) {
        return A1T(th, c2725qI, false, i);
    }

    public final AD A1T(Throwable th, C2725qI c2725qI, boolean z, int i) {
        int iA03 = 4;
        if (c2725qI != null && !this.A09) {
            this.A09 = true;
            try {
                int formatSupport = AKM(c2725qI);
                iA03 = AbstractC10377i.A03(formatSupport);
            } catch (AD unused) {
            } catch (Throwable th2) {
                this.A09 = false;
                throw th2;
            }
            this.A09 = false;
        }
        return AD.A04(th, getName(), A1O(), c2725qI, iA03, z, i);
    }

    public final C10286z A1U() {
        this.A0D.A00();
        return this.A0D;
    }

    public final C10477s A1V() {
        return (C10477s) AbstractC09493y.A01(this.A05);
    }

    public final C8O A1W() {
        return (C8O) AbstractC09493y.A01(this.A06);
    }

    public void A1X() throws AD {
    }

    public void A1Y() {
    }

    public void A1b(boolean z, boolean z2) throws AD {
    }

    public final boolean A1d() {
        return A9p() ? this.A08 : ((DT) AbstractC09493y.A01(this.A07)).AAe();
    }

    public final C2725qI[] A1e() {
        return (C2725qI[]) AbstractC09493y.A01(this.A0A);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void A5x() {
        AbstractC09493y.A08(this.A01 == 1);
        this.A0D.A00();
        this.A01 = 0;
        this.A07 = null;
        this.A0A = null;
        this.A08 = false;
        A1Z();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void A6L(C10477s c10477s, C2725qI[] c2725qIArr, DT dt, long j, boolean z, boolean z2, long j2, long j3) throws AD {
        AbstractC09493y.A08(this.A01 == 0);
        this.A05 = c10477s;
        this.A01 = 1;
        A1b(z, z2);
        AIa(c2725qIArr, dt, j2, j3);
        A1P(j, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final InterfaceC10447p A7D() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public AnonymousClass78 A8T() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D18870411: Adding start stall debug reason")
    public final EnumC2291ir A99() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final int A9A() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final DT A9D() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo, com.facebook.ads.redexgen.core.InterfaceC10447p
    public final int A9N() {
        return this.A0C;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10317c
    public void A9i(int i, Object obj) throws AD {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final boolean A9p() {
        return this.A03 == Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void AA9(int i, C8O c8o) {
        this.A00 = i;
        this.A06 = c8o;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final boolean AAN() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void ACU() throws IOException {
        ((DT) AbstractC09493y.A01(this.A07)).ACR();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void AIa(C2725qI[] c2725qIArr, DT dt, long j, long j2) throws AD {
        AbstractC09493y.A08(!this.A08);
        this.A07 = dt;
        if (this.A03 == Long.MIN_VALUE) {
            this.A03 = j;
        }
        this.A0A = c2725qIArr;
        this.A04 = j2;
        A1c(c2725qIArr, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void AIm(long j) throws AD {
        A1P(j, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void AJN() {
        this.A08 = true;
    }

    public int AKO() throws AD {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void start() throws AD {
        AbstractC09493y.A08(this.A01 == 1);
        this.A01 = 2;
        A1X();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void stop() {
        AbstractC09493y.A08(this.A01 == 2);
        this.A01 = 1;
        A1Y();
    }
}
