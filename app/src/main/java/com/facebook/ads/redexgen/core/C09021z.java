package com.facebook.ads.redexgen.core;

import android.media.AudioAttributes;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C09021z {
    public final AudioAttributes A00;

    public C09021z(C2731qQ c2731qQ) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(c2731qQ.A02).setFlags(c2731qQ.A03).setUsage(c2731qQ.A05);
        if (C5C.A02 >= 29) {
            C09001x.A00(usage, c2731qQ.A01);
        }
        if (C5C.A02 >= 32) {
            C09011y.A00(usage, c2731qQ.A04);
        }
        this.A00 = usage.build();
    }
}
