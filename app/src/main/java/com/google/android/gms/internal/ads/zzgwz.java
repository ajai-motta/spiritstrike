package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgwz {
    public static final /* synthetic */ int zza = 0;
    private static final zzhds zzb = zzb();

    public static zzgvq zza() throws GeneralSecurityException {
        if (zzhcz.zza()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
        }
        return zzb;
    }

    private static zzhds zzb() {
        try {
            zzhfq zzhfqVarZza = zzhft.zza();
            zzgxf.zzd(zzhfqVarZza);
            zzhfqVarZza.zza(zzhfp.zzd(zzgwx.zza, zzgxh.class, zzgvm.class));
            zzhfqVarZza.zza(zzhfp.zzd(zzgwv.zza, zzgxz.class, zzgvm.class));
            zzhfqVarZza.zza(zzhfp.zzd(zzgww.zza, zzgyi.class, zzgvm.class));
            zzhfqVarZza.zza(zzhfp.zzd(zzgwu.zza, zzgxr.class, zzgvm.class));
            zzhfqVarZza.zza(zzhfp.zzd(zzgwt.zza, zzgyq.class, zzgvm.class));
            zzhfqVarZza.zza(zzhfp.zzd(zzgws.zza, zzhal.class, zzgvm.class));
            zzhfqVarZza.zza(zzhfp.zzd(zzgwy.zza, zzhaf.class, zzgvm.class));
            return zzhds.zzb(zzhfqVarZza.zzc());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
