package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcu implements Runnable {
    final /* synthetic */ zzcv zza;

    zzcu(zzcv zzcvVar) {
        this.zza = zzcvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zza.zzb.zzd().zzi(this);
            return;
        }
        zzcv zzcvVar = this.zza;
        boolean zZzh = zzcvVar.zzh();
        zzcvVar.zzd = 0L;
        if (zZzh) {
            this.zza.zza();
        }
    }
}
