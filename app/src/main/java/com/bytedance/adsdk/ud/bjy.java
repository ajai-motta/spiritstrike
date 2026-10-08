package com.bytedance.adsdk.ud;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class bjy<K, V> {
    bjy<K, V>.ud ud;

    protected abstract void lnr();

    protected abstract int qdl();

    protected abstract int qdl(Object obj);

    protected abstract Object qdl(int i, int i2);

    protected abstract void qdl(int i);

    protected abstract Map<K, V> ud();

    bjy() {
    }

    final class qdl<T> implements Iterator<T> {
        int lnr;
        boolean mml = false;
        final int qdl;
        int ud;

        qdl(int i) {
            this.qdl = i;
            this.ud = bjy.this.qdl();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.lnr < this.ud;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) bjy.this.qdl(this.lnr, this.qdl);
            this.lnr++;
            this.mml = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.mml) {
                throw new IllegalStateException();
            }
            int i = this.lnr - 1;
            this.lnr = i;
            this.ud--;
            this.mml = false;
            bjy.this.qdl(i);
        }
    }

    final class ud implements Set<K> {
        ud() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            bjy.this.lnr();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return bjy.this.qdl(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return bjy.qdl(bjy.this.ud(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return bjy.this.qdl() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new qdl(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iQdl = bjy.this.qdl(obj);
            if (iQdl < 0) {
                return false;
            }
            bjy.this.qdl(iQdl);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return bjy.ud(bjy.this.ud(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return bjy.lnr(bjy.this.ud(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return bjy.this.qdl();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return bjy.this.ud(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) bjy.this.qdl(tArr, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return bjy.qdl(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iQdl = bjy.this.qdl() - 1; iQdl >= 0; iQdl--) {
                Object objQdl = bjy.this.qdl(iQdl, 0);
                iHashCode += objQdl == null ? 0 : objQdl.hashCode();
            }
            return iHashCode;
        }
    }

    public static <K, V> boolean qdl(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean ud(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean lnr(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public Object[] ud(int i) {
        int iQdl = qdl();
        Object[] objArr = new Object[iQdl];
        for (int i2 = 0; i2 < iQdl; i2++) {
            objArr[i2] = qdl(i2, i);
        }
        return objArr;
    }

    public <T> T[] qdl(T[] tArr, int i) {
        int iQdl = qdl();
        if (tArr.length < iQdl) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iQdl));
        }
        for (int i2 = 0; i2 < iQdl; i2++) {
            tArr[i2] = qdl(i2, i);
        }
        if (tArr.length > iQdl) {
            tArr[iQdl] = null;
        }
        return tArr;
    }

    public static <T> boolean qdl(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public Set<K> mml() {
        if (this.ud == null) {
            this.ud = new ud();
        }
        return this.ud;
    }
}
