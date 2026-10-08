package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzjt implements zzkt {
    private final Object zza;
    private zzbf zzb;

    public zzjt(Object obj, zzup zzupVar) {
        this.zza = obj;
        this.zzb = zzupVar.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkt
    public final zzbf zzb() {
        return this.zzb;
    }

    public final void zzc(zzbf zzbfVar) {
        this.zzb = zzbfVar;
    }
}
