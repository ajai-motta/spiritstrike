package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbz implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzca zzb;

    zzbz(zzca zzcaVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zzcaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcb.zzb(this.zzb.zza, this.zza);
    }
}
