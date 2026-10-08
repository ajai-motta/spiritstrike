package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdep implements zzifh {
    private final zzdeo zza;
    private final zzifq zzb;

    private zzdep(zzdeo zzdeoVar, zzifq zzifqVar) {
        this.zza = zzdeoVar;
        this.zzb = zzifqVar;
    }

    public static zzdep zza(zzdeo zzdeoVar, zzifq zzifqVar) {
        return new zzdep(zzdeoVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcyq zzcyqVarZzp = this.zza.zzp(((zzift) this.zzb).zzb());
        zzifp.zzb(zzcyqVarZzp);
        return zzcyqVarZzp;
    }
}
