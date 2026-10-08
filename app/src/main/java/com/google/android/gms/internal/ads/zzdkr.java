package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdkr implements zzifh {
    private final zzdkm zza;

    private zzdkr(zzdkm zzdkmVar) {
        this.zza = zzdkmVar;
    }

    public static zzdkr zzc(zzdkm zzdkmVar) {
        return new zzdkr(zzdkmVar);
    }

    public static zzdqt zzd(zzdkm zzdkmVar) {
        zzdqt zzdqtVarZzd = zzdkmVar.zzd();
        zzifp.zzb(zzdqtVarZzd);
        return zzdqtVarZzd;
    }

    public final zzdqt zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
