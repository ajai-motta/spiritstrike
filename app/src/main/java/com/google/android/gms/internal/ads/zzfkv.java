package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfkv implements zzifh {
    private final zzifq zza;

    private zzfkv(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfkv zzc(zzifq zzifqVar) {
        return new zzfkv(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfkr zzb() {
        return new zzfkr(((zzift) this.zza).zzb());
    }
}
