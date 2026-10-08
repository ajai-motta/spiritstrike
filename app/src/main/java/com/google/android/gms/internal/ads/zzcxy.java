package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcxy implements zzifh {
    private final zzcxx zza;
    private final zzifq zzb;

    private zzcxy(zzcxx zzcxxVar, zzifq zzifqVar) {
        this.zza = zzcxxVar;
        this.zzb = zzifqVar;
    }

    public static zzcxy zza(zzcxx zzcxxVar, zzifq zzifqVar) {
        return new zzcxy(zzcxxVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzg((String) this.zzb.zzb());
    }
}
