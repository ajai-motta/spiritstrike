package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Looper;
import android.util.Log;
import com.fyber.inneractive.sdk.player.controller.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i f1389a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h b;
    public final f c;
    public final l d;
    public final CopyOnWriteArraySet e;
    public final w f;
    public final v g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public x m;
    public Object n;
    public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h o;
    public s p;
    public i q;
    public int r;
    public long s;

    public g(a[] aVarArr, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d dVar, c cVar) {
        Log.i("ExoPlayerImpl", "Init ExoPlayerLib/2.4.4 [" + z.e + "]");
        if (aVarArr.length <= 0) {
            throw new IllegalStateException();
        }
        this.f1389a = dVar;
        this.i = false;
        this.j = 1;
        this.e = new CopyOnWriteArraySet();
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h(new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[aVarArr.length]);
        this.b = hVar;
        this.m = x.f1497a;
        this.f = new w();
        this.g = new v();
        int i = com.fyber.inneractive.sdk.player.exoplayer2.source.z.d;
        this.o = hVar;
        this.p = s.d;
        f fVar = new f(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.c = fVar;
        i iVar = new i(0, 0L);
        this.q = iVar;
        this.d = new l(aVarArr, dVar, cVar, this.i, fVar, iVar, this);
    }

    public final void a(boolean z) {
        if (this.i != z) {
            this.i = z;
            this.d.f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((b0) it.next()).a(this.j, z);
            }
        }
    }

    public final void a(int i, long j) {
        if (i >= 0 && (this.m.c() || i < this.m.b())) {
            this.k++;
            this.r = i;
            boolean zC = this.m.c();
            long j2 = C.TIME_UNSET;
            if (!zC) {
                this.m.a(i, this.f, 0L);
                long j3 = j == C.TIME_UNSET ? this.f.e : j;
                w wVar = this.f;
                int i2 = wVar.c;
                long j4 = wVar.g;
                int i3 = b.f1277a;
                long j5 = (j3 == C.TIME_UNSET ? -9223372036854775807L : j3 * 1000) + j4;
                long j6 = this.m.a(i2, this.g, false).d;
                while (j6 != C.TIME_UNSET && j5 >= j6 && i2 < this.f.d) {
                    j5 -= j6;
                    i2++;
                    j6 = this.m.a(i2, this.g, false).d;
                }
            }
            if (j == C.TIME_UNSET) {
                this.s = 0L;
                this.d.f.obtainMessage(3, new j(this.m, i, C.TIME_UNSET)).sendToTarget();
                return;
            }
            this.s = j;
            l lVar = this.d;
            x xVar = this.m;
            int i4 = b.f1277a;
            if (j != C.TIME_UNSET) {
                j2 = j * 1000;
            }
            lVar.f.obtainMessage(3, new j(xVar, i, j2)).sendToTarget();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((b0) it.next()).getClass();
            }
            return;
        }
        throw new q();
    }

    public final void a(e... eVarArr) {
        l lVar = this.d;
        if (lVar.q) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            lVar.f.obtainMessage(11, eVarArr).sendToTarget();
        }
    }

    public final int a() {
        if (!this.m.c() && this.k <= 0) {
            return this.m.a(this.q.f1391a, this.g, false).c;
        }
        return this.r;
    }
}
