package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.d0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.v;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements x, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1309a;
    public final b0 b = new b0("HlsPlaylistTracker:MediaPlaylist");
    public final d0 c;
    public d d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public IOException j;
    public final /* synthetic */ k k;

    public h(k kVar, a aVar, long j) {
        this.k = kVar;
        this.f1309a = aVar;
        this.g = j;
        this.c = new d0(kVar.f1310a.f1294a.a(), com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(kVar.j.f1306a, aVar.f1304a), kVar.b);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2, boolean z) {
        d0 d0Var = (d0) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d0Var.f1446a;
        long j3 = d0Var.f;
        if (fVar.b != null) {
            fVar.f1413a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, 4, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j, j2, j3));
        }
    }

    public final void b() {
        this.h = 0L;
        if (this.i || this.b.a()) {
            return;
        }
        b0 b0Var = this.b;
        d0 d0Var = this.c;
        int i = this.k.c;
        b0Var.getClass();
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException();
        }
        y yVar = new y(b0Var, looperMyLooper, d0Var, this, i, SystemClock.elapsedRealtime());
        if (b0Var.b != null) {
            throw new IllegalStateException();
        }
        b0Var.b = yVar;
        yVar.e = null;
        b0Var.f1434a.execute(yVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.i = false;
        b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2) {
        d0 d0Var = (d0) zVar;
        e eVar = d0Var.d;
        if (eVar instanceof d) {
            a((d) eVar);
            com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d0Var.f1446a;
            long j3 = d0Var.f;
            if (fVar.b != null) {
                fVar.f1413a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar, kVar, 4, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j, j2, j3));
                return;
            }
            return;
        }
        this.j = new r("Loaded playlist has unexpected type.");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final int a(z zVar, long j, long j2, IOException iOException) {
        boolean z;
        int i;
        d0 d0Var = (d0) zVar;
        boolean z2 = iOException instanceof r;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d0Var.f1446a;
        long j3 = d0Var.f;
        if (fVar.b != null) {
            z = z2;
            fVar.f1413a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, 4, -1, null, 0, null, C.TIME_UNSET, C.TIME_UNSET, j, j2, j3, iOException, z));
        } else {
            z = z2;
        }
        if (z) {
            return 3;
        }
        if ((iOException instanceof v) && ((i = ((v) iOException).f1459a) == 404 || i == 410)) {
            a();
            k kVar2 = this.k;
            if (kVar2.k == this.f1309a) {
                List list = kVar2.j.b;
                int size = list.size();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                for (int i2 = 0; i2 < size; i2++) {
                    h hVar = (h) kVar2.d.get(list.get(i2));
                    if (jElapsedRealtime > hVar.h) {
                        kVar2.k = hVar.f1309a;
                        hVar.b();
                    }
                }
            }
            return 2;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d r29) {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d):void");
    }

    public final void a() {
        this.h = SystemClock.elapsedRealtime() + 60000;
        k kVar = this.k;
        a aVar = this.f1309a;
        int size = kVar.g.size();
        for (int i = 0; i < size; i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i iVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i) kVar.g.get(i);
            for (n nVar : iVar.n) {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f fVar = nVar.c;
                int iA = fVar.f.a(aVar.b);
                if (iA != -1) {
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar.p;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= bVar.b) {
                            i2 = -1;
                            break;
                        } else if (bVar.c[i2] == iA) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        fVar.p.a(i2);
                    }
                }
            }
            if (iVar.m != null) {
                l lVar = (l) iVar.j;
                lVar.getClass();
                lVar.f.obtainMessage(9, iVar).sendToTarget();
            } else {
                for (n nVar2 : iVar.n) {
                    if (!nVar2.o) {
                        nVar2.b(nVar2.w);
                    }
                }
            }
        }
    }
}
