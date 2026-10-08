package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcuf implements zzifh {
    private final zzcue zza;

    private zzcuf(zzcue zzcueVar) {
        this.zza = zzcueVar;
    }

    public static zzcuf zzc(zzcue zzcueVar) {
        return new zzcuf(zzcueVar);
    }

    public static zzffu zzd(zzcue zzcueVar) {
        zzffu zzffuVarZzb = zzcueVar.zzb();
        zzifp.zzb(zzffuVarZzb);
        return zzffuVarZzb;
    }

    public final zzffu zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
