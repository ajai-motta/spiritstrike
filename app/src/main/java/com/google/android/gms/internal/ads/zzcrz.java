package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcrz implements zzifh {
    private final zzcrn zza;
    private final zzifq zzb;

    private zzcrz(zzcrn zzcrnVar, zzifq zzifqVar) {
        this.zza = zzcrnVar;
        this.zzb = zzifqVar;
    }

    public static zzcrz zza(zzcrn zzcrnVar, zzifq zzifqVar) {
        return new zzcrz(zzcrnVar, zzifqVar);
    }

    public static zzdgn zzc(zzcrn zzcrnVar, zzctb zzctbVar) {
        return new zzdgn(zzctbVar, zzcbv.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzctb) this.zzb.zzb());
    }
}
