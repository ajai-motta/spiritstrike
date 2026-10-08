package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcsc implements zzifh {
    private final zzifq zza;

    private zzcsc(zzcrn zzcrnVar, zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
    }

    public static zzcsc zza(zzcrn zzcrnVar, zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcsc(zzcrnVar, zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgn((zzctk) this.zza.zzb(), zzfjn.zzc());
    }
}
