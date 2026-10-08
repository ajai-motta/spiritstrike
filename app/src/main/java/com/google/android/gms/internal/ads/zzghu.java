package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzghu implements zzght {
    private final zzifb zza;
    private final zzgjd zzb;
    private final long zzc;

    zzghu(zzifb zzifbVar, zzgjd zzgjdVar, zzfxa zzfxaVar, long j) {
        this.zza = zzifbVar;
        this.zzb = zzgjdVar;
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zza(zzgaa zzgaaVar) {
        if (zzgaaVar == null || zzgaaVar.equals(zzgaa.zze())) {
            this.zzb.zzb(15104);
            return true;
        }
        if (zzgaaVar.zzc() != this.zza.zzb()) {
            this.zzb.zzb(15105);
            return true;
        }
        boolean z = (zzgaaVar.zza().zzc() * 1000) - System.currentTimeMillis() <= this.zzc;
        if (z) {
            this.zzb.zzb(15106);
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zzb(zzgaa zzgaaVar) {
        if (zzgaaVar == null || zzgaaVar.equals(zzgaa.zze())) {
            this.zzb.zzb(15102);
            return false;
        }
        if (zzgaaVar.zzc() == this.zza.zzb()) {
            return true;
        }
        this.zzb.zzb(15103);
        return false;
    }
}
