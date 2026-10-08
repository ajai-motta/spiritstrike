package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f1327a;
    public final int b;
    public final int c;
    public int d;
    public int e;

    public h(b bVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = bVar.P0;
        this.f1327a = nVar;
        nVar.e(12);
        this.c = nVar.m() & 255;
        this.b = nVar.m();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e
    public final int a() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e
    public final int b() {
        int i = this.c;
        if (i == 8) {
            return this.f1327a.j();
        }
        if (i == 16) {
            return this.f1327a.o();
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.e & 15;
        }
        int iJ = this.f1327a.j();
        this.e = iJ;
        return (iJ & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e
    public final boolean c() {
        return false;
    }
}
