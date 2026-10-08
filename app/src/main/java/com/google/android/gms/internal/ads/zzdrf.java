package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdrf implements zzbmp {
    private final zzczv zza;
    private final zzbyh zzb;
    private final String zzc;
    private final String zzd;

    public zzdrf(zzczv zzczvVar, zzffu zzffuVar) {
        this.zza = zzczvVar;
        this.zzb = zzffuVar.zzl;
        this.zzc = zzffuVar.zzj;
        this.zzd = zzffuVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zza() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    @ParametersAreNonnullByDefault
    public final void zzb(zzbyh zzbyhVar) {
        int i;
        String str;
        zzbyh zzbyhVar2 = this.zzb;
        if (zzbyhVar2 != null) {
            zzbyhVar = zzbyhVar2;
        }
        if (zzbyhVar != null) {
            str = zzbyhVar.zza;
            i = zzbyhVar.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zze(new zzbxs(str, i), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzc() {
        this.zza.zzf();
    }
}
