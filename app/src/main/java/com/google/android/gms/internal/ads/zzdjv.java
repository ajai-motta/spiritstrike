package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdjv implements zzifh {
    private final zzdju zza;

    private zzdjv(zzdju zzdjuVar) {
        this.zza = zzdjuVar;
    }

    public static zzdjv zzc(zzdju zzdjuVar) {
        return new zzdjv(zzdjuVar);
    }

    public final com.google.android.gms.ads.internal.client.zzbk zza() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzb();
    }
}
