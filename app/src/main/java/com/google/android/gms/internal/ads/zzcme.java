package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcme implements com.google.android.gms.ads.nonagon.signalgeneration.zzab {
    private final zzckz zza;
    private zzcxx zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzay zzc;

    /* synthetic */ zzcme(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzac zza() {
        zzifp.zzc(this.zzb, zzcxx.class);
        zzifp.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzay.class);
        return new zzcmf(this.zza, this.zzc, new zzcuu(), new zzcwv(), new zzdvx(), this.zzb, null, null);
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzay zzayVar) {
        this.zzc = zzayVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab zzc(zzcxx zzcxxVar) {
        this.zzb = zzcxxVar;
        return this;
    }
}
