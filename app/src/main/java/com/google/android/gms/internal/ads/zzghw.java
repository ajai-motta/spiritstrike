package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzghw implements zzght {
    private final zzgjd zza;
    private final long zzb;

    zzghw(zzfxa zzfxaVar, zzgjd zzgjdVar, long j) {
        this.zza = zzgjdVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zza(zzgaa zzgaaVar) {
        if (zzgaaVar == null || zzgaaVar.equals(zzgaa.zze())) {
            this.zza.zzb(20202);
            return true;
        }
        boolean z = zzgaaVar.zzb().zzb() - System.currentTimeMillis() <= this.zzb;
        if (z) {
            this.zza.zzb(20203);
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zzb(zzgaa zzgaaVar) {
        if (zzgaaVar != null && !zzgaaVar.equals(zzgaa.zze())) {
            return true;
        }
        this.zza.zzb(20204);
        return false;
    }
}
