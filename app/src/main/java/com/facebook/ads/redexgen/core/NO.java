package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.base.Ascii;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class NO extends RelativeLayout implements InterfaceC1707Yi {
    public static byte[] A0h;
    public static String[] A0i = {"HOR7o31Iej4cYWuhQXExnEuENMywT0cc", "lMe4cl58LNQGNUAHyasApQ9JUE0svDiV", "D3sd2x1kxAGmbwUwbgSwAdGIbJmc5gOO", "0qcoppWNPh", "IKOWodR4Z8ze5gnDmb", "KTSiIx6w", "wnW3I4EzpNnUTo4gipPMifUFglZZiY67", "f8O"};
    public static final int A0j;
    public static final int A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public static final RelativeLayout.LayoutParams A0p;
    public View A00;
    public LinearLayout A01;
    public RelativeLayout A02;
    public RelativeLayout A03;
    public RelativeLayout A04;
    public Toast A05;
    public C1527Re A06;
    public XO A07;
    public C1770aJ A08;
    public C1774aN A09;
    public ViewOnClickListenerC1363Kr A0A;
    public C2016eI A0B;
    public C2033ea A0C;
    public String A0D;
    public String A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public final Handler A0N;
    public final AbstractC2330jd A0O;
    public final C1437No A0P;
    public final InterfaceC1533Rk A0Q;
    public final C2165gi A0R;
    public final VA A0S;
    public final VI A0T;
    public final XO A0U;
    public final ViewOnSystemUiVisibilityChangeListenerC1696Xx A0V;
    public final InterfaceC1706Yh A0W;
    public final ZU A0X;
    public final InterfaceC1856bh A0Y;
    public final C1857bi A0Z;
    public final C2020eM A0a;
    public final AtomicBoolean A0b;
    public final AtomicBoolean A0c;
    public final boolean A0d;
    public final boolean A0e;
    public final boolean A0f;
    public final AbstractC1700Yb A0g;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public NO(C2165gi c2165gi, VA va, InterfaceC1706Yh interfaceC1706Yh, AbstractC2330jd abstractC2330jd, String str, ZU zu, boolean z) {
        super(c2165gi);
        String strA0D = A0D(0, 0, 113);
        this.A0E = strA0D;
        this.A0D = strA0D;
        this.A0Q = new OV(this);
        this.A0c = new AtomicBoolean(false);
        this.A0b = new AtomicBoolean(false);
        this.A0K = false;
        this.A0M = true;
        this.A0H = false;
        this.A0G = false;
        this.A0N = new Handler(Looper.getMainLooper());
        this.A0F = false;
        this.A0f = z;
        this.A0R = c2165gi;
        this.A0W = interfaceC1706Yh;
        this.A0S = va;
        this.A0O = abstractC2330jd;
        this.A0P = abstractC2330jd.A29().A0H().A07();
        this.A0T = new VI(this.A0O.A2E(), this.A0S);
        this.A0X = zu;
        this.A0C = new C2033ea(c2165gi, this.A0X, str, this.A0W);
        if (abstractC2330jd.A29().A0H().A07() != null) {
            this.A0I = abstractC2330jd.A29().A0H().A07().A0X();
            this.A0E = abstractC2330jd.A29().A0H().A07().A0O();
            this.A0D = abstractC2330jd.A29().A0H().A07().A0N();
        }
        this.A0J = this.A0O.A29().A0S() && this.A0O.A29().A0H().A03() > 0;
        this.A0e = this.A0O.A29().A0H().A0B();
        if (this.A0P == null) {
            this.A0W.A4j(this.A0X.A81());
            this.A0W.A4j(this.A0X.A7w());
        }
        int iA03 = this.A0P != null ? !this.A0P.A0c() ? (this.A0J && this.A0e) ? this.A0O.A29().A0H().A03() : this.A0P.A0C() : this.A0P.A0E() : 0;
        this.A0c.set(!this.A0P.A0W());
        OV ov = null;
        this.A0U = new XO(iA03, new C1444Nv(this, ov));
        this.A0d = C1615Up.A0o(this.A0R);
        this.A0g = A07();
        if (this.A0P.A0c()) {
            this.A0g.A09();
        }
        this.A0a = new C2020eM(this.A0R, this.A0S, this.A0O);
        AbstractC1866br.A00(c2165gi, this, abstractC2330jd.A29().A0H().A08());
        this.A0V = new ViewOnSystemUiVisibilityChangeListenerC1696Xx(this);
        this.A0V.A05(EnumC1695Xw.A02);
        if (C1615Up.A2K(this.A0R)) {
            this.A0g.setProgressSpinnerInvisible(true);
        }
        NP np = new NP(this, ov);
        HashMap map = new HashMap();
        map.put(A0D(56, 9, 90), this.A0X.A8l());
        this.A0B = new C2016eI(this.A0R, this.A0O, this.A0P, this.A0S, np, map);
        A0K();
        this.A0W.A45(this, new RelativeLayout.LayoutParams(-1, -1));
        A0H();
        this.A0Y = new C1448Nz(this);
        this.A0Z = new C1857bi(this.A0R, this.A0g, this.A0O, (C1202Ek) null, this.A0W, this.A0Y, this.A0A, this.A02, this.A0B);
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
        if (this.A0P.A0c()) {
            this.A0R.A0F().AEU();
        }
    }

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0h, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A0h = new byte[]{124, 85, 123, 83, 69, 67, 83, 125, 49, 62, 59, 49, 57, Ascii.CR, Base64.padSymbol, 32, 59, 53, 59, 60, Ascii.SI, 0, 5, Ascii.SI, 7, 51, Ascii.US, 3, Ascii.EM, Ascii.RS, Ascii.SI, 9, 62, 57, 35, 50, 37, 36, 35, 62, 35, 62, 54, 59, 87, 88, 77, 80, 79, 92, 102, 90, 85, 80, 90, 82, 65, 93, 80, 82, 84, 92, 84, 95, 69, 104, 127, 109, 123, 104, 126, 127, 126, 69, 108, 115, 126, 127, 117, Ascii.RS, Ascii.FF, Ascii.VT, Ascii.US, 0, Ascii.FF, Ascii.RS, 54, 10, 5, 0, 10, 2};
    }

    static {
        A0P();
        A0p = new RelativeLayout.LayoutParams(-1, -1);
        A0k = XV.A0N;
        A0l = XV.A09;
        A0o = XV.A07;
        A0m = XV.A05;
        A0n = P3.A02(-1, 77);
        A0j = XV.A0U;
    }

    public NO(C2165gi c2165gi, VA va, InterfaceC1706Yh interfaceC1706Yh, AbstractC2330jd abstractC2330jd, String str, ZU zu) {
        this(c2165gi, va, interfaceC1706Yh, abstractC2330jd, str, zu, false);
    }

    private FullScreenAdToolbar A07() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A0R, this.A0W, this.A0T, 0, this.A0O.A22(), this.A0I);
        fullScreenAdToolbar.setFullscreen(true);
        fullScreenAdToolbar.A0D(this.A0O.A28().A01(), ViewOnClickListenerC1363Kr.A05(this.A0O));
        fullScreenAdToolbar.setPageDetailsVisible(false);
        fullScreenAdToolbar.setPageDetails(this.A0O.A2C(), this.A0O.A2E(), this.A0P.A0C(), this.A0O.A2D());
        fullScreenAdToolbar.setToolbarListener(new C1445Nw(this));
        return fullScreenAdToolbar;
    }

    private ViewOnClickListenerC1363Kr A09() {
        if (this.A0B == null || this.A0B.getViewabilityChecker() == null || this.A0B.getTouchDataRecorder() == null) {
            return null;
        }
        ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr = new ViewOnClickListenerC1363Kr(this.A0R, this.A0X.A7M(), this.A0O.A28().A01(), this.A0S, this.A0W, this.A0B.getViewabilityChecker(), this.A0B.getTouchDataRecorder(), this.A0O.A2A());
        YB.A0K(viewOnClickListenerC1363Kr);
        viewOnClickListenerC1363Kr.setText(this.A0O.A29().A0J().A04());
        viewOnClickListenerC1363Kr.setTextSize(14.0f);
        viewOnClickListenerC1363Kr.setPadding(XV.A02, XV.A02, XV.A02, XV.A02);
        viewOnClickListenerC1363Kr.setOnClickListener(new Z6(this));
        return viewOnClickListenerC1363Kr;
    }

    private C1865bq A0B() {
        C2165gi c2165gi = this.A0R;
        C1423Na c1423NaA01 = this.A0O.A28().A01();
        int i = !this.A0J ? 16 : 17;
        boolean z = this.A0J;
        String[] strArr = A0i;
        if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[7] = "YLS";
        strArr2[4] = "sNsC3VBoYaF6TxGjee";
        C1865bq c1865bq = new C1865bq(c2165gi, c1423NaA01, true, i, !z ? 14 : 13, 0);
        c1865bq.A04(this.A0O.A29().A0I().A0G(), this.A0O.A29().A0I().A0F(), null, false, true);
        TextView descriptionTv = c1865bq.getDescriptionTextView();
        descriptionTv.setAlpha(0.8f);
        descriptionTv.setMaxLines(1);
        descriptionTv.setEllipsize(TextUtils.TruncateAt.END);
        TextView descriptionTv2 = c1865bq.getTitleTextView();
        descriptionTv2.setMaxLines(1);
        descriptionTv2.setEllipsize(TextUtils.TruncateAt.END);
        return c1865bq;
    }

    private void A0G() {
        String strA01;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0k, A0k);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        C1859bk c1859bk = new C1859bk(this.A0R);
        YB.A0N(c1859bk, 0);
        YB.A0K(c1859bk);
        new LM(c1859bk, this.A0R).A05(A0k, A0k).A07(this.A0O.A2C().A01());
        TextView textView = new TextView(this.A0R);
        YB.A0K(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(this.A0O.A28().A01().A07(true));
        textView.setText(this.A0O.A29().A0I().A0G());
        textView.setTextSize(!this.A0I ? 16.0f : 17.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        C1861bm c1861bm = new C1861bm(this.A0R, !this.A0I ? A0o : A0m, 5, A0n, -1);
        c1861bm.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        TextView textView2 = new TextView(this.A0R);
        textView2.setTextColor(this.A0O.A28().A01().A07(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        if (!this.A0I) {
            textView2.setTextSize(13.0f);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.leftMargin = XV.A0U;
        LinearLayout linearLayout = new LinearLayout(this.A0R);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0l);
        layoutParams4.topMargin = XV.A0U / 2;
        layoutParams4.addRule(3, textView.getId());
        linearLayout.addView(c1861bm, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        RelativeLayout.LayoutParams ratingInfoContainerParams = new RelativeLayout.LayoutParams(-2, -2);
        ratingInfoContainerParams.leftMargin = XV.A0U;
        ratingInfoContainerParams.addRule(1, c1859bk.getId());
        ratingInfoContainerParams.addRule(15);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(linearLayout, layoutParams4);
        relativeLayout.addView(textView);
        if (this.A04 != null) {
            this.A04.removeAllViews();
            this.A04.addView(relativeLayout, ratingInfoContainerParams);
            this.A04.addView(c1859bk, layoutParams);
        }
        if (TextUtils.isEmpty(this.A0O.A29().A0I().A0C())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        c1861bm.setRating(Float.parseFloat(this.A0O.A29().A0I().A0C()));
        if (this.A0O.A29().A0I().A09() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A0D(0, 1, 63));
        if (!this.A0I) {
            strA01 = NumberFormat.getNumberInstance().format(Integer.parseInt(this.A0O.A29().A0I().A09()));
        } else {
            strA01 = AbstractC1679Xg.A01(Integer.parseInt(this.A0O.A29().A0I().A09()));
        }
        sb.append(strA01);
        sb.append(A0D(1, 1, 23));
        textView2.setText(sb.toString());
    }

    private void A0H() {
        if (this.A0P.A0W()) {
            A0J();
        } else {
            A0O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I() {
        this.A0L = true;
        if (this.A0O.A29().A0S()) {
            this.A0C.A06();
            this.A0W.A4k(this.A0X.A6l(), new C4K(0, 0));
        }
    }

    private void A0J() {
        C1988dq c1988dqA0F = new Cdo(this.A0R, this.A0O.A29().A0I(), this.A0O.A2C()).A0A(this.A0O.A28().A01()).A0D(this.A0P.A0Q()).A0C(this.A0P.A0K()).A09(2000).A0E(this.A0I).A0B(this.A0E).A0F();
        VK.A04(c1988dqA0F, this.A0T, VH.A0U);
        addView(c1988dqA0F, A0p);
        c1988dqA0F.A04(new C1447Ny(this));
    }

    private void A0K() {
        RelativeLayout.LayoutParams layoutParams;
        this.A0A = A09();
        this.A02 = new RelativeLayout(getContext());
        YB.A0K(this.A02);
        this.A04 = new RelativeLayout(getContext());
        YB.A0K(this.A04);
        if (this.A0d) {
            A0G();
        } else {
            RelativeLayout relativeLayout = this.A04;
            C1865bq c1865bqA0B = A0B();
            RelativeLayout.LayoutParams iconAndMetaDataContainerParams = new RelativeLayout.LayoutParams(-2, -2);
            relativeLayout.addView(c1865bqA0B, iconAndMetaDataContainerParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, XV.A09, 0);
        this.A02.addView(this.A04, layoutParams2);
        if (this.A0A != null) {
            ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr = this.A0A;
            String[] strArr = A0i;
            if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
                throw new RuntimeException();
            }
            A0i[3] = InneractiveMediationDefs.GENDER_FEMALE;
            layoutParams2.addRule(0, viewOnClickListenerC1363Kr.getId());
            if (!this.A0I) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(6, this.A04.getId());
                layoutParams.addRule(8, this.A04.getId());
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                YB.A0V(this.A0A, YB.A06(-16738826, A0j));
                this.A0A.setStateListAnimator(null);
                this.A0A.setPadding(XV.A0B, XV.A06, XV.A0B, XV.A06);
                YB.A0Z(this.A0A);
            }
            layoutParams.addRule(11);
            this.A02.addView(this.A0A, layoutParams);
        }
        YB.A0K(this.A0g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10);
        this.A01 = new LinearLayout(getContext());
        YB.A0K(this.A01);
        RelativeLayout.LayoutParams adWebViewParams = new RelativeLayout.LayoutParams(-2, -2);
        adWebViewParams.setMargins(XV.A09, XV.A05, XV.A09, XV.A05);
        adWebViewParams.addRule(12);
        this.A01.setOrientation(1);
        RelativeLayout.LayoutParams toolbarParams = new RelativeLayout.LayoutParams(-1, -1);
        toolbarParams.setMargins(XV.A09, 0, XV.A09, 0);
        toolbarParams.addRule(3, this.A0g.getId());
        toolbarParams.addRule(2, this.A01.getId());
        this.A01.addView(this.A02, new RelativeLayout.LayoutParams(-2, -2));
        this.A03 = new RelativeLayout(getContext());
        YB.A0K(this.A03);
        this.A01.addView(this.A03);
        if (this.A0O.A2M()) {
            this.A0g.A08();
            A0M();
        }
        if (this.A0O.A2W()) {
            A0L();
        }
        this.A0g.setVisibility(4);
        this.A0B.setVisibility(4);
        this.A02.setVisibility(4);
        addView(this.A0g, layoutParams3);
        addView(this.A0B, toolbarParams);
        addView(this.A01, adWebViewParams);
        if (this.A0P.A0Y()) {
            this.A0B.A0C();
        }
    }

    private void A0L() {
        this.A09 = AbstractC1775aO.A02(this.A0R, EnumC1773aM.A03, this.A0O);
        YB.A0K(this.A09);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.topMargin = XV.A09;
        this.A03.addView(this.A09, layoutParams);
    }

    private void A0M() {
        this.A08 = AbstractC1775aO.A01(this.A0R, true, this.A0O, this.A0T, this.A0W, EnumC1773aM.A03, AbstractC1772aL.A00(this.A0O));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.topMargin = XV.A09;
        this.A03.addView(this.A08, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N() {
        if (this.A0O.A2M() && this.A08 != null) {
            this.A08.A0P();
            if (this.A0O.A2U()) {
                AbstractC1772aL.A04(this.A0R, EnumC1773aM.A02);
            } else {
                AbstractC1772aL.A05(this.A0R, EnumC1773aM.A02);
            }
        }
        if (this.A0O.A2W() && this.A09 != null) {
            AbstractC1772aL.A06(this.A0R, EnumC1773aM.A02);
        }
        new VI(this.A0O.A2E(), this.A0S).A04(VH.A0z, null);
        this.A0b.set(true);
        YB.A0W(this);
        YB.A0H(this.A0B);
        YB.A0d(this.A0Z, this.A00, this.A0B);
        if (this.A0I) {
            boolean z = this.A0d;
            String[] strArr = A0i;
            if (strArr[7].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[6] = "qNCG6dDJsAPFbWTySRxInyS8ppXyMF33";
            strArr2[1] = "jWdNFAVobp8QAHjjZXwWCxlFqJ2u0nxR";
            if (z) {
                YB.A0H(this.A0g);
            }
        } else {
            YB.A0L(this.A0g);
        }
        YB.A0L(this.A0A);
        Pair<EnumC2019eL, View> pairA03 = this.A0a.A03(this.A0A);
        this.A00 = (View) pairA03.second;
        switch (Z7.A00[((EnumC2019eL) pairA03.first).ordinal()]) {
            case 1:
                RelativeLayout.LayoutParams screenshotParams = new RelativeLayout.LayoutParams(-1, -1);
                screenshotParams.setMargins(0, this.A0g.getToolbarHeight(), 0, 0);
                if (!this.A0I) {
                    YB.A0L(this.A02);
                    screenshotParams.addRule(2, this.A01.getId());
                    addView(this.A00, screenshotParams);
                } else {
                    View c1982dj = new C1982dj(this.A0R, this.A0O.A2C(), this.A0O.A29().A0I(), A09(), this.A0D, new Z5(this));
                    RelativeLayout.LayoutParams screenshotParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.A0O.A2M()) {
                        screenshotParams2.addRule(2, this.A01.getId());
                        if (this.A02 != null) {
                            YB.A0O(this.A02, 8);
                        }
                    }
                    addView(c1982dj, screenshotParams2);
                    View view = this.A0g;
                    String[] strArr3 = A0i;
                    if (strArr3[7].length() == strArr3[4].length()) {
                        A0i[5] = "GuR3tgtU";
                        removeView(view);
                    } else {
                        String[] strArr4 = A0i;
                        strArr4[0] = "xaRPgQ1Vn5AR5k4AW07eBuZz1tirIodN";
                        strArr4[2] = "10QTFu18AzpwL0fCi5Lt2x9tRdyuYXAR";
                        removeView(view);
                    }
                }
                break;
            case 2:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if (this.A0O.A2M()) {
                    layoutParams.addRule(2, this.A01.getId());
                    if (this.A02 != null) {
                        YB.A0O(this.A02, 8);
                    }
                } else {
                    YB.A0d(this.A01);
                }
                addView(this.A00, layoutParams);
                break;
        }
        if (this.A0P.A0c()) {
            this.A0R.A0F().AEP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O() {
        YB.A0W(this);
        if (!this.A0P.A0Y()) {
            this.A0B.A0C();
        }
        this.A0g.setVisibility(0);
        this.A0B.setVisibility(0);
        if (this.A02 != null) {
            RelativeLayout relativeLayout = this.A02;
            String[] strArr = A0i;
            if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
                throw new RuntimeException();
            }
            A0i[3] = "XO2ZpTY6Mgvz2u";
            relativeLayout.setVisibility(0);
        }
        if (this.A0A != null && this.A0O.A25() > 0 && this.A07 == null) {
            this.A07 = new XO(this.A0O.A25(), new C1446Nx(this));
            this.A07.A07();
        }
        this.A0U.A07();
        if (this.A08 != null && this.A0O.A2Q()) {
            C1770aJ c1770aJ = this.A08;
            String[] strArr2 = A0i;
            if (strArr2[0].charAt(6) != strArr2[2].charAt(6)) {
                c1770aJ.A0Q();
            } else {
                A0i[5] = "teHq37vz";
                c1770aJ.A0Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Q(int i) {
        String strValueOf = String.valueOf(i);
        Toast toast = this.A05;
        String strA0J = this.A0P.A0J();
        String progress = A0D(2, 6, 75);
        YB.A0b(toast, strA0J.replace(progress, strValueOf), 49, 0, XV.A0T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0W(boolean z, String str) {
        this.A0H = true;
        HashMap map = new HashMap();
        map.put(A0D(8, 12, 57), z ? A0D(79, 13, 2) : A0D(44, 12, 82));
        map.put(A0D(20, 12, 7), str);
        new C1844bV(this.A0R, this.A0X.A7M(), this.A0B.getViewabilityChecker(), this.A0B.getTouchDataRecorder(), this.A0S, this.A0O.A2A(), this.A0W).A05(this.A0O.A2E(), this.A0O.A29().A0J().A05(), map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0X() {
        return this.A0O.A10().equals(A0D(65, 14, 113)) || (this.A0O.A10().equals(A0D(32, 12, 60)) && this.A0O.A29().A0V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0Y() {
        return this.A0e && !this.A0K && !this.A0M && this.A0P.A0C() < this.A0O.A29().A0H().A03();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AAu(Intent intent, Bundle bundle, C1527Re c1527Re) {
        this.A06 = c1527Re;
        this.A06.A0A(this.A0Q);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFA(boolean z) {
        this.A0U.A06();
        this.A0G = true;
        if (!this.A0F && !z && this.A08 != null) {
            this.A08.A0P();
        }
        this.A0F = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFi(boolean z) {
        if ((!this.A0e || !this.A0M) && !this.A0K) {
            boolean z2 = this.A0c.get();
            String[] strArr = A0i;
            if (strArr[6].charAt(22) == strArr[1].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[0] = "5YF9hd1VnayjDYXn8X9NIXHiJcVpNWhU";
            strArr2[2] = "6mHNY01g6eF3bUPoEn1oonlPgYyDS663";
            if (z2) {
                XO xo = this.A0U;
                String[] strArr3 = A0i;
                if (strArr3[6].charAt(22) != strArr3[1].charAt(22)) {
                    String[] strArr4 = A0i;
                    strArr4[7] = "SY9";
                    strArr4[4] = "T1jNCZgiG5fRSAcWDF";
                    if (xo.A05()) {
                        return;
                    }
                } else {
                    String[] strArr5 = A0i;
                    strArr5[7] = "0UX";
                    strArr5[4] = "cSjXeSxWsZqlnq3791";
                    if (xo.A05()) {
                        return;
                    }
                }
                this.A0U.A07();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AIv(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public String getCurrentClientToken() {
        return this.A0O.A2E();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void onDestroy() {
        this.A0V.A03();
        if (this.A08 != null) {
            this.A08.A0O();
        }
        if (this.A06 != null) {
            this.A06.A0B(this.A0Q);
        }
        if (this.A0B != null) {
            if (!TextUtils.isEmpty(this.A0O.A2E())) {
                this.A0S.AB7(this.A0O.A2E(), new C1822b9().A03(this.A0B.getViewabilityChecker()).A02(this.A0B.getTouchDataRecorder()).A05());
            }
            C2016eI c2016eI = this.A0B;
            String[] strArr = A0i;
            if (strArr[0].charAt(6) != strArr[2].charAt(6)) {
                throw new RuntimeException();
            }
            A0i[3] = "Lk0Kz0u4YEu";
            c2016eI.A0D();
        }
        this.A0U.A06();
        this.A0g.setToolbarListener(null);
        this.A0N.removeCallbacksAndMessages(null);
        this.A05 = null;
        this.A06 = null;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AFi(false);
        } else {
            this.A0F = true;
            AFA(false);
        }
    }

    public void setListener(InterfaceC1706Yh interfaceC1706Yh) {
    }

    public void setServerSideRewardHandler(C2033ea c2033ea) {
        this.A0C = c2033ea;
    }
}
