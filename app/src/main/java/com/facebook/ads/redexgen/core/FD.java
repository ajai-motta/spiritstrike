package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class FD extends C1860bl {
    public final ImageView A00;
    public final C2165gi A01;

    public FD(C2165gi c2165gi) {
        super(c2165gi);
        this.A01 = c2165gi;
        this.A00 = new ImageView(c2165gi);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final void A00(String str) {
        LM downloadImageTask = new LM(this.A00, this.A01);
        downloadImageTask.A04();
        downloadImageTask.A07(str);
    }
}
