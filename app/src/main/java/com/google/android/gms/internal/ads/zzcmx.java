package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcmx implements zzifh {
    private final zzifq zza;

    private zzcmx(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcmx zza(zzifq zzifqVar) {
        return new zzcmx(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.util.zzbl(((zzcjv) this.zza).zza());
    }
}
