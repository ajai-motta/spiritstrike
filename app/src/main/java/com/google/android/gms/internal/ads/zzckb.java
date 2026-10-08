package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzckb implements zzifh {
    private final zzifq zza;

    private zzckb(zzcjp zzcjpVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzckb zzc(zzcjp zzcjpVar, zzifq zzifqVar) {
        return new zzckb(zzcjpVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        return zzfhj.zza(((zzcjv) this.zza).zza()).zze();
    }
}
