package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ge, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1247Ge extends FrameLayout implements InterfaceC1707Yi {
    public static byte[] A0L;
    public static String[] A0M = {"2u2dP7fJh3RTJE0f5j", "V84xfC9vRBWBw28ag3Wa", "AJ9OWsf0IOCB9JkMwpi03POlIdxFWB0O", "t4KHUJW6pNylT", "agpCzVGtSfjd9ImL9ArnGOWeGltiI7KT", "yQxi0n265GvpKMbNVeZVKXQg4YYx4N", "9gQlnw56", "rIoCFSW2UJYE3I7OlTOsSCWVSaoSra"};
    public static final RelativeLayout.LayoutParams A0N;
    public int A00;
    public int A01;
    public int A02;
    public C1847bY A03;
    public AbstractC1304Ij A04;
    public C2033ea A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C2324jT A0A;
    public final InterfaceC1533Rk A0B;
    public final C1571Sx A0C;
    public final C2165gi A0D;
    public final VA A0E;
    public final VI A0F;
    public final ViewOnSystemUiVisibilityChangeListenerC1696Xx A0G;
    public final AbstractC1700Yb A0H;
    public final InterfaceC1706Yh A0I;
    public final ZU A0J;
    public final ArrayList<C1983dk> A0K;

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 100);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0I() {
        A0L = new byte[]{-103, -24, -33, -103, -1, 34, -34};
    }

    static {
        A0I();
        A0N = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C1247Ge(C2165gi c2165gi, ZU zu, VA va, C2324jT c2324jT, C1571Sx c1571Sx, InterfaceC1706Yh interfaceC1706Yh) {
        FrameLayout.LayoutParams layoutParams;
        super(c2165gi);
        this.A0K = new ArrayList<>();
        this.A09 = false;
        this.A07 = false;
        this.A08 = false;
        this.A06 = true;
        this.A02 = 1;
        this.A00 = 0;
        this.A01 = 0;
        this.A0B = new C1251Gi(this);
        this.A0D = c2165gi;
        this.A0J = zu;
        this.A0E = va;
        this.A0A = c2324jT;
        this.A0C = c1571Sx;
        this.A0I = interfaceC1706Yh;
        this.A0F = new VI(this.A0A.A27(0).A2E(), this.A0E);
        this.A0G = new ViewOnSystemUiVisibilityChangeListenerC1696Xx(this);
        this.A0G.A05(EnumC1695Xw.A02);
        this.A05 = new C2033ea(this.A0D, this.A0J, this.A0A.A1G(), interfaceC1706Yh);
        this.A0H = A07();
        if (this.A0A.A1c()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(XV.A0u, XV.A0r, 0, 0);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, this.A0H.getToolbarHeight());
        }
        addView(this.A0H, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bf, code lost:
    
        if (r4.A1L() != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c1, code lost:
    
        r6.A0H.setToolbarActionMode(0);
        r6.A0D.A0F().A4x();
        r6.A04.A1G();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e6, code lost:
    
        if (r4.A1L() != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00() {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1247Ge.A00():int");
    }

    private int A01(int i) {
        if (this.A0A.A2I()) {
            C2324jT c2324jT = this.A0A;
            String[] strArr = A0M;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[5] = "SFVCTE3Hv2F6eV4jkYzgVN3BuZvLlt";
            strArr2[7] = "be2ILDbetBMqGPrAeiZBpkZxeTc1wp";
            if (i < c2324jT.A2B().size() && i >= 0) {
                return this.A0A.A2B().get(i).intValue();
            }
        }
        return this.A0A.A0p();
    }

    public static /* synthetic */ int A03(C1247Ge c1247Ge, int i) {
        int i2 = c1247Ge.A01 + i;
        c1247Ge.A01 = i2;
        return i2;
    }

    private AbstractC1700Yb A07() {
        AbstractC1700Yb pu;
        if (!this.A0A.A1c()) {
            pu = new FullScreenAdToolbar(this.A0D, this.A0I, this.A0F, 2, -1, false);
        } else {
            pu = new PU(this.A0D, this.A0A.A27(this.A00), 2);
        }
        pu.setFullscreen(true);
        pu.setToolbarListener(new C1248Gf(this));
        return pu;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.core.AbstractC1304Ij A0C(boolean r33, int r34) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1247Ge.A0C(boolean, int):com.facebook.ads.redexgen.X.Ij");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E() {
        int iA00 = A00();
        if (iA00 != 0) {
            this.A0D.A0F().A4y(iA00);
        }
    }

    private void A0F() {
        if (this.A00 > 0 && !TextUtils.isEmpty(this.A0A.A27(this.A00 - 1).A2E())) {
            VA va = this.A0E;
            String strA2E = this.A0A.A27(this.A00 - 1).A2E();
            C1822b9 c1822b9A03 = new C1822b9().A03(this.A04 != null ? this.A04.getAdViewabilityChecker() : null);
            AbstractC1304Ij abstractC1304Ij = this.A04;
            String[] strArr = A0M;
            if (strArr[6].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[2] = "pDlFeLBfyToKKboIUgGc0hC9I32LVeJD";
            strArr2[4] = "3B6yIVnUpbF0PBycHqRFA1bh2UEjPzxQ";
            va.AB7(strA2E, c1822b9A03.A02(abstractC1304Ij != null ? this.A04.getTouchDataRecorder() : null).A05());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G() {
        if (this.A0H.getToolbarActionMode() == 8) {
            AbstractC1700Yb abstractC1700Yb = this.A0H;
            String[] strArr = A0M;
            if (strArr[2].charAt(19) == strArr[4].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[2] = "ALooRHp0AOPErSNB2N5ax0GYeQeSWGkg";
            strArr2[4] = "Jojrpwo5bfgl2L1NDhbRQaPRUafbLI0W";
            abstractC1700Yb.setToolbarActionMode(2);
        }
        int i = this.A00 - 1;
        if (this.A0A.A2J(i)) {
            AbstractC2330jd abstractC2330jdA27 = this.A0A.A27(i);
            AbstractC1700Yb abstractC1700Yb2 = this.A0H;
            String[] strArr3 = A0M;
            String str = strArr3[2];
            String str2 = strArr3[4];
            int iCharAt = str.charAt(19);
            int index = str2.charAt(19);
            if (iCharAt == index) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0M;
            strArr4[0] = "SYmrADrPyc9xENaNAh";
            strArr4[1] = "82lRVJ32R9K27GgHKLOx";
            abstractC1700Yb2.setProgressSpinnerInvisible(!abstractC2330jdA27.A2S());
            abstractC2330jdA27.A2K(false);
            abstractC2330jdA27.A29().A0M(-1);
        }
    }

    private void A0H() {
        this.A0D.A0F().A4w();
        this.A07 = true;
        this.A03 = new C1847bY(this.A0D, this.A0A, this.A0E, this.A0I, this.A0H.getToolbarHeight(), this.A02);
        C1983dk c1983dk = null;
        Iterator<C1983dk> it = this.A0K.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1983dk next = it.next();
            if (next.A00 == C1983dk.A06) {
                c1983dk = next;
                break;
            }
        }
        if (c1983dk != null) {
            A0N(this.A03, c1983dk);
        } else {
            boolean zIsEmpty = this.A0K.isEmpty();
            String[] strArr = A0M;
            if (strArr[5].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[5] = "8vyvfMLKM55zirtuKFzVGEL0IOO7sZ";
            strArr2[7] = "ODibu6eYSRbNQzGgUnvrLUj83p1fS4";
            if (!zIsEmpty) {
                A0N(this.A03, this.A0K.get(0));
            }
        }
        A0W(true);
        if (this.A0H instanceof FullScreenAdToolbar) {
            ((FullScreenAdToolbar) this.A0H).setOnlyPageDetails(null);
        }
        if (this.A04 != null) {
            YB.A0J(this.A04);
            this.A04.A1E();
            this.A04 = null;
        }
        YB.A0J(this.A03);
        YB.A0G(1102, this.A03);
        addView(this.A03, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    private final void A0J() {
        this.A0G.A05(EnumC1695Xw.A03);
    }

    private synchronized void A0K() {
        this.A0I.A4j(this.A0J.A6l());
        this.A05.A06();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(float f) {
        float seenCurrentPosMS;
        float fA01 = A01(this.A00 - 1);
        float seenCurrentPosMS2 = (this.A0A.A2I() ? 0 : this.A01) + f;
        if (fA01 > 0.0f) {
            seenCurrentPosMS = seenCurrentPosMS2 / fA01;
        } else {
            seenCurrentPosMS = 1.0f;
        }
        if (this.A06 && this.A0A.A2I()) {
            this.A06 = false;
            this.A0H.setProgressImmediate(0.0f);
        }
        float unskippableSeconds = 100.0f * seenCurrentPosMS;
        this.A0H.setProgress(unskippableSeconds);
        if (seenCurrentPosMS >= 1.0f && !this.A09) {
            setUnskippableSecondsComplete(true);
            this.A0H.setToolbarActionMode(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M(int i) {
        this.A0D.A0F().A4t(i);
        setUnskippableSecondsComplete(true);
        A0K();
        A0F();
        this.A0D.A0F().AB0();
        this.A0I.A4j(this.A0J.A7w());
    }

    private void A0N(ViewGroup viewGroup, C1983dk c1983dk) {
        if (c1983dk.A00 == C1983dk.A06 && c1983dk.A03 != null) {
            AbstractC1866br.A00(this.A0D, viewGroup, c1983dk.A03);
        } else {
            int i = c1983dk.A01;
            String[] strArr = A0M;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[5] = "6Qw2GncBlIK9qwoUetngT0jkAnHCQL";
            strArr2[7] = "iVxLMdIUnWJTFKOlNtOcmcGRsmSn6x";
            YB.A0N(viewGroup, i);
        }
        this.A0H.setFullscreen(c1983dk.A05);
        this.A0H.A0D(c1983dk.A02, c1983dk.A04);
    }

    private void A0O(AbstractC2330jd abstractC2330jd) {
        if (this.A0H instanceof FullScreenAdToolbar) {
            if (A0b(abstractC2330jd) && this.A02 == 2) {
                ((FullScreenAdToolbar) this.A0H).setOnlyPageDetails(abstractC2330jd.A2C());
            } else {
                ((FullScreenAdToolbar) this.A0H).setOnlyPageDetails(null);
            }
        }
    }

    private final void A0P(C1527Re c1527Re) {
        c1527Re.A0A(this.A0B);
        int i = c1527Re.A05().getResources().getConfiguration().orientation;
        this.A02 = i;
        A0X(this.A0A.A2D(), i);
        A0J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0W(boolean r7) {
        /*
            r6 = this;
            boolean r0 = r6.A0Z()
            r4 = 0
            r3 = 1
            if (r0 == 0) goto La5
            boolean r0 = r6.A0Y()
            if (r0 != 0) goto La5
            boolean r5 = r6.A0a()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            r0 = 0
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto Lad
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            java.lang.String r1 = "abX2oERzf98UggHhJlwc5xOu8ehA434Q"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "mcfqurarHSiAo6r6yfyhrMyo3UPU5OrE"
            r0 = 4
            r2[r0] = r1
            if (r5 != 0) goto La5
            r1 = 1
        L33:
            boolean r0 = r6.A0Y()
            if (r0 != 0) goto L71
            if (r1 != 0) goto L71
            r6.setUnskippableSecondsComplete(r3)
            if (r7 == 0) goto L4d
            com.facebook.ads.redexgen.X.Yb r3 = r6.A0H
            r2 = 0
            r1 = 0
            r0 = 85
            java.lang.String r0 = A0D(r2, r1, r0)
            r3.setToolbarActionMessage(r0)
        L4d:
            com.facebook.ads.redexgen.X.Yb r3 = r6.A0H
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto La7
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            java.lang.String r1 = "6hDdRvQvhZI2wvmWyf"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "dfELTL2TgrvtcbRt37j2"
            r0 = 1
            r2[r0] = r1
            r3.setToolbarActionMode(r4)
        L70:
            return
        L71:
            com.facebook.ads.redexgen.X.Yb r4 = r6.A0H
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            r0 = 0
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L95
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            java.lang.String r1 = "JMDiVFyp4yY8WixxdBAiYWzIdfNljSYZ"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "DEcXsd0kn675y00aYcKTg0COR2JcG3d3"
            r0 = 4
            r2[r0] = r1
            r4.setToolbarActionMode(r3)
            goto L70
        L95:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1247Ge.A0M
            java.lang.String r1 = "uCb48oA3"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "eCwSqnipc7icS"
            r0 = 3
            r2[r0] = r1
            r4.setToolbarActionMode(r3)
            goto L70
        La5:
            r1 = 0
            goto L33
        La7:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        Lad:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1247Ge.A0W(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0X(boolean z, int i) {
        if (this.A04 != null) {
            this.A04.A1E();
            this.A04.removeAllViews();
            YB.A0J(this.A04);
        }
        if (this.A0A.A1c()) {
            YB.A0J(this.A0H);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(XV.A0u, XV.A0r, 0, 0);
            addView(this.A0H, layoutParams);
        }
        if (!A0Y()) {
            setUnskippableSecondsComplete(true);
            if (A0Z()) {
                A0H();
                return;
            }
            A0M(1);
            String[] strArr = A0M;
            if (strArr[6].length() != strArr[3].length()) {
                String[] strArr2 = A0M;
                strArr2[5] = "b6hirdpqFqEpTGRF7TvzfLNB23PEQW";
                strArr2[7] = "Y5Eb3FssofDa3ImZpKtnPvm2BrdUNN";
                return;
            }
        } else {
            if (this.A0A.A2I()) {
                setUnskippableSecondsComplete(false);
                this.A0H.setProgressImmediate(0.0f);
            }
            T1 t1A01 = this.A0D.A01();
            AbstractC2330jd abstractC2330jdA27 = this.A0A.A27(this.A00);
            String[] strArr3 = A0M;
            if (strArr3[6].length() != strArr3[3].length()) {
                String[] strArr4 = A0M;
                strArr4[0] = "SeXhCWKDArfU2xbUHE";
                strArr4[1] = "icHjaKCGoPIgSTYVXjnx";
                boolean isLoaded = t1A01.AAM(abstractC2330jdA27.A2E(), this.A0A.A28());
                if (!isLoaded) {
                    this.A0D.A0F().A4u();
                    A0M(2);
                    return;
                }
                AbstractC1304Ij abstractC1304IjA0C = A0C(z, i);
                this.A04 = abstractC1304IjA0C;
                AbstractC1304Ij abstractC1304Ij = this.A04;
                boolean isLoaded2 = this.A09;
                abstractC1304Ij.A1I(isLoaded2);
                setupToolbarForAd(abstractC1304IjA0C);
                addView(this.A04, 0, A0N);
                this.A00++;
                this.A04.A1H();
                return;
            }
        }
        throw new RuntimeException();
    }

    private boolean A0Y() {
        return this.A00 < this.A0A.A23();
    }

    private boolean A0Z() {
        return this.A0A.A22() == 2;
    }

    private final boolean A0a() {
        return this.A07;
    }

    public static boolean A0b(AbstractC2330jd abstractC2330jd) {
        return TextUtils.isEmpty(abstractC2330jd.A29().A0H().A09());
    }

    public final void A0d() {
        A0X(false, this.A02);
    }

    public final boolean A0e() {
        boolean z = this.A00 < this.A0A.A23() && this.A0A.A2G();
        if (z) {
            this.A0D.A0F().AC1();
        }
        return z;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AAu(Intent intent, Bundle bundle, C1527Re c1527Re) {
        this.A0I.A45(this, A0N);
        A0P(c1527Re);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFA(boolean z) {
        if (this.A04 != null) {
            this.A04.A1J(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AFi(boolean z) {
        if (this.A04 != null) {
            this.A04.A1K(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void AIv(Bundle bundle) {
    }

    public AbstractC1304Ij getContentView() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public String getCurrentClientToken() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.A02 = configuration.orientation;
        if (this.A04 != null) {
            this.A04.onConfigurationChanged(configuration);
        }
        if (this.A04 instanceof C09845h) {
            A0N(this.A04, this.A04.getFullScreenAdStyle());
            A0O(this.A04.getAdDataBundle());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1707Yi
    public final void onDestroy() {
        if (this.A04 != null) {
            this.A04.A1E();
            this.A04 = null;
        }
        this.A0D.A01().A4z(this.A0A.A28());
        this.A0G.A03();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(InterfaceC1706Yh interfaceC1706Yh) {
    }

    public void setServerSideRewardHandler(C2033ea c2033ea) {
        this.A05 = c2033ea;
    }

    public void setUnskippableSecondsComplete(boolean z) {
        this.A09 = z;
        if (this.A04 != null) {
            this.A04.A1I(this.A09);
        }
    }

    private void setupToolbarForAd(AbstractC1304Ij abstractC1304Ij) {
        if (this.A0H == null) {
            return;
        }
        this.A06 = true;
        AbstractC2330jd abstractC2330jdA27 = this.A0A.A27(this.A00);
        int iA01 = A01(this.A00);
        if (this.A0H instanceof FullScreenAdToolbar) {
            ((FullScreenAdToolbar) this.A0H).A0G(this.A0D, abstractC2330jdA27.A22());
            ((FullScreenAdToolbar) this.A0H).A0F(abstractC2330jdA27.A2C(), abstractC2330jdA27.A2E(), iA01);
        } else if (this.A0H instanceof PU) {
            ((PU) this.A0H).setInitialUnskippableSeconds(iA01);
        }
        C1983dk fullScreenAdStyle = abstractC1304Ij.getFullScreenAdStyle();
        A0N(abstractC1304Ij, fullScreenAdStyle);
        this.A0K.add(fullScreenAdStyle);
        this.A0H.setToolbarActionMessage(A0D(4, 3, 90) + (this.A00 + 1) + A0D(0, 4, 21) + this.A0A.A23());
        if (this.A08) {
            this.A0H.setToolbarActionMode(1);
        }
        A0O(abstractC2330jdA27);
    }
}
