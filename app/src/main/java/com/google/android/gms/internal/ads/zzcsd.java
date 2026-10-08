package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcsd implements zzifh {
    private final zzifq zza;

    private zzcsd(zzcrn zzcrnVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcsd zza(zzcrn zzcrnVar, zzifq zzifqVar) {
        return new zzcsd(zzcrnVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzdbp zzdbpVarZza = ((zzctj) this.zza).zza();
        return new zzdgn(new zzddl() { // from class: com.google.android.gms.internal.ads.zzcrl
            @Override // com.google.android.gms.internal.ads.zzddl
            public final /* synthetic */ void zza() {
                zzdbpVarZza.zzc();
            }
        }, zzcbv.zzg);
    }
}
