package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C09102j extends Q9<C2110fp> implements T4 {
    public C2165gi A00;
    public boolean A01;

    public C09102j(C2110fp c2110fp, C2165gi c2165gi) {
        super(c2110fp);
        this.A00 = c2165gi;
        this.A01 = false;
    }

    private void A00(int i) {
        if (!this.A01) {
            this.A00.A0F().A3v(i);
        }
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        C2110fp c2110fpA08 = A08();
        int iIntValue = 0;
        if (c2110fpA08 == null) {
            A00(0);
            return;
        }
        View view = c2110fpA08.A0C;
        AbstractC2109fo abstractC2109fo = (AbstractC2109fo) c2110fpA08.A0E.get();
        int i = 1;
        boolean z = view == null;
        if (!z && abstractC2109fo != null) {
            C2111fq c2111fqA0E = C2110fp.A0E(view, c2110fpA08.A0A, this.A00);
            if (c2111fqA0E.A04()) {
                C2110fp.A05(c2110fpA08);
            } else {
                c2110fpA08.A00 = 0;
            }
            boolean z2 = c2110fpA08.A00 > c2110fpA08.A09;
            boolean wasViewable = c2110fpA08.A05 != null && c2110fpA08.A05.A04();
            if (z2 || !c2111fqA0E.A04()) {
                c2110fpA08.A05 = c2111fqA0E;
            }
            String strValueOf = String.valueOf(c2111fqA0E.A01());
            synchronized (c2110fpA08) {
                if (c2110fpA08.A06.containsKey(strValueOf)) {
                    iIntValue = ((Integer) c2110fpA08.A06.get(strValueOf)).intValue();
                }
                c2110fpA08.A06.put(strValueOf, Integer.valueOf(iIntValue + 1));
            }
            if (z2 && !wasViewable) {
                this.A01 = true;
                c2110fpA08.A03 = System.currentTimeMillis();
                if (c2110fpA08.A07) {
                    this.A00.A0F().A3w();
                }
                abstractC2109fo.A03();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500L);
                    view.startAnimation(alphaAnimation);
                }
                if (!c2110fpA08.A0F) {
                    return;
                }
            } else if (!z2 && wasViewable) {
                this.A01 = true;
                if (c2110fpA08.A07) {
                    this.A00.A0F().A3S(c2111fqA0E.A02());
                }
                abstractC2109fo.A00();
            } else {
                abstractC2109fo.A02();
                if (!this.A01 && c2110fpA08.A07) {
                    this.A00.A0F().A3u(c2111fqA0E.A02());
                }
                this.A01 = true;
            }
            if (!c2110fpA08.A08 && c2110fpA08.A04 != null) {
                c2110fpA08.A0B.postDelayed(c2110fpA08.A04, c2110fpA08.A02);
                return;
            }
            return;
        }
        if (c2110fpA08.A07) {
            if (!z) {
                i = 2;
            }
            A00(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.T4
    public final C2165gi A6m() {
        return this.A00;
    }
}
