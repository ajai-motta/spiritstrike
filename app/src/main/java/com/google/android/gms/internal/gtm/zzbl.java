package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbl implements Runnable {
    final /* synthetic */ zzek zza;
    final /* synthetic */ zzbp zzb;

    zzbl(zzbp zzbpVar, zzek zzekVar) {
        this.zza = zzekVar;
        this.zzb = zzbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzb.zza.zzj(this.zza);
    }
}
