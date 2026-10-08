package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhai {
    private static final zzheq zza = zzhah.zza;
    private static final zzhfp zzb = zzhfp.zzd(zzhag.zza, zzhaf.class, zzgvm.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzhcl.zza;
        zzhcl.zza(zzhfb.zza());
        zzhex zzhexVarZza = zzhex.zza();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzhae.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzhae.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzhae.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzhae.zzj);
        zzhexVarZza.zzd(Collections.unmodifiableMap(map));
        zzhey.zza().zzb(zzb);
        zzhes.zza().zzb(zza, zzhak.class);
    }
}
