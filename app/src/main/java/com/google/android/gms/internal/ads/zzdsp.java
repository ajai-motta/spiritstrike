package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdsp implements zzifh {
    private final zzifq zza;

    private zzdsp(zzdso zzdsoVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdsp zza(zzdso zzdsoVar, zzifq zzifqVar) {
        return new zzdsp(zzdsoVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgn(((zzdsn) this.zza).zzb(), zzcbv.zzf);
    }
}
