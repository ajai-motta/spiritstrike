package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2020eM {
    public ViewOnClickListenerC1363Kr A00;
    public final NN A01;
    public final NY A02;
    public final C1426Nd A03;
    public final C1435Nm A04;
    public final C2165gi A05;
    public final VI A06;
    public static final int A09 = (int) (XX.A02 * 4.0f);
    public static final int A07 = (int) (XX.A02 * 72.0f);
    public static final int A08 = (int) (XX.A02 * 8.0f);

    public C2020eM(C2165gi c2165gi, VA va, AbstractC2330jd abstractC2330jd) {
        this.A05 = c2165gi;
        this.A06 = new VI(abstractC2330jd.A2E(), va);
        this.A01 = abstractC2330jd.A28();
        this.A02 = abstractC2330jd.A29().A0I();
        this.A04 = abstractC2330jd.A2C();
        this.A03 = abstractC2330jd.A29().A0K();
    }

    private View A00(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
        C1865bq c1865bq = new C1865bq(this.A05, this.A01.A01(), true, false, false);
        c1865bq.A04(this.A02.A0G(), this.A02.A04(), null, false, true);
        c1865bq.setAlignment(17);
        C1859bk c1859bk = new C1859bk(this.A05);
        YB.A0N(c1859bk, 0);
        c1859bk.setRadius(50);
        new LM(c1859bk, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1859bk, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c1865bq, layoutParams);
        if (viewOnClickListenerC1363Kr != null) {
            YB.A0J(viewOnClickListenerC1363Kr);
            linearLayout.addView(viewOnClickListenerC1363Kr, layoutParams);
            viewOnClickListenerC1363Kr.setPadding(XV.A0Z, 0, XV.A0Z, 0);
            if (TextUtils.isEmpty(viewOnClickListenerC1363Kr.getText())) {
                YB.A0H(viewOnClickListenerC1363Kr);
            }
        }
        return linearLayout;
    }

    private C7M A01() {
        C7M c7m = new C7M(this.A05);
        c7m.setLayoutManager(new C2235hr(this.A05, 0, false));
        c7m.setAdapter(new FH(this.A05, this.A03.A02(), A09, this.A00));
        return c7m;
    }

    private final EnumC2019eL A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC2019eL.A03;
        }
        return EnumC2019eL.A02;
    }

    public final Pair<EnumC2019eL, View> A03(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
        View viewA01;
        this.A00 = viewOnClickListenerC1363Kr;
        EnumC2019eL enumC2019eLA02 = A02();
        switch (enumC2019eLA02) {
            case A03:
                viewA01 = A01();
                break;
            default:
                viewA01 = A00(this.A00);
                break;
        }
        VK.A04(viewA01, this.A06, VH.A0S);
        return new Pair<>(enumC2019eLA02, viewA01);
    }
}
