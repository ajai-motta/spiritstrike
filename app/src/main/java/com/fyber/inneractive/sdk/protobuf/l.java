package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1564a = 0;
    public final int b;
    public final /* synthetic */ s c;

    public l(s sVar) {
        this.c = sVar;
        this.b = sVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1564a < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f1564a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f1564a = i + 1;
        return Byte.valueOf(this.c.d(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
