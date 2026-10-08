package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzby implements Runnable {
    final /* synthetic */ zzca zza;
    final /* synthetic */ zzel zzb;

    zzby(zzca zzcaVar, zzel zzelVar) {
        this.zzb = zzelVar;
        this.zza = zzcaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.zza.zzg()) {
            return;
        }
        this.zza.zza.zzE("Connected to service after a timeout");
        zzca zzcaVar = this.zza;
        zzcb.zzi(zzcaVar.zza, this.zzb);
    }
}
