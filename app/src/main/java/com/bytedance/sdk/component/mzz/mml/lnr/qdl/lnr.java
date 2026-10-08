package com.bytedance.sdk.component.mzz.mml.lnr.qdl;

import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class lnr<K, V> {
    private final LinkedHashMap<K, SoftReference<V>> qdl = new LinkedHashMap<>(0, 0.75f, true);
    private int ud;

    public lnr(int i) {
        this.ud = i;
    }

    public synchronized V qdl(K k) {
        V v = null;
        if (k == null) {
            return null;
        }
        if (this.ud <= 0) {
            return null;
        }
        SoftReference<V> softReference = this.qdl.get(k);
        if (softReference != null) {
            v = softReference.get();
            if (v != null) {
                return v;
            }
            this.qdl.remove(k);
        }
        return v;
    }

    public synchronized void qdl(K k, V v) {
        if (this.ud <= 0) {
            return;
        }
        if (k == null || v == null) {
            return;
        }
        this.qdl.put(k, new SoftReference<>(v));
        int size = this.qdl.size();
        int i = this.ud;
        if (size > i) {
            qdl((int) (((double) i) * 0.7d));
        }
    }

    public synchronized void qdl(int i) {
        int size = this.qdl.size() - i;
        if (size > 0) {
            Iterator<Map.Entry<K, SoftReference<V>>> it = this.qdl.entrySet().iterator();
            for (int i2 = 0; i2 < size; i2++) {
                it.next();
                it.remove();
            }
        }
        if (i == 0) {
            return;
        }
        Iterator<Map.Entry<K, SoftReference<V>>> it2 = this.qdl.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getValue().get() == null) {
                it2.remove();
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxCount=%d,size=%d]", Integer.valueOf(this.ud), Integer.valueOf(this.qdl.size()));
    }
}
