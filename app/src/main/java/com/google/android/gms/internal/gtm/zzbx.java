package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbx extends zzcv {
    final /* synthetic */ zzcb zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbx(zzcb zzcbVar, zzbu zzbuVar) {
        super(zzbuVar);
        this.zza = zzcbVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzcv
    public final void zza() {
        com.google.android.gms.analytics.zzr.zzh();
        zzcb zzcbVar = this.zza;
        if (zzcbVar.zzg()) {
            zzcbVar.zzN("Inactivity, disconnecting from device AnalyticsService");
            zzcbVar.zzc();
        }
    }
}
