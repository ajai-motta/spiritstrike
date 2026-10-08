package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclm implements zzdws {
    private final zzckz zza;
    private final zzclp zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzclm(zzckz zzckzVar, zzclp zzclpVar, byte[] bArr) {
        this.zza = zzckzVar;
        this.zzb = zzclpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final zzdwt zza() {
        zzifp.zzc(this.zzc, Long.class);
        zzifp.zzc(this.zzd, String.class);
        return new zzcln(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final /* bridge */ /* synthetic */ zzdws zzc(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    public final /* bridge */ /* synthetic */ zzdws zzb(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }
}
