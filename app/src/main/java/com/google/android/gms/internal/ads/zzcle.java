package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcle implements zzfay {
    final zzifq zza;
    final zzifq zzb;
    final zzifq zzc;
    final zzifq zzd;
    final zzifq zze;
    final zzifq zzf;
    private final zzckz zzg;

    zzcle(zzckz zzckzVar, Context context, String str) {
        this.zzg = zzckzVar;
        zzifh zzifhVarZza = zzifi.zza(context);
        this.zza = zzifhVarZza;
        zzifh zzifhVarZza2 = zzifi.zza(str);
        this.zzb = zzifhVarZza2;
        zzifq zzifqVar = zzckzVar.zzbs;
        zzfdo zzfdoVarZzc = zzfdo.zzc(zzifhVarZza, zzifqVar, zzckzVar.zzbt);
        this.zzc = zzfdoVarZzc;
        zzifq zzifqVarZza = zzifg.zza(zzfbv.zza(zzifqVar));
        this.zzd = zzifqVarZza;
        zzifq zzifqVar2 = zzckzVar.zza;
        zzifq zzifqVar3 = zzckzVar.zzV;
        zzfgp zzfgpVarZza = zzfgp.zza();
        zzifq zzifqVar4 = zzckzVar.zzi;
        zzifq zzifqVarZza2 = zzifg.zza(zzfbx.zza(zzifhVarZza, zzifqVar2, zzifqVar3, zzfdoVarZzc, zzifqVarZza, zzfgpVarZza, zzifqVar4));
        this.zze = zzifqVarZza2;
        this.zzf = zzifg.zza(zzfcd.zza(zzifqVar3, zzifhVarZza, zzifhVarZza2, zzifqVarZza2, zzifqVarZza, zzifqVar4, zzckzVar.zzl));
    }

    @Override // com.google.android.gms.internal.ads.zzfay
    public final zzfcc zza() {
        return (zzfcc) this.zzf.zzb();
    }
}
