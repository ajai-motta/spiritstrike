package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvh extends zzym {
    private final zzbg zza;

    public zzvh(zzyk zzykVar, zzbg zzbgVar) {
        super(zzykVar);
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof zzvh)) {
            return this.zza.equals(((zzvh) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final int hashCode() {
        return (super.hashCode() * 31) + this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzym, com.google.android.gms.internal.ads.zzyp
    public final zzbg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzym, com.google.android.gms.internal.ads.zzyp
    public final zzv zzb(int i) {
        return this.zza.zza(zzd().zzf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzym, com.google.android.gms.internal.ads.zzyk
    public final zzv zzc() {
        return this.zza.zza(zzd().zzh());
    }
}
