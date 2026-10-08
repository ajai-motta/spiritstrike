package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbj implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzbp zzc;

    zzbj(zzbp zzbpVar, String str, Runnable runnable) {
        this.zza = str;
        this.zzb = runnable;
        this.zzc = zzbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzc.zza.zzn(this.zza);
        this.zzb.run();
    }
}
