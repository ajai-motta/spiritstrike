package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxl {
    public static final /* synthetic */ int zza = 0;
    private static final zzhfp zzb = zzhfp.zzd(zzgxk.zza, zzgxh.class, zzgvm.class);
    private static final zzgvu zzc = zzhef.zze("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzgvm.class, zzhkw.SYMMETRIC, zzhix.zzg());
    private static final zzhet zzd = zzgxj.zza;
    private static final zzheq zze = zzgxi.zza;
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (!zzhcy.zza(i)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzhaw.zza;
        zzhaw.zza(zzhfb.zza());
        zzhey.zza().zzb(zzb);
        zzhex zzhexVarZza = zzhex.zza();
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzhae.zze);
        zzgxm zzgxmVar = new zzgxm(null);
        zzgxmVar.zza(16);
        zzgxmVar.zzb(32);
        zzgxmVar.zzd(16);
        zzgxmVar.zzc(16);
        zzgxn zzgxnVar = zzgxn.zzc;
        zzgxmVar.zzf(zzgxnVar);
        zzgxo zzgxoVar = zzgxo.zzc;
        zzgxmVar.zze(zzgxoVar);
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzgxmVar.zzg());
        map.put("AES256_CTR_HMAC_SHA256", zzhae.zzf);
        zzgxm zzgxmVar2 = new zzgxm(null);
        zzgxmVar2.zza(32);
        zzgxmVar2.zzb(32);
        zzgxmVar2.zzd(32);
        zzgxmVar2.zzc(16);
        zzgxmVar2.zzf(zzgxnVar);
        zzgxmVar2.zze(zzgxoVar);
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzgxmVar2.zzg());
        zzhexVarZza.zzd(Collections.unmodifiableMap(map));
        zzheu.zza().zzb(zzd, zzgxp.class);
        zzhes.zza().zzb(zze, zzgxp.class);
        zzhdw.zza().zzf(zzc, i, true);
    }
}
