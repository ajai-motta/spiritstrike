package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1322a;
    public final long b;
    public final long c;
    public final long[] d;
    public final long e;
    public final int f;

    public e(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f1322a = j;
        this.b = j2;
        this.c = j3;
        this.d = jArr;
        this.e = j4;
        this.f = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return this.d != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b
    public final long b(long j) {
        if (!a()) {
            return 0L;
        }
        if (j < this.f1322a) {
            return 0L;
        }
        double d = ((j - r4) * 256.0d) / this.e;
        int iA = z.a(this.d, (long) d, false);
        int i = iA + 1;
        long j2 = (((long) i) * this.b) / 100;
        long j3 = i == 0 ? 0L : this.d[iA];
        return j2 + ((i == 99 ? 256L : this.d[i]) == j3 ? 0L : (long) (((d - j3) * (((r7 * ((long) (iA + 2))) / 100) - j2)) / (r16 - j3)));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        if (!a()) {
            return this.f1322a;
        }
        float f = (j * 100.0f) / this.b;
        if (f > 0.0f) {
            if (f >= 100.0f) {
                f = 256.0f;
            } else {
                int i = (int) f;
                f = i != 0 ? this.d[i - 1] : 0.0f;
                f += (f - i) * ((i < 99 ? this.d[i] : 256.0f) - f);
            }
        }
        long jRound = Math.round(((double) f) * 0.00390625d * this.e);
        long j2 = this.f1322a;
        long j3 = jRound + j2;
        long j4 = this.c;
        return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - ((long) this.f)) + this.e) - 1);
    }
}
