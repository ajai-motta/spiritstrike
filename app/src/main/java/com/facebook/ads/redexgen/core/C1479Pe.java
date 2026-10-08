package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1479Pe extends AbstractC1700Yb {
    public static byte[] A08;
    public static String[] A09 = {"fERBvMHNNnzy3nk4ZNYWfuNmaphricqR", "36dIUinCjWD1st1oFa", "LXwDs8sQ22ml4TxQk7X9Yy2PND6TLebQ", "XXrP48rjLtmBZR3EppDVWeHK64Oiflqr", "lJVaLdSDUZo8CZ4Z9dOQvPM3HMB2ksyr", "0Ja0eNtF0Cq6bAhyEs6lkKXZN09pMEMJ", "OH638NDLRGGNEgbxKp", "sf1pLwcEB21wXoeUmJKgsuWxlp0ZYlJT"};
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final Integer A0D;
    public static final Integer A0E;
    public int A00;
    public InterfaceC1704Yf A01;
    public float A02;
    public InterfaceC1699Ya A03;
    public boolean A04;
    public final C2165gi A05;
    public final C1703Ye A06;
    public final EnumC1705Yg A07;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A08 = new byte[]{110, 65, 66, 94, 72, Ascii.CR, 108, 73};
        String[] strArr = A09;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[6] = "7Gx7HJtPRSPh20N7Kw";
        strArr2[1] = "xYim5uVBO0YQkaepUH";
    }

    static {
        A07();
        A0A = XV.A0C;
        A0C = XV.A0H;
        A0B = (int) (((double) A0C) / 2.0d);
        A0D = 855638016;
        A0E = null;
    }

    public C1479Pe(C2165gi c2165gi, EnumC1705Yg enumC1705Yg, AbstractC2330jd abstractC2330jd, int i, InterfaceC1704Yf interfaceC1704Yf) {
        super(c2165gi);
        this.A00 = 0;
        this.A04 = true;
        this.A05 = c2165gi;
        this.A07 = enumC1705Yg;
        this.A01 = interfaceC1704Yf;
        A04();
        this.A06 = new C1703Ye(this.A05, abstractC2330jd, this.A07, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 48;
        this.A06.setContentDescription(A03(0, 8, 81));
        this.A06.setOnClickListener(new ViewOnClickListenerC1702Yd(this));
        addView(this.A06, layoutParams);
        A06();
    }

    private void A04() {
        View view = new View(this.A05);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        addView(view);
    }

    private void A05() {
        Rect requestedMargins = getRequestedMargins();
        if (this.A01 != null && requestedMargins != null) {
            this.A01.AEZ(getToolbarHeight());
        }
    }

    private void A06() {
        if (Build.VERSION.SDK_INT >= 28) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.facebook.ads.redexgen.X.Yc
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.A00.A0F(view, windowInsets);
                }
            });
        }
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

    public final /* synthetic */ WindowInsets A0F(View view, WindowInsets windowInsets) {
        int cutoutInsetTop;
        DisplayCutout cutout = windowInsets.getDisplayCutout();
        if (cutout != null && (cutoutInsetTop = cutout.getSafeInsetTop()) != this.A00) {
            this.A00 = cutoutInsetTop;
            A05();
        }
        return windowInsets;
    }

    public final void A0G() {
        if (this.A03 != null && this.A04) {
            InterfaceC1699Ya interfaceC1699Ya = this.A03;
            if (A09[4].charAt(19) != 'Q') {
                throw new RuntimeException();
            }
            String[] strArr = A09;
            strArr[7] = "Nz9FTwNSu9sKseNM42ZlibQZooapJX2m";
            strArr[0] = "gMFqMi1vQ9rk8jIPSWsyy3tPRxgAiTUd";
            interfaceC1699Ya.ACl(this);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public Rect getRequestedMargins() {
        if (getResources().getConfiguration().orientation == 1) {
            int i = XV.A0u;
            int i2 = XV.A0c;
            int orientation = this.A00;
            return new Rect(i, i2 + orientation, 0, 0);
        }
        return new Rect(XV.A0u, XV.A0v, 0, 0);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public int getToolbarActionMode() {
        return this.A06.A09();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public int getToolbarHeight() {
        if (this.A07 == EnumC1705Yg.A08) {
            if (getResources().getConfiguration().orientation == 1) {
                int i = this.A00;
                int orientation = A0C;
                int i2 = i + orientation;
                int orientation2 = XV.A0c;
                return i2 + (orientation2 * 2);
            }
            int i3 = A0C;
            int orientation3 = XV.A0v;
            return i3 + (orientation3 * 2);
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public InterfaceC1699Ya getToolbarListener() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A05();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A05();
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setClickable(float r5) {
        /*
            r4 = this;
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L29
            com.facebook.ads.redexgen.X.gi r0 = r4.A05
            boolean r3 = com.facebook.ads.redexgen.core.C1615Up.A19(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C1479Pe.A09
            r0 = 4
            r1 = r1[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            r0 = 81
            if (r1 == r0) goto L20
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L20:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1479Pe.A09
            java.lang.String r1 = "CynGSFEo4busEIaNEzQQTo6NoR2HzSp3"
            r0 = 5
            r2[r0] = r1
            if (r3 == 0) goto L2d
        L29:
            r0 = 1
        L2a:
            r4.A04 = r0
            return
        L2d:
            r0 = 0
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1479Pe.setClickable(float):void");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setFullscreen(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setPageDetails(C1435Nm c1435Nm, String str, int i, C1441Ns c1441Ns) {
        this.A02 = i * 1000;
        setClickable(this.A02);
        this.A06.A0A(this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setPageDetailsVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setProgress(float f) {
        float f2 = (f / 100.0f) * this.A02;
        float remainingMs = 0.0f;
        if (this.A02 - f2 > 0.0f) {
            float remainingMs2 = this.A02;
            remainingMs = remainingMs2 - f2;
        }
        this.A06.A0B(remainingMs);
        setClickable(remainingMs);
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
        this.A06.A0C(i);
        if (i == 0) {
            setProgress(100.0f);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1700Yb
    public void setToolbarListener(InterfaceC1699Ya interfaceC1699Ya) {
        this.A03 = interfaceC1699Ya;
    }
}
