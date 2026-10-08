package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1477a;
    public long b;
    public long c;
    public com.fyber.inneractive.sdk.player.exoplayer2.s d = com.fyber.inneractive.sdk.player.exoplayer2.s.d;

    public final void a(long j) {
        this.b = j;
        if (this.f1477a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final long b() {
        long j = this.b;
        if (!this.f1477a) {
            return j;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        com.fyber.inneractive.sdk.player.exoplayer2.s sVar = this.d;
        if (sVar.f1406a != 1.0f) {
            return j + (jElapsedRealtime * ((long) sVar.c));
        }
        int i = com.fyber.inneractive.sdk.player.exoplayer2.b.f1277a;
        long j2 = C.TIME_UNSET;
        if (jElapsedRealtime != C.TIME_UNSET) {
            j2 = 1000 * jElapsedRealtime;
        }
        return j + j2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.s a(com.fyber.inneractive.sdk.player.exoplayer2.s sVar) {
        if (this.f1477a) {
            a(b());
        }
        this.d = sVar;
        return sVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.s a() {
        return this.d;
    }
}
