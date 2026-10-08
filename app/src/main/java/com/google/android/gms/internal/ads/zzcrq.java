package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcrq implements zzifh {
    private final zzcrn zza;

    private zzcrq(zzcrn zzcrnVar) {
        this.zza = zzcrnVar;
    }

    public static zzcrq zzc(zzcrn zzcrnVar) {
        return new zzcrq(zzcrnVar);
    }

    public static zzffv zzd(zzcrn zzcrnVar) {
        zzffv zzffvVarZzd = zzcrnVar.zzd();
        zzifp.zzb(zzffvVarZzd);
        return zzffvVarZzd;
    }

    public final zzffv zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
