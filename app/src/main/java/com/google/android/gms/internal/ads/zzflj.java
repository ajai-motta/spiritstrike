package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzflj implements zzguf {
    final /* synthetic */ zzflm zza;
    final /* synthetic */ zzflc zzb;

    zzflj(zzflm zzflmVar, zzflc zzflcVar) {
        this.zza = zzflmVar;
        this.zzb = zzflcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflc zzflcVar = this.zzb;
        zzflcVar.zzj(th);
        zzflcVar.zzd(false);
        this.zza.zza(zzflcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
    }
}
