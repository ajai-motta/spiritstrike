package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1654a;
    public int b;

    public h1(int i, int i2) {
        this.f1654a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h1.class != obj.getClass()) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return this.f1654a == h1Var.f1654a && this.b == h1Var.b;
    }

    public final int hashCode() {
        return (this.f1654a * 31) + this.b;
    }
}
