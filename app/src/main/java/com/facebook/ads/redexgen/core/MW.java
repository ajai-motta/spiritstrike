package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MW extends RelativeLayout implements InterfaceC1707Yi {
    public static byte[] A0V;
    public static String[] A0W = {"K2KQx5j", "I1DdEcIQOKACt5VfynDO8RkkSmVrIdSu", "CrPvtz5bwgp8q96Y41ywgNmdDqzXYyT", "BcZqlHBP86U0O", "mAAXLn1achaKS", "KDsASou", "qHjTnlroNJSmFEFt4pVmvH8neAK9EJVy", "ok9QX18270ZP2OGfEK6N7HjWUQBUEH7u"};
    public static final int A0X;
    public int A00;
    public C1527Re A01;
    public XO A02;
    public C1755a4 A03;
    public C1770aJ A04;
    public C1774aN A05;
    public C1840bR A06;
    public ViewOnClickListenerC1363Kr A07;
    public C2020eM A08;
    public C2026eS A09;
    public C2033ea A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public final Handler A0F;
    public final AbstractC2330jd A0G;
    public final C1437No A0H;
    public final InterfaceC1533Rk A0I;
    public final C2165gi A0J;
    public final VA A0K;
    public final VI A0L;
    public final XO A0M;
    public final ViewOnSystemUiVisibilityChangeListenerC1696Xx A0N;
    public final InterfaceC1706Yh A0O;
    public final ZU A0P;
    public final C2016eI A0Q;
    public final AtomicBoolean A0R;
    public final AtomicBoolean A0S;
    public final boolean A0T;
    public final AbstractC1700Yb A0U;

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0V, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A0V = new byte[]{-81, -72, -75, -81, -73, -85, -69, -66, -75, -77, -75, -70, -99, -90, -93, -99, -91, -103, -83, -87, -81, -84, -99, -97, -7, -20, -1, -12, 1, -16, -22, -18, -9, -12, -18, -10, Ascii.CAN, Ascii.DC4, 9, Ascii.VT, Ascii.CR, Ascii.NAK, Ascii.CR, Ascii.SYN, Ascii.FS, -18, -26, -28, -21, 3, -15, -18, 2, -11, -15, 3, -21, -17, -8, -11, -17, -9};
    }

    static {
        A0P();
        A0X = XV.A03;
    }

    public MW(C2165gi c2165gi, VA va, InterfaceC1706Yh interfaceC1706Yh, AbstractC2330jd abstractC2330jd, C1437No c1437No, String str, ZU zu) {
        super(c2165gi);
        this.A0C = false;
        this.A0B = false;
        this.A0F = new Handler(Looper.getMainLooper());
        this.A0R = new AtomicBoolean(false);
        this.A0D = false;
        this.A0S = new AtomicBoolean(false);
        this.A0I = new C1410Mm(this);
        this.A0J = c2165gi;
        this.A0K = va;
        this.A0O = interfaceC1706Yh;
        this.A0G = abstractC2330jd;
        this.A0H = c1437No;
        this.A0P = zu;
        this.A0L = new VI(this.A0G.A2E(), this.A0K);
        this.A0A = new C2033ea(c2165gi, this.A0P, str, this.A0O);
        C1410Mm c1410Mm = null;
        this.A0M = new XO(this.A0H.A0C(), new C1399Mb(this, c1410Mm));
        this.A0T = this.A0G.A1v();
        setBackgroundColor(-16777216);
        this.A00 = getResources().getConfiguration().orientation;
        this.A0N = new ViewOnSystemUiVisibilityChangeListenerC1696Xx(this);
        this.A0N.A05(EnumC1695Xw.A03);
        C1398Ma c1398Ma = new C1398Ma(this, c1410Mm);
        HashMap map = new HashMap();
        map.put(A09(36, 9, 124), this.A0P.A8l());
        this.A0Q = new C2016eI(this.A0J, this.A0G, this.A0H, this.A0K, c1398Ma, map);
        this.A0U = A04();
        this.A07 = A06();
        this.A0O.A45(this, new RelativeLayout.LayoutParams(-1, -1));
        A0M();
        if (!this.A0H.A0b()) {
            A0b();
        }
    }

    private PU A04() {
        PU pu = new PU(this.A0J, this.A0G, 4);
        pu.setToolbarListener(new InterfaceC1699Ya() { // from class: com.facebook.ads.redexgen.X.NB
            @Override // com.facebook.ads.redexgen.core.InterfaceC1699Ya
            public final void ACl(AbstractC1700Yb abstractC1700Yb) {
                this.A00.A0d(abstractC1700Yb);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(XV.A00, XV.A0N, XV.A00, XV.A00);
        pu.setLayoutParams(layoutParams);
        return pu;
    }

    private ViewOnClickListenerC1363Kr A06() {
        if (this.A0Q != null) {
            C2016eI c2016eI = this.A0Q;
            if (A0W[1].charAt(5) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[5] = "DwrRGPH";
            strArr[0] = "aRDWSvq";
            if (c2016eI.getViewabilityChecker() != null && this.A0Q.getTouchDataRecorder() != null) {
                ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr = new ViewOnClickListenerC1363Kr(this.A0J, this.A0P.A7M(), this.A0G.A28().A01(), this.A0K, this.A0O, this.A0Q.getViewabilityChecker(), this.A0Q.getTouchDataRecorder(), this.A0G.A2A());
                viewOnClickListenerC1363Kr.setCta(this.A0G.A29().A0J(), this.A0G.A2E(), new HashMap(), null);
                viewOnClickListenerC1363Kr.setText(this.A0H.A0M());
                viewOnClickListenerC1363Kr.A0D();
                viewOnClickListenerC1363Kr.setTextSize(13.0f);
                viewOnClickListenerC1363Kr.setPadding(XV.A0D, XV.A00, XV.A0D, XV.A00);
                YB.A0P(viewOnClickListenerC1363Kr, -15902766, A0X);
                viewOnClickListenerC1363Kr.setElevation(0.0f);
                viewOnClickListenerC1363Kr.setStateListAnimator(null);
                viewOnClickListenerC1363Kr.setOutlineProvider(null);
                viewOnClickListenerC1363Kr.setOnClickListener(new ZA(this));
                return viewOnClickListenerC1363Kr;
            }
        }
        return null;
    }

    private void A0C() {
        this.A0U.setToolbarActionMode(2);
        this.A0D = true;
        this.A0L.A04(VH.A0Y, null);
        this.A0J.A0F().AFE();
        if (C1615Up.A1H(this.A0J)) {
            boolean z = this.A0T;
            if (A0W[2].length() == 32) {
                throw new RuntimeException();
            }
            A0W[6] = "k4geMuTXC1h9ucfhhM9HvzcpXwlG9hvy";
            if (z) {
                A0N();
                if (this.A0G.A29().A0S()) {
                    this.A0A.A06();
                    this.A0O.A4k(this.A0P.A6l(), new C4K(0, 0));
                }
            }
        }
        A0V(false, A09(45, 4, 79));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A0E = true;
        if (this.A0G.A29().A0S()) {
            this.A0A.A06();
            this.A0O.A4k(this.A0P.A6l(), new C4K(0, 0));
        }
    }

    private void A0E() {
        if (this.A03 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        layoutParams.setMargins(XV.A00, XV.A00, XV.A0F, XV.A00);
        this.A03.setLayoutParams(layoutParams);
    }

    private void A0F() {
        if (this.A04 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        layoutParams.setMargins(XV.A00, XV.A00, XV.A09, XV.A09);
        this.A04.setLayoutParams(layoutParams);
    }

    private void A0G() {
        if (this.A05 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(20);
            layoutParams.addRule(12);
            layoutParams.setMargins(XV.A09, XV.A00, XV.A00, XV.A09);
            this.A05.setLayoutParams(layoutParams);
        }
    }

    private void A0H() {
        this.A03 = new C1755a4(this.A0J, this.A0G, null, this.A0O);
        A0E();
        addView(this.A03);
    }

    private void A0I() {
        if (this.A0G.A2W()) {
            A0L();
        }
        if (this.A0G.A2M()) {
            A0K();
        } else {
            A0H();
        }
    }

    private void A0J() {
        if (this.A07 == null) {
            return;
        }
        setClipChildren(false);
        this.A06 = new C1840bR(this.A0J, this.A0G, this.A07, this.A0H.A0B(), this.A0H.A0Z());
        A0Q(this.A00);
        addView(this.A06);
    }

    private void A0K() {
        this.A04 = AbstractC1775aO.A01(this.A0J, false, this.A0G, this.A0L, this.A0O, EnumC1773aM.A03, AbstractC1772aL.A00(this.A0G));
        A0F();
        addView(this.A04);
    }

    private void A0L() {
        this.A05 = AbstractC1775aO.A02(this.A0J, EnumC1773aM.A03, this.A0G);
        this.A05.setBackgroundColor(-2145637581);
        A0G();
        addView(this.A05);
    }

    private void A0M() {
        this.A0U.setVisibility(4);
        YB.A0K(this.A0U);
        this.A0Q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        A0R(this.A00);
        addView(this.A0Q);
        addView(this.A0U);
        if (this.A0H.A0a()) {
            A0J();
        }
        A0I();
        if (!this.A0H.A0Y()) {
            boolean zA0b = this.A0H.A0b();
            if (A0W[1].charAt(5) != 'c') {
                throw new RuntimeException();
            }
            A0W[7] = "XlBnGmRHSm8FPKQHD6bIB4zK3mUoDq5y";
            if (!zA0b) {
                this.A0Q.setVisibility(4);
                return;
            }
        }
        setVisibility(4);
        this.A0Q.A0C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N() {
        if (this.A0G.A2M() && this.A04 != null) {
            this.A04.A0P();
            if (this.A0G.A2U()) {
                AbstractC1772aL.A04(this.A0J, EnumC1773aM.A02);
            } else {
                AbstractC1772aL.A05(this.A0J, EnumC1773aM.A02);
            }
        }
        if (this.A0G.A2W() && this.A05 != null) {
            AbstractC1772aL.A06(this.A0J, EnumC1773aM.A02);
        }
        this.A0L.A04(VH.A0z, null);
        if (this.A07 != null) {
            this.A07.setText(this.A0G.A29().A0J().A04());
        }
        if (!this.A0G.A29().A0K().A02().isEmpty()) {
            this.A09 = new C2026eS(this.A0J, this.A0G, this.A0O, this.A07, this.A0F, this.A0L);
            addView(this.A09.A0W(), new RelativeLayout.LayoutParams(-1, -1));
            YB.A0d(this.A0U);
        } else {
            this.A08 = new C2020eM(this.A0J, this.A0K, this.A0G);
            Pair<EnumC2019eL, View> pairA03 = this.A08.A03(this.A07);
            AbstractC1866br.A00(this.A0J, this, this.A0G.A29().A0H().A08());
            addView((View) pairA03.second, new RelativeLayout.LayoutParams(-1, -1));
            long jA00 = this.A0G.A29().A0K().A00();
            if (jA00 > 0) {
                this.A0F.postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.Z9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A00.A0c();
                    }
                }, jA00);
            } else {
                AbstractC1700Yb abstractC1700Yb = this.A0U;
                String[] strArr = A0W;
                if (strArr[5].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                A0W[3] = "dsmu";
                abstractC1700Yb.setToolbarActionMode(0);
            }
        }
        YB.A0d(this.A0Q);
        this.A0R.set(true);
    }

    private void A0O() {
        final C1994dw c1994dw = new C1994dw(this.A0J, this.A0G);
        addView(c1994dw, new RelativeLayout.LayoutParams(-1, -1));
        this.A0F.postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.Z8
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0e(c1994dw);
            }
        }, this.A0H.A0D());
    }

    private void A0Q(int i) {
        if (this.A06 == null) {
            return;
        }
        this.A06.A0I(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 2) {
            int i2 = XV.A00;
            if (A0W[4].length() == 25) {
                throw new RuntimeException();
            }
            A0W[2] = "3KWOojhtbTrcKNejqW7";
            layoutParams.setMargins(i2, XV.A00, XV.A00, XV.A05);
        } else {
            layoutParams.setMargins(XV.A00, XV.A00, XV.A00, XV.A0N);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.A06.setLayoutParams(layoutParams);
    }

    private void A0R(int i) {
        if (i == 2) {
            this.A0Q.setPadding(XV.A01, XV.A01, XV.A01, XV.A01);
            return;
        }
        C2016eI c2016eI = this.A0Q;
        int i2 = XV.A00;
        if (A0W[7].charAt(28) == 'Z') {
            throw new RuntimeException();
        }
        A0W[3] = "dtYS90IKRfB1L";
        c2016eI.setPadding(i2, XV.A00, XV.A00, XV.A00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0V(boolean z, String str) {
        this.A0C = true;
        HashMap map = new HashMap();
        map.put(A09(0, 12, 32), z ? A09(49, 13, 96) : A09(24, 12, 95));
        map.put(A09(12, 12, 14), str);
        new C1844bV(this.A0J, this.A0P.A7M(), this.A0Q.getViewabilityChecker(), this.A0Q.getTouchDataRecorder(), this.A0K, this.A0G.A2A(), this.A0O).A05(this.A0G.A2E(), this.A0G.A29().A0J().A05(), map);
    }

    public final void A0b() {
        if (this.A0H.A0Y() || this.A0H.A0b()) {
            setVisibility(0);
            this.A0Q.A0E(0);
            AFi(false);
            if (this.A0S.get()) {
                A0N();
            }
        } else {
            this.A0Q.A0C();
            this.A0Q.setVisibility(0);
            this.A0M.A07();
        }
        if (this.A0H.A0W()) {
            A0O();
        }
        if (this.A06 != null) {
            this.A06.A0E();
        }
        this.A0U.setVisibility(0);
        if (this.A07 != null && this.A0G.A25() > 0 && this.A02 == null) {
            this.A02 = new XO(this.A0G.A25(), new C1400Mc(this));
            this.A02.A07();
        }
    }

    public final /* synthetic */ void A0c() {
        this.A0U.setToolbarActionMode(0);
    }

    public final /* synthetic */ void A0d(AbstractC1700Yb abstractC1700Yb) {
        if (this.A0H.A0A() > 0 && abstractC1700Yb.getToolbarActionMode() == 8) {
            A0C();
            return;
        }
        if (abstractC1700Yb.getToolbarActionMode() != 0 && this.A0H.A0V() && !this.A0R.get()) {
            abstractC1700Yb.setToolbarActionMode(2);
            A0N();
        } else {
            this.A0L.A04(VH.A07, null);
            this.A0J.A0F().AB0();
            this.A0O.A4j(this.A0P.A7w());
        }
    }

    public final /* synthetic */ void A0e(C1994dw c1994dw) {
        removeView(c1994dw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AAu(Intent intent, Bundle bundle, C1527Re c1527Re) {
        this.A01 = c1527Re;
        c1527Re.A0A(this.A0I);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFA(boolean z) {
        this.A0M.A06();
        this.A0B = true;
        if (this.A06 != null) {
            this.A06.A0G();
        }
        if (this.A04 != null) {
            this.A04.A0P();
        } else {
            if (this.A03 == null) {
                return;
            }
            this.A03.A05();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFi(boolean z) {
        this.A0M.A07();
        if (this.A06 != null) {
            this.A06.A0H();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AIv(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public String getCurrentClientToken() {
        return A09(0, 0, 117);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == 945321098 && this.A0D && !this.A0R.get()) {
            this.A0L.A04(VH.A07, null);
            this.A0O.A4j(this.A0P.A7w());
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0R(configuration.orientation);
        A0Q(configuration.orientation);
        if (this.A09 != null) {
            this.A09.A0a(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void onDestroy() {
        this.A0N.A03();
        if (this.A01 != null) {
            this.A01.A0B(this.A0I);
        }
        if (this.A06 != null) {
            this.A06.A0F();
        }
        if (this.A0Q != null) {
            if (!TextUtils.isEmpty(this.A0G.A2E())) {
                this.A0K.AB7(this.A0G.A2E(), new C1822b9().A03(this.A0Q.getViewabilityChecker()).A02(this.A0Q.getTouchDataRecorder()).A05());
            }
            this.A0Q.A0D();
        }
        if (this.A04 != null) {
            this.A04.A0O();
        } else if (this.A03 != null) {
            this.A03.A04();
        }
        this.A0M.A06();
        AbstractC1700Yb abstractC1700Yb = this.A0U;
        if (A0W[1].charAt(5) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[5] = "SgQ0Vce";
        strArr[0] = "JIQdJaY";
        abstractC1700Yb.setToolbarListener(null);
        this.A0F.removeCallbacksAndMessages(null);
    }

    public void setListener(InterfaceC1706Yh interfaceC1706Yh) {
    }
}
