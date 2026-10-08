package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcmw implements zzifh {
    private final zzifq zza;

    private zzcmw(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcmw zza(zzifq zzifqVar) {
        return new zzcmw(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfsc(((zzcjv) this.zza).zza(), com.google.android.gms.ads.internal.zzt.zzs().zza());
    }
}
