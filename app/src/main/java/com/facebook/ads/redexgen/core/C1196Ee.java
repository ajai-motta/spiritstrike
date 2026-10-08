package com.facebook.ads.redexgen.core;

import android.media.Spatializer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1196Ee implements Spatializer.OnSpatializerStateChangedListener {
    public final /* synthetic */ C1197Ef A00;
    public final /* synthetic */ C10829h A01;

    public C1196Ee(C1197Ef c1197Ef, C10829h c10829h) {
        this.A00 = c1197Ef;
        this.A01 = c10829h;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.A01.A0L();
    }
}
