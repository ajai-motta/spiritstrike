package com.facebook.ads.redexgen.core;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2308jA implements InterfaceC1563Sp {
    public final C1437No A00;
    public final O3 A01;
    public final C1571Sx A02;
    public final C2165gi A03;
    public final boolean A04;

    public C2308jA(C2165gi c2165gi, O3 o3, C1571Sx c1571Sx, C1437No c1437No, boolean z) {
        this.A03 = c2165gi;
        this.A01 = o3;
        this.A02 = c1571Sx;
        this.A00 = c1437No;
        this.A04 = z;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        O4 playableWebViewClient = new O4(this.A00, this.A01, this.A04);
        webView.setWebViewClient(playableWebViewClient);
        webView.loadUrl(this.A00.A0L());
        playableWebViewClient.A03();
    }

    private void A01(boolean z) {
        if (this.A00.A0G() == EnumC1438Np.A05) {
            A00();
            return;
        }
        String strA0L = this.A00.A0L();
        if (z) {
            C1571Sx c1571Sx = this.A02;
            String markupUrlResult = this.A00.A0L();
            strA0L = c1571Sx.A0S(markupUrlResult);
        }
        this.A00.A0T(strA0L);
        this.A01.AFG();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1563Sp
    public final void ADL() {
        if (this.A04) {
            this.A01.AFF(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1563Sp
    public final void ADT() {
        A01(true);
    }
}
