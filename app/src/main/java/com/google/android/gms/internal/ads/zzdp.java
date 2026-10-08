package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdp {
    public final Object zza;
    private zzr zzb = new zzr();
    private boolean zzc;
    private boolean zzd;

    public zzdp(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzdp) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzdo zzdoVar) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzdoVar.zza(this.zza, this.zzb.zzb());
        }
    }

    public final void zzb(int i, zzdn zzdnVar) {
        if (this.zzd) {
            return;
        }
        if (i != -1) {
            this.zzb.zza(i);
        }
        this.zzc = true;
        zzdnVar.zza(this.zza);
    }

    public final void zzc(zzdo zzdoVar) {
        if (this.zzd || !this.zzc) {
            return;
        }
        zzs zzsVarZzb = this.zzb.zzb();
        this.zzb = new zzr();
        this.zzc = false;
        zzdoVar.zza(this.zza, zzsVarZzb);
    }
}
