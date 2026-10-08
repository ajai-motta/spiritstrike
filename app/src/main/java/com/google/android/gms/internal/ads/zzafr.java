package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzafr {
    protected final zzaem zza;

    protected zzafr(zzaem zzaemVar) {
        this.zza = zzaemVar;
    }

    protected abstract boolean zza(zzeg zzegVar) throws zzat;

    protected abstract boolean zzb(zzeg zzegVar, long j) throws zzat;

    public final boolean zzf(zzeg zzegVar, long j) throws zzat {
        return zza(zzegVar) && zzb(zzegVar, j);
    }
}
