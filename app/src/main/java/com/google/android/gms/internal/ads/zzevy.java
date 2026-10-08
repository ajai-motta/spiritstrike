package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevy implements zzifh {
    private final zzifq zza;

    private zzevy(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzevy zzc(zzifq zzifqVar) {
        return new zzevy(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzevw zzb() {
        return new zzevw((zzfft) this.zza.zzb());
    }
}
