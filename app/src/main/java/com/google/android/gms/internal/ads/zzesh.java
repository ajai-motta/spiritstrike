package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzesh implements zzifh {
    private final zzifq zza;

    private zzesh(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar2;
    }

    public static zzesh zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzesh(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzesf zzb() {
        return new zzesf(zzfjn.zzc(), ((zzcjv) this.zza).zza());
    }
}
