package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcrt implements zzifh {
    private final zzcrn zza;
    private final zzifq zzb;

    private zzcrt(zzcrn zzcrnVar, zzifq zzifqVar) {
        this.zza = zzcrnVar;
        this.zzb = zzifqVar;
    }

    public static zzcrt zzc(zzcrn zzcrnVar, zzifq zzifqVar) {
        return new zzcrt(zzcrnVar, zzifqVar);
    }

    public static zzcrg zzd(zzcrn zzcrnVar, Object obj) {
        return (zzcrj) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcrg zzb() {
        return ((zzcrk) this.zzb).zzb();
    }
}
