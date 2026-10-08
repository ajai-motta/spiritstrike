package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1467a;
    public long[] b = new long[32];

    public final void a(long j) {
        int i = this.f1467a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.f1467a;
        this.f1467a = i2 + 1;
        jArr2[i2] = j;
    }
}
