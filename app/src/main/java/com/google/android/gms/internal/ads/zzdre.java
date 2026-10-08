package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdre implements zzifh {
    private final zzifq zza;

    private zzdre(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdre zzc(zzifq zzifqVar) {
        return new zzdre(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdrd zzb() {
        return new zzdrd(((zzdmi) this.zza).zza());
    }
}
