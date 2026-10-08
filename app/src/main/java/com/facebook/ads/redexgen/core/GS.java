package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GS implements InterfaceC1680Xh {
    public final /* synthetic */ C4V A00;

    public GS(C4V c4v) {
        this.A00 = c4v;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1680Xh
    public final void AF5(String str) {
        this.A00.A0G.postDelayed(new RunnableC1990ds(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1680Xh
    public final void AF6(String str) {
        this.A00.A0H(VH.A0c);
    }
}
