package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzept implements zzifh {
    private final zzifq zza;

    private zzept(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzept zzc(zzifq zzifqVar) {
        return new zzept(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzepr zzb() {
        return new zzepr(((zzcjv) this.zza).zza());
    }
}
