package com.fyber.inneractive.sdk.player.exoplayer2.source;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1425a;
    public final y[] b;
    public int c;

    static {
        new z(new y[0]);
    }

    public z(y... yVarArr) {
        this.b = yVarArr;
        this.f1425a = yVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f1425a == zVar.f1425a && Arrays.equals(this.b, zVar.b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b);
        }
        return this.c;
    }
}
