package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbn implements Runnable {
    final /* synthetic */ zzcy zza;
    final /* synthetic */ zzbp zzb;

    zzbn(zzbp zzbpVar, zzcy zzcyVar) {
        this.zza = zzcyVar;
        this.zzb = zzbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzf(this.zza);
    }
}
