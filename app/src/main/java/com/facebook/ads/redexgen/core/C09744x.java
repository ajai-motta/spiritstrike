package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C09744x extends AbstractC1252Gj {
    public static byte[] A07;
    public static String[] A08 = {"opNTFb7MfNeLnBf1OFt8H8u3IMVbRu1d", "IWQCWQwp5ID5RPcOdaIzYqbwlbVDrClG", "KvkPuVSJhScWrt17epNc", "F0ODCmRg5uMMagWpVfR8fmvJ1OUGt5pq", "F5r", "wG3QjEZJL94bFBL8PiZK", "A8E1xGSXICDDUeWE8x490gS0hcqgXwJC", "2T9PYA9x4VF1QbksNYikemvLXt0jGXOu"};
    public AbstractC1878c3 A00;
    public DZ A01;
    public final ImageView A02;
    public final InterfaceC1533Rk A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;
    public final AtomicBoolean A06;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-17, -25, -27, -20};
    }

    static {
        A07();
    }

    public C09744x(C2165gi c2165gi, ZU zu, VA va, AbstractC2330jd abstractC2330jd, C1571Sx c1571Sx, InterfaceC1706Yh interfaceC1706Yh) {
        super(c2165gi, zu, va, abstractC2330jd, c1571Sx, interfaceC1706Yh);
        this.A03 = new C1245Gc(this);
        this.A05 = new AtomicBoolean(false);
        this.A04 = new AtomicBoolean(false);
        this.A06 = new AtomicBoolean(false);
        this.A02 = new ImageView(getContext());
        if (abstractC2330jd.A29().A0H().A04() > 0) {
            this.A01 = new DZ(c2165gi, abstractC2330jd.A29().A0H().A04() * 1000);
        }
        this.A02.setScaleType(ImageView.ScaleType.CENTER);
        this.A02.setAdjustViewBounds(true);
        new LM(this.A02, super.A05).A05(super.A03.A29().A0H().A00(), super.A03.A29().A0H().A01()).A06(new C1244Gb(this)).A07(super.A03.A29().A0H().A08());
    }

    private AbstractC1878c3 A01(int i) {
        if (this.A02.getParent() != null) {
            YB.A0J(this.A02);
        }
        C1881c6 c1881c6A0M = new C1881c6(super.A05, super.A06, this.A0A, super.A03, this.A02, this.A0C, this.A08).A0J(this.A09.getToolbarHeight()).A0P(this.A09).A0I(i).A0M(this.A07);
        if (this.A01 != null) {
            c1881c6A0M.A0R(this.A01);
        }
        c1881c6A0M.A0L(C1418Mu.A00(super.A05, super.A06, A03(0, 0, 52), XB.A00(super.A03.A29().A0J().A05()), new HashMap(), super.A03.A2A()));
        C1882c7 params = c1881c6A0M.A0U();
        return AbstractC1879c4.A00(params, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A05.get() && this.A04.get()) {
            A0e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(int r8) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C09744x.A08(int):void");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj
    public final AbstractC1700Yb A0c() {
        AbstractC1700Yb abstractC1700YbA0c = super.A0c();
        if (super.A03.A2T()) {
            abstractC1700YbA0c.setOnClickListener(new ViewOnClickListenerC1986dn(this));
        }
        return abstractC1700YbA0c;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj
    public final void A0g() {
        if (this.A00 != null) {
            this.A07.A04(VH.A0Y, null);
            EnumC1414Mq enumC1414MqA1B = this.A00.A1B(A03(0, 4, 63));
            if (super.A03.A2N()) {
                return;
            }
            EnumC1414Mq actionOutcome = EnumC1414Mq.A09;
            if (enumC1414MqA1B != actionOutcome) {
                EnumC1414Mq actionOutcome2 = EnumC1414Mq.A06;
                if (enumC1414MqA1B != actionOutcome2) {
                    A0f();
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj
    public final void A0h() {
        YB.A0L(this.A00);
        YB.A0L(this.A09);
        this.A04.set(true);
        A06();
        int iA04 = super.A03.A29().A0H().A04();
        int secondsForNextCta = super.A03.A29().A0H().A02();
        if (iA04 > 0) {
            if (this.A00 != null) {
                this.A00.A1G();
            }
            A0i(iA04, new C1243Ga(this), this.A01);
            if (secondsForNextCta == 0 || secondsForNextCta >= iA04) {
                super.A02 = true;
                this.A09.setToolbarActionMode(8);
                return;
            } else {
                if (secondsForNextCta <= 0) {
                    return;
                }
                this.A09.setProgressSpinnerInvisible(true);
                A0i(secondsForNextCta, new GZ(this), null);
                return;
            }
        }
        this.A06.set(true);
        AbstractC1700Yb abstractC1700Yb = this.A09;
        int unskippableSeconds = getCloseButtonStyle();
        abstractC1700Yb.setToolbarActionMode(unskippableSeconds);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj
    public final void A0k(C1527Re c1527Re) {
        FrameLayout.LayoutParams layoutParams;
        c1527Re.A0A(this.A03);
        int orientation = c1527Re.A05().getResources().getConfiguration().orientation;
        A08(orientation);
        if (A0m()) {
            YB.A0J(this.A09);
        }
        if (A0m()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            Rect requestedMargins = this.A09.getRequestedMargins();
            if (requestedMargins == null) {
                layoutParams.setMargins(0, XV.A0r, 0, 0);
            } else {
                int i = requestedMargins.left;
                int i2 = requestedMargins.top;
                int i3 = requestedMargins.right;
                int i4 = requestedMargins.bottom;
                if (A08[4].length() != 3) {
                    throw new RuntimeException();
                }
                A08[0] = "j24x2xTHwZJixq019qlFmxSWfXtsmamW";
                layoutParams.setMargins(i, i2, i3, i4);
            }
        } else {
            int orientation2 = this.A09.getToolbarHeight();
            layoutParams = new FrameLayout.LayoutParams(-1, orientation2);
        }
        addView(this.A09, layoutParams);
        YB.A0H(this.A00);
        YB.A0H(this.A09);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj
    public final boolean A0l() {
        if (this.A00 == null) {
            return false;
        }
        AbstractC1878c3 abstractC1878c3 = this.A00;
        if (A08[4].length() != 3) {
            throw new RuntimeException();
        }
        A08[4] = "kMg";
        return abstractC1878c3.A1P(false);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj
    public final boolean A0m() {
        return super.A03.A1j() || super.A03.A1y();
    }

    public final /* synthetic */ void A0n() {
        A0f();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFA(boolean z) {
        if (this.A00 != null) {
            this.A00.A1L(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFi(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        if (this.A00 != null) {
            return this.A00.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A03.A29().A0T() && !A0m()) {
            A08(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1252Gj, com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void onDestroy() {
        if (C1615Up.A1z(super.A05)) {
            super.A05.A0B().AKU(this.A02);
        }
        if (this.A00 != null) {
            AbstractC1878c3 abstractC1878c3 = this.A00;
            String[] strArr = A08;
            if (strArr[6].charAt(10) != strArr[1].charAt(10)) {
                throw new RuntimeException();
            }
            A08[4] = "hIQ";
            abstractC1878c3.A1C();
        }
        super.onDestroy();
    }
}
