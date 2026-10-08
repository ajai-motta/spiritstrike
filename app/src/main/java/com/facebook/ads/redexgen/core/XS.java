package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class XS {
    public static String[] A05 = {"hdh4k6eZclrlxxYg19ck", "OIQuDIQFpzBifrZrtJIvg4BasUaQd63c", "6y0NffGMqcG8EugdtirNjkqg6svCH2Zl", "13Ua2r6CYJwc6p6BI5coDxRAaPqMz7yS", "7WkbYpbXunBRly3lB1oHckvOip2eqLp6", "2PYz6J8qU0vRqLO17bgOak7iCaiihwk", "gvpJ77qQnx", "SLFhDDNvl2CxgKHJ1vqMDyCxDe74woQD"};
    public boolean A00 = false;
    public final Handler A01 = new Handler(Looper.getMainLooper());
    public final AbstractC2330jd A02;
    public final C2165gi A03;
    public final XQ A04;

    public XS(C2165gi c2165gi, AbstractC2330jd abstractC2330jd, XQ xq) {
        this.A03 = c2165gi;
        this.A04 = xq;
        this.A02 = abstractC2330jd;
    }

    public static XS A00(C2165gi c2165gi, AbstractC2330jd abstractC2330jd, XQ xq) {
        Object creativeAsCtaLoggingHelper = c2165gi.A0I();
        if (creativeAsCtaLoggingHelper == null) {
            creativeAsCtaLoggingHelper = new XS(c2165gi, abstractC2330jd, xq);
            c2165gi.A0P(creativeAsCtaLoggingHelper);
        }
        return (XS) creativeAsCtaLoggingHelper;
    }

    public static boolean A01(C2165gi c2165gi) {
        return C1615Up.A1g(c2165gi) && X6.A0I(c2165gi);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.XR A02(com.facebook.ads.redexgen.core.AbstractC2330jd r7) {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.gi r0 = r6.A03
            boolean r0 = com.facebook.ads.redexgen.core.C1615Up.A1m(r0)
            r4 = 1
            if (r0 == 0) goto L1f
            boolean r0 = r7.A1e()
            if (r0 == 0) goto L1d
            com.facebook.ads.redexgen.X.gi r0 = r6.A03
            boolean r0 = A01(r0)
            if (r0 == 0) goto L1d
        L17:
            com.facebook.ads.redexgen.X.XR r0 = new com.facebook.ads.redexgen.X.XR
            r0.<init>(r4, r4)
            return r0
        L1d:
            r4 = 0
            goto L17
        L1f:
            boolean r3 = r7.A1e()
            if (r3 == 0) goto L51
            com.facebook.ads.redexgen.X.gi r0 = r6.A03
            boolean r5 = A01(r0)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.XS.A05
            r0 = 5
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L53
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.XS.A05
            java.lang.String r1 = "D5RQoHah0ZffyX7n6MMHscTeZuBHZQ8g"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "oKN8Sif1fTCm3hFJqGEcKAR8lt3N8fjA"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L51
        L4b:
            com.facebook.ads.redexgen.X.XR r0 = new com.facebook.ads.redexgen.X.XR
            r0.<init>(r3, r4)
            return r0
        L51:
            r4 = 0
            goto L4b
        L53:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.XS.A02(com.facebook.ads.redexgen.X.jd):com.facebook.ads.redexgen.X.XR");
    }

    public final void A03() {
        this.A00 = false;
        this.A01.removeCallbacksAndMessages(null);
    }
}
