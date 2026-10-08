package com.bytedance.adsdk.ud;

import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class rdp<K, V> {
    private int jpc;
    private int lnr;
    private int mml;
    private int mo;
    private int mzz;
    private final LinkedHashMap<K, V> qdl;
    private int ud;
    private int wd;

    protected int ud(K k, V v) {
        return 1;
    }

    protected V ud(K k) {
        return null;
    }

    public rdp(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.lnr = i;
        this.qdl = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V qdl(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.qdl.get(k);
            if (v != null) {
                this.wd++;
                return v;
            }
            this.jpc++;
            V vUd = ud(k);
            if (vUd == null) {
                return null;
            }
            synchronized (this) {
                this.mzz++;
                vPut = this.qdl.put(k, vUd);
                if (vPut != null) {
                    this.qdl.put(k, vPut);
                } else {
                    this.ud += lnr(k, vUd);
                }
            }
            if (vPut != null) {
                return vPut;
            }
            qdl(this.lnr);
            return vUd;
        }
    }

    public final V qdl(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.mml++;
            this.ud += lnr(k, v);
            vPut = this.qdl.put(k, v);
            if (vPut != null) {
                this.ud -= lnr(k, vPut);
            }
        }
        qdl(this.lnr);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
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
            int r0 = r3.ud     // Catch: java.lang.Throwable -> L6d
            if (r0 < 0) goto L4e
            java.util.LinkedHashMap<K, V> r0 = r3.qdl     // Catch: java.lang.Throwable -> L6d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L11
            int r0 = r3.ud     // Catch: java.lang.Throwable -> L6d
            if (r0 != 0) goto L4e
        L11:
            int r0 = r3.ud     // Catch: java.lang.Throwable -> L6d
            if (r0 <= r4) goto L4c
            java.util.LinkedHashMap<K, V> r0 = r3.qdl     // Catch: java.lang.Throwable -> L6d
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L1e
            goto L4c
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r3.qdl     // Catch: java.lang.Throwable -> L6d
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L6d
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L6d
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L6d
            java.util.LinkedHashMap<K, V> r2 = r3.qdl     // Catch: java.lang.Throwable -> L6d
            r2.remove(r1)     // Catch: java.lang.Throwable -> L6d
            int r2 = r3.ud     // Catch: java.lang.Throwable -> L6d
            int r0 = r3.lnr(r1, r0)     // Catch: java.lang.Throwable -> L6d
            int r2 = r2 - r0
            r3.ud = r2     // Catch: java.lang.Throwable -> L6d
            int r0 = r3.mo     // Catch: java.lang.Throwable -> L6d
            int r0 = r0 + 1
            r3.mo = r0     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6d
            goto L0
        L4c:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L6d
            return
        L4e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r0.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L6d
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6d
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L6d
            throw r4     // Catch: java.lang.Throwable -> L6d
        L6d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.rdp.qdl(int):void");
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
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.lnr), Integer.valueOf(this.wd), Integer.valueOf(this.jpc), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
