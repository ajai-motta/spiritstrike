package com.fyber.inneractive.sdk.player.cache;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1229a;
    public final long[] b;
    public boolean c;
    public d d;
    public final /* synthetic */ g e;

    public e(g gVar, String str) {
        this.e = gVar;
        this.f1229a = str;
        this.b = new long[gVar.g];
    }

    public final File a(int i) {
        return new File(this.e.f1230a, this.f1229a + "." + i);
    }

    public final File b(int i) {
        return new File(this.e.f1230a, this.f1229a + "." + i + ".tmp");
    }
}
