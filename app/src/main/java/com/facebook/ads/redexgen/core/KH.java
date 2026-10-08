package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class KH extends AbstractRunnableC1652Wc {
    public final /* synthetic */ KE A00;

    public KH(KE ke) {
        this.A00 = ke;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        if (!this.A00.A0Y) {
            YB.A0F(1000, this.A00.A0K);
        }
        this.A00.postDelayed(this, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
