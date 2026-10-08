package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcdt implements Runnable {
    private final zzcdf zza;
    private boolean zzb = false;

    zzcdt(zzcdf zzcdfVar) {
        this.zza = zzcdfVar;
    }

    private final void zzc() {
        zzfuz zzfuzVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzfuzVar.removeCallbacks(this);
        zzfuzVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzF();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzF();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
