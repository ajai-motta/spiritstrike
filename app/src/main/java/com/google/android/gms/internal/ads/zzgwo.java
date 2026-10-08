package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgwo {
    public static zzgwe zza(String str) throws GeneralSecurityException {
        try {
            try {
                try {
                    zzhlg zzhlgVarZze = zzhlg.zze(zzgvs.zza(str).zzb().zzaN(), zzhvy.zza());
                    for (zzhlf zzhlfVar : zzhlgVarZze.zzb()) {
                        if (zzhlfVar.zzb().zzc() == zzhkw.UNKNOWN_KEYMATERIAL || zzhlfVar.zzb().zzc() == zzhkw.SYMMETRIC || zzhlfVar.zzb().zzc() == zzhkw.ASYMMETRIC_PRIVATE) {
                            throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", zzhlfVar.zzb().zzc().name(), zzhlfVar.zzb().zza()));
                        }
                    }
                    return zzgwe.zza(zzhlgVarZze);
                } catch (zzhxd unused) {
                    throw new GeneralSecurityException("invalid keyset");
                }
            } catch (zzhxd unused2) {
                throw new GeneralSecurityException("invalid keyset");
            }
        } catch (IOException unused3) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }
}
