package com.google.android.gms.internal.gtm;

import java.io.Closeable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwg implements Closeable {
    private static final ThreadLocal zza = new zzwf();
    private int zzb = 0;

    public static int zza() {
        return ((zzwg) zza.get()).zzb;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.zzb;
        if (i <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i - 1;
    }
}
