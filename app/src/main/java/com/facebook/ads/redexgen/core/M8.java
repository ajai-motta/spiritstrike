package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class M8 extends LinearLayout implements InterfaceC1808av {
    public static byte[] A0C;
    public static String[] A0D = {"gmSbsJUTV6ssYU6sPFdQApLIq3Ne91IM", "MfGeHL5PmkPbpLjQYYWOTSdzt", "", "SJThwTW85f7z2tdQDzwWLTm6w", "rQXooJE", "LhKJvtc1UCCcm5M0SWMNGP7YHUEfZfxE", "", "2Oh5HyK"};
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final Uri A0H;
    public static final View.OnTouchListener A0I;
    public ImageView A00;
    public ImageView A01;
    public ImageView A02;
    public ImageView A03;
    public C1799am A04;
    public InterfaceC1807au A05;
    public String A06;
    public final WebView A07;
    public final C2165gi A08;
    public final InterfaceC1804ar A09;
    public final boolean A0A;
    public final boolean A0B;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        byte[] bArr = {-43, -12, -10, -2, -68, -27, -24, -20, -34, 0, 41, 44, 49, Ascii.ESC, 44, Ascii.RS, Ascii.ETB, 56, 45, 54, -24, 54, 41, 60, 49, 62, 45, -24, 42, 58, 55, 63, 59, 45, 58, 41, 42, 55, Base64.padSymbol, 60, 2, 42, 52, 41, 54, 51, 55, 68, 58, 72, 69, 63, 58, 4, 63, 68, 74, 59, 68, 74, 4, 55, 57, 74, 63, 69, 68, 4, 44, Ascii.US, Ascii.ESC, 45, -29, -17, -19, -82, -31, -18, -28, -14, -17, -23, -28, -82, -29, -24, -14, -17, -19, -27, 59, 71, 71, 67, Ascii.CR, 2, 2, 74, 74, 74, 1, 57, 52, 54, 56, 53, 66, 66, 62, 1, 54, 66, SignedBytes.MAX_POWER_OF_TWO};
        String[] strArr = A0D;
        if (strArr[2].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[7] = "Ujyw6mT";
        strArr2[4] = "Vqhraj8";
        A0C = bArr;
    }

    static {
        A0A();
        A0F = Color.rgb(224, 224, 224);
        A0G = Color.argb(34, 0, 0, 0);
        A0E = XV.A0k;
        A0H = XB.A00(A06(90, 23, 118));
        A0I = new ViewOnTouchListenerC1784aX();
    }

    public M8(C2165gi c2165gi, WebView webView, boolean z) {
        super(c2165gi);
        this.A09 = new M9(this);
        this.A07 = webView;
        this.A08 = c2165gi;
        this.A0A = AbstractC1616Uq.A06(c2165gi);
        this.A0B = z;
        A08();
        A0C(false);
    }

    private void A08() {
        float f;
        YB.A0N(this, -1);
        setGravity(16);
        this.A01 = new ImageView(this.A08);
        this.A01.setContentDescription(A06(4, 5, 28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A0E, A0E);
        layoutParams.setMargins(0, 0, XV.A0b, 0);
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setImageBitmap(YN.A01(YM.BROWSER_CLOSE));
        this.A01.setOnTouchListener(A0I);
        this.A01.setOnClickListener(new ViewOnClickListenerC1785aY(this));
        addView(this.A01, layoutParams);
        if (this.A0A && !C1615Up.A2w(this.A08)) {
            this.A00 = new ImageView(this.A08);
            this.A00.setEnabled(false);
            this.A00.setAlpha(0.3f);
            this.A00.setContentDescription(A06(0, 4, 54));
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A0E, A0E);
            this.A00.setScaleType(ImageView.ScaleType.CENTER);
            this.A00.setImageBitmap(YN.A01(YM.BACK_ARROW_V2));
            this.A00.setOnTouchListener(A0I);
            this.A00.setOnClickListener(new ViewOnClickListenerC1786aZ(this));
            addView(this.A00, layoutParams2);
        }
        this.A04 = new C1799am(this.A08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        if (this.A0A || C1615Up.A2w(this.A08)) {
            f = 0.5f;
        } else {
            f = 1.0f;
        }
        layoutParams3.weight = f;
        this.A04.setGravity(17);
        if (C1615Up.A2w(this.A08) && !this.A0B) {
            LinearLayout linearLayout = new LinearLayout(this.A08);
            linearLayout.setOrientation(1);
            addView(linearLayout, layoutParams3);
            YB.A0K(linearLayout);
            ImageView imageView = new ImageView(this.A08);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageBitmap(YN.A01(YM.HANDLER));
            linearLayout.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
            LinearLayout.LayoutParams closeButtonParams = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.addView(this.A04, closeButtonParams);
        } else {
            addView(this.A04, layoutParams3);
        }
        if (this.A0A && !C1615Up.A2w(this.A08)) {
            this.A02 = new ImageView(this.A08);
            this.A02.setEnabled(false);
            this.A02.setAlpha(0.3f);
            this.A02.setContentDescription(A06(9, 7, 93));
            ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(A0E, A0E);
            this.A02.setScaleType(ImageView.ScaleType.CENTER);
            this.A02.setImageBitmap(YN.A02(YM.BACK_ARROW_V2));
            this.A02.setOnTouchListener(A0I);
            this.A02.setOnClickListener(new ViewOnClickListenerC1787aa(this));
            addView(this.A02, layoutParams4);
        }
        this.A03 = new ImageView(this.A08);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(A0E, A0E);
        layoutParams5.setMargins(XV.A0b, 0, 0, 0);
        this.A03.setContentDescription(A06(16, 19, 107));
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setOnTouchListener(A0I);
        this.A03.setOnClickListener(new ViewOnClickListenerC1788ab(this));
        addView(this.A03, layoutParams5);
        A09();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09() {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.M8.A09():void");
    }

    private void A0C(boolean z) {
        int i = z ? 0 : 8;
        if (this.A00 != null) {
            this.A00.setVisibility(i);
        }
        if (this.A02 != null) {
            this.A02.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(boolean z) {
        if (z) {
            A0C(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1808av
    public InterfaceC1804ar getBrowserNavigationListener() {
        return this.A09;
    }

    public static Bitmap getExternalBrowserBitmap() {
        YM ym = YM.BROWSER_LAUNCH_NATIVE_V2;
        if (A0D[0].charAt(23) == 'K') {
            throw new RuntimeException();
        }
        A0D[0] = "lUY1mRDCMXM3WZHcFiHRXNaY27JpPEEp";
        return YN.A01(ym);
    }

    public void setCloseButtonVisibility(int i) {
        this.A01.setVisibility(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1808av
    public void setListener(InterfaceC1807au interfaceC1807au) {
        this.A05 = interfaceC1807au;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1808av
    public void setTitle(String str) {
        this.A04.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1808av
    public void setUrl(String str) {
        this.A06 = str;
        if (!TextUtils.isEmpty(this.A06)) {
            String strA06 = A06(35, 11, 107);
            if (A0D[0].charAt(23) == 'K') {
                throw new RuntimeException();
            }
            A0D[0] = "qQ1cUQL6zuFcmcs6RwakvLgHhcCBx0UL";
            if (!strA06.equals(this.A06)) {
                this.A04.setSubtitle(this.A06);
                this.A03.setEnabled(true);
                this.A03.setColorFilter((ColorFilter) null);
                return;
            }
        }
        this.A04.setSubtitle(null);
        this.A03.setEnabled(false);
        this.A03.setColorFilter(new PorterDuffColorFilter(A0F, PorterDuff.Mode.SRC_IN));
    }
}
