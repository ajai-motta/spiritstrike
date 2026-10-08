package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzctg {
    private final zzdbp zza;
    private final zzddu zzb;

    public zzctg(zzdbp zzdbpVar, zzddu zzdduVar) {
        this.zza = zzdbpVar;
        this.zzb = zzdduVar;
    }

    public final zzdbp zza() {
        return this.zza;
    }

    final zzdgn zzb() {
        zzddu zzdduVar = this.zzb;
        return zzdduVar != null ? new zzdgn(zzdduVar, zzcbv.zzg) : new zzdgn(new zzctf(this), zzcbv.zzg);
    }

    final zzddu zzc() {
        return this.zzb;
    }
}
