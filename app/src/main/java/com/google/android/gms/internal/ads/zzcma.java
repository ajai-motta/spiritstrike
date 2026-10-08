package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcma implements zzffo {
    final zzifq zza;
    final zzifq zzb;
    final zzifq zzc;
    final zzifq zzd;
    final zzifq zze;
    final zzifq zzf;
    final zzifq zzg;
    final zzifq zzh;
    private final zzckz zzi;

    zzcma(zzckz zzckzVar, Context context, String str) {
        this.zzi = zzckzVar;
        zzifh zzifhVarZza = zzifi.zza(context);
        this.zza = zzifhVarZza;
        zzifq zzifqVar = zzckzVar.zzbs;
        zzfdp zzfdpVarZzc = zzfdp.zzc(zzifhVarZza, zzifqVar, zzckzVar.zzbt);
        this.zzb = zzfdpVarZzc;
        zzifq zzifqVarZza = zzifg.zza(zzfez.zza(zzifqVar));
        this.zzc = zzifqVarZza;
        zzifq zzifqVarZza2 = zzifg.zza(zzfgl.zza());
        this.zzd = zzifqVarZza2;
        zzifq zzifqVarZza3 = zzifg.zza(zzffi.zza(zzifhVarZza, zzckzVar.zza, zzckzVar.zzV, zzfdpVarZzc, zzifqVarZza, zzfgp.zza(), zzifqVarZza2));
        this.zze = zzifqVarZza3;
        this.zzf = zzifg.zza(zzffs.zza(zzifqVarZza3, zzifqVarZza, zzifqVarZza2));
        zzifh zzifhVarZzc = zzifi.zzc(str);
        this.zzg = zzifhVarZzc;
        this.zzh = zzifg.zza(zzffm.zza(zzifhVarZzc, zzifqVarZza3, zzifhVarZza, zzifqVarZza, zzifqVarZza2, zzckzVar.zzi, zzckzVar.zzY, zzckzVar.zzl));
    }

    @Override // com.google.android.gms.internal.ads.zzffo
    public final zzffr zza() {
        return (zzffr) this.zzf.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzffo
    public final zzffl zzb() {
        return (zzffl) this.zzh.zzb();
    }
}
