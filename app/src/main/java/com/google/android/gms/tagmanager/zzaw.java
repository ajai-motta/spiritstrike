package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaw implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzaz zzb;

    zzaw(zzaz zzazVar, String str) {
        this.zza = str;
        this.zzb = zzazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaz.zzg(this.zzb, this.zza);
    }
}
