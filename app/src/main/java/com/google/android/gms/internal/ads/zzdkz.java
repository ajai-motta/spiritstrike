package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdkz implements zzifh {
    private final zzifq zza;

    private zzdkz(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdkz zzc(zzifq zzifqVar) {
        return new zzdkz(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdky zzb() {
        return new zzdky(((zzdmi) this.zza).zza());
    }
}
