package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcly implements zzedi {
    private final zzebo zza;
    private final zzckz zzb;

    zzcly(zzckz zzckzVar, zzclw zzclwVar, zzebo zzeboVar) {
        this.zzb = zzckzVar;
        this.zza = zzeboVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedi
    public final zzebp zza() {
        zzckz zzckzVar = this.zzb;
        return zzebq.zza(zzcjv.zzd(zzckzVar.zzI()), zzckk.zzd(zzckzVar.zzI()), this.zza, zzbwo.zza());
    }
}
