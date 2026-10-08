package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzav implements Runnable {
    final /* synthetic */ zzar zza;
    final /* synthetic */ zzaz zzb;

    zzav(zzaz zzazVar, zzar zzarVar) {
        this.zza = zzarVar;
        this.zzb = zzazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(zzaz.zzf(this.zzb));
    }
}
