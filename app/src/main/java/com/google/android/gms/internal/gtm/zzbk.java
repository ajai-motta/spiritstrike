package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbk implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbp zzb;

    zzbk(zzbp zzbpVar, int i) {
        this.zza = i;
        this.zzb = zzbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzY(((long) this.zza) * 1000);
    }
}
