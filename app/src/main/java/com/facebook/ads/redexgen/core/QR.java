package com.facebook.ads.redexgen.core;

import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QR implements Runnable {
    public final /* synthetic */ C7P A00;
    public final /* synthetic */ ArrayList A01;

    public QR(C7P c7p, ArrayList arrayList) {
        this.A00 = c7p;
        this.A01 = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (C1498Qa c1498Qa : this.A01) {
            this.A00.A0e(c1498Qa.A04, c1498Qa.A00, c1498Qa.A01, c1498Qa.A02, c1498Qa.A03);
        }
        this.A01.clear();
        this.A00.A05.remove(this.A01);
    }
}
