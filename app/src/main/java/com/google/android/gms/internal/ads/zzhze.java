package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhze extends zzhzc {
    zzhze() {
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* bridge */ /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzhzd) obj).zzk(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* bridge */ /* synthetic */ void zzb(Object obj, int i, int i2) {
        ((zzhzd) obj).zzk((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* bridge */ /* synthetic */ void zzc(Object obj, int i, long j) {
        ((zzhzd) obj).zzk((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i, zzhvi zzhviVar) {
        ((zzhzd) obj).zzk((i << 3) | 2, zzhviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, Object obj2) {
        ((zzhzd) obj).zzk((i << 3) | 3, (zzhzd) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* synthetic */ Object zzf() {
        return zzhzd.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* synthetic */ Object zzg(Object obj) {
        zzhzd zzhzdVar = (zzhzd) obj;
        zzhzdVar.zzd();
        return zzhzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzhwo zzhwoVar = (zzhwo) obj;
        zzhzd zzhzdVar = zzhwoVar.zzt;
        if (zzhzdVar != zzhzd.zza()) {
            return zzhzdVar;
        }
        zzhzd zzhzdVarZzb = zzhzd.zzb();
        zzhwoVar.zzt = zzhzdVarZzb;
        return zzhzdVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzhwo) obj).zzt = (zzhzd) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    final void zzj(Object obj) {
        ((zzhwo) obj).zzt.zzd();
    }
}
