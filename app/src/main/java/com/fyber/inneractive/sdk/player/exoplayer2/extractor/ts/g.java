package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1367a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[] b;
    public boolean c;
    public int d;
    public int e;
    public long f;

    public g(List list) {
        this.f1367a = list;
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[list.size()];
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.c = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
        if (this.c) {
            for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar : this.b) {
                rVar.a(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        for (int i = 0; i < this.b.length; i++) {
            c0 c0Var = (c0) this.f1367a.get(i);
            e0Var.a();
            e0Var.b();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e0Var.d, 3);
            e0Var.b();
            gVarA.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(e0Var.e, null, MimeTypes.APPLICATION_DVBSUBS, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, c0Var.f1361a, -1, Long.MAX_VALUE, Collections.singletonList(c0Var.b), null, null));
            this.b[i] = gVarA;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        if (z) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (this.c) {
            if (this.d == 2) {
                if (nVar.c - nVar.b == 0) {
                    return;
                }
                if (nVar.j() != 32) {
                    this.c = false;
                }
                this.d--;
                if (!this.c) {
                    return;
                }
            }
            if (this.d == 1) {
                if (nVar.c - nVar.b == 0) {
                    return;
                }
                if (nVar.j() != 0) {
                    this.c = false;
                }
                this.d--;
                if (!this.c) {
                    return;
                }
            }
            int i = nVar.b;
            int i2 = nVar.c - i;
            for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar : this.b) {
                nVar.e(i);
                rVar.a(i2, nVar);
            }
            this.e += i2;
        }
    }
}
