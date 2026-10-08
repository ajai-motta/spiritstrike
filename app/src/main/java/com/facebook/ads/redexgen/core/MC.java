package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MC extends AbstractC1728Zd {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C1455Og A03;
    public final C2165gi A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-52, -21, -19, -11, 120, -95, -92, -88, -102, 85, 118, -103, 85, -121, -102, -91, -92, -89, -87, -98, -93, -100};
    }

    static {
        A01();
        A08 = (int) (XX.A02 * 8.0f);
        A07 = (int) (XX.A02 * 10.0f);
        A06 = (int) (XX.A02 * 44.0f);
    }

    public MC(C2165gi c2165gi, VA va, String str) {
        super(c2165gi, va, str);
        this.A04 = c2165gi;
        this.A03 = AbstractC1456Oh.A00(this.A04.A02());
        this.A00 = new ImageView(getContext());
        this.A00.setPadding(A07, A07, A07, A07);
        this.A00.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A06, A06);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        YB.A0N(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        this.A01.setPadding(A08, A08, A08, A08);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0O() {
        this.A00.setImageBitmap(YN.A01(YM.CROSS));
        this.A00.setOnClickListener(new ViewOnClickListenerC1747Zw(this));
        this.A00.setContentDescription(A00(4, 18, 29));
        C1732Zh c1732Zh = new C1732Zh(this.A04);
        c1732Zh.setData(this.A03.A0H(), YM.HIDE_AD);
        c1732Zh.setOnClickListener(new ViewOnClickListenerC1748Zx(this, c1732Zh));
        C1732Zh c1732Zh2 = new C1732Zh(this.A04);
        c1732Zh2.setData(this.A03.A0L(), YM.REPORT_AD);
        c1732Zh2.setOnClickListener(new ViewOnClickListenerC1749Zy(this, c1732Zh2));
        C1732Zh c1732Zh3 = new C1732Zh(this.A04);
        c1732Zh3.setData(this.A03.A0M(), YM.AD_CHOICES_ICON);
        c1732Zh3.setOnClickListener(new ViewOnClickListenerC1750Zz(this, c1732Zh3));
        LinearLayout.LayoutParams menuParams = new LinearLayout.LayoutParams(-2, -2);
        menuParams.setMargins(A08, A08, A08, A08);
        menuParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        YB.A0W(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams);
        linearLayout.addView(c1732Zh, menuParams);
        linearLayout.addView(c1732Zh2, menuParams);
        linearLayout.addView(c1732Zh3, menuParams);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0P() {
        YB.A0I(this);
        YB.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0Q(C1459Ok c1459Ok, EnumC1457Oi enumC1457Oi) {
        String strA0H;
        YM ym;
        int i;
        this.A00.setOnClickListener(null);
        if (enumC1457Oi == EnumC1457Oi.A06) {
            strA0H = this.A03.A0F();
            ym = YM.REPORT_AD;
            i = -552389;
        } else {
            strA0H = this.A03.A0H();
            ym = YM.HIDE_AD;
            i = -13272859;
        }
        C1725Za c1725ZaA0H = new C1725Za(this.A04, this.A0D).A0H(strA0H);
        String title = this.A03.A0D();
        C1725Za c1725ZaA0G = c1725ZaA0H.A0G(title);
        String title2 = c1459Ok.A04();
        C1726Zb adHiddenView = c1725ZaA0G.A0E(title2).A0J(false).A0D(ym).A0C(i).A0K(false).A0I(false).A0L();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        YB.A0W(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(adHiddenView, layoutParams);
        super.A0Q(c1459Ok, enumC1457Oi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final void A0R(C1459Ok c1459Ok, EnumC1457Oi enumC1457Oi) {
        boolean isReportFlow = enumC1457Oi == EnumC1457Oi.A06;
        C1746Zv c1746Zv = new C1746Zv(this.A04, c1459Ok, this.A0D, isReportFlow ? YM.REPORT_AD : YM.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(YN.A01(YM.BACK_ARROW));
        this.A00.setOnClickListener(new ViewOnClickListenerC1751a0(this));
        this.A00.setContentDescription(A00(0, 4, 114));
        YB.A0W(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(c1746Zv, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1728Zd
    public final boolean A0S() {
        return true;
    }
}
