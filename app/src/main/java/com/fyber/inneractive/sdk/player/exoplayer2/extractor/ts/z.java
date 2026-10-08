package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m f1384a = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(new byte[4]);
    public final /* synthetic */ b0 b;

    public z(b0 b0Var) {
        this.b = b0Var;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (nVar.j() != 0) {
            return;
        }
        nVar.e(nVar.b + 7);
        int i = (nVar.c - nVar.b) / 4;
        for (int i2 = 0; i2 < i; i2++) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = this.f1384a;
            nVar.a(mVar.f1471a, 0, 4);
            mVar.b(0);
            int iA = this.f1384a.a(16);
            this.f1384a.c(3);
            if (iA == 0) {
                this.f1384a.c(13);
            } else {
                int iA2 = this.f1384a.a(13);
                b0 b0Var = this.b;
                b0Var.f.put(iA2, new w(new a0(b0Var, iA2)));
                this.b.i++;
            }
        }
        b0 b0Var2 = this.b;
        if (b0Var2.f1359a != 2) {
            b0Var2.f.remove(0);
        }
    }
}
