package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdit implements zzifh {
    private final zzifq zza;

    private zzdit(zzdia zzdiaVar, zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
    }

    public static zzdit zza(zzdia zzdiaVar, zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdit(zzdiaVar, zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgn((zzdjq) this.zza.zzb(), zzfjn.zzc());
    }
}
