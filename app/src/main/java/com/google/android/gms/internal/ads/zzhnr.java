package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhnr {
    public static final /* synthetic */ int zza = 0;
    private static final zzhfp zzb = zzhfp.zzd(zzhnp.zza, zzhnm.class, zzgwl.class);
    private static final zzhfp zzc = zzhfp.zzd(zzhnq.zza, zzhns.class, zzgwm.class);
    private static final zzgwk zzd = zzhef.zzf("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey", zzgwl.class, zzhkk.zzg());
    private static final zzgvu zze = zzhef.zze("type.googleapis.com/google.crypto.tink.Ed25519PublicKey", zzgwm.class, zzhkw.ASYMMETRIC_PUBLIC, zzhkm.zzg());
    private static final zzhet zzf = zzhno.zza;
    private static final zzheq zzg = zzhnn.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        int i = zzhqh.zza;
        zzhqh.zza(zzhfb.zza());
        zzhex zzhexVarZza = zzhex.zza();
        HashMap map = new HashMap();
        map.put("ED25519", zzhnl.zzb(zzhnk.zza));
        zzhnk zzhnkVar = zzhnk.zzd;
        map.put("ED25519_RAW", zzhnl.zzb(zzhnkVar));
        map.put("ED25519WithRawOutput", zzhnl.zzb(zzhnkVar));
        zzhexVarZza.zzd(Collections.unmodifiableMap(map));
        zzhes.zza().zzb(zzg, zzhnl.class);
        zzheu.zza().zzb(zzf, zzhnl.class);
        zzhey.zza().zzb(zzb);
        zzhey.zza().zzb(zzc);
        zzhdw.zza().zzb(zzd, true);
        zzhdw.zza().zzb(zze, false);
    }
}
