package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1742Zr implements View.OnClickListener {
    public final /* synthetic */ C1459Ok A00;
    public final /* synthetic */ C1732Zh A01;
    public final /* synthetic */ MD A02;

    public ViewOnClickListenerC1742Zr(MD md, C1732Zh c1732Zh, C1459Ok c1459Ok) {
        this.A02 = md;
        this.A01 = c1732Zh;
        this.A00 = c1459Ok;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0D.AF4(this.A00);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
