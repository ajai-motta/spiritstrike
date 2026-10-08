package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.google.android.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1421a;
    public final /* synthetic */ p b;

    public o(p pVar, int i) {
        this.b = pVar;
        this.f1421a = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.v
    public final void a() throws IOException {
        this.b.i.b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.v
    public final boolean isReady() {
        boolean z;
        p pVar = this.b;
        int i = this.f1421a;
        if (pVar.F) {
            return true;
        }
        if (pVar.D == C.TIME_UNSET) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.e eVar = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) pVar.o.valueAt(i)).c;
            synchronized (eVar) {
                z = eVar.i == 0;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.v
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.p pVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar, boolean z) {
        p pVar2 = this.b;
        int i = this.f1421a;
        if (pVar2.u || pVar2.D != C.TIME_UNSET) {
            return -3;
        }
        return ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) pVar2.o.valueAt(i)).a(pVar, cVar, z, pVar2.F, pVar2.C);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.v
    public final void a(long j) {
        p pVar = this.b;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) pVar.o.valueAt(this.f1421a);
        if (pVar.F && j > gVar.d()) {
            gVar.f();
        } else {
            gVar.a(true, j);
        }
    }
}
