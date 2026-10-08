package com.bytedance.sdk.component.mzz.lnr.qdl;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class lnr<K, V> {
    private int jpc;
    private int lnr;
    private int mml;
    private int mo;
    private int mzz;
    private final LinkedHashMap<K, SoftReference<V>> qdl;
    private int ud;
    private int wd;

    protected int ud(K k, V v) {
        return 1;
    }

    protected V ud(K k) {
        return null;
    }

    public lnr(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.lnr = i;
        this.qdl = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V qdl(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.qdl.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.wd++;
                    return v;
                }
                this.qdl.remove(k);
            } else {
                v = null;
            }
            this.jpc++;
            V vUd = ud(k);
            if (vUd == null) {
                return null;
            }
            synchronized (this) {
                this.mzz++;
                SoftReference<V> softReferencePut = this.qdl.put(k, new SoftReference<>(vUd));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.qdl.put(k, softReferencePut);
                } else {
                    this.ud += lnr(k, vUd);
                }
            }
            if (v != null) {
                return v;
            }
            qdl(this.lnr);
            return vUd;
        }
    }

    public final V qdl(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.mml++;
            this.ud += lnr(k, v);
            SoftReference<V> softReferencePut = this.qdl.put(k, new SoftReference<>(v));
            if (softReferencePut != null) {
                v2 = softReferencePut.get();
                if (v2 != null) {
                    this.ud -= lnr(k, v2);
                }
            } else {
                v2 = null;
            }
        }
        qdl(this.lnr);
        return v2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r3.ud + ", maxSize: " + r4);
        r3.ud = 0;
        r3.qdl.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.ud     // Catch: java.lang.Throwable -> L79
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.qdl     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L12
            int r0 = r3.ud     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L12
            goto L52
        L12:
            int r0 = r3.ud     // Catch: java.lang.Throwable -> L79
            if (r0 > r4) goto L18
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L79
            return
        L18:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.qdl     // Catch: java.lang.Throwable -> L79
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L79
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L79
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L2c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L79
            return
        L2c:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L79
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L79
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.qdl     // Catch: java.lang.Throwable -> L79
            r2.remove(r1)     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L79
            int r2 = r3.ud     // Catch: java.lang.Throwable -> L79
            int r0 = r3.lnr(r1, r0)     // Catch: java.lang.Throwable -> L79
            int r2 = r2 - r0
            r3.ud = r2     // Catch: java.lang.Throwable -> L79
        L4a:
            int r0 = r3.mo     // Catch: java.lang.Throwable -> L79
            int r0 = r0 + 1
            r3.mo = r0     // Catch: java.lang.Throwable -> L79
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L79
            goto L0
        L52:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L79
            int r2 = r3.ud     // Catch: java.lang.Throwable -> L79
            r1.append(r2)     // Catch: java.lang.Throwable -> L79
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L79
            r1.append(r4)     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L79
            android.util.Log.e(r0, r4)     // Catch: java.lang.Throwable -> L79
            r4 = 0
            r3.ud = r4     // Catch: java.lang.Throwable -> L79
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.qdl     // Catch: java.lang.Throwable -> L79
            r4.clear()     // Catch: java.lang.Throwable -> L79
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L79
            return
        L79:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mzz.lnr.qdl.lnr.qdl(int):void");
    }

    private int lnr(K k, V v) {
        int iUd = ud(k, v);
        if (iUd >= 0) {
            return iUd;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.wd;
        i2 = this.jpc + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.lnr), Integer.valueOf(this.wd), Integer.valueOf(this.jpc), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
