package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1455a;
    public final m b;
    public final g c;

    public o(Context context, m mVar, q qVar) {
        this.f1455a = context.getApplicationContext();
        this.b = mVar;
        this.c = qVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public final h a() {
        return new n(this.f1455a, this.b, this.c.a());
    }
}
