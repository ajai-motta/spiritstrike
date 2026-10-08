package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclx implements zzedh {
    private final zzckz zza;
    private final zzclw zzb;
    private zzebo zzc;

    /* synthetic */ zzclx(zzckz zzckzVar, zzclw zzclwVar, byte[] bArr) {
        this.zza = zzckzVar;
        this.zzb = zzclwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedh
    public final zzedi zza() {
        zzifp.zzc(this.zzc, zzebo.class);
        return new zzcly(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzedh
    public final /* bridge */ /* synthetic */ zzedh zzb(zzebo zzeboVar) {
        this.zzc = zzeboVar;
        return this;
    }
}
