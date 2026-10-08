package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbi implements Runnable {
    final /* synthetic */ zzbp zza;

    zzbi(zzbp zzbpVar, boolean z) {
        this.zza = zzbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzad();
    }
}
