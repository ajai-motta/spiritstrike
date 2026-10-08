package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class q3 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f1575a;

    public q3(r3 r3Var) {
        this.f1575a = r3Var.f1578a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1575a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f1575a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
