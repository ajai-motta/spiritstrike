package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcui implements zzifh {
    private final zzcue zza;

    private zzcui(zzcue zzcueVar) {
        this.zza = zzcueVar;
    }

    public static zzcui zzc(zzcue zzcueVar) {
        return new zzcui(zzcueVar);
    }

    public static zzfgf zzd(zzcue zzcueVar) {
        zzfgf zzfgfVarZza = zzcueVar.zza();
        zzifp.zzb(zzfgfVarZza);
        return zzfgfVarZza;
    }

    public final zzfgf zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
