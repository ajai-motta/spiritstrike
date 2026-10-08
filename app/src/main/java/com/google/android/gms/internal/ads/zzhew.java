package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhew {
    private static final zzhew zza = new zzhew();
    private static final zzhev zzb = new zzhev(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzhew zza() {
        return zza;
    }

    public final zzhen zzb() {
        zzhen zzhenVar = (zzhen) this.zzc.get();
        return zzhenVar == null ? zzb : zzhenVar;
    }
}
