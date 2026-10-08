package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a {
    public byte[] i;
    public int j;
    public volatile boolean k;
    public final String l;
    public byte[] m;

    public c(com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i, Object obj, byte[] bArr, String str) {
        super(3, i, C.TIME_UNSET, C.TIME_UNSET, oVar, hVar, kVar, obj);
        this.i = bArr;
        this.l = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.k;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.k = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a
    public final long c() {
        return this.j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void load() {
        try {
            this.h.a(this.f1410a);
            this.j = 0;
            while (!this.k) {
                byte[] bArr = this.i;
                if (bArr == null) {
                    this.i = new byte[16384];
                } else if (bArr.length < this.j + 16384) {
                    this.i = Arrays.copyOf(bArr, bArr.length + 16384);
                }
                int i = this.h.read(this.i, this.j, 16384);
                if (i != -1) {
                    this.j += i;
                }
                if (i == -1) {
                    break;
                }
            }
            if (!this.k) {
                this.m = Arrays.copyOf(this.i, this.j);
            }
        } finally {
            z.a(this.h);
        }
    }
}
