package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f1375a = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10);
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;
    public long d;
    public int e;
    public int f;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.c = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
        int i;
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.a(this.d, 1, i, 0, null);
            this.c = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e0Var.d, 4);
        this.b = gVarA;
        e0Var.b();
        gVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e0Var.e, MimeTypes.APPLICATION_ID3, (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        if (z) {
            this.c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (this.c) {
            int i = nVar.c - nVar.b;
            int i2 = this.f;
            if (i2 < 10) {
                int iMin = Math.min(i, 10 - i2);
                System.arraycopy(nVar.f1472a, nVar.b, this.f1375a.f1472a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.f1375a.e(0);
                    if (73 == this.f1375a.j() && 68 == this.f1375a.j() && 51 == this.f1375a.j()) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.f1375a;
                        nVar2.e(nVar2.b + 3);
                        this.e = this.f1375a.i() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    }
                }
            }
            int iMin2 = Math.min(i, this.e - this.f);
            this.b.a(iMin2, nVar);
            this.f += iMin2;
        }
    }
}
