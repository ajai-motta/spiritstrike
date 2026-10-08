package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdbt implements zzifh {
    private final zzifq zza;

    private zzdbt(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdbt zzc(zzifq zzifqVar) {
        return new zzdbt(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdbs zzb() {
        return new zzdbs(((zzift) this.zza).zzb());
    }
}
