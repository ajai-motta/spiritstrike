package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclu implements zzfeb {
    final zzifq zza;
    final zzifq zzb;
    final zzifq zzc;
    final zzifq zzd;
    final zzifq zze;
    final zzifq zzf;
    final zzifq zzg;
    private final zzckz zzh;

    zzclu(zzckz zzckzVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzh = zzckzVar;
        zzifh zzifhVarZza = zzifi.zza(context);
        this.zza = zzifhVarZza;
        zzifh zzifhVarZza2 = zzifi.zza(zzrVar);
        this.zzb = zzifhVarZza2;
        zzifh zzifhVarZza3 = zzifi.zza(str);
        this.zzc = zzifhVarZza3;
        zzifq zzifqVar = zzckzVar.zzl;
        zzifq zzifqVarZza = zzifg.zza(zzeou.zza(zzifqVar));
        this.zzd = zzifqVarZza;
        zzifq zzifqVarZza2 = zzifg.zza(zzfez.zza(zzckzVar.zzbs));
        this.zze = zzifqVarZza2;
        zzifq zzifqVarZza3 = zzifg.zza(zzfdz.zza(zzifhVarZza, zzckzVar.zza, zzckzVar.zzV, zzifqVarZza, zzifqVarZza2, zzfgp.zza()));
        this.zzf = zzifqVarZza3;
        this.zzg = zzifg.zza(zzepc.zza(zzifhVarZza, zzifhVarZza2, zzifhVarZza3, zzifqVarZza3, zzifqVarZza, zzifqVarZza2, zzckzVar.zzi, zzckzVar.zzY, zzifqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzfeb
    public final zzepb zza() {
        return (zzepb) this.zzg.zzb();
    }
}
