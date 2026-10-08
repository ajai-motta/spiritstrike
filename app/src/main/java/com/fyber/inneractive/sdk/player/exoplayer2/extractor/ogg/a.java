package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import androidx.work.WorkRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1343a;

    public a(b bVar) {
        this.f1343a = bVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        b bVar = this.f1343a;
        return (bVar.f * 1000000) / ((long) bVar.d.i);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        if (j == 0) {
            return this.f1343a.b;
        }
        b bVar = this.f1343a;
        long j2 = (((long) bVar.d.i) * j) / 1000000;
        long j3 = bVar.b;
        long j4 = bVar.c;
        long j5 = ((((j4 - j3) * j2) / bVar.f) - WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) + j3;
        if (j5 >= j3) {
            j3 = j5;
        }
        return j3 >= j4 ? j4 - 1 : j3;
    }
}
