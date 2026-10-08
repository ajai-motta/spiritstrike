package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaia {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzeg zzf;
    private final zzeg zzg;
    private int zzh;
    private int zzi;

    public zzaia(zzeg zzegVar, zzeg zzegVar2, boolean z) throws zzat {
        this.zzg = zzegVar;
        this.zzf = zzegVar2;
        this.zze = z;
        zzegVar2.zzh(12);
        this.zza = zzegVar2.zzH();
        zzegVar.zzh(12);
        this.zzi = zzegVar.zzH();
        zzade.zza(zzegVar.zzB() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        this.zzd = this.zze ? this.zzf.zzJ() : this.zzf.zzz();
        if (this.zzb == this.zzh) {
            zzeg zzegVar = this.zzg;
            this.zzc = zzegVar.zzH();
            zzegVar.zzk(4);
            int i2 = this.zzi - 1;
            this.zzi = i2;
            this.zzh = i2 > 0 ? (-1) + zzegVar.zzH() : -1;
        }
        return true;
    }
}
