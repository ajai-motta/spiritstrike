package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1894cJ {
    public static byte[] A0N;
    public static String[] A0O = {"pFRbUbIPvfwTsTWtR68DyqtfsQzo0Y9e", "Jmt0yS7cxIqywVTLVazlNOZqViG4fijG", "7JVXgwFSulrh0z9RNSntkrow2", "W96LwBzZpPkBapcy7gGTKWs8B4GUDBcq", "br88nFbBZbLJ3vTh4p9wwCNTIA57FmIY", "mzQptMR0Z3d1fPQPbwNf4EthVYWzR3DW", "IPE7BiI9pZn923UUuncSvZhUL3wMHGrT", "br6hrssh6VRKiVV1vNUkmhf3WWjX02F0"};
    public C1770aJ A08;
    public C1770aJ A09;
    public ViewOnClickListenerC1363Kr A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0E;
    public final int A0F;
    public final AbstractC2330jd A0G;
    public final NN A0H;
    public final NY A0I;
    public final C1426Nd A0J;
    public final C2165gi A0K;
    public final VI A0L;
    public final InterfaceC1706Yh A0M;
    public int A03 = 16;
    public int A02 = 12;
    public int A01 = 10;
    public int A04 = 20;
    public int A05 = 40;
    public int A06 = 52;
    public int A00 = 10;
    public int A07 = 8;
    public boolean A0D = true;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0N, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            if (A0O[2].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0O;
            strArr[3] = "XwNXbwlUcFi7qEktIehGuIyqazGrk614";
            strArr[1] = "hx9Csixc74t4pIrSAOrr1o5nquGlqFF4";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0N = new byte[]{109, 118, 126, 126, 126, 126, 126, 126, 126, 4, 97, 97, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, 37, 41, 43, 104, 32, 39, 37, 35, 36, 41, 41, 45, 104, 39, 34, 53, 104, 47, 40, 50, 35, 52, 53, 50, 47, 50, 47, 39, 42, 104, 32, 47, 40, 47, 53, 46, Ascii.EM, 39, 37, 50, 47, 48, 47, 50, 63, 42, 50, 48, 41};
    }

    static {
        A04();
    }

    public C1894cJ(C2165gi c2165gi, AbstractC2330jd abstractC2330jd, VI vi, Handler handler, InterfaceC1706Yh interfaceC1706Yh) {
        this.A0K = c2165gi;
        this.A0M = interfaceC1706Yh;
        this.A0I = abstractC2330jd.A29().A0I();
        this.A0J = abstractC2330jd.A29().A0K();
        this.A0H = abstractC2330jd.A28();
        this.A0E = abstractC2330jd.A2T();
        this.A0C = abstractC2330jd.A2P();
        this.A0F = AbstractC2028eU.A00(c2165gi.getResources().getDisplayMetrics());
        this.A0L = vi;
        this.A0G = abstractC2330jd;
        A03();
    }

    private ImageView A00(final ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(YN.A01(YM.OTHER_SKIP), this.A04, this.A04, true);
        ImageView imageView = new ImageView(this.A0K);
        imageView.setImageBitmap(scaledBitmap);
        imageView.setColorFilter(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(A02(0, 9, 80)));
        imageView.setBackground(gradientDrawable);
        imageView.setPadding(this.A01, this.A01, this.A01, this.A01);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.cG
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1894cJ.A0B(viewOnClickListenerC1363Kr, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.TOP_END);
        layoutParams.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setVisibility(0);
        return imageView;
    }

    private TextView A01() {
        if (TextUtils.isEmpty(this.A0G.A29().A0I().A08())) {
            return null;
        }
        TextView textView = new TextView(this.A0K);
        textView.setText(this.A0G.A29().A0I().A08());
        textView.setTextColor(-1);
        textView.setTextSize(13.0f);
        textView.setGravity(17);
        return textView;
    }

    private void A03() {
        this.A03 *= this.A0F;
        this.A02 *= this.A0F;
        this.A01 *= this.A0F;
        this.A04 *= this.A0F;
        this.A05 *= this.A0F;
        this.A06 *= this.A0F;
        this.A00 *= this.A0F;
        this.A07 *= this.A0F;
    }

    private void A05(FrameLayout frameLayout) {
        View view = new View(this.A0K);
        view.setBackgroundColor(Color.parseColor(A02(9, 9, 57)));
        view.setAlpha(0.8f);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    private void A06(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        this.A08 = AbstractC1775aO.A01(this.A0K, false, this.A0G, this.A0L, this.A0M, EnumC1773aM.A02, AbstractC1772aL.A00(this.A0G));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.BOTTOM_END);
        layoutParams.setMargins(0, 0, this.A04, this.A03);
        frameLayout2.addView(this.A08, layoutParams);
        frameLayout.addView(frameLayout2);
    }

    private void A07(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        this.A09 = AbstractC1775aO.A01(this.A0K, false, this.A0G, this.A0L, this.A0M, EnumC1773aM.A02, EnumC1776aP.A04);
        YB.A0K(this.A09);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.BOTTOM_START);
        layoutParams.setMargins(this.A04, 0, 0, this.A03);
        frameLayout2.addView(this.A09, layoutParams);
        frameLayout.addView(frameLayout2);
    }

    private void A08(FrameLayout frameLayout) {
        FrameLayout frameLayout2 = new FrameLayout(this.A0K);
        C1774aN c1774aNA02 = AbstractC1775aO.A02(this.A0K, EnumC1773aM.A02, this.A0G);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.BOTTOM_START);
        layoutParams.setMargins(this.A04, 0, 0, this.A03);
        frameLayout2.addView(c1774aNA02, layoutParams);
        frameLayout.addView(frameLayout2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A09(android.widget.FrameLayout r14, com.facebook.ads.redexgen.core.ViewOnClickListenerC1363Kr r15) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1894cJ.A09(android.widget.FrameLayout, com.facebook.ads.redexgen.X.Kr):void");
    }

    private void A0A(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        viewOnClickListenerC1363Kr.setPadding(this.A04, this.A03, this.A04, this.A03);
        viewOnClickListenerC1363Kr.setTextSize(14.0f);
        viewOnClickListenerC1363Kr.A0D();
        viewOnClickListenerC1363Kr.setIncludeFontPadding(true);
        viewOnClickListenerC1363Kr.setLayoutParams(layoutParams);
        viewOnClickListenerC1363Kr.setTextColor(-16777216);
        YB.A0V(viewOnClickListenerC1363Kr, YB.A06(-1, this.A00));
        viewOnClickListenerC1363Kr.setId(View.generateViewId());
        if (viewOnClickListenerC1363Kr.getParent() != null) {
            ((ViewGroup) viewOnClickListenerC1363Kr.getParent()).removeView(viewOnClickListenerC1363Kr);
        }
    }

    public static /* synthetic */ void A0B(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr, View view) {
        viewOnClickListenerC1363Kr.A0E(A02(63, 4, 71));
        viewOnClickListenerC1363Kr.setVisibility(4);
    }

    public final View A0C(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
        if (viewOnClickListenerC1363Kr != null) {
            viewOnClickListenerC1363Kr.setV2Design(true);
        }
        return A0D(viewOnClickListenerC1363Kr, null);
    }

    public final View A0D(ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr, ImageView imageView) {
        this.A0A = viewOnClickListenerC1363Kr;
        this.A0B = imageView != null;
        FrameLayout frameLayout = new FrameLayout(this.A0K);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        C1865bq c1865bq = new C1865bq(this.A0K, this.A0H.A01(), true, false, false);
        c1865bq.A04(this.A0I.A0G(), this.A0I.A0E().toLowerCase(Locale.getDefault()), null, false, false);
        c1865bq.setAlignment(17);
        c1865bq.setTitleTextSize(28);
        c1865bq.setDescriptionTextSize(13);
        c1865bq.A02();
        c1865bq.setPadding(this.A05, 0, this.A05, 0);
        LinearLayout linearLayout = new LinearLayout(this.A0K);
        linearLayout.setClickable(true);
        if (C1615Up.A1D(this.A0K)) {
            linearLayout.setOnClickListener(new ViewOnClickListenerC1892cH(this, viewOnClickListenerC1363Kr));
        }
        linearLayout.setPadding(0, -this.A04, 0, 0);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        if (imageView != null) {
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            linearLayout.addView(imageView);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.A03, 0, this.A07);
        linearLayout.addView(c1865bq, layoutParams);
        TextView textViewA01 = A01();
        if (textViewA01 != null) {
            new LinearLayout.LayoutParams(-2, -2).setMargins(0, this.A07, 0, this.A03);
            linearLayout.addView(textViewA01);
        }
        if (viewOnClickListenerC1363Kr != null) {
            A0A(viewOnClickListenerC1363Kr);
            linearLayout.addView(viewOnClickListenerC1363Kr, layoutParams);
            if (TextUtils.isEmpty(viewOnClickListenerC1363Kr.getText())) {
                YB.A0H(viewOnClickListenerC1363Kr);
            }
        }
        linearLayout.setAlpha(1.0f);
        A05(frameLayout);
        frameLayout.addView(linearLayout);
        A09(frameLayout, viewOnClickListenerC1363Kr);
        if (this.A0G.A2M()) {
            A06(frameLayout);
        }
        AbstractC2330jd abstractC2330jd = this.A0G;
        String[] strArr = A0O;
        if (strArr[0].charAt(31) == strArr[6].charAt(31)) {
            throw new RuntimeException();
        }
        A0O[2] = "4iwGVt394BTmmSYCgqRVgc6es";
        if (abstractC2330jd.A2W()) {
            A08(frameLayout);
        } else if (this.A0G.A2V()) {
            A07(frameLayout);
        }
        return frameLayout;
    }

    public final ViewOnClickListenerC1363Kr A0E() {
        return this.A0A;
    }

    public final void A0F() {
        if (this.A08 != null) {
            this.A08.A0O();
        }
        C1770aJ c1770aJ = this.A09;
        String[] strArr = A0O;
        if (strArr[4].charAt(0) != strArr[7].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0O;
        strArr2[3] = "2Z0HXqlllvltE4fpmlk2k5YgzqGJ81zY";
        strArr2[1] = "EMsyCAj6WMyQurvXYMEHBK7qX1GDVftC";
        if (c1770aJ != null) {
            this.A09.A0O();
        }
    }

    public final /* synthetic */ void A0G(View view) {
        this.A0K.A0F().AB0();
        this.A0M.A4j(A02(18, 45, 88));
    }

    public final void A0H(boolean z) {
        if (!z && this.A08 != null) {
            this.A08.A0P();
        }
        if (this.A09 != null) {
            this.A09.A0P();
        }
    }

    public final void A0I(boolean z) {
        this.A0D = z;
    }
}
