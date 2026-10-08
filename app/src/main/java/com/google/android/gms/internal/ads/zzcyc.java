package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcyc implements zzifh {
    private final zzifq zza;

    private zzcyc(zzcxx zzcxxVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcyc zzc(zzcxx zzcxxVar, zzifq zzifqVar) {
        return new zzcyc(zzcxxVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String strZzp = ((zzcve) this.zza.zzb()).zzp();
        zzifp.zzb(strZzp);
        return strZzp;
    }
}
