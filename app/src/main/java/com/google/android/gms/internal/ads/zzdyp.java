package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdyp implements zzifh {
    private final zzifq zza;

    private zzdyp(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdyp zza(zzifq zzifqVar) {
        return new zzdyp(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdya(((zzcjv) this.zza).zza());
    }
}
