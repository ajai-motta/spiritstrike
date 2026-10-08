package com.fyber.inneractive.sdk.player.exoplayer2.util;

import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1478a;
    public long b;
    public volatile long c = C.TIME_UNSET;

    public v(long j) {
        c(j);
    }

    public final long a(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.c != C.TIME_UNSET) {
            this.c = j;
        } else {
            long j2 = this.f1478a;
            if (j2 != Long.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.c = j;
                notifyAll();
            }
        }
        return j + this.b;
    }

    public final long b(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.c != C.TIME_UNSET) {
            long j2 = (this.c * 90000) / 1000000;
            long j3 = (4294967296L + j2) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - j2) < Math.abs(j - j2)) {
                j = j4;
            }
        }
        return a((j * 1000000) / 90000);
    }

    public final synchronized void c(long j) {
        if (this.c != C.TIME_UNSET) {
            throw new IllegalStateException();
        }
        this.f1478a = j;
    }
}
