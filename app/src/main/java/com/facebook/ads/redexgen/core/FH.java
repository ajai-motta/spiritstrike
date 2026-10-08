package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class FH extends AbstractC1513Qq<FC> {
    public final int A00;
    public final C2165gi A01;
    public final ViewOnClickListenerC1363Kr A02;
    public final List<String> A03;

    public FH(C2165gi c2165gi, List<String> screenshotUrls, int i, ViewOnClickListenerC1363Kr viewOnClickListenerC1363Kr) {
        this.A03 = screenshotUrls;
        this.A00 = i;
        this.A01 = c2165gi;
        this.A02 = viewOnClickListenerC1363Kr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC1513Qq
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final FC A0F(ViewGroup viewGroup, int i) {
        FD fd = new FD(this.A01);
        if (C1615Up.A1D(this.A01)) {
            fd.setOnClickListener(new ViewOnClickListenerC2032eZ(this));
        }
        return new FC(fd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC1513Qq
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0K(FC fc, int i) {
        String str = this.A03.get(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int startSpacing = this.A00 * 4;
        if (i != 0) {
            startSpacing = this.A00;
        }
        marginLayoutParams.setMargins(startSpacing, 0, i >= A0B() + (-1) ? this.A00 * 4 : this.A00, 0);
        fc.A0p().setLayoutParams(marginLayoutParams);
        fc.A0p().A00(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1513Qq
    public final int A0B() {
        return this.A03.size();
    }
}
