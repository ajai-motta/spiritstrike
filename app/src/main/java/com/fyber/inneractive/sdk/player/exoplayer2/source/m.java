package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f1419a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final n c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.e d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.o e;
    public volatile boolean f;
    public boolean g;
    public long h;
    public long i;
    public final /* synthetic */ p j;

    public m(p pVar, Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, n nVar, com.fyber.inneractive.sdk.player.exoplayer2.util.e eVar) {
        this.j = pVar;
        uri.getClass();
        this.f1419a = uri;
        hVar.getClass();
        this.b = hVar;
        nVar.getClass();
        this.c = nVar;
        this.d = eVar;
        this.e = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.o();
        this.g = true;
        this.i = -1L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.f;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.f = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void load() throws Throwable {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        long j;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar;
        int iA = 0;
        while (iA == 0 && !this.f) {
            try {
                j = this.e.f1342a;
                long jA = this.b.a(new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(this.f1419a, j, j, -1L, this.j.h, 0));
                this.i = jA;
                if (jA != -1) {
                    this.i = jA + j;
                }
                hVar = this.b;
                bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar, j, this.i);
            } catch (Throwable th) {
                th = th;
                bVar = null;
            }
            try {
                n nVar = this.c;
                hVar.a();
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.i iVarA = nVar.a(bVar);
                if (this.g) {
                    iVarA.a(j, this.h);
                    this.g = false;
                }
                long j2 = j;
                while (iA == 0 && !this.f) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.e eVar = this.d;
                    synchronized (eVar) {
                        while (!eVar.f1465a) {
                            eVar.wait();
                        }
                    }
                    iA = iVarA.a(bVar, this.e);
                    long j3 = bVar.c;
                    if (j3 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + j2) {
                        this.d.a();
                        p pVar = this.j;
                        pVar.n.post(pVar.m);
                        j2 = j3;
                    }
                }
                if (iA == 1) {
                    iA = 0;
                } else {
                    this.e.f1342a = bVar.c;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(this.b);
            } catch (Throwable th2) {
                th = th2;
                if (iA != 1 && bVar != null) {
                    this.e.f1342a = bVar.c;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(this.b);
                throw th;
            }
        }
    }
}
