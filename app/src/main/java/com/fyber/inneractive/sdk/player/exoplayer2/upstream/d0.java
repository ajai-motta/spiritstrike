package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1446a;
    public final h b;
    public final c0 c;
    public volatile com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e d;
    public volatile boolean e;
    public volatile long f;

    public d0(h hVar, Uri uri, c0 c0Var) {
        this.b = hVar;
        this.f1446a = new k(uri, 0L, 0L, -1L, null, 1);
        this.c = c0Var;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.e = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void load() {
        j jVar = new j(this.b, this.f1446a);
        try {
            jVar.f1450a.a(jVar.b);
            jVar.d = true;
            this.d = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.g) this.c).a(this.b.a(), jVar);
        } finally {
            this.f = jVar.f;
            com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(jVar);
        }
    }
}
