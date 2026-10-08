package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ZY implements View.OnClickListener {
    public final /* synthetic */ C1726Zb A00;

    public ZY(C1726Zb c1726Zb) {
        this.A00 = c1726Zb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A05) {
                this.A00.A04.A53();
            } else {
                this.A00.A04.A54();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
