package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhwl implements zzhwc {
    final int zza;
    final zzhzp zzb;
    final boolean zzc;
    final boolean zzd;

    zzhwl(zzhwt zzhwtVar, int i, zzhzp zzhzpVar, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzhzpVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zzhwl) obj).zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final zzhzp zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final zzhzq zzc() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final boolean zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhwc
    public final boolean zze() {
        return this.zzd;
    }
}
