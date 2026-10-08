package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzum implements zzus, zzur {
    public final zzuu zza;
    private final long zzb;
    private final zzyv zzc;
    private zzuw zzd;
    private zzus zze;
    private zzur zzf;
    private long zzg = C.TIME_UNSET;

    public zzum(zzuu zzuuVar, zzyv zzyvVar, long j) {
        this.zza = zzuuVar;
        this.zzc = zzyvVar;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzg;
        return j2 != C.TIME_UNSET ? j2 : j;
    }

    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzf = zzurVar;
        zzus zzusVar = this.zze;
        if (zzusVar != null) {
            zzusVar.zzb(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        zzus zzusVar = this.zze;
        if (zzusVar != null) {
            zzusVar.zzc();
            return;
        }
        zzuw zzuwVar = this.zzd;
        if (zzuwVar != null) {
            zzuwVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        long j2 = this.zzg;
        long j3 = (j2 == C.TIME_UNSET || j != this.zzb) ? j : j2;
        this.zzg = C.TIME_UNSET;
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zze(zzykVarArr, zArr, zzwkVarArr, zArr2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z) {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        zzusVar.zzf(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        zzusVar.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zzj(j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zzk(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        zzus zzusVar = this.zze;
        String str = zzep.zza;
        return zzusVar.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        zzus zzusVar = this.zze;
        return zzusVar != null && zzusVar.zzm(zzknVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        zzus zzusVar = this.zze;
        return zzusVar != null && zzusVar.zzn();
    }

    public final void zzo(long j) {
        this.zzg = j;
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        zzur zzurVar = this.zzf;
        String str = zzep.zza;
        zzurVar.zzp(this);
    }

    public final long zzq() {
        return this.zzg;
    }

    public final void zzr(zzuw zzuwVar) {
        zzgmd.zzh(this.zzd == null);
        this.zzd = zzuwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        zzur zzurVar = this.zzf;
        String str = zzep.zza;
        zzurVar.zzs(this);
    }

    public final void zzt(zzuu zzuuVar) {
        long jZzv = zzv(this.zzb);
        zzuw zzuwVar = this.zzd;
        zzuwVar.getClass();
        zzus zzusVarZzG = zzuwVar.zzG(zzuuVar, this.zzc, jZzv);
        this.zze = zzusVarZzG;
        if (this.zzf != null) {
            zzusVarZzG.zzb(this, jZzv);
        }
    }

    public final void zzu() {
        zzus zzusVar = this.zze;
        if (zzusVar != null) {
            zzuw zzuwVar = this.zzd;
            zzuwVar.getClass();
            zzuwVar.zzD(zzusVar);
        }
    }
}
