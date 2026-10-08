package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class m4 implements Set, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f465a = new ArrayList();
    private final HashSet b = new HashSet();

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(Comparable comparable) {
        if (contains(comparable)) {
            return false;
        }
        if (isEmpty() || comparable.compareTo(a()) > 0) {
            this.f465a.add(comparable);
        } else {
            this.f465a.add(b(comparable), comparable);
        }
        return this.b.add(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (add((Comparable) it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public Comparable b(int i) {
        Comparable comparable = (Comparable) this.f465a.remove(i);
        this.b.remove(comparable);
        return comparable;
    }

    public int c(Comparable comparable) {
        int iBinarySearch = Collections.binarySearch(this.f465a, comparable);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableA = a(iBinarySearch);
        while (iBinarySearch < size() && comparableA == a(iBinarySearch)) {
            iBinarySearch++;
        }
        return iBinarySearch;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f465a.clear();
        this.b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.b.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.b.containsAll(collection);
    }

    public int d(Comparable comparable) {
        if (comparable == null || !contains(comparable)) {
            return -1;
        }
        return b(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f465a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f465a.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int iD = d((Comparable) obj);
        if (iD == -1) {
            return false;
        }
        this.f465a.remove(iD);
        return this.b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.f465a.get(size);
            if (!collection.contains(comparable)) {
                this.f465a.remove(size);
                this.b.remove(comparable);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f465a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.f465a.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f465a.toArray(objArr);
    }

    public int b(Comparable comparable) {
        int iBinarySearch = Collections.binarySearch(this.f465a, comparable);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableA = a(iBinarySearch);
        while (iBinarySearch >= 0 && comparableA == a(iBinarySearch)) {
            iBinarySearch--;
        }
        return iBinarySearch + 1;
    }

    public Comparable a(int i) {
        return (Comparable) this.f465a.get(i);
    }

    public void a(int i, Comparable comparable) {
        this.b.remove((Comparable) this.f465a.get(i));
        this.f465a.set(i, comparable);
        this.b.add(comparable);
    }

    public Comparable a() {
        return (Comparable) this.f465a.get(size() - 1);
    }
}
