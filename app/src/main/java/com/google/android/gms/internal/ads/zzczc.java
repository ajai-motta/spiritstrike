package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzczc implements zzifh {
    private final zzifq zza;

    private zzczc(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzczc zzc(zzifq zzifqVar) {
        return new zzczc(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcyx zzb() {
        return new zzcyx(((zzift) this.zza).zzb());
    }
}
