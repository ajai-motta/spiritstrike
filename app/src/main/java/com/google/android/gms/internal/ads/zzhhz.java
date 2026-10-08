package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhhz implements zzhgs {
    private zzhhz(zzhgk zzhgkVar, Provider provider) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzhgkVar.zze().zzc();
            zzhgkVar.zzf();
            new SecretKeySpec(zzhgkVar.zzd().zzc(zzgvr.zza()), "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new GeneralSecurityException("AES-CMAC not available.", e);
        }
    }

    public static zzhgs zza(zzhgk zzhgkVar, Provider provider) throws GeneralSecurityException {
        return new zzhhz(zzhgkVar, provider);
    }
}
