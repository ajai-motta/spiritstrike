package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdjx implements zzifh {
    private final zzdju zza;

    private zzdjx(zzdju zzdjuVar) {
        this.zza = zzdjuVar;
    }

    public static zzdjx zzc(zzdju zzdjuVar) {
        return new zzdjx(zzdjuVar);
    }

    public static zzdma zzd(zzdju zzdjuVar) {
        zzdma zzdmaVarZza = zzdjuVar.zza();
        zzifp.zzb(zzdmaVarZza);
        return zzdmaVarZza;
    }

    public final zzdma zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
