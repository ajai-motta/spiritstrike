package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzco {
    public static final /* synthetic */ int zza = 0;
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    public static final void zza(int i, long j) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer numValueOf = Integer.valueOf(i);
        Object zzcnVar = concurrentHashMap.get(numValueOf);
        if (zzcnVar == null) {
            zzcnVar = new zzcn();
        }
        zzcn zzcnVar2 = (zzcn) zzcnVar;
        zzcnVar2.zzg(zzcnVar2.zzb() + 1);
        zzcnVar2.zzf(zzcnVar2.zzd() + j);
        zzcnVar2.zze(Math.max(j, zzcnVar2.zzc()));
        concurrentHashMap.put(numValueOf, zzcnVar2);
    }
}
