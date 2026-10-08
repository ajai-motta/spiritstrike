package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.datamodels.AdInfo;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C4T extends PJ {
    public static byte[] A0D;
    public static String[] A0E = {"tW3Su6P8GZp1yTngpwFy2DF2GhDzXnf2", "3HQabaXZCQWVf5CedpF1izNpaoU6B", "XHPkWVuaRS230ZzCiYR7qtQACoZnYKM5", "gQNAwnCobdMDtnebLpL2jf4350QwOymE", "dRJ3n5TbirTJDeON6upQokchUTJmTtSu", "43KhzPf8qbqk0SZtfSmXLCVXJtKHuuuO", "kYCENHGiqRDWZvuV9M2TmYzxFqbu31T5", "7NDfQDtGKt0HcNI2moZZTs031QkqKmSX"};
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public int A00;
    public int A01;
    public LinearLayout A02;
    public AbstractC2330jd A03;
    public C1571Sx A04;
    public C1J A05;
    public C1858bj A06;
    public C1241Fy A07;
    public AbstractC2109fo A08;
    public C2110fp A09;
    public String A0A;
    public List<C2003e5> A0B;
    public final Y2 A0C;

    public static String A0E(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0G() {
        A0D = new byte[]{66, 71, 124, 71, 66, 87, 66, 124, 65, 86, 77, 71, 79, 70, Ascii.DC2, 5, Ascii.ETB, 1, Ascii.DC2, 4, 5, 4, 54, 9, 4, 5, Ascii.SI, 33, 4, 36, 1, Ascii.DC4, 1, 34, Ascii.NAK, Ascii.SO, 4, Ascii.FF, 5, 118, 110, 108, 117};
    }

    static {
        A0G();
        A0G = (int) (XX.A02 * 48.0f);
        A0H = XV.A0v;
        A0I = (int) (XX.A02 * 8.0f);
        A0K = (int) (XX.A02 * 56.0f);
        A0F = (int) (XX.A02 * 48.0f);
        A0J = (int) (XX.A02 * 12.0f);
    }

    public C4T(C2165gi c2165gi, VA va, C1571Sx c1571Sx, InterfaceC1706Yh interfaceC1706Yh, AbstractC2330jd abstractC2330jd) {
        super(c2165gi, va, interfaceC1706Yh, abstractC2330jd);
        this.A0C = new Y2();
        if (abstractC2330jd instanceof C10407l) {
            super.A09 = true;
            super.A08 = new C2033ea(c2165gi, new MG(), this.A0D.A1G(), interfaceC1706Yh);
        }
        this.A04 = c1571Sx;
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    private int A00() {
        return A0K + A0G + (A0H * 4) + (this.A0D.A2Q() ? A0F : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.facebook.ads.redexgen.core.EnumC1414Mq A02(java.lang.String r7) {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.Mq r5 = com.facebook.ads.redexgen.core.EnumC1414Mq.A09
            com.facebook.ads.redexgen.X.1J r0 = r6.A05
            if (r0 != 0) goto L7
            return r5
        L7:
            com.facebook.ads.redexgen.X.1J r4 = r6.A05
            com.facebook.ads.redexgen.X.1J r0 = r6.A05
            com.facebook.ads.redexgen.X.hr r3 = r0.getLayoutManager()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            r0 = 5
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L91
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            java.lang.String r1 = "E32f1TaBN4dkj3FL0vDfikWnsbqL7SKY"
            r0 = 2
            r2[r0] = r1
            int r0 = r3.A25()
            com.facebook.ads.redexgen.X.RK r3 = r4.A1G(r0)
            com.facebook.ads.redexgen.X.FY r3 = (com.facebook.ads.redexgen.core.FY) r3
            if (r3 == 0) goto L7d
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            if (r0 == 0) goto L7d
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            com.facebook.ads.redexgen.X.Mq r5 = r0.A0E(r7)
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            com.facebook.ads.redexgen.X.bV r4 = r0.getCtaActionHelper()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C4T.A0E
            r0 = 2
            r1 = r1[r0]
            r0 = 16
            char r1 = r1.charAt(r0)
            r0 = 49
            if (r1 == r0) goto L7e
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            java.lang.String r1 = "i7TFLIHedh0buU6tWLTqbZ60SXZT8zmg"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "DCWE7AKb21kTTjPuFVubbU6pDlTglIBY"
            r0 = 6
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Mr r0 = r4.A06()
            if (r0 != 0) goto L7d
        L6d:
            com.facebook.ads.redexgen.X.Kr r0 = r3.A0p()
            com.facebook.ads.redexgen.X.bV r1 = r0.getCtaActionHelper()
            com.facebook.ads.redexgen.X.Ff r0 = new com.facebook.ads.redexgen.X.Ff
            r0.<init>(r6)
            r1.A07(r0)
        L7d:
            return r5
        L7e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C4T.A0E
            java.lang.String r1 = "dI26cUvsILIVYWhCptAOIe9hx0G02LwU"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "KP2PoUq36ksxZ0HlOf60WIRRhVJwRZXP"
            r0 = 0
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Mr r0 = r4.A06()
            if (r0 != 0) goto L7d
            goto L6d
        L91:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C4T.A02(java.lang.String):com.facebook.ads.redexgen.X.Mq");
    }

    private AbstractC2330jd A03(Intent intent) {
        if (super.A09) {
            return (AbstractC2330jd) intent.getSerializableExtra(A0E(14, 25, 103));
        }
        return (AbstractC2330jd) intent.getSerializableExtra(A0E(0, 14, 36));
    }

    private final void A0H() {
        if (this.A02 != null) {
            this.A02.removeAllViews();
            if (A0E[3].charAt(5) != 'n') {
                throw new RuntimeException();
            }
            A0E[4] = "3JPxSaqJUpKyt95G35P4gQJAerHutmpA";
            this.A02 = null;
        }
        if (this.A05 != null) {
            this.A05.removeAllViews();
            this.A05.A1S();
            this.A05 = null;
        }
        if (this.A06 != null) {
            this.A06.removeAllViews();
            this.A06 = null;
        }
    }

    private final void A0I(int i, Bundle bundle) {
        int extraSpacing;
        int i2;
        int height;
        this.A02 = new LinearLayout(getContext());
        if (i == 1) {
            this.A02.setGravity(17);
        } else {
            this.A02.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i3 = XX.A04.widthPixels;
        int i4 = XX.A04.heightPixels;
        if (i == 1) {
            extraSpacing = Math.min(i3 - (A0H * 4), i4 / 2);
            i2 = (i3 - extraSpacing) / 8;
            height = i2 * 4;
        } else {
            extraSpacing = i4 - A00();
            i2 = A0H;
            height = i2 * 2;
        }
        this.A08 = new C1224Fg(this);
        this.A09 = new C2110fp(this, 1, new WeakReference(this.A08), this.A0E);
        this.A09.A0W(this.A00);
        this.A09.A0X(this.A01);
        this.A05 = new C1J(this.A0E);
        this.A05.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A07 = new C1241Fy(this.A05, i, this.A0B, this.A09, bundle);
        int extraSpacing2 = i2;
        int childSpacing = extraSpacing;
        this.A05.setAdapter(new C1232Fp(this.A0E, this.A0B, this.A03, this.A0F, this.A04, this.A09, this.A0C, getAudienceNetworkListener(), this.A0A, childSpacing, extraSpacing2, height, i, this.A07, this.A0H));
        this.A05.A1h(this.A05.getOnScrollListener());
        if (i == 1) {
            A0K(this.A07);
        }
        this.A02.addView(this.A05);
        if (this.A06 != null) {
            this.A02.addView(this.A06);
        }
        if (C1615Up.A1z(this.A0E)) {
            this.A0E.A0B().AKn(this.A05, this.A0D.A2E(), false);
        }
        A0f(this.A02, false, i);
    }

    private void A0J(AbstractC2330jd abstractC2330jd) {
        this.A03 = abstractC2330jd;
        this.A0A = this.A03.A2E();
        this.A00 = this.A03.A0m();
        this.A01 = this.A03.A0n();
        List<NR> listA2G = this.A03.A2G();
        List<AdInfo> adInfoList = new ArrayList<>(listA2G.size());
        this.A0B = adInfoList;
        for (int i = 0; i < listA2G.size(); i++) {
            NR nr = listA2G.get(i);
            List<C2003e5> list = this.A0B;
            int i2 = listA2G.size();
            list.add(new C2003e5(i, i2, nr));
        }
    }

    private void A0K(C1241Fy c1241Fy) {
        new C7N().A0G(this.A05);
        c1241Fy.A0Y(new C1222Fe(this));
        this.A06 = new C1858bj(this.A0E, super.A07.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0I);
        layoutParams.setMargins(0, A0J, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public final AbstractC1700Yb A0b() {
        return new FullScreenAdToolbar(this.A0E, getAudienceNetworkListener(), this.A0G, 0, this.A0D.A22(), false);
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public final void A0d() {
        EnumC1414Mq enumC1414MqA02 = A02(A0E(39, 4, 2));
        if (this.A0D.A2N()) {
            return;
        }
        EnumC1414Mq actionOutcome = EnumC1414Mq.A09;
        if (enumC1414MqA02 != actionOutcome) {
            EnumC1414Mq actionOutcome2 = EnumC1414Mq.A06;
            if (enumC1414MqA02 != actionOutcome2) {
                A0m();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public final boolean A0l() {
        return false;
    }

    public final void A0m() {
        if (this.A0H.getToolbarActionMode() == 8) {
            this.A0H.setToolbarActionMode(2);
        }
        this.A0D.A2K(false);
        this.A0D.A29().A0M(-1);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AAu(Intent intent, Bundle bundle, C1527Re c1527Re) {
        AbstractC2330jd dataBundle = A03(intent);
        A0g(c1527Re);
        A0J(dataBundle);
        A0I(c1527Re.A05().getResources().getConfiguration().orientation, bundle);
        c1527Re.A0A(new C1221Fd(this, c1527Re));
        AbstractC2330jd dataBundle2 = this.A0D;
        int unskippableSec = dataBundle2.A29().A0H().A04();
        if (super.A09) {
            AbstractC2330jd dataBundle3 = this.A0D;
            unskippableSec = dataBundle3.A29().A0H().A03();
        }
        if (unskippableSec > 0) {
            A0e(unskippableSec);
        }
        AbstractC2330jd dataBundle4 = this.A0D;
        if (dataBundle4.A29().A0H().A02() >= 0) {
            this.A0H.setToolbarActionMode(8);
        }
        AbstractC2330jd dataBundle5 = this.A0D;
        if (dataBundle5.A2T()) {
            this.A0H.setOnClickListener(new ViewOnClickListenerC2007e9(this));
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ, com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFA(boolean z) {
        super.AFA(z);
        if (this.A07 != null) {
            this.A07.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ, com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFi(boolean z) {
        super.AFi(z);
        this.A07.A0R();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AIv(Bundle bundle) {
        if (this.A07 != null) {
            this.A07.A0W(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        AIv(bundle);
        A0H();
        A0I(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.PJ, com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void onDestroy() {
        super.onDestroy();
        if (C1615Up.A1z(this.A0E)) {
            this.A0E.A0B().AKU(this.A05);
        }
        if (!TextUtils.isEmpty(this.A0A)) {
            this.A0F.AB7(this.A0A, new C1822b9().A03(this.A09).A02(this.A0C).A05());
        }
        A0H();
        this.A09.A0V();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0C.A06(this.A0E, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
