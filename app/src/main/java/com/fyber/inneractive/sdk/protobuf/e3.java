package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e3 extends AbstractMap {
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1549a;
    public boolean d;
    public volatile d3 e;
    public volatile x2 g;
    public List b = Collections.emptyList();
    public Map c = Collections.emptyMap();
    public Map f = Collections.emptyMap();

    public e3(int i) {
        this.f1549a = i;
    }

    public final Object a(Comparable comparable, Object obj) {
        a();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((b3) this.b.get(iA)).setValue(obj);
        }
        a();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.f1549a);
        }
        int i = -(iA + 1);
        if (i >= this.f1549a) {
            return c().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.f1549a;
        if (size == i2) {
            b3 b3Var = (b3) this.b.remove(i2 - 1);
            c().put(b3Var.f1541a, b3Var.b);
        }
        this.b.add(i, new b3(this, comparable, obj));
        return null;
    }

    public final Iterable b() {
        return this.c.isEmpty() ? a3.b : this.c.entrySet();
    }

    public final SortedMap c() {
        a();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        a();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new d3(this);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e3)) {
            return super.equals(obj);
        }
        e3 e3Var = (e3) obj;
        int size = size();
        if (size != e3Var.size()) {
            return false;
        }
        int size2 = this.b.size();
        if (size2 != e3Var.b.size()) {
            return entrySet().equals(e3Var.entrySet());
        }
        for (int i = 0; i < size2; i++) {
            if (!((Map.Entry) this.b.get(i)).equals((Map.Entry) e3Var.b.get(i))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.c.equals(e3Var.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((b3) this.b.get(iA)).b : this.c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.b.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((b3) this.b.get(i)).hashCode();
        }
        return this.c.size() > 0 ? iHashCode + this.c.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        a();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA < 0) {
            if (this.c.isEmpty()) {
                return null;
            }
            return this.c.remove(comparable);
        }
        a();
        Object obj2 = ((b3) this.b.remove(iA)).b;
        if (!this.c.isEmpty()) {
            Iterator it = c().entrySet().iterator();
            this.b.add(new b3(this, (Map.Entry) it.next()));
            it.remove();
        }
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.c.size() + this.b.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            com.fyber.inneractive.sdk.protobuf.b3 r2 = (com.fyber.inneractive.sdk.protobuf.b3) r2
            java.lang.Comparable r2 = r2.f1541a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L41
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.b
            java.lang.Object r3 = r3.get(r2)
            com.fyber.inneractive.sdk.protobuf.b3 r3 = (com.fyber.inneractive.sdk.protobuf.b3) r3
            java.lang.Comparable r3 = r3.f1541a
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3b
            int r1 = r2 + (-1)
            goto L22
        L3b:
            if (r3 <= 0) goto L40
            int r0 = r2 + 1
            goto L22
        L40:
            return r2
        L41:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.e3.a(java.lang.Comparable):int");
    }

    public final void a() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }
}
