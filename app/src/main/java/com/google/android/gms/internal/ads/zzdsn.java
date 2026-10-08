package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdsn implements zzifh {
    private final zzifq zza;

    private zzdsn(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdsn zzc(zzifq zzifqVar) {
        return new zzdsn(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdsm zzb() {
        return new zzdsm((zzcgy) this.zza.zzb());
    }
}
