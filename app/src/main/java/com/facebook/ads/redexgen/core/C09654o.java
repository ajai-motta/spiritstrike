package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C09654o extends BroadcastReceiver {
    public final /* synthetic */ C09664p A00;

    public C09654o(C09664p c09664p) {
        this.A00 = c09664p;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int iA00 = C09664p.A00(context);
        if (C5C.A02 >= 31 && iA00 == 5) {
            C09634m.A02(context, this.A00);
        } else {
            this.A00.A07(iA00);
        }
    }
}
