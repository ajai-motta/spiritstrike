package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeej implements zzifh {
    private final zzifq zza;

    private zzeej(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzeej zzc(zzifq zzifqVar) {
        return new zzeej(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeei zzb() {
        return new zzeei(((zzcks) this.zza).zzb());
    }
}
