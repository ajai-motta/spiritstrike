package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewk implements zzifh {
    private final zzifq zza;

    private zzewk(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar2;
    }

    public static zzewk zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzewk(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzewi zzb() {
        return new zzewi(zzfjn.zzc(), (zzdwl) this.zza.zzb());
    }
}
