package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfal implements zzifh {
    private final zzfaf zza;

    private zzfal(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfal zzc(zzfaf zzfafVar) {
        return new zzfal(zzfafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zzi());
    }
}
