package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1734Zj implements View.OnClickListener {
    public final /* synthetic */ ME A00;

    public ViewOnClickListenerC1734Zj(ME me) {
        this.A00 = me;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0D.AEr(EnumC1457Oi.A04);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
