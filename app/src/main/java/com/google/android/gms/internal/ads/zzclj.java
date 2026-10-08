package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclj implements zzfcl {
    final zzifq zza;
    final zzifq zzb;
    final zzifq zzc;
    final zzifq zzd;
    final zzifq zze;
    final zzifq zzf;
    private final Context zzg;
    private final com.google.android.gms.ads.internal.client.zzr zzh;
    private final String zzi;
    private final zzckz zzj;

    zzclj(zzckz zzckzVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzj = zzckzVar;
        this.zzg = context;
        this.zzh = zzrVar;
        this.zzi = str;
        zzifh zzifhVarZza = zzifi.zza(context);
        this.zza = zzifhVarZza;
        zzifh zzifhVarZza2 = zzifi.zza(zzrVar);
        this.zzb = zzifhVarZza2;
        zzifq zzifqVarZza = zzifg.zza(zzeou.zza(zzckzVar.zzl));
        this.zzc = zzifqVarZza;
        zzifq zzifqVarZza2 = zzifg.zza(zzeoz.zza());
        this.zzd = zzifqVarZza2;
        zzifq zzifqVarZza3 = zzifg.zza(zzddw.zza());
        this.zze = zzifqVarZza3;
        this.zzf = zzifg.zza(zzfcj.zza(zzifhVarZza, zzckzVar.zza, zzifhVarZza2, zzckzVar.zzV, zzifqVarZza, zzifqVarZza2, zzfgp.zza(), zzifqVarZza3));
    }

    @Override // com.google.android.gms.internal.ads.zzfcl
    public final zzeny zza() {
        zzfci zzfciVar = (zzfci) this.zzf.zzb();
        zzeot zzeotVar = (zzeot) this.zzc.zzb();
        zzckz zzckzVar = this.zzj;
        zzifq zzifqVar = zzckzVar.zzl;
        return new zzeny(this.zzg, this.zzh, this.zzi, zzfciVar, zzeotVar, zzckk.zzd(zzckzVar.zzI()), (zzdvi) zzifqVar.zzb());
    }
}
