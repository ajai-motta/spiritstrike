package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclb implements zzcqt {
    private final zzckz zza;
    private zzfdq zzb;
    private zzfcu zzc;
    private zzdeo zzd;
    private zzcxx zze;

    /* synthetic */ zzclb(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcqu zzh() {
        zzifp.zzc(this.zzd, zzdeo.class);
        zzifp.zzc(this.zze, zzcxx.class);
        return new zzclc(this.zza, new zzcuu(), new zzfht(), new zzcwv(), new zzdvx(), this.zzd, this.zze, zzelg.zza(), null, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final /* synthetic */ zzcqt zzb(zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final /* synthetic */ zzcqt zzc(zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final /* bridge */ /* synthetic */ zzcqt zzd(zzcxx zzcxxVar) {
        this.zze = zzcxxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcqt
    public final /* bridge */ /* synthetic */ zzcqt zze(zzdeo zzdeoVar) {
        this.zzd = zzdeoVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzi(zzfcu zzfcuVar) {
        this.zzc = zzfcuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcxu
    public final /* synthetic */ zzcxu zzj(zzfdq zzfdqVar) {
        this.zzb = zzfdqVar;
        return this;
    }
}
