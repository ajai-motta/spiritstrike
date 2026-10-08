package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.exoplayer2.util.v f1383a;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        this.f1383a = vVar;
        e0Var.a();
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e0Var.d, 4);
        this.b = gVarA;
        e0Var.b();
        gVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e0Var.e, MimeTypes.APPLICATION_SCTE35, (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        long j;
        long j2;
        boolean z = this.c;
        long j3 = C.TIME_UNSET;
        if (!z) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar = this.f1383a;
            long j4 = 0;
            if ((vVar.f1478a == Long.MAX_VALUE ? 0L : vVar.c == C.TIME_UNSET ? -9223372036854775807L : vVar.b) == C.TIME_UNSET) {
                return;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = this.b;
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar2 = this.f1383a;
            if (vVar2.f1478a == Long.MAX_VALUE) {
                j2 = j4;
                rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(null, null, MimeTypes.APPLICATION_SCTE35, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null));
                this.c = true;
            } else if (vVar2.c == C.TIME_UNSET) {
                j2 = -9223372036854775807L;
                rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(null, null, MimeTypes.APPLICATION_SCTE35, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null));
                this.c = true;
            } else {
                j4 = vVar2.b;
                j2 = j4;
                rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(null, null, MimeTypes.APPLICATION_SCTE35, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null));
                this.c = true;
            }
        }
        int i = nVar.c - nVar.b;
        this.b.a(i, nVar);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar2 = this.b;
        com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar3 = this.f1383a;
        if (vVar3.c != C.TIME_UNSET) {
            j3 = vVar3.c;
        } else {
            long j5 = vVar3.f1478a;
            if (j5 != Long.MAX_VALUE) {
                j = j5;
            }
            rVar2.a(j, 1, i, 0, null);
        }
        j = j3;
        rVar2.a(j, 1, i, 0, null);
    }
}
