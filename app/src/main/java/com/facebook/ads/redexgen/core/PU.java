package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class PU extends AbstractC1700Yb {
    public static byte[] A03;
    public C2165gi A00;
    public InterfaceC1699Ya A01;
    public final ZM A02;

    static {
        A05();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-75, -34, -31, -27, -41, -110, -77, -42};
    }

    public PU(C2165gi c2165gi, AbstractC2330jd abstractC2330jd, int i) {
        super(c2165gi);
        this.A00 = c2165gi;
        setGravity(16);
        A04();
        this.A02 = new ZM(this.A00, abstractC2330jd, i);
        A03();
    }

    private void A03() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.A02.setContentDescription(A02(0, 8, 39));
        this.A02.setActionClickListener(new ViewOnClickListenerC1716Yr(this));
        addView(this.A02, layoutParams);
    }

    private void A04() {
        View view = new View(this.A00);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        addView(view);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public final void A0A() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public final void A0B() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public final void A0C(float f, int i) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public final void A0D(C1423Na c1423Na, boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public final boolean A0E() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public int getToolbarActionMode() {
        return this.A02.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public int getToolbarHeight() {
        return AbstractC1700Yb.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public InterfaceC1699Ya getToolbarListener() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setAdReportingVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setCTAClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setCTAClickListener(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setFullscreen(boolean z) {
    }

    public void setInitialUnskippableSeconds(int i) {
        this.A02.setInitialUnskippableSeconds(i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setPageDetails(C1435Nm c1435Nm, String str, int i, C1441Ns c1441Ns) {
        this.A02.setInitialUnskippableSeconds(i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setPageDetailsVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setProgress(float f) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setProgressClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setProgressImage(YM ym) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setProgressImmediate(float f) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setProgressSpinnerInvisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setToolbarActionMode(int i) {
        this.A02.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setToolbarListener(InterfaceC1699Ya interfaceC1699Ya) {
        this.A01 = interfaceC1699Ya;
    }
}
