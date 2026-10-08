package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet f1442a = new TreeSet(this);
    public long b;

    public final void a(l lVar, long j) {
        while (this.b + j > 10485760) {
            try {
                g gVar = (g) this.f1442a.first();
                synchronized (lVar) {
                    lVar.a(gVar, true);
                }
            } catch (a unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[ORIG_RETURN, RETURN] */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compare(java.lang.Object r9, java.lang.Object r10) {
        /*
            r8 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.g r9 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.g) r9
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.g r10 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.g) r10
            long r0 = r9.f
            long r2 = r10.f
            long r4 = r0 - r2
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L31
            java.lang.String r0 = r9.f1439a
            java.lang.String r1 = r10.f1439a
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L23
            java.lang.String r9 = r9.f1439a
            java.lang.String r10 = r10.f1439a
            int r9 = r9.compareTo(r10)
            goto L38
        L23:
            long r0 = r9.b
            long r9 = r10.b
            long r0 = r0 - r9
            int r9 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r9 != 0) goto L2e
            r9 = 0
            goto L38
        L2e:
            if (r9 >= 0) goto L37
            goto L35
        L31:
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 >= 0) goto L37
        L35:
            r9 = -1
            goto L38
        L37:
            r9 = 1
        L38:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.j.compare(java.lang.Object, java.lang.Object):int");
    }
}
