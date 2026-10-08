package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfai implements zzifh {
    private final zzfaf zza;

    private zzfai(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfai zzc(zzfaf zzfafVar) {
        return new zzfai(zzfafVar);
    }

    public static boolean zzd(zzfaf zzfafVar) {
        return zzfafVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzh());
    }
}
