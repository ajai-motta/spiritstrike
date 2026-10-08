package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzz {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzag zzb;
    private Long zzc;

    zzz(zzag zzagVar, boolean z) {
        this.zza = z;
        this.zzb = zzagVar;
    }

    public final boolean zza(Container container) {
        if (!this.zza) {
            return !container.isDefault();
        }
        long lastRefreshTime = container.getLastRefreshTime();
        if (this.zzc == null) {
            this.zzc = Long.valueOf(this.zzb.zzi.zza());
        }
        return lastRefreshTime + this.zzc.longValue() >= this.zzb.zza.currentTimeMillis();
    }
}
