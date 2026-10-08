package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevf implements zzexy {
    private final boolean zza;

    public zzevf(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ((zzcxq) obj).zza.putBoolean("is_gbid", this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcxq) obj).zzb.putBoolean("is_gbid", this.zza);
    }
}
