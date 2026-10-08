package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1319a;
    public final int b;
    public final long c;

    public a(int i, long j, long j2) {
        this.f1319a = j;
        this.b = i;
        this.c = j2 == -1 ? C.TIME_UNSET : b(j2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return this.c != C.TIME_UNSET;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b
    public final long b(long j) {
        return (Math.max(0L, j - this.f1319a) * 8000000) / ((long) this.b);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        long j2 = this.c;
        if (j2 == C.TIME_UNSET) {
            return 0L;
        }
        int i = z.f1480a;
        long jMax = Math.max(0L, Math.min(j, j2));
        return ((jMax * ((long) this.b)) / 8000000) + this.f1319a;
    }
}
