package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhap {
    public static final /* synthetic */ int zza = 0;
    private static final zzhfp zzb = zzhfp.zzd(zzhao.zza, zzhal.class, zzgvm.class);
    private static final zzgvu zzc = zzhef.zze("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzgvm.class, zzhkw.SYMMETRIC, zzhmt.zze());
    private static final zzhet zzd = zzham.zza;
    private static final zzheq zze = zzhan.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i = zzhcr.zza;
        zzhcr.zza(zzhfb.zza());
        zzhey.zza().zzb(zzb);
        zzhex zzhexVarZza = zzhex.zza();
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", zzhar.zzb(zzhaq.zza));
        map.put("XCHACHA20_POLY1305_RAW", zzhar.zzb(zzhaq.zzc));
        zzhexVarZza.zzd(Collections.unmodifiableMap(map));
        zzhes.zza().zzb(zze, zzhar.class);
        zzheu.zza().zzb(zzd, zzhar.class);
        zzhdw.zza().zzb(zzc, true);
    }
}
