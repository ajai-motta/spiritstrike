package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfyf implements zzgat {
    final zzifq zza;
    final zzifq zzb;
    final zzifq zzc;
    final zzifq zzd;
    final zzifq zze;
    private final zzfxz zzf;
    private final zzfyf zzg = this;

    zzfyf(zzfxz zzfxzVar) {
        this.zzf = zzfxzVar;
        zzifq zzifqVarZza = zzifg.zza(zzgaw.zza());
        this.zza = zzifqVarZza;
        zzifq zzifqVarZza2 = zzifg.zza(zzgcg.zza(zzfxzVar.zza, zzfxzVar.zzc, zzfxzVar.zzD, zzifqVarZza, zzfxzVar.zzG, zzfxzVar.zzr, zzfxzVar.zzh, zzgcj.zza()));
        this.zzb = zzifqVarZza2;
        zzifq zzifqVarZza3 = zzifg.zza(zzgbb.zza());
        this.zzc = zzifqVarZza3;
        zzfye zzfyeVar = new zzfye(this);
        this.zzd = zzfyeVar;
        this.zze = zzifg.zza(zzgau.zza(zzfxzVar.zzc, zzifqVarZza2, zzfxzVar.zzD, zzfxzVar.zzC, zzifqVarZza3, zzfyeVar, zzfxzVar.zzh));
    }

    @Override // com.google.android.gms.internal.ads.zzgat
    public final zzgab zza() {
        return (zzgab) this.zze.zzb();
    }

    final /* synthetic */ zzfxz zzb() {
        return this.zzf;
    }

    final /* synthetic */ zzfyf zzc() {
        return this.zzg;
    }
}
