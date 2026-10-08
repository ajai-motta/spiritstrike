package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzhef implements zzgvu {
    final String zza;
    final Class zzb;
    final zzhkw zzc;

    zzhef(String str, Class cls, zzhkw zzhkwVar, zzhyh zzhyhVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzhkwVar;
    }

    public static zzgvu zze(String str, Class cls, zzhkw zzhkwVar, zzhyh zzhyhVar) {
        return new zzhef(str, cls, zzhkwVar, zzhyhVar);
    }

    public static zzgwk zzf(String str, Class cls, zzhyh zzhyhVar) {
        return new zzhee(str, cls, zzhyhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public final Object zza(zzhvi zzhviVar) throws GeneralSecurityException {
        return zzhey.zza().zzd(zzhfb.zza().zzg(zzhfw.zza(this.zza, zzhviVar, this.zzc, zzhlt.RAW, null), zzgvr.zza()), this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public final Class zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgvu
    public final zzhkx zzd(zzhvi zzhviVar) throws GeneralSecurityException {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza(this.zza);
        zzhkzVarZze.zzb(zzhviVar);
        zzhkzVarZze.zzc(zzhlt.RAW);
        zzhfw zzhfwVar = (zzhfw) zzhfb.zza().zzh(zzhes.zza().zzc(zzhfb.zza().zzj(zzhfx.zzb((zzhla) zzhkzVarZze.zzbu())), null), zzhfw.class, zzgvr.zza());
        zzhkv zzhkvVarZzd = zzhkx.zzd();
        zzhkvVarZzd.zza(zzhfwVar.zzg());
        zzhkvVarZzd.zzb(zzhfwVar.zzb());
        zzhkvVarZzd.zzc(zzhfwVar.zzc());
        return (zzhkx) zzhkvVarZzd.zzbu();
    }
}
