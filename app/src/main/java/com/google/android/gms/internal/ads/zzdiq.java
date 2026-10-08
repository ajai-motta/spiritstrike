package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdiq implements zzifh {
    private final zzifq zza;

    private zzdiq(zzdia zzdiaVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdiq zza(zzdia zzdiaVar, zzifq zzifqVar) {
        return new zzdiq(zzdiaVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgn((zzcxn) this.zza.zzb(), zzcbv.zzf);
    }
}
