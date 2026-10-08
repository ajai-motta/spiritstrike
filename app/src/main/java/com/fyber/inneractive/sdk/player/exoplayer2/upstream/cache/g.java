package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1439a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;

    public g(String str, long j, long j2, long j3, File file) {
        this.f1439a = str;
        this.b = j;
        this.c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        if (!this.f1439a.equals(gVar.f1439a)) {
            return this.f1439a.compareTo(gVar.f1439a);
        }
        long j = this.b - gVar.b;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }
}
