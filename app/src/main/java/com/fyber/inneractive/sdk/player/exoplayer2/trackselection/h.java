package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1431a;
    public final b[] b;
    public int c;

    public h(b... bVarArr) {
        this.b = bVarArr;
        this.f1431a = bVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((h) obj).b);
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.b) + 527;
        }
        return this.c;
    }
}
