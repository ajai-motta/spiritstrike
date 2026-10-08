package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.upstream.cache.CacheDataSink;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2383kV implements C5V {
    public MP A02;
    public long A01 = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    public int A00 = CacheDataSink.DEFAULT_BUFFER_SIZE;

    public final C2383kV A00(MP mp) {
        this.A02 = mp;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C5V
    public final C2382kU A5H() {
        return new C2382kU((MP) AbstractC09493y.A01(this.A02), this.A01, this.A00);
    }
}
