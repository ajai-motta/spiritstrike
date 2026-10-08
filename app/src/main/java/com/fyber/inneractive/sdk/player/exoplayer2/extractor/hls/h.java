package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.q;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public n D;
    public volatile boolean E;
    public volatile boolean F;
    public final int j;
    public final int k;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a l;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h m;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.k n;
    public final boolean o;
    public final boolean p;
    public final v q;
    public final String r;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i s;
    public final boolean t;
    public final boolean u;
    public final List v;
    public final boolean w;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n x;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n y;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.i z;

    /* JADX WARN: Illegal instructions before constructor call */
    public h(com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar, List list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, v vVar, h hVar2, byte[] bArr, byte[] bArr2) {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h aVar2 = (bArr == null || bArr2 == null) ? hVar : new a(hVar, bArr, bArr2);
        super(i, i2, j, j2, aVar.b, aVar2, kVar, obj);
        this.k = i3;
        this.n = kVar2;
        this.l = aVar;
        this.v = list;
        this.p = z;
        this.q = vVar;
        this.o = aVar2 instanceof a;
        String lastPathSegment = kVar.f1451a.getLastPathSegment();
        this.r = lastPathSegment;
        boolean z2 = lastPathSegment.endsWith(".aac") || lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3") || lastPathSegment.endsWith(".mp3");
        this.w = z2;
        if (hVar2 != null) {
            this.x = hVar2.x;
            this.y = hVar2.y;
            this.s = hVar2.z;
            boolean z3 = hVar2.l != aVar;
            this.t = z3;
            this.u = hVar2.k != i3 || z3;
        } else {
            this.x = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n() : null;
            this.y = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10) : null;
            this.s = null;
            this.t = false;
            this.u = true;
        }
        this.m = hVar;
        this.j = G.getAndIncrement();
    }

    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVarA;
        bVar.e = 0;
        if (!bVar.a(this.y.f1472a, 0, 10, true)) {
            return C.TIME_UNSET;
        }
        this.y.c(10);
        if (this.y.l() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.b) {
            return C.TIME_UNSET;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.y;
        nVar.e(nVar.b + 3);
        int i = this.y.i();
        int i2 = i + 10;
        if (i2 > this.y.a()) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.y;
            byte[] bArr = nVar2.f1472a;
            nVar2.c(i2);
            System.arraycopy(bArr, 0, this.y.f1472a, 0, 10);
        }
        if (!bVar.a(this.y.f1472a, 10, i, true) || (bVarA = this.x.a(i, this.y.f1472a)) == null) {
            return C.TIME_UNSET;
        }
        int length = bVarA.f1400a.length;
        for (int i3 = 0; i3 < length; i3++) {
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o oVar = bVarA.f1400a[i3];
            if (oVar instanceof q) {
                q qVar = (q) oVar;
                if ("com.apple.streaming.transportStreamTimestamp".equals(qVar.b)) {
                    System.arraycopy(qVar.c, 0, this.y.f1472a, 0, 8);
                    this.y.c(8);
                    return this.y.g();
                }
            }
        }
        return C.TIME_UNSET;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.E = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a
    public final long c() {
        return this.B;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f5  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void load() {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h.load():void");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.E;
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i a(long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i aVar;
        if (this.r.endsWith(".aac")) {
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c(j);
        } else if (!this.r.endsWith(".ac3") && !this.r.endsWith(".ec3")) {
            if (this.r.endsWith(".mp3")) {
                aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c(j);
            } else {
                throw new IllegalArgumentException("Unkown extension for audio file: " + this.r);
            }
        } else {
            aVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a(j);
        }
        aVar.a(this.D);
        return aVar;
    }
}
