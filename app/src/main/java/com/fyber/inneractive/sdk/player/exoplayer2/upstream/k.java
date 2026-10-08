package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f1451a;
    public final long b;
    public final long c;
    public final long d;
    public final String e;
    public final int f;

    public k(Uri uri, long j, long j2, long j3, String str, int i) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j2 < 0) {
            throw new IllegalArgumentException();
        }
        if (j3 <= 0 && j3 != -1) {
            throw new IllegalArgumentException();
        }
        this.f1451a = uri;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = str;
        this.f = i;
    }

    public final String toString() {
        return "DataSpec[" + this.f1451a + ", " + Arrays.toString((byte[]) null) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + "]";
    }
}
