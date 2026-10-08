package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcox implements zzguf {
    final /* synthetic */ zzfng zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzv zzc;
    final /* synthetic */ zzcpe zzd;

    zzcox(zzcpe zzcpeVar, zzfng zzfngVar, String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = zzfngVar;
        this.zzb = str;
        this.zzc = zzvVar;
        Objects.requireNonNull(zzcpeVar);
        this.zzd = zzcpeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(final Throwable th) {
        final zzfng zzfngVar = this.zza;
        final String str = this.zzb;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        this.zzd.zzj().zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcow
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlp)).booleanValue();
                Throwable th2 = th;
                zzcox zzcoxVar = this.zza;
                if (zBooleanValue) {
                    zzcpe zzcpeVar = zzcoxVar.zzd;
                    zzcpeVar.zzb = zzbwf.zzc(zzcpeVar.zzi());
                    zzcpeVar.zzb.zzh(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzcpe zzcpeVar2 = zzcoxVar.zzd;
                    zzcpeVar2.zza = zzbwf.zza(zzcpeVar2.zzi());
                    zzcpeVar2.zza.zzh(th2, "AttributionReportingSampled.registerSourceAndPingClickUrl");
                }
                com.google.android.gms.ads.internal.util.client.zzv zzvVar2 = zzvVar;
                zzfngVar.zzb(str, zzvVar2, null, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final zzfng zzfngVar = this.zza;
        final String str = (String) obj;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        this.zzd.zzj().zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfngVar.zzb(str, zzvVar, null, null);
            }
        });
    }
}
