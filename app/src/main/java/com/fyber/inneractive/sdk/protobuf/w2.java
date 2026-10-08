package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class w2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1587a;
    public Iterator b;
    public final /* synthetic */ e3 c;

    public w2(e3 e3Var) {
        this.c = e3Var;
        this.f1587a = e3Var.b.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f1587a;
        if (i <= 0 || i > this.c.b.size()) {
            if (this.b == null) {
                this.b = this.c.f.entrySet().iterator();
            }
            if (!this.b.hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        if (this.b.hasNext()) {
            if (this.b == null) {
                this.b = this.c.f.entrySet().iterator();
            }
            return (Map.Entry) this.b.next();
        }
        List list = this.c.b;
        int i = this.f1587a - 1;
        this.f1587a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
