package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1914cd extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final ViewOnClickListenerC1363Kr A02;
    public static final int A05 = (int) (XX.A02 * 36.0f);
    public static final int A06 = (int) (XX.A02 * 36.0f);
    public static final int A03 = (int) (XX.A02 * 23.0f);
    public static final int A04 = (int) (XX.A02 * 3.0f);
    public static final int A07 = (int) (XX.A02 * 4.0f);

    public C1914cd(C2165gi c2165gi, ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr, AbstractC2330jd abstractC2330jd, VA va, InterfaceC1706Yh interfaceC1706Yh, C2110fp c2110fp, Y2 y2, C1423Na c1423Na, InterfaceC1843bU interfaceC1843bU) {
        super(c2165gi);
        this.A00 = c1423Na.A09(true);
        this.A01 = new RelativeLayout(c2165gi);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c2165gi, abstractC2330jd.A29().A0J().A04());
        if (viewOnClickListenerC1363Kr == null) {
            this.A02 = new ViewOnClickListenerC1363Kr(c2165gi, abstractC2330jd.A0w(), (C1423Na) null, va, interfaceC1706Yh, c2110fp, y2, abstractC2330jd.A2A());
        } else {
            this.A02 = viewOnClickListenerC1363Kr;
        }
        A03();
        this.A02.setCta(abstractC2330jd.A29().A0J(), abstractC2330jd.A2E(), new HashMap(), interfaceC1843bU);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C2165gi c2165gi, View view) {
        ImageView imageView = new ImageView(c2165gi);
        imageView.setImageBitmap(YN.A01(YM.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C2165gi c2165gi, String str) {
        Button button = new Button(c2165gi);
        YB.A0K(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        YB.A0Q(button, this.A00, A07);
        button.setTextColor(-16777216);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c2165gi, button);
    }

    public final EnumC1414Mq A02(String str) {
        return this.A02.A0E(str);
    }

    public final void A03() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC2330jd abstractC2330jd, AbstractC1700Yb abstractC1700Yb) {
        this.A02.A0F(abstractC2330jd, abstractC1700Yb);
    }

    public void setCta(C1425Nc c1425Nc, String str, HashMap<String, String> extras, InterfaceC1843bU interfaceC1843bU) {
        this.A02.setCta(c1425Nc, str, extras, interfaceC1843bU);
    }
}
