package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzqr {
    private final zzcg[] zza;
    private final zzrn zzb;
    private final zzcj zzc;

    public zzqr(zzcg... zzcgVarArr) {
        zzrn zzrnVar = new zzrn();
        zzcj zzcjVar = new zzcj();
        zzcg[] zzcgVarArr2 = {zzrnVar, zzcjVar};
        this.zza = zzcgVarArr2;
        System.arraycopy(zzcgVarArr, 0, zzcgVarArr2, 0, 0);
        this.zzb = zzrnVar;
        this.zzc = zzcjVar;
    }

    public final zzcg[] zza() {
        return this.zza;
    }

    public final zzav zzb(zzav zzavVar) {
        zzcj zzcjVar = this.zzc;
        zzcjVar.zzk(zzavVar.zzb);
        zzcjVar.zzl(zzavVar.zzc);
        return zzavVar;
    }

    public final boolean zzc(boolean z) {
        this.zzb.zzq(z);
        return z;
    }

    public final long zzd(long j) {
        zzcj zzcjVar = this.zzc;
        return zzcjVar.zzc() ? zzcjVar.zzm(j) : j;
    }

    public final long zze() {
        return this.zzb.zzr();
    }
}
