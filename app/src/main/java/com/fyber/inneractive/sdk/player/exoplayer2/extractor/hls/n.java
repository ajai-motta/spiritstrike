package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.source.w;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.google.android.exoplayer2.C;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements x, w, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j, com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1301a;
    public final i b;
    public final f c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.o e;
    public final int f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f h;
    public boolean n;
    public boolean o;
    public int p;
    public com.fyber.inneractive.sdk.player.exoplayer2.o q;
    public int r;
    public boolean s;
    public z t;
    public int u;
    public boolean[] v;
    public long w;
    public long x;
    public boolean y;
    public final b0 g = new b0("Loader:HlsSampleStreamWrapper");
    public final d i = new d();
    public final SparseArray j = new SparseArray();
    public final LinkedList k = new LinkedList();
    public final m l = new m(this);
    public final Handler m = new Handler();

    public n(int i, i iVar, f fVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i2, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2) {
        this.f1301a = i;
        this.b = iVar;
        this.c = fVar;
        this.d = bVar;
        this.e = oVar;
        this.f = i2;
        this.h = fVar2;
        this.w = j;
        this.x = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void a(q qVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013d  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(long r40) {
        /*
            Method dump skipped, instruction units count: 837
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.n.b(long):boolean");
    }

    public final void c(long j) {
        this.w = j;
        this.x = j;
        this.y = false;
        this.k.clear();
        if (this.g.a()) {
            this.g.b.a(false);
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i)).a(this.v[i]);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public final void e() {
        this.m.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        long j = this.x;
        if (j != C.TIME_UNSET) {
            return j;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return ((h) this.k.getLast()).g;
    }

    public final void h() {
        if (this.s || this.o || !this.n) {
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i)).e() == null) {
                return;
            }
        }
        int size2 = this.j.size();
        int i2 = 0;
        char c = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size2) {
                break;
            }
            String str = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i2)).e().f;
            char c2 = "video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 3 : "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 2 : "text".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 1 : (char) 0;
            if (c2 > c) {
                i3 = i2;
                c = c2;
            } else if (c2 == c && i3 != -1) {
                i3 = -1;
            }
            i2++;
        }
        y yVar = this.c.f;
        int i4 = yVar.f1424a;
        this.u = -1;
        this.v = new boolean[size2];
        y[] yVarArr = new y[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            com.fyber.inneractive.sdk.player.exoplayer2.o oVarE = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i5)).e();
            if (i5 == i3) {
                com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.o[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    oVarArr[i6] = a(yVar.b[i6], oVarE);
                }
                yVarArr[i5] = new y(oVarArr);
                this.u = i5;
            } else {
                yVarArr[i5] = new y(a((c == 3 && "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(oVarE.f))) ? this.e : null, oVarE));
            }
        }
        this.t = new z(yVarArr);
        this.o = true;
        i iVar = this.b;
        int i7 = iVar.k - 1;
        iVar.k = i7;
        if (i7 > 0) {
            return;
        }
        int i8 = 0;
        for (n nVar : iVar.n) {
            i8 += nVar.t.f1425a;
        }
        y[] yVarArr2 = new y[i8];
        int i9 = 0;
        for (n nVar2 : iVar.n) {
            int i10 = nVar2.t.f1425a;
            int i11 = 0;
            while (i11 < i10) {
                yVarArr2[i9] = nVar2.t.b[i11];
                i11++;
                i9++;
            }
        }
        iVar.m = new z(yVarArr2);
        ((com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j).f.obtainMessage(8, iVar).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f1410a;
        int i = aVar.b;
        int i2 = this.f1301a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long jC = aVar.c();
        if (fVar.b != null) {
            fVar.f1413a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, jC));
        }
        if (z) {
            return;
        }
        int size = this.j.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i4)).a(this.v[i4]);
        }
        i iVar = this.b;
        iVar.getClass();
        if (iVar.m == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
        lVar.getClass();
        lVar.f.obtainMessage(9, iVar).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        f fVar = this.c;
        fVar.getClass();
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            fVar.i = cVar.i;
            fVar.a(cVar.f1410a.f1451a, cVar.l, cVar.m);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f1410a;
        int i = aVar.b;
        int i2 = this.f1301a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long jC = aVar.c();
        if (fVar2.b != null) {
            fVar2.f1413a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar2, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, jC));
        }
        if (!this.o) {
            b(this.w);
            return;
        }
        i iVar = this.b;
        iVar.getClass();
        if (iVar.m == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
        lVar.getClass();
        lVar.f.obtainMessage(9, iVar).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010b  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z r25, long r26, long r28, java.io.IOException r30) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.n.a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z, long, long, java.io.IOException):int");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a(int i, int i2) {
        if (this.j.indexOfKey(i) >= 0) {
            return (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.get(i);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.g(this.d);
        gVar.n = this;
        gVar.c.r = this.r;
        this.j.put(i, gVar);
        return gVar;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.o a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        String strA;
        if (oVar == null) {
            return oVar2;
        }
        int iC = com.fyber.inneractive.sdk.player.exoplayer2.util.i.c(oVar2.f);
        if (iC == 1) {
            strA = a(oVar.c, 1);
        } else {
            strA = iC == 2 ? a(oVar.c, 2) : null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar.f1404a, oVar2.e, oVar2.f, strA, oVar.b, oVar2.g, oVar.j, oVar.k, oVar2.l, oVar2.m, oVar2.n, oVar2.p, oVar2.o, oVar2.q, oVar2.r, oVar2.s, oVar2.t, oVar2.u, oVar2.v, oVar.x, oVar.y, oVar2.z, oVar2.w, oVar2.h, oVar2.i, oVar2.d);
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (i == com.fyber.inneractive.sdk.player.exoplayer2.util.i.c(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void b() {
        this.n = true;
        this.m.post(this.l);
    }
}
