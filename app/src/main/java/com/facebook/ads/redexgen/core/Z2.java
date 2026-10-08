package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Z2 extends FrameLayout {
    public static byte[] A0D;
    public static String[] A0E = {"EYRP1PEEhxzmFZofVXiCCrEXWQs6qPAa", "IPRTBS", "NsAYUXCCkxBbK0XyUhCt1xHChz5fZfMK", "fEJJ0", "6651Qynk9CVpAvzNTMvYSQKVDYa6iazW", "nD7S5n7VHEDKGeK1PzI1a27Vk58dSaaa", "vFV0GS7SjmRPmH7mLZ5yrXn6gSrRknN8", "LPfldR2r"};
    public static final int A0F;
    public boolean A00;
    public final C2335ji A01;
    public final AbstractC2330jd A02;
    public final C2165gi A03;
    public final VA A04;
    public final VI A05;
    public final Y2 A06;
    public final C1471Ow A07;
    public final AbstractC1465Oq A08;
    public final AbstractC2109fo A09;
    public final C2110fp A0A;
    public final String A0B;
    public final WeakReference<Z1> A0C;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public Z2(C2165gi c2165gi, VA va, C1571Sx c1571Sx, WeakReference<Z1> weakReference, int i, int i2, int i3, int i4, C2335ji c2335ji, String str) {
        super(c2165gi);
        this.A06 = new Y2();
        this.A03 = c2165gi;
        this.A04 = va;
        this.A01 = c2335ji;
        this.A0C = weakReference;
        this.A0B = str;
        AbstractC2330jd abstractC2330jdA0F = this.A01.A0F();
        if (abstractC2330jdA0F == null) {
            throw new IllegalStateException(A09(0, 32, 86));
        }
        this.A02 = this.A01.A0F();
        YB.A0N(this, -1);
        this.A05 = new VI(this.A01.A7O(), this.A04);
        this.A09 = A06();
        this.A0A = A07(i, i4, i2, i3);
        LinearLayout linearLayout = new LinearLayout(c2165gi);
        linearLayout.setOrientation(1);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        this.A08 = A04(c1571Sx);
        if (this.A08 != null) {
            linearLayout.addView(this.A08, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        this.A07 = A02(abstractC2330jdA0F);
        linearLayout.addView(this.A07, new LinearLayout.LayoutParams(-1, -2));
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
            if (A0E[6].charAt(17) == 'I') {
                throw new RuntimeException();
            }
            A0E[6] = "HyV3wef6DGt1nbLL1fRSvAmBe6VeBas4";
            bArrCopyOfRange[i4] = b;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0F() {
        A0D = new byte[]{-6, Ascii.GS, -39, Ascii.GS, Ascii.SUB, 45, Ascii.SUB, -39, Ascii.ESC, 46, 39, Ascii.GS, 37, Ascii.RS, -39, 34, 44, -39, Ascii.FS, Ascii.SUB, 39, 39, 40, 45, -39, Ascii.ESC, Ascii.RS, -39, 39, 46, 37, 37, 52, SignedBytes.MAX_POWER_OF_TWO, 62, -1, 55, 50, 52, 54, 51, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 60, -1, 50, 53, 68, -1, 51, 50, 63, 63, 54, 67, -1, 52, Base64.padSymbol, 58, 52, 60, 54, 53};
    }

    static {
        A0F();
        A0F = (int) (XX.A02 * 40.0f);
    }

    private C1471Ow A02(AbstractC2330jd abstractC2330jd) {
        C1423Na c1423NaA00;
        NR nrA29 = abstractC2330jd.A29();
        PW pw = new PW() { // from class: com.facebook.ads.redexgen.X.6f
            public static byte[] A01;
            public static String[] A02 = {"69whQSJFXzC5tMS1mvBQof2SK7ErE5ZD", "1jHEgafKgZ1qGtZeFln5jYEaZuoTSi1L", "X7dL0uEA8hI8yFDxVjmpGWGPGaRf3imC", "xkNxR1N5ht6u5HrBYV6Jaj9BRbbqvvjX", "FzWiIV8jsRMCATg74qRy8XJg", "NPgeBhkCK5cdUCtVbQG3V7Bzbyz9qF6p", "wkBgnizDM2wMuU", "fQJYdDBiu8hI0YoMzyDMv7ESaoH1tCRU"};

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                int i4 = 0;
                while (true) {
                    int length = bArrCopyOfRange.length;
                    String[] strArr = A02;
                    if (strArr[5].charAt(30) == strArr[3].charAt(30)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[5] = "zFlqgUHcpRBmVFunDUsFQIo1zDN3Ly6W";
                    strArr2[3] = "vgtBZdmtnd3XTM9GsG6r3isUaM0HNLHl";
                    if (i4 >= length) {
                        return new String(bArrCopyOfRange);
                    }
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 4);
                    i4++;
                }
            }

            public static void A01() {
                A01 = new byte[]{-102};
            }

            static {
                A01();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC1706Yh
            public final void A4j(String str) {
                P2.A00(this.A00.A03).A07(new Intent(str + A00(0, 1, 92) + this.A00.A0B));
            }
        };
        if (getOrientation() == 1) {
            c1423NaA00 = abstractC2330jd.A28().A01();
        } else {
            NN nnA28 = abstractC2330jd.A28();
            String[] strArr = A0E;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0E[7] = "bY8FFe1Y";
            c1423NaA00 = nnA28.A00();
        }
        C1471Ow c1471Ow = new C1471Ow(this.A03, A0F, c1423NaA00, nrA29.A0J().A06(), A09(32, 31, 110), this.A04, pw, this.A0A, this.A06, abstractC2330jd.A2A());
        c1471Ow.setInfo(nrA29.A0I(), nrA29.A0J(), this.A01.A7O(), abstractC2330jd.A2C().A01(), null, null);
        if (C1615Up.A1N(this.A03)) {
            c1471Ow.A0k();
        }
        return c1471Ow;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.6q] */
    private AbstractC1465Oq A04(C1571Sx c1571Sx) {
        final ViewOnClickListenerC1724Yz viewOnClickListenerC1724Yz = new ViewOnClickListenerC1724Yz(this);
        String videoUrl = this.A01.A0e();
        if (A0H(c1571Sx, this.A01) && videoUrl != null) {
            C10096g videoView = new C10096g(this.A03, this.A04, c1571Sx, this.A05, viewOnClickListenerC1724Yz, this.A02).A0I(this.A01.A7O(), videoUrl, this.A01.A0H() != null ? this.A01.A0H().getUrl() : null, this.A01.A0R(), this.A01.A0Q());
            if (C1615Up.A1R(this.A03)) {
                setViewAsCTA(videoView);
            }
            return videoView;
        }
        C1627Vb c1627VbA0H = this.A01.A0H();
        if (c1627VbA0H == null) {
            return null;
        }
        final C2165gi c2165gi = this.A03;
        final VI vi = this.A05;
        final AbstractC2330jd abstractC2330jd = this.A02;
        C10196q c10196qA0I = new AbstractC1465Oq(c2165gi, viewOnClickListenerC1724Yz, vi, abstractC2330jd) { // from class: com.facebook.ads.redexgen.X.6q
            public final C1818b5 A00;

            {
                super(c2165gi, viewOnClickListenerC1724Yz, vi, abstractC2330jd);
                this.A00 = new C1818b5(c2165gi);
                addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC1465Oq
            public final void A0E() {
                super.A0E();
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC1465Oq
            public final void A0F() {
                super.A0F();
                if (this.A04 != null) {
                    YB.A0J(this.A04);
                    this.A04.setLayoutParams(AbstractC1465Oq.A0A(null));
                    addView(this.A04);
                }
            }

            public final C10196q A0I(String str) {
                new LM(this.A00, this.A08).A05(this.A00.getHeight(), this.A00.getWidth()).A06(new C1466Or(this)).A07(str);
                A0F();
                return this;
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC1465Oq
            public int getMediaViewId() {
                return this.A00.getId();
            }
        }.A0I(c1627VbA0H.getUrl());
        if (C1615Up.A1P(this.A03)) {
            setViewAsCTA(c10196qA0I);
        }
        return c10196qA0I;
    }

    private C1450Ob A06() {
        return new C1450Ob(this);
    }

    private C2110fp A07(int i, int i2, int i3, int i4) {
        C2110fp c2110fp = new C2110fp(this, i, i2, true, new WeakReference(this.A09), this.A03);
        c2110fp.A0W(i3);
        c2110fp.A0X(i4);
        return c2110fp;
    }

    private void A0C() {
        String strA0M = this.A01.A0M();
        if (!TextUtils.isEmpty(strA0M)) {
            X6 x6 = new X6();
            C2165gi c2165gi = this.A03;
            Uri uriA00 = XB.A00(strA0M);
            String adChoicesLinkUrl = this.A01.A7O();
            X6.A0O(x6, c2165gi, uriA00, adChoicesLinkUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A05.A04(VH.A0A, null);
        if (!AbstractC1456Oh.A00(this.A03.A02()).A0O(this.A03, false)) {
            A0C();
            return;
        }
        AbstractC1728Zd abstractC1728ZdA01 = AbstractC1729Ze.A01(this.A03, this.A04, this.A01.A7O(), this);
        if (abstractC1728ZdA01 == null) {
            A0C();
            return;
        }
        YB.A0W(this);
        addView(abstractC1728ZdA01, new FrameLayout.LayoutParams(-1, -1));
        abstractC1728ZdA01.A0N();
    }

    private void A0E() {
        if (getVisibility() == 0 && this.A00 && hasWindowFocus()) {
            this.A0A.A0U();
        } else {
            this.A0A.A0V();
        }
    }

    public static boolean A0H(C1571Sx c1571Sx, C2335ji c2335ji) {
        String strA0e = c2335ji.A0e();
        if (TextUtils.isEmpty(strA0e)) {
            return false;
        }
        String videoUrl = c1571Sx.A0T(strA0e);
        return !TextUtils.isEmpty(videoUrl);
    }

    public final void A0I() {
        if (this.A08 != null) {
            this.A08.A0D();
        }
        if (this.A0A != null) {
            this.A0A.A0V();
        }
        YB.A0J(this);
    }

    public final void A0J() {
        if (this.A08 != null) {
            AbstractC1465Oq abstractC1465Oq = this.A08;
            if (A0E[2].charAt(13) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[0] = "hgkEcT5pEsAUKYMkvVnojxGMD5WCOUSh";
            strArr[5] = "qBRuzdoZQfMYUt1SZmDdshQz8Ndd8EXP";
            abstractC1465Oq.A0E();
        }
    }

    private int getOrientation() {
        Activity activity = this.A03.A0E();
        if (activity != null) {
            return activity.getResources().getConfiguration().orientation;
        }
        return 1;
    }

    public C2110fp getViewabilityChecker() {
        return this.A0A;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A00 = true;
        A0E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00 = false;
        A0E();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A06.A06(this.A03, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        A0E();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A0E();
    }

    private void setViewAsCTA(View view) {
        view.setOnClickListener(new Z0(this));
    }
}
