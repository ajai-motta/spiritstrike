package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzul {
    private static final AtomicLong zza = new AtomicLong();

    public zzul(long j, zzgf zzgfVar, long j2) {
        Uri uri = zzgfVar.zza;
        Collections.emptyMap();
    }

    public zzul(long j, zzgf zzgfVar, Uri uri, Map map, long j2, long j3, long j4) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }
}
