package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzym implements zzyk {
    private final zzyk zza;

    public zzym(zzyk zzykVar) {
        this.zza = zzykVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzym) {
            return this.zza.equals(((zzym) obj).zza);
        }
        return false;
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public zzbg zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public zzv zzb(int i) {
        return this.zza.zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzyk
    public zzv zzc() {
        return this.zza.zzc();
    }

    public final zzyk zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzf(int i) {
        return this.zza.zzf(i);
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzg(int i) {
        return this.zza.zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzyk
    public final int zzh() {
        return this.zza.zzh();
    }
}
