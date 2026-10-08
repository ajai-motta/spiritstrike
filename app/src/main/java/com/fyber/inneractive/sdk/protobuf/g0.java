package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1554a;
    public final int b;

    public g0(int i, Object obj) {
        this.f1554a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f1554a == g0Var.f1554a && this.b == g0Var.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f1554a) * 65535) + this.b;
    }
}
