package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzblb implements zzguf {
    final /* synthetic */ zzcgy zza;

    zzblb(zzcgy zzcgyVar) {
        this.zza = zzcgyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcgy zzcgyVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbt(zzcgyVar.getContext(), zzcgyVar.zzs().afmaVersion, str, null, zzcgyVar.zzC() != null ? zzcgyVar.zzC().zzax : null).zzb();
    }
}
