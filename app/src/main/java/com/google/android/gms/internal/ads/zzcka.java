package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcka implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcka(zzcjp zzcjpVar, zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcka zza(zzcjp zzcjpVar, zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcka(zzcjpVar, zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdm)).booleanValue() ? new zzaxa((zzawv) this.zzb.zzb()) : new zzaxa((zzawv) this.zza.zzb());
    }
}
