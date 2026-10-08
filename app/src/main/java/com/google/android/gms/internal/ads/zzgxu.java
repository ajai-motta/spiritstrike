package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxu {
    public static final /* synthetic */ int zza = 0;
    private static final zzhfp zzb = zzhfp.zzd(zzgxs.zza, zzgxr.class, zzgvm.class);
    private static final zzgvu zzc = zzhef.zze("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgvm.class, zzhkw.SYMMETRIC, zzhjh.zzg());
    private static final zzheq zzd = zzgxt.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        int i = zzhbb.zza;
        zzhbb.zza(zzhfb.zza());
        zzhey.zza().zzb(zzb);
        zzhex zzhexVarZza = zzhex.zza();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzhae.zzc);
        zzgxv zzgxvVar = new zzgxv(null);
        zzgxvVar.zzb(16);
        zzgxvVar.zza(16);
        zzgxvVar.zzc(16);
        zzgxw zzgxwVar = zzgxw.zzc;
        zzgxvVar.zzd(zzgxwVar);
        map.put("AES128_EAX_RAW", zzgxvVar.zze());
        map.put("AES256_EAX", zzhae.zzd);
        zzgxv zzgxvVar2 = new zzgxv(null);
        zzgxvVar2.zzb(16);
        zzgxvVar2.zza(32);
        zzgxvVar2.zzc(16);
        zzgxvVar2.zzd(zzgxwVar);
        map.put("AES256_EAX_RAW", zzgxvVar2.zze());
        zzhexVarZza.zzd(Collections.unmodifiableMap(map));
        zzhes.zza().zzb(zzd, zzgxx.class);
        zzhdw.zza().zzb(zzc, true);
    }
}
