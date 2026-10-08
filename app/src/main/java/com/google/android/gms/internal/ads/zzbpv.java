package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbpv extends zzcch {
    private final Object zza = new Object();
    private final zzbqa zzb;
    private boolean zzc;

    public zzbpv(zzbqa zzbqaVar) {
        this.zzb = zzbqaVar;
    }

    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("release: Lock acquired");
            if (this.zzc) {
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zze(new zzbps(this), new zzccd());
            zze(new zzbpt(this), new zzbpu(this));
            com.google.android.gms.ads.internal.util.zze.zza("release: Lock released");
        }
    }

    final /* synthetic */ zzbqa zzb() {
        return this.zzb;
    }
}
