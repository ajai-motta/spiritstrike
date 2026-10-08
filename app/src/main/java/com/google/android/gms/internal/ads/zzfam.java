package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfam implements zzifh {
    private final zzfaf zza;

    private zzfam(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfam zzc(zzfaf zzfafVar) {
        return new zzfam(zzfafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zzj());
    }
}
