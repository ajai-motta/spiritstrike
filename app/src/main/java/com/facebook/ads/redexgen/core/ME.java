package com.facebook.ads.redexgen.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ME extends AbstractC1728Zd {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (XX.A02 * 8.0f);
    public final RelativeLayout A00;
    public final C1455Og A01;
    public final C2165gi A02;

    public ME(C2165gi c2165gi, VA va, String str, C1435Nm c1435Nm, InterfaceC1707Yi interfaceC1707Yi, InterfaceC1706Yh interfaceC1706Yh) {
        super(c2165gi, va, str, c1435Nm, interfaceC1707Yi, interfaceC1706Yh);
        this.A02 = c2165gi;
        this.A01 = AbstractC1456Oh.A00(c2165gi.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        YB.A0N(this.A00, -1728053248);
        if (C1615Up.A2b(c2165gi)) {
            this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Zi
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A0T(view);
                }
            });
        }
    }

    public static RelativeLayout.LayoutParams A00(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A01() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0O() {
        C1459Ok c1459OkA0A = this.A01.A0A();
        C1743Zs c1743Zs = new C1743Zs(this.A02);
        c1743Zs.setInfo(YM.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        c1743Zs.setOnClickListener(new ViewOnClickListenerC1734Zj(this));
        C1459Ok c1459OkA0B = this.A01.A0B();
        C1743Zs c1743Zs2 = new C1743Zs(this.A02);
        c1743Zs2.setInfo(YM.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        c1743Zs2.setOnClickListener(new ViewOnClickListenerC1735Zk(this));
        C1743Zs c1743Zs3 = new C1743Zs(this.A02);
        c1743Zs3.setInfo(YM.AD_CHOICES_ICON, this.A01.A0M(), "");
        c1743Zs3.setOnClickListener(new ViewOnClickListenerC1736Zl(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        YB.A0N(linearLayout, -1);
        if (!c1459OkA0A.A05().isEmpty()) {
            linearLayout.addView(c1743Zs, itemParams);
        }
        if (!c1459OkA0B.A05().isEmpty()) {
            linearLayout.addView(c1743Zs2, itemParams);
        }
        linearLayout.addView(c1743Zs3, itemParams);
        A01();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0P() {
        this.A00.removeAllViews();
        YB.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0Q(C1459Ok c1459Ok, EnumC1457Oi enumC1457Oi) {
        String strA0E;
        int i;
        String strA01;
        if (enumC1457Oi == EnumC1457Oi.A05) {
            return;
        }
        boolean z = enumC1457Oi == EnumC1457Oi.A06;
        C1725Za c1725Za = new C1725Za(this.A02, this.A0D);
        if (z) {
            C1455Og c1455Og = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            strA0E = c1455Og.A0F();
        } else {
            strA0E = this.A01.A0E();
        }
        C1725Za c1725ZaA0D = c1725Za.A0H(strA0E).A0G(this.A01.A0D()).A0E(c1459Ok.A04()).A0D(z ? YM.REPORT_AD : YM.HIDE_AD);
        if (z) {
            i = -552389;
        } else {
            i = -13272859;
        }
        C1725Za c1725ZaA0C = c1725ZaA0D.A0C(i);
        if (this.A0C != null) {
            C1435Nm c1435Nm = this.A0C;
            if (A03[1].charAt(11) != 'X') {
                strA01 = c1435Nm.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                strA01 = c1435Nm.A01();
            }
        } else {
            strA01 = "";
        }
        C1726Zb adHiddenView = c1725ZaA0C.A0F(strA01).A0L();
        YB.A0N(adHiddenView, -1);
        YB.A0W(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A00(true));
        super.A0Q(c1459Ok, enumC1457Oi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0R(C1459Ok c1459Ok, EnumC1457Oi enumC1457Oi) {
        String strA0H;
        boolean z = enumC1457Oi == EnumC1457Oi.A06;
        C2165gi c2165gi = this.A02;
        InterfaceC1730Zf interfaceC1730Zf = this.A0D;
        if (z) {
            strA0H = this.A01.A0L();
        } else {
            strA0H = this.A01.A0H();
        }
        C1746Zv c1746Zv = new C1746Zv(c2165gi, c1459Ok, interfaceC1730Zf, strA0H, z ? YM.REPORT_AD : YM.HIDE_AD);
        c1746Zv.setClickable(true);
        YB.A0N(c1746Zv, -1);
        c1746Zv.setPadding(A04 * 2, A04, A04 * 2, A04);
        A01();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(c1746Zv, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final boolean A0S() {
        return false;
    }

    public final /* synthetic */ void A0T(View view) {
        this.A0D.A54();
    }
}
