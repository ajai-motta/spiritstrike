package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcyf implements zzifh {
    private final zzcxx zza;

    private zzcyf(zzcxx zzcxxVar) {
        this.zza = zzcxxVar;
    }

    public static zzcyf zzc(zzcxx zzcxxVar) {
        return new zzcyf(zzcxxVar);
    }

    public static zzfgn zzd(zzcxx zzcxxVar) {
        zzfgn zzfgnVarZzb = zzcxxVar.zzb();
        zzifp.zzb(zzfgnVarZzb);
        return zzfgnVarZzb;
    }

    public final zzfgn zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
